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

import org.hibernate.mapping.Set;

@Entity
public class Section {

    @Id
    @GeneratedValue
    private int idSection;

    @Column(name="titleSection", columnDefinition="varchar(40)")
    private String titleSection;

    @Column(name="descriptionSection", columnDefinition="text")
    private String descriptionSection;

    @OneToMany(mappedBy="section", cascade=CascadeType.ALL)  
    private List<Thread> threads;

    /**
     * Insere uma nova seção na base de dados.
     * @param section
     */
    public int insertNewSection(Section section) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(section);
        em.getTransaction().commit();

        return section.getIdSection();
    }

    /**
     * Pesquisa por uma seção com base no id passado.
     * @param id
     * @return section
     */
    public Section findById(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("FROM Section WHERE idSection = :id");
        q.setParameter("id", id);
        Section section = (Section) q.getSingleResult();
        em.getTransaction().commit();
        return section;
    }

    /**
     * Pesquisa por todas as seções.
     * @return List<Section>
     */
    public List<Section> findAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        List<Section> sections = em.createQuery("FROM Section", Section.class).getResultList();
        em.getTransaction().commit();
        return sections;
    }
    
    public void deleteSection(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Section section = em.find(Section.class, id);
        em.remove(section);
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void updateSection(int id, String title, String description) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Section section = em.find(Section.class, id);
        section.setTitleSection(title);
        section.setDescriptionSection(description);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getTitleSection() {
        return titleSection;
    }

    public void setTitleSection(String titleSection) {
        this.titleSection = titleSection;
    }

    public String getDescriptionSection() {
        return descriptionSection;
    }

    public void setDescriptionSection(String descriptionSection) {
        this.descriptionSection = descriptionSection;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }
}