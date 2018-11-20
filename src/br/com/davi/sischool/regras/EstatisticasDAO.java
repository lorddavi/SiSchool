/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.NotasFaltas;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Turma;
import java.util.ArrayList;
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
    
    public String mediaHistorica(List<NotasFaltas> nf, String materia){
        int num = 0;
        List<String> conta = new ArrayList<>();
        for (NotasFaltas f: nf){
            if (f.getMateria().equals(materia)){
                conta.add(f.getNota1());
                conta.add(f.getNota2());
                conta.add(f.getNota3());
                conta.add(f.getNota4());
                num = num + 4;
            }
        }
        
        int valor = 0;
        
        try {
            for (String n : conta){
                switch (n) {
                    case "I":
                        valor = valor + 4;
                        break;
                    case "R":
                        valor = valor + 6;
                        break;
                    case "B":
                        valor = valor + 8;
                        break;
                    case "O":
                        valor = valor + 10;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e){
            
        }
        
        double media = valor / num;
        
        if (media<5){
            return "I";
        } else if (media < 7){
            return "R";
        } else if (media < 9) {
            return "B";
        } else {
            return "O";
        }
    }
    
    public String mediaEsteAno(List<NotasFaltas> nf, String materia){
        int num = 0;
        List<String> conta = new ArrayList<>();
        for (NotasFaltas f: nf){
            if (f.getMateria().equals(materia) && f.getAno().equals("2018")){
                conta.add(f.getNota1());
                conta.add(f.getNota2());
                conta.add(f.getNota3());
                conta.add(f.getNota4());
                num = num + 4;
            }
        }
        
        int valor = 0;
        
        try {
            for (String n : conta){
                switch (n) {
                    case "I":
                        valor = valor + 4;
                        break;
                    case "R":
                        valor = valor + 6;
                        break;
                    case "B":
                        valor = valor + 8;
                        break;
                    case "O":
                        valor = valor + 10;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e){
            
        }
        
        double media = valor / num;
        
        if (media<5){
            return "I";
        } else if (media < 7){
            return "R";
        } else if (media < 9) {
            return "B";
        } else {
            return "O";
        }
    }
    
    public String mediaTurma(Turma t, String materia){
        int num = 0;
        List<String> conta = new ArrayList<>();
        for (Aluno a: t.getAlunos()){
            for (NotasFaltas f: a.getNotasFaltas()){
                if (f.getMateria().equals(materia) && f.getAno().equals("2018")){
                    conta.add(f.getNota1());
                    conta.add(f.getNota2());
                    conta.add(f.getNota3());
                    conta.add(f.getNota4());
                    num = num + 4;
                }
            }
        }
        
        int valor = 0;
        
        try {
            for (String n : conta){
                switch (n) {
                    case "I":
                        valor = valor + 4;
                        break;
                    case "R":
                        valor = valor + 6;
                        break;
                    case "B":
                        valor = valor + 8;
                        break;
                    case "O":
                        valor = valor + 10;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e){
            
        }
        
        double media = valor / num;
        
        if (media<5){
            return "I";
        } else if (media < 7){
            return "R";
        } else if (media < 9) {
            return "B";
        } else {
            return "O";
        }
    }
    
    public String faltas(List<NotasFaltas> nf, String materia){
        String faltas = "0";
        for (NotasFaltas f: nf){
            if (f.getMateria().equals(materia) && f.getAno().equals("2018")){
                faltas = f.getFaltas();
            }
        }
        
        return faltas;
    }
    
    public String mediaNotasFaltasTurma(Turma t, String materia){
        int num = 0;
        List<String> conta = new ArrayList<>();
        int faltas = 0;
        try {
            for (Aluno a: t.getAlunos()){
                for (NotasFaltas f: a.getNotasFaltas()){
                    if (f.getMateria().equals(materia) && f.getAno().equals("2018")){
                        conta.add(f.getNota1());
                        conta.add(f.getNota2());
                        conta.add(f.getNota3());
                        conta.add(f.getNota4());
                        num = num + 4;
                        try {
                            faltas = faltas + Integer.parseInt(f.getFaltas());
                        } catch (Exception e){

                        }
                    }
                }
            }
        } catch (NullPointerException e){
            
        }
        
        int valor = 0;
        
        try {
            for (String n : conta){
                switch (n) {
                    case "I":
                        valor = valor + 4;
                        break;
                    case "R":
                        valor = valor + 6;
                        break;
                    case "B":
                        valor = valor + 8;
                        break;
                    case "O":
                        valor = valor + 10;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e){
            
        }
        double media;
        try {
            media = valor / num;
        } catch (Exception e) {
            media = 0;
        }
        
        String mediaFaltas;
        
        try {
            mediaFaltas = String.valueOf(faltas / t.getAlunos().size());
        } catch (Exception e){
            mediaFaltas = "0";
        }
        
        if (media<5){
            return "I" + " / " + mediaFaltas + " faltas.";
        } else if (media < 7){
            return "R" + " / " + mediaFaltas + " faltas.";
        } else if (media < 9) {
            return "B" + " / " + mediaFaltas + " faltas.";
        } else {
            return "O" + " / " + mediaFaltas + " faltas.";
        }
    }
    
    public String numeroAlunosEscola(Escola e){
        AlunoDAO adao = new AlunoDAO();
        int alunos = 0;
        for (Aluno a: adao.buscaTodos()){
            if (a.getEscola().getId() == e.getId()){
                alunos++;
            }
        }
        
        return String.valueOf(alunos);
    }
    
    public String mediaAlunosSala(Escola e){
        TurmaDAO tdao = new TurmaDAO();
        int numAlunos = 0;
        int numSalas = 0;
        
        for (Turma t: tdao.buscaTodas()){
            if (t.getEscola().getId() == e.getId()){
                numSalas++;
                try {
                    numAlunos = numAlunos + t.getAlunos().size();
                } catch (Exception ex){

                }
            }
        }
        double media =(double) numAlunos / (double) numSalas;
        return String.valueOf(media);
    }
    
    public String alunosPortNeces(Escola e){
        AlunoDAO adao = new AlunoDAO();
        int numAlunos = 0;
        
        for (Aluno a: adao.buscaTodos()){
            if (a.getEscola().getId() == e.getId()){
                if (a.isNecesEspec()){
                    numAlunos++;
                }
            }
        }
        
        return String.valueOf(numAlunos);
    }
    
    public String alunosAcompanhantes(Escola e){
        AlunoDAO adao = new AlunoDAO();
        int numAlunos = 0;
        
        for (Aluno a: adao.buscaTodos()){
            if (a.getEscola().getId() == e.getId()){
                if (a.isNecesEspecAcomp()){
                    numAlunos++;
                }
            }
        }
        
        return String.valueOf(numAlunos);
    }
    
    public String alunosTranspPublico(Escola e){
        AlunoDAO adao = new AlunoDAO();
        int numAlunos = 0;
        
        for (Aluno a: adao.buscaTodos()){
            if (a.getEscola().getId() == e.getId()){
                if (a.isNecesEspec()){
                    numAlunos++;
                }
            }
        }
        
        return String.valueOf(numAlunos);
    }
}
