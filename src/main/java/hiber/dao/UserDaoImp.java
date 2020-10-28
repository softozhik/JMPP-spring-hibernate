package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User withCar(Car car) {

        //если я правильно понял, User usr - создает ссылку usr, которую потом можно через onetoone использовать
        //для подключения к другой таблице
        //надо как-то запомнить, что ли, догадаться нереально :-(
        String hql = "from User usr where usr.car.model = :model and usr.car.series = :series";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());

        return query.getSingleResult();
    }

}
