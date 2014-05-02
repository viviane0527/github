package data.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import data.persistence.MomokoDatabase;

public class PersistenceContextProducer {
	@Produces
	@PersistenceContext(unitName="com.thales.momokoPU")
	@MomokoDatabase
	public EntityManager momokoEntityManager;
}

