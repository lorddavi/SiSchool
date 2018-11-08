/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.NotasFaltas;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Professor;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.AlunoDAO;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.ProfessorDAO;
import br.com.davi.sischool.regras.ProfessorPebIDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Davi
 */
public class JFNotasEFaltas extends javax.swing.JFrame {

    /**
     * Construtor padrão de um form JNotasEFaltas
     */
    private JFNotasEFaltas(){
        
    }
    
    /*
    * Construtor de um JNotasEFaltas que recebe um login como parâmetro.
    */
    public JFNotasEFaltas(Login login) {
        func = login.getFunc();
        initComponents();
        iniciarComponentes();
    }

    private void iniciarComponentes(){
        preencheEscolas();
        preencheProfs();
        preencheTurmas();
        setaListeners();
        tmnf.addListaDeNotasFaltas(listaAlunos());
        tblNotasFaltas.setModel(tmnf);
        txtMateria.setText("Matemática");
        tblNotasFaltas.setDefaultRenderer(Aluno.class, new CellRenderer());
        tblNotasFaltas.getColumnModel().getColumn(0).setPreferredWidth(200);
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnSalvar.addActionListener(oa);
        btnVoltaMateria.addActionListener(oa);
        btnProximaMateria.addActionListener(oa);
        comboProfs.addActionListener(oa);
        comboEscolas.addActionListener(oa);
        comboSerie.addActionListener(oa);
//        btnPreenche.addActionListener(oa);
    }
    
    private List<Aluno> listaAlunos(){
        Turma t = (Turma) comboSerie.getSelectedItem();
        if (t.getAlunos() != null){
            return t.getAlunos();
        } else {
            return null;
        }
    }
    
    private void preencheTurmas(){
        Professor p = new Professor();
        p = (Professor) comboProfs.getSelectedItem();
        
        try {
            if (p!=null){
                if (p.getCargo().equals("Professor PEB I")){
                    ProfessorPebI p1 = pidao.buscarId(p.getId());
                    for (Turma t: p1.getTurma()){
                            comboSerie.addItem(t);
                    }   
                } else {
                    ProfessorPebII p2 = piidao.buscarId(p.getId());
                    for (Turma t: p2.getTurmas()){
                            comboSerie.addItem(t);
                    }   
                }
            }
                    
        } catch (Exception e){
            System.out.println("Erro aqui na classe notasfaltas");
        }
    }
    
    private void preencheEscolas(){
        switch (func.getCargo()) {
            case "Professor PEB I":
                if (profPebI.getEscola() != null){
                    for (Escola e: profPebI.getEscola()){
                        comboEscolas.addItem(e);
                    }
                }   break;
            case "Professor PEB II":
                for (Escola e: profPebII.getEscola()){
                    comboEscolas.addItem(e);
                }   break;
            default:
                for (Escola e: edao.buscaTodas()){
                    comboEscolas.addItem(e);
                }   break;   
        }
    }
    
    public void preencheProfs(){
        if (func.getCargo().equals("Professor PEB I")){
            profPebI = pidao.buscarId(func.getId());
            comboProfs.addItem(profPebI);
        } else if (func.getCargo().equals("Professor PEB II")){
            profPebII = piidao.buscarId(func.getId());
            comboProfs.addItem(profPebII);
        } else {
            Escola es = (Escola) comboEscolas.getSelectedItem();
            for (Professor p: es.getProfessor()){
                comboProfs.addItem(p);
            }
        }
    }
    
    public void preencheMateria(){
        switch(notasExibidas){
            case MATEMATICA:
                txtMateria.setText("Matemática");
                break;
            case PORTUGUES:
                txtMateria.setText("Português");
                break;
            case CIENCIAS:
                txtMateria.setText("Ciências");
                break;
            case HISTORIA:
                txtMateria.setText("História");
                break;
            case GEOGRAFIA:
                txtMateria.setText("Geografia");
                break;
            case ARTES:
                txtMateria.setText("Artes");
                break;
            case INGLES:
                txtMateria.setText("Inglês");
                break;
            case EDUCACAOFISICA:
                txtMateria.setText("Ed. Física");
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds"); 
        }   
    }
    
