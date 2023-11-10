package com.example.bibliotecaMongo.service;

import com.example.bibliotecaMongo.model.Livro;
import com.example.bibliotecaMongo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public List<Livro> findByAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }

    public List<Livro> findByGenero(String genero) {
        return livroRepository.findByGenero(genero);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void delete(String id) {
        livroRepository.deleteById(id);
    }
}