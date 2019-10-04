package com.example.salesapi.dao;

import com.example.salesapi.model.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {
}
