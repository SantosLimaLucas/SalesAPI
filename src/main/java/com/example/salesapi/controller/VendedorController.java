package com.example.salesapi.controller;

import com.example.salesapi.model.VendaModel;
import com.example.salesapi.model.VendedorModel;
import com.example.salesapi.dao.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VendedorController {
    /**
     * Objeto vendedor model utilizado no método realizarVenda
     */
    private VendedorModel vendedorModel;

    /**
     * Repositório onde os vendedores são salvos
     */
    @Autowired
    private VendedorRepository vendedorRepository;

    /**
     * Esta requisição cadastra um vendedor
     * @param vendedor = Objeto vendedor que será cadastrado
     *
     */
    @RequestMapping("/cadastrar-vendedor")
    @Validated
    public VendedorModel criarVendedor(@RequestBody VendedorModel vendedor){
       return vendedorRepository.save(vendedor);
    }

    /**
     *
     * @return Esta requisição retorna uma lista com todos os vendedores cadastrados
     */
    @RequestMapping("/vendedores-cadastrados")
    public List<VendedorModel> listarVendedores(){
        return vendedorRepository.findAll();
    }

    /**
     * @param id = identificador de um vendedor
     * @return Retorna o vendedor correspondente ao id passado por parâmetro
     */
    @RequestMapping("/selecionar-vendedor-pelo-id")
    public Optional<VendedorModel> getNomeById(@RequestBody int id){
         return  vendedorRepository.findById(id);
    }

    /**
     * Esta requisição adiciona uma venda na lista de vendas de um vendedor.
     *
     */
    @RequestMapping("/realizar-venda")
    @Validated
    public VendaModel realizarVenda(@Valid @RequestBody VendaModel venda){
        vendedorModel = vendedorRepository.getOne(venda.getIdVendedor());
        vendedorModel.setVendasRealizadas(venda);
        vendedorModel = vendedorRepository.save(vendedorModel);
        return venda;
    }
}
