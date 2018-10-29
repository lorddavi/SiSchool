/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Davi
 */
public class EstatisticasDAO {
    AlunoDAO alunoDao = new AlunoDAO();
    EscolaDAO escolaDao = new EscolaDAO();
    ProfessorPebIDAO pebidao = new ProfessorPebIDAO();
    ProfessorPebIIDAO pebiidao = new ProfessorPebIIDAO();
    OutroCargoDAO ocdao = new OutroCargoDAO();
    
    public int numAlunos(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        int qtd;
        List<Aluno> alunos = alunoDao.buscaTodos();
        qtd = alunos.size();
        em.close();
        cem.fecharEM(); 
        return qtd;
    }
    
    public int numEscolas(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        int qtd;
        List<Escola> escolas = escolaDao.buscaTodas();
        qtd = escolas.size();
        em.close();
        cem.fecharEM(); 
        return qtd;
    }
    
    public int numProfPebI(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        int qtd;
        List<ProfessorPebI> profs = pebidao.buscaTodos();
        qtd = profs.size();
        em.close();
        cem.fecharEM(); 
        return qtd;
    }
    
    public int numProfPebII(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        int qtd;
        List<ProfessorPebII> profs = pebiidao.buscaTodos();
        qtd = profs.size();
        em.close();
        cem.fecharEM(); 
        return qtd;
    }
    
    public int numOutroCargo(){
        CriaEntityManager cem = new CriaEntityManager();
        EntityManager em = cem.criarEM();
        int qtd;
        List<OutroCargo> funcs = ocdao.buscaTodos();
        qtd = funcs.size();
        em.close();
        cem.fecharEM(); 
        return qtd;
    }
}
