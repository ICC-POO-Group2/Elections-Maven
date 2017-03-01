package spring.core.ui;

import spring.core.metier.IMetier;

public class Ui2 implements IUi {

	private IMetier metier;
	
	public int doSomethingInUiLayer(int a, int b) {
			a--;
			b++;
			return metier.doSomethingInMetierLayer(a, b);
	}
		
	public void setMetier(IMetier metier) {
			this.metier = metier;
	}

}
