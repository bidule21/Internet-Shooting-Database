package net.vl0w.isd;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = { "net.vl0w.isd" })
public class AppConfiguration {

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "app22656478");
	}

	@Bean
	public Mongo mongo() throws Exception {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://mr-crabs:isd@troup.mongohq.com:10026/app22656478");
		return new MongoClient(uri);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		return new TomcatEmbeddedServletContainerFactory(80);
	}
}
