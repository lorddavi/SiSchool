/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.CamposDeTelefone;
import br.com.davi.sischool.funcoes.ConverteData;
import br.com.davi.sischool.funcoes.PreencheCombo;
import br.com.davi.sischool.funcoes.VerificaCheckBox;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Telefone;
import br.com.davi.sischool.regras.FuncionarioDAO;
import br.com.davi.sischool.regras.OutroCargoDAO;
import br.com.davi.sischool.regras.ProfessorPebIDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
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
public class JFCadastrarFuncionario extends javax.swing.JFrame {

    /*
    * Construtor padrão do JFCadastrarFuncionario.
    */
    
    public JFCadastrarFuncionario(){
        
    }
    
    /*
    * Construtor do JFCadastrarFuncionario que recebe como parâmetro um Login
    * para realizar verificações de permissão e segurança.
    */
    
    public JFCadastrarFuncionario(Login login) {
        funcLogado = login.getFunc();
        initComponents();
        iniciarComponentes();
        tmf = new TableModelFuncionario(listaF());
        tabelaBuscaFuncionarios.setModel(tmf);
    }
    
    private void iniciarComponentes(){
        preencheCombo.preencheEscolas(comboEscolaOutroCargo);
        funcs = fdao.buscaTodos();
        setaListeners();
    }
    
    private void setaListeners(){
        radioPebIICadFunc.addItemListener(oi);
        radioHabilitaManha.addItemListener(oi);
        radioHabilitaTarde.addItemListener(oi);
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnAddTelefoneCadFunc.addActionListener(oa);
        btnRemoveTelefoneCadFunc.addActionListener(oa);
        btnSalvarCadFunc.addActionListener(oa);
        btnEditar.addActionListener(oa);
        btnCancelarCadFunc.addActionListener(oa);
        btnExcluir.addActionListener(oa);
        btnRelatorios.addActionListener(oa);
        btnNovo.addActionListener(oa);
        txtBuscaFunc.addKeyListener(okl);
        radioCargoProfCadFunc.addItemListener(oi);
        radioCargoOutrosCadFunc.addItemListener(oi);
        radioPebICadFunc.addItemListener(oi);
        radioPebIICadFunc.addItemListener(oi);
        tabelaBuscaFuncionarios.getSelectionModel().addListSelectionListener(ols);
        txtCpfCadFunc.addFocusListener(of);
    }
    
    private void relatorio(){
        try {
	// Cria a fonte de dados
            List<Funcionario> funcs = fdao.buscaTodos();
	    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(funcs);
	// Preenche o relatório
	    JasperPrint print = JasperFillManager.fillReport("relatorios/Funcionarios.jasper", null, ds);
	// Exibe o relatório
	    JasperViewer.viewReport(print, false);
        } catch (JRException e) {
                e.printStackTrace();
        }
    }
    
    private String checaCargo() {
        if (radioCargoOutrosCadFunc.isSelected()) {
            return txtCargo.getText();
        } else if (radioCargoProfCadFunc.isSelected()) {
            if (checaCategoria()==1){
                return "Professor PEB I";
            } else if (checaCategoria()==2){
                return "Professor PEB II";
            }
        }
        return null;
    }
    
    public int checaCategoria(){
        if (radioPebICadFunc.isSelected()){
            return 1;
        } else if (radioPebIICadFunc.isSelected()){
            return 2;
        }
        return 0;
    }
    
    public String checaPeriodo(){
        if (radioHabilitaManha.isSelected() && radioHabilitaTarde.isSelected()){
            return "Duplo";
        } else if (radioHabilitaManha.isSelected() && !radioHabilitaTarde.isSelected()) {
            return "Manhã";
        } else {
            return "Tarde";
        }
    }
    
    private boolean redigiteSenha(){
        String senha = new String(pswSenhaUsrCadFunc.getPassword());
        String redigite = new String(redPswSenhaUsrCadFunc.getPassword());
        if (senha.equals(redigite)){
            return true;
        }
        JOptionPane.showMessageDialog(null, "As senhas digitadas devem ser iguais.");
        return false;
    }
    
    public void novoFuncEnabled(){
        txtNomeCadFunc.setEnabled(true);
        txtFDataNasc.setEnabled(true);
        txtCpfCadFunc.setEnabled(true);
        txtEnderecoCadFunc.setEnabled(true);
        txtBairroCadFunc.setEnabled(true);
        txtCidadeCadFunc.setEnabled(true);
        txtCepCadFunc.setEnabled(true);
        txtTelefonesCadFunc.setEnabled(true);
        txtMatriculaCadFunc.setEnabled(true);
        txtNickNameUsrCadFunc.setEnabled(true);
        pswSenhaUsrCadFunc.setEnabled(true);
        redPswSenhaUsrCadFunc.setEnabled(true);
        
        comboAcessoUsrCadFunc.setEnabled(true);
        
        radioCargoOutrosCadFunc.setEnabled(true);
        radioPebICadFunc.setEnabled(true);
        radioPebIICadFunc.setEnabled(true);
        radioMascCadFunc.setEnabled(true);
        radioFemCadFunc.setEnabled(true);
        radioPebICadFunc.setEnabled(true);
        
        checkPossuiDeficiencia.setEnabled(true);
    
        jListTelefonesCadFunc.setEnabled(true);
        
    }
    
    public void estadoBotoesNovo(){
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnSalvarCadFunc.setEnabled(true);
        btnCancelarCadFunc.setEnabled(true);
        btnAddTelefoneCadFunc.setEnabled(true);
        btnRemoveTelefoneCadFunc.setEnabled(true);
    }
    
