package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import cz.lttr.esch.webapp.model.EschUser;

/**
 * DAO for EschUser
 */
@Stateless
public class EschUserDao {
	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(EschUser entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		EschUser entity = em.find(EschUser.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public EschUser findById(int id) {
		return em.find(EschUser.class, id);
	}

	public EschUser update(EschUser entity) {
		return em.merge(entity);
	}

	public List<EschUser> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<EschUser> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM EschUser e LEFT JOIN FETCH e.instructor LEFT JOIN FETCH e.events ORDER BY e.id",
						EschUser.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
