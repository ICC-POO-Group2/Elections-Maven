package spring.core.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.core.dao.IElectionsDao;
import spring.core.dao.entities.ElectionsException;
import spring.core.dao.ElectionsDaoFile;

@Configuration
@ComponentScan({ "elections.dao.entities" })
public class ConfigDao {
	// implémentation 1
	@Bean
	public IElectionsDao electionsDaoFile() throws ElectionsException, IOException {
		return new ElectionsDaoFile("elections-in-good.txt","elections-out.txt","elections-log.txt");
		
	}
	
	
}
