package data.persistence;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import data.model.enterprise.Enterprise;
import data.annotations.Facade;
import data.annotations.FeatureType;


@Facade(FeatureType.Enterprise)
@Stateless
public class EnterpriseFacade extends AbstractFacade<Enterprise> implements Serializable
{
	//@Inject @MomokoDatabase
	// change with your persistence unit name here:
	@PersistenceContext(unitName="com.thales.momokoPU")
	private EntityManager em;
    
	@Override
	protected EntityManager getEntityManager() 
	{
    	return em;
	}

	public EnterpriseFacade() 
	{
    	super(Enterprise.class);
	}
}
