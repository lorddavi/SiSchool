/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.ConverteData;
import br.com.davi.sischool.funcoes.PreencheCombo;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.AlunoDAO;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.TurmaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFCriarTurmas extends javax.swing.JFrame {

    public JFCriarTurmas(){
        
    }
    /**
     * Creates new form JFCriarTurmas
     * @param login
     */
    public JFCriarTurmas(Login login) {
        initComponents();
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        preencheCombo.preencheEscolas(comboEscolas);
        esc = (Escola) comboEscolas.getSelectedItem();
        setaListeners();
        atualizarTabelaTurmas(buscaAtualizado());
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnAddTurma.addActionListener(oa);
        btnRemoverTurma.addActionListener(oa);
        btnSalvar.addActionListener(oa);
        btnEditar.addActionListener(oa);
        btnCancelar.addActionListener(oa);
        btnNovaTurma.addActionListener(oa);
        btnAvancarTurma.addActionListener(oa);
        comboEscolas.addItemListener(oi);
        tabelaTurmas.getSelectionModel().addListSelectionListener(ols);
    }
    
    private void estadoInicial(){
        comboEscolas.setEnabled(true);
        comboSerie.setEnabled(false);
        txtTurma.setEnabled(false);
        txtVagas.setEnabled(false);
        comboPeriodo.setEnabled(false);
        
        btnNovaTurma.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnAddTurma.setEnabled(false);
        btnRemoverTurma.setEnabled(false);
        btnAvancarTurma.setEnabled(false);
        btnEditar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }
    
    private Turma pegaTurma(){
        int linha = tabelaTurmas.getSelectedRow();
        return tmt.getTurma(linha);
    }
    
    private void editarTurma(){
        if (tabelaTurmas.getSelectedRow() != -1){
            edicao = true;
            apto = true;

            turmaEdita = pegaTurma();

            comboEscolas.setSelectedItem(turmaEdita.getEscola());
            comboPeriodo.setSelectedItem(turmaEdita.getPeriodo());
            comboSerie.setSelectedItem(turmaEdita.getTurma());
            txtTurma.setText(turmaEdita.getLetra());
            txtVagas.setText(String.valueOf(turmaEdita.getVagas()));

            comboEscolas.setEnabled(false);
            comboPeriodo.setEnabled(true);
            comboSerie.setEnabled(true);
            txtTurma.setEnabled(true);
            txtVagas.setEnabled(true);

            btnAddTurma.setEnabled(false);
            btnSalvar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnCancelar.setEnabled(true);
            btnNovaTurma.setEnabled(false);
            btnRemoverTurma.setEnabled(false);
            btnAvancarTurma.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Você precisa selecionar uma turma para editá-la.");
        }
    }
    
    private void defineCamposEditar(){
        int vagas = Integer.parseInt(txtVagas.getText());
        
        turmaEdita.setTurma(comboSerie.getSelectedItem().toString());
        turmaEdita.setLetra(txtTurma.getText());
        turmaEdita.setVagas(vagas);
        turmaEdita.setPeriodo(comboPeriodo.getSelectedItem().toString());
    }
    
    public void cancelar(){
        apto = false;
        tabelaTurmas.clearSelection();
        
        txtTurma.setText("");
        txtVagas.setText("");
        
        estadoInicial();
        turma = new Turma();
        if (edicao){
            turmaEdita = null;
            edicao = false;
            System.out.println("edicao");
        } else if (exclusao){
            try{
                comboEscolas.setSelectedItem(turmaExclui.getEscola());
                exclusao = false;
                turmaExclui = new Turma();
                System.out.println("exclusao");
            } catch (Exception e){
                
            }
        } else {
            
        }
        atualizarTabelaTurmas(buscaAtualizado());
    }
   
    private void avancarTurma(){
        Turma t = pegaTurma();
        AlunoDAO adao = new AlunoDAO();
        TurmaDAO tdao = new TurmaDAO();
        
        try {
            if (!t.getTurma().substring(0, 1).equals("5")){
                JOptionPane.showMessageDialog(this, "Essa turma ainda não completou o Fundamental Ciclo I");
            } else {
                for (Aluno a: t.getAlunos()){
                    if (a.isAprovado()){
                        a.setAtivo(false);
                        a.setSerie(null);
                        a.setEscola(null);

                        adao.editar(a);
                    }
                }

                JOptionPane.showMessageDialog(this, "Turma editada com sucesso.");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Não foi possível avançar a turma.");
        }
        
    }
    
    private void novaTurma(){
        tabelaTurmas.clearSelection();
        
        comboEscolas.setEnabled(true);
        comboPeriodo.setEnabled(true);
        comboSerie.setEnabled(true);
        txtTurma.setEnabled(true);
        txtVagas.setEnabled(true);
        
        btnAddTurma.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnNovaTurma.setEnabled(false);
        btnRemoverTurma.setEnabled(false);
       
    }
    
    private boolean verificaCampos(){
        if (!txtTurma.getText().trim().equals("") && !txtVagas.getText().trim().equals("")){
            return true;
        } else {
            return false;
        }
    }
    
    private void colocaTurmaNaLista(){
        Turma t = new Turma();
        if (verificaCampos()){
            int vagas = Integer.parseInt(txtVagas.getText());
            t.setEscola(esc);
            t.setTurma(comboSerie.getSelectedItem().toString());
            t.setLetra(txtTurma.getText());
            t.setVagas(vagas);
            t.setPeriodo(comboPeriodo.getSelectedItem().toString());
            turma = t;
            limpar();
            btnAddTurma.setEnabled(false);
            tmt.addTurma(t);
            apto = true;
        } else {
            JOptionPane.showMessageDialog(null, "Você não preencheu todos os campos"); //trocar isso aqui por um hint
        }
    }
    
    private void excluiTurmaDaLista(List<Turma> turmas){
        apto = true;
        exclusao = true;
        Turma t = pegaTurma();
        
        turmaExclui = t;
        turmas.remove(t);
        
        btnRemoverTurma.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNovaTurma.setEnabled(false);
        btnEditar.setEnabled(false);
        
        tabelaTurmas.clearSelection();
    }
    
    private void limpar(){
        txtTurma.setText("");
        txtVagas.setText("");
    }
    
    private void atualizarTabelaTurmas(List<Turma> turmas){
        TurmaDAO tdao = new TurmaDAO();
        List<Turma> lista = new ArrayList<>();
        
        for (Turma t: turmas){
            lista.add(tdao.buscarId(t.getId()));
        }
        tmt = new TableModelTurma(lista);
        tabelaTurmas.setModel(tmt);
    }

    private void salvar(){
        TurmaDAO tdao = new TurmaDAO();
        
        if (apto){
            if (edicao){
                defineCamposEditar();
                tdao.editar(turmaEdita);
                JOptionPane.showMessageDialog(this, "Turma editada!");
                limpar();
                edicao = false;
                cancelar();
            } else if (exclusao) {
                tdao.excluir(turmaExclui);
                JOptionPane.showMessageDialog(this, "Turma excluída!");
                exclusao = false;
                cancelar();
            } else {
                tdao.inserir(turma);
                JOptionPane.showMessageDialog(this, "Turmas salvas!");
                limpar();
                cancelar();
            }
            atualizarTabelaTurmas(buscaAtualizado());
            tabelaTurmas.clearSelection();
            apto = false;
        } else {
            JOptionPane.showMessageDialog(this, "Não é possível salvar sem preencher todos os campos.");
        }
        
    }
    
    private List<Turma> buscaAtualizado(){
        TurmaDAO tdao = new TurmaDAO();
        List<Turma> turmas = new ArrayList<>();
            for (Turma t : tdao.buscaTodas()){
                if (t.getEscola().getId() == esc.getId()){
                    turmas.add(t);
                    //System.out.println(t);
                }
            }
        return turmas;
    }
    /**
     * Inicia todos os componentes. Gerado automaticamente pelo Swing e, portanto,
     * é imutável.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboEscolas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboSerie = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtTurma = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVagas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboPeriodo = new javax.swing.JComboBox<>();
        btnAddTurma = new javax.swing.JButton();
        btnRemoverTurma = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTurmas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNovaTurma = new javax.swing.JButton();
        btnAvancarTurma = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Turmas");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Escola:");

        comboEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Série:");

        comboSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Berçário I", "Berçário II", "Maternal I", "Maternal II", "Jardim I", "Jardim II", "1º Ano", "2º Ano", "3º Ano", "4º Ano", "5º Ano" }));
        comboSerie.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Turma:");

        txtTurma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTurma.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Vagas:");

        txtVagas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVagas.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Período:");

        comboPeriodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde" }));
        comboPeriodo.setEnabled(false);

        btnAddTurma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/adic.png"))); // NOI18N
        btnAddTurma.setContentAreaFilled(false);
        btnAddTurma.setEnabled(false);

        btnRemoverTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/minus.png"))); // NOI18N
        btnRemoverTurma.setContentAreaFilled(false);
        btnRemoverTurma.setEnabled(false);

        tabelaTurmas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaTurmas.setModel(tmt);
        jScrollPane3.setViewportView(tabelaTurmas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddTurma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoverTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboEscolas, javax.swing.GroupLayout.Alignment.TRAILING, 0, 351, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddTurma)
                    .addComponent(btnRemoverTurma)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaAlunos.setModel(tma);
        jScrollPane2.setViewportView(tabelaAlunos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnNovaTurma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovaTurma.setText("Nova Turma");

        btnAvancarTurma.setText("Avançar Turma");
        btnAvancarTurma.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNovaTurma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAvancarTurma)
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNovaTurma)
                    .addComponent(btnAvancarTurma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                new JFCriarTurmas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTurma;
    private javax.swing.JButton btnAvancarTurma;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNovaTurma;
    private javax.swing.JButton btnRemoverTurma;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Escola> comboEscolas;
    private javax.swing.JComboBox<String> comboPeriodo;
    private javax.swing.JComboBox<String> comboSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTable tabelaTurmas;
    private javax.swing.JTextField txtTurma;
    private javax.swing.JTextField txtVagas;
    // End of variables declaration//GEN-END:variables
    private Escola esc = new Escola();
    private Turma turma = new Turma();
    private OuvintesAction oa = new OuvintesAction();
    private OuvintesItems oi = new OuvintesItems();
    private OuvintesLista ols = new OuvintesLista();
    private PreencheCombo preencheCombo = new PreencheCombo();
    private TableModelAluno tma = new TableModelAluno();
    private TableModelTurma tmt = new TableModelTurma();
    private boolean edicao = false;
    private Turma turmaEdita = new Turma();
    private boolean exclusao = false;
    private Turma turmaExclui = new Turma();
    private boolean apto;
    
    class OuvintesAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnAddTurma){
                colocaTurmaNaLista();
            } else if  (ae.getSource() == btnRemoverTurma){
                excluiTurmaDaLista(esc.getTurmas());
                atualizarTabelaTurmas(esc.getTurmas());
            } else if (ae.getSource() == btnSalvar){
                salvar();
            } else if (ae.getSource() == btnEditar){
                editarTurma();
            } else if (ae.getSource() == btnCancelar){
                cancelar();
            } else if (ae.getSource() == btnNovaTurma){
                novaTurma();
            } else if (ae.getSource() == btnAvancarTurma){
                avancarTurma();
            }
        }
        
    }
    
    class OuvintesItems implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() == comboEscolas){
                tabelaTurmas.clearSelection();
                esc = (Escola) comboEscolas.getSelectedItem();
                atualizarTabelaTurmas(buscaAtualizado());
                cancelar();
                estadoInicial();
            }
        }
    }
    
    class OuvintesLista implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            btnRemoverTurma.setEnabled(true);
            int linha = tabelaTurmas.getSelectedRow();
            Turma t = tmt.getTurma(linha);
            try {
                tma = new TableModelAluno(t.getAlunos());
                tabelaAlunos.setModel(tma);
            } catch (Exception e){

            }
            if (!exclusao){
                btnEditar.setEnabled(true);
            }
        }
    }
    
    private class TableModelAluno extends AbstractTableModel {
        private List<Aluno> linhas;
        private String[] colunas = new String[] {"RA", "Nome", "Data de Nascimento"};
        private static final int RA = 0;
        private static final int NOME = 1;
        private static final int DATADENASCIMENTO = 2;
 
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
            case RA:
                return String.class;
            case NOME:
                return String.class;
            case DATADENASCIMENTO:
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
            Collections.sort(linhas, (Aluno a1, Aluno a2) -> a1.getNome().compareTo(a2.getNome()));
            Aluno a = linhas.get(rowIndex);
            ConverteData converteData = new ConverteData();
            switch (columnIndex) {
                case RA:
                    return a.getRa();
                case NOME:
                    return a.getNome();
                case DATADENASCIMENTO:
                    return converteData.converteDateParaString(a.getDataNasc());
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        public Aluno getAluno(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        public void addAluno(Aluno a) {
            linhas.add(a);
            int ultimoIndice = getRowCount() - 1;

            fireTableRowsInserted(ultimoIndice, ultimoIndice);
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
 
        public void limpar() {
            linhas.clear();
            fireTableDataChanged();
        }
    }
    
    private class TableModelTurma extends AbstractTableModel {
        private List<Turma> linhas;
        private String[] colunas = new String[] {"Turma", "Vagas totais", "Alunos"};
        private static final int TURMA = 0;
        private static final int VAGASTOTAIS = 1;
        private static final int ALUNOS = 2; 
 
        public TableModelTurma() {
            linhas = new ArrayList<>();
        }
 
        public TableModelTurma(List<Turma> lista) {
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
            case TURMA:
                return String.class;
            case VAGASTOTAIS:
                return Integer.class;
            case ALUNOS:
                return Integer.class;
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
            Collections.sort(linhas, (Turma t1, Turma t2) -> (t1.getTurma() + t1.getLetra()).compareTo(t2.getTurma() + t2.getLetra()));
            Turma t = linhas.get(rowIndex);
            switch (columnIndex) {
                case TURMA:
                    return t.getTurma() + " " + t.getLetra();
                case VAGASTOTAIS:
                    return t.getVagas();
                case ALUNOS:
                    try {
                        return t.getAlunos().size();
                    } catch (Exception e) {
                        return 0;
                    }
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        public Turma getTurma(int indiceLinha) {
            try {
                return linhas.get(indiceLinha);
            } catch (Exception e){
                return null;
            }
        }

        public void addTurma(Turma t) {
            linhas.add(t);
            int ultimoIndice = getRowCount() - 1;

            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        public void removeTurma(int indiceLinha) {
            linhas.remove(indiceLinha);

            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        public void addListaDeTurmas(List<Turma> turmas) {
            int indice = getRowCount();
            linhas.addAll(turmas);

            fireTableRowsInserted(indice, indice + turmas.size());
        }
 
        public void limpar() {
            linhas.clear();
            fireTableDataChanged();
        }
    }
}
