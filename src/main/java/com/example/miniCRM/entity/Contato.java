package com.example.miniCRM.entity;

import com.example.miniCRM.dtos.ContatoRequestDTO;
import com.example.miniCRM.enumeration.TipoContato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contatos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private TipoContato type;
    @Column(length = 100, nullable = false,unique = true)
    private String valueType;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Contato (ContatoRequestDTO request) {
        this.type = request.type();
        this.valueType = request.valueType();
    }


}
