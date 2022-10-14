package d0.testSpring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class H2Test {
    public static void main(String[] args) {
        System.out.println("asdasdasd");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        try {
            tx.begin();
            Member member = new Member();
            member.setId(1L);
            member.setName("ㅁㄴㅇㅁㄴㅇ");
            em.persist(member);
            tx.commit();

        }catch (Exception e) {
            tx.rollback();
            System.out.println(e);
            System.out.println("에러 일어남");

        }finally {
            em.close();

        }
        emf.close();

    }
}
