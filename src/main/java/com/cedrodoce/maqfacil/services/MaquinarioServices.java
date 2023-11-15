package com.cedrodoce.maqfacil.services;

import com.cedrodoce.maqfacil.entities.Maquinario;
import com.cedrodoce.maqfacil.entities.MaquinarioDTO;
import com.cedrodoce.maqfacil.repository.MaquinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinarioServices {

    @Autowired
    MaquinarioRepository maquinarioRepository;

    public Maquinario inserirMaquina(MaquinarioDTO data) {
        Maquinario maquinario = new Maquinario(data);
        return maquinarioRepository.save(maquinario);
    }

    public List<Maquinario> listarMaquinas() {
        List<Maquinario> all = maquinarioRepository.findAll();
        return all;

    }

    public void deletarMaquina(Long id) {
        maquinarioRepository.deleteById(id);
    }

    public ResponseEntity<String> abastecerMaquina(Long id) {
        var maquina = maquinarioRepository.findById(id);
        if (maquina.isPresent()) {
            Maquinario maquinario = maquina.get();
            maquinario.getStatus().setNivel_combustivel(100);
            return ResponseEntity.ok("Tanque abastecido até a capacidade máxima.");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> colocarOleo(Long id){
        var maquina = maquinarioRepository.findById(id);
        if(maquina.isPresent()){
            Maquinario maquinario = maquina.get();
            maquinario.getStatus().setNivel_oleo(1);
        }
    }

}
