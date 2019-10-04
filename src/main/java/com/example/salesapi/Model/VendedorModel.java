package com.example.salesapi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendedorModel implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nome;

    /**
     * Lista de vendas realizadas por um vendedor.
     */
    public List<VendaModel> vendasEfetuadas = new ArrayList<VendaModel>();
}
