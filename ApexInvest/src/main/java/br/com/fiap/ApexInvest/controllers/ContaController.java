package br.com.fiap.ApexInvest.controllers;

import br.com.fiap.ApexInvest.model.Conta;

import br.com.fiap.ApexInvest.model.Servicos;
import br.com.fiap.ApexInvest.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    @GetMapping("/login")
    public Conta login(@RequestBody Map<String, Object> requestBody) {

        long cpf = (long) requestBody.get("cpf");
        int senha = (int) requestBody.get("senha");

        List<Conta> optionalConta = contaRepository.findAll();
        Conta contaLogged = null;

        for (Conta conta : optionalConta) {
            if (conta.getCpf() == cpf && conta.getSenha() == senha) {
                System.out.println("Login realizado com sucesso: " + conta.toString());
                contaLogged = conta;
                break;
            }
        }
        return contaLogged;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Conta> findContaById(@PathVariable long id) {

        Optional<Conta> byId = contaRepository.findById(id);

        if (byId.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(byId.get());

    }

    @GetMapping("/listar-todas")
    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    @PostMapping("/cadastro")
    public Conta cadastrarConta(@RequestBody Conta novaContaRequest) {

        System.out.println("Cadastrando CONTA - " + novaContaRequest.toString());

        contaRepository.save(novaContaRequest);

        return novaContaRequest;
    }

    @PutMapping("/transferencia")
    public ResponseEntity<Conta> transferencia(@RequestBody Map<String, Object> requestBody) {

        long cpf = (long) requestBody.get("cpf");
        int senha = (int) requestBody.get("senha");
        String email = (String) requestBody.get("email");
        double valorTranf = (double) requestBody.get("valorTranf");

        List<Conta> optionalConta = contaRepository.findAll();
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta conta : optionalConta) {
            if (conta.getCpf() == cpf && conta.getSenha() == senha) {
                contaOrigem = conta;
                break;
            }
        }
        for (Conta conta : optionalConta) {
            if (conta.getEmail().equals(email)) {
                contaDestino = conta;
                break;
            }
        }

        if (Servicos.tranferencia(contaOrigem, contaDestino, valorTranf)) {
            contaRepository.save(contaOrigem);
            contaRepository.save(contaDestino);

            return ResponseEntity.ok(contaOrigem);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Object> deleteConta(@RequestBody Map<String, Object> requestBody) {

        long cpf = (long) requestBody.get("cpf");
        int senha = (int) requestBody.get("senha");

        List<Conta> optionalConta = contaRepository.findAll();

        for (Conta conta : optionalConta) {
            if (conta.getCpf() == cpf && conta.getSenha() == senha) {
                contaRepository.delete(conta);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}





