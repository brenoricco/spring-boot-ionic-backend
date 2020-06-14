package com.brenoricco.cursomc.repositories;

import com.brenoricco.cursomc.domains.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
