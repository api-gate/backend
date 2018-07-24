package mx.com.ag.backend.api.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.ag.backend.api.model.dto.AuthenticationRequest;
import mx.com.ag.backend.api.service.AuthenticationService;
import mx.com.ag.exception.AGException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/auth")
@Api(value = "Authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @POST
    @Path("/authenticate")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @ApiOperation(value = "Responde Hola Mundo usando POST", produces = APPLICATION_JSON, response = Response.class, notes = "Descripcion larga")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Peticion Incorrecta"),
            @ApiResponse(code = 404, message = "No existe el recurso solicitado")
    })
    public Response authenticate(AuthenticationRequest authenticationRequest) throws AGException {
        return Response.ok(200)
                .header("tkn", authenticationService.validateUser(authenticationRequest))
                .entity(authenticationRequest)
                .build();
    }

    @Inject
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}