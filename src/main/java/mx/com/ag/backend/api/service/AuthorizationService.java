package mx.com.ag.backend.api.service;

import mx.com.ag.backend.api.client.GenericClient;
import mx.com.ag.backend.api.model.dto.ApiRequest;
import mx.com.ag.exception.AGException;

import javax.ejb.Stateless;

/**
 * @author Alex79L
 */
@Stateless
public class AuthorizationService {

    private static final String URL = "https://invd-pxy-nory-01.invexbt.com/";
    private static final String RESOURCE = "/business-backend/api/";

    public Object invokeService(ApiRequest apiRequest) throws AGException {
        GenericClient client = new GenericClient(URL, RESOURCE);
        return client.postRequest(apiRequest);
    }

}
