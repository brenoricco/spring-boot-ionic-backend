package com.brenoricco.cursomc.repositories;

import com.brenoricco.cursomc.domains.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
