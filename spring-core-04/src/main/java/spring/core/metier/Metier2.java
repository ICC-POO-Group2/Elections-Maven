package spring.core.metier;

import spring.core.dao.IDao;

public class Metier2 implements IMetier {

	private IDao dao;
	
	@Override
	public int doSomethingInMetierLayer(int a, int b) {
		a--;
		b++;
		return dao.doSomethingInDaoLayer(a, b);
	 }
	
	 public void setDao(IDao dao) {
		 this.dao = dao;
	 }

}
