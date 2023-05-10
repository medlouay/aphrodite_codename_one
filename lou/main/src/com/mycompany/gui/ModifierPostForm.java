/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycomany.entities.AppointmentRequest;
//import com.mycomany.entities.Reclamation;

import com.mycompany.services.ServicePost;

/**
 *
 * @author Lenovo
 */
public class ModifierPostForm extends BaseForm {
    
    Form current;
    public ModifierPostForm(Resources res, AppointmentRequest rec) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Post");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField etatTxt = new TextField(rec.getName(), "title" , 20 , TextField.ANY);
        TextField etatTxt1 = new TextField(rec.getLastname(), "slug" , 20 , TextField.ANY);
        TextField etatTxt2 = new TextField(rec.getGender(), "summary" , 20 , TextField.ANY);
        TextField etatTxt3 = new TextField(rec.getPhonenumber(), "content" , 20 , TextField.ANY);
        TextField etatTxt4 = new TextField(rec.getEmail(), "content" , 20 , TextField.ANY);
        TextField etatTxt5 = new TextField(rec.getOld_new(), "content" , 20 , TextField.ANY);
        TextField etatTxt6 = new TextField(rec.getAppointmentprocedure(), "content" , 20 , TextField.ANY);
        TextField etatTxt7 = new TextField(rec.getType(), "content" , 20 , TextField.ANY);
        //TextField dateTxt = new TextField(rec.getStatus(), "publishedAt" , 20 , TextField.ANY);
              // TextField etat = new TextField(String.valueOf(r.getEtat()) , "Etat" , 20 , TextField.ANY);
 
        etatTxt.setUIID("NewsTopLine");
        etatTxt1.setUIID("NewsTopLine");
        etatTxt2.setUIID("NewsTopLine");
        etatTxt3.setUIID("NewsTopLine");
        etatTxt4.setUIID("NewsTopLine");
        etatTxt5.setUIID("NewsTopLine");
        etatTxt6.setUIID("NewsTopLine");
        etatTxt7.setUIID("NewsTopLine");
        //dateTxt.setUIID("NewsTopLine");
        
        
        etatTxt.setSingleLineTextArea(true);
        etatTxt1.setSingleLineTextArea(true);
        etatTxt2.setSingleLineTextArea(true);
        etatTxt3.setSingleLineTextArea(true);
        etatTxt4.setSingleLineTextArea(true);
        etatTxt5.setSingleLineTextArea(true);
        etatTxt6.setSingleLineTextArea(true);
        etatTxt7.setSingleLineTextArea(true);
        //dateTxt.setSingleLineTextArea(true);

        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           rec.setName(etatTxt.getText());
           rec.setLastname(etatTxt1.getText());
           rec.setGender(etatTxt2.getText());
           rec.setPhonenumber(etatTxt3.getText());
           rec.setEmail(etatTxt4.getText());
           rec.setOld_new(etatTxt5.getText());
           rec.setAppointmentprocedure(etatTxt6.getText());
           rec.setType(etatTxt7.getText());
           //rec.setStatus(dateTxt.getText());
           
      
       
       //appel fonction modfier reclamation men service
       
       if(ServicePost.getInstance().modifierReclamation(rec)) { // if true
           new ListPostForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListPostForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(etatTxt),
                createLineSeparator(),
                new FloatingHint(etatTxt1),
                createLineSeparator(),
                new FloatingHint(etatTxt2),
                createLineSeparator(),
                new FloatingHint(etatTxt3),
                createLineSeparator(),
                new FloatingHint(etatTxt4),
                createLineSeparator(),
                new FloatingHint(etatTxt5),
                createLineSeparator(),
                new FloatingHint(etatTxt6),
                createLineSeparator(),
                //new FloatingHint(etatTxt7),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }

    //ModifierReclamationForm(Resources res, post rec) {
       
    //}
}
