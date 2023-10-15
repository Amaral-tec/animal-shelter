package br.com.amaral.animalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalServiceApplication.class, args);
	}

}

/** 
 * Requisitos funcionais:
 * 
 * API que permita o cadastro de animais que foram resgatados por um abrigo
 * 
 * Endpoints:
 * - Cadastro de animais
 * - Listagem de animais no abrigo que ainda não foram adotados, ordebados pela data de 
 * 	 entrada no abrigo
 * - Listagem de animais no abrigo que já foram adotados
 * 
 * Requisitos não funcionais:
 * 
 * Linguagem: Java
 * Rodar o serviço dentro de um container
 * DataBase a ser utilizada: H2
 * Autenticação e autorização: não
 * Larga escala: não
 * APIs precisam retornar o resultado no formato JSON
 * As APIs precisam ser no formato RESTful
 * 
 * Domínio:
 * 
 * - Animais
 * 
 */