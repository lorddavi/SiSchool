/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.forms;

import br.com.davi.sischool.funcoes.ConverteData;
import br.com.davi.sischool.model.Certificado;
import br.com.davi.sischool.model.Login;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Professor;
import br.com.davi.sischool.regras.CertificadoDAO;
import br.com.davi.sischool.regras.OutroCargoDAO;
import br.com.davi.sischool.regras.ProfessorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davi
 */
public class JFPontos extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal
     */
    public JFPontos() {
     
    }
    
    public JFPontos(Login login){
        funcLogado = ocdao.buscarFunc(login.getFunc().getId());
        initComponents();
        iniciarComponentes();
    }

    public void iniciarComponentes(){
        setaListeners();
        setaTabelas();
    }
    
    public void setaTabelas(){
        tabelaProfessores.setModel(tmp);
    }
    
    public void setaListeners(){
        btnFechar.addActionListener(oa);
        btnMinimizar.addActionListener(oa);
        btnSalvar.addActionListener(oa);
        btnRemover.addActionListener(oa);
        tabelaProfessores.getSelectionModel().addListSelectionListener(ols);
    }
    
    public List<Professor> listaProfs(){
        ProfessorDAO pdao = new ProfessorDAO();
        return pdao.buscarProfessores();
    }
    
    public List<Certificado> listaCertificados(Professor p){
        List<Certificado> lista = p.getCertificados();
        return lista;
    }
    
    public Professor professorSelecionado(){
        int linha = tabelaProfessores.getSelectedRow();
        return tmp.getProf(linha);
    }
    
    private static void ordenaPorPontos(List<Professor> listaProf) {  
        listaProf.sort(new Comparator<Professor>() {  
            @Override  
            public int compare(Professor p1, Professor p2) {
                if (p1.getPontos() > p2.getPontos()){
                    return 1;
                } else {
                    return 0;
                }
            }  

     });  
    }  
    
    public void atribuiCamposSalvar(){
        nomeCurso = txtCurso.getText();
        instituicao = txtInstituicao.getText();
        pontos = txtPontos.getText();
        dataCurso = converteData.converteDataParaUtilDate(fDataCurso);
    }
    
    public void salvar(){
        Certificado c = new Certificado();
        
        int linha = tabelaProfessores.getSelectedRow();
        Professor p = tmp.getProf(linha);
        
        atribuiCamposSalvar();
        c.setNomeCurso(nomeCurso);
        c.setInstituicao(instituicao);
        c.setPontos(Integer.parseInt(pontos));
        c.setDataCurso(dataCurso);
        
        p.setPontos(p.getPontos() + c.getPontos());
        try {  
            c.setProfessor(p);
            tmc.addCertificado(c);
            cdao.inserir(c);
            pdao.editar(p);
            JOptionPane.showMessageDialog(this, "Certificado salvo!");
        } catch (Exception e){
            System.out.println("Não foi possível atribuir o certificado");
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inicia os componentes. Criado automaticamente pelo swing e, portanto, imutável.
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
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtBuscaEscola = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRemover = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtInstituicao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPontos = new javax.swing.JTextField();
        panelCertificados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCertificados = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        fDataCurso = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();

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
        lblTituloPrincipal.setText("SiSchool - Atribuição de Pontos e Certificados");

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/sischool/icons/green.png"))); // NOI18N
        btnMinimizar.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraDeTituloLayout = new javax.swing.GroupLayout(panelBarraDeTitulo);
        panelBarraDeTitulo.setLayout(panelBarraDeTituloLayout);
        panelBarraDeTituloLayout.setHorizontalGroup(
            panelBarraDeTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraDeTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        tabelaProfessores.setModel(tmp);
        jScrollPane1.setViewportView(tabelaProfessores);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Professor(a)"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscaEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 176, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnRemover.setText("Remover Certificado");

        btnSalvar.setText("Salvar Certificado");

        jLabel1.setText("Curso:");

        jLabel2.setText("Instituição:");

        jLabel3.setText("Pontos:");

        panelCertificados.setBackground(new java.awt.Color(204, 204, 204));
        panelCertificados.setBorder(javax.swing.BorderFactory.createTitledBorder("Certificados "));

        tabelaCertificados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabelaCertificados);

        javax.swing.GroupLayout panelCertificadosLayout = new javax.swing.GroupLayout(panelCertificados);
        panelCertificados.setLayout(panelCertificadosLayout);
        panelCertificadosLayout.setHorizontalGroup(
            panelCertificadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCertificadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelCertificadosLayout.setVerticalGroup(
            panelCertificadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCertificadosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEditar.setText("Editar");

        try {
            fDataCurso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fDataCurso.setToolTipText("ddmmaa");

        jLabel4.setText("Data:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCertificados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCurso)
                            .addComponent(txtInstituicao)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel4)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(fDataCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fDataCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18)
                .addComponent(panelCertificados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBarraDeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPontos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField fDataCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JPanel panelBarraDeTitulo;
    private javax.swing.JPanel panelCertificados;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tabelaCertificados;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JTextField txtBuscaEscola;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtInstituicao;
    private javax.swing.JTextField txtPontos;
    // End of variables declaration//GEN-END:variables
    private CertificadoDAO cdao = new CertificadoDAO();
    private OutroCargo funcLogado = new OutroCargo();
    private OutroCargoDAO ocdao = new OutroCargoDAO();
    private OuvintesAction oa = new OuvintesAction();
    private OuvintesListSelection ols = new OuvintesListSelection();
    private TableModelProfessor tmp = new TableModelProfessor(listaProfs());
    private TableModelCertificado tmc = new TableModelCertificado();
    private String nomeCurso, instituicao, pontos;
    private Date dataCurso;
    private ConverteData converteData = new ConverteData();
    private ProfessorDAO pdao = new ProfessorDAO();  

    private class OuvintesAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnFechar){
                dispose();
            } else if (ae.getSource() == btnMinimizar){
                setExtendedState(ICONIFIED);
            } else if (ae.getSource() == btnSalvar){
                salvar();
            } else if (ae.getSource() == btnRemover){
                int linha = tabelaCertificados.getSelectedRow();
                Certificado c = tmc.getCertificado(linha);
                tmc.removeCertificado(linha);
                Professor p = professorSelecionado();
                p.setPontos(p.getPontos() - c.getPontos());
                pdao.editar(p);
                cdao.excluir(c);
                JOptionPane.showMessageDialog(null, "Deletado");
            } 
        }
        
    }
    
    private class OuvintesListSelection implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
                int linha = tabelaProfessores.getSelectedRow();
                Professor p = tmp.getProf(linha);
                tmc = new TableModelCertificado(p.getCertificados());
                tabelaCertificados.setModel(tmc);
        }
    }
    
    private class TableModelProfessor extends AbstractTableModel {
        // Lista de professores a serem exibidos na tabela
        private List<Professor> linhas;
        private String[] colunas = new String[] {"CPF", "Nome", "Pontos"};
        private static final int MATRICULA = 0;
        private static final int NOME = 1;
        private static final int PONTOS = 2;
 
        // Cria um SocioTableModel sem nenhuma linha
        public TableModelProfessor() {
            linhas = new ArrayList<>();
        }
 
        // Cria um SocioTableModel contendo a lista recebida por parâmetro
        public TableModelProfessor(List<Professor> listaProfs) {
            ordenaPorPontos(listaProfs);
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
            case MATRICULA:
                return String.class;
            case NOME:
                return String.class;
            case PONTOS:
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
            // Pega o professor referente a linha especificada.
            Collections.sort(linhas, (Professor p1, Professor p2) -> p1.getNome().compareTo(p2.getNome()));
            Professor prof = linhas.get(rowIndex);
            switch (columnIndex) {
                case MATRICULA:
                    return prof.getCpf();
                case NOME:
                    return prof.getNome();
                case PONTOS:
                    return prof.getPontos();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        // Retorna o professor referente a linha especificada
        public Professor getProf(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        // Adiciona o professor especificado ao modelo
        public void addProf(Professor prof) {
            // Adiciona o registro.
            linhas.add(prof);
 
            // Pega a quantidade de registros e subtrai 1 para
            // achar o último índice. A subtração é necessária
            // porque os índices começam em zero.
            int ultimoIndice = getRowCount() - 1;

            // Notifica a mudança.
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        // Remove o sócio da linha especificada.
        public void removeProf(int indiceLinha) {
            // Remove o registro.
            linhas.remove(indiceLinha);

            // Notifica a mudança.
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        // Adiciona uma lista de professores no final da lista.
        public void addListaDeProfessores(List<Professor> profs) {
            // Pega o tamanho antigo da tabela, que servirá
            // como índice para o primeiro dos novos registros
            int indice = getRowCount();

            // Adiciona os registros.
            linhas.addAll(profs);

            // Notifica a mudança.
            fireTableRowsInserted(indice, indice + profs.size());
        }
 
        // Remove todos os registros.
        public void limpar() {
            // Remove todos os elementos da lista de sócios.
            linhas.clear();

            // Notifica a mudança.
            fireTableDataChanged();
        }
    }
    
    private class TableModelCertificado extends AbstractTableModel {
        // Lista de professores a serem exibidos na tabela
        private List<Certificado> linhas;
        private String[] colunas = new String[] {"Curso", "Instituição", "Pontos"};
        private static final int CURSO = 0;
        private static final int INSTITUICAO = 1;
        private static final int PONTOS = 2;
 
        // Cria um TableModel sem nenhuma linha
        public TableModelCertificado() {
            linhas = new ArrayList<>();
        }
 
        // Cria um TableModel contendo a lista recebida por parâmetro
        public TableModelCertificado(List<Certificado> lista) {
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
            case CURSO:
                return String.class;
            case INSTITUICAO:
                return String.class;
            case PONTOS:
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
            // Pega o professor referente a linha especificada.
            Collections.sort(linhas, (Certificado c1, Certificado c2) -> c1.getNomeCurso().compareTo(c2.getNomeCurso()));
            Certificado certificado = linhas.get(rowIndex);
            switch (columnIndex) {
                case CURSO:
                    return certificado.getNomeCurso();
                case INSTITUICAO:
                    return certificado.getInstituicao();
                case PONTOS:
                    return certificado.getPontos();
                default:
                    throw new IndexOutOfBoundsException("columnIndex out of bounds");
            }
        }
        
        // Retorna o certificado referente a linha especificada
        public Certificado getCertificado(int indiceLinha) {
            return linhas.get(indiceLinha);
        }

        // Adiciona o professor especificado ao modelo
        public void addCertificado(Certificado certificado) {
            // Adiciona o registro.
            linhas.add(certificado);
 
            // Pega a quantidade de registros e subtrai 1 para
            // achar o último índice. A subtração é necessária
            // porque os índices começam em zero.
            int ultimoIndice = getRowCount() - 1;

            // Notifica a mudança.
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
 
        // Remove o sócio da linha especificada.
        public void removeCertificado(int indiceLinha) {
            // Remove o registro.
            linhas.remove(indiceLinha);

            // Notifica a mudança.
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }
 
        // Adiciona uma lista de professores no final da lista.
        public void addListaDeCertificados(List<Certificado> certificados) {
            // Pega o tamanho antigo da tabela, que servirá
            // como índice para o primeiro dos novos registros
            int indice = getRowCount();

            // Adiciona os registros.
            linhas.addAll(certificados);

            // Notifica a mudança.
            fireTableRowsInserted(indice, indice + certificados.size());
        }
 
        // Remove todos os registros.
        public void limpar() {
            // Remove todos os elementos da lista de certificados.
            linhas.clear();

            // Notifica a mudança.
            fireTableDataChanged();
        }
    }
}
