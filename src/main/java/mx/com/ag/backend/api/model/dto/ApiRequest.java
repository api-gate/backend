package mx.com.ag.backend.api.model.dto;

import java.util.Map;

/**
 * @author Alejandro Luna
 * Date: 24/07/2018
 */
public class ApiRequest {

    private String resource;
    private Map<String, Object> payload;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
