package com.bancodesangue.doarsangue.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doador")
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private int idade;
    private String peso;
    private String tiposanguineo;
    private String localdoacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getTiposanguineo() {
        return tiposanguineo;
    }
    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }
    public String getLocaldoacao() {
        return localdoacao;
    }
    public void setLocaldoacao(String localdoacao) {
        this.localdoacao = localdoacao;
    }
}
