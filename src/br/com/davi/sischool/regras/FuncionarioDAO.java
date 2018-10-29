/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Davi
 */
public class FuncionarioDAO {
    Funcionario func = null;
    
    public FuncionarioDAO(){
        
    }
    
    public void inserir(Funcionario func){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(func);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(Funcionario func){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
        Funcionario f2 = func;
        em.merge(f2);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void excluir(Funcionario func){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
        Funcionario f2 = em.merge(func);
	em.remove(f2);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<Funcionario> buscarPorNome(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        TypedQuery<Funcionario> consulta = em.createQuery("SELECT f FROM Pessoa p, Funcionario f WHERE p.id = f.id AND p.nome LIKE :busca", Funcionario.class);
        consulta.setParameter("busca", busca);
        List<Funcionario> funcionarios = consulta.getResultList();
        em.close();
        cem.fecharEM();
        return funcionarios;
    }
    
    public List<Funcionario> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Funcionario> funcionarios = null;
        try {
            Query consulta = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            funcionarios = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("erro ao buscar todos os funcionários");
        }
        em.close();
        cem.fecharEM();    
        
        return funcionarios;
    } 
    
    public Funcionario buscarPorLogin(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        try{
            TypedQuery<Funcionario> consulta = em.createQuery("SELECT f FROM Funcionario f WHERE f.usrName = :busca", Funcionario.class);
            consulta.setParameter("busca", busca);
            Funcionario funcionario = consulta.getSingleResult();
            funcionario.setId(buscarId(busca));
            em.close();
            cem.fecharEM();
            return funcionario;
        } catch (Exception e) {
            System.out.println("erro ao buscar funcionário por login");
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Funcionario> buscarProfessores(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Funcionario> lista = new ArrayList<>();
        for (Funcionario f: buscaTodos()){
            if (f.getCargo().equals("Professor PEB I") ||  f.getCargo().equals("Professor PEB II")) {
                lista.add(f);
            }
        }
        em.close();
        cem.fecharEM();
        return lista;
    }
    
    /**
     * Método que retorna o id do usuário buscado. Um tapa-buraco para um erro
     * ridículo que estava retornando o funcionário mas o id permanecia 0.
     * @param busca
     * @return id do funcionário.
     */
    private int buscarId(String busca){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        Query consulta = em.createQuery("SELECT f.id FROM Funcionario f WHERE f.usrName = :busca");
        consulta.setParameter("busca", busca);
        int funcionario = Integer.valueOf(consulta.getSingleResult().toString());
        return funcionario;
    }
    
    public Funcionario buscarPorId(int id){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        try {
            TypedQuery<Funcionario> consulta = em.createQuery("SELECT f FROM Funcionario f WHERE f.id = :id", Funcionario.class);
            consulta.setParameter("id", id);
            Funcionario funcionario = consulta.getSingleResult();
            return funcionario;
        } catch(Exception e){
            return null;
        }
    }
}
