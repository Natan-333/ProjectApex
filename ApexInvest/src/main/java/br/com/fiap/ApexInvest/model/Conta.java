package br.com.fiap.ApexInvest.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_CONTA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CONTA_NUMERO", columnNames = "CONTA_NUMERO"),
        @UniqueConstraint(name = "UK_CONTA_CPF", columnNames = "CONTA_CPF"),
        @UniqueConstraint(name = "UK_CONTA_EMAIL", columnNames = "CONTA_EMAIL")
})
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTA")
    @SequenceGenerator( name = "SQ_CONTA", sequenceName = "SQ_CONTA")
    @Column(name = "ID_CONTA")
    private long id;

    @Column(name = "CONTA_AGENCIA", nullable = false)
    private long agencia;

    @Column(name = "CONTA_NUMERO", nullable = false, unique = true)
    private long numero;

    @Column(name = "CONTA_SALDO", nullable = false)
    private double saldo;

    @Column(name = "CONTA_SENHA", nullable = false)
    private int senha;

    @Column(name = "CONTA_NOME", nullable = false)
    private String nome;

    @Column(name = "CONTA_CPF", nullable = false, unique = true)
    private long cpf;

    @Column(name = "CONTA_TELEFONE", nullable = false)
    private long telefone;

    @Column(name = "CONTA_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "CONTA_IDADE", nullable = false)
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
