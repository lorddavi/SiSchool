package br.com.davi.sischool.json;

/**
 *
 * @author Davi
 */

import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.ProfessorPebI;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;

public class JSONWrite {
    //Cria um Objeto JSON
    JSONObject jsonObject = new JSONObject();
    FileWriter writeFile = null;
    
    public JSONWrite() {
    }
    
    public void gerarJSONFuncionario(Funcionario f){
        FileWriter writeFile = null;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", f.getNome());
        jsonObject.put("cargo", f.getCargo());
        jsonObject.put("acesso", f.getAcesso());
        jsonObject.put("userName", f.getUsrName());
        jsonObject.put("senha", f.getSenha());
        try{
            writeFile = new FileWriter("Funcionarios.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void gerarJSONPebI(List<ProfessorPebI> p){
        
        //Armazena dados em um Objeto JSON
            try{
                writeFile = new FileWriter("OutroCargo.json");
                for (ProfessorPebI prof: p){
                    jsonObject.put("nome", prof.getNome() + "");
                    jsonObject.put("cargo", prof.getCargo());
                    jsonObject.put("acesso", prof.getAcesso());
                    jsonObject.put("userName", prof.getUsrName());
                    jsonObject.put("senha", prof.getSenha());
                    jsonObject.put("periodo", prof.getPeriodo());
                    jsonObject.put("escola", prof.getEscola());
                    jsonObject.put("turma", prof.getTurma());
                    
                    //Escreve no arquivo conteudo do Objeto JSON
                    writeFile.write(jsonObject.toJSONString());
                }

                writeFile.close();
            } catch(IOException e){
                e.printStackTrace();
            }
    } 
}
