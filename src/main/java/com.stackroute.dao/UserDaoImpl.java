package com.stackroute.dao;


import com.stackroute.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*
     * Save the note in the database(note) table.
     */

    public boolean saveNote(User user) {

        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().flush();
        return true;
    }


}
