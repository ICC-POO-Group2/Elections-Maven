package spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.core.dao.ElectionsDaoFile;
import spring.core.dao.IElectionsDao;

@Configuration
@ComponentScan({ "spring.core.entities" })
public class ConfigDao {
	
	@Bean
	public IElectionsDao ElectionsDaoFile(){
		return new ElectionsDaoFile("data\\elections-in-good.txt", "data\\elections-out.txt", "data\\elections-log.txt");
	}
	
}
