/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Turma;
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
public class TurmaDAO {

    
    
    public TurmaDAO() {
    }
    
     public void inserir(Turma turma){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(turma);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
     
    public void editar(Turma turma){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        em.getTransaction().begin();
        Turma t = turma;
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        cem.fecharEM();
    }
    
    public void excluir(Turma turma){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        em.getTransaction().begin();
        Turma t = em.merge(turma);
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        cem.fecharEM();
    }
    
    public void editarList(List<Turma> turmas){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        em.getTransaction().begin();
        for (Turma t: turmas){
            em.merge(t);
        }
        em.getTransaction().commit();
        em.close();
        cem.fecharEM();
    }
     
    public List<Turma> buscaTodas(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Turma> turmas = null;
        try {
            Query consulta = em.createQuery("SELECT t FROM Turma t", Turma.class);
            turmas = consulta.getResultList();
        } catch(NoResultException ex) {
    		System.out.println("Aluno não encontrado");
        } catch(NonUniqueResultException ex) {
    		System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return turmas;
    }
    
    public List<Turma> buscaPorEscola(Escola e){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Turma> turmas = null;
        try {
            TypedQuery<Turma> consulta = em.createQuery("SELECT t FROM Turma t WHERE t.escola.id = :escolaId", Turma.class);
            consulta.setParameter("escolaId", e.getId());
            turmas = consulta.getResultList();
        } catch(NoResultException ex) {
    		System.out.println("Turma não encontrada");
        } catch(NonUniqueResultException ex) {
    		System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return turmas;
    }
    
    public List<Turma> buscaPorProfessorPebI(ProfessorPebI p){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Turma> turmas = null;
        try {
            TypedQuery<Turma> consulta = em.createQuery("SELECT t FROM Turma t WHERE t.profPebI = :p", Turma.class);
            consulta.setParameter("p", p);
            turmas = consulta.getResultList();
        } catch(NoResultException ex) {
    		System.out.println("Turma não encontrada");
        } catch(NonUniqueResultException ex) {
    		System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return turmas;
    }
    
    public List<Turma> buscaPorProfessorPebII(ProfessorPebII p){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Turma> turmas = null;
        try {
            TypedQuery<Turma> consulta = em.createQuery("SELECT t FROM Turma t WHERE t.profPebII = :p", Turma.class);
            consulta.setParameter("p", p);
            turmas = consulta.getResultList();
        } catch(NoResultException ex) {
    		System.out.println("Turma não encontrada");
        } catch(NonUniqueResultException ex) {
    		System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return turmas;
    }
   
    public Turma buscarId(int id){
        Turma turma;
        try {
            CriaEntityManager cem = new CriaEntityManager();
            EntityManager em = cem.criarEM();
            TypedQuery<Turma> consulta = em.createQuery("SELECT t FROM Turma t WHERE t.id = :id", Turma.class);
            consulta.setParameter("id", id);
            turma = consulta.getSingleResult();
            return turma;
        } catch (Exception e){
            return null;
        }
    }
}