    public void estadoInicial(){
        txtNomeCadFunc.setEnabled(false);
        txtFDataNasc.setEnabled(false);
        txtCpfCadFunc.setEnabled(false);
        txtEnderecoCadFunc.setEnabled(false);
        txtBairroCadFunc.setEnabled(false);
        txtCidadeCadFunc.setEnabled(false);
        txtCepCadFunc.setEnabled(false);
        txtTelefonesCadFunc.setEnabled(false);
        txtMatriculaCadFunc.setEnabled(false);
        txtNickNameUsrCadFunc.setEnabled(false);
        pswSenhaUsrCadFunc.setEnabled(false);
        redPswSenhaUsrCadFunc.setEnabled(false);
        txtAObservacoes.setEnabled(false);
        txtCargo.setEnabled(false);
        
        comboAcessoUsrCadFunc.setEnabled(false);
        comboEscolaOutroCargo.setEnabled(false);
        comboEspecialidade.setEnabled(false);
        
        radioCargoOutrosCadFunc.setEnabled(false);
        radioPebICadFunc.setEnabled(false);
        radioPebIICadFunc.setEnabled(false);
        radioMascCadFunc.setEnabled(false);
        radioFemCadFunc.setEnabled(false);
        radioPebICadFunc.setEnabled(false);
        
        checkPossuiDeficiencia.setEnabled(false);
    
        jListTelefonesCadFunc.setEnabled(false);
        
        btnNovo.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnSalvarCadFunc.setEnabled(false);
        btnCancelarCadFunc.setEnabled(false);
        btnAddTelefoneCadFunc.setEnabled(false);
        btnRemoveTelefoneCadFunc.setEnabled(false);
    }
    
    private void pebiEnabled(){
        if (radioPebICadFunc.isSelected()){
            radioHabilitaManha.setEnabled(true);
            radioHabilitaTarde.setEnabled(true);
        } else {
            radioHabilitaManha.setEnabled(false);
            radioHabilitaTarde.setEnabled(false);
        }
    }

    private void pebiiEnabled(){
        if (radioPebIICadFunc.isSelected()){
            comboEspecialidade.setEnabled(true);
            radioHabilitaManha.setEnabled(false);
            radioHabilitaTarde.setEnabled(false);
        } else {
            comboEspecialidade.setEnabled(false);
        }
    }
    
    public void setaProfFalseEnabled(){
        radioPebICadFunc.setEnabled(false);
        radioPebIICadFunc.setEnabled(false);
        radioHabilitaManha.setEnabled(false);
        radioHabilitaTarde.setEnabled(false);
        txtCargo.setEnabled(true);
        comboEscolaOutroCargo.setEnabled(true);
        txtAObservacoes.setEnabled(true);
    } 
    
    public void setaFuncFalseEnabled(){
        comboEscolaOutroCargo.setEnabled(false);
        radioPebICadFunc.setEnabled(true);
        radioHabilitaManha.setEnabled(true);
        radioHabilitaTarde.setEnabled(true);
        radioPebIICadFunc.setEnabled(true);
        txtCargo.setEnabled(false);
        txtAObservacoes.setEnabled(false);
    }
    
    public void verificaCargoEnabled(){
        if (radioCargoOutrosCadFunc.isSelected()) {
            setaProfFalseEnabled();
        } else if (radioCargoProfCadFunc.isSelected()) {
            setaFuncFalseEnabled();
        }
    }
    
    public void limpar(){
        txtNomeCadFunc.setText("");
        txtFDataNasc.setText("");
        txtEnderecoCadFunc.setText("");
        txtBairroCadFunc.setText("");
        txtCidadeCadFunc.setText("");
        txtCepCadFunc.setText("");
        telef = null;
        txtAObservacoes.setText("");
        txtCargo.setText("");
        txtCpfCadFunc.setText("");
        txtMatriculaCadFunc.setText("");
        checkPossuiDeficiencia.setSelected(false);
        comboAcessoUsrCadFunc.setSelectedIndex(0);
        txtNickNameUsrCadFunc.setText("");
        pswSenhaUsrCadFunc.setText("");
        redPswSenhaUsrCadFunc.setText("");
    }
    
