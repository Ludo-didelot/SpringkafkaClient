package com.ldt;

import com.ldt.repository.HumanRepository;
import org.neo4j.ogm.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
@EnableNeo4jRepositories("com.ldt.repository")
public class SpringkafkaClient {
    @Autowired
    HumanRepository repo;


	public static void main(String[] args) {

		SpringApplication.run(SpringkafkaClient.class, args);

	}

	@PostConstruct
	public void createDataStarWar() {
		System.out.println(repo.findByNameLike("Princess"));
        System.out.println(repo.findAll());
		System.out.println(repo.graph(10));
	}
}
