package com.probation.sender.checkers;

import com.probation.sender.dao.GlobalDaoFactory;
import com.probation.sender.dao.PersonDao;
import com.probation.sender.domain.Person;
import com.probation.sender.exception.CheckerException;
import com.probation.sender.exception.DaoException;


public class PersonManager {
    private PersonDao dao = GlobalDaoFactory.getPersonDao();
    private static PersonManager instance = new PersonManager();

    private PersonManager() {
    }

    public static PersonManager getInstance() {
        return instance;
    }

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    public Long addPerson(Person person) throws CheckerException {
        try {
            Long id = dao.add(person);
            return id;
        } catch (DaoException e) {
            e.printStackTrace();
            CheckerException ex = new CheckerException("Exception in PersonManager");
            throw ex;
        }
    }

    public Person findPerson(Person person) throws CheckerException {
        try {
            Person person1 = dao.findPerson(person);
            return person1;
        } catch (DaoException e) {
            e.printStackTrace();
            CheckerException ex = new CheckerException("Exception in PersonManager");
            throw ex;
        }
    }

}
