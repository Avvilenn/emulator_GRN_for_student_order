package com.probation.sender.checkers;

import com.probation.sender.domain.Person;
import com.probation.sender.exception.CheckerException;

/**
 * Created by просто on 22.03.2017.
 */
public class CheckIfPersonLivesInSTPeter {
    private PersonManager manager = PersonManager.getInstance();
    private static CheckIfPersonLivesInSTPeter instance = new CheckIfPersonLivesInSTPeter();

    private CheckIfPersonLivesInSTPeter() {
    }

    public static CheckIfPersonLivesInSTPeter getInstance() {
        return instance;
    }

    public boolean check(Person person) throws CheckerException {
        try {
            Person person1 = manager.findPerson(person);
            if(person.getAdressOfLiving().getCity()!=null && person.getAdressOfLiving().getCity().trim()!= null ){
                if(person.getAdressOfLiving().getCity().trim() == "СПб" || person.getAdressOfLiving().getCity().trim() == "Санкт-Петербург"){
                    return true;
                } else if (person.getAdressOfLiving().getCity().trim() == "St.Peter" || person.getAdressOfLiving().getCity().trim() == "SaintPetersburg"){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (CheckerException e) {
            e.printStackTrace();
            throw new CheckerException("checker exception");
        }
    }

}
