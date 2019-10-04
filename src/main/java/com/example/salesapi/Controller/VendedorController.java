package com.example.salesapi.Controller;

import com.example.salesapi.Model.VendaModel;
import com.example.salesapi.Model.VendedorModel;
import com.example.salesapi.dao.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VendedorController {

    private VendedorModel vendedor;
    @Autowired
    private VendedorRepository vendedorRepository;

    @RequestMapping("/cadastrarVendedor")
    public VendedorModel criarVendedor(@RequestBody VendedorModel vendedor){
       return vendedorRepository.save(vendedor);

    }

    @RequestMapping("/vendedoresCadastrados")
    public List<VendedorModel> listarVendedores(){

        return vendedorRepository.findAll();
    }

    @RequestMapping("/selecionarVendedorPeloID")
    public Optional<VendedorModel> getNomeById(int id){

         return  vendedorRepository.findById(id);
    }

    /**
     * Esse método adiciona uma venda na lista de vendas de um vendedor passado como parâmetro.
     *
     * @param idVendedor parâmetro de um vendedor já cadastrado que realizará a venda.
     *
     */
    @RequestMapping("/RealizarVenda")
    public VendaModel realizarVenda(@PathVariable(value = "id") int idVendedor, @Valid @RequestBody VendaModel venda){
        vendedor = vendedorRepository.getOne(idVendedor);
        vendedor.vendasEfetuadas.add(venda);
        return venda;
    }

}
