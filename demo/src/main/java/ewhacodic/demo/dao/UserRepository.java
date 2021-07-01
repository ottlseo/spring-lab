package ewhacodic.demo.dao;


import ewhacodic.demo.domain.User;

import javax.persistence.EntityManager;
import java.util.*;

public class UserRepository implements UserDAO {
    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    private final EntityManager em;

    public UserRepository(EntityManager em){
        this.em = em;
    }

    public User save(User user){
        em.persist(user);
        return user;
    }

    @Override
    public List<User> findAll(){
        //return new ArrayList<>(store.values()); //store에 저장되어있는 내용 리턴
        //return em.createQuery("select ") //여기서 멈춤 (54p)
    }

    public void clearStore(){
        store.clear();
    }
}
