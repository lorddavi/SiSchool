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
    
    public JSONWrite() {
    }
     
    public void gerarJSONPebI(ProfessorPebI prof, int index){
        FileWriter writeFile = null;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", prof.getId());
        jsonObject.put("nome", prof.getNome());
        jsonObject.put("dataNasc", prof.getDataNasc()); //SE PA TEM QUE CONVERTER EM STRING ANTES
        jsonObject.put("genero", prof.getGenero());
        jsonObject.put("endereco", prof.getEndereco());
        jsonObject.put("bairro", prof.getBairro());
        jsonObject.put("cidade", prof.getCidade());
        jsonObject.put("cep", prof.getCep());
        jsonObject.put("telefones", prof.getTelefones()); //OLHAR COM MAIS CLAREZA, VER A QUESTÃO DE PEGAR SÓ ID
        jsonObject.put("observacoes", prof.getObservacoes());
        jsonObject.put("ativo", prof.isAtivo());
        jsonObject.put("cpf", prof.getCpf());
        jsonObject.put("cargo", prof.getCargo());
        jsonObject.put("dataAdmissao", prof.getDataAdmissao());
        jsonObject.put("possuiDeficiencia", prof.isPossuiDeficiencia());
        jsonObject.put("acesso", prof.getAcesso());
        jsonObject.put("userName", prof.getUsrName());
        jsonObject.put("senha", prof.getSenha());
        jsonObject.put("pontos", prof.getPontos());
        jsonObject.put("certificados", prof.getCertificados());
        jsonObject.put("escolas", prof.getEscola());
        jsonObject.put("periodo", prof.getPeriodo());
        jsonObject.put("turma", prof.getTurma()); //QUALQUER COISA TEM Q FAZER UM PUT TURMA1, TURMA2, ETC.
        try{
            writeFile = new FileWriter("Arquivos/ProfPebI" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
     
    public void gerarJSONTodos(List<ProfessorPebI> p){
        FileWriter writeFile = null;
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
