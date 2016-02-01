package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import cz.lttr.esch.webapp.model.ProgramDay;

/**
 * DAO for ProgramDay
 */
@Stateless
public class ProgramDayDao {
	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(ProgramDay entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		ProgramDay entity = em.find(ProgramDay.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ProgramDay findById(int id) {
		return em.find(ProgramDay.class, id);
	}

	public ProgramDay update(ProgramDay entity) {
		return em.merge(entity);
	}

	public List<ProgramDay> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ProgramDay> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM ProgramDay p LEFT JOIN FETCH p.event LEFT JOIN FETCH p.programBlocks ORDER BY p.id",
						ProgramDay.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
