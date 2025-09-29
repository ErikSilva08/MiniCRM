package com.example.miniCRM.repository;

import com.example.miniCRM.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato,Long> {
}
