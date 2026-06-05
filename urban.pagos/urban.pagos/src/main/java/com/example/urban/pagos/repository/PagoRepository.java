package com.example.urban.pagos.repository;

import com.example.urban.pagos.modelo.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pagos, Long> {
}