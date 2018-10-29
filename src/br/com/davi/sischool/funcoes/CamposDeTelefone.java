/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import br.com.davi.sischool.model.Telefone;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Davi
 */
public class CamposDeTelefone {

    public CamposDeTelefone() {
    }
    
    /*
    * Recebe uma lista de Telefones e exibe em uma JList.
    */
    public void exibeTelefonesNoJList(JList<Telefone> list, List<Telefone> telef){
        DefaultListModel model = new DefaultListModel();
        list.setModel(model);
        if (!telef.isEmpty()){
            for (int i=0; i<telef.size(); i++) {
                model.add(i, telef.get(i));
            }
        }
    }
    
    /*
    * Adiciona um telefone digitado a uma lista de telefones.
    */
    public void colocaTelefoneNaLista(List<Telefone> telef, JTextField txtTelef){
        Telefone t = new Telefone();
        if (!txtTelef.getText().trim().equals("")){
            t.setNumero(txtTelef.getText());
            telef.add(t);
            txtTelef.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Você não preencheu o campo telefone."); //trocar isso aqui por um hint
        }
    }
    
    /*
    * Remove um telefone selecionado em uma JList de uma lista de telefones.
    */
    public void excluiTelefoneDaLista(JList<Telefone> list, List<Telefone> telef){
        int selecionado = list.getSelectedIndex();
        telef.remove(selecionado);
    }
    
}
