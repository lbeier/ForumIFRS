package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private int idTag;

	@Column(name="titleTag", columnDefinition="text")
	private String titleTag;

	@OneToMany(mappedBy="tag", cascade=CascadeType.ALL)  
	private List<Thread_Tag> threadsTags;

	public int insertNewTag(String titleTag) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		Tag tag = new Tag();
		tag.setTitleTag(titleTag.toLowerCase());

		em.getTransaction().begin();
		em.persist(tag);
		em.getTransaction().commit();

		return tag.getIdTag();
	}

	public Tag findById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM Tag WHERE idTag = :id");
		q.setParameter("id", id);
		Tag tag = (Tag) q.getSingleResult();
		em.getTransaction().commit();
		return tag;
	}

	public void createListOfTags(String[] tags, int idThread) {
		List<Tag> tagsList = new ArrayList<Tag>();
		Thread thread = new Thread().findById(idThread);
		
		for(int i = 0; i < tags.length; i++) {
			String titleTag = tags[i].trim();
			int idTag = createTagIfNotExists(titleTag);
			Tag tagObj = new Tag().findById(idTag);
			tagsList.add(tagObj);
		}

		new Thread_Tag().insertNewThreadTag(thread, tagsList);
	}

	public int createTagIfNotExists(String titleTag) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM Tag WHERE titleTag LIKE :titleTag");
		q.setParameter("titleTag", titleTag);
		List<Tag> tagList = q.getResultList();
		em.getTransaction().commit();
		
		if(tagList.isEmpty())
			return new Tag().insertNewTag(titleTag);
		else
			return tagList.get(0).getIdTag();
	}

	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getTitleTag() {
		return titleTag;
	}

	public void setTitleTag(String titleTag) {
		this.titleTag = titleTag;
	}

	public List<Thread_Tag> getThreadsTags() {
		return threadsTags;
	}

	public void setThreadsTags(List<Thread_Tag> threadsTags) {
		this.threadsTags = threadsTags;
	}
}
