package com.probation.sender.domain;


import java.io.Serializable;

public class Adress implements Serializable {

    private String country;
    private String postalCode;
    private String oblast;
    private String city;
    private String street;
    private int numberOfBuilding;
    private char literaOfBuilding;
    private int numberOfApartament;
    private char literaOfApartament;

    public Adress() {
    }

    public Adress(String country, String postalCode, String oblast, String city, String street, int numberOfBuilding, char literaOfBuilding, int numberOfApartament, char literaOfApartament) {
        this.country = country;
        this.postalCode = postalCode;
        this.oblast = oblast;
        this.city = city;
        this.street = street;
        this.numberOfBuilding = numberOfBuilding;
        this.literaOfBuilding = literaOfBuilding;
        this.numberOfApartament = numberOfApartament;
        this.literaOfApartament = literaOfApartament;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(int numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }

    public char getLiteraOfBuilding() {
        return literaOfBuilding;
    }

    public void setLiteraOfBuilding(char literaOfBuilding) {
        this.literaOfBuilding = literaOfBuilding;
    }

    public int getNumberOfApartament() {
        return numberOfApartament;
    }

    public void setNumberOfApartament(int numberOfApartament) {
        this.numberOfApartament = numberOfApartament;
    }

    public char getLiteraOfApartament() {
        return literaOfApartament;
    }

    public void setLiteraOfApartament(char literaOfApartament) {
        this.literaOfApartament = literaOfApartament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adress adress = (Adress) o;

        if (numberOfBuilding != adress.numberOfBuilding) return false;
        if (literaOfBuilding != adress.literaOfBuilding) return false;
        if (numberOfApartament != adress.numberOfApartament) return false;
        if (literaOfApartament != adress.literaOfApartament) return false;
        if (country != null ? !country.equals(adress.country) : adress.country != null) return false;
        if (postalCode != null ? !postalCode.equals(adress.postalCode) : adress.postalCode != null) return false;
        if (oblast != null ? !oblast.equals(adress.oblast) : adress.oblast != null) return false;
        if (!city.equals(adress.city)) return false;
        return street != null ? street.equals(adress.street) : adress.street == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (oblast != null ? oblast.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + numberOfBuilding;
        result = 31 * result + (int) literaOfBuilding;
        result = 31 * result + numberOfApartament;
        result = 31 * result + literaOfApartament;
        return result;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", oblast='" + oblast + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfBuilding=" + numberOfBuilding +
                ", literaOfBuilding=" + literaOfBuilding +
                ", numberOfApartament=" + numberOfApartament +
                ", literaOfApartament=" + literaOfApartament +
                '}';
    }
}
