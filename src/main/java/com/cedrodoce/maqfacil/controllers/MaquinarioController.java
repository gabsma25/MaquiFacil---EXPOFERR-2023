package com.cedrodoce.maqfacil.controllers;

import com.cedrodoce.maqfacil.entities.Maquinario;
import com.cedrodoce.maqfacil.entities.MaquinarioDTO;
import com.cedrodoce.maqfacil.repository.MaquinarioRepository;
import com.cedrodoce.maqfacil.services.MaquinarioServices;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.List;

@RestController
@RequestMapping("/maquinario")
public class MaquinarioController {

    @Autowired
    MaquinarioServices maquinarioServices;

    @GetMapping
    public ResponseEntity listarMaquinario() {
        var allProducts = maquinarioServices.listarMaquinas();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<String> inserirMaquinario(@RequestBody @Validated MaquinarioDTO maquinario) {
        maquinarioServices.inserirMaquina(maquinario);
        return ResponseEntity.ok("Inserido com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarMaquinario(@PathVariable Long id) {
        maquinarioServices.deletarMaquina(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }

    @PutMapping("/abastecer/{id}")
    @Transactional
    public ResponseEntity<String> abastecerMaquinario(@PathVariable Long id){
        return maquinarioServices.abastecerMaquina(id);
    }

}
