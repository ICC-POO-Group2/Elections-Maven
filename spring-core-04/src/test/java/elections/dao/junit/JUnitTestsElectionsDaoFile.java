package elections.dao.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import junit.framework.TestCase;
import spring.core.config.ConfigDao;
import spring.core.dao.ElectionsDaoFile;
import spring.core.dao.IElectionsDao;


public class JUnitTestsElectionsDaoFile extends TestCase{
	@Autowired
	@Qualifier("daoFile")
	private ElectionsDaoFile daoFile;
	
	@Test
	public void testElectionsDao(){
		
	}
}
