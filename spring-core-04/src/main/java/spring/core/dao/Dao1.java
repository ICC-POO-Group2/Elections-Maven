package spring.core.dao;

public class Dao1 implements IDao {

	@Override
	public int doSomethingInDaoLayer(int a, int b) {
			
		return a+b;
	}

}
