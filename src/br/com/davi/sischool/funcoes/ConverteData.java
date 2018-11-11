/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Davi
 */
public class ConverteData {

    public ConverteData() {
    }
    
    /*
    * Recebe uma data de um JFormattedTextField e converte para o formato de data 
    * do tipo Date.
    */
    public Date converteDataParaUtilDate(JFormattedTextField ftxt){
        SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy" );
        formato.setLenient(false);
        Date data = null;
        try {
            data = formato.parse(ftxt.getText());
            return data;
        } catch (Exception e) {
            System.out.println("Data inválida: " + e.getMessage());
        }
        return data;
    }
    
    public String converteDateParaString(Date data){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        df.setLenient(false);
        String dataConvertida = df.format(data);
        return dataConvertida;
    }
    
    public int calculaIdade(Date dataNasc) {
        Calendar dataNascimento = Calendar.getInstance();  
        dataNascimento.setTime(dataNasc); 
        Calendar hoje = Calendar.getInstance();  

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
          idade--;  
        } else { 
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--; 
            }
        }

        return idade;
    }
}
