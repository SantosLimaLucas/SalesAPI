package com.example.salesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@SequenceGenerator(name="sequencia_vendedor", sequenceName ="sequencia_vendedor", initialValue = 1, allocationSize = 1)
public class VendedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_vendedor")
    private int idVendedor;
    @NotNull
    private String nomeVendedor;

    /**
     * Lista de vendas realizadas por um vendedor.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<VendaModel> vendasRealizadas;

    /**
     * Este método adiciona uma venda à lista de vendas de um vendedor, ele é chamado na requisição realizarVenda
     * da classe vendedorController
     *
     * @param venda = Objeto venda que será adicionado
     */
    public void setVendasRealizadas(VendaModel venda){
        vendasRealizadas.add(venda);
    }
}
