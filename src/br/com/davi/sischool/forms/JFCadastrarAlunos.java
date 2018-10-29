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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

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
        comboEscolasCadAluno.addActionListener(oa);
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnSalvarCadAluno.addActionListener(oa);
        btnRemoveTelefoneCadAluno.addActionListener(oa);
        btnAddTelefCadAluno.addActionListener(oa);
        radioOutroResponsavelCadAluno.addActionListener(oa);
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
        foto3x4 = "TEM QUE VER ESSA FITA AÍ";
        List<Telefone> telefones = a.getTelefones();
        observacoes = a.getObservacoes();
        
        txtNomeCadastroAluno.setText(nome);
        txtRaCadastroAluno.setText(ra);
        ftxtDataNasc.setText(converteData.converteDateParaString(dataNasc));
        editaGenero(genero);
        txtEnderecoCadastroAluno.setText(endereco);
        txtBairroCadastroAluno.setText(bairro);
        txtCep.setText(cep);
        comboEscolasCadAluno.setSelectedItem(escola);
        comboBoxSerieCadastroAluno.setSelectedItem(turma);
        //comprov Residencia
        checkNecessidadesEspeciaisCadastroAluno.setSelected(necesEspec);
        checkNecessidadesEspeciaisAcompCadAluno.setSelected(necesAcomp);
        checkTransporteEscolarCadastroAluno.setSelected(transpEsc);
        txtNomePaiCadastroAluno.setText(nomePai);
        checkPaiResponsavelCadAluno.setSelected(checaPaiResp);
        txtNomeMaeCadAluno.setText(nomeMae);
        checkMaeResponsavelCadAluno.setSelected(checaMaeResp);
        radioOutroResponsavelCadAluno.setSelected(checaOutroResp);
        txtNomeResponsavelCadAluno.setText(nomeResponsavel);
        txtParentescoResponsavelCadAluno.setText(parentescoResponsavel);
        //foto3x4
        telef = telefones;
        txtAObservacoesCadAluno.setText(observacoes);
        
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
        preencheCombo.preencheEscolas(comboEscolasCadAluno);
        preencheCombo.preencheTurmas(comboBoxSerieCadastroAluno, preencheCombo.pegaEscola(comboEscolasCadAluno));
    }
    
    /*
    * Verifica se há campos em branco e, caso haja, requisita o foco para este.
    */
    private boolean checaNaoPreenchido() {
        return checaCampos.checaNaoPreenchido(txtNomeCadastroAluno, tabbedPaneCadastroAluno, 0);
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
            if (txtNomeResponsavelCadAluno.getText().trim().equals("")){
                tabbedPaneCadastroAluno.setSelectedIndex(1);
                txtNomeResponsavelCadAluno.requestFocus();
                return false;
            } else if (txtParentescoResponsavelCadAluno.getText().trim().equals("")){
                tabbedPaneCadastroAluno.setSelectedIndex(1);
                txtParentescoResponsavelCadAluno.requestFocus();
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
            txtNomeResponsavelCadAluno.setEnabled(true);
            txtParentescoResponsavelCadAluno.setEnabled(true);
        } else {
            txtNomeResponsavelCadAluno.setEnabled(false);
            txtParentescoResponsavelCadAluno.setEnabled(false);
        }
    }
    
    /**
    * Coloca todos os campos preenchidos em variáveis e, por fim, atribui seus
    * valores a um aluno.
    */
    private void defineAluno() {
        nome = txtNomeCadastroAluno.getText();
        ra = txtRaCadastroAluno.getText();
        dataNasc = converteData.converteDataParaUtilDate(ftxtDataNasc);
        genero = verificaCheck.checaGenero(radioMasculinoCadastroAluno);
        endereco = txtEnderecoCadastroAluno.getText();
        bairro = txtBairroCadastroAluno.getText();
        cep = txtCep.getText();
        escola =  preencheCombo.pegaEscola(comboEscolasCadAluno);
        turma = preencheCombo.pegaTurma(comboBoxSerieCadastroAluno);
        comprovanteResidencia = "A VER MAIS TARDE";
        necesEspec = verificaCheck.checaVerdadeiroFalso(checkNecessidadesEspeciaisCadastroAluno);
        necesAcomp = verificaCheck.checaVerdadeiroFalso(checkNecessidadesEspeciaisAcompCadAluno);
        transpEsc = verificaCheck.checaVerdadeiroFalso(checkTransporteEscolarCadastroAluno);
        nomePai = txtNomePaiCadastroAluno.getText();
        checaPaiResp = verificaCheck.checaVerdadeiroFalso(checkPaiResponsavelCadAluno);
        nomeMae = txtNomeMaeCadAluno.getText();
        checaMaeResp = verificaCheck.checaVerdadeiroFalso(checkMaeResponsavelCadAluno);
        checaOutroResp = verificaCheck.checaVerdadeiroFalso(radioOutroResponsavelCadAluno);
        nomeResponsavel = txtNomeResponsavelCadAluno.getText();
        parentescoResponsavel = txtParentescoResponsavelCadAluno.getText();
        foto3x4 = "TEM QUE VER ESSA FITA AÍ";
        List<Telefone> telefones = telef;
        observacoes = txtAObservacoesCadAluno.getText();


        
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
        aluno.setComprovanteResidencia(comprovanteResidencia);
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
        aluno.setFoto3x4(foto3x4);
        aluno.setTelefones(telefones);
        aluno.setObservacoes(observacoes);

    }
    
    /*
    * Verifica se os campos estão preenchidos, valida os dados inseridos e persiste
    * os dados.
    */
    private void salvar() {
        AlunoDAO adao = new AlunoDAO();
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
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedPaneCadastroAluno = new javax.swing.JTabbedPane();
        scrollPaneCadastroAlunoAluno = new javax.swing.JScrollPane();
        paneCadastroAlunoAluno = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNomeCadastroAluno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRaCadastroAluno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        paneGeneroCadastroAluno = new javax.swing.JPanel();
        radioMasculinoCadastroAluno = new javax.swing.JRadioButton();
        radioFemininoCadastroAluno = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        txtEnderecoCadastroAluno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBairroCadastroAluno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblComprovanteResidenciaCadAluno = new javax.swing.JLabel();
        btnProcurarComprovResidenciaCadAluno = new javax.swing.JButton();
        panelCheckBoxCadastroAluno = new javax.swing.JPanel();
        checkTransporteEscolarCadastroAluno = new javax.swing.JCheckBox();
        checkNecessidadesEspeciaisAcompCadAluno = new javax.swing.JCheckBox();
        checkNecessidadesEspeciaisCadastroAluno = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        ftxtDataNasc = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        comboEscolasCadAluno = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboBoxSerieCadastroAluno = new javax.swing.JComboBox<>();
        scrollPaneCadastroAlunoResponsavel = new javax.swing.JScrollPane();
        paneCadastroAlunoResponsavel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomePaiCadastroAluno = new javax.swing.JTextField();
        checkPaiResponsavelCadAluno = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        checkMaeResponsavelCadAluno = new javax.swing.JCheckBox();
        txtNomeMaeCadAluno = new javax.swing.JTextField();
        radioOutroResponsavelCadAluno = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        scrollPaneObservacoesCadAluno = new javax.swing.JScrollPane();
        txtAObservacoesCadAluno = new javax.swing.JTextArea();
        paneFotoAluno = new javax.swing.JPanel();
        btnFotoAlunoCadAluno = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnProcurarFotoCadAluno = new javax.swing.JButton();
        btnAddTelefCadAluno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefonesCadAluno = new javax.swing.JList<>();
        txtTelefoneCadAluno = new javax.swing.JTextField();
        btnRemoveTelefoneCadAluno = new javax.swing.JButton();
        panelOutroResponsavel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeResponsavelCadAluno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtParentescoResponsavelCadAluno = new javax.swing.JTextField();
        btnSalvarCadAluno = new javax.swing.JButton();
        btnCancelarCadAluno = new javax.swing.JButton();

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
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel9.setLabelFor(txtNomeCadastroAluno);
        jLabel9.setText("Nome:");
        jLabel9.setName(""); // NOI18N

        jLabel10.setLabelFor(txtRaCadastroAluno);
        jLabel10.setText("RA:");

        jLabel11.setText("Data de nascimento:");

        paneGeneroCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        paneGeneroCadastroAluno.setBorder(javax.swing.BorderFactory.createTitledBorder("Gênero"));

        buttonGroup1.add(radioMasculinoCadastroAluno);
        radioMasculinoCadastroAluno.setSelected(true);
        radioMasculinoCadastroAluno.setText("Masculino");

        buttonGroup1.add(radioFemininoCadastroAluno);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioFemininoCadastroAluno)
                .addContainerGap())
        );

        jLabel12.setLabelFor(txtEnderecoCadastroAluno);
        jLabel12.setText("Endereço:");

        jLabel13.setLabelFor(txtBairroCadastroAluno);
        jLabel13.setText("Bairro:");

        jLabel14.setLabelFor(lblComprovanteResidenciaCadAluno);
        jLabel14.setText("Comprovante de residência:");

        lblComprovanteResidenciaCadAluno.setText("Nenhum arquivo selecionado...");
        lblComprovanteResidenciaCadAluno.setToolTipText("Nenhum arquivo selecionado...");

        btnProcurarComprovResidenciaCadAluno.setText("Procurar");

        panelCheckBoxCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        panelCheckBoxCadastroAluno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkTransporteEscolarCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkTransporteEscolarCadastroAluno.setText("Utiliza transporte público escolar.");

        checkNecessidadesEspeciaisAcompCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkNecessidadesEspeciaisAcompCadAluno.setText("Necessita de Acompanhante.");

        checkNecessidadesEspeciaisCadastroAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkNecessidadesEspeciaisCadastroAluno.setText("Portador de necessidades especiais.");

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setText("Recebe Auxílio");

        javax.swing.GroupLayout panelCheckBoxCadastroAlunoLayout = new javax.swing.GroupLayout(panelCheckBoxCadastroAluno);
        panelCheckBoxCadastroAluno.setLayout(panelCheckBoxCadastroAlunoLayout);
        panelCheckBoxCadastroAlunoLayout.setHorizontalGroup(
            panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckBoxCadastroAlunoLayout.createSequentialGroup()
                .addGroup(panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCheckBoxCadastroAlunoLayout.createSequentialGroup()
                        .addComponent(checkTransporteEscolarCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(panelCheckBoxCadastroAlunoLayout.createSequentialGroup()
                        .addComponent(checkNecessidadesEspeciaisCadastroAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkNecessidadesEspeciaisAcompCadAluno)
                    .addComponent(jCheckBox1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCheckBoxCadastroAlunoLayout.setVerticalGroup(
            panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckBoxCadastroAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkNecessidadesEspeciaisAcompCadAluno)
                    .addComponent(checkNecessidadesEspeciaisCadastroAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCheckBoxCadastroAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkTransporteEscolarCadastroAluno)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            ftxtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel18.setText("CEP:");

        jLabel17.setText("Escola:");

        jLabel7.setLabelFor(comboBoxSerieCadastroAluno);
        jLabel7.setText("Turma:");

        javax.swing.GroupLayout paneCadastroAlunoAlunoLayout = new javax.swing.GroupLayout(paneCadastroAlunoAluno);
        paneCadastroAlunoAluno.setLayout(paneCadastroAlunoAlunoLayout);
        paneCadastroAlunoAlunoLayout.setHorizontalGroup(
            paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(55, 573, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelCheckBoxCadastroAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(txtRaCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ftxtDataNasc)))
                                    .addComponent(txtNomeCadastroAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                    .addComponent(txtEnderecoCadastroAluno, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(paneGeneroCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                                .addComponent(lblComprovanteResidenciaCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnProcurarComprovResidenciaCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairroCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(22, 305, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))
                    .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel7)
                            .addComponent(comboBoxSerieCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboEscolasCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        paneCadastroAlunoAlunoLayout.setVerticalGroup(
            paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCadastroAlunoAlunoLayout.createSequentialGroup()
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(paneGeneroCadastroAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneCadastroAlunoAlunoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRaCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEnderecoCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneCadastroAlunoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairroCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComprovanteResidenciaCadAluno)
                    .addComponent(btnProcurarComprovResidenciaCadAluno))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(3, 3, 3)
                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEscolasCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSerieCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(panelCheckBoxCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        scrollPaneCadastroAlunoAluno.setViewportView(paneCadastroAlunoAluno);

        tabbedPaneCadastroAluno.addTab("Aluno", scrollPaneCadastroAlunoAluno);

        scrollPaneCadastroAlunoResponsavel.setBackground(new java.awt.Color(204, 204, 204));
        scrollPaneCadastroAlunoResponsavel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        paneCadastroAlunoResponsavel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setLabelFor(txtNomePaiCadastroAluno);
        jLabel1.setText("Nome do pai:");

        checkPaiResponsavelCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkPaiResponsavelCadAluno.setText("Marcar como responsável");

        jLabel2.setLabelFor(txtNomeMaeCadAluno);
        jLabel2.setText("Nome da mãe:");

        checkMaeResponsavelCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        checkMaeResponsavelCadAluno.setText("Marcar como responsável");

        radioOutroResponsavelCadAluno.setBackground(new java.awt.Color(204, 204, 204));
        radioOutroResponsavelCadAluno.setText("Outro responsável.");

        jLabel5.setText("Telefones:");

        jLabel6.setLabelFor(txtAObservacoesCadAluno);
        jLabel6.setText("Observações:");

        txtAObservacoesCadAluno.setColumns(20);
        txtAObservacoesCadAluno.setLineWrap(true);
        txtAObservacoesCadAluno.setRows(5);
        txtAObservacoesCadAluno.setWrapStyleWord(true);
        scrollPaneObservacoesCadAluno.setViewportView(txtAObservacoesCadAluno);

        paneFotoAluno.setBackground(new java.awt.Color(204, 204, 204));

        btnFotoAlunoCadAluno.setText("foto 3x4");

        jLabel8.setLabelFor(btnFotoAlunoCadAluno);
        jLabel8.setText("Foto 3x4 do aluno.");

        btnProcurarFotoCadAluno.setText("Procurar");

        javax.swing.GroupLayout paneFotoAlunoLayout = new javax.swing.GroupLayout(paneFotoAluno);
        paneFotoAluno.setLayout(paneFotoAlunoLayout);
        paneFotoAlunoLayout.setHorizontalGroup(
            paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFotoAlunoCadAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneFotoAlunoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneFotoAlunoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnProcurarFotoCadAluno))
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        paneFotoAlunoLayout.setVerticalGroup(
            paneFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFotoAlunoLayout.createSequentialGroup()
                .addComponent(btnFotoAlunoCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnProcurarFotoCadAluno))
        );

        btnAddTelefCadAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/add.png"))); // NOI18N
        btnAddTelefCadAluno.setContentAreaFilled(false);

        jListTelefonesCadAluno.setAutoscrolls(false);
        jScrollPane1.setViewportView(jListTelefonesCadAluno);

        txtTelefoneCadAluno.setToolTipText("Digite um telefone para adicioná-lo.");
        txtTelefoneCadAluno.setName(""); // NOI18N

        btnRemoveTelefoneCadAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/delete.png"))); // NOI18N
        btnRemoveTelefoneCadAluno.setContentAreaFilled(false);

        panelOutroResponsavel.setBackground(new java.awt.Color(204, 204, 204));
        panelOutroResponsavel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setLabelFor(txtNomeResponsavelCadAluno);
        jLabel3.setText("Nome do responsável:");

        txtNomeResponsavelCadAluno.setEnabled(false);

        jLabel4.setLabelFor(txtParentescoResponsavelCadAluno);
        jLabel4.setText("Parentesco:");

        txtParentescoResponsavelCadAluno.setEnabled(false);

        javax.swing.GroupLayout panelOutroResponsavelLayout = new javax.swing.GroupLayout(panelOutroResponsavel);
        panelOutroResponsavel.setLayout(panelOutroResponsavelLayout);
        panelOutroResponsavelLayout.setHorizontalGroup(
            panelOutroResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutroResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOutroResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtParentescoResponsavelCadAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(txtNomeResponsavelCadAluno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOutroResponsavelLayout.setVerticalGroup(
            panelOutroResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutroResponsavelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeResponsavelCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtParentescoResponsavelCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(txtNomePaiCadastroAluno)
                            .addComponent(txtNomeMaeCadAluno)
                            .addComponent(panelOutroResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addComponent(radioOutroResponsavelCadAluno)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(paneFotoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(79, 79, 79)
                        .addComponent(checkMaeResponsavelCadAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                        .addGap(187, 187, 187))
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)
                                .addComponent(checkPaiResponsavelCadAluno))
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTelefoneCadAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAddTelefCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRemoveTelefoneCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(37, 37, 37)
                                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPaneObservacoesCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addComponent(txtNomePaiCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(checkMaeResponsavelCadAluno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeMaeCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                        .addComponent(txtTelefoneCadAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneCadastroAlunoResponsavelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneCadastroAlunoResponsavelLayout.createSequentialGroup()
                                .addComponent(btnAddTelefCadAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoveTelefoneCadAluno))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(scrollPaneObservacoesCadAluno))
                .addContainerGap())
        );

        scrollPaneCadastroAlunoResponsavel.setViewportView(paneCadastroAlunoResponsavel);

        tabbedPaneCadastroAluno.addTab("Responsável", scrollPaneCadastroAlunoResponsavel);

        btnSalvarCadAluno.setText("Salvar");

        btnCancelarCadAluno.setText("Cancelar");
        btnCancelarCadAluno.setToolTipText("");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnCancelarCadAluno)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarCadAluno)
                    .addComponent(btnCancelarCadAluno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JButton btnCancelarCadAluno;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFotoAlunoCadAluno;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnProcurarComprovResidenciaCadAluno;
    private javax.swing.JButton btnProcurarFotoCadAluno;
    private javax.swing.JButton btnRemoveTelefoneCadAluno;
    private javax.swing.JButton btnSalvarCadAluno;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkMaeResponsavelCadAluno;
    private javax.swing.JCheckBox checkNecessidadesEspeciaisAcompCadAluno;
    private javax.swing.JCheckBox checkNecessidadesEspeciaisCadastroAluno;
    private javax.swing.JCheckBox checkPaiResponsavelCadAluno;
    private javax.swing.JCheckBox checkTransporteEscolarCadastroAluno;
    private javax.swing.JComboBox<Turma> comboBoxSerieCadastroAluno;
    private javax.swing.JComboBox<Escola> comboEscolasCadAluno;
    private javax.swing.JFormattedTextField ftxtDataNasc;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JList<Telefone> jListTelefonesCadAluno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblComprovanteResidenciaCadAluno;
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
    private javax.swing.JTextArea txtAObservacoesCadAluno;
    private javax.swing.JTextField txtBairroCadastroAluno;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtEnderecoCadastroAluno;
    private javax.swing.JTextField txtNomeCadastroAluno;
    private javax.swing.JTextField txtNomeMaeCadAluno;
    private javax.swing.JTextField txtNomePaiCadastroAluno;
    private javax.swing.JTextField txtNomeResponsavelCadAluno;
    private javax.swing.JTextField txtParentescoResponsavelCadAluno;
    private javax.swing.JTextField txtRaCadastroAluno;
    private javax.swing.JTextField txtTelefoneCadAluno;
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
            nomePai, nomeMae, nomeResponsavel, parentescoResponsavel, foto3x4, 
            observacoes;
    private Date dataNasc;
    private Escola escola;
    private Turma turma;
    private boolean necesEspec, necesAcomp, transpEsc, checaPaiResp, checaMaeResp,
            checaOutroResp;
    private List<NotasFaltas> notasFaltas = new ArrayList<>();
    private boolean edicao = false;
    private Aluno aluno = new Aluno();
    //Fim da declaração das variáveis declaradas por mim.
    
    private class OuvintesAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == comboEscolasCadAluno){
                comboBoxSerieCadastroAluno.removeAllItems();
                Escola esc = preencheCombo.pegaEscola(comboEscolasCadAluno);
                preencheCombo.preencheTurmas(comboBoxSerieCadastroAluno, esc);
            } else if (evt.getSource() == btnFechar){
                dispose();
            } else if (evt.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (evt.getSource() == radioOutroResponsavelCadAluno){
                checaRadioResponsavelEnabled();
            } else if (evt.getSource() == btnSalvarCadAluno){
                salvar();
            } else if (evt.getSource() == btnRemoveTelefoneCadAluno){
                camposTelef.excluiTelefoneDaLista(jListTelefonesCadAluno, telef);
                camposTelef.exibeTelefonesNoJList(jListTelefonesCadAluno, telef);
            } else if (evt.getSource() == btnAddTelefCadAluno){
                camposTelef.colocaTelefoneNaLista(telef, txtTelefoneCadAluno);
                camposTelef.exibeTelefonesNoJList(jListTelefonesCadAluno, telef); 
            }
        }
    }
}
