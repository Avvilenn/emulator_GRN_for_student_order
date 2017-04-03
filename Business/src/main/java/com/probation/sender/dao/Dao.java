package com.probation.sender.dao;

import com.probation.sender.domain.Person;
import com.probation.sender.exception.DaoException;

/**
 * Created by просто on 22.03.2017.
 */
public interface Dao {
    Long add(Person person) throws DaoException;
    Person findPerson(Person person) throws DaoException;
}
