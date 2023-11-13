package br.com.bikeinsure.teste;


import br.com.bikeinsure.model.Pessoa;
import br.com.bikeinsure.service.PessoaService;

public class TestePesquisaPessoaId {

	// Testar a busca por ID
	public static void main(String[] args) {
	    try {
	        PessoaService pessoaService = new PessoaService();

	        // Buscar pessoa por ID
	        Pessoa pessoaEncontrada = pessoaService.pesquisar(1323); 

	        // Exibir os detalhes da pessoa encontrada
	        System.out.println("Nome: " + pessoaEncontrada.getNome());
	        System.out.println("CPF: " + pessoaEncontrada.getCpf());
	        System.out.println("RG: " + pessoaEncontrada.getRg());
	        // ... outros detalhes

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	}
