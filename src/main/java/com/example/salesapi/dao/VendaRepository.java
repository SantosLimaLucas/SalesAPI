package com.example.salesapi.dao;

import com.example.salesapi.Model.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaModel, Integer> {
}
