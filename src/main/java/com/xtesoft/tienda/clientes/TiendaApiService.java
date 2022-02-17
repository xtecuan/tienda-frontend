package com.xtesoft.tienda.clientes;

import com.xtesoft.tienda.clientes.dto.ClienteDTO;
import com.xtesoft.tienda.clientes.dto.UserDTO;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("clientes")
public interface TiendaApiService {
    @POST
    @Path("/findByEmailAndPass")
    public ClienteDTO getSingle(UserDTO user);

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
