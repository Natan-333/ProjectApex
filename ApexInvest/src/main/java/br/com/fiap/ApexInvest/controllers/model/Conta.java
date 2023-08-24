package br.com.fiap.ApexInvest.controllers.model;

import java.util.Objects;

public class Conta {

    private long id;
    private long agencia;
    private long numero;
    private double saldo;
    private int senha;
    private String nome;
    private long cpf;
    private long telefone;
    private String email;
    private int idade;

    public Conta() {
    }

    public Conta(long id, long agencia, long numero, double saldo, int senha, String nome, long cpf, long telefone, String email, int idade) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

    public Conta setId(long id) {
        this.id = id;
        return this;
    }

    public long getAgencia() {
        return agencia;
    }

    public Conta setAgencia(long agencia) {
        this.agencia = agencia;
        return this;
    }

    public long getNumero() {
        return numero;
    }

    public Conta setNumero(long numero) {
        this.numero = numero;
        return this;
    }

    public double getSaldo() {
        return saldo;
    }

    public Conta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public int getSenha() {
        return senha;
    }

    public Conta setSenha(int senha) {
        this.senha = senha;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Conta setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public long getCpf() {
        return cpf;
    }

    public Conta setCpf(long cpf) {
        this.cpf = cpf;
        return this;
    }

    public long getTelefone() {
        return telefone;
    }

    public Conta setTelefone(long telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Conta setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getIdade() {
        return idade;
    }

    public Conta setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return getId() == conta.getId() && getAgencia() == conta.getAgencia() && getNumero() == conta.getNumero() && getSenha() == conta.getSenha() && getCpf() == conta.getCpf() && getTelefone() == conta.getTelefone() && getIdade() == conta.getIdade() && Objects.equals(getSaldo(), conta.getSaldo()) && Objects.equals(getNome(), conta.getNome()) && Objects.equals(getEmail(), conta.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAgencia(), getNumero(), getSaldo(), getSenha(), getNome(), getCpf(), getTelefone(), getEmail(), getIdade());
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", senha=" + senha +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
