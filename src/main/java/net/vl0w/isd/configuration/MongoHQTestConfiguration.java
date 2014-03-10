package net.vl0w.isd.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = { "net.vl0w.isd" })
public class MongoHQTestConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "app22656478";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://mr-crabs:isd@troup.mongohq.com:10026/app22656478");
		return new MongoClient(uri);
	}
}
