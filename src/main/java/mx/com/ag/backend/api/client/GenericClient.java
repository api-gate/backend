package mx.com.ag.backend.api.client;

import com.mashape.unirest.http.HttpMethod;
import mx.com.ag.backend.api.model.dto.ApiRequest;
import mx.com.ag.exception.AGException;
import mx.com.ag.lib.api.client.RestClient;

/**
 * @author Alejandro Luna
 * Date: 24/07/2018
 */
public class GenericClient extends RestClient {

    /**
     * Construye una instancia del cliente de servicios Rest
     *
     * @param serverUrl URL del servidor
     * @param resource  Nombre del recurso levantado por el servicio
     */
    public GenericClient(String serverUrl, String resource) {
        super(serverUrl, resource);
    }

    public String getRequest(ApiRequest request, String endPoint) throws AGException {
        return invokeService(request.getResource(), request.getPayload(), HttpMethod.GET, String.class).getBody();
    }

    public String postRequest(ApiRequest request) throws AGException {
        return invokeService(request.getResource(), request.getPayload(), HttpMethod.POST, String.class).getBody();
    }
}
