package spring.core.tests;

import org.junit.Assert;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.boot.test.SpringApplicationConfiguration;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 import spring.core.config.Config;
 import spring.core.dao.IDao;
 import spring.core.metier.IMetier;
 import spring.core.ui.IUi;

 
@SpringApplicationConfiguration(classes = { Config.class })
 @RunWith(SpringJUnit4ClassRunner.class)
 public class JUnitTest {
	  // couche [UI]
	  @Autowired
	  @Qualifier("ui1")
	  private IUi ui1;
	 
	  @Autowired
	  @Qualifier("ui2")
	  private IUi ui2;
	 
	  // couche [métier]
	  @Autowired
	  @Qualifier("metier1")
	  private IMetier metier1;
	 
	  @Autowired
	  @Qualifier("metier2")
	  private IMetier metier2;
	 
	  // couche [dao]
	  @Autowired
	  @Qualifier("dao1")
	  private IDao dao1;
	 
	  @Autowired
	  @Qualifier("dao2")
	  private IDao dao2;
	 
	  @Test
	  public void testDao() {
	  Assert.assertEquals(30, dao1.doSomethingInDaoLayer(10, 20));
	  Assert.assertEquals(-10, dao2.doSomethingInDaoLayer(10, 20));
	  }
	 
	  @Test
	  public void testMetier() {
	  Assert.assertEquals(32, metier1.doSomethingInMetierLayer(10, 20));
	  Assert.assertEquals(-12, metier2.doSomethingInMetierLayer(10, 20));
	  }
	 
	  @Test
	  public void testUI() {
	  Assert.assertEquals(34, ui1.doSomethingInUiLayer(10, 20));
	  Assert.assertEquals(-14, ui2.doSomethingInUiLayer(10, 20));
	  }

}