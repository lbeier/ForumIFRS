package Model;

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
public class User {

	@Id
	@GeneratedValue
	private int idUser;

	@Column(columnDefinition="varchar(20)")
	private String loginUser;

	@Column(columnDefinition="varchar(40)")
	private String passwordUser;

	@Column(columnDefinition="boolean")
	private boolean typeUser;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)  
	private List<Thread> threads;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)  
	private List<Comment> comments;

	/**
	 * Insere um novo usuário na base de dados.
	 * @param user
	 */
	public void insertNewUser(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	/**
	 * Pesquisa por um usuário com base no id passado.
	 * @param id
	 * @return user
	 */
	public User findById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM User WHERE idUser = :id");
		q.setParameter("id", id);
		User user = (User) q.getSingleResult();
		em.getTransaction().commit();
		return user;
	}

	public List<User> findAllUsers() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM User", User.class);
		List<User> users = q.getResultList();
		em.getTransaction().commit();
		return users;
	}

	/**
	 * Loga usuário no sistema.
	 * @return
	 */
	public int loginUser() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM User WHERE loginUser = :login AND passwordUser = :password", User.class);
		q.setParameter("login", this.getLoginUser());
		q.setParameter("password", this.getPasswordUser());
		try {
			User query = (User) q.getSingleResult();
			return query.getIdUser();
		} catch(Exception e) {
			return 0;
		}
	}

	public boolean isUserAdmin(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("FROM User WHERE idUser = :id");
		q.setParameter("id", id);
		User user = (User) q.getSingleResult();
		em.getTransaction().commit();

		if(user.getTypeUser())
			return true;
		else
			return false;
	}

	public boolean canModifyUser(int idUser, int idUserDelete) {

        boolean isAdmin = new User().isUserAdmin(idUser);

        if(idUser == idUserDelete || isAdmin)
            return true;
        else
            return false;
    }
	
	public void deleteUser(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
	
	public void updateUser(int id, String password, boolean type, boolean isAdmin) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		User user = em.find(User.class, id);
		user.setPasswordUser(password);
		if(isAdmin)
			user.setTypeUser(type);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public boolean getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(boolean typeUser) {
		this.typeUser = typeUser;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
