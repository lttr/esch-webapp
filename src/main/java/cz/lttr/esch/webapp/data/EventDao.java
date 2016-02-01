package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.lttr.esch.webapp.model.Event;

@Stateless
public class EventDao {

	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(Event entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Event entity = em.find(Event.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Event findById(Integer id) {
		return em.find(Event.class, id);
	}

	public Event update(Event entity) {
		return em.merge(entity);
	}

	public List<Event> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Event> findAllQuery = em.createQuery(
				"SELECT DISTINCT e FROM Event e JOIN FETCH e.eventConfiguration", Event.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
