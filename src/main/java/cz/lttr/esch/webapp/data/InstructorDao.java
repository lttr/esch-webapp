package cz.lttr.esch.webapp.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cz.lttr.esch.webapp.model.Instructor;

@Stateless
public class InstructorDao {

	@PersistenceContext(unitName = "esch-webapp-mysql-persistence")
	private EntityManager em;

	public void create(Instructor entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		Instructor entity = em.find(Instructor.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Instructor findById(int id) {
		return em.find(Instructor.class, id);
	}

	public Instructor update(Instructor entity) {
		return em.merge(entity);
	}

	public List<Instructor> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Instructor> findAllQuery = em.createQuery(
				"SELECT i FROM Instructor i",
				Instructor.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
