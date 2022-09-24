/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoCadPessoas.model.repository;
import com.projeto.projetoCadPessoas.model.entity.PessoaFisica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erick
 */
@Repository
public class PessoaFRepository {
    
     @PersistenceContext
    private EntityManager em;

    public void save(PessoaFisica pessoa){
        em.persist(pessoa);
    }

    public PessoaFisica pessoa(Long id){
        return em.find(PessoaFisica.class, id);
    }

    public List<PessoaFisica> pessoas(){
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public void remove(Long id){
        PessoaFisica p = em.find(PessoaFisica.class, id);
        em.remove(p);
    }

    public void update(PessoaFisica pessoa){
        em.merge(pessoa);
    }
}