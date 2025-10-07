package com.example.miniCRM.controller;

import com.example.miniCRM.dtos.ClienteRequestDTO;
import com.example.miniCRM.dtos.ClienteResponseDTO;
import com.example.miniCRM.dtos.ContatoRequestDTO;
import com.example.miniCRM.dtos.ContatoResponseDTO;
import com.example.miniCRM.entity.Cliente;
import com.example.miniCRM.entity.Contato;
import com.example.miniCRM.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
    public final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> createCliente (@RequestBody ClienteRequestDTO request) {
        return new ResponseEntity<>(service.createCliente(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listAllClientes () {
        List<ClienteResponseDTO> responseList = service.listAllCientes();
        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{clienteId}/contato")
    public ResponseEntity<ContatoResponseDTO> addContatoToCliente (@PathVariable Long clienteId, @RequestBody ContatoRequestDTO request) {
        ContatoResponseDTO criatedContato = service.addContatoToCliente(clienteId,request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{clienteId}")
                .buildAndExpand(criatedContato.id())
                .toUri();

        return ResponseEntity.created(uri).body(criatedContato);
    }


}