    public void defineCampos(){
        nome = txtNomeCadFunc.getText();
        dataNasc = converteData.converteDataParaUtilDate(txtFDataNasc);
        genero = verificaCheck.checaGenero(radioMascCadFunc);
        endereco = txtEnderecoCadFunc.getText();
        bairro = txtBairroCadFunc.getText();
        cidade = txtCidadeCadFunc.getText();
        cep = txtCepCadFunc.getText();
        //telefone
        observacoes = txtAObservacoes.getText();
        cargo = checaCargo();
        cpf = txtCpfCadFunc.getText();
        matricula = txtMatriculaCadFunc.getText();
        especialidade = (String) comboEspecialidade.getSelectedItem();
        periodo = checaPeriodo();
        deficiencia = verificaCheck.checaVerdadeiroFalso(checkPossuiDeficiencia);
        //escolas
        escolaOutroCargo = (Escola) comboEscolaOutroCargo.getSelectedItem();
        acesso = Integer.parseInt(comboAcessoUsrCadFunc.getSelectedItem().toString());
        usrName = txtNickNameUsrCadFunc.getText();
        senha = new String(pswSenhaUsrCadFunc.getPassword());
        
        if (checaCargo().equals("Professor PEB I")){
            profPebI.setNome(nome);
            profPebI.setDataNasc(dataNasc);
            profPebI.setGenero(genero);
            profPebI.setEndereco(endereco);
            profPebI.setBairro(bairro);
            profPebI.setCidade(cidade);
            profPebI.setCep(cep);
            profPebI.setTelefones(telef);
            profPebI.setObservacoes(observacoes);
            profPebI.setCargo(cargo);
            profPebI.setCpf(cpf);
            profPebI.setMatricula(matricula);
            profPebI.setPossuiDeficiencia(deficiencia);
            profPebI.setPeriodo(periodo);
            profPebI.setAcesso(acesso);
            profPebI.setUsrName(usrName);
            profPebI.setSenha(senha);
        } else if (checaCargo().equals("Professor PEB II")){
            profPebII.setNome(nome);
            profPebII.setDataNasc(dataNasc);
            profPebII.setGenero(genero);
            profPebII.setEndereco(endereco);
            profPebII.setBairro(bairro);
            profPebII.setCidade(cidade);
            profPebII.setCep(cep);
            profPebII.setTelefones(telef);
            profPebII.setObservacoes(observacoes);
            profPebII.setCargo(cargo);
            profPebII.setCpf(cpf);
            profPebII.setMatricula(matricula);
            profPebII.setPossuiDeficiencia(deficiencia);
            profPebII.setAcesso(acesso);
            profPebII.setUsrName(usrName);
            profPebII.setSenha(senha);
            profPebII.setEspecialidade(especialidade);
        } else {
            funcOutroCargo.setNome(nome);
            funcOutroCargo.setDataNasc(dataNasc);
            funcOutroCargo.setGenero(genero);
            funcOutroCargo.setEndereco(endereco);
            funcOutroCargo.setBairro(bairro);
            funcOutroCargo.setCidade(cidade);
            funcOutroCargo.setCep(cep);
            funcOutroCargo.setTelefones(telef);
            funcOutroCargo.setObservacoes(observacoes);
            funcOutroCargo.setCargo(cargo);
            funcOutroCargo.setCpf(cpf);
            funcOutroCargo.setMatricula(matricula);
            funcOutroCargo.setPossuiDeficiencia(deficiencia);
            funcOutroCargo.setAcesso(acesso);
            funcOutroCargo.setUsrName(usrName);
            funcOutroCargo.setSenha(senha);
            funcOutroCargo.setEscola(escolaOutroCargo);
        }
    }

    public void editarFunc(int id){
        if (pebidao.buscarId(id) == null){
            if (pebiidao.buscarId(id) == null){
                funcOutroCargo = ocdao.buscarFunc(id);
                
                nome = funcOutroCargo.getNome();
                dataNasc = funcOutroCargo.getDataNasc();
                genero = funcOutroCargo.getGenero();
                endereco = funcOutroCargo.getEndereco();
                bairro = funcOutroCargo.getBairro();
                cidade = funcOutroCargo.getCidade();
                cep = funcOutroCargo.getCep();
                observacoes = funcOutroCargo.getObservacoes();
                cargo = funcOutroCargo.getCargo();
                cpf = funcOutroCargo.getCpf();
                matricula = funcOutroCargo.getMatricula();
                deficiencia = funcOutroCargo.isPossuiDeficiencia();
                escolaOutroCargo = funcOutroCargo.getEscola();
                acesso = funcOutroCargo.getAcesso();
                usrName = funcOutroCargo.getUsrName();
                senha = funcOutroCargo.getSenha();
            } else {
                profPebII = pebiidao.buscarId(id);
                
                nome = profPebII.getNome();
                dataNasc = profPebII.getDataNasc();
                genero = profPebII.getGenero();
                endereco = profPebII.getEndereco();
                bairro = profPebII.getBairro();
                cidade = profPebII.getCidade();
                cep = profPebII.getCep();
                observacoes = profPebII.getObservacoes();
                cargo = profPebII.getCargo();
                cpf = profPebII.getCpf();
                matricula = profPebII.getMatricula();
                especialidade = profPebII.getEspecialidade();
                deficiencia = profPebII.isPossuiDeficiencia();
                acesso = profPebII.getAcesso();
                usrName = profPebII.getUsrName();
                senha = profPebII.getSenha();
            }
        } else {
            profPebI = pebidao.buscarId(id);

            nome = profPebI.getNome();
            dataNasc = profPebI.getDataNasc();
            genero = profPebI.getGenero();
            endereco = profPebI.getEndereco();
            bairro = profPebI.getBairro();
            cidade = profPebI.getCidade();
            cep = profPebI.getCep();
            observacoes = profPebI.getObservacoes();
            cargo = profPebI.getCargo();
            cpf = profPebI.getCpf();
            matricula = profPebI.getMatricula();
            periodo = profPebI.getPeriodo();
            deficiencia = profPebI.isPossuiDeficiencia();
            acesso = profPebI.getAcesso();
            usrName = profPebI.getUsrName();
            senha = profPebI.getSenha();
        }
        
        txtNomeCadFunc.setText(nome);
        //Date dataNasc = converteData.converteDataParaUtilDate(txtFDataNasc);
        generoEditar(genero);
        txtEnderecoCadFunc.setText(endereco);
        txtBairroCadFunc.setText(bairro);
        txtCidadeCadFunc.setText(cidade);
        txtCepCadFunc.setText(cep);
        //telefone
        txtAObservacoes.setText(observacoes);
        cargoEditar(cargo);
        txtCpfCadFunc.setText(cpf);
        txtMatriculaCadFunc.setText(matricula);
        comboEspecialidade.setSelectedItem(especialidade);
        if (periodo == null){
        } else {
            periodoEditar(periodo);
        }
        checkPossuiDeficiencia.setSelected(deficiencia);
        //escolas
        comboEscolaOutroCargo.setSelectedItem(escolaOutroCargo);
        comboAcessoUsrCadFunc.setSelectedIndex(acesso);
        txtNickNameUsrCadFunc.setText(usrName);
        pswSenhaUsrCadFunc.setText(senha);
        redPswSenhaUsrCadFunc.setText(senha);
    }

