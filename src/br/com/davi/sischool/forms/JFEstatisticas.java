/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.EstatisticasDAO;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
    
    private void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
    }
    
    private void setaStats(){
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
    }
    
    private Escola escolaMaisALunos(){
        int num = 0;
        Escola esc = new Escola();
        for(Escola e: eDao.buscaTodas()){
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
        for(Escola e: eDao.buscaTodas()){
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
        txtBuscaAlunoEstatisticas = new javax.swing.JTextField();
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
        panelArtes = new javax.swing.JPanel();
        medAnosAntArtes = new javax.swing.JLabel();
        medAnoAtualArtes = new javax.swing.JLabel();
        progressoArtes = new javax.swing.JLabel();
        medTurmaArtes = new javax.swing.JLabel();
        faltasArtes = new javax.swing.JLabel();
        presencaArtes = new javax.swing.JLabel();
        panelIngles = new javax.swing.JPanel();
        medAnosAntIngles = new javax.swing.JLabel();
        medAnoAtualIngles = new javax.swing.JLabel();
        progressoIngles = new javax.swing.JLabel();
        medTurmaIngles = new javax.swing.JLabel();
        faltasIngles = new javax.swing.JLabel();
        presencaIngles = new javax.swing.JLabel();
        panelFisica = new javax.swing.JPanel();
        medAnosAntFisica = new javax.swing.JLabel();
        medAnoAtualFisica = new javax.swing.JLabel();
        progressoFisica = new javax.swing.JLabel();
        medTurmaFisica = new javax.swing.JLabel();
        faltasFisica = new javax.swing.JLabel();
        presencaFisica = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
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
        jTable1 = new javax.swing.JTable();
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

        paneAlunoEstatisticas.setBackground(new java.awt.Color(204, 204, 204));

        paneNotasEFaltas.setBackground(new java.awt.Color(204, 204, 204));

        paneLabels.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setText("Média anos anteriores:");

        jLabel12.setText("Média este ano:");

        jLabel13.setText("Progresso:");

        jLabel14.setText("Média da turma:");

        jLabel15.setText("Faltas:");

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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        paneMatematica.setBackground(new java.awt.Color(204, 204, 204));
        paneMatematica.setBorder(javax.swing.BorderFactory.createTitledBorder("Matemática"));

        medAnosAnteMatem.setText("jLabel1");

        medAnoAtualMatem.setText("jLabel2");

        progressoMatem.setText("jLabel3");

        medTurmaMatem.setText("jLabel4");

        faltasMatem.setText("jLabel5");

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
        panePortugues.setBorder(javax.swing.BorderFactory.createTitledBorder("Português"));

        medAnosAntPortug.setText("jLabel6");

        medAnoAtualPortug.setText("jLabel7");

        progressoPortug.setText("jLabel8");

        medTurmaPortug.setText("jLabel9");

        faltasPortug.setText("jLabel10");

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
                .addContainerGap(13, Short.MAX_VALUE))
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
        panelCiencias.setBorder(javax.swing.BorderFactory.createTitledBorder("Ciências"));

        medAnosAntCiencias.setText("jLabel16");

        medAnoAtualCiencias.setText("jLabel17");

        progressoCiencias.setText("jLabel18");

        medTurmaCiencias.setText("jLabel19");

        faltasCiencias.setText("jLabel20");

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
                .addContainerGap(13, Short.MAX_VALUE))
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

        panelArtes.setBackground(new java.awt.Color(204, 204, 204));
        panelArtes.setBorder(javax.swing.BorderFactory.createTitledBorder("Artes"));

        medAnosAntArtes.setText("jLabel21");

        medAnoAtualArtes.setText("jLabel22");

        progressoArtes.setText("jLabel23");

        medTurmaArtes.setText("jLabel24");

        faltasArtes.setText("jLabel25");

        presencaArtes.setText("jLabel4");

        javax.swing.GroupLayout panelArtesLayout = new javax.swing.GroupLayout(panelArtes);
        panelArtes.setLayout(panelArtesLayout);
        panelArtesLayout.setHorizontalGroup(
            panelArtesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArtesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntArtes)
                    .addComponent(medAnoAtualArtes)
                    .addComponent(progressoArtes)
                    .addComponent(medTurmaArtes)
                    .addComponent(faltasArtes)
                    .addComponent(presencaArtes))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelArtesLayout.setVerticalGroup(
            panelArtesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArtesLayout.createSequentialGroup()
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

        panelIngles.setBackground(new java.awt.Color(204, 204, 204));
        panelIngles.setBorder(javax.swing.BorderFactory.createTitledBorder("Inglês"));

        medAnosAntIngles.setText("jLabel26");

        medAnoAtualIngles.setText("jLabel27");

        progressoIngles.setText("jLabel28");

        medTurmaIngles.setText("jLabel29");

        faltasIngles.setText("jLabel30");

        presencaIngles.setText("jLabel5");

        javax.swing.GroupLayout panelInglesLayout = new javax.swing.GroupLayout(panelIngles);
        panelIngles.setLayout(panelInglesLayout);
        panelInglesLayout.setHorizontalGroup(
            panelInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInglesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntIngles)
                    .addComponent(medAnoAtualIngles)
                    .addComponent(progressoIngles)
                    .addComponent(medTurmaIngles)
                    .addComponent(faltasIngles)
                    .addComponent(presencaIngles))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelInglesLayout.setVerticalGroup(
            panelInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInglesLayout.createSequentialGroup()
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

        panelFisica.setBackground(new java.awt.Color(204, 204, 204));
        panelFisica.setBorder(javax.swing.BorderFactory.createTitledBorder("Ed. Física"));

        medAnosAntFisica.setText("jLabel31");

        medAnoAtualFisica.setText("jLabel32");

        progressoFisica.setText("jLabel33");

        medTurmaFisica.setText("jLabel34");

        faltasFisica.setText("jLabel35");

        presencaFisica.setText("jLabel36");

        javax.swing.GroupLayout panelFisicaLayout = new javax.swing.GroupLayout(panelFisica);
        panelFisica.setLayout(panelFisicaLayout);
        panelFisicaLayout.setHorizontalGroup(
            panelFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFisicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medAnosAntFisica)
                    .addComponent(medAnoAtualFisica)
                    .addComponent(progressoFisica)
                    .addComponent(medTurmaFisica)
                    .addComponent(faltasFisica)
                    .addComponent(presencaFisica))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelFisicaLayout.setVerticalGroup(
            panelFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFisicaLayout.createSequentialGroup()
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
                .addComponent(panelArtes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        paneNotasEFaltasLayout.setVerticalGroup(
            paneNotasEFaltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMatematica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panePortugues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCiencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelArtes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelIngles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel27.setText("Insira o número da matrícula do aluno:");

        javax.swing.GroupLayout paneAlunoEstatisticasLayout = new javax.swing.GroupLayout(paneAlunoEstatisticas);
        paneAlunoEstatisticas.setLayout(paneAlunoEstatisticasLayout);
        paneAlunoEstatisticasLayout.setHorizontalGroup(
            paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                .addComponent(paneNotasEFaltas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscaAlunoEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneAlunoEstatisticasLayout.setVerticalGroup(
            paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlunoEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneAlunoEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaAlunoEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneNotasEFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        tabbedPaneEstatisticas.addTab("Aluno", paneAlunoEstatisticas);

        paneEscolaEstatisticas.setBackground(new java.awt.Color(204, 204, 204));
        paneEscolaEstatisticas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelMediaNotasFaltasTurma.setBackground(new java.awt.Color(204, 204, 204));
        panelMediaNotasFaltasTurma.setBorder(javax.swing.BorderFactory.createTitledBorder("Média de notas/faltas por turma"));

        jListTurmasDaEscola.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneListaTurmas.setViewportView(jListTurmasDaEscola);

        jLabel3.setText("Matemática:");

        jLabel4.setText("Português:");

        jLabel5.setText("Ciências:");

        jLabel6.setText("Artes:");

        jLabel7.setText("Inglês:");

        jLabel8.setText("Ed. Física:");

        medTurmMatemEscola.setText("jLabel9");

        medTurmPortugEscola.setText("jLabel10");

        medTurmCienciasEscola.setText("jLabel21");

        medTurmArtesEscola.setText("jLabel22");

        medTurmInglesEscola.setText("jLabel23");

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
                .addGroup(panelMediaNotasFaltasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneListaTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMediaNotasFaltasTurmaLayout.createSequentialGroup()
                        .addContainerGap()
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
                            .addComponent(medTurmFisicaEscola))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setText("Quantidade de alunos:");

        numAlunosSala.setText("jLabel27");

        JLabel1.setText("Quantidade de alunos na escola:");

        numAlunosEscola.setText("jLabel28");

        JLabel2.setText("Média de alunos por sala:");

        medALunosSala.setText("jLabel29");

        jLabel24.setText("Média de presença da sala:");

        medPresencaSala.setText("jLabel30");

        jLabel25.setText("Média de presença da escola:");

        medPresencaEscola.setText("jLabel31");

        jLabel9.setText("Alunos portadores de necessidades especiais:");

        numAlunosPortNeceEsp.setText("jLabel32");

        jLabel10.setText("Alunos que precisam de acompanhante:");

        numAlunosPortNesseEspAcomp.setText("jLabel33");

        jLabel26.setText("Alunos que utilizam transporte público escolar:");

        numAlunosTranspEscolar.setText("jLabel34");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(numAlunosTranspEscolar))))
                    .addComponent(panelMediaNotasFaltasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medALunosSala, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(medPresencaSala, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelMediaNotasFaltasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(numAlunosTranspEscolar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
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
                            .addComponent(medPresencaEscola))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscaEscolaEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(txtBuscaEscolaEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(paneEscolaEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPaneEstatisticas.addTab("Escola", paneEscolaEstatisticas);

        paneRedeEstatisticas.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel23.setText("Funcionários administrativos na rede:");

        jLabel22.setText("Professores PEB II na rede:");

        jLabel16.setText("Professores PEB I na rede:");

        jLabel19.setText("Escola com o menor número de alunos:");

        jLabel18.setText("Escola com o maior número de alunos:");

        jLabel17.setText("Média de Alunos por escola:");

        jLabel2.setText("Quantidade de escolas:");

        jLabel20.setText("Número de alunos na rede:");

        lblNumAlunosRede.setText("0");

        lblQntdEscolasRede.setText("0");

        lblMediaAlunosPorEscola.setText("0");

        lblEscolaMaisAlunos.setText("0");

        lblEscolaMenosAlunos.setText("0");

        lblProfPebIRede.setText("0");

        lblProfPebIIRede.setText("0");

        lblFuncAdminRede.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel2)
                    .addComponent(jLabel20)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(7, 7, 7)))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumAlunosRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQntdEscolasRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMediaAlunosPorEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEscolaMaisAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFuncAdminRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProfPebIIRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProfPebIRede, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEscolaMenosAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 598, Short.MAX_VALUE))
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
                .addContainerGap(331, Short.MAX_VALUE))
        );

        tabbedPaneEstatisticas.addTab("Rede Municipal", paneRedeEstatisticas);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPaneEstatisticas)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListTurmasDaEscola;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneListaTurmas;
    private javax.swing.JTable jTable1;
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
    private javax.swing.JLabel medAnoAtualIngles;
    private javax.swing.JLabel medAnoAtualMatem;
    private javax.swing.JLabel medAnoAtualPortug;
    private javax.swing.JLabel medAnosAntArtes;
    private javax.swing.JLabel medAnosAntCiencias;
    private javax.swing.JLabel medAnosAntFisica;
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
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelCiencias;
    private javax.swing.JPanel panelFisica;
    private javax.swing.JPanel panelIngles;
    private javax.swing.JPanel panelMediaNotasFaltasTurma;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel presencaArtes;
    private javax.swing.JLabel presencaCiencias;
    private javax.swing.JLabel presencaFisica;
    private javax.swing.JLabel presencaIngles;
    private javax.swing.JLabel presencaMatem;
    private javax.swing.JLabel presencaPortug;
    private javax.swing.JLabel progressoArtes;
    private javax.swing.JLabel progressoCiencias;
    private javax.swing.JLabel progressoFisica;
    private javax.swing.JLabel progressoIngles;
    private javax.swing.JLabel progressoMatem;
    private javax.swing.JLabel progressoPortug;
    private javax.swing.JTabbedPane tabbedPaneEstatisticas;
    private javax.swing.JTextField txtBuscaAlunoEstatisticas;
    private javax.swing.JTextField txtBuscaEscolaEstatisticas;
    // End of variables declaration//GEN-END:variables
    private EscolaDAO eDao = new EscolaDAO();
    private EstatisticasDAO statsDao = new EstatisticasDAO();
    private OuvintesAction oa = new OuvintesAction();
    
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
}