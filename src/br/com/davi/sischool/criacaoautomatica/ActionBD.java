package br.com.davi.sischool.criacaoautomatica;
        
import java.sql.*;
import javax.swing.JOptionPane;

public class ActionBD {
    private conexao conecta;
    private Statement st;
    private PreparedStatement pst;
    
    public ActionBD(){
        
    }
    
    public ActionBD(String sql){
        try {
            conecta = new conexao();
            if (!conecta.getConnection()){
                JOptionPane.showMessageDialog(null, "Falha na conexão, o sistema será fechado!");
                System.exit(0);
            }
            st = conecta.conexao.createStatement();
            st.executeUpdate(sql);
            System.out.println("Comando executado com sucesso!");
            st.close();
            conecta.close();
        } catch(Exception e){
            System.out.println("Não foi possível executar o comando.");
            e.getMessage();
            e.printStackTrace();   
        }
    }
    
    public void createDB(String nomeDB){
        try {
            conecta = new conexao();
            if (!conecta.getConnection()){
                JOptionPane.showMessageDialog(null, "Falha na conexão, o sistema será fechado!");
                System.exit(0);
            }
            String sql = "CREATE DATABASE IF NOT EXISTS " + nomeDB;
            st = conecta.conexao.createStatement();
            st.executeUpdate(sql);
            System.out.println("Banco " + nomeDB + " criado com sucesso!");
            st.close();
            conecta.close();
        } catch (Exception e) {

        }
    }
    
    public void criarDavi(String nomeBD){
        try { 
            conecta = new conexao();
            if (!conecta.getConnection()){
                JOptionPane.showMessageDialog(null, "Falha na conexão, o sistema será fechado!");
                System.exit(0);
            }
            String sql1 = "USE " + nomeBD;
            String sql2 = "INSERT INTO pessoa (id, tipo, nome) VALUES (1, 'OutroCargo', 'Davi');";
            String sql3 = "INSERT INTO funcionario (id, acesso, cargo, senha, usrname) VALUES (1, 3, 'Desenvolvedor', 'dev', 'dev');";
            String sql4 = "INSERT INTO outroCargo (id) VALUES (1)";
            st = conecta.conexao.createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);
            st.executeUpdate(sql4);
            st.close();
            conecta.close();
        } catch (Exception e) {

        }
    }

}