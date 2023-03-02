package com.pix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String username; // username spring security
    private String email;
    private String pix;

    // carteira fiduciaria?

}