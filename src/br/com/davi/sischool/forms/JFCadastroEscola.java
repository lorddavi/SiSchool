/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.CamposDeTelefone;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Telefone;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.OutroCargoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFCadastroEscola extends javax.swing.JFrame {

    /**
     * Creates new form JFTransferirAlunos
     */
    public JFCadastroEscola(){
        
    }
    
    public JFCadastroEscola(Login login) {
        oc = ocdao.buscarFunc(login.getFunc().getId());
        initComponents();
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        escolas = edao.buscaTodas();
        atualizaTabelaEscolas(escolas);
        setaListeners();
    }
    
    public void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnAddTel.addActionListener(oa);
        btnRemoveTel.addActionListener(oa);
        btnCancelar.addActionListener(oa);
        btnEditar.addActionListener(oa);
        btnSalvar.addActionListener(oa);
        btnExcluir.addActionListener(oa);
        btnNovaEscola.addActionListener(oa);
        txtBuscar.addKeyListener(new OuvintesKeyListener());
        tabelaEscolas.getSelectionModel().addListSelectionListener(new OuvintesListSelection());
    }
    
    private void buscaEscola(){
        String busca = "%" + txtBuscar.getText() + "%";
        escolas = edao.buscaPorNome(busca);
        atualizaTabelaEscolas(escolas);
    }
    
    private void atualizaTabelaEscolas(List<Escola> escolas){
        tme = new TableModelEscola(escolas);
        tabelaEscolas.setModel(tme);
    }
    
    private Escola selecionaEscola(){
        int linha = tabelaEscolas.getSelectedRow();
        return tme.getEscola(linha);
    }
    
    private void editarEscola(Escola esc){
        edicao = true;
        escola = esc;
        
        enablaTudo();
        
        nome = escola.getNome();
        endereco = escola.getEndereco();
        bairro = escola.getBairro();
        telef = escola.getTelefones();
        cep = escola.getCep();
        email = escola.getEmail();
        
        txtNomeCadEscola.setText(nome);
        txtEnderecoCadEscola.setText(endereco);
        txtBairroCadEscola.setText(bairro);
        txtFCep.setText(cep);
        txtEmail.setText(email);
        camposTelef.exibeTelefonesNoJList(listTelefone, telef);
        
        btnNovaEscola.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
    }
    
    private void situacaoInicial(){
        txtNomeCadEscola.setEnabled(false);
        txtEnderecoCadEscola.setEnabled(false);
        txtBairroCadEscola.setEnabled(false);
        txtTelefones.setEnabled(false);
        txtFCep.setEnabled(false);
        txtEmail.setEnabled(false);
        btnAddTel.setEnabled(false);
        btnRemoveTel.setEnabled(false);
        
        btnNovaEscola.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }
    
    private void enablaTudo(){
        txtNomeCadEscola.setEnabled(true);
        txtEnderecoCadEscola.setEnabled(true);
        txtBairroCadEscola.setEnabled(true);
        txtTelefones.setEnabled(true);
        txtFCep.setEnabled(true);
        txtEmail.setEnabled(true);
        btnAddTel.setEnabled(true);
        btnRemoveTel.setEnabled(true);
    }
    
    private void limpar(){
        nome = ""; endereco = ""; bairro = ""; email = ""; cep = "";
        edicao = false;
        escolas = new ArrayList<>();
        telef = new ArrayList<>();
        
        txtNomeCadEscola.setText("");
        txtEnderecoCadEscola.setText("");
        txtBairroCadEscola.setText("");
        txtTelefones.setText("");
        txtFCep.setText("");
        txtEmail.setText("");
        camposTelef.exibeTelefonesNoJList(listTelefone, telef);
    }
    
    private void cancelar(){
        tabelaEscolas.clearSelection();
        situacaoInicial();
        limpar();
    }
    
    private void novo(){
        enablaTudo();
        limpar();
        
        btnNovaEscola.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
    }
    
    private void excluirEscola(){
        Escola esc = selecionaEscola();
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                edao.excluir(esc);
                JOptionPane.showMessageDialog(this, "A exclusão foi efetuada com sucesso!");
                atualizaTabelaEscolas(edao.buscaTodas());
            } 
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Você precisa selecionar uma escola!");
            e.printStackTrace();
        } 
    }
    
    private boolean checaNaoPreenchido() {
        if (txtNomeCadEscola.getText().trim().equals("")){
            txtNomeCadEscola.requestFocus();
            return false;
        } else if (txtEnderecoCadEscola.getText().trim().equals("")) {
            txtEnderecoCadEscola.requestFocus();
            return false;
        } else if (txtBairroCadEscola.getText().trim().equals("")) {
            txtBairroCadEscola.requestFocus();
            return false;
       } else if (txtFCep.getText().trim().length()<7){
           txtFCep.requestFocus();
           return false;
       }
        return true;
    }
    
    private void defineEscola() {
        nome = txtNomeCadEscola.getText();
        endereco = txtEnderecoCadEscola.getText();
        bairro = txtBairroCadEscola.getText();
        cep = txtFCep.getText();
        email = txtEmail.getText();
       
        escola.setNome(nome);
        escola.setEndereco(endereco);
        escola.setBairro(bairro);
        escola.setCep(cep);
        escola.setEmail(email);
        escola.setTelefones(telef);
    }
    
    private void salvar() {
        boolean preenchido = checaNaoPreenchido();
        try {
            defineEscola();
            if (preenchido != true){
                JOptionPane.showMessageDialog(null, "Há campos em branco!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                if (edicao){
                    edao.editar(escola);
                    JOptionPane.showMessageDialog(this, "Dados alterados!");
                    edicao = false;
                } else {
                    edao.inserir(escola);
                    JOptionPane.showMessageDialog(this, "Sucesso!"); //PROCURAR FUTURAMENTE UM OPTION PANE ADEQUADO PRA MENSAGENS DE SUCESSO
                }
                tabelaEscolas.clearSelection();
                limpar();
                situacaoInicial();
            }
            escolas = edao.buscaTodas();
            atualizaTabelaEscolas(escolas);
        } catch  (Exception e) {

        }
    }
    /**
     * Inicia os componentes. Gerado automaticamente pelo swing e, portanto, 
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
        panelFundo = new javax.swing.JPanel();
        panelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCadEscola = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEnderecoCadEscola = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTelefone = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        txtBairroCadEscola = new javax.swing.JTextField();
        btnAddTel = new javax.swing.JButton();
        btnRemoveTel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtFCep = new javax.swing.JFormattedTextField();
        btnCancelar = new javax.swing.JButton();
        panelTabela = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEscolas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovaEscola = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Cadastrar nova escola");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        panelFundo.setBackground(new java.awt.Color(204, 204, 204));

        panelCadastro.setBackground(new java.awt.Color(204, 204, 204));
        panelCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        txtNomeCadEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNomeCadEscola.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Endereço:");

        txtEnderecoCadEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEnderecoCadEscola.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Telefones:");

        txtTelefones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTelefones.setEnabled(false);
        txtTelefones.setInputVerifier(new VerificadorDeTelefone());

        listTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listTelefone);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Bairro:");

        txtBairroCadEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBairroCadEscola.setEnabled(false);

        btnAddTel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/adic.png"))); // NOI18N
        btnAddTel.setContentAreaFilled(false);
        btnAddTel.setEnabled(false);

        btnRemoveTel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/minus.png"))); // NOI18N
        btnRemoveTel.setContentAreaFilled(false);
        btnRemoveTel.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("CEP:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("E-mail:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setEnabled(false);

        try {
            txtFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFCep.setEnabled(false);
        txtFCep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFCep.setInputVerifier(new VerificadorCEP());

        javax.swing.GroupLayout panelCadastroLayout = new javax.swing.GroupLayout(panelCadastro);
        panelCadastro.setLayout(panelCadastroLayout);
        panelCadastroLayout.setHorizontalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeCadEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtEnderecoCadEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(txtBairroCadEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGroup(panelCadastroLayout.createSequentialGroup()
                        .addComponent(txtTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddTel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveTel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        panelCadastroLayout.setVerticalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeCadEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEnderecoCadEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(txtBairroCadEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(txtFCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemoveTel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        panelTabela.setBackground(new java.awt.Color(204, 204, 204));

        tabelaEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaEscolas.setModel(tme);
        jScrollPane2.setViewportView(tabelaEscolas);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Buscar Escola:");

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscar.setToolTipText("Digite paraprocurar");

        javax.swing.GroupLayout panelTabelaLayout = new javax.swing.GroupLayout(panelTabela);
        panelTabela.setLayout(panelTabelaLayout);
        panelTabelaLayout.setHorizontalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addGroup(panelTabelaLayout.createSequentialGroup()
                        .addGroup(panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTabelaLayout.setVerticalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);

        btnNovaEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovaEscola.setText("Nova Escola");

        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFundoLayout.createSequentialGroup()
                        .addComponent(btnNovaEscola)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(8, 8, 8))
                    .addComponent(panelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFundoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnNovaEscola)
                    .addComponent(btnExcluir))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFTransferirAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFTransferirAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFTransferirAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFTransferirAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCadastroEscola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNovaEscola;
    private javax.swing.JButton btnRemoveTel;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JList<Telefone> listTelefone;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelCadastro;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabela;
    private javax.swing.JTable tabelaEscolas;
    private javax.swing.JTextField txtBairroCadEscola;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnderecoCadEscola;
    private javax.swing.JFormattedTextField txtFCep;
    private javax.swing.JTextField txtNomeCadEscola;
    private javax.swing.JTextField txtTelefones;
    // End of variables declaration//GEN-END:variables
    private OutroCargo oc = new OutroCargo();
    private OutroCargoDAO ocdao = new OutroCargoDAO();
    private OuvintesAction oa = new OuvintesAction();
    private Escola escola = new Escola();
    private EscolaDAO edao = new EscolaDAO();
    private List<Telefone> telef = new ArrayList<>();
    private CamposDeTelefone camposTelef = new CamposDeTelefone();
    private List<Escola> escolas = new ArrayList<>();
    private TableModelEscola tme = new TableModelEscola();
    private String nome, endereco, bairro, cep, email;
    private boolean edicao = false;
    
    private class OuvintesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnAddTel){
                camposTelef.colocaTelefoneNaLista(telef, txtTelefones);
                camposTelef.exibeTelefonesNoJList(listTelefone, telef);
            } else if (ae.getSource() == btnRemoveTel){
                camposTelef.excluiTelefoneDaLista(listTelefone, telef);
                camposTelef.exibeTelefonesNoJList(listTelefone, telef);
            } else if (ae.getSource() == btnCancelar){
                cancelar();
                edicao = false;
            } else if (ae.getSource() == btnEditar){
                editarEscola(selecionaEscola());
            } else if (ae.getSource() == btnSalvar){
                salvar();
            } else if (ae.getSource() == btnExcluir){
                excluirEscola();
            } else if (ae.getSource() == btnNovaEscola){
                novo();
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
            if (ke.getSource()==txtBuscar){
                buscaEscola();
            }
        }
        
    }
    
    private class OuvintesListSelection implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            btnEditar.setEnabled(true);
        }
    }
    
    class VerificadorDeTelefone extends InputVerifier {
	public VerificadorDeTelefone() {
        }
        
        @Override
	public boolean verify(JComponent jc) {
            txtTelefones = (JTextField) jc;
            String texto = txtTelefones.getText();

            try {
                if (texto.trim().length() == 0){
                    return(true);
		} 
                
                try {
                    long numero = Long.parseLong(texto);
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Digite apenas números!");
                    return false;
                }
                
                switch (texto.trim().length()) {
                    case 8: 
                        return true;
                    case 9:
                        return true;
                    case 10:
                        return true;
                    case 11:
                        return true;
                    default:
                        throw new IllegalArgumentException();
                }
                
            } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(null, "Telefone inválido");
		return (false);
            }
        }
    }    
    
    class VerificadorCEP extends InputVerifier {
	public VerificadorCEP() {
        }
        
        @Override
	public boolean verify(JComponent jc) {
            txtFCep = (JFormattedTextField) jc;
            String texto = txtFCep.getText();
           
            try {
                if (texto.trim().length() == 1){
                    return true;
		} 
                
                if (texto.trim().length() == 9){
                    return true;
                } else {
                    throw new IllegalArgumentException();
                }
                
            } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(null, "CEP inválido!");
		return (false);
            }
        }
    }    
    
    private class TableModelEscola extends AbstractTableModel {
        private List<Escola> linhas;
        private String[] colunas = new String[] {"Nome"};
        private static final int NOME = 0;
 
        public TableModelEscola() {
            linhas = new ArrayList<>();
        }
 
        public TableModelEscola(List<Escola> lista) {
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
            Collections.sort(linhas, (Escola e1, Escola e2) -> e1.getNome().compareTo(e2.getNome()));
            Escola e = linhas.get(rowIndex);
            
            switch (columnIndex) {
                case NOME:
                    return e.getNome();
                default:
                        throw new IndexOutOfBoundsException("columnIndex out of bounds");
                }
        }
        
        public Escola getEscola(int indiceLinha) {
            return linhas.get(indiceLinha);
        }
 
        public void removeEscola(int indiceLinha) {
            linhas.remove(indiceLinha);

            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        public void addListaDeEscolas(List<Escola> escolas) {
            int indice = getRowCount();
            linhas.addAll(escolas);

            fireTableRowsInserted(indice, indice + escolas.size());
        }
    }
}
