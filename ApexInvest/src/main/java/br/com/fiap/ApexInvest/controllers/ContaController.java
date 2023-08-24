package br.com.fiap.ApexInvest.controllers;

import br.com.fiap.ApexInvest.controllers.model.Conta;
import br.com.fiap.ApexInvest.controllers.model.Servicos;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @GetMapping("/{cpf}/{senha}")
    public Conta login(@PathVariable long cpf, @PathVariable int senha) {
        if ((cpf == 12345678900L) && (senha == 1234)) {
            Conta conta = new Conta(1, 123, 456789, 1500.75, 1234, "João Silva", 12345678900L, 987654321L, "joao@example.com", 30);
            return conta;
        } else {
            return null;
        }
    }

    @PostMapping
    public Conta cadastrarConta(@RequestBody Conta novaConta) {
        System.out.println(novaConta.toString());
        return novaConta;
    }

    @PutMapping("/Transf/{cpf}/{senha}/{email}/{valorTranf}")
    public Conta tranferencia(@PathVariable long cpf, @PathVariable int senha, @PathVariable String email, @PathVariable double valorTranf) {

        if ((cpf == 12345678900L) && (senha == 1234) && (email.equals("maria@example.com"))) {
            Conta contaOrigem = new Conta(1, 123, 456789, 1500.75, 1234, "João Silva", 12345678900L, 987654321L, "joao@example.com", 30);
            Conta contaDestino = new Conta(
                    2,
                    456,
                    987654,
                    2000.50,
                    5678,
                    "Maria Souza",
                    98765432100L,
                    123456789L,
                    "maria@example.com",
                    28
            );
            System.out.println(contaOrigem+" - Antes");
            Servicos.tranferencia(contaOrigem, contaDestino, valorTranf);
            System.out.println(contaOrigem+" - Depois");
            return contaOrigem;
        } else {
            return null;
        }

    }

}
