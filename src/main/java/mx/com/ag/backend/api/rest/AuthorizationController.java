package mx.com.ag.backend.api.rest;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.ag.backend.api.model.dto.ApiRequest;
import mx.com.ag.backend.api.model.dto.AuthenticationRequest;
import mx.com.ag.backend.api.service.AuthenticationService;
import mx.com.ag.backend.api.service.AuthorizationService;
import mx.com.ag.backend.util.ValidateToken;
import mx.com.ag.exception.AGException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/authorize")
@Api(value = "Authorization")
public class AuthorizationController {

    private ValidateToken validateToken;
    private AuthorizationService authorizationService;

    @POST
    @Path("/authorize")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @ApiOperation(value = "Responde Hola Mundo usando POST", produces = APPLICATION_JSON, response = Response.class, notes = "Descripcion larga")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Peticion Incorrecta"),
            @ApiResponse(code = 404, message = "No existe el recurso solicitado")
    })
    public Response authorize(ApiRequest apiRequest, @HeaderParam("tkn") String tkn) throws AGException, UnirestException {
        validateToken.validateToken(tkn);
        return Response.ok(200)
                .entity(authorizationService.invokeService(apiRequest))
                .build();
    }

    @Inject
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Inject
    public void setValidateToken(ValidateToken validateToken) {
        this.validateToken = validateToken;
    }
}