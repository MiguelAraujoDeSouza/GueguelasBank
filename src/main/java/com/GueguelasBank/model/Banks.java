package com.GueguelasBank.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "banks")
@Entity
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String city;

    private String cpnj;

}
