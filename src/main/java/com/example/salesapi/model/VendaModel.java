package com.example.salesapi.model;


import com.example.salesapi.controller.ProdutoController;
import com.example.salesapi.dao.ProdutoRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@SequenceGenerator(name="sequencia_venda", sequenceName ="sequencia_venda", initialValue = 1, allocationSize = 1)
public class VendaModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_venda")
    private int idVenda;
    private int idVendedor;
    private Calendar dataDeVenda = Calendar.getInstance();
    private double valorVenda = 0;
    @NotNull
    @Getter
    private int[] idsProdutos;
    @ManyToMany(targetEntity = ProdutoModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name="vp_fk", referencedColumnName = "idVenda")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ProdutoModel> listaProdutos = new ArrayList<>();

    /**
     *
     * @return = Retorna o id de um vendedor, este método é chamado na requisição realizarVenda
     * da classe vendedorController
     */
    public int getIdVendedor(){
        return this.idVendedor;
    }
    public int[] getIdsProdutos(){
        return this.idsProdutos;
    }


    public void gerarValorVenda() {
        double total = 0;
        for(int i = 0; i < listaProdutos.size(); i++){
            total += listaProdutos.get(i).getValorProduto();
        }
        this.valorVenda =  total;
    }

    public void adicionarProduto(ProdutoModel produto){
        this.listaProdutos.add(produto);
    }
}
