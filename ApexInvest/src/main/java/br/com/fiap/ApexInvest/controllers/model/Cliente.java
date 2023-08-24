package br.com.fiap.ApexInvest.controllers.model;

import java.util.Objects;

public class Cliente {

    private long id;
    private String nome;
    private long cpf;
    private long telefone;
    private String email;
    private int idade;
    private Conta conta;

    public Cliente() {
    }

    public Cliente(long id, String nome, long cpf, long telefone, String email, int idade, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
        this.conta = conta;
    }

    public long getId() {
        return id;
    }

    public Cliente setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public long getCpf() {
        return cpf;
    }

    public Cliente setCpf(long cpf) {
        this.cpf = cpf;
        return this;
    }

    public long getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(long telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getIdade() {
        return idade;
    }

    public Cliente setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public Cliente setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getId() == cliente.getId() && getCpf() == cliente.getCpf() && getTelefone() == cliente.getTelefone() && getIdade() == cliente.getIdade() && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getEmail(), cliente.getEmail()) && Objects.equals(getConta(), cliente.getConta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getTelefone(), getEmail(), getIdade(), getConta());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", conta=" + conta +
                '}';
    }
}
