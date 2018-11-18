/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.Professor;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class ProfessorDAO {

    public ProfessorDAO() {
    }
    
    public void editar(Professor p){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
        Professor p2 = p;
	em.merge(p2);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<Professor> buscarProfessores(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Professor> listaP = new ArrayList<>();
        List<Funcionario> listaF = new ArrayList<>();
        FuncionarioDAO fdao = new FuncionarioDAO();
        ProfessorPebIDAO pidao = new ProfessorPebIDAO();
        ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();

        for (Funcionario f: fdao.buscaTodos()){
            if (f.getCargo().equals("Professor PEB I") ||  f.getCargo().equals("Professor PEB II")) {
                listaF.add(f);
            }
        }
        for (Funcionario f: listaF){
            if (f.getCargo().equals("Professor PEB I")){
                ProfessorPebI p = new ProfessorPebI();
                p = pidao.buscarId(f.getId());
                    listaP.add(p);
            } else if (f.getCargo().equals("Professor PEB II")){
                ProfessorPebII p = new ProfessorPebII();
                p = piidao.buscarId(f.getId());
                    listaP.add(p);
            }

        }

        em.close();
        cem.fecharEM();
        return listaP;
    }
    
    public Professor buscarId(int id){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        Professor professor = new Professor();
        
        try {
            em.getTransaction().begin();
            professor = em.find(Professor.class, id);
            em.close();
            cem.fecharEM();
            return professor;
        } catch (Exception e) {
            System.out.println("ProfessorID não encontrado.");
            return null;
        }
    }
    
    public List<Professor> buscarPorNome(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        TypedQuery<Professor> consulta = em.createQuery("SELECT p FROM Professor p WHERE p.nome LIKE :busca", Professor.class);
        consulta.setParameter("busca", busca);
        List<Professor> professores = consulta.getResultList();
        em.close();
        cem.fecharEM();
        return professores;
    }
}
