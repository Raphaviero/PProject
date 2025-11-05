package com.raphaproject.PProject.controller;

import com.raphaproject.PProject.model.FProdutor;
import com.raphaproject.PProject.repository.ProdutorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtor")
public class CProdutor {


    private ProdutorRepository produtorRepository;

    public CProdutor(ProdutorRepository produtorRepository) {
        this.produtorRepository = produtorRepository;
    }

    @PostMapping
    public void save(@RequestBody FProdutor produtor){
        String id = UUID.randomUUID().toString();
        produtor.setId(id);
        produtorRepository.save(produtor);
    }

    @GetMapping("{id}")
    public FProdutor findProdutorById(@PathVariable("id") String id){
       return produtorRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteProdutorById(@PathVariable("id") String id){
        produtorRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateProdutorById(@PathVariable("id") String id,
                                   @RequestBody FProdutor fProdutor){
        fProdutor.setId(id);
        produtorRepository.save(fProdutor);
    }

}
