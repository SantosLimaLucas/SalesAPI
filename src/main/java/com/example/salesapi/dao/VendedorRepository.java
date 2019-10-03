package com.example.salesapi.dao;

import com.example.salesapi.Model.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {

}
