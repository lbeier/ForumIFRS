package Model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Entity
public class Thread_Tag {

	@Id
	@GeneratedValue
	private int idThreadTag;

	@ManyToOne  
	@JoinColumn(name = "idThread")
	private Thread thread;

	@ManyToOne  
	@JoinColumn(name = "idTag")
	private Tag tag;

	public void insertNewThreadTag(Thread thread, List<Tag> tagList) {
		for(int i = 0; i < tagList.size(); i++) {
			Tag tag = tagList.get(i);

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
			EntityManager em = factory.createEntityManager();
			Thread_Tag threadTag = new Thread_Tag();
			threadTag.setThread(thread);
			threadTag.setTag(tag);

			em.getTransaction().begin();
			em.persist(threadTag);
			em.getTransaction().commit();
		}
	}
	
	public List<Thread_Tag> findAllTagsById(int idThread) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM Thread_Tag WHERE idThread = :idThread");
		q.setParameter("idThread", idThread);
		List<Thread_Tag> tags = q.getResultList();
		em.getTransaction().commit();
		return tags;
	}

	public int getIdThreadTag() {
		return idThreadTag;
	}

	public void setIdThreadTag(int idThreadTag) {
		this.idThreadTag = idThreadTag;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
