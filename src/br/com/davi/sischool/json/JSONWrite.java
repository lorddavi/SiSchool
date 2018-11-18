package br.com.davi.sischool.json;

/**
 *
 * @author Davi
 */

import br.com.davi.sischool.funcoes.ConverteData;
import br.com.davi.sischool.model.Aluno;
import br.com.davi.sischool.model.Certificado;
import br.com.davi.sischool.model.Escola;
import br.com.davi.sischool.model.NotasFaltas;
import br.com.davi.sischool.model.OutroCargo;
import br.com.davi.sischool.model.Professor;
import br.com.davi.sischool.model.ProfessorPebI;
import br.com.davi.sischool.model.ProfessorPebII;
import br.com.davi.sischool.model.Telefone;
import br.com.davi.sischool.model.Turma;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

public class JSONWrite {
    //Cria um Objeto JSON
    JSONObject jsonObject = new JSONObject();
    ConverteData cd = new ConverteData();
    
    public JSONWrite() {
    }
     
    public void gerarJSONPebI(ProfessorPebI prof, int index){
        FileWriter writeFile = null;
        int percorre = 0;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", prof.getId());
        jsonObject.put("nome", prof.getNome());
        jsonObject.put("dataNasc", prof.getDataNasc()); 
        jsonObject.put("genero", prof.getGenero());
        jsonObject.put("endereco", prof.getEndereco());
        jsonObject.put("bairro", prof.getBairro());
        jsonObject.put("cidade", prof.getCidade());
        jsonObject.put("cep", prof.getCep());
        
        for (Telefone t: prof.getTelefones()){
          jsonObject.put("telefones"+String.valueOf(percorre), t.getId());
          percorre++;
        }
        percorre = 0;
        
        jsonObject.put("observacoes", prof.getObservacoes());
        jsonObject.put("ativo", prof.isAtivo()); //PESSOA ATÉ AQUI
        jsonObject.put("cpf", prof.getCpf());
        jsonObject.put("cargo", prof.getCargo());
        jsonObject.put("dataAdmissao", prof.getDataAdmissao());
        jsonObject.put("possuiDeficiencia", prof.isPossuiDeficiencia());
        jsonObject.put("acesso", prof.getAcesso());
        jsonObject.put("userName", prof.getUsrName());
        jsonObject.put("senha", prof.getSenha()); //FUNCIONARIO ATÉ AQUI
        jsonObject.put("pontos", prof.getPontos());
        
        for (Certificado c: prof.getCertificados()){
            jsonObject.put("certificados"+String.valueOf(percorre), c.getId());
            percorre++;
        }
        percorre = 0;
        
        for (Escola e: prof.getEscola()){
            jsonObject.put("escola"+String.valueOf(percorre), e.getId()); //PROFESSOR ATÉ AQUI
            percorre++;
        }
        percorre = 0;
        
        jsonObject.put("periodo", prof.getPeriodo());
        
        for (Turma t: prof.getTurma()){
            jsonObject.put("turma"+String.valueOf(percorre), t.getId());
            percorre++;
        }
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
    
    public void gerarJSONPebII(ProfessorPebII prof, int index){
        FileWriter writeFile = null;
        int percorre = 0;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", prof.getId());
        jsonObject.put("nome", prof.getNome());
        jsonObject.put("dataNasc", prof.getDataNasc()); 
        jsonObject.put("genero", prof.getGenero());
        jsonObject.put("endereco", prof.getEndereco());
        jsonObject.put("bairro", prof.getBairro());
        jsonObject.put("cidade", prof.getCidade());
        jsonObject.put("cep", prof.getCep());
        
        for (Telefone t: prof.getTelefones()){
          jsonObject.put("telefones"+String.valueOf(percorre), t.getId());
          percorre++;
        }
        percorre = 0;
        
        jsonObject.put("observacoes", prof.getObservacoes());
        jsonObject.put("ativo", prof.isAtivo()); //PESSOA ATÉ AQUI
        jsonObject.put("cpf", prof.getCpf());
        jsonObject.put("cargo", prof.getCargo());
        jsonObject.put("dataAdmissao", prof.getDataAdmissao());
        jsonObject.put("possuiDeficiencia", prof.isPossuiDeficiencia());
        jsonObject.put("acesso", prof.getAcesso());
        jsonObject.put("userName", prof.getUsrName());
        jsonObject.put("senha", prof.getSenha()); //FUNCIONÁRIO ATÉ AQUI
        jsonObject.put("pontos", prof.getPontos());
        
        for (Certificado c: prof.getCertificados()){
            jsonObject.put("certificados"+String.valueOf(percorre), c.getId());
            percorre++;
        }
        percorre = 0;
        
        for (Escola e: prof.getEscola()){
            jsonObject.put("escola"+String.valueOf(percorre), e.getId()); //PROFESSOR ATÉ AQUI
            percorre++;
        }
        percorre = 0;
        
        jsonObject.put("especialidade", prof.getEspecialidade());
        jsonObject.put("aulasAtribuidas", prof.getAulasAtribuidas());
        
        for (Turma t: prof.getTurmas()){
            jsonObject.put("turma"+String.valueOf(percorre), t.getId());
            percorre++;
        }
        try{
            writeFile = new FileWriter("Arquivos/ProfPebII" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void gerarJSONOutroCargo(OutroCargo func, int index){
        FileWriter writeFile = null;
        int percorre = 0;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", func.getId());
        jsonObject.put("nome", func.getNome());
        jsonObject.put("dataNasc", func.getDataNasc()); 
        jsonObject.put("genero", func.getGenero());
        jsonObject.put("endereco", func.getEndereco());
        jsonObject.put("bairro", func.getBairro());
        jsonObject.put("cidade", func.getCidade());
        jsonObject.put("cep", func.getCep());
        
        for (Telefone t: func.getTelefones()){
          jsonObject.put("telefones"+String.valueOf(percorre), t.getId());
          percorre++;
        }
        percorre = 0;
        
        jsonObject.put("observacoes", func.getObservacoes());
        jsonObject.put("ativo", func.isAtivo()); //PESSOA ATÉ AQUI
        jsonObject.put("cpf", func.getCpf());
        jsonObject.put("cargo", func.getCargo());
        jsonObject.put("dataAdmissao", func.getDataAdmissao());
        jsonObject.put("possuiDeficiencia", func.isPossuiDeficiencia());
        jsonObject.put("acesso", func.getAcesso());
        jsonObject.put("userName", func.getUsrName());
        jsonObject.put("senha", func.getSenha()); //FUNCIONÁRIO ATÉ AQUI
        try {
            jsonObject.put("escola", func.getEscola().getId()); //UNICO ATRIBUTO DO OUTROCARGO
        } catch (NullPointerException ex){
            jsonObject.put("escola", "");
        }
       
        try{
            writeFile = new FileWriter("Arquivos/OutroCargo" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void gerarJSONAluno(Aluno a, int index){
        FileWriter writeFile = null;
        int percorre = 0;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", a.getId());
        jsonObject.put("nome", a.getNome());
        jsonObject.put("dataNasc", a.getDataNasc());
        jsonObject.put("genero", a.getGenero());
        jsonObject.put("endereco", a.getEndereco());
        jsonObject.put("bairro", a.getBairro());
        jsonObject.put("cidade", a.getCidade());
        jsonObject.put("cep", a.getCep());
        
        for (Telefone t: a.getTelefones()){
            jsonObject.put("telefone"+String.valueOf(percorre), t.getId());
            percorre++;
        }
        percorre = 0;
        
        jsonObject.put("observacoes", a.getObservacoes());
        jsonObject.put("ativo", a.isAtivo()); //PESSOAS ATÉ AQUI
        jsonObject.put("ra", a.getRa());
        jsonObject.put("serie", a.getSerie().getId());
        jsonObject.put("necesEspec", a.isNecesEspec());
        jsonObject.put("necesAcomp", a.isNecesEspecAcomp());
        jsonObject.put("transpPublico", a.isTranspPublicoEscolar());
        jsonObject.put("nomePai", a.getNomePai());
        jsonObject.put("paiResponsavel", a.isPaiResponsavel());
        jsonObject.put("nomeMae", a.getNomeMae());
        jsonObject.put("maeResponsavel", a.isMaeResponsavel());
        jsonObject.put("outroResponsavel", a.isOutroResponsavel());
        jsonObject.put("nomeResponsavel", a.getNomeResponsavel());
        
        for (NotasFaltas nf: a.getNotasFaltas()){
            jsonObject.put("notasFaltas"+String.valueOf(percorre), nf.getId());
            percorre++;
        }
        percorre=0;
        
        //jsonObject.put("comprovanteResidencia", a.getComprovanteResidencia()); TEM QUE VER ISSO AÍ
        //jsonObject.put("foto3x4", a.getFoto3x4()); TEM QUE VER ISSO AÍ
        
        jsonObject.put("aprovado", a.isAprovado());
        try{
            writeFile = new FileWriter("Arquivos/Aluno" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void gerarJSONCertificado(Certificado c, int index){
        FileWriter writeFile = null;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", c.getId());
        jsonObject.put("pontos", c.getPontos());
        jsonObject.put("nomeCurso", c.getNomeCurso());
        jsonObject.put("instituicao", c.getInstituicao());
        jsonObject.put("dataCurso", c.getDataCurso());
        jsonObject.put("professor", c.getProfessor());
        
        try{
            writeFile = new FileWriter("Arquivos/Certificado" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void gerarJSONEscola(Escola e, int index){
        FileWriter writeFile = null;
        int percorre = 0;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", e.getId());
        jsonObject.put("nome", e.getNome());
        jsonObject.put("endereco", e.getEndereco());
        jsonObject.put("bairro", e.getBairro());
        
        for (Telefone t: e.getTelefones()){
            jsonObject.put("telefone"+String.valueOf(percorre), t.getId());
            percorre++;
        }
        percorre = 0;
        
        for (OutroCargo oc : e.getFuncOutroCargo()){
            jsonObject.put("funcOutroCargo"+String.valueOf(percorre), oc.getId());
            percorre++;
        }
        percorre=0;
        
        for (Professor p: e.getProfessor()){
            jsonObject.put("professor"+String.valueOf(percorre), p.getId());
            percorre++;
        }
        percorre = 0;
        
        
        for (Turma t: e.getTurmas()){
            jsonObject.put("turma"+String.valueOf(percorre), t.getId());
            percorre++;
        }
        percorre = 0;
        
        
        for (Aluno a: e.getAlunos()){
            jsonObject.put("aluno"+String.valueOf(percorre), a.getId());
            percorre++;
        }
        percorre = 0;
        
      
        try{
            writeFile = new FileWriter("Arquivos/Escola" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException ex){
            ex.printStackTrace();
        }
    } 
    
    public void gerarJSONTurma(Turma t, int index){
        FileWriter writeFile = null;
        int percorre = 0;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", t.getId());
        jsonObject.put("turma", t.getTurma());
        jsonObject.put("letra", t.getLetra());
        jsonObject.put("periodo", t.getPeriodo());
        jsonObject.put("cronograma", t.getCronograma());
        jsonObject.put("vagas", t.getVagas());
        jsonObject.put("escola", t.getEscola().getId());
        
        for (Aluno a : t.getAlunos()){
            jsonObject.put("aluno"+String.valueOf(percorre), a.getId());
            percorre++;
        }
        percorre=0;
        
        try {
            jsonObject.put("profPebI", t.getProfPebI().getId());
        } catch (NullPointerException ex){
            jsonObject.put("profPebI", "");
        }
        
        
        for (ProfessorPebII p: t.getProfPebII()){
            jsonObject.put("profPebII"+String.valueOf(percorre), p.getId());
            percorre++;
        }
        percorre = 0;
        
        
        for (OutroCargo oc: t.getAdi()){
            jsonObject.put("adi"+String.valueOf(percorre), oc.getId());
            percorre++;
        }
        percorre = 0;
        
        try{
            writeFile = new FileWriter("Arquivos/Turma" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException ex){
            ex.printStackTrace();
        }
    } 
    
    public void gerarJSONNotasFaltas(NotasFaltas nf, int index){
        FileWriter writeFile = null;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", nf.getId());
        jsonObject.put("ano", nf.getAno());
        jsonObject.put("materia", nf.getMateria());
        jsonObject.put("nota1", nf.getNota1());
        jsonObject.put("nota2", nf.getNota2());
        jsonObject.put("nota3", nf.getNota3());
        jsonObject.put("nota4", nf.getNota4());
        jsonObject.put("faltas", nf.getFaltas());
        jsonObject.put("situacao", nf.getSituacao());
        
        try{
            writeFile = new FileWriter("Arquivos/NotasFaltas" + String.valueOf(index) + ".json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            //Imprimne na Tela o Objeto JSON para vizualização
        } catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void gerarJSONTelefone(Telefone t, int index){
        FileWriter writeFile = null;
        
        //Armazena dados em um Objeto JSON
        jsonObject.put("id", t.getId());
        jsonObject.put("numero", t.getNumero());
        
        try{
            writeFile = new FileWriter("Arquivos/Telefone" + String.valueOf(index) + ".json");
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
