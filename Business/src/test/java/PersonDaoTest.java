import com.probation.sender.checkers.CheckIfPersonLivesInSTPeter;
import com.probation.sender.checkers.PersonManager;
import com.probation.sender.domain.Adress;
import com.probation.sender.domain.Person;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.Date;

public class PersonDaoTest {
    @Test
    public void testAddPerson () throws Exception {
        Adress adress = new Adress();
        adress.setCity("St.Peter");
        adress.setOblast("LO");
        adress.setPostalCode("188800");
        adress.setStreet("someStreet");
        adress.setNumberOfApartament(127);
        adress.setLiteraOfApartament("a".charAt(0));
        adress.setNumberOfBuilding(220);
        adress.setLiteraOfBuilding("b".charAt(0));
        Person person = new Person ();
        person.setAdressOfLiving(adress);
        person.setSurName("Surname");
        person.setPatronymic("PatronicName");
        person.setGivenName("GivenName");
        person.setDateOfBirth(new Date(12-03-1998));
        person.setPassportDateExpire(new Date(12-03-2010));
        person.setPassportDateIssue(new Date(12-03-2020));
        person.setPassportNumber("123456");
        person.setPassportSeria("AF");

        PersonManager manager = PersonManager.getInstance();
        Long id = manager.addPerson(person);
        System.out.println("person added id=" + id);


        CheckIfPersonLivesInSTPeter checker = CheckIfPersonLivesInSTPeter.getInstance();
        Boolean f = checker.check(person);
        System.out.println("person lives in St.Peter   " + f);
    }
}
