/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoCadPessoas.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "tb_pessoafisica")
public class PessoaFisica extends Pessoa{

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    private String cpf;
}
