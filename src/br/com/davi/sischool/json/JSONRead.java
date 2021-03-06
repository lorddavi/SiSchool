/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.json;

import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Funcionario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Davi
 */
public class JSONRead {
    JSONObject jsonObject;

    public JSONRead() {
    }
   
    public void lerJSONFuncionario(int index) throws FileNotFoundException, IOException {
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        int id, acesso;
        String nome, cargo, usrName, senha;
        
        Funcionario f = new Funcionario();
 
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "Arquivos/Funcionarios" + String.valueOf(index) + ".json"));
             
            //Salva nas variaveis os dados retirados do arquivo
            senha = (String) jsonObject.get("senha");
            acesso = Integer.parseInt(jsonObject.get("acesso").toString());
            nome = (String) jsonObject.get("nome");
            cargo = (String) jsonObject.get("cargo");
            usrName = (String) jsonObject.get("userName");
            
            
            f.setNome(nome);
            f.setCargo(cargo);
            f.setAcesso(acesso);
            f.setUsrName(usrName);
            f.setSenha(senha);
 
            
            JOptionPane.showMessageDialog(null, f.getNome());
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void lerJSONAluno(int index) throws FileNotFoundException, IOException {
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        ImageIcon foto = new ImageIcon();
        
        Aluno a = new Aluno();
 
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "Arquivos/Aluno" + String.valueOf(index) + ".json"));
             
            //Salva nas variaveis os dados retirados do arquivo
            foto = (ImageIcon) jsonObject.get("foto");
            
            
 
            
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
