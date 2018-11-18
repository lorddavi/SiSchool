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
import br.com.davi.sischool.regras.TurmaDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        preencheTurmas();
        preencheProfs();
        setaListeners();
        tmnf = new TableModelNotasFaltas();
        tblNotasFaltas.setModel(tmnf);
        atualizaTabelaAlunos(adao.buscaTodos());
        txtMateria.setText("Matemática");
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnSalvar.addActionListener(oa);
        btnVoltaMateria.addActionListener(oa);
        btnProximaMateria.addActionListener(oa);
        btnSalvarHistorico.addActionListener(oa);
        comboProfs.addActionListener(oa);
        comboEscolas.addActionListener(oa);
        comboSerie.addActionListener(oa);
        btnOk.addActionListener(oa);
        tabelaAlunos.getSelectionModel().addListSelectionListener(new OuvintesListSelection());
        txtBuscaAluno.addKeyListener(new OuvintesKeyListener());
    }
    
    private void atualizaTabelaNotasFaltas(List<Aluno> alunos, int ne){
        tmnf = new TableModelNotasFaltas(alunos, ne);
        tblNotasFaltas.setModel(tmnf);
    }
    
    private void atualizaTabelaAlunos(List<Aluno> alunos){
        tma = new TableModelAluno(alunos);
        tabelaAlunos.setModel(tma);
    }
    
    private void atualizaTabelaHistorico(List<NotasFaltas> nf){
        tmh = new TableModelHistorico(nf);
        tabelaHistorico.setModel(tmh);
    }
    
    private Aluno alunoSelecionado(){
        int linha = tabelaAlunos.getSelectedRow();
        return tma.getAluno(linha);
    }
    
    private List<Aluno> listaAlunos(){
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            if (comboSerie.getSelectedIndex()>=0){
                Turma t = (Turma) comboSerie.getSelectedItem();
                if (!t.getAlunos().isEmpty()){
                    alunos = t.getAlunos();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return alunos;
    }
    
    private void preencheTurmas(){
        Escola e = (Escola) comboEscolas.getSelectedItem();
        
        try {
            switch (func.getCargo()) {
                case "Professor PEB I":
                    ProfessorPebI p1 = pidao.buscarId(func.getId());
                    for (Turma t: p1.getTurma()){
                        if (t.getEscola().getId() == e.getId()){
                            comboSerie.addItem(t);
                        }
                    }   break;
                case "Professor PEB II":
                    ProfessorPebII p2 = piidao.buscarId(func.getId());
                    for (Turma t: p2.getTurmas()){
                        if (t.getEscola().getId() == e.getId()){
                            comboSerie.addItem(t);
                        }
                    }   break;
                default:
                    TurmaDAO tdao = new TurmaDAO();
                    List<Turma> turmas = tdao.buscaPorEscola(e);
                    turmas.forEach((t) -> {
                        comboSerie.addItem(t);
                    });
                    break;
            }   
        } catch (Exception ex){
            System.out.println("Erro aqui na classe notasfaltas");
            ex.printStackTrace();
        }
    }
    
    private void preencheEscolas(){
        switch (func.getCargo()) {
            case "Professor PEB I":
                profPebI = pidao.buscarId(func.getId());
                if (profPebI.getEscola() != null){
                    for (Escola e: profPebI.getEscola()){
                        comboEscolas.addItem(e);
                    }
                }   
                break;
            case "Professor PEB II":
                profPebII = piidao.buscarId(func.getId());
                for (Escola e: profPebII.getEscola()){
                    comboEscolas.addItem(e);
                }   
                break;
            default:
                for (Escola e: edao.buscaTodas()){
                    if (e.getNome().substring(0, 4).trim().equals("CEI")){
                    } else {
                       comboEscolas.addItem(e);
            }
                }   
                break;   
        }
    }
    
    public void preencheProfs(){
        switch (func.getCargo()) {
            case "Professor PEB I":
                profPebI = pidao.buscarId(func.getId());
                comboProfs.addItem(profPebI);
                break;
            case "Professor PEB II":
                profPebII = piidao.buscarId(func.getId());
                comboProfs.addItem(profPebII);
                break;
            default:
                Escola es = (Escola) comboEscolas.getSelectedItem();
                Turma t = (Turma) comboSerie.getSelectedItem();
                for (Professor p: es.getProfessor()){
                    try {
                        if (p.getId() == t.getProfPebI().getId()){
                            comboProfs.addItem(p);
                        }
                    } catch (Exception e){
                        
                    }
                }   try {
                    for (ProfessorPebII p2 : t.getProfPebII()){
                        comboProfs.addItem(p2);
                    }
                } catch (Exception e){
                    
                }   break;
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
    
    private void verificaProfessor(){
        if (comboProfs.getItemCount() > 0){
            Professor p = (Professor) comboProfs.getSelectedItem();

            if (p.getCargo().equals("Professor PEB II")){
                ProfessorPebII p2 = piidao.buscarId(p.getId());
                switch (p2.getEspecialidade()){
                    case "Artes":
                        notasExibidas = 5;
                        break;
                    case "Inglês":
                        notasExibidas = 6;
                        break;
                    case "Educação Física":
                        notasExibidas = 7;
                        break;
                    default:
                        notasExibidas = 0;
                        break;
                }
                atualizaTabelaNotasFaltas(listaAlunos(), notasExibidas);
                preencheMateria();
                btnProximaMateria.setEnabled(false);
                btnVoltaMateria.setEnabled(false);
            } else if (p.getCargo().equals("Professor PEB I")){
                notasExibidas = 0;
                atualizaTabelaNotasFaltas(listaAlunos(), notasExibidas);
                preencheMateria();
                btnProximaMateria.setEnabled(true);
                btnVoltaMateria.setEnabled(true);
            }
        }
    }
    
    private void novasNotas(){
        String ano = txtAno.getText();
        String[] turmas = {"1º Ano", "2º Ano", "3º Ano", "4º Ano", "5º Ano"};
        String turma = alunoSelecionado().getSerie().toString().substring(0, 6);
        boolean temAno = false;
        boolean converte = false;

        try {
            if (ano.length()==4){
                Integer.parseInt(ano);
            }
            converte = true;
        } catch (Exception e){
            converte = false;
        }

        if (!converte){
            JOptionPane.showMessageDialog(null, "Ano inválido!");
        } else {
            Aluno a = alunoSelecionado();
            List<NotasFaltas> nf = new ArrayList<>();
            for (NotasFaltas n : a.getNotasFaltas()){
                if(n.getAno().equals(ano)){
                    temAno = true;
                    nf.add(n);
                }
            }

            if (temAno){
                atualizaTabelaHistorico(nf);
            } else {
                NotasFaltas n[] = new NotasFaltas[8];
                String materias[] =  {"Matemática", "Português", "Ciências", "História",
                "Geografia", "Artes", "Inglês", "Educação Física"};
                for (int i=0; i<8; i++){
                    n[i] = new NotasFaltas();
                    n[i].setAno(String.valueOf(ano));
                    n[i].setMateria(materias[i]);
                    n[i].setSituacao("Reprovado");
                    nf.add(n[i]);
                    a.getNotasFaltas().add(n[i]);
                }
                atualizaTabelaHistorico(nf);
            }

            try {

            int anoNovo = Integer.parseInt(anoAtual) - Integer.parseInt(ano);
            int num = 0;
            for (int i=0; i<turmas.length; i++){
                if (turmas[i].equals(turma)){
                    num = i;
                }
            }


                if (num != 0){
                    turma = turmas[num-anoNovo];
                    txtSerie.setText(turma);
                }
            } catch (Exception e){

            }

            if (txtAno.getText().trim().length() != 4){
                btnSalvarHistorico.setEnabled(false);
            } else {
                btnSalvarHistorico.setEnabled(true);
            }
        }
    }
    
    private void corDasSetas(){
        if (notasExibidas > 3){
            btnProximaMateria.setEnabled(false);
        } else if (notasExibidas == 0) {
            btnVoltaMateria.setEnabled(false);
        } else {
            btnProximaMateria.setEnabled(true);
            btnVoltaMateria.setEnabled(true);
        }
    }
    
    private void buscaAluno(String busca){
        if (radioNome.isSelected()){
            atualizaTabelaAlunos(adao.buscarPorNome(busca));
        } else if (radioRa.isSelected()){
            atualizaTabelaAlunos(adao.buscarUmPorRa(busca));
        }
    }
    
    private void proximaMateria(){
        if (notasExibidas<4){
            notasExibidas++;
            preencheMateria();
            corDasSetas();
            tmnf = new TableModelNotasFaltas(listaAlunos(), notasExibidas);
            tblNotasFaltas.setModel(tmnf);
        }
    }
    
    private void voltaMateria(){
        if (notasExibidas > 0){
            notasExibidas--;
            corDasSetas();
            preencheMateria();
            tmnf = new TableModelNotasFaltas(listaAlunos(), notasExibidas);
            tblNotasFaltas.setModel(tmnf);    
        }
    }
    
    private void atribuiNotas(){
        List<Aluno> lista = new ArrayList<>();
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

        radioGroupBusca = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedPaneNotasFaltas = new javax.swing.JTabbedPane();
        paneTabNotasAtual = new javax.swing.JPanel();
        panTabela = new javax.swing.JPanel();
        lblTurma = new javax.swing.JLabel();
        lblProf = new javax.swing.JLabel();
        jLabelM = new javax.swing.JLabel();
        comboEscolas = new javax.swing.JComboBox<>();
        comboProfs = new javax.swing.JComboBox<>();
        comboSerie = new javax.swing.JComboBox<>();
        btnVoltaMateria = new javax.swing.JButton();
        txtMateria = new javax.swing.JTextField();
        btnProximaMateria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotasFaltas = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        paneTabPreencherHistórico = new javax.swing.JPanel();
        panelFundoHistorico = new javax.swing.JPanel();
        panelBuscaAluno = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscaAluno = new javax.swing.JTextField();
        radioNome = new javax.swing.JRadioButton();
        radioRa = new javax.swing.JRadioButton();
        panelExibeHistorico = new javax.swing.JPanel();
        panelTabela = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaHistorico = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnSalvarHistorico = new javax.swing.JButton();

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

        lblTurma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTurma.setText("Série:");

        lblProf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProf.setText("Professor(a):");

        jLabelM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelM.setText("Matéria:");

        comboEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboProfs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnVoltaMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas2.png"))); // NOI18N
        btnVoltaMateria.setContentAreaFilled(false);
        btnVoltaMateria.setEnabled(false);

        txtMateria.setEditable(false);
        txtMateria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnProximaMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/setas.png"))); // NOI18N
        btnProximaMateria.setContentAreaFilled(false);

        tblNotasFaltas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNotasFaltas.setModel(tmnf);
        tblNotasFaltas.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tblNotasFaltas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNotasFaltas);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar Notas");

        javax.swing.GroupLayout panTabelaLayout = new javax.swing.GroupLayout(panTabela);
        panTabela.setLayout(panTabelaLayout);
        panTabelaLayout.setHorizontalGroup(
            panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTabelaLayout.createSequentialGroup()
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProf)
                            .addComponent(lblTurma))
                        .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panTabelaLayout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(230, 230, 230))
                            .addGroup(panTabelaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboProfs, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(panTabelaLayout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panTabelaLayout.setVerticalGroup(
            panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTurma)
                    .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProximaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelM, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProf)
                        .addComponent(comboProfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        javax.swing.GroupLayout paneTabNotasAtualLayout = new javax.swing.GroupLayout(paneTabNotasAtual);
        paneTabNotasAtual.setLayout(paneTabNotasAtualLayout);
        paneTabNotasAtualLayout.setHorizontalGroup(
            paneTabNotasAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 754, Short.MAX_VALUE)
        );
        paneTabNotasAtualLayout.setVerticalGroup(
            paneTabNotasAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPaneNotasFaltas.addTab("Ano atual", paneTabNotasAtual);

        paneTabPreencherHistórico.setBackground(new java.awt.Color(204, 204, 204));

        panelFundoHistorico.setBackground(new java.awt.Color(204, 204, 204));

        panelBuscaAluno.setBackground(new java.awt.Color(204, 204, 204));
        panelBuscaAluno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaAlunos.setModel(tma);
        jScrollPane2.setViewportView(tabelaAlunos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Aluno:");

        txtBuscaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        radioNome.setBackground(new java.awt.Color(204, 204, 204));
        radioGroupBusca.add(radioNome);
        radioNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioNome.setSelected(true);
        radioNome.setText("Nome");

        radioRa.setBackground(new java.awt.Color(204, 204, 204));
        radioGroupBusca.add(radioRa);
        radioRa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioRa.setText("RA");

        javax.swing.GroupLayout panelBuscaAlunoLayout = new javax.swing.GroupLayout(panelBuscaAluno);
        panelBuscaAluno.setLayout(panelBuscaAlunoLayout);
        panelBuscaAlunoLayout.setHorizontalGroup(
            panelBuscaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaAlunoLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(radioNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioRa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaAlunoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBuscaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaAlunoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaAlunoLayout.createSequentialGroup()
                        .addComponent(txtBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))))
        );
        panelBuscaAlunoLayout.setVerticalGroup(
            panelBuscaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioNome)
                    .addComponent(radioRa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelExibeHistorico.setBackground(new java.awt.Color(204, 204, 204));
        panelExibeHistorico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelTabela.setBackground(new java.awt.Color(204, 204, 204));

        tabelaHistorico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaHistorico.setModel(tmh);
        jScrollPane3.setViewportView(tabelaHistorico);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ano:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Série:");

        btnOk.setText("Ok");

        javax.swing.GroupLayout panelTabelaLayout = new javax.swing.GroupLayout(panelTabela);
        panelTabela.setLayout(panelTabelaLayout);
        panelTabelaLayout.setHorizontalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(panelTabelaLayout.createSequentialGroup()
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk))
                    .addComponent(jLabel3)
                    .addComponent(txtSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTabelaLayout.setVerticalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelExibeHistoricoLayout = new javax.swing.GroupLayout(panelExibeHistorico);
        panelExibeHistorico.setLayout(panelExibeHistoricoLayout);
        panelExibeHistoricoLayout.setHorizontalGroup(
            panelExibeHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExibeHistoricoLayout.createSequentialGroup()
                .addComponent(panelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelExibeHistoricoLayout.setVerticalGroup(
            panelExibeHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnSalvarHistorico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarHistorico.setText("Salvar Histórico");

        javax.swing.GroupLayout panelFundoHistoricoLayout = new javax.swing.GroupLayout(panelFundoHistorico);
        panelFundoHistorico.setLayout(panelFundoHistoricoLayout);
        panelFundoHistoricoLayout.setHorizontalGroup(
            panelFundoHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFundoHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBuscaAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelExibeHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panelFundoHistoricoLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(btnSalvarHistorico)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFundoHistoricoLayout.setVerticalGroup(
            panelFundoHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoHistoricoLayout.createSequentialGroup()
                .addComponent(panelBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelExibeHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnSalvarHistorico)
                .addContainerGap())
        );

        javax.swing.GroupLayout paneTabPreencherHistóricoLayout = new javax.swing.GroupLayout(paneTabPreencherHistórico);
        paneTabPreencherHistórico.setLayout(paneTabPreencherHistóricoLayout);
        paneTabPreencherHistóricoLayout.setHorizontalGroup(
            paneTabPreencherHistóricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundoHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paneTabPreencherHistóricoLayout.setVerticalGroup(
            paneTabPreencherHistóricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTabPreencherHistóricoLayout.createSequentialGroup()
                .addComponent(panelFundoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPaneNotasFaltas.addTab("Preencher histórico", paneTabPreencherHistórico);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(tabbedPaneNotasFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneNotasFaltas))
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
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnProximaMateria;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarHistorico;
    private javax.swing.JButton btnVoltaMateria;
    private javax.swing.JComboBox<Escola> comboEscolas;
    private javax.swing.JComboBox<Professor> comboProfs;
    private javax.swing.JComboBox<Turma> comboSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblProf;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel panTabela;
    private javax.swing.JPanel paneTabNotasAtual;
    private javax.swing.JPanel paneTabPreencherHistórico;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelBuscaAluno;
    private javax.swing.JPanel panelExibeHistorico;
    private javax.swing.JPanel panelFundoHistorico;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabela;
    private javax.swing.ButtonGroup radioGroupBusca;
    private javax.swing.JRadioButton radioNome;
    private javax.swing.JRadioButton radioRa;
    private javax.swing.JTabbedPane tabbedPaneNotasFaltas;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTable tabelaHistorico;
    private javax.swing.JTable tblNotasFaltas;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtBuscaAluno;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
    private Funcionario func = new Funcionario();
    private OutroCargo funcOutro = new OutroCargo();
    private ProfessorPebI profPebI = new ProfessorPebI();
    private ProfessorPebII profPebII = new ProfessorPebII();
    private EscolaDAO edao = new EscolaDAO();
    private AlunoDAO adao = new AlunoDAO();
    private ProfessorPebIDAO pidao = new ProfessorPebIDAO();
    private ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();
    private ProfessorDAO pdao = new ProfessorDAO();
    private OuvintesAction oa = new OuvintesAction();
    private int notasExibidas = 0;
    private TableModelNotasFaltas tmnf = new TableModelNotasFaltas();
    private TableModelAluno tma = new TableModelAluno();
    private TableModelHistorico tmh = new TableModelHistorico();
    private static final int MATEMATICA = 0;
    private static final int PORTUGUES = 1;
    private static final int CIENCIAS = 2;
    private static final int HISTORIA = 3;
    private static final int GEOGRAFIA = 4;
    private static final int ARTES = 5;
    private static final int INGLES = 6;
    private static final int EDUCACAOFISICA = 7;
    private Calendar calAnoAtual = Calendar.getInstance();  
    private String anoAtual = String.valueOf(calAnoAtual.get(Calendar.YEAR)); 

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
                comboSerie.removeAllItems();
                preencheTurmas();
            } else if (ae.getSource() == comboProfs){
                verificaProfessor();
                corDasSetas();
            } else if (ae.getSource() == comboSerie){
                if (comboSerie.getItemCount()!=0){
                    tmnf = new TableModelNotasFaltas(listaAlunos(), 0);
                    tblNotasFaltas.setModel(tmnf);
                }
                comboProfs.removeAllItems();
                preencheProfs();
            } else if (ae.getSource() == btnProximaMateria){
                proximaMateria();
            } else if (ae.getSource() == btnVoltaMateria){
                voltaMateria();
            } else if (ae.getSource() == btnSalvarHistorico){
                Aluno a = alunoSelecionado();
                String ano = txtAno.getText();
                List<NotasFaltas> nf = new ArrayList<>();
                
                try {
                    adao.editar(a);
                    JOptionPane.showMessageDialog(null, "Notas salvas com sucesso!");
                } catch (Exception e){
                  JOptionPane.showMessageDialog(null, "Não foi possível salvar as notas.");
                  e.printStackTrace();
                }
            } else if (ae.getSource() == btnOk){
                novasNotas();
            }
        }
    }
    
    private class OuvintesKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent ke) {
        }
        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            String busca = "%" + txtBuscaAluno.getText() + "%";
            buscaAluno(busca);
        }
    }
    
    private class OuvintesListSelection implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            List<NotasFaltas> nf = new ArrayList<>();
            
            if (tabelaAlunos.getSelectedRow() != -1){
                for (NotasFaltas n: alunoSelecionado().getNotasFaltas()){
                    if (n.getAno().equals(anoAtual)){
                        nf.add(n);
                    }
                }
                atualizaTabelaHistorico(nf);
                txtAno.setText(anoAtual);
                txtSerie.setText(alunoSelecionado().getSerie().toString());
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
            // Pega o objeto referente a linha especificada.0
            tblNotasFaltas.getColumnModel().getColumn(0).setPreferredWidth(200);
            Collections.sort(linhas, (Aluno a1, Aluno a2) -> a1.getNome().compareTo(a2.getNome()));
            Aluno a = linhas.get(rowIndex);
            List<NotasFaltas> nf = new ArrayList<>();
            
            for (NotasFaltas n: a.getNotasFaltas()){
                if (n.getAno().equals(anoAtual)){
                    nf.add(n);
                }
            }
            int m = -1;    
            
            switch (ne) {
                case MATEMATICA:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("Matemática")){
                            m = i;
                        }
                    }
                    break;
                case PORTUGUES:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("Português")){
                            m = i;
                        }
                    }
                    break;
                case CIENCIAS:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("Ciências")){
                            m = i;
                        }
                    }
                    break;
                case HISTORIA:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("História")){
                            m = i;
                        }
                    }
                    break;
                case GEOGRAFIA:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("Geografia")){
                            m = i;
                        }
                    }
                    break;
                case ARTES:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("Artes")){
                            m = i;
                        }
                    }
                    break;
                case INGLES:
                    for (int i=0; i<nf.size(); i++){
                        if (nf.get(i).getMateria().equals("Inglês")){
                            m = i;
                        }
                    }
                    break;
                case EDUCACAOFISICA:
                    for (int i=0; i<nf.size(); i++){
                            if (nf.get(i).getMateria().equals("Educação Física")){
                            m = i;
                        }
                    }
                    break;
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds"); 
            }
            try {
                nf.get(m).setSituacao(calculaMedia(a.getNotasFaltas().get(m)));
            } catch (Exception e){
            
            }
            switch (columnIndex) {
                case NOMEALUNO:
                    return a.getNome();
                case NOTAS1:
                    return nf.get(m).getNota1();
                case NOTAS2:
                    return nf.get(m).getNota2();
                case NOTAS3:
                    return nf.get(m).getNota3();
                case NOTAS4: 
                    return nf.get(m).getNota4();
                case FALTAS:
                    return nf.get(m).getFaltas();
                case SITUACAO:
                    return nf.get(m).getSituacao();
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
                            if (a.getNotasFaltas().get(i).getMateria().equals("Matemática") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case PORTUGUES:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Português") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case CIENCIAS:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Ciências") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case HISTORIA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("História") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case GEOGRAFIA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Geografia") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case ARTES:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Artes") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case INGLES:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                            if (a.getNotasFaltas().get(i).getMateria().equals("Inglês") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    case EDUCACAOFISICA:
                        for (int i=0; i<a.getNotasFaltas().size(); i++){
                                if (a.getNotasFaltas().get(i).getMateria().equals("Educação Física") && a.getNotasFaltas().get(i).getAno().equals(anoAtual)){
                                m = i;
                            }
                        }
                        break;
                    default:
                        throw new IndexOutOfBoundsException("columnIndex out of bounds"); 
                }   
            a.getNotasFaltas().get(m).setSituacao(calculaMedia(a.getNotasFaltas().get(m)));
            String valor;
            switch (columnIndex) {
                case NOMEALUNO:
                    break;
                case NOTAS1:
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        a.getNotasFaltas().get(m).setNota1((String) aValue);
                    }
                    break;
                case NOTAS2:
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        a.getNotasFaltas().get(m).setNota2((String) aValue);
                    }
                    break;
                case NOTAS3:
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        a.getNotasFaltas().get(m).setNota3((String) aValue);
                    }
                    break;
                case NOTAS4: 
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        a.getNotasFaltas().get(m).setNota4((String) aValue);
                    }
                    break;
                case FALTAS:
                    boolean converte = false;
                    valor = (String) aValue;
                    try {
                        Integer.parseInt(valor);
                        converte = true;
                    } catch (Exception e) {
                        converte = false;
                    }
                    if (converte){
                        a.getNotasFaltas().get(m).setFaltas((String) aValue);
                    }
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
    
    private class TableModelAluno extends AbstractTableModel {
        private List<Aluno> linhas;
        private String[] colunas = new String[] {"RA", "Nome"};
        private static final int RA = 0;
        private static final int NOME = 1;
 
        public TableModelAluno() {
            linhas = new ArrayList<>();
        }
 
        public TableModelAluno(List<Aluno> lista) {
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
            case NOME:
                return String.class;
            case RA:
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
            tabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(260);
            Collections.sort(linhas, (Aluno a1, Aluno a2) -> a1.getNome().compareTo(a2.getNome()));
            Aluno a = linhas.get(rowIndex);
            switch (columnIndex) {
                case NOME:
                    return a.getNome();
                case RA:
                    return a.getRa();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
                }
        }
        
        public Aluno getAluno(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        public void removeAluno(int indiceLinha) {
            linhas.remove(indiceLinha);

            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        public void addListaDeAlunos(List<Aluno> alunos) {
            int indice = getRowCount();
            linhas.addAll(alunos);

            fireTableRowsInserted(indice, indice + alunos.size());
        }
    }
    
    private class TableModelHistorico extends AbstractTableModel {
        // Lista de professores a serem exibidos na tabela
        private List<NotasFaltas> linhas;
        private String[] colunas = new String[] {"Matéria", "Notas 1º Bim", "Notas 2º Bim", "Notas 3º Bim", "Notas 4º Bim", "Faltas"};
        private static final int MATERIA = 0;
        private static final int NOTAS1 = 1;
        private static final int NOTAS2 = 2;
        private static final int NOTAS3 = 3;
        private static final int NOTAS4 = 4;
        private static final int FALTAS = 5;
 
        // Cria um TableModel sem nenhuma linha
        public TableModelHistorico() {
            linhas = new ArrayList<>();
        }
 
        // Cria um TableModel contendo a lista recebida por parâmetro
        public TableModelHistorico(List<NotasFaltas> lista) {
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
            case MATERIA:
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
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == MATERIA) {
                return false;
            } else {
              // if (linhas.get(rowIndex).getAno().equals(anoAtual)){
              //     return false;
               //} else {
                   return true;
              // }
               
            }
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Pega o objeto referente a linha especificada.
            Collections.sort(linhas, (NotasFaltas nf1, NotasFaltas nf2) -> nf1.getMateria().compareTo(nf2.getMateria()));
            NotasFaltas nf = linhas.get(rowIndex);
            
            switch (columnIndex) {
                case MATERIA:
                    return nf.getMateria();
                case NOTAS1:
                    return nf.getNota1();
                case NOTAS2:
                    return nf.getNota2();
                case NOTAS3:
                    return nf.getNota3();
                case NOTAS4: 
                    return nf.getNota4();
                case FALTAS:
                    return nf.getFaltas();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            // Pega o objeto referente a linha especificada.
            NotasFaltas nf = linhas.get(rowIndex);
            String valor;
            switch (columnIndex) {
                case MATERIA:
                    break;
                case NOTAS1:
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        nf.setNota1((String) aValue);
                    }
                    break;
                case NOTAS2:
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        nf.setNota2((String) aValue);
                    }
                    break;
                case NOTAS3:
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        nf.setNota3((String) aValue);
                    }
                    break;
                case NOTAS4: 
                    valor = (String) aValue;
                    if (valor.equals("R") || valor.equals("I") || valor.equals("B") | valor.equals("O")){
                        nf.setNota4((String) aValue);
                    }
                    break;
                case FALTAS:
                    boolean converte = false;
                    valor = (String) aValue;
                    try {
                        Integer.parseInt(valor);
                        converte = true;
                    } catch (Exception e) {
                        converte = false;
                    }
                    if (converte){
                        nf.setFaltas((String) aValue);
                    }
                    break;
                default:
                    // Não deve ocorrer, pois só existem 2 colunas
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
             // Notifica a atualização da célula
             fireTableCellUpdated(rowIndex, columnIndex);
        }
    
        // Retorna o objeto NotasFaltas referente a linha especificada
        public NotasFaltas getNotasFaltas(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        // Adiciona o objeto NotasFaltas especificado ao modelo
        public void addNotasFaltas(NotasFaltas nf) {
            // Adiciona o registro.
            linhas.add(nf);
 
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
        public void addListaDeNotasFaltas(List<NotasFaltas> nf) {
            // Pega o tamanho antigo da tabela, que servirá
            // como índice para o primeiro dos novos registros
            int indice = getRowCount();

            // Adiciona os registros.
            linhas.addAll(nf);

            // Notifica a mudança.
            fireTableRowsInserted(indice, indice + nf.size());
        }
 
        // Remove todos os registros.
        public void limpar() {
            // Remove todos os elementos da lista de certificados.
            linhas.clear();

            // Notifica a mudança.
            fireTableDataChanged();
        }
    }
}
