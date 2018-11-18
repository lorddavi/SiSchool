/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.dialogs.JDConfirmaCadastroAluno;
import br.com.davi.sischool.funcoes.CamposDeTelefone;
import br.com.davi.sischool.funcoes.ChecaCamposEmBranco;
import br.com.davi.sischool.funcoes.ConverteData;
import br.com.davi.sischool.funcoes.PreencheCombo;
import br.com.davi.sischool.funcoes.VerificaCheckBox;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.NotasFaltas;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Telefone;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.AlunoDAO;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Davi
 */
public class JFCadastrarAlunos extends javax.swing.JFrame {

    /**
     * Construtor vazio de JFTransferirAlunos
     */
    
    public JFCadastrarAlunos(){
        
    }
    
    /**
     * Construtor da classe que recebe como parâmetro um login e inicia os componentes
     * do frame.
     * @param login
     */
    public JFCadastrarAlunos(Login login) {
        initComponents();
        iniciarComponentes();
    }
    
    /**
     * Construtor da classe que recebe como parâmetro um aluno para edição.
     * @param oc
     * @param aluno
     */
    public JFCadastrarAlunos(OutroCargo oc, Aluno aluno){
        initComponents();
        iniciarEdicao(aluno);
    }
    
    public void iniciarComponentes(){
        preencherComboBox();
        setaListeners();
    }
    
    public void setaListeners(){
        comboEscolas.addActionListener(oa);
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnSalvarCadAluno.addActionListener(oa);
        btnRemoveTelefoneCadAluno.addActionListener(oa);
        btnAddTelefCadAluno.addActionListener(oa);
        radioOutroResponsavelCadAluno.addActionListener(oa);
        btnProcurarFoto.addActionListener(oa);
        btnProcurarComprovResidencia.addActionListener(oa);
        btnCancelar.addActionListener(oa);
    }
    
    public void iniciarEdicao(Aluno a){
        edicao = true;
        aluno = a;
        preencherComboBox();
        setaListeners();
        
        nome = a.getNome();
        ra = a.getRa();
        dataNasc = a.getDataNasc();
        genero = a.getGenero();
        endereco = a.getEndereco();
        bairro = a.getBairro();
        cep = a.getCep();
        escola = a.getEscola();
        turma = a.getSerie();
        comprovanteResidencia = "A VER MAIS TARDE";
        necesEspec = a.isNecesEspec();
        necesAcomp = a.isNecesEspecAcomp();
        transpEsc = a.isTranspPublicoEscolar();
        nomePai = a.getNomePai();
        checaPaiResp = a.isPaiResponsavel();
        nomeMae = a.getNomeMae();
        checaMaeResp = a.isMaeResponsavel();
        checaOutroResp = a.isOutroResponsavel();
        nomeResponsavel = a.getNomeResponsavel();
        parentescoResponsavel = a.getParentescoResponsavel();
        foto = a.getFoto3x4();
        telef = a.getTelefones();
        observacoes = a.getObservacoes();
        comprovante = a.getComprovanteResidencia();
        
        txtNome.setText(nome);
        txtRa.setText(ra);
        ftxtDataNasc.setText(converteData.converteDateParaString(dataNasc));
        editaGenero(genero);
        txtEndereco.setText(endereco);
        txtBairro.setText(bairro);
        txtCep.setText(cep);
        comboEscolas.setSelectedItem(escola);
        comboBoxSerie.setSelectedItem(turma);
        //comprov Residencia
        checkNecessidadesEspeciaisCadastroAluno.setSelected(necesEspec);
        checkNecessidadesEspeciaisAcompCadAluno.setSelected(necesAcomp);
        checkTransporteEscolarCadastroAluno.setSelected(transpEsc);
        txtNomePai.setText(nomePai);
        checkPaiResponsavelCadAluno.setSelected(checaPaiResp);
        txtNomeMae.setText(nomeMae);
        checkMaeResponsavelCadAluno.setSelected(checaMaeResp);
        radioOutroResponsavelCadAluno.setSelected(checaOutroResp);
        txtNomeResponsavel.setText(nomeResponsavel);
        txtParentescoResponsavel.setText(parentescoResponsavel);
        lblImagem.setText("");
        try {
            lblImagem.setIcon(pegaImagemByte(foto, 117, 117));
        } catch (NullPointerException e){
            lblImagem.setIcon(null);
            lblImagem.setText("Carregue uma imagem");
        }
        
        try {
            lblComprovante.setIcon(pegaImagemByte(comprovante, 50, 50));
        } catch (NullPointerException e){
            lblComprovante.setIcon(null);
        }
        camposTelef.exibeTelefonesNoJList(jListTelefones, telef);
        txtAObservacoes.setText(observacoes);
        
        comboEscolas.setEnabled(false);
    }
    
