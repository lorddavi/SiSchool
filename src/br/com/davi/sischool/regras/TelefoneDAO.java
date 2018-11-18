/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Telefone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Davi
 */
public class TelefoneDAO {

    public TelefoneDAO() {
    }
    
    public List<Telefone> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Telefone> telefones = null;
        try {
            Query consulta = em.createQuery("SELECT t FROM Telefone t", Telefone.class);
            telefones = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("Erro ao buscar todos os telefones");
        }
        em.close();
        cem.fecharEM();    
        
        return telefones;
    } 
}
