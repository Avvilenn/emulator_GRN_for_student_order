package com.probation.sender.domain;


import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String surName;
    private String givenName;
    private String patronymic;
    private Date dateOfBirth;
    private String passportSeria;
    private String passportNumber;
    private Date passportDateIssue;
    private Date passportDateExpire;
    private Adress adressOfLiving;

    public Person() {
    }

    public Person(String surName, String givenName, String patronymic, Date dateOfBirth, String passportSeria, String passportNumber, Date passportDateIssue, Date passportDateExpire, Adress adressOfLiving) {
        this.surName = surName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.passportSeria = passportSeria;
        this.passportNumber = passportNumber;
        this.passportDateIssue = passportDateIssue;
        this.passportDateExpire = passportDateExpire;
        this.adressOfLiving = adressOfLiving;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getPassportDateIssue() {
        return passportDateIssue;
    }

    public void setPassportDateIssue(Date passportDateIssue) {
        this.passportDateIssue = passportDateIssue;
    }

    public Date getPassportDateExpire() {
        return passportDateExpire;
    }

    public void setPassportDateExpire(Date passportDateExpire) {
        this.passportDateExpire = passportDateExpire;
    }

    public Adress getAdressOfLiving() {
        return adressOfLiving;
    }

    public void setAdressOfLiving(Adress adressOfLiving) {
        this.adressOfLiving = adressOfLiving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!surName.equals(person.surName)) return false;
        if (!givenName.equals(person.givenName)) return false;
        if (patronymic != null ? !patronymic.equals(person.patronymic) : person.patronymic != null) return false;
        if (!dateOfBirth.equals(person.dateOfBirth)) return false;
        if (!passportSeria.equals(person.passportSeria)) return false;
        if (!passportNumber.equals(person.passportNumber)) return false;
        if (passportDateIssue != null ? !passportDateIssue.equals(person.passportDateIssue) : person.passportDateIssue != null)
            return false;
        if (passportDateExpire != null ? !passportDateExpire.equals(person.passportDateExpire) : person.passportDateExpire != null)
            return false;
        return adressOfLiving != null ? adressOfLiving.equals(person.adressOfLiving) : person.adressOfLiving == null;
    }

    @Override
    public int hashCode() {
        int result = surName.hashCode();
        result = 31 * result + givenName.hashCode();
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + passportSeria.hashCode();
        result = 31 * result + passportNumber.hashCode();
        result = 31 * result + (passportDateIssue != null ? passportDateIssue.hashCode() : 0);
        result = 31 * result + (passportDateExpire != null ? passportDateExpire.hashCode() : 0);
        result = 31 * result + (adressOfLiving != null ? adressOfLiving.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surName='" + surName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportSeria='" + passportSeria + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportDateIssue=" + passportDateIssue +
                ", passportDateExpire=" + passportDateExpire +
                ", adressOfLiving=" + adressOfLiving +
                '}';
    }
}
