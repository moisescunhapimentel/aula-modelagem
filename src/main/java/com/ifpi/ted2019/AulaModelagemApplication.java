package com.ifpi.ted2019;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifpi.ted2019.domain.Categoria;
import com.ifpi.ted2019.domain.Cidade;
import com.ifpi.ted2019.domain.Estado;
import com.ifpi.ted2019.domain.Produto;
import com.ifpi.ted2019.repositories.CategoriaRepository;
import com.ifpi.ted2019.repositories.CidadeRepository;
import com.ifpi.ted2019.repositories.EstadoRepository;
import com.ifpi.ted2019.repositories.ProdutoRepository;

@SpringBootApplication
public class AulaModelagemApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
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
		
		Estado estado1 = new Estado(null, "Piauí");
		Estado estado2 = new Estado(null, "Ceará");
		
		Cidade cidade1 = new Cidade(null, "Fortaleza", estado1);
		Cidade cidade2 = new Cidade(null, "Piripiri", estado2);
		Cidade cidade3 = new Cidade(null, "Parnaíba", estado2);

		estado1.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		estado2.getCidades().addAll(Arrays.asList(cidade1));

		categoriaRepository.saveAll(Arrays.asList(categoria, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
	}

}
