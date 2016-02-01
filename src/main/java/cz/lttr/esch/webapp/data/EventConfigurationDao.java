package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import cz.lttr.esch.webapp.model.EventConfiguration;

/**
 * DAO for EventConfiguration
 */
@Stateless
public class EventConfigurationDao {
	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(EventConfiguration entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		EventConfiguration entity = em.find(EventConfiguration.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public EventConfiguration findById(int id) {
		return em.find(EventConfiguration.class, id);
	}

	public EventConfiguration update(EventConfiguration entity) {
		return em.merge(entity);
	}

	public List<EventConfiguration> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<EventConfiguration> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM EventConfiguration e LEFT JOIN FETCH e.event ORDER BY e.id",
						EventConfiguration.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
