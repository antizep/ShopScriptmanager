package spring.dao;

//import entities.EntityAuntification;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
//import spring_interfaces.AuntificationDao;


@Transactional
public class HibAuntifDao {

    private SessionFactory sessionFactory;


//    @Override
//    @Transactional(readOnly = true)
//    public String findLastByID(long id) {
//        sessionFactory.getCurrentSession()
//                .createQuery("from EntityAuntification c where id=1");
////        return auntification.getLogin();
//    return "";
//    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
