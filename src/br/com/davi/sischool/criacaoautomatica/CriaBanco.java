/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.criacaoautomatica;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Davi
 */
public class CriaBanco {
    private conexao conecta;
    private PreparedStatement pst;
    private Statement st;
    
    
    public static void main(String[] args) {
       ActionBD act = new ActionBD();
       act.createDB("sischoolbd");
    }
}
