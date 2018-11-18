/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.FazBackup;
import br.com.davi.sischool.json.JSONRead;
import br.com.davi.sischool.json.JSONWrite;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Certificado;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.NotasFaltas;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Telefone;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.AlunoDAO;
import br.com.davi.sischool.regras.CertificadoDAO;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.FuncionarioDAO;
import br.com.davi.sischool.regras.NotasFaltasDAO;
import br.com.davi.sischool.regras.OutroCargoDAO;
import br.com.davi.sischool.regras.ProfessorPebIDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import br.com.davi.sischool.regras.TelefoneDAO;
import br.com.davi.sischool.regras.TurmaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class JFBackup extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal
     */
    public JFBackup() {

    }
    
    public JFBackup(Login login){
        func = login.getFunc();
        initComponents();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        setaListeners();
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnBackup.addActionListener(oa);
        btnRestaura.addActionListener(oa);
    }
    
    private void gerarBackup(){
        int index = 0;
        
        for (Telefone t: teldao.buscaTodos()){
            jsonw.gerarJSONTelefone(t, index);
            index++;
        }
        index = 0;
        
        for (Escola e: edao.buscaTodas()){
            jsonw.gerarJSONEscola(e, index);
            index++;
        }
        index = 0;
        
        for (Turma t: tdao.buscaTodas()){
            jsonw.gerarJSONTurma(t, index);
            index++;
        }
        index = 0;
        
        for (ProfessorPebI p: pidao.buscaTodos()){
            jsonw.gerarJSONPebI(p, index);  
            index++;
        }
        index = 0;    

        for (ProfessorPebII p: piidao.buscaTodos()){
            jsonw.gerarJSONPebII(p, index);
            index++;
        }
        index = 0;
        
        for (OutroCargo oc: ocdao.buscaTodos()){
            jsonw.gerarJSONOutroCargo(oc, index);
            index++;
        }
        index = 0;

        for (Certificado c: cdao.buscaTodos()){
            jsonw.gerarJSONCertificado(c, index);
            index++;
        }
        index = 0;

        for (Aluno a: adao.buscaTodos()){
            jsonw.gerarJSONAluno(a, index);
            index++;
        }
        index = 0;
        
        for (NotasFaltas nf : nfdao.buscaTodos()){
            jsonw.gerarJSONNotasFaltas(nf, index);
            index++;
        }
        index = 0;
        
        FazBackup fb = new FazBackup();
        fb.backup();
        
    }
    
    private void restaurarBackup(){
        try {
            /*boolean possivel = true;
            int index = 0;
            while (possivel){
                try {
                    jsonr.lerJSONFuncionario(index);
                    index++;
                } catch (FileNotFoundException e){
                    possivel = false;
                } catch (IOException e){
                    possivel = false;
                }
            }*/
            
            FazBackup fb = new FazBackup();
            fb.restaurar();
            
        } catch (Exception ex) {
            Logger.getLogger(JFBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Código imutável gerado automaticamente pelo Netbeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        panelFundo = new javax.swing.JPanel();
        panelBackup = new javax.swing.JPanel();
        btnBackup = new javax.swing.JButton();
        btnRestaura = new javax.swing.JButton();
        checkAlunos = new javax.swing.JCheckBox();
        checkProfessores = new javax.swing.JCheckBox();
        checkFuncionarios = new javax.swing.JCheckBox();
        checkEscolas = new javax.swing.JCheckBox();
        lblfoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setExtendedState(NORMAL);
        setLocation(new java.awt.Point(0, 0));
        setName("framePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPrincipal.setName("panelPrincipal"); // NOI18N

        panelBarraDeTitulo.setBackground(new java.awt.Color(0, 0, 102));
        panelBarraDeTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/red.png"))); // NOI18N
        btnFechar.setContentAreaFilled(false);
        btnFechar.setName("btnFechar"); // NOI18N

        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("SiSchool - Backup e Restauração de dados");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelBarraDeTituloLayout.setVerticalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(407, 407, 407))
        );

        panelFundo.setBackground(new java.awt.Color(204, 204, 204));

        panelBackup.setBackground(new java.awt.Color(204, 204, 204));
        panelBackup.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fazer backup", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        btnBackup.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBackup.setText("Fazer Backup");

        btnRestaura.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRestaura.setText("Restaurar Backup");

        checkAlunos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        checkAlunos.setText("Alunos");

        checkProfessores.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        checkProfessores.setText("Professores");

        checkFuncionarios.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        checkFuncionarios.setText("Funcionários");

        checkEscolas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        checkEscolas.setText("Escolas");

        lblfoto.setText("jLabel1");

        javax.swing.GroupLayout panelBackupLayout = new javax.swing.GroupLayout(panelBackup);
        panelBackup.setLayout(panelBackupLayout);
        panelBackupLayout.setHorizontalGroup(
            panelBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackupLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnBackup)
                .addGap(51, 51, 51)
                .addComponent(btnRestaura)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackupLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblfoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkAlunos)
                    .addComponent(checkEscolas)
                    .addComponent(checkFuncionarios)
                    .addComponent(checkProfessores))
                .addGap(166, 166, 166))
        );
        panelBackupLayout.setVerticalGroup(
            panelBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackupLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkAlunos)
                    .addComponent(lblfoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkProfessores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkEscolas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackup)
                    .addComponent(btnRestaura))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFBackup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnRestaura;
    private javax.swing.JCheckBox checkAlunos;
    private javax.swing.JCheckBox checkEscolas;
    private javax.swing.JCheckBox checkFuncionarios;
    private javax.swing.JCheckBox checkProfessores;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JPanel panelBackup;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    private OuvintesAction oa = new OuvintesAction();
    private JSONWrite jsonw = new JSONWrite();
    private JSONRead jsonr = new JSONRead();
    private FuncionarioDAO fdao = new FuncionarioDAO();
    private ProfessorPebIDAO pidao = new ProfessorPebIDAO();
    private ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();
    private OutroCargoDAO ocdao = new OutroCargoDAO();
    private AlunoDAO adao = new AlunoDAO();
    private NotasFaltasDAO nfdao = new NotasFaltasDAO();
    private TelefoneDAO teldao = new TelefoneDAO();
    private CertificadoDAO cdao = new CertificadoDAO();
    private EscolaDAO edao = new EscolaDAO();
    private TurmaDAO tdao = new TurmaDAO();
    
    private Funcionario func = new Funcionario();
    
    private class OuvintesAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnBackup){
                gerarBackup();
            } else if (ae.getSource() == btnRestaura){
                restaurarBackup();
            }
        }
    
    }
}
