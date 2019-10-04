package com.example.salesapi.Controller;

import com.example.salesapi.Model.VendaModel;
import com.example.salesapi.Model.VendedorModel;
import com.example.salesapi.dao.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/cadastrarVendedor")
    public VendedorModel criarVendedor(@RequestBody VendedorModel vendedor){
       return vendedorRepository.save(vendedor);
    }

    /**
     *
     * @return Esta requisição retorna uma lista com todos os vendedores cadastrados
     */
    @RequestMapping("/vendedoresCadastrados")
    public List<VendedorModel> listarVendedores(){
        return vendedorRepository.findAll();
    }

    /**
     * @param id = identificador de um vendedor
     * @return Retorna o vendedor correspondente ao id passado por parâmetro
     */
    @RequestMapping("/selecionarVendedorPeloID")
    public Optional<VendedorModel> getNomeById(int id){
         return  vendedorRepository.findById(id);
    }

    /**
     * Esta requisição adiciona uma venda na lista de vendas de um vendedor.
     *
     */
    @RequestMapping("/RealizarVenda")
    public VendaModel realizarVenda(@Valid @RequestBody VendaModel venda){
        vendedorModel = vendedorRepository.getOne(venda.getIdVendedor());
        vendedorModel.setVendasRealizadas(venda);
        vendedorModel = vendedorRepository.save(vendedorModel);
        return venda;
    }

}
