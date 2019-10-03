package com.example.salesapi.Controller;

import com.example.salesapi.Model.VendedorModel;
import com.example.salesapi.dao.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendedorController {
    @Autowired
    private VendedorRepository vendedorRepository;

    @RequestMapping("/cadastrarVendedor")
    public String criarVendedor(@RequestBody VendedorModel vendedor){
        vendedorRepository.save(vendedor);
        return "Vendedor Cadastrado!";
    }

    @RequestMapping("/vendedoresCadastrados")
    public List<VendedorModel> listarVendedores(){
        return vendedorRepository.findAll();
    }


}
