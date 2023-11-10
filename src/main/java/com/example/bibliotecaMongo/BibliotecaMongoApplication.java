package com.example.bibliotecaMongo;

import com.example.bibliotecaMongo.model.Livro;
import com.example.bibliotecaMongo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class BibliotecaMongoApplication {

	@Autowired
	private LivroService livroService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaMongoApplication.class, args);
	}

	@PostConstruct
	public void run() {
		// Adiciona um livro
		Livro livro = new Livro();
		livro.setTitulo("A Test Book");
		livro.setAutor("Test Author");
		livro.setAnoPublicacao(2022);
		livro.setGenero("Test Genre");

		Livro savedLivro = livroService.save(livro);
		System.out.println("Livro adicionado: " + savedLivro);

		// Obtém todos os livros
		List<Livro> allLivros = livroService.findAll();
		System.out.println("Todos os livros: " + allLivros);

		// Obtém livros por autor
		List<Livro> livrosByAutor = livroService.findByAutor("Test Author");
		System.out.println("Livros por autor: " + livrosByAutor);

		// Obtém livros por gênero
		List<Livro> livrosByGenero = livroService.findByGenero("Test Genre");
		System.out.println("Livros por gênero: " + livrosByGenero);

		// Atualiza o ano de publicação de um livro
		if (!allLivros.isEmpty()) {
			Livro livroToUpdate = allLivros.get(0);
			livroToUpdate.setAnoPublicacao(2023);
			Livro updatedLivro = livroService.save(livroToUpdate);
			System.out.println("Livro atualizado: " + updatedLivro);
		}

		// Deleta um livro
		if (!allLivros.isEmpty()) {
			Livro livroToDelete = allLivros.get(0);
			livroService.delete(livroToDelete.getId());
			System.out.println("Livro deletado: " + livroToDelete);
		}

		// Obtém todos os livros após a exclusão
		List<Livro> remainingLivros = livroService.findAll();
		System.out.println("Livros restantes: " + remainingLivros);
	}
}