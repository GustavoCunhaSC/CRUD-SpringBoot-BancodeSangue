package com.bancodesangue.doarsangue.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodesangue.doarsangue.entities.Doador;
import com.bancodesangue.doarsangue.repositories.DoadorRepository;

@RestController
@RequestMapping(value = "/doadores")
public class DoadorController {
    
    @Autowired //instanciar automaticamente
    private DoadorRepository doadorRepository;

    @GetMapping
    public List<Doador> findall(){
        return doadorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doador> findById(@PathVariable Long id){
        Optional<Doador> doador = doadorRepository.findById(id);
        return doador.map(response -> ResponseEntity.ok().body(response)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Doador insert(@RequestBody Doador doador){
        return doadorRepository.save(doador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doador> update(@PathVariable Long id, @RequestBody Doador novosDoador){
        Optional<Doador> doadorOptional = doadorRepository.findById(id);

        if (doadorOptional.isPresent()) {
            Doador doador = doadorOptional.get();
            doador.setNome(novosDoador.getNome());
            doador.setCpf(novosDoador.getCpf());
            doador.setIdade(novosDoador.getIdade());
            doador.setPeso(novosDoador.getPeso());
            doador.setTiposanguineo(novosDoador.getTiposanguineo());
            doador.setLocaldoacao(novosDoador.getLocaldoacao());
            Doador resultado = doadorRepository.save(doador);
            return ResponseEntity.ok(resultado);
        } else{
            return ResponseEntity.notFound().build();
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doador> delete(@PathVariable Long id){
        Optional<Doador> doadorOptional = doadorRepository.findById(id);

        if (doadorOptional.isPresent()) {
            doadorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