    public void editaGenero(String genero){
        if (genero.equals("Masculino")){
            radioMasculinoCadastroAluno.setSelected(true);
        } else {
            radioFemininoCadastroAluno.setSelected(true);
        }
    }
    
    /**
    * Preenche os comboBox de escolas e turmas.
    */
    private void preencherComboBox(){
        preencheCombo.preencheEscolas(comboEscolas);
        preencheCombo.preencheTurmas(comboBoxSerie, preencheCombo.pegaEscola(comboEscolas));
    }
    
    /*
    * Verifica se há campos em branco e, caso haja, requisita o foco para este.
    */
    private boolean checaNaoPreenchido() {
        return checaCampos.checaNaoPreenchido(txtNome, tabbedPaneCadastroAluno, 0);
    }
    
    /*
    * Verifica e retorna verdadeiro ou falso se os checkBox ou o radioButton estão 
    * selecionados. 
    */
    private boolean checaResponsavel(){
        if (!checkPaiResponsavelCadAluno.isSelected() && !checkMaeResponsavelCadAluno.isSelected() 
                && !radioOutroResponsavelCadAluno.isSelected()) {
            checkPaiResponsavelCadAluno.requestFocus();
            return false;
        } 
        return true;
    }
    
    /*
    * Confere se, no caso de haver outro responsável, este teve seus dados preenchidos.
    */
    private boolean checaPreenchidoResponsavel(){
        if (radioOutroResponsavelCadAluno.isSelected()){
            if (txtNomeResponsavel.getText().trim().equals("")){
                tabbedPaneCadastroAluno.setSelectedIndex(1);
                txtNomeResponsavel.requestFocus();
                return false;
            } else if (txtParentescoResponsavel.getText().trim().equals("")){
                tabbedPaneCadastroAluno.setSelectedIndex(1);
                txtParentescoResponsavel.requestFocus();
                return false;
            }
        }
        return true;
    }
    
    private boolean checaData(){ //PRECISA SER ACERTADO
        if (ftxtDataNasc.getText().trim().equals("")) {
            tabbedPaneCadastroAluno.setSelectedIndex(0);
            ftxtDataNasc.requestFocus();
            return false;
        } 
        return true;
    }
    
    /*
    * Verifica se o radioButton está selecionado. Se estiver, os TextFields
    * recebem enabled(true).
    */
    public void checaRadioResponsavelEnabled(){
        if (radioOutroResponsavelCadAluno.isSelected()){
            txtNomeResponsavel.setEnabled(true);
            txtParentescoResponsavel.setEnabled(true);
        } else {
            txtNomeResponsavel.setEnabled(false);
            txtParentescoResponsavel.setEnabled(false);
        }
    }
    
