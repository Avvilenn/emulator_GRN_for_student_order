package com.probation.sender.dao;


import com.probation.sender.exception.GetPropertiesException;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GlobalDaoFactory {
    private static PersonDao personDao;

    public synchronized static PersonDao getPersonDao() {
        if (personDao == null) {
            try {
                createAllDao();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return personDao;
    }

    public synchronized static void createAllDao() throws GetPropertiesException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        PropertyResourceBundle p = (PropertyResourceBundle) ResourceBundle.getBundle("DaoProperties");

        String personDaoStr = p.getString("PersonDao");
        personDao = (PersonDao) Class.forName(personDaoStr).newInstance();

    }
}
