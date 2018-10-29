package br.com.davi.sischool.criacaoautomatica;

import java.sql.*;

public class conexao {
    public Connection conexao = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DBNAME = "";
    private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private final String LOGIN = "root";
    private final String SENHA = "";
        
    public boolean getConnection(){
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Driver não encontrado " + erro.toString());
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha ao conectar " + erro.toString());
            return false;
        }
    }
    
    public void close(){
       try {
           conexao.close();
       } catch (SQLException erro) {
           
       }
    }
    
}
