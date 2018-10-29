/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.ProfessorPebII;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class ProfessorPebIIDAO {


    public ProfessorPebIIDAO() {
    }
    
    public void inserir(ProfessorPebII prof){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(prof);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(ProfessorPebII prof){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	ProfessorPebII p2 = prof;
        em.merge(p2);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<ProfessorPebII> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<ProfessorPebII> professores = null;
        try {
            Query consulta = em.createQuery("SELECT p FROM ProfessorPebII p", ProfessorPebII.class);
            professores = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("erro ao buscar todos os prof peb ii");
        }
        em.close();
        cem.fecharEM();    
        
        return professores;
    } 
    
    public List<ProfessorPebII> buscaEscola(Escola e){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<ProfessorPebII> profs = null;
        try {
            TypedQuery<ProfessorPebII> consulta = em.createQuery("SELECT p FROM ProfessorPebII p WHERE "
                    + "p.escola = :e", ProfessorPebII.class);
            consulta.setParameter("e", e);
            profs = consulta.getResultList();
        } catch (NoResultException ex) {
            System.out.println("erro ao buscar profpebii pela escola");
        }
        
        return profs;
    }
    
    public List<ProfessorPebII> buscaEspecialidade(String esp){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<ProfessorPebII> profs = null;
        try {
            TypedQuery<ProfessorPebII> consulta = em.createQuery("SELECT p FROM ProfessorPebII p WHERE "
                    + "p.especialidade = :esp", ProfessorPebII.class);
            consulta.setParameter("esp", esp);
            profs = consulta.getResultList();
        } catch (NoResultException ex) {
            System.out.println("erro ao buscar a especialidade dos prof peb ii");
        }
        
        return profs;
    }
    
    public ProfessorPebII buscarId(int id){
        ProfessorPebII funcionario;
        try {
            CriaEntityManager cem = new CriaEntityManager();
            EntityManager em = cem.criarEM();
            TypedQuery<ProfessorPebII> consulta = em.createQuery("SELECT p FROM ProfessorPebII p WHERE p.id = :id", ProfessorPebII.class);
            consulta.setParameter("id", id);
            funcionario = consulta.getSingleResult();
            return funcionario;
        } catch (Exception e){
            return null;
        }
    }
    
}
