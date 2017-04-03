package com.probation.sender.dao;

import com.probation.sender.domain.Adress;
import com.probation.sender.domain.Person;
import com.probation.sender.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PersonDao implements Dao {

    private Connection getConnection() throws Exception {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public Long add(Person person) throws DaoException {
        try {
            Connection con = getConnection();
            try {
                String sql = "INSERT INTO person_grn (surName, givenName, patronymic, " +
                        "dateOfBirth, passportSeria, passportNumber, passportDateIssue, passportDateExpire, postalCode, oblast, city, " +
                        "street, numberOfBuilding, literaOfBuilding, numberOfApartament, literaOfApartament ) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, new String[]{
                        "person_id"
                });
                stmt.setString(1, person.getSurName());
                System.out.println("1, personDao");
                stmt.setString(2, person.getGivenName());
                System.out.println("2, personDao");
                stmt.setString(3, person.getPatronymic());
                System.out.println("3, personDao");
                stmt.setDate(4, new java.sql.Date(person.getDateOfBirth().getTime()));
                System.out.println("4, personDao");
                stmt.setString(5, person.getPassportSeria());
                System.out.println("5, personDao");
                stmt.setString(6, person.getPassportNumber());
                System.out.println("6, personDao");
                stmt.setDate(7, new java.sql.Date(person.getPassportDateIssue().getTime()));
                System.out.println("7, personDao");
                stmt.setDate(8, new java.sql.Date(person.getPassportDateExpire().getTime()));
                System.out.println("8, personDao");
                stmt.setString(9, person.getAdressOfLiving().getPostalCode());
                System.out.println("9, personDao");
                stmt.setString(10, person.getAdressOfLiving().getOblast());
                System.out.println("10, personDao");
                stmt.setString(11, person.getAdressOfLiving().getCity());
                System.out.println("11, personDao");
                stmt.setString(12, person.getAdressOfLiving().getStreet());
                System.out.println("12, personDao");
                stmt.setInt(13, person.getAdressOfLiving().getNumberOfBuilding());
                System.out.println("13, personDao");
                stmt.setString(14, String.valueOf(person.getAdressOfLiving().getLiteraOfBuilding()));
                System.out.println("14, personDao");
                stmt.setInt(15, person.getAdressOfLiving().getNumberOfApartament());
                System.out.println("15, personDao");
                stmt.setString(16, String.valueOf(person.getAdressOfLiving().getLiteraOfApartament()));
                System.out.println("16, personDao");
                stmt.executeUpdate();
                System.out.println("17, personDao");
                ResultSet gk = stmt.getGeneratedKeys();
                Long savedId = 0L;
                if (gk.next()) {
                    savedId = gk.getLong(1);
                }
                gk.close();
                stmt.close();
                return savedId;
            } catch (SQLException e) {
                e.printStackTrace();
                DaoException ex = new DaoException(12L, "PersonDaoFailed");
                throw ex;
            } finally {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            DaoException ex = new DaoException(12L, "PersonDaoFailed");
            throw ex;
        }
    }

    @Override
    public Person findPerson(Person person) throws DaoException {
        try {
            Connection con = getConnection();
            try {
                String sql = "SELECT * FROM person_grn WHERE surName=?AND givenName=?AND patronymic=?AND dateOfBirth=?AND passportSeria=?AND passportNumber=? order by person_id desc LIMIT 1";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, person.getSurName());
                System.out.println("1, personDao");
                stmt.setString(2, person.getGivenName());
                System.out.println("2, personDao");
                stmt.setString(3, person.getPatronymic());
                stmt.setDate(4,  new java.sql.Date(person.getDateOfBirth().getTime()));
                System.out.println("4, personDao");
                stmt.setString(5, person.getPassportSeria());
                System.out.println("5, personDao");
                stmt.setString(6, person.getPassportNumber());
                System.out.println("6, personDao");

                ResultSet rs = stmt.executeQuery();
               Person person1= null;
                while (rs.next()) {
                    person1 = new Person();
                    person1.setSurName(rs.getString("surName"));
                    person1.setGivenName(rs.getString("givenName"));
                    person1.setPatronymic(rs.getString("patronymic"));
//                    person1.setDateOfBirth(new Date(rs.getString("dateOfBirth")));
                    person1.setPassportSeria(rs.getString("passportSeria"));
                    person1.setPassportNumber(rs.getString("passportNumber"));
//                    person1.setPassportDateIssue(new Date(rs.getString("passportDateIssue")));
//                    person1.setPassportDateExpire(new Date(rs.getString("passportDateExpire")));
                    Adress adress = new Adress();

                    adress.setOblast(rs.getString("oblast"));
                    adress.setCity(rs.getString("city"));
                    adress.setStreet(rs.getString("street"));
                    adress.setNumberOfBuilding(rs.getInt("numberOfBuilding"));
                    adress.setLiteraOfBuilding(rs.getString("literaOfBuilding").charAt(0));
                    adress.setNumberOfApartament(rs.getInt("numberOfApartament"));
                    adress.setLiteraOfApartament(rs.getString("literaOfApartament").charAt(0));

                    person1.setAdressOfLiving(adress);

                }
                rs.close();
                stmt.close();
                return person1;

            } catch (SQLException e) {
                e.printStackTrace();
                DaoException ex = new DaoException(12L, "PersonDaoFailed");
                throw ex;
            } finally {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            DaoException ex = new DaoException(12L, "PersonDaoFailed");
            throw ex;
        }

    }
}
