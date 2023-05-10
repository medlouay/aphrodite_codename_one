/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
//import com.mycomany.entities.Reclamation;
import com.mycomany.entities.AppointmentRequest;
import com.mycomany.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Lenovo
 */
public class ServicePost {
     public ArrayList<AppointmentRequest> post;
    
    //singleton 
    public static ServicePost instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServicePost getInstance() {
        if(instance == null )
            instance = new ServicePost();
        return instance ;
    }
    
    
    
    public ServicePost() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajoutReclamation(AppointmentRequest appointment) {
        
        String url =Statics.BASE_URL+"/api/json/newappointment?name="+appointment.getName()+"&lastname="+appointment.getLastname()+"&gender="+appointment.getGender()+"&phonenumber="+appointment.getPhonenumber()+"&email="+appointment.getEmail()+"&new_old="+appointment.getOld_new()+"&appointmentprocedure="+appointment.getAppointmentprocedure()+"&type="+appointment.getType()+"&status="+appointment.getStatus()+"&lien=dddddd"+"&id_patient=1"; // aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    //affichage
    
    public ArrayList<AppointmentRequest>affichageReclamations() {
        ArrayList<AppointmentRequest> post = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/api/json/displayappointment";
        req.setUrl(url);
        
        req.setHttpMethod("GET");
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>postListJson = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) postListJson.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        AppointmentRequest re = new AppointmentRequest();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                  //      String title = obj.get("name").toString();
               // String slug = obj.get("lastname").toString();
                //String summary = obj.get("summary").toString();
                //String content = obj.get("content").toString();
                //String publishedAt = obj.get("publishedAt").toString();
                
                String name = obj.get("name").toString();
                String lastname = obj.get("lastname").toString();
                //String birthday = obj.get("birthday").toString();
                String gender = obj.get("gender").toString();
                String phonenumber = obj.get("phonenumber").toString();
                String email = obj.get("email").toString();
                String new_old = obj.get("new_old").toString();
                String appointmentprocedure = obj.get("appointmentprocedure").toString();
                //String appointmentdate = obj.get("appointmentdate").toString();
                String type = obj.get("type").toString();
                //String lien = obj.get("lien").toString();
                //String appointmentime = obj.get("appointmentime").toString();
                String status = obj.get("status").toString();

                re.setId((int)id);
                //ar.setObjet();
                re.setName(name);
                re.setLastname(lastname);
                //ar.setBirthday(birthday);
                re.setGender(gender);
                re.setPhonenumber(phonenumber);
                re.setEmail(email);
                re.setOld_new(new_old);
                re.setAppointmentprocedure(appointmentprocedure);
                //ar.setAppointmentdate(appointmentdate);
                re.setType(type);
                //ar.setLien(lien);
                //ar.setAppointmentime(appointmentime);
                re.setStatus(status);

                //Date 
                

                        post.add(re);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return post;
        
        
    }
    
    
    
    //Detail Reclamation bensba l detail n5alihoa lel5r ba3d delete+update
    

    
    
    //Delete 
    public boolean deleteReclamation(int id ) {
        String url = Statics.BASE_URL +"/api/json/deleteappointment?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    
    //Update 
    public boolean modifierReclamation(AppointmentRequest appointment) {
        String url = Statics.BASE_URL + "/api/json/editappointment?name="+appointment.getName()+"&id=" + appointment.getId() + "&lastname="+appointment.getLastname()+"&gender="+appointment.getGender()+"&phonenumber="+appointment.getPhonenumber()+"&email="+appointment.getEmail()+"&new_old="+appointment.getOld_new()+"&appointmentprocedure="+appointment.getAppointmentprocedure()+"&type="+appointment.getType()+"&lien=dddddd";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }

    //public void ajoutReclamation(Reclamation r) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}


    

    
}