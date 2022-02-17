package com.xtesoft.tienda.clientes;

import com.xtesoft.tienda.clientes.dto.ClienteDTO;
import com.xtesoft.tienda.clientes.dto.UserDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
@RegisterRestClient
public interface TiendaApiService {
    @GET
    @Path("/findByEmailAndPass")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO getSingle(@QueryParam("correoe")String correo,@QueryParam("clave")String clave);

    @GET
    public List<ClienteDTO> getAll();

    @GET
    @Path("{id}")
    public ClienteDTO getSingle(@PathParam("id") Long id);

    @POST
    public Response create(ClienteDTO cliente);

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id);

    @PUT
    @Path("{id}")
    public ClienteDTO update(@PathParam("id") Long id, ClienteDTO cliente);


}
