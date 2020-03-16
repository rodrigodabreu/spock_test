package br.com.rodrigo.abreu.spock_test.controller;

import br.com.rodrigo.abreu.spock_test.entity.Cliente;
import br.com.rodrigo.abreu.spock_test.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClienteRest {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> listaClientePeloId(@PathVariable(value = "id") Long clienteId) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/clientes")
    public List<Cliente> listaTodosClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> adicionarCliente(@Valid @RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> atualizaCliente(
            @PathVariable(value = "id") Long clienteId,
            @Valid @RequestBody Cliente clienteInfo) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente id :: não encontrado" + clienteId));
        cliente.setNome(clienteInfo.getNome());
        cliente.setDtNascimento(clienteInfo.getDtNascimento());
        cliente.setSexo(clienteInfo.getSexo());
        final Cliente clienteAtualizado = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("clientes/{id}")
    public Map<String, Boolean> removerCliente(@PathVariable(value = "id") Long idCliente) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResourceNotFoundException("Cliente id :: não encontrado" + idCliente));
        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
