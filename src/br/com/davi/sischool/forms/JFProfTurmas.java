/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.PreencheCombo;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.regras.ProfessorPebIDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import br.com.davi.sischool.regras.TurmaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFProfTurmas extends javax.swing.JFrame {

    /**
     * Creates new form JFTransferirAlunos
     */
    public JFProfTurmas(){
        
    }
    
    public JFProfTurmas(Login login) {
        func = login.getFunc();
        initComponents();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        preencheCombos.preencheEscolas(comboEscola1);
        
        Escola e = (Escola) comboEscola1.getSelectedItem();

        preencheCombos.preencheEscolas(comboEscola2);
        
        Escola e2 = (Escola) comboEscola2.getSelectedItem();
        
        preencheCombos.preencheTurmas(comboTurma1, e);
        preencheCombos.preencheTurmas(comboTurma2, e2);
        setaListeners();
        setaTabelas();
        
        preencheLabels((Turma) comboTurma2.getSelectedItem());
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnSalvar1.addActionListener(oa);
        btnSalvar2.addActionListener(oa);
        comboEscola1.addItemListener(oi);
        comboEscola2.addItemListener(oi);
        comboTurma1.addItemListener(oi);
        comboTurma2.addItemListener(oi);
    }
 
    private void setaTabelas(){
        tabelaPebI.setModel(tmp1);
        tabelaPebII.setModel(tmp2);
    }
    
    private List<ProfessorPebI> listaProfs1(){
        return pidao.buscaTodos();
    }
    
    private List<ProfessorPebII> listaProfs2(){
        return piidao.buscaTodos();
    }
    
    private void salvarPebI(){
        int linha = tabelaPebI.getSelectedRow();
        TurmaDAO tdao = new TurmaDAO();
        ProfessorPebI prof = tmp1.getProf(linha);
        Escola esc = (Escola) comboEscola1.getSelectedItem();
        Turma t = (Turma) comboTurma1.getSelectedItem();
        escolas.add(esc);
        turmas.add(t);
        prof.setEscola(escolas);
        t.setProfPebI(prof);
        
        pidao.editar(prof);
        tdao.editar(t);
        JOptionPane.showMessageDialog(this, "Turma atribuída com sucesso!");
    }
    
    private void salvarPebII(){
        int linha = tabelaPebII.getSelectedRow();
        ProfessorPebII prof = tmp2.getProf(linha);
        Escola esc = (Escola) comboEscola2.getSelectedItem();
        Turma t = (Turma) comboTurma2.getSelectedItem();
        escolas = prof.getEscola();
        turmas = prof.getTurmas();
        escolas.add(esc);
        turmas.add(t);
        int aulas = prof.getAulasAtribuidas();
        aulas++;
        prof.setAulasAtribuidas(aulas);
        prof.setEscola(escolas);
        prof.setTurmas(turmas);
        piidao.editar(prof);

        JOptionPane.showMessageDialog(this, "Turma atribuída com sucesso!");
    }
    
    public void verificaEscola(List<Escola> escola, Escola e){
        for (int i=0; i<escola.size(); i++){
            if (escola.get(i) != e){
                escola.add(e);
            }
        }
    }
    
    public void verificaTurma(List<Turma> turma, Turma t){
        for (int i=0; i<turma.size(); i++){
            if (turma.get(i) != t){
                turma.add(t);
            }
        }
    }
    
    public void preencheLabels(Turma t){
        ProfessorPebII partes = new ProfessorPebII();
        ProfessorPebII pingles = new ProfessorPebII();
        ProfessorPebII ped = new ProfessorPebII();
        
        for (ProfessorPebII p: t.getProfPebII()){
            if (p.getEspecialidade().equals("Artes")){
                partes = p;
            } else if (p.getEspecialidade().equals("Inglês")){
                pingles = p;
            } else {
                ped = p;
            }
        }
        try {
            lblPebI.setText(t.getProfPebI().getNome());
        } catch(Exception e) {
            lblPebI.setText("");
        }
        
        try {
            lblArtes.setText(partes.getNome());
        } catch(Exception e) {
            lblArtes.setText("");
        }
        
        try {
            lblIngles.setText(pingles.getNome());
        } catch(Exception e) {
            lblIngles.setText("");
        }
        
        try {
            lblEducacaoFisica.setText(ped.getNome());
        } catch(Exception e) {
            lblEducacaoFisica.setText("");
        }
    }
    /**
     * Inicia os componentes automaticamente. Criado pelo swing e, portanto, é
     * imutável.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupProfPeb = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedFundo = new javax.swing.JTabbedPane();
        panelPebI = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelTabelaProfPebI = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPebI = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusca1 = new javax.swing.JTextField();
        panelComponentesPebI = new javax.swing.JPanel();
        PanelEscola = new javax.swing.JPanel();
        comboEscola1 = new javax.swing.JComboBox<>();
        panelTurma = new javax.swing.JPanel();
        comboTurma1 = new javax.swing.JComboBox<>();
        btnCancelar1 = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();
        panelPebII = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelTabelaProfPebII = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPebII = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBusca2 = new javax.swing.JTextField();
        panelComponentesPebI1 = new javax.swing.JPanel();
        PanelEscola1 = new javax.swing.JPanel();
        comboEscola2 = new javax.swing.JComboBox<>();
        panelTurma1 = new javax.swing.JPanel();
        comboTurma2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPebI = new javax.swing.JLabel();
        lblArtes = new javax.swing.JLabel();
        lblIngles = new javax.swing.JLabel();
        lblEducacaoFisica = new javax.swing.JLabel();
        btnCancelar2 = new javax.swing.JButton();
        btnSalvar2 = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Atribuição de turmas - PEB I");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        panelPebI.setBackground(new java.awt.Color(204, 204, 204));

        panelTabelaProfPebI.setBackground(new java.awt.Color(204, 204, 204));

        tabelaPebI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaPebI);

        jLabel1.setText("Buscar professor(a)");

        javax.swing.GroupLayout panelTabelaProfPebILayout = new javax.swing.GroupLayout(panelTabelaProfPebI);
        panelTabelaProfPebI.setLayout(panelTabelaProfPebILayout);
        panelTabelaProfPebILayout.setHorizontalGroup(
            panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaProfPebILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(panelTabelaProfPebILayout.createSequentialGroup()
                        .addGroup(panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTabelaProfPebILayout.setVerticalGroup(
            panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaProfPebILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(txtBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelComponentesPebI.setBackground(new java.awt.Color(204, 204, 204));

        PanelEscola.setBackground(new java.awt.Color(204, 204, 204));
        PanelEscola.setBorder(javax.swing.BorderFactory.createTitledBorder("Escola"));

        javax.swing.GroupLayout PanelEscolaLayout = new javax.swing.GroupLayout(PanelEscola);
        PanelEscola.setLayout(PanelEscolaLayout);
        PanelEscolaLayout.setHorizontalGroup(
            PanelEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboEscola1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        PanelEscolaLayout.setVerticalGroup(
            PanelEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboEscola1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelTurma.setBackground(new java.awt.Color(204, 204, 204));
        panelTurma.setBorder(javax.swing.BorderFactory.createTitledBorder("Turma"));

        javax.swing.GroupLayout panelTurmaLayout = new javax.swing.GroupLayout(panelTurma);
        panelTurma.setLayout(panelTurmaLayout);
        panelTurmaLayout.setHorizontalGroup(
            panelTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTurma1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelTurmaLayout.setVerticalGroup(
            panelTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTurma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnCancelar1.setText("Cancelar");

        btnSalvar1.setText("Salvar");

        javax.swing.GroupLayout panelComponentesPebILayout = new javax.swing.GroupLayout(panelComponentesPebI);
        panelComponentesPebI.setLayout(panelComponentesPebILayout);
        panelComponentesPebILayout.setHorizontalGroup(
            panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebILayout.createSequentialGroup()
                .addGroup(panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComponentesPebILayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelComponentesPebILayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnCancelar1)
                        .addGap(63, 63, 63)
                        .addComponent(btnSalvar1))
                    .addGroup(panelComponentesPebILayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelComponentesPebILayout.setVerticalGroup(
            panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar1)
                    .addComponent(btnCancelar1))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPebILayout = new javax.swing.GroupLayout(panelPebI);
        panelPebI.setLayout(panelPebILayout);
        panelPebILayout.setHorizontalGroup(
            panelPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPebILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelComponentesPebI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabelaProfPebI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPebILayout.setVerticalGroup(
            panelPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPebILayout.createSequentialGroup()
                .addGroup(panelPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPebILayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel4))
                    .addComponent(panelComponentesPebI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTabelaProfPebI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedFundo.addTab("Professores PEB I", panelPebI);

        panelPebII.setBackground(new java.awt.Color(204, 204, 204));

        panelTabelaProfPebII.setBackground(new java.awt.Color(204, 204, 204));

        tabelaPebII.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matrícula", "Nome", "Pontos", "Especialidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaPebII);
        if (tabelaPebII.getColumnModel().getColumnCount() > 0) {
            tabelaPebII.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabelaPebII.getColumnModel().getColumn(0).setHeaderValue("Matrícula");
            tabelaPebII.getColumnModel().getColumn(1).setResizable(false);
            tabelaPebII.getColumnModel().getColumn(1).setHeaderValue("Nome");
            tabelaPebII.getColumnModel().getColumn(2).setResizable(false);
            tabelaPebII.getColumnModel().getColumn(2).setHeaderValue("Pontos");
            tabelaPebII.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setText("Buscar professor(a)");

        javax.swing.GroupLayout panelTabelaProfPebIILayout = new javax.swing.GroupLayout(panelTabelaProfPebII);
        panelTabelaProfPebII.setLayout(panelTabelaProfPebIILayout);
        panelTabelaProfPebIILayout.setHorizontalGroup(
            panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaProfPebIILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(panelTabelaProfPebIILayout.createSequentialGroup()
                        .addGroup(panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTabelaProfPebIILayout.setVerticalGroup(
            panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaProfPebIILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(txtBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelComponentesPebI1.setBackground(new java.awt.Color(204, 204, 204));

        PanelEscola1.setBackground(new java.awt.Color(204, 204, 204));
        PanelEscola1.setBorder(javax.swing.BorderFactory.createTitledBorder("Escola"));

        javax.swing.GroupLayout PanelEscola1Layout = new javax.swing.GroupLayout(PanelEscola1);
        PanelEscola1.setLayout(PanelEscola1Layout);
        PanelEscola1Layout.setHorizontalGroup(
            PanelEscola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscola1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboEscola2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        PanelEscola1Layout.setVerticalGroup(
            PanelEscola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscola1Layout.createSequentialGroup()
                .addComponent(comboEscola2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelTurma1.setBackground(new java.awt.Color(204, 204, 204));
        panelTurma1.setBorder(javax.swing.BorderFactory.createTitledBorder("Turma"));

        jLabel3.setText("Professor PEB I:");

        jLabel6.setText("Artes:");

        jLabel7.setText("Inglês:");

        jLabel8.setText("Educação Física: ");

        lblPebI.setText("jLabel9");

        lblArtes.setText("jLabel10");

        lblIngles.setText("jLabel11");

        lblEducacaoFisica.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPebI)
                    .addComponent(lblArtes)
                    .addComponent(lblIngles)
                    .addComponent(lblEducacaoFisica))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblPebI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArtes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEducacaoFisica))
        );

        javax.swing.GroupLayout panelTurma1Layout = new javax.swing.GroupLayout(panelTurma1);
        panelTurma1.setLayout(panelTurma1Layout);
        panelTurma1Layout.setHorizontalGroup(
            panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurma1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTurma2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTurma1Layout.createSequentialGroup()
                        .addGroup(panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTurma1Layout.setVerticalGroup(
            panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurma1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTurma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTurma1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnCancelar2.setText("Cancelar");

        btnSalvar2.setText("Salvar");

        javax.swing.GroupLayout panelComponentesPebI1Layout = new javax.swing.GroupLayout(panelComponentesPebI1);
        panelComponentesPebI1.setLayout(panelComponentesPebI1Layout);
        panelComponentesPebI1Layout.setHorizontalGroup(
            panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebI1Layout.createSequentialGroup()
                .addGroup(panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComponentesPebI1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelEscola1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelTurma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelComponentesPebI1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnCancelar2)
                        .addGap(66, 66, 66)
                        .addComponent(btnSalvar2)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelComponentesPebI1Layout.setVerticalGroup(
            panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebI1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEscola1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTurma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar2)
                    .addComponent(btnSalvar2))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPebIILayout = new javax.swing.GroupLayout(panelPebII);
        panelPebII.setLayout(panelPebIILayout);
        panelPebIILayout.setHorizontalGroup(
            panelPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPebIILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelComponentesPebI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabelaProfPebII, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPebIILayout.setVerticalGroup(
            panelPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPebIILayout.createSequentialGroup()
                .addGroup(panelPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabelaProfPebII, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPebIILayout.createSequentialGroup()
                        .addGroup(panelPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPebIILayout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel5))
                            .addComponent(panelComponentesPebI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabbedFundo.addTab("Professores PEB II", panelPebII);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(tabbedFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                new JFProfTurmas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEscola;
    private javax.swing.JPanel PanelEscola1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnFechar;
    private javax.swing.ButtonGroup btnGroupProfPeb;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JButton btnSalvar2;
    private javax.swing.JComboBox<Escola> comboEscola1;
    private javax.swing.JComboBox<Escola> comboEscola2;
    private javax.swing.JComboBox<Turma> comboTurma1;
    private javax.swing.JComboBox<Turma> comboTurma2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArtes;
    private javax.swing.JLabel lblEducacaoFisica;
    private javax.swing.JLabel lblIngles;
    private javax.swing.JLabel lblPebI;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelComponentesPebI;
    private javax.swing.JPanel panelComponentesPebI1;
    private javax.swing.JPanel panelPebI;
    private javax.swing.JPanel panelPebII;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabelaProfPebI;
    private javax.swing.JPanel panelTabelaProfPebII;
    private javax.swing.JPanel panelTurma;
    private javax.swing.JPanel panelTurma1;
    private javax.swing.JTabbedPane tabbedFundo;
    private javax.swing.JTable tabelaPebI;
    private javax.swing.JTable tabelaPebII;
    private javax.swing.JTextField txtBusca1;
    private javax.swing.JTextField txtBusca2;
    // End of variables declaration//GEN-END:variables
    private Funcionario func = new Funcionario();
    private List<Escola> escolas = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private ProfessorPebIDAO pidao = new ProfessorPebIDAO();
    private ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();
    private PreencheCombo preencheCombos = new PreencheCombo();
    private TurmaDAO tdao = new TurmaDAO();
    private OuvintesAction oa = new OuvintesAction();
    private OuvintesItems oi = new OuvintesItems();
    private TableModelPeb1 tmp1 = new TableModelPeb1(listaProfs1());
    private TableModelPeb2 tmp2 = new TableModelPeb2(listaProfs2());
    
    private class OuvintesAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource()==btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnSalvar1){
                salvarPebI();
            } else if (ae.getSource() == btnSalvar2){
                salvarPebII();
            }
        }
    }
    
    private class OuvintesItems implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() == comboEscola1){
                comboTurma1.removeAllItems();
                preencheCombos.preencheTurmas(comboTurma1, (Escola) comboEscola1.getSelectedItem());
            } else if (ie.getSource() == comboEscola2){
                comboTurma2.removeAllItems();
                preencheCombos.preencheTurmas(comboTurma2, (Escola) comboEscola2.getSelectedItem());
            } else if (ie.getSource() == comboTurma2){
                setaTabelas();
                preencheLabels((Turma) comboTurma2.getSelectedItem());
            }
        }
    }
    
    private class TableModelPeb1 extends AbstractTableModel{
        // Lista de professores a serem exibidos na tabela
        private List<ProfessorPebI> linhas;
        private String[] colunas = new String[] {"CPF", "Nome", "Pontos"};
        private static final int MATRICULA = 0;
        private static final int NOME = 1;
        private static final int PONTOS = 2;

 
        // Cria um SocioTableModel sem nenhuma linha
        public TableModelPeb1() {
            linhas = new ArrayList<>();
        }
 
        // Cria um SocioTableModel contendo a lista recebida por parâmetro
        public TableModelPeb1(List<ProfessorPebI> listaProfs) {
            linhas = new ArrayList<>(listaProfs);
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
            case MATRICULA:
                return String.class;
            case NOME:
                return String.class;
            case PONTOS:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Pega o professor referente a linha especificada.
            Collections.sort(linhas, (ProfessorPebI p1, ProfessorPebI p2) -> {
                if (p1.getPontos() > p2.getPontos()) {
                    return -1;
                }
                if (p1.getPontos() < p2.getPontos()) {
                    return 1;
                }
                return 0;
            });
            ProfessorPebI prof = linhas.get(rowIndex);
            switch (columnIndex) {
                case MATRICULA:
                    return prof.getCpf();
                case NOME:
                    return prof.getNome();
                case PONTOS:
                    return prof.getPontos();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        // Retorna o professor referente a linha especificada
        public ProfessorPebI getProf(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        // Adiciona o professor especificado ao modelo
        public void addProf(ProfessorPebI prof) {
            // Adiciona o registro.
            linhas.add(prof);
 
            // Pega a quantidade de registros e subtrai 1 para
            // achar o último índice. A subtração é necessária
            // porque os índices começam em zero.
            int ultimoIndice = getRowCount() - 1;

            // Notifica a mudança.
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        // Remove o sócio da linha especificada.
        public void removeProf(int indiceLinha) {
            // Remove o registro.
            linhas.remove(indiceLinha);

            // Notifica a mudança.
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        // Adiciona uma lista de sócios no final da lista.
        public void addListaDeProfessores(List<ProfessorPebI> profs) {
            // Pega o tamanho antigo da tabela, que servirá
            // como índice para o primeiro dos novos registros
            int indice = getRowCount();

            // Adiciona os registros.
            linhas.addAll(profs);

            // Notifica a mudança.
            fireTableRowsInserted(indice, indice + profs.size());
        }
 
        // Remove todos os registros.
        public void limpar() {
            // Remove todos os elementos da lista de sócios.
            linhas.clear();

            // Notifica a mudança.
            fireTableDataChanged();
        }
    }
    
    private class TableModelPeb2 extends AbstractTableModel{
        // Lista de professores a serem exibidos na tabela
        private List<ProfessorPebII> linhas;
        private String[] colunas = new String[] {"CPF", "Nome", "Pontos", "Especialidade"};
        private static final int MATRICULA = 0;
        private static final int NOME = 1;
        private static final int PONTOS = 2;
        private static final int ESPECIALIDADE = 3;
 
        // Cria um SocioTableModel sem nenhuma linha
        public TableModelPeb2() {
            linhas = new ArrayList<>();
        }
 
        // Cria um SocioTableModel contendo a lista recebida por parâmetro
        public TableModelPeb2(List<ProfessorPebII> listaProfs) {
            linhas = new ArrayList<>(listaProfs);
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
            case MATRICULA:
                return String.class;
            case NOME:
                return String.class;
            case PONTOS:
                return String.class;
            case ESPECIALIDADE:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Pega o professor referente a linha especificada.
            Collections.sort(linhas, (ProfessorPebII p1, ProfessorPebII p2) -> {
                if (p1.getPontos() > p2.getPontos()) {
                    return -1;
                }
                if (p1.getPontos() < p2.getPontos()) {
                    return 1;
                }
                return 0;
            });
            ProfessorPebII prof = linhas.get(rowIndex);
            switch (columnIndex) {
                case MATRICULA:
                    return prof.getCpf();
                case NOME:
                    return prof.getNome();
                case PONTOS:
                    return prof.getPontos();
                case ESPECIALIDADE: 
                    return prof.getEspecialidade();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        // Retorna o professor referente a linha especificada
        public ProfessorPebII getProf(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        // Adiciona o professor especificado ao modelo
        public void addProf(ProfessorPebII prof) {
            // Adiciona o registro.
            linhas.add(prof);
 
            // Pega a quantidade de registros e subtrai 1 para
            // achar o último índice. A subtração é necessária
            // porque os índices começam em zero.
            int ultimoIndice = getRowCount() - 1;

            // Notifica a mudança.
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        // Remove o sócio da linha especificada.
        public void removeProf(int indiceLinha) {
            // Remove o registro.
            linhas.remove(indiceLinha);

            // Notifica a mudança.
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        // Adiciona uma lista de sócios no final da lista.
        public void addListaDeProfessores(List<ProfessorPebII> profs) {
            // Pega o tamanho antigo da tabela, que servirá
            // como índice para o primeiro dos novos registros
            int indice = getRowCount();

            // Adiciona os registros.
            linhas.addAll(profs);

            // Notifica a mudança.
            fireTableRowsInserted(indice, indice + profs.size());
        }
 
        // Remove todos os registros.
        public void limpar() {
            // Remove todos os elementos da lista de sócios.
            linhas.clear();

            // Notifica a mudança.
            fireTableDataChanged();
        }
    }
}
