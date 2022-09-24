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
@Table(name = "tb_pessoajuridica")
public class PessoaJuridica extends Pessoa{

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    private String cnpj;
}
