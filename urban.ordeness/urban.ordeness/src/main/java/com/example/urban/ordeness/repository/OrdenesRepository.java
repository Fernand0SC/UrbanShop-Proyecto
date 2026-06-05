package com.example.urban.ordeness.repository;

import com.example.urban.ordeness.modelo.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {
}