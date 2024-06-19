package com.bancodesangue.doarsangue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancodesangue.doarsangue.entities.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Long>{
    
}
