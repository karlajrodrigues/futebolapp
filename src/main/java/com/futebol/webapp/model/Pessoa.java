package com.futebol.webapp.model;

import org.hibernate.annotations.ColumnTransformer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_pessoa;

   @ColumnTransformer(
            read    = "pgp_pub_decrypt(nome, dearmor(current_setting('keys.private')), current_setting('decryption.password'))",
            write   = "pgp_pub_encrypt(?, dearmor(current_setting('keys.public')))")
    @Column(name="nome", nullable=false, columnDefinition = "bytea")
    private String nome;

    @ColumnTransformer(
            read    = "pgp_pub_decrypt(email, dearmor(current_setting('keys.private')), current_setting('decryption.password'))",
            write   = "pgp_pub_encrypt(?, dearmor(current_setting('keys.public')))")
    @Column(name="email", nullable=false, columnDefinition = "bytea")
    private String email;

    @ColumnTransformer(
            read    = "pgp_pub_decrypt(cpf, dearmor(current_setting('keys.private')), current_setting('decryption.password'))",
            write   = "pgp_pub_encrypt(?, dearmor(current_setting('keys.public')))")
    @Column(name="cpf", nullable=false, columnDefinition = "bytea")
    private String cpf;

    @Column(name="foto")
    private String foto;

    @Column(name="pronome")
    private String pronome;

    @Column(name ="data_nascimento")
    private String data_nascimento;

}
