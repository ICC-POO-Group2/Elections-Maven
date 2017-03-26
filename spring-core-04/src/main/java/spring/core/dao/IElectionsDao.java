package spring.core.dao;

import spring.core.dao.entities.ListeElectorale;

public interface IElectionsDao {
	public double getSeuilElectoral();
	public int getNbSiegesAPourvoir();
	public ListeElectorale[] getListesElectorales();
	public void setListesElectorales(ListeElectorale[] listesElectorales);
	public String getInFileName();
	public String getOutFileName();
}
