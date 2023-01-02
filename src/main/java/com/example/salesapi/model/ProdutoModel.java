package com.example.salesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@SequenceGenerator(name="sequencia_produto", sequenceName ="sequencia_produto", initialValue = 1, allocationSize = 1)
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_produto")
    private int idProduto;

    private String nomeProduto;

    private double valorProduto;
}
