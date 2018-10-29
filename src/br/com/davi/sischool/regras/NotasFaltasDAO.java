/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.NotasFaltas;
import javax.persistence.EntityManager;

/**
 *
 * @author Davi
 */
public class NotasFaltasDAO {
    
    public void inserir(NotasFaltas nf){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(nf);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(NotasFaltas nf){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.merge(nf);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
}
