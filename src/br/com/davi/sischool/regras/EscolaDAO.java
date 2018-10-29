/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Escola;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class EscolaDAO {
    CriaEntityManager cem = new CriaEntityManager();
    EntityManager em = cem.criarEM();
    
    public EscolaDAO(){
        
    }
    
    public void inserir(Escola escola){
	em.getTransaction().begin();
	em.persist(escola);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(Escola escola){
	em.getTransaction().begin();
	em.merge(escola);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void excluir(Escola escola){
	em.getTransaction().begin();
	em.remove(escola);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<Escola> buscaTodas(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Escola> escolas = null;
        try {
            Query consulta = em.createQuery("SELECT e FROM Escola e", Escola.class);
            escolas = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("Escola não encontrada");
        } catch(NonUniqueResultException ex) {
            System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return escolas;
    } 
    
    public List<Escola> buscaPorNome(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Escola> escolas = null;
        try {
            TypedQuery<Escola> consulta = em.createQuery("SELECT e FROM Escola e "
                    + "WHERE e.nome LIKE :busca", Escola.class);
            consulta.setParameter("busca", busca);
            escolas = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("Escola não encontrada");
        } catch(NonUniqueResultException ex) {
            System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return escolas;
    } 
    
    public Escola buscaPorId(int id){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        Escola escola = new Escola();
        try {
            TypedQuery<Escola> consulta = em.createQuery("SELECT e FROM Escola e "
                    + "WHERE e.id = :id", Escola.class);
            consulta.setParameter("id", id);
            escola = consulta.getSingleResult();
        } catch(NoResultException ex) {
            System.out.println("Escola não encontrada");
        } 
        em.close();
        cem.fecharEM();    
        
        return escola;
    } 

}
