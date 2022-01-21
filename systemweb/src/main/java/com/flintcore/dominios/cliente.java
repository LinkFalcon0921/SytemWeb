package com.flintcore.dominios;

public class cliente {

    private int idCliente;
    private String name;
    private String lname;
    private int age;
    private String mail;
    private double current;
    

    //Constructor

    public cliente() {
    }

    public cliente(String name, String lname, int age, String mail, double current) {
        this.name = name;
        this.lname = lname;
        this.age = age;
        this.mail = mail;
        this.current = current;
    }
    
    public cliente(int idCliente, String name, String lname, int age, String mail, double current) {
        this(name,lname,age,mail,current);
        this.idCliente = idCliente;
    }

    public cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    

    

    
}
