package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.lttr.esch.webapp.model.ProgramCategory;

@Stateless
public class ProgramCategoryDao {

	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(ProgramCategory entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		ProgramCategory entity = em.find(ProgramCategory.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ProgramCategory findById(int id) {
		return em.find(ProgramCategory.class, id);
	}

	public ProgramCategory update(ProgramCategory entity) {
		return em.merge(entity);
	}

	public List<ProgramCategory> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<ProgramCategory> findAllQuery = em
				.createQuery(
						"SELECT p FROM ProgramCategory p",
						ProgramCategory.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
