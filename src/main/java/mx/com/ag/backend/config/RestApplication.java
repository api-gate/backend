package mx.com.ag.backend.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Info;
import io.swagger.models.License;
import mx.com.ag.exception.AGRuntimeException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;

import static mx.com.ag.exception.messages.ExceptionCode.UNIREST_MAPPER_READ_VALUE_NOT_LOADED;

/**
 * @author Alex79L
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

    private static final String VERSION = "1.0.0-SNAPSHOT";

    public RestApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion(VERSION);
        beanConfig.setBasePath("api-gateway-backend/api");
        beanConfig.setResourcePackage("mx.com.ag.backend.api.rest");
        beanConfig.setScan(true);

        final Info info = new Info()
                .title("API-GATEWAY-BACKEND REST API")
                .version(VERSION)
                .description("API-GATEWAY-BACKEND REST API.")
                .license(new License().name("GNU").url("https://www.gnu.org/licenses/gpl.html"));

        beanConfig.setInfo(info);

        //Configuración Unirest.
        initUnirest();
    }

    private void initUnirest() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String s, Class<T> aClass) {
                try {
                    return this.jacksonObjectMapper.readValue(s, aClass);
                } catch (IOException var4) {
                    throw new AGRuntimeException(UNIREST_MAPPER_READ_VALUE_NOT_LOADED, var4);
                }
            }

            public String writeValue(Object o) {
                try {
                    return this.jacksonObjectMapper.writeValueAsString(o);
                } catch (JsonProcessingException var3) {
                    throw new AGRuntimeException(UNIREST_MAPPER_READ_VALUE_NOT_LOADED, var3);
                }
            }
        });
    }

}
