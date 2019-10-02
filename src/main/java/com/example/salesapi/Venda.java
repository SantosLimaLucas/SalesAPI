package com.example.salesapi;

import java.util.Date;

public class Venda {
    Vendedor vendedor = new Vendedor();
    private long id;
    private Date dataDeVenda;
    private double valor;
    private String nomeVendedor = vendedor.getNome();
    private long idVendedor = vendedor.getId();

}
