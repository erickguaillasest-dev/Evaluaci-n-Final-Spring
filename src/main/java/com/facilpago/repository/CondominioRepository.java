package com.facilpago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilpago.model.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, String> {
}