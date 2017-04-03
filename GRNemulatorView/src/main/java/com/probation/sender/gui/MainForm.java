package com.probation.sender.gui;

import com.probation.sender.checkers.PersonManager;
import com.probation.sender.domain.Adress;
import com.probation.sender.domain.Person;
import com.probation.sender.exception.CheckerException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class MainForm extends JFrame{


    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getSurName() {
        return surName;
    }

    public void setSurName(JTextField surName) {
        this.surName = surName;
    }

    public JTextField getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(JTextField numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }

    public JTextField getLiteraOfApartament() {
        return literaOfApartament;
    }

    public void setLiteraOfApartament(JTextField literaOfApartament) {
        this.literaOfApartament = literaOfApartament;
    }

    public JTextField getLiteraOfBuilding() {
        return literaOfBuilding;
    }

    public void setLiteraOfBuilding(JTextField literaOfBuilding) {
        this.literaOfBuilding = literaOfBuilding;
    }

    public JTextField getNumberOfApartament() {
        return numberOfApartament;
    }

    public void setNumberOfApartament(JTextField numberOfApartament) {
        this.numberOfApartament = numberOfApartament;
    }

    public JTextField getGivenName() {
        return givenName;
    }

    public void setGivenName(JTextField givenName) {
        this.givenName = givenName;
    }

    public JTextField getCity() {
        return city;
    }

    public void setCity(JTextField city) {
        this.city = city;
    }

    public JTextField getStreet() {
        return street;
    }

    public void setStreet(JTextField street) {
        this.street = street;
    }

    public JTextField getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(JTextField postalCode) {
        this.postalCode = postalCode;
    }

    public JTextField getOblast() {
        return oblast;
    }

    public void setOblast(JTextField oblast) {
        this.oblast = oblast;
    }

    public JTextField getPassportDateIssue() {
        return passportDateIssue;
    }

    public void setPassportDateIssue(JTextField passportDateIssue) {
        this.passportDateIssue = passportDateIssue;
    }

    public JTextField getPassportDateExpire() {
        return passportDateExpire;
    }

    public void setPassportDateExpire(JTextField passportDateExpire) {
        this.passportDateExpire = passportDateExpire;
    }

    public JTextField getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(JTextField passportSeria) {
        this.passportSeria = passportSeria;
    }

    public JTextField getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(JTextField passportNumber) {
        this.passportNumber = passportNumber;
    }

    public JTextField getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(JTextField patronymic) {
        this.patronymic = patronymic;
    }

    public JTextField getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(JTextField dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public JButton getSaveInDataBase() {
        return saveInDataBase;
    }

    public void setSaveInDataBase(JButton saveInDataBase) {
        this.saveInDataBase = saveInDataBase;
    }

    private JPanel panel1;
    private JTextField surName;
    private JTextField numberOfBuilding;
    private JTextField literaOfApartament;
    private JTextField literaOfBuilding;
    private JTextField numberOfApartament;
    private JTextField givenName;
    private JTextField city;
    private JTextField street;
    private JTextField postalCode;
    private JTextField oblast;
    private JTextField passportDateIssue;
    private JTextField passportDateExpire;
    private JTextField passportSeria;
    private JTextField passportNumber;
    private JTextField patronymic;
    private JTextField dateOfBirth;
    private JButton saveInDataBase;


    public MainForm() {


        saveInDataBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Are u sure?");
                Person person = new Person();
                Adress adress = new Adress();
                PersonManager manager = PersonManager.getInstance();
                adress.setCity(city.getText());
                adress.setPostalCode(postalCode.getText());
                adress.setOblast(oblast.getText());
                adress.setStreet(street.getText());
                adress.setNumberOfBuilding(Integer.parseInt(numberOfBuilding.getText()));
                adress.setNumberOfApartament(Integer.parseInt(numberOfApartament.getText()));
                adress.setLiteraOfApartament(literaOfApartament.getText().charAt(0));
                adress.setLiteraOfBuilding(literaOfBuilding.getText().charAt(0));
                System.out.println(adress);
                person.setAdressOfLiving(adress);
                person.setSurName(surName.getText());

                person.setGivenName(givenName.getText());
                person.setPatronymic(patronymic.getText());
                person.setDateOfBirth(new Date(dateOfBirth.getText()));
                person.setPassportSeria(passportSeria.getText());
                person.setPassportNumber(passportNumber.getText());
                person.setPassportDateIssue(new Date(passportDateIssue.getText()));
                person.setPassportDateExpire(new Date(passportDateExpire.getText()));

                System.out.println(person);
                Long id;

                try {
                    id  = manager.addPerson(person);
                    JOptionPane.showMessageDialog(null, "Person  id = " + id + "was added to GRN database");
                } catch (CheckerException e1) {
                    e1.printStackTrace();
                }



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
