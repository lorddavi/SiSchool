/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.PreencheCombo;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Professor;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.OutroCargoDAO;
import br.com.davi.sischool.regras.ProfessorDAO;
import br.com.davi.sischool.regras.ProfessorPebIIDAO;
import br.com.davi.sischool.regras.TurmaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFCronograma extends javax.swing.JFrame {

    /**
     * Creates new form JFCronograma
     */
    public JFCronograma() {
        
    }
    
    public JFCronograma(Login login){
        oc = ocdao.buscarFunc(login.getFunc().getId());
        initComponents();
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        Escola e = oc.getEscola();
        preencheCombo.preencheTurmas(comboTurmas, e);
        t = (Turma) comboTurmas.getSelectedItem();
        lblNomeTurma.setText(t.toString());
        preencheCombo.preenchePeriodo(comboAula, t);
        setaListeners();
        tmp = new TableModelProfessor(pdao.buscarProfessores());
        tabelaProfs.setModel(tmp);
        tmc = new TableModelCronograma(t);
        tabelaCrono.setModel(tmc);
    }
    
    private void setaListeners(){
        comboTurmas.addItemListener(ov);
        btnAtribuir.addActionListener(oa);
        btnSalvar.addActionListener(oa);
        btnRemover.addActionListener(oa);
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        txtBusca.addActionListener(oa);
    }
    
    private Professor selecionaProfessor(){
        try {
            int linha = tabelaProfs.getSelectedRow();
            return tmp.getProf(linha);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Você precisa selecionar um professor");
            return null;
        }
    }
    
    private void buscar(){
        busca = txtBusca.getText();
        tmp = new TableModelProfessor(pdao.buscarPorNome("%" + busca + "%"));
        tabelaProfs.setModel(tmp);
    }
    
    public void btnAtribuir(){
        int linha = comboDia.getSelectedIndex();
        int coluna = comboAula.getSelectedIndex();
        int[][] cronograma = t.getCronograma();
        prof = selecionaProfessor();
        if (prof != null){
            cronograma[linha][coluna] = prof.getId();
            t.setCronograma(cronograma);
            tmc = new TableModelCronograma(t);
            tabelaCrono.setModel(tmc);
        }
    }

    /**
     * Método que inicia todos os componentes do form ao ser chamado no construtor.
     * Criado automaticamente pelo swing e, por isso, imutável.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        panelConteudo = new javax.swing.JPanel();
        panelAtribuicao = new javax.swing.JPanel();
        scroolPaneTabelaProfessor = new javax.swing.JScrollPane();
        tabelaProfs = new javax.swing.JTable();
        comboTurmas = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAtribuir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        comboDia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboAula = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        panelVisualizarCronograma = new javax.swing.JPanel();
        scrollPaneTabelaCrono = new javax.swing.JScrollPane();
        tabelaCrono = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblNomeTurma = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Cronograma de aulas");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        panelConteudo.setBackground(new java.awt.Color(204, 204, 204));

        panelAtribuicao.setBackground(new java.awt.Color(204, 204, 204));

        tabelaProfs.setModel(tmp);
        scroolPaneTabelaProfessor.setViewportView(tabelaProfs);

        txtBusca.setToolTipText("Busque um Professor");

        jLabel4.setText("Selecione a turma:");

        btnAtribuir.setText("Atribuir");

        btnRemover.setText("Remover");

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira" }));

        jLabel3.setText("Dia da Semana:");

        jLabel5.setText("Aula:");

        jLabel6.setText("Busque um professor:");

        javax.swing.GroupLayout panelAtribuicaoLayout = new javax.swing.GroupLayout(panelAtribuicao);
        panelAtribuicao.setLayout(panelAtribuicaoLayout);
        panelAtribuicaoLayout.setHorizontalGroup(
            panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                        .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                                .addComponent(scroolPaneTabelaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                                .addGap(39, 39, 39))
                            .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboTurmas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAtribuicaoLayout.createSequentialGroup()
                                    .addComponent(btnRemover)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAtribuir)))
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboAula, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboDia, javax.swing.GroupLayout.Alignment.LEADING, 0, 113, Short.MAX_VALUE)))
                        .addGap(31, 31, 31))
                    .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelAtribuicaoLayout.setVerticalGroup(
            panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAtribuicaoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelAtribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemover)
                            .addComponent(btnAtribuir))
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(scroolPaneTabelaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelVisualizarCronograma.setBackground(new java.awt.Color(204, 204, 204));
        panelVisualizarCronograma.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaCrono.setModel(tmc);
        scrollPaneTabelaCrono.setViewportView(tabelaCrono);

        jLabel1.setText("Turma:");

        lblNomeTurma.setText("nome da turma");

        javax.swing.GroupLayout panelVisualizarCronogramaLayout = new javax.swing.GroupLayout(panelVisualizarCronograma);
        panelVisualizarCronograma.setLayout(panelVisualizarCronogramaLayout);
        panelVisualizarCronogramaLayout.setHorizontalGroup(
            panelVisualizarCronogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVisualizarCronogramaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(lblNomeTurma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelVisualizarCronogramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTabelaCrono)
                .addContainerGap())
        );
        panelVisualizarCronogramaLayout.setVerticalGroup(
            panelVisualizarCronogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVisualizarCronogramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVisualizarCronogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNomeTurma))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTabelaCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout panelConteudoLayout = new javax.swing.GroupLayout(panelConteudo);
        panelConteudo.setLayout(panelConteudoLayout);
        panelConteudoLayout.setHorizontalGroup(
            panelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelVisualizarCronograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAtribuicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConteudoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(107, 107, 107)
                .addComponent(btnSalvar)
                .addGap(339, 339, 339))
        );
        panelConteudoLayout.setVerticalGroup(
            panelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAtribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelVisualizarCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                new JFCronograma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtribuir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboAula;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<Turma> comboTurmas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelAtribuicao;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelConteudo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelVisualizarCronograma;
    private javax.swing.JScrollPane scrollPaneTabelaCrono;
    private javax.swing.JScrollPane scroolPaneTabelaProfessor;
    private javax.swing.JTable tabelaCrono;
    private javax.swing.JTable tabelaProfs;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
    private OutroCargo oc = new OutroCargo();
    private OutroCargoDAO ocdao = new OutroCargoDAO();
    private PreencheCombo preencheCombo = new PreencheCombo();
    private OuvintesItens ov = new OuvintesItens();
    private OuvintesActions oa = new OuvintesActions();
    private Professor prof = new Professor();
    private ProfessorDAO pdao = new ProfessorDAO();
    private List<Professor> profs = new ArrayList<>();
    private Turma t = new Turma();
    private TableModelProfessor tmp = new TableModelProfessor();
    private TableModelCronograma tmc = new TableModelCronograma();
    private String busca;
    
    
    private class OuvintesItens implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() == comboTurmas){
                t = (Turma) comboTurmas.getSelectedItem();
                lblNomeTurma.setText(t.toString());
                preencheCombo.preenchePeriodo(comboAula, t);
                tmc = new TableModelCronograma(t);
                tabelaCrono.setModel(tmc);
            }
        }
    }
    
    private class OuvintesActions implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnAtribuir){
                btnAtribuir();
            } else if (ae.getSource() == btnSalvar){
                TurmaDAO tdao = new TurmaDAO();
                try {
                    tdao.editar(t);
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro");
                }
            } else if (ae.getSource() == btnRemover){
                int linha = comboDia.getSelectedIndex();
                int coluna = comboAula.getSelectedIndex();
                int[][] cronograma = t.getCronograma();
                cronograma[linha][coluna] = 0;
                t.setCronograma(cronograma);
                tmc = new TableModelCronograma(t);
                tabelaCrono.setModel(tmc);
            } else if (ae.getSource()==txtBusca){
                buscar();
            }
        }
        
    }
    
    private class TableModelProfessor extends AbstractTableModel {
        private List<Professor> linhas;
        private String[] colunas = new String[] {"Professor", "Categoria", "Especialidade"};
        private static final int PROFESSOR = 0;
        private static final int CATEGORIA = 1;
        private static final int ESPECIALIDADE = 2;
 
        public TableModelProfessor() {
            linhas = new ArrayList<>();
        }
 
        public TableModelProfessor(List<Professor> listaProfs) {
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
            case PROFESSOR:
                return String.class;
            case CATEGORIA:
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
            Collections.sort(linhas, (Professor p1, Professor p2) -> p1.getNome().compareTo(p2.getNome()));
            Professor prof = linhas.get(rowIndex);
            ProfessorPebII p2 = new ProfessorPebII();
            ProfessorPebIIDAO piidao = new ProfessorPebIIDAO();
            switch (columnIndex) {
                case PROFESSOR:
                    return prof.getNome();
                case CATEGORIA:
                    return prof.getCargo();
                case ESPECIALIDADE:
                    if (prof.getCargo().equals("Professor PEB II")){
                        p2 = piidao.buscarId(prof.getId());
                        return p2.getEspecialidade();
                    } else {
                        return "-";
                    }
                default:
                        throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        public Professor getProf(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        public void addProf(Professor prof) {
            linhas.add(prof);
 
            int ultimoIndice = getRowCount() - 1;

            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        public void removeProf(int indiceLinha) {
            linhas.remove(indiceLinha);

            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        public void addListaDeProfessores(List<Professor> profs) {
            int indice = getRowCount();

            linhas.addAll(profs);

            fireTableRowsInserted(indice, indice + profs.size());
        }
 
        public void limpar() {
            linhas.clear();

            fireTableDataChanged();
        }
    }
    
    private class TableModelCronograma extends AbstractTableModel {
        Turma turma = new Turma();
        private String[] colunas = new String[] {"Aula", "Segunda-feira", "Terça-feira",
                        "Quarta-feira", "Quinta-feira", "Sexta-feira"};
        private String[] aulas = new String []{"Aula 1", "Aula 2", "Aula 3", "Aula 4", "Aula 5"};
        private static final int AULA = 0;
        private static final int SEGUNDA = 1;
        private static final int TERCA = 2;
        private static final int QUARTA = 3;
        private static final int QUINTA = 4;
        private static final int SEXTA = 5;
 
        public TableModelCronograma() {

        }
 
        public TableModelCronograma(Turma t) {
            turma = t;
        }
        
        @Override
        public int getRowCount() {
            return aulas.length;
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
            case AULA:
                return String.class;
            case SEGUNDA:
                return String.class;
            case TERCA:
                return String.class;
            case QUARTA:
                return String.class;
            case QUINTA:
                return String.class;
            case SEXTA:
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
        public Object getValueAt(int linha, int coluna) {
            int crono[][] = turma.getCronograma();
            switch (coluna) {
                case AULA:
                    return aulas[linha];
                case SEGUNDA:
                    try {
                        return pdao.buscarId(crono[coluna-1][linha]).getNome();
                    } catch(Exception e) {
                        return null;
                    }
                case TERCA:
                    try {
                        return pdao.buscarId(crono[coluna-1][linha]).getNome();
                    } catch(Exception e) {
                        return null;
                    }
                case QUARTA:
                    try {
                        return pdao.buscarId(crono[coluna-1][linha]).getNome();
                    } catch(Exception e) {
                        return null;
                    }
                case QUINTA:
                    try {
                        return pdao.buscarId(crono[coluna-1][linha]).getNome();
                    } catch(Exception e) {
                        return null;
                    }
                case SEXTA:
                    try {
                        return pdao.buscarId(crono[coluna-1][linha]).getNome();
                    } catch(Exception e) {
                        return null;
                    }
                default:
                        throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
    }
}
