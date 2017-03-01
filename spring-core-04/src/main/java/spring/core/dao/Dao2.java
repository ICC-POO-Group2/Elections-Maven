package spring.core.dao;

public class Dao2 implements IDao {

	@Override
	public int doSomethingInDaoLayer(int a, int b) {
		return a-b;
	}

}
