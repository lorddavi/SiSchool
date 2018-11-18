/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Certificado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Davi
 */
public class CertificadoDAO {

    public CertificadoDAO() {
    }
    
    public void inserir(Certificado c){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.persist(c);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void editar(Certificado c){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
	em.merge(c);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public void excluir(Certificado c){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
	em.getTransaction().begin();
        Certificado c2 = em.merge(c);
	em.remove(c2);
	em.getTransaction().commit();
	em.close();
	cem.fecharEM();
    }
    
    public List<Certificado> buscaTodos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        List<Certificado> certificados = null;
        try {
            Query consulta = em.createQuery("SELECT c FROM Certificado c", Certificado.class);
            certificados = consulta.getResultList();
        } catch(NoResultException ex) {
            System.out.println("Erro ao buscar todos os certificados.");
        }
        em.close();
        cem.fecharEM();    
        
        return certificados;
    } 
}
