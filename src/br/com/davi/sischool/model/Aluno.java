/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Davi
 */

@Entity
@DiscriminatorValue("Aluno")
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(cascade = {CascadeType.ALL})
    private int id;
    @Column
    private String ra;
    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name="turma_id")
    private Turma serie;
    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name="escola_id")
    private Escola escola;
    @Column
    private boolean necesEspec;
    @Column
    private boolean necesEspecAcomp;
    @Column
    private boolean transpPublicoEscolar;
    @Column
    private String nomePai;
    @Column
    private boolean paiResponsavel;
    @Column
    private String nomeMae;
    @Column
    private boolean maeResponsavel;
    @Column
    private boolean outroResponsavel;
    @Column
    private String nomeResponsavel;
    @Column
    private String parentescoResponsavel;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "notas_id")
    private List<NotasFaltas> notasFaltas; //pensar no historico */
    @Column
    private String comprovanteResidencia;
    @Column
    private String foto3x4;
    @Column
    private boolean aprovado;

    public Aluno() {
    }
    
    public String getRa() {
        return ra;
    }

    public void setRa(String rA) {
        this.ra = rA;
    }

    public Turma getSerie() {
        return serie;
    }

    public void setSerie(Turma serie) {
        this.serie = serie;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public boolean isNecesEspec() {
        return necesEspec;
    }

    public void setNecesEspec(boolean necesEspec) {
        this.necesEspec = necesEspec;
    }

    public boolean isNecesEspecAcomp() {
        return necesEspecAcomp;
    }

    public void setNecesEspecAcomp(boolean necesEspecAcomp) {
        this.necesEspecAcomp = necesEspecAcomp;
    }

    public boolean isTranspPublicoEscolar() {
        return transpPublicoEscolar;
    }

    public void setTranspPublicoEscolar(boolean transpPublicoEscolar) {
        this.transpPublicoEscolar = transpPublicoEscolar;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public boolean isPaiResponsavel() {
        return paiResponsavel;
    }

    public void setPaiResponsavel(boolean paiResponsavel) {
        this.paiResponsavel = paiResponsavel;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public boolean isMaeResponsavel() {
        return maeResponsavel;
    }

    public void setMaeResponsavel(boolean maeResponsavel) {
        this.maeResponsavel = maeResponsavel;
    }

    public boolean isOutroResponsavel() {
        return outroResponsavel;
    }

    public void setOutroResponsavel(boolean outroResponsavel) {
        this.outroResponsavel = outroResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getParentescoResponsavel() {
        return parentescoResponsavel;
    }

    public void setParentescoResponsavel(String parentescoResponsavel) {
        this.parentescoResponsavel = parentescoResponsavel;
    }

    public List<NotasFaltas> getNotasFaltas() {
        return notasFaltas;
    }

    public void setNotasFaltas(List<NotasFaltas> notasFaltas) {
        this.notasFaltas = notasFaltas;
    }

    public String getComprovanteResidencia() {
        return comprovanteResidencia;
    }

    public void setComprovanteResidencia(String comprovanteResidencia) {
        this.comprovanteResidencia = comprovanteResidencia;
    }

    public String getFoto3x4() {
        return foto3x4;
    }

    public void setFoto3x4(String foto3x4) {
        this.foto3x4 = foto3x4;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
}
