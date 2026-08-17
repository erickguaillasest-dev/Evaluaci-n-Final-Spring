package com.facilpago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilpago.model.Bloque;

@Repository
public interface BloqueRepository extends JpaRepository<Bloque, String> {
}
