/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.Tabela;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.Transferencia;
import br.com.davi.sischool.model.Turma;
import br.com.davi.sischool.regras.AlunoDAO;
import br.com.davi.sischool.regras.EscolaDAO;
import br.com.davi.sischool.regras.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFTransferirAlunos extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal
     */
    public JFTransferirAlunos() {
        
    }
    
    public JFTransferirAlunos(Login login){
        func = login.getFunc();
        initComponents();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        setaListeners();
        preencheEscolas();
        preencheTurmas();
    }
    
    private void setaListeners(){
        OuvintesAction oa = new OuvintesAction();
        OuvintesItems oi = new OuvintesItems();
        OuvintesKey ok = new OuvintesKey();
        
        btnMinimizar.addActionListener(oa);
        btnFechar.addActionListener(oa);
        btnTransferir.addActionListener(oa);
        comboEscolas.addItemListener(oi);
        txtBusca.addKeyListener(ok);
    }
    
    private void pegaDados(){
        Escola escola = (Escola) comboEscolas.getSelectedItem();
        Turma turma = (Turma) comboSerie.getSelectedItem();
        transf.setFuncionario(func);
        transf.setAluno(selecionaAluno());
        transf.setEscola(escola);
        transf.setTurma(turma);
    }
        
    private Aluno selecionaAluno(){
        int linha = tabelaAlunos.getSelectedRow();
        return tma.getAluno(linha);
    }
    
    private void atualizaTabela(List<Aluno> alunos){
        tma = new TableModelAluno(alunos);
        tabelaAlunos.setModel(tma);
    }
        
    private void buscaAluno(){
        busca = "%" + txtBusca.getText() + "%";
        alunos = adao.buscarPorNome("%" + busca + "%");
        atualizaTabela(alunos);
    }
    
    private void preencheTurmas(){
        Escola escola = (Escola) comboEscolas.getSelectedItem();
        if (escola != null){
            for (Turma t: escola.getTurmas()){
                    comboSerie.addItem(t);
            }
        }
    }
    
    private void preencheEscolas(){
            for (Escola e: edao.buscaTodas()){
                    comboEscolas.addItem(e);
            }   
    }
    
    private void salvarTransferencia(){
        pegaDados();
        tDao.inserir(transf);
        JOptionPane.showMessageDialog(null, "Solicitação enviada. Aguardando confirmação!");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupCriterioBusca = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBarraDeTitulo = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        lblTituloPrincipal = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        paneFundo = new javax.swing.JPanel();
        paneBuscaETransfere = new javax.swing.JPanel();
        paneCriterioBusca = new javax.swing.JPanel();
        radioNome = new javax.swing.JRadioButton();
        radioRa = new javax.swing.JRadioButton();
        txtBusca = new javax.swing.JTextField();
        scrollPaneTabela = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        paneTransfere = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboEscolas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboSerie = new javax.swing.JComboBox<>();
        btnTransferir = new javax.swing.JButton();

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
        lblTituloPrincipal.setText("SiSchool - Transferir Alunos");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        paneFundo.setBackground(new java.awt.Color(204, 204, 204));

        paneBuscaETransfere.setBackground(new java.awt.Color(204, 204, 204));

        paneCriterioBusca.setBackground(new java.awt.Color(204, 204, 204));
        paneCriterioBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Critério de Busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnGroupCriterioBusca.add(radioNome);
        radioNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioNome.setSelected(true);
        radioNome.setText("Nome");

        btnGroupCriterioBusca.add(radioRa);
        radioRa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioRa.setText("RA");

        javax.swing.GroupLayout paneCriterioBuscaLayout = new javax.swing.GroupLayout(paneCriterioBusca);
        paneCriterioBusca.setLayout(paneCriterioBuscaLayout);
        paneCriterioBuscaLayout.setHorizontalGroup(
            paneCriterioBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCriterioBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioNome)
                .addGap(18, 18, 18)
                .addComponent(radioRa)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        paneCriterioBuscaLayout.setVerticalGroup(
            paneCriterioBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCriterioBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCriterioBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNome)
                    .addComponent(radioRa))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        txtBusca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabelaAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaAlunos.setModel(tma);
        scrollPaneTabela.setViewportView(tabelaAlunos);

        paneTransfere.setBackground(new java.awt.Color(204, 204, 204));
        paneTransfere.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transferir para:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Escola");

        comboEscolas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Série:");

        comboSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout paneTransfereLayout = new javax.swing.GroupLayout(paneTransfere);
        paneTransfere.setLayout(paneTransfereLayout);
        paneTransfereLayout.setHorizontalGroup(
            paneTransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTransfereLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneTransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(comboEscolas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(comboSerie, 0, 318, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneTransfereLayout.setVerticalGroup(
            paneTransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTransfereLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEscolas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTransferir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTransferir.setText("Transferir");

        javax.swing.GroupLayout paneBuscaETransfereLayout = new javax.swing.GroupLayout(paneBuscaETransfere);
        paneBuscaETransfere.setLayout(paneBuscaETransfereLayout);
        paneBuscaETransfereLayout.setHorizontalGroup(
            paneBuscaETransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneBuscaETransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                        .addComponent(scrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneBuscaETransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paneTransfere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(btnTransferir)
                                .addGap(0, 143, Short.MAX_VALUE))))
                    .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                        .addComponent(paneCriterioBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        paneBuscaETransfereLayout.setVerticalGroup(
            paneBuscaETransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                .addComponent(paneCriterioBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneBuscaETransfereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneBuscaETransfereLayout.createSequentialGroup()
                        .addComponent(paneTransfere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTransferir)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneFundoLayout = new javax.swing.GroupLayout(paneFundo);
        paneFundo.setLayout(paneFundoLayout);
        paneFundoLayout.setHorizontalGroup(
            paneFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFundoLayout.createSequentialGroup()
                .addComponent(paneBuscaETransfere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneFundoLayout.setVerticalGroup(
            paneFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFundoLayout.createSequentialGroup()
                .addComponent(paneBuscaETransfere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFTransferirAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.ButtonGroup btnGroupCriterioBusca;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JComboBox<Escola> comboEscolas;
    private javax.swing.JComboBox<Turma> comboSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel paneBuscaETransfere;
    private javax.swing.JPanel paneCriterioBusca;
    private javax.swing.JPanel paneFundo;
    private javax.swing.JPanel paneTransfere;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioNome;
    private javax.swing.JRadioButton radioRa;
    private javax.swing.JScrollPane scrollPaneTabela;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
    private Funcionario func = new Funcionario();
    private EscolaDAO edao = new EscolaDAO();
    private AlunoDAO adao = new AlunoDAO();
    private TableModelAluno tma = new TableModelAluno();
    private String busca = new String();
    private Transferencia transf = new Transferencia();
    private List<Aluno> alunos = new ArrayList<>();
    private TransferenciaDAO tDao = new TransferenciaDAO();
   
    class OuvintesAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == btnFechar){
                dispose();
            } else if (evt.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (evt.getSource() == btnTransferir){
                salvarTransferencia();
            }
        }
    }
    
    class OuvintesItems implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource() == comboEscolas){
                comboSerie.removeAllItems();
                preencheTurmas();
            }
        }
        
    }
    
    class OuvintesKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            buscaAluno();
        }
        
    }
    
    private class TableModelAluno extends AbstractTableModel {
        private List<Aluno> linhas;
        private String[] colunas = new String[] {"RA", "Nome", "Escola", "Turma"};
        private static final int RA = 0;
        private static final int NOME = 1;
        private static final int ESCOLA = 2;
        private static final int TURMA = 3;
 
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
            case ESCOLA:
                return String.class;
            case TURMA:
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
            switch (columnIndex) {
                case RA:
                    return a.getRa();
                case NOME:
                    return a.getNome();
                case ESCOLA:
                    return a.getEscola().getNome();
                case TURMA:
                    return a.getSerie();
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
}
