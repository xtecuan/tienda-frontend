package com.xtesoft.tienda.clientes;

import com.xtesoft.tienda.clientes.dto.ClienteDTO;
import com.xtesoft.tienda.clientes.dto.UserDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class TiendaBackendClient {
    @ConfigProperty(name = "tienda.backend.baseurl")
    String baseurl;
    private WebTarget webTargetBase;

    @PostConstruct
    void init(){
        webTargetBase = ClientBuilder.newClient().target(baseurl);
    }

    public ClienteDTO findByEmailAndPass(String correoe,String clave){
        UserDTO user = new UserDTO(correoe,clave);
        Invocation.Builder invocationBuilder = webTargetBase.path("clientes").path("findByEmailAndPass").request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(user,MediaType.APPLICATION_JSON));
        if(response.getStatus() == 200){
            return (ClienteDTO) response.getEntity();
        }else{
            return null;
        }
    }
}
