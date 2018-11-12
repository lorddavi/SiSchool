/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.ProfessorPebI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class ProfessorPebIDAO {
    
    public ProfessorPebIDAO() {
    }
    
    public void inserir(ProfessorPebI prof){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(prof);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(ProfessorPebI p){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.merge(p);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<ProfessorPebI> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<ProfessorPebI> professores = null;
        try {
            Query consulta = em.createQuery("SELECT p FROM ProfessorPebI p", ProfessorPebI.class);
            professores = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("erro ao buscar todos os prof peb i");
        }
        em.close();
        cem.fecharEM();    
        
        return professores;
    } 
    
    public List<ProfessorPebI> buscaPorNome(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<ProfessorPebI> professores = null;
        try {
            TypedQuery<ProfessorPebI> consulta = em.createQuery("SELECT p FROM ProfessorPebI p WHERE p.nome LIKE :busca", ProfessorPebI.class);
            consulta.setParameter("busca", busca);
            professores = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("Não foi possível encontrar nenhum professor com esse nome");
        }
        em.close();
        cem.fecharEM();    
        
        return professores;
    } 
    
    public List<ProfessorPebI> buscaEscola(Escola e){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<ProfessorPebI> profs = null;
        try {
            TypedQuery<ProfessorPebI> consulta = em.createQuery("SELECT p FROM ProfessorPebI p WHERE "
                    + "p.escola = :e", ProfessorPebI.class);
            consulta.setParameter("e", e);
            profs = consulta.getResultList();
        } catch (NoResultException ex) {
            System.out.println("erro ao buscar prof pebi pela escola");
        }
        
        return profs;
    }
    
    public ProfessorPebI buscarId(int id){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        ProfessorPebI funcionario ;
        try{
        em.getTransaction().begin();
        TypedQuery<ProfessorPebI> consulta = em.createQuery("SELECT p FROM ProfessorPebI p WHERE p.id = :id", ProfessorPebI.class);
        consulta.setParameter("id", id);
        funcionario = consulta.getSingleResult();
        em.close();
        cem.fecharEM();
        return funcionario;
        } catch (Exception e) {
            return null;
        }
    }
}