    /**
    * Coloca todos os campos preenchidos em variáveis e, por fim, atribui seus
    * valores a um aluno.
    */
    private void defineAluno() {
        try { 
            nome = txtNome.getText();
            ra = txtRa.getText();
            dataNasc = converteData.converteDataParaUtilDate(ftxtDataNasc);
            genero = verificaCheck.checaGenero(radioMasculinoCadastroAluno);
            endereco = txtEndereco.getText();
            bairro = txtBairro.getText();
            cep = txtCep.getText();
            escola =  preencheCombo.pegaEscola(comboEscolas);
            turma = preencheCombo.pegaTurma(comboBoxSerie);
            //comprovanteResidencia = "A VER MAIS TARDE";
            necesEspec = verificaCheck.checaVerdadeiroFalso(checkNecessidadesEspeciaisCadastroAluno);
            necesAcomp = verificaCheck.checaVerdadeiroFalso(checkNecessidadesEspeciaisAcompCadAluno);
            transpEsc = verificaCheck.checaVerdadeiroFalso(checkTransporteEscolarCadastroAluno);
            nomePai = txtNomePai.getText();
            checaPaiResp = verificaCheck.checaVerdadeiroFalso(checkPaiResponsavelCadAluno);
            nomeMae = txtNomeMae.getText();
            checaMaeResp = verificaCheck.checaVerdadeiroFalso(checkMaeResponsavelCadAluno);
            checaOutroResp = verificaCheck.checaVerdadeiroFalso(radioOutroResponsavelCadAluno);
            nomeResponsavel = txtNomeResponsavel.getText();
            parentescoResponsavel = txtParentescoResponsavel.getText();
            //foto3x4 = "TEM QUE VER ESSA FITA AÍ";
            List<Telefone> telefones = telef;
            observacoes = txtAObservacoes.getText();

            aluno.setNome(nome);
            aluno.setRa(ra);
            aluno.setDataNasc(dataNasc);
            aluno.setGenero(genero);
            aluno.setEndereco(endereco);
            aluno.setBairro(bairro);
            aluno.setCep(cep);
            aluno.setCidade("Avaré");
            aluno.setEscola(escola);
            aluno.setSerie(turma);
            aluno.setComprovanteResidencia(comprovante);
            aluno.setNecesEspec(necesEspec);
            aluno.setNecesEspecAcomp(necesAcomp);
            aluno.setTranspPublicoEscolar(transpEsc);
            aluno.setNomePai(nomePai);
            aluno.setPaiResponsavel(checaPaiResp);
            aluno.setNomeMae(nomeMae);
            aluno.setMaeResponsavel(checaMaeResp);
            aluno.setOutroResponsavel(checaOutroResp);
            aluno.setNomeResponsavel(nomeResponsavel);
            aluno.setParentescoResponsavel(parentescoResponsavel);
            aluno.setAtivo(true);
            try{
                aluno.setFoto3x4(foto);
            } catch(Exception e){
                e.printStackTrace();
            }
            aluno.setTelefones(telefones);
            aluno.setObservacoes(observacoes);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    
    private void procurarFoto(){
        fileChooserFoto.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg"));
        fileChooserFoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooserFoto.showDialog(fileChooserFoto, "Selecione");
        ImageIcon mostrarFoto = pegaImagem(fileChooserFoto.getSelectedFile().getAbsolutePath(), 117, 117);
        try {
            foto = converterArquivo(fileChooserFoto.getSelectedFile());
        } catch (Exception ex) {
            System.out.println("Erro ao gravar foto." + ex.getMessage());
        }
        lblImagem.setText("");
        lblImagem.setIcon(mostrarFoto);
    }
    
    private void procurarComprovante(){
        fileChooserComprovante.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg"));
        fileChooserComprovante.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooserComprovante.showDialog(fileChooserComprovante, "Selecione");
        ImageIcon mostrarComp = pegaImagem(fileChooserComprovante.getSelectedFile().getAbsolutePath(), 50, 50);
        try {
            comprovante = converterArquivo(fileChooserComprovante.getSelectedFile());
        } catch (Exception ex) {
            System.out.println("Erro ao gravar comprovante: " +  ex.getMessage());
        }
        lblComprovante.setIcon(mostrarComp);
    }
    
    public byte[] converterArquivo(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[25600];
        int bytesRead = 0;
        while ((bytesRead = fis.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }
    
    private ImageIcon pegaImagem(String caminho, int w, int h){
        ImageIcon foto = new ImageIcon(caminho);
        Image imagem = foto.getImage();
        Image newimg = imagem.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        ImageIcon pronta = new ImageIcon(newimg);
        return pronta;
    }
    
    private ImageIcon pegaImagemByte(byte[] b, int w, int h){
        ImageIcon foto = new ImageIcon(b);
        Image imagem = foto.getImage();
        Image newimg = imagem.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        ImageIcon pronta = new ImageIcon(newimg);
        return pronta;
    }
    
    private void adicionaTelefone(){
        if (txtTelefones.getText().trim().length() != 0){
            camposTelef.colocaTelefoneNaLista(telef, txtTelefones);
            camposTelef.exibeTelefonesNoJList(jListTelefones, telef); 
        } else {
            JOptionPane.showMessageDialog(this, "Digite o número de telefone antes de adicioná-lo!");
        }
    }
    
    private void removeTelefone(){
        if (jListTelefones.getSelectedIndex() != -1){
            camposTelef.excluiTelefoneDaLista(jListTelefones, telef);
            camposTelef.exibeTelefonesNoJList(jListTelefones, telef);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum telefone selecionado.");
        }
    }
    
    private void limpar(){
       telef = new ArrayList<>();
       nome = ""; ra = ""; genero = "Masculino"; endereco = ""; bairro = ""; 
       cep = ""; nomePai = ""; nomeMae = ""; nomeResponsavel = ""; 
       parentescoResponsavel = ""; observacoes = ""; 
       foto = null; comprovante = null; dataNasc = null; escola = null;
       turma = null; necesEspec = false; necesAcomp = false; transpEsc = false;
       checaPaiResp = false; checaMaeResp = false; checaOutroResp = false;
       notasFaltas = new ArrayList<>();
       edicao = false;
       aluno = new Aluno();
       
       txtNome.setText(""); txtRa.setText(""); ftxtDataNasc.setText("");
       editaGenero(genero); txtEndereco.setText(""); txtBairro.setText("");
        txtCep.setText("");
        comboEscolas.setSelectedIndex(0); comboBoxSerie.setSelectedIndex(0);
        
        checkNecessidadesEspeciaisCadastroAluno.setSelected(false);
        checkNecessidadesEspeciaisAcompCadAluno.setSelected(false);
        checkTransporteEscolarCadastroAluno.setSelected(false);
        checkMaeResponsavelCadAluno.setSelected(false);
        radioOutroResponsavelCadAluno.setSelected(false);
        checkPaiResponsavelCadAluno.setSelected(false);
                
        txtNomePai.setText(""); txtNomeMae.setText(""); txtNomeResponsavel.setText("");
        txtParentescoResponsavel.setText("");
        lblImagem.setText("Carregue uma imagem.");
        lblImagem.setIcon(null);
        lblComprovante.setIcon(null);
        
        camposTelef.exibeTelefonesNoJList(jListTelefones, telef);
        txtAObservacoes.setText("");
        
        comboEscolas.setEnabled(true);
    }
    
    /*
    * Verifica se os campos estão preenchidos, valida os dados inseridos e persiste
    * os dados.
    */
    private void salvar() {
       defineAluno();
        if (edicao){
            adao.editar(aluno);
            JOptionPane.showMessageDialog(this, "Editado!");
        } else {
            NotasFaltas nf[] = new NotasFaltas[8];
            String materias[] =  {"Matemática", "Português", "Ciências", "História",
                "Geografia", "Artes", "Inglês", "Educação Física"};
            Calendar cal = Calendar.getInstance();
            int ano = cal.get(Calendar.YEAR);
            for (int i=0; i<8; i++){
                nf[i] = new NotasFaltas();
                nf[i].setAno(String.valueOf(ano));
                nf[i].setMateria(materias[i]);
                nf[i].setSituacao("Reprovado");
                notasFaltas.add(nf[i]);
            }
            
            aluno.setNotasFaltas(notasFaltas);

            boolean preenchido = checaNaoPreenchido();
            boolean responsavel = checaResponsavel();
            boolean preenchidoResponsavel = checaPreenchidoResponsavel();
            boolean data = checaData();
            try {
                if (preenchido != true){
                    JOptionPane.showMessageDialog(null, "Há campos em branco!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (responsavel != true) {
                    JOptionPane.showMessageDialog(null, "Você precisa marcar alguém como responsável.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (preenchidoResponsavel != true) {
                    JOptionPane.showMessageDialog(null, "Preencha o nome e parentesco do responsável.", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } else if(data != true) {
                    JOptionPane.showMessageDialog(null, "Data inválida!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);

                } else {
                    adao.inserir(aluno);
                    //defineTurma(aluno);
                    JDConfirmaCadastroAluno cc = new JDConfirmaCadastroAluno(this, rootPaneCheckingEnabled);
                    cc.setVisible(true);
                }
                
                aluno = null;
                limpar();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } 
    }
    
    /**
     * Inicia os componentes do form. Criado automaticamente pelo swing e, portanto,
     * é inalterável.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileChooserFoto = new javax.swing.JFileChooser();
        fileChooserComprovante = new javax.swing.JFileChooser();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedPaneCadastroAluno = new javax.swing.JTabbedPane();
        scrollPaneCadastroAlunoAluno = new javax.swing.JScrollPane();
        paneCadastroAlunoAluno = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        paneGeneroCadastroAluno = new javax.swing.JPanel();
        radioMasculinoCadastroAluno = new javax.swing.JRadioButton();
        radioFemininoCadastroAluno = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnProcurarComprovResidencia = new javax.swing.JButton();
        panelCheckBoxCadastroAluno = new javax.swing.JPanel();
        checkTransporteEscolarCadastroAluno = new javax.swing.JCheckBox();
        checkNecessidadesEspeciaisAcompCadAluno = new javax.swing.JCheckBox();
        checkNecessidadesEspeciaisCadastroAluno = new javax.swing.JCheckBox();
        ftxtDataNasc = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboEscolas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboBoxSerie = new javax.swing.JComboBox<>();
        txtCep = new javax.swing.JFormattedTextField();
        lblComprovante = new javax.swing.JLabel();
        scrollPaneCadastroAlunoResponsavel = new javax.swing.JScrollPane();
        paneCadastroAlunoResponsavel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomePai = new javax.swing.JTextField();
        checkPaiResponsavelCadAluno = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        checkMaeResponsavelCadAluno = new javax.swing.JCheckBox();
        txtNomeMae = new javax.swing.JTextField();
        radioOutroResponsavelCadAluno = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        scrollPaneObservacoesCadAluno = new javax.swing.JScrollPane();
        txtAObservacoes = new javax.swing.JTextArea();
        paneFotoAluno = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnProcurarFoto = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        btnAddTelefCadAluno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefones = new javax.swing.JList<>();
        txtTelefones = new javax.swing.JTextField();
        btnRemoveTelefoneCadAluno = new javax.swing.JButton();
        panelOutroResponsavel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeResponsavel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtParentescoResponsavel = new javax.swing.JTextField();
        btnSalvarCadAluno = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        fileChooserFoto.setDialogTitle("Selecione uma imagem");
        fileChooserFoto.setFileFilter(new MeuFiltroPersonalizado());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setExtendedState(NORMAL);
        setLocation(new java.awt.Point(0, 0));
        setName("framePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
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
        lblTituloPrincipal.setText("SiSchool - Cadastrar Alunos");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        scrollPaneCadastroAlunoAluno.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        paneCadastroAlunoAluno.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setLabelFor(txtNome);
        jLabel9.setText("Nome:");
        jLabel9.setName(""); // NOI18N

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setLabelFor(txtRa);
        jLabel10.setText("RA:");

        txtRa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRa.setInputVerifier(new VerificadorDeRA());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Data de nascimento:");

        paneGeneroCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        paneGeneroCadastroAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gênero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        buttonGroup1.add(radioMasculinoCadastroAluno);
        radioMasculinoCadastroAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioMasculinoCadastroAluno.setSelected(true);
        radioMasculinoCadastroAluno.setText("Masculino");

        buttonGroup1.add(radioFemininoCadastroAluno);
        radioFemininoCadastroAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioFemininoCadastroAluno.setText("Feminino");

        javax.swing.GroupLayout paneGeneroCadastroAlunoLayout = new javax.swing.GroupLayout(paneGeneroCadastroAluno);
        paneGeneroCadastroAluno.setLayout(paneGeneroCadastroAlunoLayout);
        paneGeneroCadastroAlunoLayout.setHorizontalGroup(
            paneGeneroCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneGeneroCadastroAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneGeneroCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioMasculinoCadastroAluno)
                    .addComponent(radioFemininoCadastroAluno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneGeneroCadastroAlunoLayout.setVerticalGroup(
            paneGeneroCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneGeneroCadastroAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioMasculinoCadastroAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(radioFemininoCadastroAluno)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setLabelFor(txtEndereco);
        jLabel12.setText("Endereço:");

        txtEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setLabelFor(txtBairro);
        jLabel13.setText("Bairro:");

        txtBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Comprovante de residência:");

        btnProcurarComprovResidencia.setText("Procurar");

        panelCheckBoxCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        panelCheckBoxCadastroAluno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkTransporteEscolarCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkTransporteEscolarCadastroAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkTransporteEscolarCadastroAluno.setText("Utiliza transporte público escolar.");

        checkNecessidadesEspeciaisAcompCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkNecessidadesEspeciaisAcompCadAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkNecessidadesEspeciaisAcompCadAluno.setText("Necessita de Acompanhante.");

        checkNecessidadesEspeciaisCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkNecessidadesEspeciaisCadastroAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkNecessidadesEspeciaisCadastroAluno.setText("Portador de necessidades especiais.");

        javax.swing.GroupLayout panelCheckBoxCadastroAlunoLayout = new javax.swing.GroupLayout(panelCheckBoxCadastroAluno);
        panelCheckBoxCadastroAluno.setLayout(panelCheckBoxCadastroAlunoLayout);
        panelCheckBoxCadastroAlunoLayout.setHorizontalGroup(
            panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckBoxCadastroAlunoLayout.createSequentialGroup()
                .addGroup(panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkNecessidadesEspeciaisCadastroAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(checkTransporteEscolarCadastroAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkNecessidadesEspeciaisAcompCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelCheckBoxCadastroAlunoLayout.setVerticalGroup(
            panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckBoxCadastroAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkNecessidadesEspeciaisAcompCadAluno)
                    .addComponent(checkNecessidadesEspeciaisCadastroAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkTransporteEscolarCadastroAluno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            ftxtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataNasc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ftxtDataNasc.setInputVerifier(new VerificadorDeData());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("CEP:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Escola:");

        comboEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setLabelFor(comboBoxSerie);
        jLabel7.setText("Turma:");

        comboBoxSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCep.setInputVerifier(new VerificadorCEP());

        javax.swing.GroupLayout paneCadastroAlunoAlunoLayout = new javax.swing.GroupLayout(paneCadastroAlunoAluno);
        paneCadastroAlunoAluno.setLayout(paneCadastroAlunoAlunoLayout);
        paneCadastroAlunoAlunoLayout.setHorizontalGroup(
            paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addComponent(panelCheckBoxCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                    .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                            .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(txtRa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ftxtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11)))
                                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGap(110, 110, 110)
                                    .addComponent(paneGeneroCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(comboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel12))
                            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnProcurarComprovResidencia))))
                        .addGap(0, 102, Short.MAX_VALUE))))
        );
        paneCadastroAlunoAlunoLayout.setVerticalGroup(
            paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addComponent(paneGeneroCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14)
                    .addComponent(btnProcurarComprovResidencia))
                .addGap(5, 5, 5)
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17))
                    .addComponent(lblComprovante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(panelCheckBoxCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        scrollPaneCadastroAlunoAluno.setViewportView(paneCadastroAlunoAluno);

        tabbedPaneCadastroAluno.addTab("Aluno", scrollPaneCadastroAlunoAluno);

        scrollPaneCadastroAlunoResponsavel.setBackground(new java.awt.Color(204, 204, 204));
        scrollPaneCadastroAlunoResponsavel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        paneCadastroAlunoResponsavel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setLabelFor(txtNomePai);
        jLabel1.setText("Nome do pai:");

        txtNomePai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        checkPaiResponsavelCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkPaiResponsavelCadAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkPaiResponsavelCadAluno.setText("Marcar como responsável");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setLabelFor(txtNomeMae);
        jLabel2.setText("Nome da mãe:");

        checkMaeResponsavelCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkMaeResponsavelCadAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkMaeResponsavelCadAluno.setText("Marcar como responsável");

        txtNomeMae.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        radioOutroResponsavelCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        radioOutroResponsavelCadAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioOutroResponsavelCadAluno.setText("Outro responsável.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telefones:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setLabelFor(txtAObservacoes);
        jLabel6.setText("Observações:");

        txtAObservacoes.setColumns(20);
        txtAObservacoes.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtAObservacoes.setLineWrap(true);
        txtAObservacoes.setRows(5);
        txtAObservacoes.setWrapStyleWord(true);
        scrollPaneObservacoesCadAluno.setViewportView(txtAObservacoes);

        paneFotoAluno.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Foto 3x4 do aluno.");

        btnProcurarFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProcurarFoto.setText("Procurar");

        lblImagem.setText("Carregue uma imagem.");

        javax.swing.GroupLayout paneFotoAlunoLayout = new javax.swing.GroupLayout(paneFotoAluno);
        paneFotoAluno.setLayout(paneFotoAlunoLayout);
        paneFotoAlunoLayout.setHorizontalGroup(
            paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFotoAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneFotoAlunoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFotoAlunoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFotoAlunoLayout.createSequentialGroup()
                                .addComponent(btnProcurarFoto)
                                .addGap(21, 21, 21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFotoAlunoLayout.createSequentialGroup()
                        .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        paneFotoAlunoLayout.setVerticalGroup(
            paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFotoAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcurarFoto)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        btnAddTelefCadAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/adic.png"))); // NOI18N
        btnAddTelefCadAluno.setContentAreaFilled(false);

        jListTelefones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListTelefones.setAutoscrolls(false);
        jScrollPane1.setViewportView(jListTelefones);

        txtTelefones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTelefones.setToolTipText("Digite um telefone para adicioná-lo.");
        txtTelefones.setInputVerifier(new VerificadorDeTelefone());
        txtTelefones.setName(""); // NOI18N

        btnRemoveTelefoneCadAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/minus.png"))); // NOI18N
        btnRemoveTelefoneCadAluno.setContentAreaFilled(false);

        panelOutroResponsavel.setBackground(new java.awt.Color(204, 204, 204));
        panelOutroResponsavel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setLabelFor(txtNomeResponsavel);
        jLabel3.setText("Nome do responsável:");

        txtNomeResponsavel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNomeResponsavel.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setLabelFor(txtParentescoResponsavel);
        jLabel4.setText("Parentesco:");

        txtParentescoResponsavel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtParentescoResponsavel.setEnabled(false);

        javax.swing.GroupLayout panelOutroResponsavelLayout = new javax.swing.GroupLayout(panelOutroResponsavel);
        panelOutroResponsavel.setLayout(panelOutroResponsavelLayout);
        panelOutroResponsavelLayout.setHorizontalGroup(
            panelOutroResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutroResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOutroResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtParentescoResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(txtNomeResponsavel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOutroResponsavelLayout.setVerticalGroup(
            panelOutroResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutroResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtParentescoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneCadastroAlunoResponsavelLayout = new javax.swing.GroupLayout(paneCadastroAlunoResponsavel);
        paneCadastroAlunoResponsavel.setLayout(paneCadastroAlunoResponsavelLayout);
        paneCadastroAlunoResponsavelLayout.setHorizontalGroup(
            paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomePai)
                            .addComponent(txtNomeMae)
                            .addComponent(panelOutroResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addComponent(radioOutroResponsavelCadAluno)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(paneFotoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(checkMaeResponsavelCadAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addGap(209, 209, 209))
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66)
                        .addComponent(checkPaiResponsavelCadAluno)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTelefones, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddTelefCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemoveTelefoneCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addComponent(scrollPaneObservacoesCadAluno)
                                .addGap(131, 131, 131)))))
                .addGap(46, 46, 46))
        );
        paneCadastroAlunoResponsavelLayout.setVerticalGroup(
            paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(checkPaiResponsavelCadAluno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(checkMaeResponsavelCadAluno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioOutroResponsavelCadAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOutroResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addComponent(paneFotoAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(103, 103, 103)))
                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addComponent(txtTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addComponent(btnAddTelefCadAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoveTelefoneCadAluno))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollPaneObservacoesCadAluno))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        scrollPaneCadastroAlunoResponsavel.setViewportView(paneCadastroAlunoResponsavel);

        tabbedPaneCadastroAluno.addTab("Responsável", scrollPaneCadastroAlunoResponsavel);

        btnSalvarCadAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarCadAluno.setText("Salvar");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarCadAluno)
                .addGap(123, 123, 123))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(tabbedPaneCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarCadAluno)
                    .addComponent(btnCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que detecta quando o form é arrastado e o salva na nova localização.
     * Foi necessário implementar esse método pois o frame foi declarado como
     * undecorated(true) para eliminar a barra padrão do windows.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point posicaoNova = new Point(evt.getXOnScreen(), evt.getYOnScreen());
	setLocation(posicaoNova);
    }//GEN-LAST:event_formMouseDragged

    //Início de código inalterável criado pelo Netbeans.
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTelefCadAluno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnProcurarComprovResidencia;
    private javax.swing.JButton btnProcurarFoto;
    private javax.swing.JButton btnRemoveTelefoneCadAluno;
    private javax.swing.JButton btnSalvarCadAluno;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkMaeResponsavelCadAluno;
    private javax.swing.JCheckBox checkNecessidadesEspeciaisAcompCadAluno;
    private javax.swing.JCheckBox checkNecessidadesEspeciaisCadastroAluno;
    private javax.swing.JCheckBox checkPaiResponsavelCadAluno;
    private javax.swing.JCheckBox checkTransporteEscolarCadastroAluno;
    private javax.swing.JComboBox<Turma> comboBoxSerie;
    private javax.swing.JComboBox<Escola> comboEscolas;
    private javax.swing.JFileChooser fileChooserComprovante;
    private javax.swing.JFileChooser fileChooserFoto;
    private javax.swing.JFormattedTextField ftxtDataNasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Telefone> jListTelefones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblComprovante;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel paneCadastroAlunoAluno;
    private javax.swing.JPanel paneCadastroAlunoResponsavel;
    private javax.swing.JPanel paneFotoAluno;
    private javax.swing.JPanel paneGeneroCadastroAluno;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelCheckBoxCadastroAluno;
    private javax.swing.JPanel panelOutroResponsavel;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioFemininoCadastroAluno;
    private javax.swing.JRadioButton radioMasculinoCadastroAluno;
    private javax.swing.JRadioButton radioOutroResponsavelCadAluno;
    private javax.swing.JScrollPane scrollPaneCadastroAlunoAluno;
    private javax.swing.JScrollPane scrollPaneCadastroAlunoResponsavel;
    private javax.swing.JScrollPane scrollPaneObservacoesCadAluno;
    private javax.swing.JTabbedPane tabbedPaneCadastroAluno;
    private javax.swing.JTextArea txtAObservacoes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtNomePai;
    private javax.swing.JTextField txtNomeResponsavel;
    private javax.swing.JTextField txtParentescoResponsavel;
    private javax.swing.JTextField txtRa;
    private javax.swing.JTextField txtTelefones;
    // End of variables declaration//GEN-END:variables
    //Fim de código inalterável criado pelo Netbeans.
    //Início da declaração das variáveis criadas por mim.
    private List<Telefone> telef = new ArrayList<>();
    private PreencheCombo preencheCombo = new PreencheCombo();
    private VerificaCheckBox verificaCheck = new VerificaCheckBox();
    private CamposDeTelefone camposTelef = new CamposDeTelefone();
    private ConverteData converteData = new ConverteData();
    private ChecaCamposEmBranco checaCampos = new ChecaCamposEmBranco();
    private OuvintesAction oa = new OuvintesAction();
    private String nome, ra, genero, endereco, bairro, cep, comprovanteResidencia,
            nomePai, nomeMae, nomeResponsavel, parentescoResponsavel, 
            observacoes; 
    private byte[] foto, comprovante;
    private Date dataNasc;
    private Escola escola;
    private Turma turma;
    private boolean necesEspec, necesAcomp, transpEsc, checaPaiResp, checaMaeResp,
            checaOutroResp;
    private List<NotasFaltas> notasFaltas = new ArrayList<>();
    private boolean edicao = false;
    private Aluno aluno = new Aluno();
    private AlunoDAO adao = new AlunoDAO();
    //Fim da declaração das variáveis declaradas por mim.
    
    class VerificadorDeData extends InputVerifier {
	public VerificadorDeData() {
        
        }
        
        @Override
	public boolean verify(JComponent jc) {
            ftxtDataNasc = (JFormattedTextField) jc;
            String texto = ftxtDataNasc.getText();
            String data = texto.substring(0, 2) + texto.substring(3, 5)
                    + texto.substring(6, 10);

            try {
                if (data.trim().length() == 0){
                    return(true);
		}
                
                if (data.length() != 8) {
                    throw new IllegalArgumentException();
		}
                
                int idade = 0;
                try {
                    Date dataN = converteData.converteDataParaUtilDate(ftxtDataNasc);
                    idade = converteData.calculaIdade(dataN);
                } catch (Exception e){
                    throw new IllegalArgumentException();
                }
                
                if (idade < 0 || idade > 12){
                    throw new IllegalArgumentException();
                } else {
                    return true;
                }
                
            } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(null, "Data inválida!");
		return (false);
            }
        }
    }    
    
    class VerificadorCEP extends InputVerifier {
	public VerificadorCEP() {
        }
        
        @Override
	public boolean verify(JComponent jc) {
            txtCep = (JFormattedTextField) jc;
            String texto = txtCep.getText();
           
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
    
    class VerificadorDeTelefone extends InputVerifier {
	public VerificadorDeTelefone() {
        }
        
        @Override
	public boolean verify(JComponent jc) {
            txtTelefones = (javax.swing.JTextField) jc;
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
                
                switch (texto.length()) {
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
    
    class VerificadorDeRA extends InputVerifier {
	public VerificadorDeRA() {
        }
        
        @Override
	public boolean verify(JComponent jc) {
            txtRa = (javax.swing.JTextField) jc;
            String texto = txtRa.getText();
            

            try {
                
            for (Aluno a: adao.buscaTodos()){
                if (a.getRa().equals(texto)){
                    JOptionPane.showMessageDialog(null, "Esse RA já está cadastrado!");
                    return false;
                }
            }
            
            if (texto.trim().length() > 5){
                return(true);
            } else {
                throw new IllegalArgumentException();
            }
                
            } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(null, "RA inválido");
		return (false);
            }
        }
    }  
    
    private class OuvintesAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == comboEscolas){
                comboBoxSerie.removeAllItems();
                Escola esc = preencheCombo.pegaEscola(comboEscolas);
                preencheCombo.preencheTurmas(comboBoxSerie, esc);
            } else if (evt.getSource() == btnFechar){
                dispose();
            } else if (evt.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (evt.getSource() == radioOutroResponsavelCadAluno){
                checaRadioResponsavelEnabled();
            } else if (evt.getSource() == btnSalvarCadAluno){
                salvar();
            } else if (evt.getSource() == btnRemoveTelefoneCadAluno){
                removeTelefone();
            } else if (evt.getSource() == btnAddTelefCadAluno){
                adicionaTelefone();
            }  else if (evt.getSource() == btnProcurarFoto){
                procurarFoto();
            } else if (evt.getSource() == btnProcurarComprovResidencia){
                procurarComprovante();
            } else if (evt.getSource() == btnCancelar){
                limpar();
            }
        }
    }
    
    class MeuFiltroPersonalizado extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            //Permite apenas arquivos com a extensão jpg
            return file.isDirectory() || file.getAbsolutePath().endsWith(".jpg");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Imagem (*.jpg)";
        }
    } 
}
