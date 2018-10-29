/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.regras;

import br.com.davi.sischool.model.Funcionario;
import br.com.davi.sischool.model.Login;
import javax.persistence.EntityManager;

/**
 *
 * @author Davi
 */
public class LoginDAO {
    CriaEntityManager cem;
    EntityManager em;
    Funcionario f;
    FuncionarioDAO fdao = new FuncionarioDAO();
    
    public LoginDAO(){
        cem = new CriaEntityManager();
        em = cem.criarEM();
    }
    
    public String confereSenha(String login, String senha){
        String confere = "confere";
        String senhaN = "senhaN";
        String loginN = "loginN";
        if (fdao.buscarPorLogin(login) != null){
            f = fdao.buscarPorLogin(login);
            if (f.getUsrName().equals(login) && f.getSenha().equals(senha)){
                return confere;
            } else {
                return senhaN;
            }
        } else {
            return loginN;
        }
    }
    
    public Login usrLogado(){
        Login login = new Login();
        login.setFunc(f);
        
        return login;
    }
}
