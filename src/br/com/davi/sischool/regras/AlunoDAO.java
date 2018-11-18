/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class AlunoDAO {
    Aluno aluno = null;
    NotasFaltasDAO bfdao = new NotasFaltasDAO();
    
    public AlunoDAO(){
        
    }
    
    public void inserir(Aluno aluno){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();    
	em.getTransaction().begin();
	em.persist(aluno);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(Aluno aluno){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	Aluno a = aluno;
        em.merge(a);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void excluir(Aluno aluno){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	Aluno a2 = em.merge(aluno);
        em.remove(a2);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<Aluno> buscarPorNome(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        TypedQuery<Aluno> consulta = em.createQuery(
            "SELECT a FROM Aluno a WHERE a.nome LIKE :busca AND a.ativo = true", Aluno.class);
        consulta.setParameter("busca", busca);
        List<Aluno> alunos = consulta.getResultList();
        em.close();
        cem.fecharEM();
        return alunos;
    }
    
    public List<Aluno> buscarUmPorRa(String ra){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Aluno> alunos = new ArrayList<>();
        try {
            TypedQuery<Aluno> consulta = em.createQuery("SELECT a FROM Aluno a WHERE a.ra like :ra AND a.ativo = true", Aluno.class);
            consulta.setParameter("ra", ra);
            alunos = consulta.getResultList();
        } catch(NoResultException ex) {
    		System.out.println("Aluno não encontrado");
        } catch(NonUniqueResultException ex) {
    		System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return alunos;
    }
    
    public List<Aluno> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Aluno> alunos = null;
        try {
            TypedQuery<Aluno> consulta = em.createQuery("SELECT a FROM Aluno a WHERE a.ativo = true", Aluno.class);
            alunos = consulta.getResultList();
        } catch(NoResultException ex) {
    		System.out.println("Aluno não encontrado");
        }
        em.close();
        cem.fecharEM();    
        
        return alunos;
    }
    
}
