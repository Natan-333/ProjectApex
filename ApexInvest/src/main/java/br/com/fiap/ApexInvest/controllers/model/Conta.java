package br.com.fiap.ApexInvest.controllers.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {

    private long agencia;
    private long numero;
    private BigDecimal saldo;
    private int senha;

    public Conta() {
    }

    public Conta(long agencia, long numero, BigDecimal saldo, int senha) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.senha = senha;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Conta setSaldo(BigDecimal saldo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return getAgencia() == conta.getAgencia() && getNumero() == conta.getNumero() && getSenha() == conta.getSenha() && Objects.equals(getSaldo(), conta.getSaldo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAgencia(), getNumero(), getSaldo(), getSenha());
    }


    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", senha=" + senha +
                '}';
    }
}
