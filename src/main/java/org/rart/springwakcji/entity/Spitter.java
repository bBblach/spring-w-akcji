package org.rart.springwakcji.entity;

public class Spitter {


    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;


    public Spitter() {
    }

    public Spitter(String login, String password, String firstName, String lastName) {

        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long id, String login, String password, String firstName, String lastName) {
        this(login,password,firstName,lastName);
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
