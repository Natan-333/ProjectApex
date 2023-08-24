package br.com.fiap.ApexInvest.controllers.model;

public class Servicos {

    public static void tranferencia(Conta origem, Conta destino, double valorTransferencia){
        if (origem.getSaldo() >= valorTransferencia) {
            origem.setSaldo(origem.getSaldo() - valorTransferencia);
            destino.setSaldo(destino.getSaldo() + valorTransferencia);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

}
