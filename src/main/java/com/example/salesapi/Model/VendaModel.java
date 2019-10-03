package com.example.salesapi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {
    @Id
    @GeneratedValue
    private long id;
    @GeneratedValue
    private Date dataDeVenda;

    private double valor;
    private String nomeVendedor;
    private long idVendedor;



}
