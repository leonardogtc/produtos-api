package br.com.leonardogtc.productapi.controller;

import br.com.leonardogtc.productapi.model.Produto;
import br.com.leonardogtc.productapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto salvo: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id); // Gera um ID único para o produto
        // O Spring Data JPA cuida de salvar o produto no banco de dados
        produtoRepository.save(produto);
        return produto;
    }
}
