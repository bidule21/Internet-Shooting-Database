package net.vl0w.isd.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories(basePackages = { "net.vl0w.isd" })
public class MongoIntegrationTestingConfiguration extends
		AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "testing";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo("mongo-integration-testing").getMongo();
	}
}
