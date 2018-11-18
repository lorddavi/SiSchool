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
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
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
    JFPrincipal jfp;
    JFEstatisticas estatisticas;
    JFCadastrarAlunos cadAluno;
    JFConsultas consultas;
    JFCadastrarFuncionario cadFunc;
    JFCadastroEscola cadEsc;
    JFDevCad devCad;
    JFLogin telaLogin;
    JFNotasEFaltas notasEFaltas;
    JFProfTurmas profTurmas;
    JFTransferirAlunos transfAlunos;
    JFAvisos avisos;
    JFPontos telaPontos;
    JFCronograma crono;
    JFBackup bac;
    JFCriarTurmas ct;
            
    public AbrirTelas(){
        
    }
    
    private void setarIconeNoTitulo(JFrame frame, String titulo) {
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("../src/br/com/davi/sischool/icons/bandeja.png");
            frame.setIconImage(icon);
            frame.setTitle(titulo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void abrirJFPrincipal(Login login){
        if (jfp == null){
            jfp = new JFPrincipal(login);
            setarIconeNoTitulo(jfp, "SiSchool - Tela Principal");
        }            
        jfp.setVisible(true);
    }
    
    public void abrirJFEstatisticas(Login login){
        if (estatisticas == null){
            estatisticas = new JFEstatisticas(login);
            setarIconeNoTitulo(estatisticas, "SiSchool - Estatísticas");
        }
        estatisticas.setVisible(true);
    }
    
    public void abrirJFCadastrarAlunos(Login login){
        if (nivelAcesso(login)>=1){
            if (cadAluno == null){
                cadAluno = new JFCadastrarAlunos(login);
                setarIconeNoTitulo(cadAluno, "SiSchool - Cadastrar Alunos");
            }
            cadAluno.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar alunos!");
        }
    }
    
    public void abrirJFCadastrarAlunosEdicao(OutroCargo oc, Aluno a){
        if (oc.getAcesso()>=1){
            if (cadAluno == null){
                cadAluno = new JFCadastrarAlunos(oc, a);
                setarIconeNoTitulo(cadAluno, "SiSchool - Cadastrar Alunos");
            }
            cadAluno.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar alunos!");
        }
    }
    
    public void abrirJFConsultas(Login login){
        if (consultas == null){
            consultas = new JFConsultas(login);
            setarIconeNoTitulo(consultas, "SiSchool - Consultas");
        }
        consultas.setVisible(true);
    }
    
    public void abrirJFCadastrarFuncionarios(Login login){
        if(nivelAcesso(login) >= 1){
            if (cadFunc == null){
                cadFunc = new JFCadastrarFuncionario(login);
                setarIconeNoTitulo(cadFunc, "SiSchool - Cadastro de Funcionários");
            }
            cadFunc.setVisible(true);   
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar funcionários!");
        }
    }
    
    public void abrirJFCadastroEscola(Login login){
        if (nivelAcesso(login)>=2){
            if (cadEsc == null){
                cadEsc = new JFCadastroEscola(login);
                setarIconeNoTitulo(cadEsc, "SiSchool - Cadastro de Escolas");
            }
            cadEsc.setVisible(true);
        } else  {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite cadastrar escolas!");
        }
    }
    
    public void abrirJFDevCad(Login login){
        if (nivelAcesso(login)==3){
            if (devCad == null){
                devCad = new JFDevCad(login);
                setarIconeNoTitulo(devCad, "SiSchool - DevCad");
            }
            devCad.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                    + "usar o painel do desenvolvedor!");
        }
    }
    
    public void abrirJFLogin(Login login){
        if (telaLogin == null){
            telaLogin = new JFLogin();
            setarIconeNoTitulo(telaLogin, "SiSchool - Login");
        }
        telaLogin.setVisible(true);
    }
    
    public void abrirJFNotasEFaltas(Login login){
        if (notasEFaltas == null){
            notasEFaltas = new JFNotasEFaltas(login);
            setarIconeNoTitulo(notasEFaltas, "SiSchool - Notas e Faltas");
        }
        notasEFaltas.setVisible(true);
    }
    
    public void abrirJFProfTurmas(Login login){
        if(nivelAcesso(login) >= 1){
            if (profTurmas == null){
                profTurmas = new JFProfTurmas(login);
                setarIconeNoTitulo(profTurmas, "SiSchool - Atribuição de Turmas");
            }
            profTurmas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                    + "atribuir turmas a professores!");
        }
    }
    
    public void abrirJFTransferirAlunos(Login login){
        if(nivelAcesso(login) >= 1){
            if (transfAlunos == null){
                transfAlunos = new JFTransferirAlunos(login);
                setarIconeNoTitulo(transfAlunos, "SiSchool - Transferir Alunos");
            }
            transfAlunos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                    + "transferir alunos!");
        }
    }
    
    public void abrirJFAvisos(Login login){
        if (nivelAcesso(login) >= 1) {
            if (avisos == null){
                avisos = new JFAvisos(login);
                setarIconeNoTitulo(avisos, "SiSchool - Notificações");
            }
            avisos.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "ver as notificações.");
        }
    }
    
    public void abrirJFProfTurmasPebII(Login login){
        if (nivelAcesso(login) >= 1) {
            if (telaPontos == null){
                telaPontos = new JFPontos(login);
                setarIconeNoTitulo(telaPontos, "SiSchool - Certificados");
            }
            telaPontos.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "atribuir aulas.");
        }
    }
    
    public void abrirJFCronograma(Login login){
        if (nivelAcesso(login) >= 1) {
            if (crono == null){
                crono = new JFCronograma(login);
                setarIconeNoTitulo(crono, "SiSchool - Cronograma");
            }
            crono.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "abrir o cronograma.");
        }
    }
    
    public void abrirJFBackup(Login login){
        if (nivelAcesso(login) == 2) {
            if (bac == null){
                bac = new JFBackup(login);
                setarIconeNoTitulo(bac, "SiSchool - Backup");
            }
            bac.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(null, "Seu nível de acesso não te permite "
                        + "realizar backup ou restauração de dados.");
        }
    }
    
    public void abrirJFCriarTurmas(Login login){
        if (nivelAcesso(login) >= 1) {
            if (ct == null){
                ct = new JFCriarTurmas(login);
                setarIconeNoTitulo(ct, "SiSchool - Gestão de Turmas");
            }
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
