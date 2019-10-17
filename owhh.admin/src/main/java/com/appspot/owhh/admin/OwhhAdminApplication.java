package com.appspot.owhh.admin;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class OwhhAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwhhAdminApplication.class, args);
	}

	@Bean
	public GridFSBucket getGridFSBuckets(MongoDbFactory mongoDbFactory) {
		return GridFSBuckets.create(mongoDbFactory.getDb());
	}

}
