package com.example.bibliotecaMongo.repository;

import com.example.bibliotecaMongo.model.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LivroRepository extends MongoRepository<Livro, String> {

    List<Livro> findByAutor(String autor);

    List<Livro> findByGenero(String genero);
}