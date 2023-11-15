package com.cedrodoce.maqfacil.repository;

import com.cedrodoce.maqfacil.entities.Maquinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinarioRepository extends JpaRepository<Maquinario, Long> {

}
