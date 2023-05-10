/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomany.entities;

//import java.time.LocalDate;
//import java.time.LocalTime;


/**
 *
 * @author Lou
 */
public class AppointmentRequest {
    private int id;
    private String name;
    private String lastname;
    //private String birthday;
    private String gender;
    private String phonenumber;
    private String email;
    private String old_new;
    private String appointmentprocedure;
    //private String appointmentdate;
    private String type;
   // private String lien;
    private String status;
    //private String appointmentime;

    public AppointmentRequest() {
    }

    public AppointmentRequest(String name, String lastname, String gender, String phonenumber, String email, String old_new, String appointmentprocedure, String type, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.email = email;
        this.old_new = old_new;
        this.appointmentprocedure = appointmentprocedure;
        this.type = type;
        this.status = status;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOld_new() {
        return old_new;
    }

    public void setOld_new(String old_new) {
        this.old_new = old_new;
    }

    public String getAppointmentprocedure() {
        return appointmentprocedure;
    }

    public void setAppointmentprocedure(String appointmentprocedure) {
        this.appointmentprocedure = appointmentprocedure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppointmentRequest{" + "name=" + name + ", lastname=" + lastname + ", gender=" + gender + ", phonenumber=" + phonenumber + ", email=" + email + ", old_new=" + old_new + ", appointmentprocedure=" + appointmentprocedure + ", type=" + type + ", status=" + status + '}';
    }

    
   

   
    
    
    
    
}
