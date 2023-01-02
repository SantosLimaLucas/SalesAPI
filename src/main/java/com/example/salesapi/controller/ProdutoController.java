package com.example.salesapi.controller;

import com.example.salesapi.dao.ProdutoRepository;
import com.example.salesapi.model.ProdutoModel;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(value = "/produtos", method = {RequestMethod.POST})
    @Validated
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto){
        return produtoRepository.save(produto);
    }
    @RequestMapping(value="/produtos", method ={RequestMethod.GET})
    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }

    @RequestMapping("/selecionar-produto-pelo-id")
    public ProdutoModel getProdutoById(@RequestBody Integer id){

        return  produtoRepository.getOne(id);
    }
}
