/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Professor;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.FuncionarioDAO;
import br.com.davi.sischool.regras.ProfessorDAO;
import br.com.davi.sischool.regras.ProfessorPebIDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi
 */
public class Tabela {
    private FuncionarioDAO fdao = new FuncionarioDAO();
    private ProfessorPebIDAO pebidao = new ProfessorPebIDAO();
    private ProfessorPebIIDAO pebiidao = new ProfessorPebIIDAO();
    
    public Tabela() {
    }
    
    /*
    * Preenche a tabela de notas e faltas, recebendo como parâmetro a tabela 
    * correspondente e uma lista de alunos a preencher a tabela. A primeira
    * coluna da tabela corresponde ao nome do aluno e as demais se alternam
    * entre notas e faltas, correspondendo aos 4 bimestres.
    */
        
    public void preencheTabelaTransferirAlunos(JTable table, List<Aluno> alunos) {
        try {
            DefaultTableModel model =(DefaultTableModel) table.getModel();
            model.setNumRows(0);
            table.setDefaultRenderer(Object.class, new CellRenderer());
            if (!alunos.isEmpty()) {
                for(int i=0; i<alunos.size(); i++) {
                    model.addRow(new Object[] { 
                        alunos.get(i).getNome(),
                        alunos.get(i).getRa(),
                        alunos.get(i).getSerie()
                    });
                }            
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    * Recebe uma tabela, uma linha e uma coluna como parâmetros, para retornar
    * como String o valor no local identificado.
    */
    private String buscaValorNaLinha(JTable tabela, int l, int c){
        String valor = (String) tabela.getValueAt(l, c);
        return valor;
    }
    
    public void preencheTabelaProfTurmasII(JTable table, List<Turma> turma,  ProfessorPebII prof) {
        try {
            DefaultTableModel model =(DefaultTableModel) table.getModel();
            model.setNumRows(0);
            table.setDefaultRenderer(Object.class, new CellRenderer());
            if (!turma.isEmpty()) {
                for(int i=0; i<turma.size(); i++) {
                    model.addRow(new Object[] { 
                        turma.get(i).getEscola().getNome(),
                        turma.get(i).getTurma() + " " + turma.get(i).getLetra(),
                        
                    });
                }            
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void preencheTabelaCadEscolas(JTable table, List<Escola> escolas){
        try {
            DefaultTableModel model =(DefaultTableModel) table.getModel();
            model.setNumRows(0);
            table.setDefaultRenderer(Escola.class, new CellRenderer());
            if (!escolas.isEmpty()) {
                for(int i=0; i<escolas.size(); i++) {
                    model.addRow(new Object[] { 
                        escolas.get(i).getId(),
                        escolas.get(i).getNome()
                    });
                }            
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
