package com.brenoricco.cursomc.repositories;

import com.brenoricco.cursomc.domains.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
