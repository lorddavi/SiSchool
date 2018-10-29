/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.OutroCargo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class OutroCargoDAO {
    
    public OutroCargoDAO() {
    }
    
    public void inserir(OutroCargo func){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(func);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(OutroCargo func){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        em.getTransaction().begin();
        em.merge(func);
        em.getTransaction().commit();
        em.close();
        cem.fecharEM();
    }
    
    public void excluir(OutroCargo func){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        em.getTransaction().begin();
        em.remove(func);
        em.getTransaction().commit();
        em.close();
        cem.fecharEM();
    }
    
    public List<OutroCargo> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<OutroCargo> funcionarios = null;
        try {
            TypedQuery<OutroCargo> consulta = em.createQuery("SELECT o FROM OutroCargo o", OutroCargo.class);
            funcionarios = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("Erro para encontrar todos os outrocargo.");
        }
        em.close();
        cem.fecharEM();    
        
        return funcionarios;
    }
    
    public OutroCargo buscarFunc(int id){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        try {
            TypedQuery<OutroCargo> consulta = em.createQuery("SELECT o FROM OutroCargo"
                    + " o WHERE o.id = :id", OutroCargo.class);
            consulta.setParameter("id", id);
            OutroCargo funcionario = consulta.getSingleResult();
            return funcionario;
        } catch(Exception e){
            return null;
        }
    }
}
