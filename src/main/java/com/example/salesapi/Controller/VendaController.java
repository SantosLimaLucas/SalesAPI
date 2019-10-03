package com.example.salesapi.Controller;

import com.example.salesapi.Model.VendaModel;
import com.example.salesapi.dao.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendaController {
    @Autowired
    private VendaRepository vendaRepository;

    @RequestMapping("/RealizarVenda")
    public String realizarVenda(@RequestBody VendaModel venda){
        vendaRepository.save(venda);
        return "Venda realizada";
    }
    @RequestMapping("/vendasRealizadas")
    public List<VendaModel> getAll(){
        return vendaRepository.findAll();
    }

}
