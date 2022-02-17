package com.xtesoft.tienda.clientes;

import com.xtesoft.tienda.clientes.dto.ClienteDTO;
import com.xtesoft.tienda.clientes.dto.UserDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
@Produces("application/json")
@Consumes("application/json")
@RegisterRestClient
public interface AuthClient {
    @POST
    public ClienteDTO findByEmailAndPass(UserDTO userDTO);
}
