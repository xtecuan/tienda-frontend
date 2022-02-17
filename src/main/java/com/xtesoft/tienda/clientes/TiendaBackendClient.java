package com.xtesoft.tienda.clientes;

import com.xtesoft.tienda.clientes.dto.ClienteDTO;
import com.xtesoft.tienda.clientes.dto.UserDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;


@ApplicationScoped
public class TiendaBackendClient {
    @Inject
    @ConfigProperty(name = "tienda.backend.baseurl")
    String baseurl;
    @Inject
    @ConfigProperty(name = "tienda.backend.clientes")
    String clientes;

    @Inject
    @RestClient
    AuthClient authClient;

    public ClienteDTO findByEmailAndPass(String correoe,String clave){
        ClienteDTO clienteDTO = null;
        UserDTO user = new UserDTO(correoe,clave);
        clienteDTO = authClient.findByEmailAndPass(user);
        return clienteDTO;
    }
}
