package com.example.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableSolrRepositories(basePackages = "com.example.spring.api.repository")
public class SpringDataSolrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataSolrApplication.class, args);
	}

}
