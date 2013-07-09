package Model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Entity
public class Thread {

	@Id
	@GeneratedValue
	private int idThread;

	@Column(name="titleThread", columnDefinition="varchar(45)")
	private String titleThread;

	@Column(name="messageThread", columnDefinition="text")
	private String messageThread;

	@Column(name="dateCreate", columnDefinition="timestamp")
	private Timestamp dateCreate;

	@Column(name="dateUpdate", columnDefinition="Timestamp")
	private Timestamp dateUpdate;

	@Column(name="numbersOfVisualizations", columnDefinition="int")
	private int numbersOfVisualizations;

	@ManyToOne  
	@JoinColumn(name = "idUser")
	private User user;

	@ManyToOne  
	@JoinColumn(name = "idSection")
	private Section section;

	@OneToMany(mappedBy="thread", cascade=CascadeType.ALL)  
	private List<Comment> comments;

	@OneToMany(mappedBy="thread", cascade=CascadeType.ALL)  
	private List<Thread_Tag> threadsTags;

	/**
	 * Insere um novo tópico na base de dados.
	 * @param thread
	 */
	public int insertNewThread(Thread thread) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		Timestamp now = new Timestamp(new Date().getTime());
		
		thread.setDateCreate(now);
		thread.setDateUpdate(now);
		thread.setTitleThread(thread.getTitleThread().trim());
		thread.setMessageThread(thread.getMessageThread().trim());

		em.getTransaction().begin();
		em.persist(thread);
		em.getTransaction().commit();
		
		return thread.getIdThread();
	}

	/**
	 * Pesquisa por uma tópico com base no id passado.
	 * @param id
	 * @return section
	 */
	public Thread findById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM Thread WHERE idThread = :id");
		q.setParameter("id", id);
		Thread thread = (Thread) q.getSingleResult();
		em.getTransaction().commit();
		return thread;
	}

	public void updateThread(int id, String title, String message) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Thread thread = em.find( Thread.class, id);
		thread.setTitleThread(title.trim());
		thread.setMessageThread(message.trim());
		Timestamp now = new Timestamp(new Date().getTime());
		thread.setDateUpdate(now);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	public void updateThread(int id, int number) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Thread thread = em.find( Thread.class, id);
		thread.setNumbersOfVisualizations(number);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	public void deleteThread(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Thread thread = em.find( Thread.class, id);
		em.remove(thread);
		em.getTransaction().commit();
		em.close();

		new Comment().deleteAllCommentsFromThread(id);
	}

	public void deleteAllThreadsFromSection(int idSection) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();
		List<Thread> threads = new Thread().findAllBySection(idSection);

		for(int i = 0; i < threads.size(); i++) {
			em.getTransaction().begin();      
			Thread thread = em.find(Thread.class, threads.get(i).getIdThread());
			thread.deleteThread(thread.getIdThread());
			em.getTransaction().commit();
		}
		em.close();
	}

	/**
	 * Pesquisa por todos os tópicos de uma seção
	 * @return List<Thread>
	 */
	public List<Thread> findAllBySection(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM Thread WHERE idSection = :id", Thread.class);
		q.setParameter("id", id);
		List<Thread> threads = q.getResultList();
		em.getTransaction().commit();
		return threads;
	}

	public boolean canUserModifyThread(int idUSer, int idThread) {
		Thread thread = new Thread().findById(idThread);
		int idAuthorThread = thread.getUser().getIdUser();
		boolean isAdmin = new User().isUserAdmin(idUSer);

		if(idAuthorThread == idUSer || isAdmin)
			return true;
		else
			return false;
	}

	/**
	 * Pesquisa por todas as tags de um tópico.
	 * 
	 * @return List<Tag>
	 */
	public List<Tag> findAllByThread(int id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM Thread_Tag WHERE idThread = :id",
				Thread.class);
		q.setParameter("id", id);
		List<Tag> tags = q.getResultList();
		em.getTransaction().commit();
		return tags;
	}

	public int getIdThread() {
		return idThread;
	}

	public void setIdThread(int idThread) {
		this.idThread = idThread;
	}

	public String getTitleThread() {
		return titleThread;
	}

	public void setTitleThread(String titleThread) {
		this.titleThread = titleThread;
	}

	public String getMessageThread() {
		return messageThread;
	}

	public void setMessageThread(String messageThread) {
		this.messageThread = messageThread;
	}

	public Timestamp getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Timestamp getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Timestamp dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getNumbersOfVisualizations() {
		return numbersOfVisualizations;
	}

	public void setNumbersOfVisualizations(int numbersOfVisualizations) {
		this.numbersOfVisualizations = numbersOfVisualizations;
	}

	public List<Thread_Tag> getThreadsTags() {
		return threadsTags;
	}

	public void setThreadsTags(List<Thread_Tag> threadsTags) {
		this.threadsTags = threadsTags;
	}
}