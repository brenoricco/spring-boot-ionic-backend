package com.brenoricco.cursomc.repositories;

import com.brenoricco.cursomc.domains.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}