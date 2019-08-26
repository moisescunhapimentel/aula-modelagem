package com.ifpi.ted2019;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifpi.ted2019.domain.Categoria;
import com.ifpi.ted2019.domain.Produto;
import com.ifpi.ted2019.repositories.CategoriaRepository;
import com.ifpi.ted2019.repositories.ProdutoRepository;

@SpringBootApplication
public class AulaModelagemApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AulaModelagemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria categoria = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.0);
		Produto produto2 = new Produto(null, "Impressora", 8000.0);
		Produto produto3 = new Produto(null, "Mouse", 80.0);

		categoria.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria));
		produto2.getCategorias().addAll(Arrays.asList(categoria, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria));
		
		categoriaRepository.saveAll(Arrays.asList(categoria, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
	}

}
