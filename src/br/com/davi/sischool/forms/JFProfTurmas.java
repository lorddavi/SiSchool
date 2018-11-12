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
import br.com.davi.sischool.model.Professor;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        btnAtribuir1.addActionListener(oa);
        btnAtribuir2.addActionListener(oa);
        btnRemover1.addActionListener(oa);
        btnRemover2.addActionListener(oa);
        comboEscola1.addItemListener(oi);
        comboEscola2.addItemListener(oi);
        comboTurma1.addItemListener(oi);
        comboTurma2.addItemListener(oi);
        checkEscola.addItemListener(oi);
        txtBusca1.addKeyListener(new OuvintesKey());
        txtBusca2.addKeyListener(new OuvintesKey());
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
    
    private void atualizaTabelaPebI(List<ProfessorPebI> prof){
        tmp1 = new TableModelPeb1(prof);
        tabelaPebI.setModel(tmp1);
    }
    
    private void atualizaTabelaPebII(List<ProfessorPebII> prof){
        tmp2 = new TableModelPeb2(prof);
        tabelaPebII.setModel(tmp2);
    }
    
    private boolean verificaTurmas(ProfessorPebI p, Turma turma){
        for (Turma t: p.getTurma()){
            if (t.getPeriodo().equals(turma.getPeriodo())){
                return false;
            }
        }
        return true;
    }
    
    private void salvarPebI(){
        int linha = tabelaPebI.getSelectedRow();
        ProfessorPebI prof = tmp1.getProf(linha);
        
        try {
            Escola esc = (Escola) comboEscola1.getSelectedItem();
            Turma t = (Turma) comboTurma1.getSelectedItem();
            String periodo = prof.getPeriodo();
            boolean mesmaEscola = false;
            
            for (Escola e: prof.getEscola()){
                if (e.getId() == esc.getId()){
                    mesmaEscola = true;
                }
            }
            
            if (prof.getTurma().size() == 2){
                JOptionPane.showMessageDialog(this, "Este professor já atingiu o limite de turmas às quais poderia ser designado.");
            } else {
                if (t.getProfPebI() == null){
                    if (t.getPeriodo().equals(periodo) || periodo.equals("Duplo")) {
                        if (verificaTurmas(prof, t)){
                            if (!mesmaEscola){
                                prof.getEscola().add(esc);
                            }
                            t.setProfPebI(prof);
                            preencheLabels(t);
                            pidao.editar(prof);
                            tdao.editar(t);
                            JOptionPane.showMessageDialog(this, "Turma atribuída com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(this, "O professor já possui uma turma no período designado!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "A turma selecionada não é no período designado para o professor!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Essa turma já tem um professor PEB I atribuído.");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Um erro ocorreu! Não foi possível atribuir.");
            e.printStackTrace();
        }
    }
    
    private void salvarPebII(){
        int linha = tabelaPebII.getSelectedRow();
        ProfessorPebII prof = tmp2.getProf(linha);
        Escola esc = (Escola) comboEscola2.getSelectedItem();
        Turma turma = (Turma) comboTurma2.getSelectedItem();
        boolean mesmaEscola = false;
        boolean mesmaTurma = false;
        boolean mesmaMateria = false;
        
        turmas = prof.getTurmas();
        
        int aulas = prof.getAulasAtribuidas();
        
        try {
            for (Escola e: prof.getEscola()){
                if (e.getId() == esc.getId()){
                    mesmaEscola = true;
                }
            }
            
            for (Turma t: prof.getTurmas()){
                if (t == turma){
                    mesmaTurma = true;
                }
            }
            
            for (ProfessorPebII p: turma.getProfPebII()){
                if (p.getEspecialidade().equals(prof.getEspecialidade())){
                    mesmaMateria = true;
                }
            }
            
            if (mesmaMateria){
                JOptionPane.showMessageDialog(this, "Essa turma já possui um professor atribuído para essa matéria.");
            } else if (mesmaTurma){
                JOptionPane.showMessageDialog(this, "Esse professor já dá aula para essa turma.");
            } else if (aulas==36){
                JOptionPane.showMessageDialog(this, "Esse professor já possui 36 turmas.");
            } else {                   
                aulas++;
                prof.setAulasAtribuidas(aulas);
                if (!mesmaEscola){
                  prof.getEscola().add(esc);
                }
                turma.getProfPebII().add(prof);
                prof.getTurmas().add(turma);
                preencheLabels(turma);
                piidao.editar(prof);
                JOptionPane.showMessageDialog(this, "Turma atribuída com sucesso!");
            }
                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Um erro ocorreu! Não foi possível atribuir.");
            e.printStackTrace();
        }
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
        
        try{
            for (ProfessorPebII p: t.getProfPebII()){
                switch (p.getEspecialidade()) {
                    case "Artes":
                        partes = p;
                        break;
                    case "Inglês":
                        pingles = p;
                        break;
                    default:
                        ped = p;
                        break;
                }
            }
        } catch (NullPointerException e){
            
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
        checkEscola = new javax.swing.JCheckBox();
        panelComponentesPebI = new javax.swing.JPanel();
        PanelEscola = new javax.swing.JPanel();
        comboEscola1 = new javax.swing.JComboBox<>();
        panelTurma = new javax.swing.JPanel();
        comboTurma1 = new javax.swing.JComboBox<>();
        btnAtribuir1 = new javax.swing.JButton();
        btnRemover1 = new javax.swing.JButton();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblPebI = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblArtes = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblIngles = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblEducacaoFisica = new javax.swing.JLabel();
        btnRemover2 = new javax.swing.JButton();
        btnAtribuir2 = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Atribuição de turmas - PEB I e II");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 597, Short.MAX_VALUE)
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

        tabbedFundo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        panelPebI.setBackground(new java.awt.Color(204, 204, 204));

        panelTabelaProfPebI.setBackground(new java.awt.Color(204, 204, 204));

        tabelaPebI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar professor(a)");

        txtBusca1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        checkEscola.setText("Mostrar apenas professores da escola selecionada.");

        javax.swing.GroupLayout panelTabelaProfPebILayout = new javax.swing.GroupLayout(panelTabelaProfPebI);
        panelTabelaProfPebI.setLayout(panelTabelaProfPebILayout);
        panelTabelaProfPebILayout.setHorizontalGroup(
            panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaProfPebILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(panelTabelaProfPebILayout.createSequentialGroup()
                        .addGroup(panelTabelaProfPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkEscola)
                            .addComponent(jLabel1)
                            .addComponent(txtBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkEscola)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelComponentesPebI.setBackground(new java.awt.Color(204, 204, 204));

        PanelEscola.setBackground(new java.awt.Color(204, 204, 204));
        PanelEscola.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escola", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        comboEscola1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
        panelTurma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        comboTurma1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        btnAtribuir1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtribuir1.setText("Atribuir");

        btnRemover1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemover1.setText("Remover Atribuição");

        javax.swing.GroupLayout panelComponentesPebILayout = new javax.swing.GroupLayout(panelComponentesPebI);
        panelComponentesPebI.setLayout(panelComponentesPebILayout);
        panelComponentesPebILayout.setHorizontalGroup(
            panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelComponentesPebILayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnRemover1)
                        .addGap(39, 39, 39)
                        .addComponent(btnAtribuir1))
                    .addComponent(panelTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelComponentesPebILayout.setVerticalGroup(
            panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelComponentesPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtribuir1)
                    .addComponent(btnRemover1))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPebILayout = new javax.swing.GroupLayout(panelPebI);
        panelPebI.setLayout(panelPebILayout);
        panelPebILayout.setHorizontalGroup(
            panelPebILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPebILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelComponentesPebI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabelaProfPebI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        tabelaPebII.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaPebII.setModel(tmp2);
        jScrollPane2.setViewportView(tabelaPebII);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar professor(a)");

        javax.swing.GroupLayout panelTabelaProfPebIILayout = new javax.swing.GroupLayout(panelTabelaProfPebII);
        panelTabelaProfPebII.setLayout(panelTabelaProfPebIILayout);
        panelTabelaProfPebIILayout.setHorizontalGroup(
            panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaProfPebIILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(panelTabelaProfPebIILayout.createSequentialGroup()
                        .addGroup(panelTabelaProfPebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelComponentesPebI1.setBackground(new java.awt.Color(204, 204, 204));

        PanelEscola1.setBackground(new java.awt.Color(204, 204, 204));
        PanelEscola1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escola", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        javax.swing.GroupLayout PanelEscola1Layout = new javax.swing.GroupLayout(PanelEscola1);
        PanelEscola1.setLayout(PanelEscola1Layout);
        PanelEscola1Layout.setHorizontalGroup(
            PanelEscola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscola1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboEscola2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEscola1Layout.setVerticalGroup(
            PanelEscola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEscola1Layout.createSequentialGroup()
                .addComponent(comboEscola2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelTurma1.setBackground(new java.awt.Color(204, 204, 204));
        panelTurma1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Professor PEB I:");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        lblPebI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPebI.setText("jLabel9");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPebI, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblPebI))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Artes:");

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(84, 17));

        lblArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblArtes.setText("jLabel10");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArtes, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblArtes))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel6)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Inglês:");

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(84, 17));

        lblIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIngles.setText("jLabel11");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIngles, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblIngles))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel7)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Educação Física: ");

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(84, 17));

        lblEducacaoFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEducacaoFisica.setText("jLabel12");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEducacaoFisica, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEducacaoFisica))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel8)
        );

        javax.swing.GroupLayout panelTurma1Layout = new javax.swing.GroupLayout(panelTurma1);
        panelTurma1.setLayout(panelTurma1Layout);
        panelTurma1Layout.setHorizontalGroup(
            panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurma1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTurma1Layout.createSequentialGroup()
                        .addComponent(comboTurma2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelTurma1Layout.setVerticalGroup(
            panelTurma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurma1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTurma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRemover2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemover2.setText("Remover Atribuição");

        btnAtribuir2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtribuir2.setText("Atribuir");

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
                        .addGap(73, 73, 73)
                        .addComponent(btnRemover2)
                        .addGap(76, 76, 76)
                        .addComponent(btnAtribuir2)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelComponentesPebI1Layout.setVerticalGroup(
            panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesPebI1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEscola1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTurma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelComponentesPebI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover2)
                    .addComponent(btnAtribuir2))
                .addGap(0, 160, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
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
            .addComponent(tabbedFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
    private javax.swing.JButton btnAtribuir1;
    private javax.swing.JButton btnAtribuir2;
    private javax.swing.JButton btnFechar;
    private javax.swing.ButtonGroup btnGroupProfPeb;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnRemover1;
    private javax.swing.JButton btnRemover2;
    private javax.swing.JCheckBox checkEscola;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
            } else if (ae.getSource() == btnAtribuir1){
                salvarPebI();
            } else if (ae.getSource() == btnAtribuir2){
                salvarPebII();
            } else if (ae.getSource() == btnRemover1){
                
            } else if (ae.getSource() == btnRemover2){
                
            }
        }
    }
    
    private class OuvintesItems implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() == comboEscola1){
                checkEscola.setSelected(false);
                comboTurma1.removeAllItems();
                preencheCombos.preencheTurmas(comboTurma1, (Escola) comboEscola1.getSelectedItem());
            } else if (ie.getSource() == comboEscola2){
                comboTurma2.removeAllItems();
                preencheCombos.preencheTurmas(comboTurma2, (Escola) comboEscola2.getSelectedItem());
            } else if (ie.getSource() == comboTurma2){
                setaTabelas();
                preencheLabels((Turma) comboTurma2.getSelectedItem());
            } else if (ie.getSource()==checkEscola){
                if(ie.getStateChange()==ItemEvent.SELECTED){
                    txtBusca1.setEnabled(false);
                    Escola e = (Escola) comboEscola1.getSelectedItem();
                    List<ProfessorPebI> profs = new ArrayList<>();
                    for (Professor p: e.getProfessor()){
                        if (p.getCargo().equals("Professor PEB I")){
                            ProfessorPebI pi = pidao.buscarId(p.getId());
                            profs.add(pi);
                        }
                    }
                    atualizaTabelaPebI(profs);
                } else {
                    txtBusca1.setEnabled(true);
                    atualizaTabelaPebI(pidao.buscaTodos());
                }
            }
        }
    }
    
    private class OuvintesKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource()==txtBusca1){
                String busca = "%" + txtBusca1.getText() + "%";
                atualizaTabelaPebI(pidao.buscaPorNome(busca));
            } else if (ke.getSource() == txtBusca2){
                String busca = "%" + txtBusca2.getText() + "%";
                atualizaTabelaPebII(piidao.buscaPorNome(busca));
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
