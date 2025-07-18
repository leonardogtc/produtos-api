package br.com.leonardogtc.productapi.repository;

import br.com.leonardogtc.productapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    // Este repositório herda métodos CRUD do JpaRepository
    // Não é necessário implementar nada aqui, o Spring Data JPA faz isso automaticamente

    List<Produto> findByNome(String nome);
}
