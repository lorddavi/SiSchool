/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import br.com.davi.sischool.forms.JFAvisos;
import br.com.davi.sischool.forms.JFBackup;
import br.com.davi.sischool.forms.JFCadastrarAlunos;
import br.com.davi.sischool.forms.JFCadastrarFuncionario;
import br.com.davi.sischool.forms.JFCadastroEscola;
import br.com.davi.sischool.forms.JFConsultas;
import br.com.davi.sischool.forms.JFCriarTurmas;
import br.com.davi.sischool.forms.JFCronograma;
import br.com.davi.sischool.forms.JFDevCad;
import br.com.davi.sischool.forms.JFEstatisticas;
import br.com.davi.sischool.forms.JFLogin;
import br.com.davi.sischool.forms.JFNotasEFaltas;
import br.com.davi.sischool.forms.JFPrincipal;
import br.com.davi.sischool.forms.JFTransferirAlunos;
import br.com.davi.sischool.forms.JFProfTurmas;
import br.com.davi.sischool.forms.JFPontos;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.OutroCargo;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */

/**
* Explicação dos níveis de acesso:
* 0 = Professor.
* 1 = Funcionário administrativo da escola.
* 2 = Funcionário administrativo da secretaria da educação.
* 3 = Desenvolvedor.
*/
public class AbrirTelas {
    
    public AbrirTelas(){
        
    }
    
    public void abrirJFPrincipal(Login login){
        JFPrincipal jfp = new JFPrincipal(login);
        jfp.setVisible(true);
    }
    
    public void abrirJFEstatisticas(Login login){
        JFEstatisticas estatisticas = new JFEstatisticas(login);
        estatisticas.setVisible(true);
    }
    
    public void abrirJFCadastrarAlunos(Login login){
        if (nivelAcesso(login)>=1){
            JFCadastrarAlunos cadAluno = new JFCadastrarAlunos(login);
            cadAluno.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar alunos!");
        }
    }
    
    public void abrirJFCadastrarAlunosEdicao(OutroCargo oc, Aluno a){
        if (oc.getAcesso()>=1){
            JFCadastrarAlunos cadAluno = new JFCadastrarAlunos(oc, a);
            cadAluno.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar alunos!");
        }
    }
    
    public void abrirJFConsultas(Login login){
        JFConsultas consultas = new JFConsultas(login);
        consultas.setVisible(true);
    }
    
    public void abrirJFCadastrarFuncionarios(Login login){
        if(nivelAcesso(login) >= 1){
            JFCadastrarFuncionario cadFunc = new JFCadastrarFuncionario(login);
            cadFunc.setVisible(true);   
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar funcionários!");
        }
    }
    
    public void abrirJFCadastroEscola(Login login){
        if (nivelAcesso(login)>=2){
            JFCadastroEscola cadEsc = new JFCadastroEscola(login);
            cadEsc.setVisible(true);
        } else  {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar escolas!");
        }
    }
    
    public void abrirJFDevCad(Login login){
        if (nivelAcesso(login)==3){
            JFDevCad devCad = new JFDevCad(login);
            devCad.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                    + "usar o painel do desenvolvedor!");
        }
    }
    
    public void abrirJFLogin(Login login){
        JFLogin telaLogin = new JFLogin();
        telaLogin.setVisible(true);
    }
    
    public void abrirJFNotasEFaltas(Login login){
        JFNotasEFaltas notasEFaltas = new JFNotasEFaltas(login);
        notasEFaltas.setVisible(true);
    }
    
    public void abrirJFProfTurmas(Login login){
        if(nivelAcesso(login) >= 1){
            JFProfTurmas profTurmas = new JFProfTurmas(login);
            profTurmas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                    + "atribuir turmas a professores!");
        }
    }
    
    public void abrirJFTransferirAlunos(Login login){
        if(nivelAcesso(login) >= 2){
            JFTransferirAlunos transfAlunos = new JFTransferirAlunos(login);
            transfAlunos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                    + "transferir alunos!");
        }
    }
    
    public void abrirJFAvisos(Login login){
        if (nivelAcesso(login) >= 1) {
            JFAvisos avisos = new JFAvisos(login);
            avisos.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "ver os avisos.");
        }
    }
    
    public void abrirJFProfTurmasPebII(Login login){
        if (nivelAcesso(login) >= 1) {
            JFPontos telaProfPebII = new JFPontos(login);
            telaProfPebII.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "atribuir aulas.");
        }
    }
    
    public void abrirJFCronograma(Login login){
        if (nivelAcesso(login) >= 1) {
            JFCronograma crono = new JFCronograma(login);
            crono.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "abrir o cronograma.");
        }
    }
    
    public void abrirJFBackup(Login login){
        if (nivelAcesso(login) == 3) {
            JFBackup bac = new JFBackup(login);
            bac.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "realizar backup ou restauração de dados.");
        }
    }
    
    public void abrirJFCriarTurmas(Login login){
        if (nivelAcesso(login) >= 1) {
            JFCriarTurmas ct = new JFCriarTurmas(login);
            ct.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "criar turmas.");
        }
    }
    
    public int nivelAcesso(Login login){
        return login.getFunc().getAcesso();
    }
    
}
