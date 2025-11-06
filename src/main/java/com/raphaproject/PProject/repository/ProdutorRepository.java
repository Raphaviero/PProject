package com.raphaproject.PProject.repository;

import com.raphaproject.PProject.model.FProdutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutorRepository extends JpaRepository<FProdutor, String> {


    List<FProdutor> findByCPF(String cpf);
}
