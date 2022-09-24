/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoCadPessoas.controller;

import com.projeto.projetoCadPessoas.model.entity.PessoaJuridica;
import com.projeto.projetoCadPessoas.model.repository.PessoaJRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author erick
 */
@Transactional
@Controller
@RequestMapping("pessoasJuridica")
public class PessoaJController {
    @Autowired
    PessoaJRepository repository;
    

    @GetMapping("/form")
    public String form(PessoaJuridica pessoa){
        return "/pessoasJuridica/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {       
        model.addAttribute("pessoaJuridica", repository.pessoas());
        return new ModelAndView("/pessoasJuridica/list", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(PessoaJuridica pessoaJuridica){
        repository.save(pessoaJuridica);
        return new ModelAndView("redirect:/pessoasJuridica/list");
    }
        
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoasJuridica/list");
    }

    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaJuridica", repository.pessoa(id));
        return new ModelAndView("/pessoasJuridica/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica) {
        repository.update(pessoaJuridica);
        
        return new ModelAndView("redirect:/pessoasJuridica/list");
    }
}
