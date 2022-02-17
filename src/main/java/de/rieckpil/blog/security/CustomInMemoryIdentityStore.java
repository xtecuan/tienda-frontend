package de.rieckpil.blog.security;

import com.livejournal.xtecuan.microprofile.entities.Users;
import com.livejournal.xtecuan.microprofile.facade.UsersFacade;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;
import javax.inject.Inject;

import com.xtesoft.tienda.clientes.TiendaBackendClient;
import com.xtesoft.tienda.clientes.dto.ClienteDTO;
import org.apache.log4j.Logger;

@ApplicationScoped
public class CustomInMemoryIdentityStore implements IdentityStore {

    private static final Logger LOGGER = Logger.getLogger(CustomInMemoryIdentityStore.class);

    @Inject
    private TiendaBackendClient tiendaBackendClient;

    @Override
    public CredentialValidationResult validate(Credential credential) {

        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        String email = login.getCaller();
        String password = login.getPasswordAsString();

        getLogger().info("Caller: " + email);
        getLogger().info("blankPassword: " + password);
        //getLogger().info("hashedPassword: " + usersFacade.getMyHashFromH2(password));

        ClienteDTO clienteDTO = tiendaBackendClient.findByEmailAndPass(email, password);

        if (clienteDTO != null) {
            return new CredentialValidationResult(clienteDTO.getCorreoe(), new HashSet<>(Arrays.asList(clienteDTO.getRol())));
        } else {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }

//        if (login.getCaller().equals("admin@mail.com") && login.getPasswordAsString().equals("ADMIN1234")) {
//            return new CredentialValidationResult("admin", new HashSet<>(Arrays.asList("ADMIN")));
//        } else if (login.getCaller().equals("user@mail.com") && login.getPasswordAsString().equals("USER1234")) {
//            return new CredentialValidationResult("user", new HashSet<>(Arrays.asList("USER")));
//        } else {
//
//        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
