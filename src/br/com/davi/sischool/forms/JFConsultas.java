/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.AbrirTelas;
import br.com.davi.sischool.funcoes.CamposDeTelefone;
import br.com.davi.sischool.funcoes.ConverteData;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Telefone;
import br.com.davi.sischool.regras.AlunoDAO;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.FuncionarioDAO;
import br.com.davi.sischool.regras.OutroCargoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Davi
 */
public class JFConsultas extends javax.swing.JFrame {

    /**
     * Creates new form JFTransferirAlunos
     */
    
    public JFConsultas(){
        
    }
    
    public JFConsultas(Login login) {
        funcLogado = login.getFunc();
        initComponents();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        setaListeners();
        setaTabelas();
    }
    
    private void setaTabelas(){
        atualizaAlunos(adao.buscaTodos());
        atualizaEscolas(edao.buscaTodas());
        atualizaFuncionarios(fdao.buscaTodos());
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnEditar.addActionListener(oa);
        btnExcluir.addActionListener(oa);
        btnRelatorio.addActionListener(oa);
        tblConsultaAluno.getSelectionModel().addListSelectionListener(ols);
        tabelaEscolas.getSelectionModel().addListSelectionListener(ols);
        txtConsultaAluno.addKeyListener(okl);
        txtBuscarEscola.addKeyListener(okl);
        txtBuscaFuncionarios.addKeyListener(okl);
        tabbedConsultas.addChangeListener(ogl);
    }
    
    private void relatorioFichaAluno(){
        try {
	// Cria a fonte de dados
            int linha = tblConsultaAluno.getSelectedRow();
            List<Aluno> alunos = new ArrayList<>();
            JasperPrint print;
            if (linha != -1){
                Aluno a = tma.getAluno(linha);
                alunos.add(a);
        	JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(alunos);
                // Preenche o relatório
                print = JasperFillManager.fillReport("relatorios/FichaAluno.jasper", null, ds);
            } else {
                alunos = buscarAluno();
                JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(alunos);
                // Preenche o relatório
                print = JasperFillManager.fillReport("relatorios/Alunos.jasper", null, ds);
            }
	// Exibe o relatório
	    JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível preencher o relatório de Alunos.");
        }
    }
    
    private void relatorioFuncionarios(){
        try {
	// Cria a fonte de dados
            List<Funcionario> funcs = buscarFuncionario();
            if (buscarFuncionario().isEmpty()){
                funcs = fdao.buscaTodos();
            }
            Collections.sort(funcs, (Funcionario f1, Funcionario f2) -> f1.getNome().compareTo(f2.getNome()));
	    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(funcs);
	// Preenche o relatório
	    JasperPrint print = JasperFillManager.fillReport("relatorios/Funcionarios.jasper", null, ds);
	// Exibe o relatório
	    JasperViewer.viewReport(print, false);
        } catch (JRException e) {
                e.printStackTrace();
        }
    }
    
    private void relatorios(){
        switch (tabbedConsultas.getSelectedIndex()){
            case 0:
                relatorioFichaAluno();
                tblConsultaAluno.clearSelection();
                break;
            case 1:
                tabelaEscolas.clearSelection();
                break;
            case 2:
                relatorioFuncionarios();
                tabelaFuncionarios.clearSelection();
                break;
            default:
                break;
        }
    }
    
    public void atualizaAlunos(List<Aluno> alunos){
        tma = new TableModelAluno(alunos);
        tblConsultaAluno.setModel(tma);
    }
    
    public void atualizaEscolas(List<Escola> escolas){
        tme = new TableModelEscola(escolas);
        tabelaEscolas.setModel(tme);
    }
    
    public void atualizaFuncionarios(List<Funcionario> funcionarios){
        tmf = new TableModelFuncionario(funcionarios);
        tabelaFuncionarios.setModel(tmf);
    }
    
    private void preencheLista(Escola e){ 
        CamposDeTelefone cdt = new CamposDeTelefone();
        cdt.exibeTelefonesNoJList(jListTelefone, e.getTelefones());
    }

    private List<Aluno> buscarAluno() {
        try {
            List<Aluno> alunos = new ArrayList<>();
            String busca = '%' + txtConsultaAluno.getText() + '%';
            if (radioNomeConsultaAluno.isSelected()) {
                alunos = adao.buscarPorNome(busca);
            } else if (radioRaConsultaAluno.isSelected()){
                alunos = adao.buscarUmPorRa(busca);
            } 
           
            return alunos;
        } catch (Exception ex) {
            return adao.buscaTodos();
        }
    }
    
    private List<Escola> buscarEscola(){
        try {
            List<Escola> escolas = edao.buscaPorNome('%' + txtBuscarEscola.getText() + '%');
            return escolas;
        } catch (Exception e) {
            return edao.buscaTodas();
        }
    }
    
