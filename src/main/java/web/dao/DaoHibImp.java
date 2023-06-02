package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoHibImp implements DAOHib {
    @PersistenceContext()
    private EntityManager entityManager;
    protected EntityManager getEntityManager(){
        return this.entityManager;
    }


    @Transactional
    public void saveUser(User user) {
        getEntityManager().persist(user);

    }


    @Transactional
    public void updateUser(User user) {

        getEntityManager().merge(user);
    }


    @Transactional
    public User removeUserById(int id) {
        return getEntityManager().find(User.class, id);
    }

    public List<User> getAllUsers() {
        return getEntityManager().createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    public User getUserById(int id) {

        return getEntityManager().find(User.class, id);
    }
}
