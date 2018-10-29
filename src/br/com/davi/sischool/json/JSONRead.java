/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.json;

import br.com.davi.sischool.model.Funcionario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public Funcionario lerJSONFuncionario(){
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        
        //Variaveis que irao armazenar os dados do arquivo JSON
        int id;
        String nome;
        String cargo;
        int acesso;
        String usrName;
        String senha;
        Funcionario f = new Funcionario();
 
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader("Funcionarios.json"));
             
            //Salva nas variaveis os dados retirados do arquivo
            nome = (String) jsonObject.get("nome");
            cargo = (String) jsonObject.get("cargo");
            acesso = Integer.parseInt(jsonObject.get("acesso").toString());
            usrName = (String) jsonObject.get("userName");
            senha = (String) jsonObject.get("senha");
            
            f.setNome(nome);
            f.setCargo(cargo);
            f.setAcesso(acesso);
            f.setUsrName(usrName);
            f.setSenha(senha);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return f;
    }
}
