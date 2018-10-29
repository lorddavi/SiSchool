/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Davi
 */
public class CriaEntityManager {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SiSchoolPU");
    
    public CriaEntityManager() {
       
    }
    
    public EntityManager criarEM(){
       
        EntityManager em = emf.createEntityManager();
        
        return em;
    }
    
    public void fecharEM(){
	emf.close();
    }
    
}
