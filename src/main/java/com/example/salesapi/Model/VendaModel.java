package com.example.salesapi.Model;

import com.sun.xml.bind.v2.schemagen.xmlschema.LocalElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {
    @Id
    @GeneratedValue
    private long id;

    private Date dataDeVenda = new Date();

    private double valor;
    private String nomeVendedor;
    private long idVendedor;



}
