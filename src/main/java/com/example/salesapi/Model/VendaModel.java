package com.example.salesapi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="sequencia_venda", sequenceName ="sequencia_venda", initialValue = 1, allocationSize = 1)
public class VendaModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_venda")
    private long idVenda;
    private int idVendedor;
    private Calendar dataDeVenda = Calendar.getInstance();
    private double valorVenda;

    /**
     *
     * @return = Retorna o id de um vendedor, este método é chamado na requisição realizarVenda
     * da classe vendedorController
     */
    public int getIdVendedor(){
        return this.idVendedor;
    }
}
