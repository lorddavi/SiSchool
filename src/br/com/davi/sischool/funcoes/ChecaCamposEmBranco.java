/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Davi
 */
public class ChecaCamposEmBranco {

    public ChecaCamposEmBranco() {
    }
    
    public boolean checaNaoPreenchido(JTextField txtf, JTabbedPane tpane, int index) {
        if (txtf.getText().trim().equals("")){
            tpane.setSelectedIndex(index);
            txtf.requestFocus();
            return false;
        }
        return true;
    }
}
