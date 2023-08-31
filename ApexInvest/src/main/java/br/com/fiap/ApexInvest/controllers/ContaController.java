package br.com.fiap.ApexInvest.controllers;

import br.com.fiap.ApexInvest.controllers.model.Conta;
import br.com.fiap.ApexInvest.controllers.model.Servicos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private List<Servicos> servicosList = new ArrayList<>();

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
    public Conta transferencia(@PathVariable long cpf, @PathVariable int senha, @PathVariable String email, @PathVariable double valorTranf) {
        if ((cpf == 12345678900L) && (senha == 1234) && (email.equals("maria@example.com"))) {
            Conta contaOrigem = new Conta(1, 123, 456789, 1500.75, 1234, "João Silva", 12345678900L, 987654321L, "joao@example.com", 30);

            System.out.println(contaOrigem + " - Antes");
            System.out.println(contaOrigem + " - Depois");
            return contaOrigem;
        } else {
            return null;
        }
    }

    @DeleteMapping("/Servicos/{agencia}/{conta}")
    public ResponseEntity<Object> destroyServico(@PathVariable String agencia, @PathVariable String conta) {
        Servicos servicosEncontrados = null;
        for (Servicos servicos : servicosList) {
            if (servicos.getAgencia().equals(agencia) && servicos.getConta().equals(conta)) {
                servicosEncontrados = servicos;
                break;
            }
        }

        if (servicosEncontrados == null) {
            return ResponseEntity.notFound().build();
        }

        servicosList.remove(servicosEncontrados);
        return ResponseEntity.noContent().build();
    }
}





