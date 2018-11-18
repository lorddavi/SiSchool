/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.EstatisticasDAO;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFEstatisticas extends javax.swing.JFrame {

    /**
     * Creates new form JFTransferirAlunos
     */
    
    public JFEstatisticas(){
        
    }
    
    public JFEstatisticas(Login login) {
        initComponents();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        setaStats();
        setaListeners();
        
        atualizaTabelaEscolas(edao.buscaTodas());
    }
    
    private void setaListeners(){
        OuvintesAction oa = new OuvintesAction();
        
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
    }
    
    private void atualizaTabelaEscolas(List<Escola> escolas){
        tme = new TableModelEscola(escolas);
        tabelaEscolas.setModel(tme);
    }
    
    private void setaStats(){
        try{
            int numAlunosRede = statsDao.numAlunos();
            int numEscolasRede = statsDao.numEscolas();
            double mediaAlunosPorEscola = ((double) numAlunosRede / (double) numEscolasRede);
            Escola escolaMaisAlunos = escolaMaisALunos();
            Escola escolaMenosAlunos = escolaMenosALunos();
            int pebiRede = statsDao.numProfPebI();
            int pebiiRede = statsDao.numProfPebII();
            int funcsRede = statsDao.numOutroCargo();

            lblNumAlunosRede.setText(String.valueOf(numAlunosRede));
            lblQntdEscolasRede.setText(String.valueOf(numEscolasRede));
            lblMediaAlunosPorEscola.setText(String.valueOf(mediaAlunosPorEscola));
            lblEscolaMaisAlunos.setText(escolaMaisAlunos.getNome() + " com " + escolaMaisAlunos.getAlunos().size() + " alunos");
            lblEscolaMenosAlunos.setText(escolaMenosAlunos.getNome() + " com " + escolaMenosAlunos.getAlunos().size() + " alunos");
            lblProfPebIRede.setText(String.valueOf(pebiRede));
            lblProfPebIIRede.setText(String.valueOf(pebiiRede));
            lblFuncAdminRede.setText(String.valueOf(funcsRede));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private Escola escolaMaisALunos(){
        int num = 0;
        Escola esc = new Escola();
        for(Escola e: edao.buscaTodas()){
            if (e.getAlunos().size()>num){
                num = e.getAlunos().size();
                esc = e;
            }
        }
        return esc;
    }
    
    private Escola escolaMenosALunos(){
        int num = 1000000;
        Escola esc = new Escola();
        for(Escola e: edao.buscaTodas()){
            if (e.getAlunos().size()<num){
                num = e.getAlunos().size();
                esc = e;
            }
        }
        return esc;
    }

    /**
     * Método que inicia todos os componentes ao ser chamado no construtor.
     * Feito automaticamente pelo swing e, portanto, imutável.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSelecionaMateria = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        tabbedPaneEstatisticas = new javax.swing.JTabbedPane();
        paneAlunoEstatisticas = new javax.swing.JPanel();
        txtBuscaAluno = new javax.swing.JTextField();
        paneNotasEFaltas = new javax.swing.JPanel();
        paneLabels = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        paneMatematica = new javax.swing.JPanel();
        medAnosAnteMatem = new javax.swing.JLabel();
        medAnoAtualMatem = new javax.swing.JLabel();
        progressoMatem = new javax.swing.JLabel();
        medTurmaMatem = new javax.swing.JLabel();
        faltasMatem = new javax.swing.JLabel();
        presencaMatem = new javax.swing.JLabel();
        panePortugues = new javax.swing.JPanel();
        medAnosAntPortug = new javax.swing.JLabel();
        medAnoAtualPortug = new javax.swing.JLabel();
        progressoPortug = new javax.swing.JLabel();
        medTurmaPortug = new javax.swing.JLabel();
        faltasPortug = new javax.swing.JLabel();
        presencaPortug = new javax.swing.JLabel();
        panelCiencias = new javax.swing.JPanel();
        medAnosAntCiencias = new javax.swing.JLabel();
        medAnoAtualCiencias = new javax.swing.JLabel();
        progressoCiencias = new javax.swing.JLabel();
        medTurmaCiencias = new javax.swing.JLabel();
        faltasCiencias = new javax.swing.JLabel();
        presencaCiencias = new javax.swing.JLabel();
        panelHistoria = new javax.swing.JPanel();
        medAnosAntArtes = new javax.swing.JLabel();
        medAnoAtualArtes = new javax.swing.JLabel();
        progressoArtes = new javax.swing.JLabel();
        medTurmaArtes = new javax.swing.JLabel();
        faltasArtes = new javax.swing.JLabel();
        presencaArtes = new javax.swing.JLabel();
        panelGeografia = new javax.swing.JPanel();
        medAnosAntIngles = new javax.swing.JLabel();
        medAnoAtualIngles = new javax.swing.JLabel();
        progressoIngles = new javax.swing.JLabel();
        medTurmaIngles = new javax.swing.JLabel();
        faltasIngles = new javax.swing.JLabel();
        presencaIngles = new javax.swing.JLabel();
        panelArtes = new javax.swing.JPanel();
        medAnosAntFisica = new javax.swing.JLabel();
        medAnoAtualFisica = new javax.swing.JLabel();
        progressoFisica = new javax.swing.JLabel();
        medTurmaFisica = new javax.swing.JLabel();
        faltasFisica = new javax.swing.JLabel();
        presencaFisica = new javax.swing.JLabel();
        panelIngles = new javax.swing.JPanel();
        medAnosAntFisica3 = new javax.swing.JLabel();
        medAnoAtualFisica3 = new javax.swing.JLabel();
        progressoFisica3 = new javax.swing.JLabel();
        medTurmaFisica3 = new javax.swing.JLabel();
        faltasFisica3 = new javax.swing.JLabel();
        presencaFisica3 = new javax.swing.JLabel();
        panelFisica = new javax.swing.JPanel();
        medAnosAntFisica4 = new javax.swing.JLabel();
        medAnoAtualFisica4 = new javax.swing.JLabel();
        progressoFisica4 = new javax.swing.JLabel();
        medTurmaFisica4 = new javax.swing.JLabel();
        faltasFisica4 = new javax.swing.JLabel();
        presencaFisica4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        paneEscolaEstatisticas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelMediaNotasFaltasTurma = new javax.swing.JPanel();
        jScrollPaneListaTurmas = new javax.swing.JScrollPane();
        jListTurmasDaEscola = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        medTurmMatemEscola = new javax.swing.JLabel();
        medTurmPortugEscola = new javax.swing.JLabel();
        medTurmCienciasEscola = new javax.swing.JLabel();
        medTurmArtesEscola = new javax.swing.JLabel();
        medTurmInglesEscola = new javax.swing.JLabel();
        medTurmFisicaEscola = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        numAlunosSala = new javax.swing.JLabel();
        JLabel1 = new javax.swing.JLabel();
        numAlunosEscola = new javax.swing.JLabel();
        JLabel2 = new javax.swing.JLabel();
        medALunosSala = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        medPresencaSala = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        medPresencaEscola = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numAlunosPortNeceEsp = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        numAlunosPortNesseEspAcomp = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        numAlunosTranspEscolar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscaEscolaEstatisticas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEscolas = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        paneRedeEstatisticas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblNumAlunosRede = new javax.swing.JLabel();
        lblQntdEscolasRede = new javax.swing.JLabel();
        lblMediaAlunosPorEscola = new javax.swing.JLabel();
        lblEscolaMaisAlunos = new javax.swing.JLabel();
        lblEscolaMenosAlunos = new javax.swing.JLabel();
        lblProfPebIRede = new javax.swing.JLabel();
        lblProfPebIIRede = new javax.swing.JLabel();
        lblFuncAdminRede = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

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
        lblTituloPrincipal.setText("SiSchool - Estatísticas");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelBarraDeTituloLayout.setVerticalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(407, 407, 407))
        );

        tabbedPaneEstatisticas.setBackground(new java.awt.Color(204, 204, 204));
        tabbedPaneEstatisticas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        paneAlunoEstatisticas.setBackground(new java.awt.Color(204, 204, 204));

        txtBuscaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        paneNotasEFaltas.setBackground(new java.awt.Color(204, 204, 204));

        paneLabels.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Média anos anteriores:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Média este ano:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Progresso:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Média da turma:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Faltas:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Presença (%):");

        javax.swing.GroupLayout paneLabelsLayout = new javax.swing.GroupLayout(paneLabels);
        paneLabels.setLayout(paneLabelsLayout);
        paneLabelsLayout.setHorizontalGroup(
            paneLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLabelsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneLabelsLayout.setVerticalGroup(
            paneLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLabelsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneMatematica.setBackground(new java.awt.Color(204, 204, 204));
        paneMatematica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matemática", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        medAnosAnteMatem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAnteMatem.setText("jLabel1");

        medAnoAtualMatem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualMatem.setText("jLabel2");

        progressoMatem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoMatem.setText("jLabel3");

        medTurmaMatem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaMatem.setText("jLabel4");

        faltasMatem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasMatem.setText("jLabel5");

        presencaMatem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaMatem.setText("jLabel2");

        javax.swing.GroupLayout paneMatematicaLayout = new javax.swing.GroupLayout(paneMatematica);
        paneMatematica.setLayout(paneMatematicaLayout);
        paneMatematicaLayout.setHorizontalGroup(
            paneMatematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMatematicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMatematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medTurmaMatem)
                    .addComponent(faltasMatem)
                    .addComponent(medAnosAnteMatem)
                    .addComponent(presencaMatem)
                    .addComponent(medAnoAtualMatem)
                    .addComponent(progressoMatem))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        paneMatematicaLayout.setVerticalGroup(
            paneMatematicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMatematicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAnteMatem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualMatem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoMatem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaMatem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasMatem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaMatem)
                .addContainerGap())
        );

        panePortugues.setBackground(new java.awt.Color(204, 204, 204));
        panePortugues.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Português", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntPortug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntPortug.setText("jLabel6");

        medAnoAtualPortug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualPortug.setText("jLabel7");

        progressoPortug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoPortug.setText("jLabel8");

        medTurmaPortug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaPortug.setText("jLabel9");

        faltasPortug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasPortug.setText("jLabel10");

        presencaPortug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaPortug.setText("jLabel2");

        javax.swing.GroupLayout panePortuguesLayout = new javax.swing.GroupLayout(panePortugues);
        panePortugues.setLayout(panePortuguesLayout);
        panePortuguesLayout.setHorizontalGroup(
            panePortuguesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePortuguesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panePortuguesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntPortug)
                    .addComponent(medAnoAtualPortug)
                    .addComponent(progressoPortug)
                    .addComponent(medTurmaPortug)
                    .addComponent(faltasPortug)
                    .addComponent(presencaPortug))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panePortuguesLayout.setVerticalGroup(
            panePortuguesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePortuguesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntPortug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualPortug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoPortug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaPortug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasPortug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaPortug)
                .addContainerGap())
        );

        panelCiencias.setBackground(new java.awt.Color(204, 204, 204));
        panelCiencias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciências", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntCiencias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntCiencias.setText("jLabel16");

        medAnoAtualCiencias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualCiencias.setText("jLabel17");

        progressoCiencias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoCiencias.setText("jLabel18");

        medTurmaCiencias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaCiencias.setText("jLabel19");

        faltasCiencias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasCiencias.setText("jLabel20");

        presencaCiencias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaCiencias.setText("jLabel3");

        javax.swing.GroupLayout panelCienciasLayout = new javax.swing.GroupLayout(panelCiencias);
        panelCiencias.setLayout(panelCienciasLayout);
        panelCienciasLayout.setHorizontalGroup(
            panelCienciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCienciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCienciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntCiencias)
                    .addComponent(medAnoAtualCiencias)
                    .addComponent(progressoCiencias)
                    .addComponent(medTurmaCiencias)
                    .addComponent(faltasCiencias)
                    .addComponent(presencaCiencias))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCienciasLayout.setVerticalGroup(
            panelCienciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCienciasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntCiencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualCiencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoCiencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaCiencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasCiencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaCiencias)
                .addContainerGap())
        );

        panelHistoria.setBackground(new java.awt.Color(204, 204, 204));
        panelHistoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "História", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntArtes.setText("jLabel21");

        medAnoAtualArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualArtes.setText("jLabel22");

        progressoArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoArtes.setText("jLabel23");

        medTurmaArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaArtes.setText("jLabel24");

        faltasArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasArtes.setText("jLabel25");

        presencaArtes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaArtes.setText("jLabel4");

        javax.swing.GroupLayout panelHistoriaLayout = new javax.swing.GroupLayout(panelHistoria);
        panelHistoria.setLayout(panelHistoriaLayout);
        panelHistoriaLayout.setHorizontalGroup(
            panelHistoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHistoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntArtes)
                    .addComponent(medAnoAtualArtes)
                    .addComponent(progressoArtes)
                    .addComponent(medTurmaArtes)
                    .addComponent(faltasArtes)
                    .addComponent(presencaArtes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHistoriaLayout.setVerticalGroup(
            panelHistoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoriaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntArtes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualArtes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoArtes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaArtes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasArtes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaArtes)
                .addContainerGap())
        );

        panelGeografia.setBackground(new java.awt.Color(204, 204, 204));
        panelGeografia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Geografia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntIngles.setText("jLabel26");

        medAnoAtualIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualIngles.setText("jLabel27");

        progressoIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoIngles.setText("jLabel28");

        medTurmaIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaIngles.setText("jLabel29");

        faltasIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasIngles.setText("jLabel30");

        presencaIngles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaIngles.setText("jLabel5");

        javax.swing.GroupLayout panelGeografiaLayout = new javax.swing.GroupLayout(panelGeografia);
        panelGeografia.setLayout(panelGeografiaLayout);
        panelGeografiaLayout.setHorizontalGroup(
            panelGeografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeografiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntIngles)
                    .addComponent(medAnoAtualIngles)
                    .addComponent(progressoIngles)
                    .addComponent(medTurmaIngles)
                    .addComponent(faltasIngles)
                    .addComponent(presencaIngles))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeografiaLayout.setVerticalGroup(
            panelGeografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeografiaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaIngles)
                .addContainerGap())
        );

        panelArtes.setBackground(new java.awt.Color(204, 204, 204));
        panelArtes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Artes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntFisica.setText("jLabel31");

        medAnoAtualFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualFisica.setText("jLabel32");

        progressoFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoFisica.setText("jLabel33");

        medTurmaFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaFisica.setText("jLabel34");

        faltasFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasFisica.setText("jLabel35");

        presencaFisica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaFisica.setText("jLabel36");

        javax.swing.GroupLayout panelArtesLayout = new javax.swing.GroupLayout(panelArtes);
        panelArtes.setLayout(panelArtesLayout);
        panelArtesLayout.setHorizontalGroup(
            panelArtesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArtesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntFisica)
                    .addComponent(medAnoAtualFisica)
                    .addComponent(progressoFisica)
                    .addComponent(medTurmaFisica)
                    .addComponent(faltasFisica)
                    .addComponent(presencaFisica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelArtesLayout.setVerticalGroup(
            panelArtesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaFisica)
                .addContainerGap())
        );

        panelIngles.setBackground(new java.awt.Color(204, 204, 204));
        panelIngles.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inglês", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntFisica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntFisica3.setText("jLabel31");

        medAnoAtualFisica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualFisica3.setText("jLabel32");

        progressoFisica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoFisica3.setText("jLabel33");

        medTurmaFisica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaFisica3.setText("jLabel34");

        faltasFisica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasFisica3.setText("jLabel35");

        presencaFisica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaFisica3.setText("jLabel36");

        javax.swing.GroupLayout panelInglesLayout = new javax.swing.GroupLayout(panelIngles);
        panelIngles.setLayout(panelInglesLayout);
        panelInglesLayout.setHorizontalGroup(
            panelInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInglesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntFisica3)
                    .addComponent(medAnoAtualFisica3)
                    .addComponent(progressoFisica3)
                    .addComponent(medTurmaFisica3)
                    .addComponent(faltasFisica3)
                    .addComponent(presencaFisica3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInglesLayout.setVerticalGroup(
            panelInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInglesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntFisica3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualFisica3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoFisica3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaFisica3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasFisica3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaFisica3)
                .addContainerGap())
        );

        panelFisica.setBackground(new java.awt.Color(204, 204, 204));
        panelFisica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ed. Física", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        medAnosAntFisica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnosAntFisica4.setText("jLabel31");

        medAnoAtualFisica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medAnoAtualFisica4.setText("jLabel32");

        progressoFisica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progressoFisica4.setText("jLabel33");

        medTurmaFisica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmaFisica4.setText("jLabel34");

        faltasFisica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faltasFisica4.setText("jLabel35");

        presencaFisica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencaFisica4.setText("jLabel36");

        javax.swing.GroupLayout panelFisicaLayout = new javax.swing.GroupLayout(panelFisica);
        panelFisica.setLayout(panelFisicaLayout);
        panelFisicaLayout.setHorizontalGroup(
            panelFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFisicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntFisica4)
                    .addComponent(medAnoAtualFisica4)
                    .addComponent(progressoFisica4)
                    .addComponent(medTurmaFisica4)
                    .addComponent(faltasFisica4)
                    .addComponent(presencaFisica4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFisicaLayout.setVerticalGroup(
            panelFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFisicaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medAnosAntFisica4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medAnoAtualFisica4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressoFisica4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medTurmaFisica4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(faltasFisica4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presencaFisica4)
                .addContainerGap())
        );

        javax.swing.GroupLayout paneNotasEFaltasLayout = new javax.swing.GroupLayout(paneNotasEFaltas);
        paneNotasEFaltas.setLayout(paneNotasEFaltasLayout);
        paneNotasEFaltasLayout.setHorizontalGroup(
            paneNotasEFaltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNotasEFaltasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneMatematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panePortugues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCiencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGeografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelArtes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneNotasEFaltasLayout.setVerticalGroup(
            paneNotasEFaltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMatematica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panePortugues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCiencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHistoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGeografia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelArtes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelIngles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Buscar aluno:");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        tabelaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaAluno);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("jLabel29");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("jLabel30");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("jLabel31");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("jLabel32");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout paneAlunoEstatisticasLayout = new javax.swing.GroupLayout(paneAlunoEstatisticas);
        paneAlunoEstatisticas.setLayout(paneAlunoEstatisticasLayout);
        paneAlunoEstatisticasLayout.setHorizontalGroup(
            paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                .addGroup(paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txtBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paneNotasEFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 921, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneAlunoEstatisticasLayout.setVerticalGroup(
            paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneNotasEFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneEstatisticas.addTab("Aluno", paneAlunoEstatisticas);

        paneEscolaEstatisticas.setBackground(new java.awt.Color(204, 204, 204));
        paneEscolaEstatisticas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        panelMediaNotasFaltasTurma.setBackground(new java.awt.Color(204, 204, 204));
        panelMediaNotasFaltasTurma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Média de notas/faltas por turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jListTurmasDaEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPaneListaTurmas.setViewportView(jListTurmasDaEscola);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Matemática:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Português:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ciências:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Artes:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Inglês:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ed. Física:");

        medTurmMatemEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmMatemEscola.setText("jLabel9");

        medTurmPortugEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmPortugEscola.setText("jLabel10");

        medTurmCienciasEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmCienciasEscola.setText("jLabel21");

        medTurmArtesEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmArtesEscola.setText("jLabel22");

        medTurmInglesEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmInglesEscola.setText("jLabel23");

        medTurmFisicaEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medTurmFisicaEscola.setText("jLabel24");

        javax.swing.GroupLayout panelMediaNotasFaltasTurmaLayout = new javax.swing.GroupLayout(panelMediaNotasFaltasTurma);
        panelMediaNotasFaltasTurma.setLayout(panelMediaNotasFaltasTurmaLayout);
        panelMediaNotasFaltasTurmaLayout.setHorizontalGroup(
            panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMediaNotasFaltasTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneListaTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(42, 42, 42)
                .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medTurmFisicaEscola)
                    .addComponent(medTurmInglesEscola)
                    .addComponent(medTurmArtesEscola)
                    .addComponent(medTurmCienciasEscola)
                    .addComponent(medTurmPortugEscola)
                    .addComponent(medTurmMatemEscola))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelMediaNotasFaltasTurmaLayout.setVerticalGroup(
            panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMediaNotasFaltasTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMediaNotasFaltasTurmaLayout.createSequentialGroup()
                        .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(medTurmMatemEscola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(medTurmPortugEscola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(medTurmCienciasEscola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(medTurmArtesEscola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(medTurmInglesEscola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(medTurmFisicaEscola))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneListaTurmas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Quantidade de alunos:");

        numAlunosSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numAlunosSala.setText("jLabel27");

        JLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JLabel1.setText("Quantidade de alunos na escola:");

        numAlunosEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numAlunosEscola.setText("jLabel28");

        JLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JLabel2.setText("Média de alunos por sala:");

        medALunosSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medALunosSala.setText("jLabel29");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Média de presença da sala:");

        medPresencaSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medPresencaSala.setText("jLabel30");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Média de presença da escola:");

        medPresencaEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medPresencaEscola.setText("jLabel31");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Alunos portadores de necessidades especiais:");

        numAlunosPortNeceEsp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numAlunosPortNeceEsp.setText("jLabel32");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Alunos que precisam de acompanhante:");

        numAlunosPortNesseEspAcomp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numAlunosPortNesseEspAcomp.setText("jLabel33");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Alunos que utilizam transporte público escolar:");

        numAlunosTranspEscolar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numAlunosTranspEscolar.setText("jLabel34");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMediaNotasFaltasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAlunosPortNesseEspAcomp))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAlunosPortNeceEsp))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAlunosTranspEscolar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAlunosSala))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numAlunosEscola))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(medPresencaEscola))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(medALunosSala, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(medPresencaSala, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMediaNotasFaltasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(numAlunosSala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel1)
                    .addComponent(numAlunosEscola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel2)
                    .addComponent(medALunosSala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(medPresencaSala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(medPresencaEscola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(numAlunosPortNeceEsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(numAlunosPortNesseEspAcomp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(numAlunosTranspEscolar))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        txtBuscaEscolaEstatisticas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabelaEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaEscolas.setModel(tme);
        jScrollPane1.setViewportView(tabelaEscolas);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Busque uma escola:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscaEscolaEstatisticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscaEscolaEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneEscolaEstatisticasLayout = new javax.swing.GroupLayout(paneEscolaEstatisticas);
        paneEscolaEstatisticas.setLayout(paneEscolaEstatisticasLayout);
        paneEscolaEstatisticasLayout.setHorizontalGroup(
            paneEscolaEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneEscolaEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        paneEscolaEstatisticasLayout.setVerticalGroup(
            paneEscolaEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneEscolaEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneEscolaEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneEscolaEstatisticasLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneEscolaEstatisticasLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabbedPaneEstatisticas.addTab("Escola", paneEscolaEstatisticas);

        paneRedeEstatisticas.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Funcionários administrativos na rede:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Professores PEB II na rede:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Professores PEB I na rede:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Escola com o menor número de alunos:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Escola com o maior número de alunos:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Média de Alunos por escola:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Quantidade de escolas:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Número de alunos na rede:");

        lblNumAlunosRede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNumAlunosRede.setText("0");

        lblQntdEscolasRede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQntdEscolasRede.setText("0");

        lblMediaAlunosPorEscola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMediaAlunosPorEscola.setText("0");

        lblEscolaMaisAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEscolaMaisAlunos.setText("0");

        lblEscolaMenosAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEscolaMenosAlunos.setText("0");

        lblProfPebIRede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProfPebIRede.setText("0");

        lblProfPebIIRede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProfPebIIRede.setText("0");

        lblFuncAdminRede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFuncAdminRede.setText("0");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Escola com a maior média em tal matéria:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("ADIs na rede:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel2)
                            .addComponent(jLabel20)
                            .addComponent(jLabel16)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumAlunosRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQntdEscolasRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMediaAlunosPorEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEscolaMaisAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFuncAdminRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProfPebIIRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProfPebIRede, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEscolaMenosAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblNumAlunosRede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblQntdEscolasRede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblMediaAlunosPorEscola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblEscolaMaisAlunos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblEscolaMenosAlunos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblProfPebIRede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblProfPebIIRede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncAdminRede)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 484, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneRedeEstatisticasLayout = new javax.swing.GroupLayout(paneRedeEstatisticas);
        paneRedeEstatisticas.setLayout(paneRedeEstatisticasLayout);
        paneRedeEstatisticasLayout.setHorizontalGroup(
            paneRedeEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRedeEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneRedeEstatisticasLayout.setVerticalGroup(
            paneRedeEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRedeEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        tabbedPaneEstatisticas.addTab("Rede Municipal", paneRedeEstatisticas);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(tabbedPaneEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEstatisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JButton btnFechar;
    private javax.swing.ButtonGroup btnGroupSelecionaMateria;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JLabel faltasArtes;
    private javax.swing.JLabel faltasCiencias;
    private javax.swing.JLabel faltasFisica;
    private javax.swing.JLabel faltasFisica1;
    private javax.swing.JLabel faltasFisica2;
    private javax.swing.JLabel faltasFisica3;
    private javax.swing.JLabel faltasFisica4;
    private javax.swing.JLabel faltasIngles;
    private javax.swing.JLabel faltasMatem;
    private javax.swing.JLabel faltasPortug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Turma> jListTurmasDaEscola;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneListaTurmas;
    private javax.swing.JLabel lblEscolaMaisAlunos;
    private javax.swing.JLabel lblEscolaMenosAlunos;
    private javax.swing.JLabel lblFuncAdminRede;
    private javax.swing.JLabel lblMediaAlunosPorEscola;
    private javax.swing.JLabel lblNumAlunosRede;
    private javax.swing.JLabel lblProfPebIIRede;
    private javax.swing.JLabel lblProfPebIRede;
    private javax.swing.JLabel lblQntdEscolasRede;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel medALunosSala;
    private javax.swing.JLabel medAnoAtualArtes;
    private javax.swing.JLabel medAnoAtualCiencias;
    private javax.swing.JLabel medAnoAtualFisica;
    private javax.swing.JLabel medAnoAtualFisica1;
    private javax.swing.JLabel medAnoAtualFisica2;
    private javax.swing.JLabel medAnoAtualFisica3;
    private javax.swing.JLabel medAnoAtualFisica4;
    private javax.swing.JLabel medAnoAtualIngles;
    private javax.swing.JLabel medAnoAtualMatem;
    private javax.swing.JLabel medAnoAtualPortug;
    private javax.swing.JLabel medAnosAntArtes;
    private javax.swing.JLabel medAnosAntCiencias;
    private javax.swing.JLabel medAnosAntFisica;
    private javax.swing.JLabel medAnosAntFisica1;
    private javax.swing.JLabel medAnosAntFisica2;
    private javax.swing.JLabel medAnosAntFisica3;
    private javax.swing.JLabel medAnosAntFisica4;
    private javax.swing.JLabel medAnosAntIngles;
    private javax.swing.JLabel medAnosAntPortug;
    private javax.swing.JLabel medAnosAnteMatem;
    private javax.swing.JLabel medPresencaEscola;
    private javax.swing.JLabel medPresencaSala;
    private javax.swing.JLabel medTurmArtesEscola;
    private javax.swing.JLabel medTurmCienciasEscola;
    private javax.swing.JLabel medTurmFisicaEscola;
    private javax.swing.JLabel medTurmInglesEscola;
    private javax.swing.JLabel medTurmMatemEscola;
    private javax.swing.JLabel medTurmPortugEscola;
    private javax.swing.JLabel medTurmaArtes;
    private javax.swing.JLabel medTurmaCiencias;
    private javax.swing.JLabel medTurmaFisica;
    private javax.swing.JLabel medTurmaFisica1;
    private javax.swing.JLabel medTurmaFisica2;
    private javax.swing.JLabel medTurmaFisica3;
    private javax.swing.JLabel medTurmaFisica4;
    private javax.swing.JLabel medTurmaIngles;
    private javax.swing.JLabel medTurmaMatem;
    private javax.swing.JLabel medTurmaPortug;
    private javax.swing.JLabel numAlunosEscola;
    private javax.swing.JLabel numAlunosPortNeceEsp;
    private javax.swing.JLabel numAlunosPortNesseEspAcomp;
    private javax.swing.JLabel numAlunosSala;
    private javax.swing.JLabel numAlunosTranspEscolar;
    private javax.swing.JPanel paneAlunoEstatisticas;
    private javax.swing.JPanel paneEscolaEstatisticas;
    private javax.swing.JPanel paneLabels;
    private javax.swing.JPanel paneMatematica;
    private javax.swing.JPanel paneNotasEFaltas;
    private javax.swing.JPanel panePortugues;
    private javax.swing.JPanel paneRedeEstatisticas;
    private javax.swing.JPanel panelArtes;
    private javax.swing.JPanel panelArtes1;
    private javax.swing.JPanel panelArtes2;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelCiencias;
    private javax.swing.JPanel panelFisica;
    private javax.swing.JPanel panelGeografia;
    private javax.swing.JPanel panelHistoria;
    private javax.swing.JPanel panelIngles;
    private javax.swing.JPanel panelMediaNotasFaltasTurma;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel presencaArtes;
    private javax.swing.JLabel presencaCiencias;
    private javax.swing.JLabel presencaFisica;
    private javax.swing.JLabel presencaFisica1;
    private javax.swing.JLabel presencaFisica2;
    private javax.swing.JLabel presencaFisica3;
    private javax.swing.JLabel presencaFisica4;
    private javax.swing.JLabel presencaIngles;
    private javax.swing.JLabel presencaMatem;
    private javax.swing.JLabel presencaPortug;
    private javax.swing.JLabel progressoArtes;
    private javax.swing.JLabel progressoCiencias;
    private javax.swing.JLabel progressoFisica;
    private javax.swing.JLabel progressoFisica1;
    private javax.swing.JLabel progressoFisica2;
    private javax.swing.JLabel progressoFisica3;
    private javax.swing.JLabel progressoFisica4;
    private javax.swing.JLabel progressoIngles;
    private javax.swing.JLabel progressoMatem;
    private javax.swing.JLabel progressoPortug;
    private javax.swing.JTabbedPane tabbedPaneEstatisticas;
    private javax.swing.JTable tabelaAluno;
    private javax.swing.JTable tabelaEscolas;
    private javax.swing.JTextField txtBuscaAluno;
    private javax.swing.JTextField txtBuscaEscolaEstatisticas;
    // End of variables declaration//GEN-END:variables
    private EscolaDAO edao = new EscolaDAO();
    private EstatisticasDAO statsDao = new EstatisticasDAO();
    private TableModelEscola tme = new TableModelEscola();
    
    private class OuvintesAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnFechar){
                JFEstatisticas.this.dispose();
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