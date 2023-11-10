package com.example.bibliotecaMongo.controller;

import com.example.bibliotecaMongo.model.Livro;
import com.example.bibliotecaMongo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/autor/{autor}")
    public List<Livro> getLivrosByAutor(@PathVariable String autor) {
        return livroService.findByAutor(autor);
    }

    @GetMapping("/genero/{genero}")
    public List<Livro> getLivrosByGenero(@PathVariable String genero) {
        return livroService.findByGenero(genero);
    }

    @PostMapping
    public Livro addLivro(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable String id) {
        livroService.delete(id);
    }
}