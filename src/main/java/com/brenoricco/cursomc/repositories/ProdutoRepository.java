package com.brenoricco.cursomc.repositories;

import com.brenoricco.cursomc.domains.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