    public void generoEditar(String genero){
        if (genero.equals("Masculino")){
            radioMascCadFunc.setSelected(true);
        } else {
            radioFemCadFunc.setSelected(true);
        }
    }
    
    public void cargoEditar(String cargo){
        if (cargo.equals("Professor PEB I")){
            setaFuncFalseEnabled();
            radioPebICadFunc.setSelected(true);
        } else if (cargo.equals("Professor PEB II")){
            setaFuncFalseEnabled();
            verificaCargoEnabled();
            radioPebIICadFunc.setSelected(true);
        } else {
            setaProfFalseEnabled();
            radioCargoOutrosCadFunc.setSelected(true);
            txtCargo.setText(cargo);
        }
    }
    
    public void periodoEditar(String periodo){
        if (periodo.equals("Manhã")){
            radioHabilitaManha.setSelected(true);
        } else if (periodo.equals("Tarde")){
            radioHabilitaTarde.setSelected(true);
        } else {
            radioHabilitaManha.setSelected(true);
            radioHabilitaTarde.setSelected(true);
        }
    }
    
    private Funcionario pegaFuncTabela(){
        int linha = tabelaBuscaFuncionarios.getSelectedRow();
        return tmf.getFuncionario(linha);
    }
    
    private List<Funcionario> listaF(){
       return fdao.buscaTodos();
    }
    
    private void atualizaTabela(List<Funcionario> func){
        tmf = new TableModelFuncionario(funcs);
        tabelaBuscaFuncionarios.setModel(tmf);
    }
    
    private void cancelar(){
        if (edicao) {
            edicao = false;
            limpar();
        } else if (exclusao) {
            exclusao = false;
        } else {

        }
        estadoInicial();
        tabelaBuscaFuncionarios.clearSelection();
    }
    
    private void excluir(){
        exclusao = true;
        int linha = tabelaBuscaFuncionarios.getSelectedRow();
        Funcionario f = tmf.getFuncionario(linha);

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",
                                                "Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
           fdao.excluir(f);
           JOptionPane.showMessageDialog(this, "A exclusão foi efetuada com sucesso!");
           tmf.removeFuncionario(linha);
        } 
        
