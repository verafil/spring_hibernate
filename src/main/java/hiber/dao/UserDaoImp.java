package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
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
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserBySeries(int series) {
      Query query1=sessionFactory.getCurrentSession().createQuery("from Car a where a.series = :series");
      Car car = (Car) query1.setParameter("series", series).uniqueResult();
      Query query2=sessionFactory.getCurrentSession().createQuery("from User a where a.car = :idCar");
      return (User) query2.setParameter("idCar", car).uniqueResult();
   }

}
