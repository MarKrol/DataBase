package pl.camp.it.model;

import sun.swing.MenuItemLayoutHelper;

import java.util.Formatter;

public class Structure {
    private String name;
    private String surname;
    private int age;
    private String city;
    private  String country;
    private String continent;
    private String sex;

    public Structure(String name, String surname, int age, String city, String country){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public Structure(String name, String surname, int age, String city, String country, String continent, String sex){
        this(name, surname, age, city, country);
        this.continent = continent;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // przesłonięcie metody i zbudowanie własnego stringa do wyświetlania
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        formatter.format("%-10s %-30s %-35s %-10s %-30s %-30s %-30s %-20s","" ,this.name, this.surname, this.age, this.city,
                this.country, this.continent, this.sex);

        return stringBuilder.toString();
      }



}
