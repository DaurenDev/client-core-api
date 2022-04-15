package kz.dar.academy.backend.controller.deprecated;

import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.service.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/client")
public class ClientControllerOld {
    @Autowired
    Environment env;

    @Autowired
    private ClientServiceOld clientService;

    @GetMapping("/check")
    public String check() {
        return "client-core-api is working at " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId,
                                                     @Valid @RequestBody ClientModel clientModel) {
        clientService.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    }
}
