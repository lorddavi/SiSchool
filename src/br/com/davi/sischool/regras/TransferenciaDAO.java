/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Transferencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Davi
 */
public class TransferenciaDAO {
    
    public TransferenciaDAO() {
    }
    
    public void inserir(Transferencia transf){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(transf);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void remover(int id){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
        Transferencia transf = em.find(Transferencia.class, id);
	em.remove(transf);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<Transferencia> buscaTodas(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Transferencia> listaTransf = null;
        em.getTransaction().begin();
        try {
            Query consulta = em.createQuery("SELECT t FROM Transferencia t", Transferencia.class);
            listaTransf = consulta.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        em.close();
        cem.fecharEM();
        
        return listaTransf;
    }
}
