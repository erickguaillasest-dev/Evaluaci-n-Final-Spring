package com.facilpago.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.facilpago.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByCondomino_CedulaCondomino(String cedulaCondomino);

}