    private List<Funcionario> buscarFuncionario(){
        List<Funcionario> funcs = new ArrayList<>();
        try {
            String busca = "%" + txtBuscaFuncionarios.getText() + "%";
            if (radioNomeFunc.isSelected()){
                funcs = fdao.buscarPorNome(busca);
            } else if (radioCPFFunc.isSelected()) {
                funcs = fdao.buscarPorCPF(busca);
            } else if (radioCargoFunc.isSelected()){
                funcs = fdao.buscarPorCargo(busca);
            } 
            
            return funcs;
        } catch (Exception e) {
            return fdao.buscaTodos();
        }
    }
    
    private void editar(){
        AbrirTelas at = new AbrirTelas();
                
        int linha = tblConsultaAluno.getSelectedRow();
        if (linha != -1){
            Aluno a = tma.getAluno(linha);
            OutroCargo oc = new OutroCargo();
            OutroCargoDAO ocdao = new OutroCargoDAO();

            oc = ocdao.buscarFunc(funcLogado.getId());

            at.abrirJFCadastrarAlunosEdicao(oc, a);
        } else {
            JOptionPane.showMessageDialog(null, "Você precisa selecionar um aluno");
        }
    }
    
    private void excluirAluno(Aluno a){
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                adao.excluir(a);
                JOptionPane.showMessageDialog(this, "A exclusão foi efetuada com sucesso!");
                
                int linha = tblConsultaAluno.getSelectedRow();
                tma.removeAluno(linha);
            } 
            
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Você precisa selecionar um aluno");
        } 
    }
    
    private Aluno alunoSelecionado(){
        int linha = tblConsultaAluno.getSelectedRow();
        Aluno a = tma.getAluno(linha);
        return a;
    }
    
    /**
     * Cria os componentes. Gerado automaticamente. Não pode ser modificado.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAluno = new javax.swing.ButtonGroup();
        btnGroupFuncionario = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedConsultas = new javax.swing.JTabbedPane();
        tabAlunoConsultas = new javax.swing.JPanel();
        radioNomeConsultaAluno = new javax.swing.JRadioButton();
        radioRaConsultaAluno = new javax.swing.JRadioButton();
        txtConsultaAluno = new javax.swing.JTextField();
        scrolltabelaalunos = new javax.swing.JScrollPane();
        tblConsultaAluno = new javax.swing.JTable();
        tabConsultasEscola = new javax.swing.JPanel();
        scrollTabelaEscolas = new javax.swing.JScrollPane();
        tabelaEscolas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarEscola = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefone = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        tabFuncionarios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        txtBuscaFuncionarios = new javax.swing.JTextField();
        radioNomeFunc = new javax.swing.JRadioButton();
        radioCPFFunc = new javax.swing.JRadioButton();
        radioCargoFunc = new javax.swing.JRadioButton();
        btnExcluir = new javax.swing.JButton();
        btnEstatisticas = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        lblTituloPrincipal.setText("SiSchool - Consultas");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        tabbedConsultas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabbedConsultas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabAlunoConsultas.setBackground(new java.awt.Color(204, 204, 204));

        radioNomeConsultaAluno.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupAluno.add(radioNomeConsultaAluno);
        radioNomeConsultaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioNomeConsultaAluno.setSelected(true);
        radioNomeConsultaAluno.setText("Nome");

        radioRaConsultaAluno.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupAluno.add(radioRaConsultaAluno);
        radioRaConsultaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioRaConsultaAluno.setText("RA");

        txtConsultaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblConsultaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblConsultaAluno.setModel(tma);
        scrolltabelaalunos.setViewportView(tblConsultaAluno);

        javax.swing.GroupLayout tabAlunoConsultasLayout = new javax.swing.GroupLayout(tabAlunoConsultas);
        tabAlunoConsultas.setLayout(tabAlunoConsultasLayout);
        tabAlunoConsultasLayout.setHorizontalGroup(
            tabAlunoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAlunoConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabAlunoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrolltabelaalunos, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(tabAlunoConsultasLayout.createSequentialGroup()
                        .addGroup(tabAlunoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabAlunoConsultasLayout.createSequentialGroup()
                                .addComponent(radioNomeConsultaAluno)
                                .addGap(18, 18, 18)
                                .addComponent(radioRaConsultaAluno))
                            .addComponent(txtConsultaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabAlunoConsultasLayout.setVerticalGroup(
            tabAlunoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAlunoConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabAlunoConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNomeConsultaAluno)
                    .addComponent(radioRaConsultaAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsultaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrolltabelaalunos, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedConsultas.addTab("Alunos", tabAlunoConsultas);

        tabConsultasEscola.setBackground(new java.awt.Color(204, 204, 204));

        tabelaEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaEscolas.setModel(tme);
        scrollTabelaEscolas.setViewportView(tabelaEscolas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar escola:");

        txtBuscarEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jListTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jListTelefone);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Telefones:");

        javax.swing.GroupLayout tabConsultasEscolaLayout = new javax.swing.GroupLayout(tabConsultasEscola);
        tabConsultasEscola.setLayout(tabConsultasEscolaLayout);
        tabConsultasEscolaLayout.setHorizontalGroup(
            tabConsultasEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabConsultasEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabConsultasEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabConsultasEscolaLayout.createSequentialGroup()
                        .addComponent(scrollTabelaEscolas, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabConsultasEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(tabConsultasEscolaLayout.createSequentialGroup()
                        .addGroup(tabConsultasEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabConsultasEscolaLayout.setVerticalGroup(
            tabConsultasEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabConsultasEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(txtBuscarEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabConsultasEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabConsultasEscolaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 179, Short.MAX_VALUE))
                    .addComponent(scrollTabelaEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedConsultas.addTab("Escolas", tabConsultasEscola);

        tabFuncionarios.setBackground(new java.awt.Color(204, 204, 204));

        tabelaFuncionarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaFuncionarios.setModel(tmf);
        jScrollPane2.setViewportView(tabelaFuncionarios);

        txtBuscaFuncionarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGroupFuncionario.add(radioNomeFunc);
        radioNomeFunc.setSelected(true);
        radioNomeFunc.setText("Nome");

        btnGroupFuncionario.add(radioCPFFunc);
        radioCPFFunc.setText("CPF");

        btnGroupFuncionario.add(radioCargoFunc);
        radioCargoFunc.setText("Cargo");

        javax.swing.GroupLayout tabFuncionariosLayout = new javax.swing.GroupLayout(tabFuncionarios);
        tabFuncionarios.setLayout(tabFuncionariosLayout);
        tabFuncionariosLayout.setHorizontalGroup(
            tabFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(tabFuncionariosLayout.createSequentialGroup()
                        .addGroup(tabFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabFuncionariosLayout.createSequentialGroup()
                                .addComponent(radioNomeFunc)
                                .addGap(18, 18, 18)
                                .addComponent(radioCPFFunc)
                                .addGap(18, 18, 18)
                                .addComponent(radioCargoFunc))
                            .addComponent(txtBuscaFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabFuncionariosLayout.setVerticalGroup(
            tabFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNomeFunc)
                    .addComponent(radioCPFFunc)
                    .addComponent(radioCargoFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscaFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedConsultas.addTab("Funcionários", tabFuncionarios);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");

        btnEstatisticas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEstatisticas.setText("Estatísticas");

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar");

        btnRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRelatorio.setText("Relatório");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstatisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedConsultas))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEstatisticas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRelatorio)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEstatisticas;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.ButtonGroup btnGroupAluno;
    private javax.swing.ButtonGroup btnGroupFuncionario;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Telefone> jListTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioCPFFunc;
    private javax.swing.JRadioButton radioCargoFunc;
    private javax.swing.JRadioButton radioNomeConsultaAluno;
    private javax.swing.JRadioButton radioNomeFunc;
    private javax.swing.JRadioButton radioRaConsultaAluno;
    private javax.swing.JScrollPane scrollTabelaEscolas;
    private javax.swing.JScrollPane scrolltabelaalunos;
    private javax.swing.JPanel tabAlunoConsultas;
    private javax.swing.JPanel tabConsultasEscola;
    private javax.swing.JPanel tabFuncionarios;
    private javax.swing.JTabbedPane tabbedConsultas;
    private javax.swing.JTable tabelaEscolas;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTable tblConsultaAluno;
    private javax.swing.JTextField txtBuscaFuncionarios;
    private javax.swing.JTextField txtBuscarEscola;
    private javax.swing.JTextField txtConsultaAluno;
    // End of variables declaration//GEN-END:variables
    private OuvintesAction oa = new OuvintesAction();
    private Funcionario funcLogado = new Funcionario();
    private OuvintesListSelection ols = new OuvintesListSelection();
    private OuvintesKeyListener okl = new OuvintesKeyListener();
    private OuvintesChangeListener ogl = new OuvintesChangeListener();
    private TableModelAluno tma = new TableModelAluno();
    private TableModelEscola tme = new TableModelEscola();
    private TableModelFuncionario tmf = new TableModelFuncionario();
    private AlunoDAO adao = new AlunoDAO();
    private EscolaDAO edao = new EscolaDAO();
    private FuncionarioDAO fdao = new FuncionarioDAO();
    private ConverteData converteData = new ConverteData();

    class OuvintesAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == btnFechar){
                dispose();
            } else if (evt.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (evt.getSource() == btnEditar){
                editar();
            } else if (evt.getSource() == btnExcluir){
                excluirAluno(alunoSelecionado());
            } else if (evt.getSource() == btnRelatorio){
                relatorios();
            }
        }
    }
    
    class OuvintesListSelection implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (lse.getSource() == tabelaEscolas.getSelectionModel()){
                int linha = tabelaEscolas.getSelectedRow();
                Escola e = tme.getEscola(linha);
                preencheLista(e);
            }
        }
    }
    
    class OuvintesKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource()==txtBuscarEscola){
                atualizaEscolas(buscarEscola());
            } else if (ke.getSource()==txtConsultaAluno){
                atualizaAlunos(buscarAluno());
            } else if (ke.getSource()==txtBuscaFuncionarios){
                atualizaFuncionarios(buscarFuncionario());
            }       
        }
        
    }
    
    class OuvintesChangeListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent ce) {
            switch (tabbedConsultas.getSelectedIndex()) {
                case 0:
                    if (funcLogado.getAcesso() >= 1){
                        btnEditar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                        btnRelatorio.setEnabled(true);
                    } else {
                        btnEditar.setEnabled(false);
                        btnExcluir.setEnabled(false);
                        btnRelatorio.setEnabled(false);
                    }   btnEstatisticas.setEnabled(true);
                    break;
                case 1:
                    if (funcLogado.getAcesso() >= 1){
                        btnEditar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                        btnRelatorio.setEnabled(true);
                    } else {
                        btnEditar.setEnabled(false);
                        btnExcluir.setEnabled(false);
                        btnRelatorio.setEnabled(false);
                    }   btnEstatisticas.setEnabled(false);
                    break;
                case 2:
                    if (funcLogado.getAcesso() >= 1){
                        btnRelatorio.setEnabled(true);
                    } else {
                        btnRelatorio.setEnabled(false);
                    }   btnExcluir.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnEstatisticas.setEnabled(true);
                    break;
                default:
                    break;
            }
        }
    }
    
    private class TableModelAluno extends AbstractTableModel {
        private List<Aluno> linhas;
        private String[] colunas = new String[] {"Nome", "RA", "Escola", "Turma",  "Data de Nascimento"};
        private static final int NOME = 0;
        private static final int RA = 1;
        private static final int ESCOLA = 2;
        private static final int TURMA = 3;
        private static final int DATANASC = 4;
 
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
            case ESCOLA:
                return String.class;
            case TURMA:
                return String.class;
            case DATANASC:
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
            tblConsultaAluno.getColumnModel().getColumn(0).setPreferredWidth(180);
            tblConsultaAluno.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblConsultaAluno.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblConsultaAluno.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblConsultaAluno.getColumnModel().getColumn(4).setPreferredWidth(100);
            Collections.sort(linhas, (Aluno a1, Aluno a2) -> a1.getNome().compareTo(a2.getNome()));
            Aluno a = linhas.get(rowIndex);
            switch (columnIndex) {
                case NOME:
                    return a.getNome();
                case RA:
                    return a.getRa();
                case ESCOLA:
                    return a.getEscola().getNome();
                case TURMA:
                    return a.getSerie();
                case DATANASC:
                    return converteData.converteDateParaString(a.getDataNasc());
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
    
    private class TableModelFuncionario extends AbstractTableModel {
        private List<Funcionario> linhas;
        private String[] colunas = new String[] {"CPF", "Nome", "Cargo", "Data de Admissão"};
        private static final int CPF = 0;
        private static final int NOME = 1;
        private static final int CARGO = 2;
        private static final int DATAADMIS = 3;

 
        public TableModelFuncionario() {
            linhas = new ArrayList<>();
        }
 
        public TableModelFuncionario(List<Funcionario> lista) {
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
            case CPF:
                return String.class;
            case NOME:
                return String.class;
            case CARGO:
                return String.class;
            case DATAADMIS:
                return Date.class;
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
            
            Collections.sort(linhas, (Funcionario f1, Funcionario f2) -> f1.getNome().compareTo(f2.getNome()));
            Funcionario f = linhas.get(rowIndex);
            switch (columnIndex) {
                case CPF:
                    return f.getCpf();
                case NOME:
                    return f.getNome();
                case CARGO:
                    return f.getCargo();
                case DATAADMIS:
                    return f.getDataAdmissao();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        public Funcionario getFuncionario(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        public void addFuncionario(Funcionario f) {
            linhas.add(f);
            int ultimoIndice = getRowCount() - 1;

            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        public void removeFuncionario(int indiceLinha) {
            linhas.remove(indiceLinha);

            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        public void addListaDeCertificados(List<Funcionario> funcionarios) {
            int indice = getRowCount();
            linhas.addAll(funcionarios);

            fireTableRowsInserted(indice, indice + funcionarios.size());
        }
 
        public void limpar() {
            linhas.clear();
            fireTableDataChanged();
        }
    }
}
