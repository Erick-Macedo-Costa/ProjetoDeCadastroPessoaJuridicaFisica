/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoCadPessoas.controller;

/**
 *
 * @author erick
 */

import com.projeto.projetoCadPessoas.model.entity.PessoaFisica;
import com.projeto.projetoCadPessoas.model.repository.PessoaFRepository;
import javax.transaction.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
@Controller
@RequestMapping("pessoasFisica")
public class PessoaFController {

    @Autowired
    PessoaFRepository repository;
    

    @GetMapping("/form")
    public String form(PessoaFisica pessoa){
        return "/pessoasFisica/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {       
        model.addAttribute("pessoaFisica", repository.pessoas());
        return new ModelAndView("/pessoasFisica/list", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(PessoaFisica pessoaFisica){
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoasFisica/list");
    }
        
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoasFisica/list");
    }

    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaFisica", repository.pessoa(id));
        return new ModelAndView("/pessoasFisica/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        
        return new ModelAndView("redirect:/pessoasFisica/list");
    }
    
}
