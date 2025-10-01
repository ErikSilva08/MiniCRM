package com.example.miniCRM.services;

import com.example.miniCRM.dtos.ClienteRequestDTO;
import com.example.miniCRM.dtos.ClienteResponseDTO;
import com.example.miniCRM.dtos.ContatoRequestDTO;
import com.example.miniCRM.dtos.ContatoResponseDTO;
import com.example.miniCRM.entity.Cliente;
import com.example.miniCRM.entity.Contato;
import com.example.miniCRM.repository.ClienteRepository;
import com.example.miniCRM.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    public final ClienteRepository repository;
    public final ContatoRepository contatoRepository;

    public ClienteService (ClienteRepository repository, ContatoRepository contatoRepository) {
        this.repository = repository;
        this.contatoRepository = contatoRepository;
    }

    public ClienteResponseDTO createCliente (ClienteRequestDTO request) {
        Cliente clienteCriated = new Cliente(request);
        Cliente clienteSave = repository.save(clienteCriated);
        return new ClienteResponseDTO(clienteSave);
    }

    public List<ClienteResponseDTO> listAllCientes () {
        return repository.findAll().stream()
                .map(cliente -> new ClienteResponseDTO(cliente))
                .collect(Collectors.toList());
    }

    public ContatoResponseDTO addContatoToCliente (Long clienteId, ContatoRequestDTO request) {
        Cliente clienteById = repository.findById(clienteId)
                .orElseThrow(()-> new EntityNotFoundException("id: " + clienteId + " Not found!"));

        Contato contatoCreated = new Contato();
        contatoCreated.setType(request.type());
        contatoCreated.setValueType(request.valueType());
        contatoCreated.setCliente(clienteById);

        Contato contatoSaved = contatoRepository.save(contatoCreated);

        return new ContatoResponseDTO(contatoSaved);
    }

}