    public void corDasSetas(){
        if (notasExibidas > 6){
            btnProximaMateria.setIcon((new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas3.png"))));
        } else if (notasExibidas == 0) {
            btnVoltaMateria.setIcon((new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas4.png"))));
        } else {
            btnProximaMateria.setIcon((new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas.png"))));
            btnVoltaMateria.setIcon((new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas2.png"))));
        }
    }
    
    private void atribuiNotas(){
        List<Aluno> lista = new ArrayList<>();
        AlunoDAO adao = new AlunoDAO();
        for (int i=0; i<tblNotasFaltas.getRowCount(); i++){
            lista.add(tmnf.getNotasFaltas(i));
        }
        for (Aluno a: lista){
            try {
                adao.editar(a);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Notas cadastradas com sucesso");
    }
    /**
     * Gerado automaticamente pelo Swing para inicializar os componentes. Não pode
     * ser alterado.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedPaneNotasFaltas = new javax.swing.JTabbedPane();
        paneTabNotasAtual = new javax.swing.JPanel();
        panTabela = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotasFaltas = new javax.swing.JTable();
        lblTurma = new javax.swing.JLabel();
        lblProf = new javax.swing.JLabel();
        jLabelM = new javax.swing.JLabel();
        comboEscolas = new javax.swing.JComboBox<>();
        comboProfs = new javax.swing.JComboBox<>();
        comboSerie = new javax.swing.JComboBox<>();
        btnVoltaMateria = new javax.swing.JButton();
        txtMateria = new javax.swing.JTextField();
        btnProximaMateria = new javax.swing.JButton();
        paneTabPreencherHistórico = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();

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

        lblTituloPrincipal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPrincipal.setText("SiSchool - Notas e Faltas");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblTituloPrincipal)
                    .addGroup(panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(407, 407, 407))
        );

        tabbedPaneNotasFaltas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        panTabela.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tblNotasFaltas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNotasFaltas.setModel(tmnf);
        tblNotasFaltas.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tblNotasFaltas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNotasFaltas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        lblTurma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTurma.setText("Série:");

        lblProf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProf.setText("Professor(a):");

        jLabelM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelM.setText("Matéria:");

        comboEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboProfs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnVoltaMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas4.png"))); // NOI18N
        btnVoltaMateria.setContentAreaFilled(false);

        txtMateria.setEditable(false);
        txtMateria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnProximaMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas.png"))); // NOI18N
        btnProximaMateria.setContentAreaFilled(false);

        javax.swing.GroupLayout panTabelaLayout = new javax.swing.GroupLayout(panTabela);
        panTabela.setLayout(panTabelaLayout);
        panTabelaLayout.setHorizontalGroup(
            panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panTabelaLayout.createSequentialGroup()
                        .addComponent(jLabelM)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProximaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProf)
                    .addComponent(lblTurma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProfs, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panTabelaLayout.setVerticalGroup(
            panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProf)
                    .addComponent(comboProfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panTabelaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProximaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoltaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelM, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTabelaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTurma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout paneTabNotasAtualLayout = new javax.swing.GroupLayout(paneTabNotasAtual);
        paneTabNotasAtual.setLayout(paneTabNotasAtualLayout);
        paneTabNotasAtualLayout.setHorizontalGroup(
            paneTabNotasAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTabNotasAtualLayout.createSequentialGroup()
                .addComponent(panTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneTabNotasAtualLayout.setVerticalGroup(
            paneTabNotasAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPaneNotasFaltas.addTab("Ano atual", paneTabNotasAtual);

        javax.swing.GroupLayout paneTabPreencherHistóricoLayout = new javax.swing.GroupLayout(paneTabPreencherHistórico);
        paneTabPreencherHistórico.setLayout(paneTabPreencherHistóricoLayout);
        paneTabPreencherHistóricoLayout.setHorizontalGroup(
            paneTabPreencherHistóricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        paneTabPreencherHistóricoLayout.setVerticalGroup(
            paneTabPreencherHistóricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        tabbedPaneNotasFaltas.addTab("Preencher histórico", paneTabPreencherHistórico);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar Notas");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(tabbedPaneNotasFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(331, 331, 331))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneNotasFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                new JFNotasEFaltas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnProximaMateria;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltaMateria;
    private javax.swing.JComboBox<Escola> comboEscolas;
    private javax.swing.JComboBox<Professor> comboProfs;
    private javax.swing.JComboBox<Turma> comboSerie;
    private javax.swing.JLabel jLabelM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProf;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel panTabela;
    private javax.swing.JPanel paneTabNotasAtual;
    private javax.swing.JPanel paneTabPreencherHistórico;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTabbedPane tabbedPaneNotasFaltas;
    private javax.swing.JTable tblNotasFaltas;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables
    private Funcionario func = new Funcionario();
    private OutroCargo funcOutro = new OutroCargo();
    private ProfessorPebI profPebI = new ProfessorPebI();
    private ProfessorPebII profPebII = new ProfessorPebII();
    private EscolaDAO edao = new EscolaDAO();
    private ProfessorPebIDAO pidao = new ProfessorPebIDAO();
    private ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();
    private ProfessorDAO pdao = new ProfessorDAO();
    private OuvintesAction oa = new OuvintesAction();
    private int notasExibidas = 0;
    private TableModelNotasFaltas tmnf = new TableModelNotasFaltas();
    private static final int MATEMATICA = 0;
    private static final int PORTUGUES = 1;
    private static final int CIENCIAS = 2;
    private static final int HISTORIA = 3;
    private static final int GEOGRAFIA = 4;
    private static final int ARTES = 5;
    private static final int INGLES = 6;
    private static final int EDUCACAOFISICA = 7;

    class OuvintesAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnSalvar){
                atribuiNotas();
            } else if (ae.getSource() == comboEscolas){
                comboProfs.removeAllItems();
                preencheProfs();
            } else if (ae.getSource() == comboProfs){
                comboSerie.removeAllItems();
                preencheTurmas();
            } else if (ae.getSource() == comboSerie){
                if (comboSerie.getItemCount()!=0){
                    tmnf = new TableModelNotasFaltas(listaAlunos(), 0);
                    tblNotasFaltas.setModel(tmnf);
                    tblNotasFaltas.getColumnModel().getColumn(0).setPreferredWidth(200);
                }
            } else if (ae.getSource() == btnProximaMateria){
                if (notasExibidas<7){
                    notasExibidas++;
                    preencheMateria();
                    corDasSetas();
                    tmnf = new TableModelNotasFaltas(listaAlunos(), notasExibidas);
                    tblNotasFaltas.setModel(tmnf);
                    tblNotasFaltas.getColumnModel().getColumn(0).setPreferredWidth(200);
                }
            } else if (ae.getSource() == btnVoltaMateria){
                if (notasExibidas > 0){
                    notasExibidas--;
                    corDasSetas();
                    preencheMateria();
                    tmnf = new TableModelNotasFaltas(listaAlunos(), notasExibidas);
                    tblNotasFaltas.setModel(tmnf);    
                    tblNotasFaltas.getColumnModel().getColumn(0).setPreferredWidth(200);
                }
//            } else if (ae.getSource() == btnPreenche){
                
            }
        }
    }
    
    private class TableModelNotasFaltas extends AbstractTableModel {
        // Lista de professores a serem exibidos na tabela
        private List<Aluno> linhas;
        private String[] colunas = new String[] {"Nome do aluno", "Notas 1º Bim", "Notas 2º Bim", "Notas 3º Bim", "Notas 4º Bim", "Faltas", "Situação"};
        private static final int NOMEALUNO = 0;
        private static final int NOTAS1 = 1;
        private static final int NOTAS2 = 2;
        private static final int NOTAS3 = 3;
        private static final int NOTAS4 = 4;
        private static final int FALTAS = 5;
        private static final int SITUACAO = 6;
        private int ne;
 
        // Cria um TableModel sem nenhuma linha
        public TableModelNotasFaltas() {
            linhas = new ArrayList<>();
        }
 
        // Cria um TableModel contendo a lista recebida por parâmetro
        public TableModelNotasFaltas(List<Aluno> lista, int ne) {
            this.ne = ne;
            linhas = new ArrayList<>(lista);
        }
        
        @Override
        public int getRowCount() {
            return linhas.size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }
        
        @Override
        public String getColumnName(int columnIndex) {
            return colunas[columnIndex];
        };
        
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
            case NOMEALUNO:
                return String.class;
            case NOTAS1:
                return String.class;
            case NOTAS2:
                return String.class;
            case NOTAS3:
                return String.class;
            case NOTAS4: 
                return String.class;
            case FALTAS:
                return String.class;
            case SITUACAO: 
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == NOMEALUNO) {
                return false;
            } else {
                return true;
            }
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Pega o objeto referente a linha especificada.
            Collections.sort(linhas, (Aluno a1, Aluno a2) -> a1.getNome().compareTo(a2.getNome()));
            Aluno a = linhas.get(rowIndex);
            int m = -1;    
            
            switch (ne) {
                case MATEMATICA:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("Matemática")){
                            m = i;
                        }
                    }
                    break;
                case PORTUGUES:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("Português")){
                            m = i;
                        }
                    }
                    break;
                case CIENCIAS:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("Ciências")){
                            m = i;
                        }
                    }
                    break;
                case HISTORIA:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("História")){
                            m = i;
                        }
                    }
                    break;
                case GEOGRAFIA:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("Geografia")){
                            m = i;
                        }
                    }
                    break;
                case ARTES:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("Artes")){
                            m = i;
                        }
                    }
                    break;
                case INGLES:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                        if (a.getNotasFaltas().get(i).getMateria().equals("Inglês")){
                            m = i;
                        }
                    }
                    break;
                case EDUCACAOFISICA:
                    for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Educação Física")){
                            m = i;
                        }
                    }
                    break;
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds"); 
            }   
            a.getNotasFaltas().get(m).setSituacao(calculaMedia(a.getNotasFaltas().get(m)));
            switch (columnIndex) {
                case NOMEALUNO:
                    return a.getNome();
                case NOTAS1:
                    return a.getNotasFaltas().get(m).getNota1();
                case NOTAS2:
                    return a.getNotasFaltas().get(m).getNota2();
                case NOTAS3:
                    return a.getNotasFaltas().get(m).getNota3();
                case NOTAS4: 
                    return a.getNotasFaltas().get(m).getNota4();
                case FALTAS:
                    return a.getNotasFaltas().get(m).getFaltas();
                case SITUACAO:
                    return a.getNotasFaltas().get(m).getSituacao();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        private int converte(String nota){
            try {
                if (nota.equals("I")){
                    return 3;
                } else if (nota.equals("R")){
                    return 5;
                } else if (nota.equals("B")){
                    return 8;
                } else if (nota.equals("O")){
                    return 10;
                } 
                return 0;
            } catch(Exception e){
                return 0;
            }
        }
        
        private String calculaMedia(NotasFaltas nf){
            int n1 = converte(nf.getNota1());
            int n2 = converte(nf.getNota2());
            int n3 = converte(nf.getNota3());
            int n4 = converte(nf.getNota4());
            
            double media = (n1 + n2 + n3 + n4) / 4;
            
            if (media>=5){
                return "Aprovado";
            } else {
                return "Reprovado";
            }
        }
        
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            // Pega o objeto referente a linha especificada.
            Aluno a = linhas.get(rowIndex);
                int m = -1;    

                switch (ne) {
                    case MATEMATICA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Matemática")){
                                m = i;
                            }
                        }
                        break;
                    case PORTUGUES:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Português")){
                                m = i;
                            }
                        }
                        break;
                    case CIENCIAS:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Ciências")){
                                m = i;
                            }
                        }
                        break;
                    case HISTORIA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("História")){
                                m = i;
                            }
                        }
                        break;
                    case GEOGRAFIA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Geografia")){
                                m = i;
                            }
                        }
                        break;
                    case ARTES:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Artes")){
                                m = i;
                            }
                        }
                        break;
                    case INGLES:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Inglês")){
                                m = i;
                            }
                        }
                        break;
                    case EDUCACAOFISICA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                                if (a.getNotasFaltas().get(i).getMateria().equals("Educação Física")){
                                m = i;
                            }
                        }
                        break;
                    default:
                        throw new IndexOutOfBoundsException("columnIndex out of bounds"); 
                }   
            a.getNotasFaltas().get(m).setSituacao(calculaMedia(a.getNotasFaltas().get(m)));
            switch (columnIndex) {
                case NOMEALUNO:
                    break;
                case NOTAS1:
                    a.getNotasFaltas().get(m).setNota1((String) aValue);
                    break;
                case NOTAS2:
                    a.getNotasFaltas().get(m).setNota2((String) aValue);
                    break;
                case NOTAS3:
                    a.getNotasFaltas().get(m).setNota3((String) aValue);
                    break;
                case NOTAS4: 
                    a.getNotasFaltas().get(m).setNota4((String) aValue);
                    break;
                case FALTAS:
                    a.getNotasFaltas().get(m).setFaltas((String) aValue);
                    break;
                case SITUACAO:
                    
                    break;
                default:
                    // Não deve ocorrer, pois só existem 2 colunas
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
             // Notifica a atualização da célula
             fireTableCellUpdated(rowIndex, columnIndex);
        }
    
        // Retorna o objeto NotasFaltas referente a linha especificada
        public Aluno getNotasFaltas(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        // Adiciona o objeto NotasFaltas especificado ao modelo
        public void addNotasFaltas(Aluno a) {
            // Adiciona o registro.
            linhas.add(a);
 
            // Pega a quantidade de registros e subtrai 1 para
            // achar o último índice. A subtração é necessária
            // porque os índices começam em zero.
            int ultimoIndice = getRowCount() - 1;

            // Notifica a mudança.
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        // Remove o sócio da linha especificada.
        public void removeNotasFaltas(int indiceLinha) {
            // Remove o registro.
            linhas.remove(indiceLinha);

            // Notifica a mudança.
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        // Adiciona uma lista de professores no final da lista.
        public void addListaDeNotasFaltas(List<Aluno> a) {
            // Pega o tamanho antigo da tabela, que servirá
            // como índice para o primeiro dos novos registros
            int indice = getRowCount();

            // Adiciona os registros.
            linhas.addAll(a);

            // Notifica a mudança.
            fireTableRowsInserted(indice, indice + a.size());
        }
 
        // Remove todos os registros.
        public void limpar() {
            // Remove todos os elementos da lista de certificados.
            linhas.clear();

            // Notifica a mudança.
            fireTableDataChanged();
        }
    }
    
    class CellRenderer extends DefaultTableCellRenderer {
        public CellRenderer(){
            super();
        }
    
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column != 0){
                this.setHorizontalAlignment(CENTER);
            } else {
                this.setHorizontalAlignment(LEFT);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
