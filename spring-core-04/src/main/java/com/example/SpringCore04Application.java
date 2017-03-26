package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
/** Classe d'exemple !**/
@SpringBootApplication
public class SpringCore04Application {

	public static void main(String[] args) {
		// instanciation du contexte Spring
		ConfigurableApplicationContext context = SpringApplication.run(SpringCore04Application.class, args);
		// affichage du contexte
		System.out.println("---------------- Liste des beans Spring");
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		// fermeture contexte
		context.close();
	}
}
