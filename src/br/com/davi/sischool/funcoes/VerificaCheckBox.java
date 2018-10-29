/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

/**
 *
 * @author Davi
 */
public class VerificaCheckBox {

    public VerificaCheckBox() {
    }
    
    /*
    * Recebe um JCheckBox como parâmetro e retorna se seu estado é verdadeiro ou falso.
    */
    public boolean checaVerdadeiroFalso(JCheckBox check){
        return check.isSelected();
    }
    
    public boolean checaVerdadeiroFalso(JRadioButton radio){
        return radio.isSelected();
    }
    
    public String checaGenero(JRadioButton radio){
        if (radio.isSelected()){
            return "Masculino";
        } else {
            return "Feminino";
        }
    }
}
