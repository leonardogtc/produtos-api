package br.com.leonardogtc.productapi.controller;

import br.com.leonardogtc.productapi.model.Produto;
import br.com.leonardogtc.productapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        var id = UUID.randomUUID().toString(); // Universal Unique Identifier (UUID) para gerar um ID único
        produto.setId(id); // Gera um ID único para o produto
        produtoRepository.save(produto); // O Spring Data JPA cuida de salvar o produto no banco de dados
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null); // Busca o produto pelo ID
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") String id) {
        produtoRepository.deleteById(id); // Deleta o produto pelo ID
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id); // Define o ID do produto a ser atualizado
        produtoRepository.save(produto); // Atualiza o produto no banco de dados
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome); // Busca produtos pelo nome
    }

}
