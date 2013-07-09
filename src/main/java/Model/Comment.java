package Model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
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
public class Comment {

    @Id
    @GeneratedValue
    private int idComment;

    @Column(name = "messageComment", columnDefinition = "text")
    private String messageComment;

    @Column(name = "dateCreate", columnDefinition = "timestamp")
    private Timestamp dateCreate;

    @Column(name = "dateUpdate", columnDefinition = "timestamp")
    private Timestamp dateUpdate;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idThread")
    private Thread thread;

    /**
     * Insere um novo comentário na base de dados.
     * 
     * @param comment
     */
    public void insertNewComment(Comment comment) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();
		Timestamp now = new Timestamp(new Date().getTime());

		comment.setDateCreate(now);
		comment.setDateUpdate(now);
		comment.setMessageComment(comment.getMessageComment().trim());

        em.getTransaction().begin();
        em.persist(comment);
        em.getTransaction().commit();
    }

    /**
     * Pesquisa por todos os comentários de um tópico
     * 
     * @return List<Thread>
     */
    public List<Comment> findAllByThread(int id) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("FROM Comment WHERE idThread = :id",
                Comment.class);
        q.setParameter("id", id);
        List<Comment> comments = q.getResultList();
        em.getTransaction().commit();
        return comments;
    }

    public void updateComment(int id, String message) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Comment comment = em.find(Comment.class, id);
        comment.setMessageComment(message);
        Timestamp now = new Timestamp(new Date().getTime());
		comment.setDateUpdate(now);
		comment.setMessageComment(comment.getMessageComment().trim());

        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public Comment findById(int id) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("FROM Comment WHERE idComment = :id");
        q.setParameter("id", id);
        Comment comment = (Comment) q.getSingleResult();
        em.getTransaction().commit();
        return comment;
    }

    public boolean canUserModifyComment(int idUSer, int idComment) {
        Comment comment = new Comment().findById(idComment);
        int idAuthorThread = comment.getUser().getIdUser();
        boolean isAdmin = new User().isUserAdmin(idUSer);

        if (idAuthorThread == idUSer || isAdmin)
            return true;
        else
            return false;
    }

    public void deleteAllCommentsFromThread(int idThread) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();
        List<Comment> comments = new Comment().findAllByThread(idThread);

        for(int i = 0; i < comments.size(); i++) {
            em.getTransaction().begin();      
            Comment comment = em.find(Comment.class, comments.get(i).getIdComment());
            em.remove(comment);
            em.getTransaction().commit();
        }
        em.close();
    }
    
    public void deleteComment(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
        em.getTransaction().commit();
        em.close();
        
        new Comment().deleteAllCommentsFromThread(id);
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getMessageComment() {
        return messageComment;
    }

    public void setMessageComment(String messageComment) {
        this.messageComment = messageComment;
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

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}