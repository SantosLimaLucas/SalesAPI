package com.example.salesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import java.util.ArrayList;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<VendaModel> vendasRealizadas = new ArrayList<>();

}
