package com.example.salesapi.controller;

import com.example.salesapi.dao.ProdutoRepository;
import com.example.salesapi.dao.VendaRepository;
import com.example.salesapi.model.ProdutoModel;
import com.example.salesapi.model.VendaModel;
import com.example.salesapi.model.VendedorModel;
import com.example.salesapi.dao.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VendedorController {

    /**
     * Repositório onde os vendedores são salvos
     */
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    VendaRepository vendaRepository;

    /**
     * Esta requisição cadastra um vendedor
     * @param vendedor = Objeto vendedor que será cadastrado
     *
     */
    @RequestMapping(value = "/vendedores", method = {RequestMethod.POST})
    @Validated
    public VendedorModel criarVendedor(@RequestBody VendedorModel vendedor){
       return vendedorRepository.save(vendedor);
    }

    /**
     *
     * @return Esta requisição retorna uma lista com todos os vendedores cadastrados
     */
    @RequestMapping(value = "/vendedores", method = {RequestMethod.GET})
    public List<VendedorModel> listarVendedores(){

        /** Essa lógica serve para popular a lista de vendas do vendedor, isto será alterado futuramente
            desenvolvi essa lógica apenas para teste
         **/
        List<VendedorModel> vendedores = vendedorRepository.findAll();
        List<VendaModel> vendas = vendaRepository.findAll();

        for (VendedorModel vendedor: vendedores
             ) {
            List<VendaModel> vendasRealizadas = new ArrayList<>();
            for(VendaModel venda: vendas){

                if(venda.getIdVendedor() == vendedor.getIdVendedor()){
                    vendasRealizadas.add(venda);
                }
            }
            vendedor.setVendasRealizadas(vendasRealizadas);
        }
        return vendedores;

    }

    /**
     * @param id = identificador de um vendedor
     * @return Retorna o vendedor correspondente ao id passado por parâmetro
     */
    @RequestMapping(value = "/selecionar-vendedor-pelo-id", method = {RequestMethod.GET})
    public Optional<VendedorModel> getNomeById(int id){
         return  vendedorRepository.findById(id);
    }
}