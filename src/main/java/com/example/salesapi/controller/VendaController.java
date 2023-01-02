package com.example.salesapi.controller;

import com.example.salesapi.dao.ProdutoRepository;
import com.example.salesapi.dao.VendaRepository;
import com.example.salesapi.model.ProdutoModel;
import com.example.salesapi.model.VendaModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@JsonSerialize
@Transactional
@RestController
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(value = "/venda", method = {RequestMethod.POST})
    @Validated
    public VendaModel criarVenda(@RequestBody VendaModel venda){
        venda = preencherListaProdutos(venda);
        return vendaRepository.save(venda);
    }

    @RequestMapping(value = "/venda", method = {RequestMethod.GET})
    public List<VendaModel> listarVendas(){
        return vendaRepository.findAll();
    }

    private VendaModel preencherListaProdutos(VendaModel venda){
        int[] idsProdutos = venda.getIdsProdutos();
        for (int i = 0; i < idsProdutos.length; i++){
            ProdutoModel produto = produtoRepository.getOne(idsProdutos[i]);
            venda.adicionarProduto(produto);
        }
        venda.gerarValorVenda();
        return venda;
    }
}
