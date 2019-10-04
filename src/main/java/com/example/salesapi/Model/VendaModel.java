package com.example.salesapi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private Calendar dataDeVenda = Calendar.getInstance();

    private double valor;

}
