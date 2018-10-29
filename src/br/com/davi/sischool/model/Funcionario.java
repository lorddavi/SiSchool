/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Davi
 */

@Entity
@DiscriminatorValue("funcionario")
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String cpf;
    @Column
    private String matricula;
    @Column
    private String cargo;
    @Column
    private boolean possuiDeficiencia;
    @Column
    private int acesso;
    @Column
    private String usrName;
    @Column
    private String senha;
    //private List<Escola> escolasHistorico; //talvez seja preciso criar variavel Funcionario na tabela escola com relação manytomany

    public Funcionario() {
    }

    /*public List<Escola> getEscolasHistorico() {
        return escolasHistorico;
    }

    public void setEscolasHistorico(List<Escola> escolasHistorico) {
        this.escolasHistorico = escolasHistorico;
    }*/

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isPossuiDeficiencia() {
        return possuiDeficiencia;
    }

    public void setPossuiDeficiencia(boolean possuiDeficiencia) {
        this.possuiDeficiencia = possuiDeficiencia;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    public ProfessorPebI toPebI(ProfessorPebI p){
        p.setId(this.getId());
        p.setNome(this.getNome());
        p.setDataNasc(this.getDataNasc());
        p.setGenero(this.getGenero());
        p.setEndereco(this.getEndereco());
        p.setBairro(this.getBairro());
        p.setCidade(this.getCidade());
        p.setCep(this.getCep());
        p.setTelefones(this.getTelefones());
        p.setObservacoes(this.getObservacoes());
        p.setCpf(this.getCpf());
        p.setMatricula(this.getMatricula());
        p.setCargo(this.getCargo());
        p.setPossuiDeficiencia(this.isPossuiDeficiencia());
        p.setAcesso(this.getAcesso());
        p.setUsrName(this.getUsrName());
        p.setSenha(this.getSenha());
        
        return p;
    }
    
    public ProfessorPebII toPebII(ProfessorPebII p){
        p.setId(this.getId());
        p.setNome(this.getNome());
        p.setDataNasc(this.getDataNasc());
        p.setGenero(this.getGenero());
        p.setEndereco(this.getEndereco());
        p.setBairro(this.getBairro());
        p.setCidade(this.getCidade());
        p.setCep(this.getCep());
        p.setTelefones(this.getTelefones());
        p.setObservacoes(this.getObservacoes());
        p.setCpf(this.getCpf());
        p.setMatricula(this.getMatricula());
        p.setCargo(this.getCargo());
        p.setPossuiDeficiencia(this.isPossuiDeficiencia());
        p.setAcesso(this.getAcesso());
        p.setUsrName(this.getUsrName());
        p.setSenha(this.getSenha());
        
        return p;
    }
}
