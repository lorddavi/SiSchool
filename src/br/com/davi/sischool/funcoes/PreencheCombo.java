/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.FuncionarioDAO;
import br.com.davi.sischool.regras.ProfessorPebIDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import javax.swing.JComboBox;

/**
 *
 * @author Davi
 */
public final class PreencheCombo {
    EscolaDAO escDao = new EscolaDAO();
    FuncionarioDAO funcDao = new FuncionarioDAO();
    ProfessorPebIDAO pIDao = new ProfessorPebIDAO();
    ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();
    
    /*
    * Método construtor da classe.
    */
    public PreencheCombo() {
    }
   
    /*
    * Método que preenche o comboBox passado como parâmetro listando todas as 
    * escolas cadastradas no combo
    */
    public void preencheEscolas(JComboBox<Escola> combo){
        for(Escola e: escDao.buscaTodas()){
            combo.addItem(e);
        }
    }
    
    /*
    * Método que retornará a escola selecionada no comboBox passado como parâmetro.
    */
    public Escola pegaEscola(JComboBox<Escola> combo){
        return (Escola) combo.getSelectedItem();
    }
    
    /*
    * Método que preencherá o comboBox passado como parâmetro com as turmas 
    * cadastradas na escola passada como parâmetro.
    */
    public void preencheTurmas(JComboBox<Turma> combo, Escola e){
        for (Turma t: e.getTurmas()){
            combo.addItem(t);
        }
    }
    
    /*
    * Método que retornará a turma selecionada no comboBox passado como parâmetro
    */
    public Turma pegaTurma(JComboBox<Turma> combo){
        return (Turma) combo.getSelectedItem();
    }
    
    /*
     * Método que confere se o funcionário é professor PEB I ou II e preenche um
     * comboBox passado como parâmetro.
     */
    public void preencheProfsPebI(JComboBox<ProfessorPebI> combo){
        for (ProfessorPebI p: pIDao.buscaTodos()){
            combo.addItem(p);
        }
    }
    
    public void preencheProfsPebIComEscola(JComboBox<ProfessorPebI> combo, Escola e){
        for (ProfessorPebI p: pIDao.buscaEscola(e)){
                combo.addItem(p);
        }
    }
    
    public void preencheProfsPebII(JComboBox<ProfessorPebII> combo){
        for (ProfessorPebII p: piidao.buscaTodos()){
            combo.addItem(p);
        }
    }
    
    public void preencheProfsPebIIComEspecialidade(JComboBox<ProfessorPebII> combo, String especialidade){
        for (ProfessorPebII p: piidao.buscaEspecialidade(especialidade)){
                combo.addItem(p);
                System.out.println(p.getNome());
        }
    }
    
    public void preenchePeriodo(JComboBox combo, Turma t){
        if (t.getPeriodo().equals("Manhã")){
            combo.removeAllItems();
            combo.addItem("07h00");
            combo.addItem("07h50");
            combo.addItem("08h40");
            combo.addItem("09h50");
            combo.addItem("10h40");
        } else if (t.getPeriodo().equals("Tarde")){
            combo.removeAllItems();
            combo.addItem("12h30");
            combo.addItem("13h20");
            combo.addItem("14h10");
            combo.addItem("15h20");
            combo.addItem("16h10");
        }
    }
    
}