        tabelaBuscaFuncionarios.clearSelection();
        estadoInicial();
        
    }
    
    private void editar(){
        novoFuncEnabled();
        estadoBotoesNovo();
        if ((funcLogado.getAcesso() > pegaFuncTabela().getAcesso()) || funcLogado.getAcesso()>=2){
            edicao = true;
            editarFunc(pegaFuncTabela().getId());
            btnCancelarCadFunc.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem autorização para "
                + "editar esse usuário.");
        }
    }
    
    public void salvar(){
        try {
            defineCampos();
            if (redigiteSenha()){
                if (checaCargo().equals("Professor PEB I")){
                    if (edicao){
                        pebidao.editar(profPebI);
                        JOptionPane.showMessageDialog(null, "Modificado com sucesso!");
                        edicao = false;
                    } else {
                        pebidao.inserir(profPebI);
                        JOptionPane.showMessageDialog(null, "Professor PEB I cadastrado!");
                        tmf.addFuncionario(profPebI);
                    }
                } else if (checaCargo().equals("Professor PEB II")){
                    if (edicao) {
                        pebiidao.editar(profPebII);
                        JOptionPane.showMessageDialog(null, "Modificado com sucesso!");
                        edicao = false;
                    } else {
                        pebiidao.inserir(profPebII);
                        JOptionPane.showMessageDialog(null, "Professor PEB II cadastrado!");
                        tmf.addFuncionario(profPebII);
                    }
                } else {
                    if (edicao){
                        ocdao.editar(funcOutroCargo);
                        JOptionPane.showMessageDialog(null, "Modificado com sucesso!");
                        edicao = false;
                    } else {
                        ocdao.inserir(funcOutroCargo);
                        JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
                        tmf.addFuncionario(funcOutroCargo);
                    }
                }
                limpar();
                estadoBotoesNovo();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inicia os componentes. Código criado automaticamente pelo Swing e, portanto,
     * é imutável.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGeneroCadFunc = new javax.swing.ButtonGroup();
        btnGroupPebIPebII = new javax.swing.ButtonGroup();
        btnGroupCargo = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        panelFundo = new javax.swing.JPanel();
        tabbedCadastrarFuncionarios = new javax.swing.JTabbedPane();
        tabDadosPessoasCadFunc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCadFunc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEnderecoCadFunc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFDataNasc = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        radioMascCadFunc = new javax.swing.JRadioButton();
        radioFemCadFunc = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBairroCadFunc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCidadeCadFunc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefonesCadFunc = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        txtTelefonesCadFunc = new javax.swing.JTextField();
        btnAddTelefoneCadFunc = new javax.swing.JButton();
        btnRemoveTelefoneCadFunc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCepCadFunc = new javax.swing.JTextField();
        checkPossuiDeficiencia = new javax.swing.JCheckBox();
        txtCpfCadFunc = new javax.swing.JFormattedTextField();
        tabCargoCadFunc = new javax.swing.JPanel();
        radioCargoProfCadFunc = new javax.swing.JRadioButton();
        panelProf = new javax.swing.JPanel();
        panelProf1PeriodoCargoCadFunc = new javax.swing.JPanel();
        radioHabilitaTarde = new javax.swing.JRadioButton();
        radioHabilitaManha = new javax.swing.JRadioButton();
        panelRadioPebIeIICadFunc = new javax.swing.JPanel();
        radioPebICadFunc = new javax.swing.JRadioButton();
        radioPebIICadFunc = new javax.swing.JRadioButton();
        jPanelEspecialidadePebII = new javax.swing.JPanel();
        comboEspecialidade = new javax.swing.JComboBox<>();
        panelOutrosCargos = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAObservacoes = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        comboEscolaOutroCargo = new javax.swing.JComboBox<>();
        radioCargoOutrosCadFunc = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txtMatriculaCadFunc = new javax.swing.JTextField();
        panelTabUsuario = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNickNameUsrCadFunc = new javax.swing.JTextField();
        comboAcessoUsrCadFunc = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        pswSenhaUsrCadFunc = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        redPswSenhaUsrCadFunc = new javax.swing.JPasswordField();
        panelTabelaBusca = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaBuscaFuncionarios = new javax.swing.JTable();
        txtBuscaFunc = new javax.swing.JTextField();
        btnRelatorios = new javax.swing.JButton();
        btnCancelarCadFunc = new javax.swing.JButton();
        btnSalvarCadFunc = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Cadastrar Funcionário");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        tabbedCadastrarFuncionarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabDadosPessoasCadFunc.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nome:");

        txtNomeCadFunc.setEnabled(false);

        jLabel2.setText("Endereço:");

        txtEnderecoCadFunc.setEnabled(false);

        jLabel3.setText("Data de Nascimento:");

        try {
            txtFDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFDataNasc.setToolTipText("dd/mm/aa");
        txtFDataNasc.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Gênero"));

        btnGroupGeneroCadFunc.add(radioMascCadFunc);
        radioMascCadFunc.setText("Masculino");
        radioMascCadFunc.setEnabled(false);

        btnGroupGeneroCadFunc.add(radioFemCadFunc);
        radioFemCadFunc.setSelected(true);
        radioFemCadFunc.setText("Feminino");
        radioFemCadFunc.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioFemCadFunc)
                    .addComponent(radioMascCadFunc))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(radioMascCadFunc)
                .addGap(10, 10, 10)
                .addComponent(radioFemCadFunc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("CPF:");

        jLabel6.setText("Bairro:");

        txtBairroCadFunc.setEnabled(false);

        jLabel7.setText("Cidade:");

        txtCidadeCadFunc.setEnabled(false);

        jListTelefonesCadFunc.setEnabled(false);
        jScrollPane1.setViewportView(jListTelefonesCadFunc);

        jLabel8.setText("Telefones:");

        txtTelefonesCadFunc.setEnabled(false);

        btnAddTelefoneCadFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/adic.png"))); // NOI18N
        btnAddTelefoneCadFunc.setContentAreaFilled(false);
        btnAddTelefoneCadFunc.setEnabled(false);

        btnRemoveTelefoneCadFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/minus.png"))); // NOI18N
        btnRemoveTelefoneCadFunc.setContentAreaFilled(false);
        btnRemoveTelefoneCadFunc.setEnabled(false);

        jLabel9.setText("CEP:");

        txtCepCadFunc.setEnabled(false);

        checkPossuiDeficiencia.setBackground(new java.awt.Color(204, 204, 204));
        checkPossuiDeficiencia.setText("Possui deficiência");
        checkPossuiDeficiencia.setEnabled(false);

        try {
            txtCpfCadFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfCadFunc.setEnabled(false);
        txtCpfCadFunc.setInputVerifier(ivcpf);

        javax.swing.GroupLayout tabDadosPessoasCadFuncLayout = new javax.swing.GroupLayout(tabDadosPessoasCadFunc);
        tabDadosPessoasCadFunc.setLayout(tabDadosPessoasCadFuncLayout);
        tabDadosPessoasCadFuncLayout.setHorizontalGroup(
            tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDadosPessoasCadFuncLayout.createSequentialGroup()
                        .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBairroCadFunc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                .addComponent(txtEnderecoCadFunc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCidadeCadFunc, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1)
                            .addComponent(txtTelefonesCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(txtNomeCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCpfCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(checkPossuiDeficiencia)
                            .addComponent(txtCepCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddTelefoneCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveTelefoneCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        tabDadosPessoasCadFuncLayout.setVerticalGroup(
            tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txtNomeCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpfCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDadosPessoasCadFuncLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnderecoCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPossuiDeficiencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBairroCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidadeCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCepCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonesCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDadosPessoasCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDadosPessoasCadFuncLayout.createSequentialGroup()
                        .addComponent(btnAddTelefoneCadFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveTelefoneCadFunc)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        txtFDataNasc.getAccessibleContext().setAccessibleName("");

        tabbedCadastrarFuncionarios.addTab("Dados Pessoais", tabDadosPessoasCadFunc);

        tabCargoCadFunc.setBackground(new java.awt.Color(204, 204, 204));

        btnGroupCargo.add(radioCargoProfCadFunc);
        radioCargoProfCadFunc.setSelected(true);
        radioCargoProfCadFunc.setText("Professor(a)");
        radioCargoProfCadFunc.setEnabled(false);

        panelProf.setBackground(new java.awt.Color(205, 205, 205));
        panelProf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        panelProf1PeriodoCargoCadFunc.setBackground(new java.awt.Color(204, 204, 204));
        panelProf1PeriodoCargoCadFunc.setBorder(javax.swing.BorderFactory.createTitledBorder("Período"));

        radioHabilitaTarde.setBackground(new java.awt.Color(204, 204, 204));
        radioHabilitaTarde.setText("Tarde:");
        radioHabilitaTarde.setEnabled(false);

        radioHabilitaManha.setBackground(new java.awt.Color(204, 204, 204));
        radioHabilitaManha.setText("Manhã:");
        radioHabilitaManha.setEnabled(false);

        javax.swing.GroupLayout panelProf1PeriodoCargoCadFuncLayout = new javax.swing.GroupLayout(panelProf1PeriodoCargoCadFunc);
        panelProf1PeriodoCargoCadFunc.setLayout(panelProf1PeriodoCargoCadFuncLayout);
        panelProf1PeriodoCargoCadFuncLayout.setHorizontalGroup(
            panelProf1PeriodoCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProf1PeriodoCargoCadFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProf1PeriodoCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioHabilitaManha)
                    .addComponent(radioHabilitaTarde))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelProf1PeriodoCargoCadFuncLayout.setVerticalGroup(
            panelProf1PeriodoCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProf1PeriodoCargoCadFuncLayout.createSequentialGroup()
                .addComponent(radioHabilitaManha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioHabilitaTarde))
        );

        panelRadioPebIeIICadFunc.setBackground(new java.awt.Color(204, 204, 204));
        panelRadioPebIeIICadFunc.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        radioPebICadFunc.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupPebIPebII.add(radioPebICadFunc);
        radioPebICadFunc.setText("PEB I");
        radioPebICadFunc.setEnabled(false);

        radioPebIICadFunc.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupPebIPebII.add(radioPebIICadFunc);
        radioPebIICadFunc.setText("PEB II");
        radioPebIICadFunc.setEnabled(false);

        javax.swing.GroupLayout panelRadioPebIeIICadFuncLayout = new javax.swing.GroupLayout(panelRadioPebIeIICadFunc);
        panelRadioPebIeIICadFunc.setLayout(panelRadioPebIeIICadFuncLayout);
        panelRadioPebIeIICadFuncLayout.setHorizontalGroup(
            panelRadioPebIeIICadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadioPebIeIICadFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRadioPebIeIICadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioPebICadFunc)
                    .addComponent(radioPebIICadFunc))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelRadioPebIeIICadFuncLayout.setVerticalGroup(
            panelRadioPebIeIICadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadioPebIeIICadFuncLayout.createSequentialGroup()
                .addComponent(radioPebICadFunc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioPebIICadFunc))
        );

        jPanelEspecialidadePebII.setBackground(new java.awt.Color(204, 204, 204));
        jPanelEspecialidadePebII.setBorder(javax.swing.BorderFactory.createTitledBorder("Especialidade"));

        comboEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artes", "Inglês", "Educação Física" }));
        comboEspecialidade.setEnabled(false);

        javax.swing.GroupLayout jPanelEspecialidadePebIILayout = new javax.swing.GroupLayout(jPanelEspecialidadePebII);
        jPanelEspecialidadePebII.setLayout(jPanelEspecialidadePebIILayout);
        jPanelEspecialidadePebIILayout.setHorizontalGroup(
            jPanelEspecialidadePebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEspecialidadePebIILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEspecialidadePebIILayout.setVerticalGroup(
            jPanelEspecialidadePebIILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEspecialidadePebIILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelProfLayout = new javax.swing.GroupLayout(panelProf);
        panelProf.setLayout(panelProfLayout);
        panelProfLayout.setHorizontalGroup(
            panelProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRadioPebIeIICadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelProf1PeriodoCargoCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEspecialidadePebII, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelProfLayout.setVerticalGroup(
            panelProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelEspecialidadePebII, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelRadioPebIeIICadFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelProf1PeriodoCargoCadFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelOutrosCargos.setBackground(new java.awt.Color(205, 205, 205));
        panelOutrosCargos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel22.setText("Cargo / Função:");

        txtCargo.setEnabled(false);

        jLabel13.setText("Observações:");

        txtAObservacoes.setColumns(20);
        txtAObservacoes.setLineWrap(true);
        txtAObservacoes.setRows(5);
        txtAObservacoes.setWrapStyleWord(true);
        txtAObservacoes.setEnabled(false);
        jScrollPane2.setViewportView(txtAObservacoes);

        jLabel12.setText("Escola:");

        comboEscolaOutroCargo.setEnabled(false);

        javax.swing.GroupLayout panelOutrosCargosLayout = new javax.swing.GroupLayout(panelOutrosCargos);
        panelOutrosCargos.setLayout(panelOutrosCargosLayout);
        panelOutrosCargosLayout.setHorizontalGroup(
            panelOutrosCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutrosCargosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelOutrosCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(comboEscolaOutroCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOutrosCargosLayout.setVerticalGroup(
            panelOutrosCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutrosCargosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEscolaOutroCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnGroupCargo.add(radioCargoOutrosCadFunc);
        radioCargoOutrosCadFunc.setText("Outro Cargo");
        radioCargoOutrosCadFunc.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Matrícula"));

        txtMatriculaCadFunc.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMatriculaCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMatriculaCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabCargoCadFuncLayout = new javax.swing.GroupLayout(tabCargoCadFunc);
        tabCargoCadFunc.setLayout(tabCargoCadFuncLayout);
        tabCargoCadFuncLayout.setHorizontalGroup(
            tabCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCargoCadFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCargoCadFuncLayout.createSequentialGroup()
                        .addComponent(radioCargoOutrosCadFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelOutrosCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(tabCargoCadFuncLayout.createSequentialGroup()
                        .addComponent(radioCargoProfCadFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCargoCadFuncLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        tabCargoCadFuncLayout.setVerticalGroup(
            tabCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCargoCadFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCargoProfCadFunc)
                    .addComponent(panelProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(tabCargoCadFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCargoOutrosCadFunc)
                    .addComponent(panelOutrosCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabbedCadastrarFuncionarios.addTab("Cargo", tabCargoCadFunc);

        panelTabUsuario.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setText("Nickname:");

        jLabel19.setText("Senha:");

        txtNickNameUsrCadFunc.setEnabled(false);

        comboAcessoUsrCadFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        comboAcessoUsrCadFunc.setEnabled(false);

        jLabel21.setText("Nível de acesso:");

        pswSenhaUsrCadFunc.setEnabled(false);

        jLabel23.setText("Digite a senha novamente:");

        redPswSenhaUsrCadFunc.setEnabled(false);

        javax.swing.GroupLayout panelTabUsuarioLayout = new javax.swing.GroupLayout(panelTabUsuario);
        panelTabUsuario.setLayout(panelTabUsuarioLayout);
        panelTabUsuarioLayout.setHorizontalGroup(
            panelTabUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabUsuarioLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(panelTabUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(redPswSenhaUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(comboAcessoUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(pswSenhaUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtNickNameUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 207, Short.MAX_VALUE))
        );
        panelTabUsuarioLayout.setVerticalGroup(
            panelTabUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabUsuarioLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickNameUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenhaUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redPswSenhaUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAcessoUsrCadFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );

        tabbedCadastrarFuncionarios.addTab("Usuário", panelTabUsuario);

        panelTabelaBusca.setBackground(new java.awt.Color(204, 204, 204));
        panelTabelaBusca.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Busque um funcionário:");

        tabelaBuscaFuncionarios.setModel(tmf);
        jScrollPane3.setViewportView(tabelaBuscaFuncionarios);

        btnRelatorios.setText("Ver relatório");

        javax.swing.GroupLayout panelTabelaBuscaLayout = new javax.swing.GroupLayout(panelTabelaBusca);
        panelTabelaBusca.setLayout(panelTabelaBuscaLayout);
        panelTabelaBuscaLayout.setHorizontalGroup(
            panelTabelaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabelaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTabelaBuscaLayout.createSequentialGroup()
                        .addGroup(panelTabelaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelaBuscaLayout.createSequentialGroup()
                        .addComponent(txtBuscaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelaBuscaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorios)
                .addGap(112, 112, 112))
        );
        panelTabelaBuscaLayout.setVerticalGroup(
            panelTabelaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaBuscaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRelatorios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addComponent(tabbedCadastrarFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabelaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabelaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbedCadastrarFuncionarios))
                .addContainerGap())
        );

        btnCancelarCadFunc.setText("Cancelar");
        btnCancelarCadFunc.setEnabled(false);

        btnSalvarCadFunc.setText("Salvar");
        btnSalvarCadFunc.setEnabled(false);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);

        btnNovo.setText("Novo Funcionário");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarCadFunc)
                .addGap(18, 18, 18)
                .addComponent(btnSalvarCadFunc)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCadFunc)
                    .addComponent(btnSalvarCadFunc)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo))
                .addContainerGap(32, Short.MAX_VALUE))
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
                new JFCadastrarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTelefoneCadFunc;
    private javax.swing.JButton btnCancelarCadFunc;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.ButtonGroup btnGroupCargo;
    private javax.swing.ButtonGroup btnGroupGeneroCadFunc;
    private javax.swing.ButtonGroup btnGroupPebIPebII;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnRemoveTelefoneCadFunc;
    private javax.swing.JButton btnSalvarCadFunc;
    private javax.swing.JCheckBox checkPossuiDeficiencia;
    private javax.swing.JComboBox<String> comboAcessoUsrCadFunc;
    private javax.swing.JComboBox<Escola> comboEscolaOutroCargo;
    private javax.swing.JComboBox<String> comboEspecialidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Telefone> jListTelefonesCadFunc;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelEspecialidadePebII;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JPanel panelOutrosCargos;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelProf;
    private javax.swing.JPanel panelProf1PeriodoCargoCadFunc;
    private javax.swing.JPanel panelRadioPebIeIICadFunc;
    private javax.swing.JPanel panelTabUsuario;
    private javax.swing.JPanel panelTabelaBusca;
    private javax.swing.JPasswordField pswSenhaUsrCadFunc;
    private javax.swing.JRadioButton radioCargoOutrosCadFunc;
    private javax.swing.JRadioButton radioCargoProfCadFunc;
    private javax.swing.JRadioButton radioFemCadFunc;
    private javax.swing.JRadioButton radioHabilitaManha;
    private javax.swing.JRadioButton radioHabilitaTarde;
    private javax.swing.JRadioButton radioMascCadFunc;
    private javax.swing.JRadioButton radioPebICadFunc;
    private javax.swing.JRadioButton radioPebIICadFunc;
    private javax.swing.JPasswordField redPswSenhaUsrCadFunc;
    private javax.swing.JPanel tabCargoCadFunc;
    private javax.swing.JPanel tabDadosPessoasCadFunc;
    private javax.swing.JTabbedPane tabbedCadastrarFuncionarios;
    private javax.swing.JTable tabelaBuscaFuncionarios;
    private javax.swing.JTextArea txtAObservacoes;
    private javax.swing.JTextField txtBairroCadFunc;
    private javax.swing.JTextField txtBuscaFunc;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCepCadFunc;
    private javax.swing.JTextField txtCidadeCadFunc;
    private javax.swing.JFormattedTextField txtCpfCadFunc;
    private javax.swing.JTextField txtEnderecoCadFunc;
    private javax.swing.JFormattedTextField txtFDataNasc;
    private javax.swing.JTextField txtMatriculaCadFunc;
    private javax.swing.JTextField txtNickNameUsrCadFunc;
    private javax.swing.JTextField txtNomeCadFunc;
    private javax.swing.JTextField txtTelefonesCadFunc;
    // End of variables declaration//GEN-END:variables
    private Funcionario funcLogado = new Funcionario();
    private ProfessorPebI profPebI = new ProfessorPebI();
    private ProfessorPebII profPebII = new ProfessorPebII();
    private OutroCargo funcOutroCargo = new OutroCargo();
    private ProfessorPebIDAO pebidao = new ProfessorPebIDAO();
    private ProfessorPebIIDAO pebiidao = new ProfessorPebIIDAO();
    private OutroCargoDAO ocdao = new OutroCargoDAO();
    private FuncionarioDAO fdao = new FuncionarioDAO();
    private List<Telefone> telef = new ArrayList<>();
    private ConverteData converteData = new ConverteData();
    private VerificaCheckBox verificaCheck = new VerificaCheckBox();
    private CamposDeTelefone camposTelef = new CamposDeTelefone();
    private PreencheCombo preencheCombo = new PreencheCombo();
    private OuvintesAction oa = new OuvintesAction();
    private OuvintesItem oi = new OuvintesItem();
    private OuvintesListSelection ols = new OuvintesListSelection();
    private OuvinteFocus of = new OuvinteFocus();
    private OuvintesKeyListener okl = new OuvintesKeyListener();
    private TableModelFuncionario tmf = new TableModelFuncionario();
    private String nome, genero, endereco, bairro, cidade, cep, observacoes, cargo,
            cpf, matricula, especialidade, periodo, usrName, senha;
    private Date dataNasc;
    private boolean deficiencia;
    private Escola escolaOutroCargo = new Escola();
    int acesso;
    private boolean edicao, exclusao = false;
    private List<Funcionario> funcs = null;
    private VerificadorDeCpf ivcpf = new VerificadorDeCpf();

    class VerificadorDeCpf extends InputVerifier {
	public VerificadorDeCpf() {
        
        }
        
        @Override
	public boolean verify(JComponent jc) {
            txtCpfCadFunc = (JFormattedTextField) jc;
            String texto = txtCpfCadFunc.getText();
            String cpf = texto.substring(0, 3) + texto.substring(4, 7)
                    + texto.substring(8, 11) + texto.substring(12);

            try {
                if (cpf.trim().length() == 0){
                    return(true);
		}
                
                if (cpf.length() != 11) {
                    throw new IllegalArgumentException();
		}

		if (cpf.equals("00000000000") || cpf.equals("11111111111")
                    || cpf.equals("22222222222") || cpf.equals("33333333333")
                    || cpf.equals("44444444444") || cpf.equals("55555555555")
                    || cpf.equals("66666666666") || cpf.equals("77777777777")
                    || cpf.equals("88888888888") || cpf.equals("99999999999")){
                    
                    throw new IllegalArgumentException();
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

                // Calculo do 1o. Digito Verificador
		sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
		}

		r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
		} else {
                    dig10 = (char) (r + 48);
		} 

		// Calculo do 2o. Digito Verificador
		sm = 0;
		peso = 11;
		for (i = 0; i < 10; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
		}

		r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
		} else {
                    dig11 = (char) (r + 48);
		}

                if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                    return (true);
		} else {
                    throw new IllegalArgumentException();
		}

            } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(null, "CPF Inválido!");
		return (false);
            }
	}
    }    
    
    
    private class OuvintesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnAddTelefoneCadFunc){
                camposTelef.colocaTelefoneNaLista(telef, txtTelefonesCadFunc);
                camposTelef.exibeTelefonesNoJList(jListTelefonesCadFunc, telef);
            } else if (ae.getSource() == btnRemoveTelefoneCadFunc){
                camposTelef.excluiTelefoneDaLista(jListTelefonesCadFunc, telef);
                camposTelef.exibeTelefonesNoJList(jListTelefonesCadFunc, telef);
            } else if (ae.getSource() ==  btnSalvarCadFunc){
                salvar();
            } else if (ae.getSource() == btnCancelarCadFunc){
                cancelar();
            } else if (ae.getSource() == btnEditar){
                editar();
            } else if (ae.getSource() == btnExcluir){
                excluir();
            } else if (ae.getSource() == btnRelatorios){
                relatorio();
            } else if (ae.getSource() == btnNovo){
                novoFuncEnabled();
                estadoBotoesNovo();
            }
        }
        
    }
    
    private class OuvintesItem implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() ==  radioCargoProfCadFunc){
                verificaCargoEnabled();
            } else if (ie.getSource() == radioCargoOutrosCadFunc){
                verificaCargoEnabled();
            } else if (ie.getSource() == radioPebIICadFunc){
                pebiiEnabled();
            } else if (ie.getSource() == radioPebICadFunc){
                pebiEnabled();
            }
        }
    }
    
    class OuvinteFocus extends FocusAdapter {
        // Não seleciona
        @Override
	public void focusGained(FocusEvent e) {
            if (e.getSource() == txtCpfCadFunc){
		txtCpfCadFunc.setSelectionStart(0);
		//txtCpfCadFunc.setSelectionEnd(((String) txtCpfCadFunc.getValue()).length());
            }
        }
    }
    
    class OuvintesListSelection implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
                btnExcluir.setEnabled(true);
                btnEditar.setEnabled(true);
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
            String busca = "%" + txtBuscaFunc.getText() + "%";
            funcs = fdao.buscarPorNome(busca);
            atualizaTabela(funcs);
        }
        
    }
    
    private class TableModelFuncionario extends AbstractTableModel {
        private List<Funcionario> linhas;
        private String[] colunas = new String[] {"CPF", "Nome"};
        private static final int CPF = 0;
        private static final int NOME = 1;
 
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
            Funcionario f = linhas.get(rowIndex);
            switch (columnIndex) {
                case CPF:
                    return f.getCpf();
                case NOME:
                    return f.getNome();
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
