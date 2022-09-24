/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoCadPessoas.model.repository;
import com.projeto.projetoCadPessoas.model.entity.PessoaJuridica;
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
public class PessoaJRepository {
    
     @PersistenceContext
    private EntityManager em;

    public void save(PessoaJuridica pessoa){
        em.persist(pessoa);
    }

    public PessoaJuridica pessoa(Long id){
        return em.find(PessoaJuridica.class, id);
    }

    public List<PessoaJuridica> pessoas(){
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    public void remove(Long id){
        PessoaJuridica p = em.find(PessoaJuridica.class, id);
        em.remove(p);
    }

    public void update(PessoaJuridica pessoa){
        em.merge(pessoa);
    }
}