package com.facilpago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilpago.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, String> {
}
