package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.lttr.esch.webapp.model.ProgramBlock;

@Stateless
public class ProgramBlockDao {

	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(ProgramBlock entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		ProgramBlock entity = em.find(ProgramBlock.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ProgramBlock findById(int id) {
		return em.find(ProgramBlock.class, id);
	}

	public ProgramBlock update(ProgramBlock entity) {
		return em.merge(entity);
	}

	public List<ProgramBlock> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ProgramBlock> findAllQuery = em.createQuery("SELECT p FROM ProgramBlock p",
				ProgramBlock.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
