package org.hws.driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.pojo.Contact;
 
@ManagedBean(name="contactsView")
@ViewScoped
public class ContactsView implements Serializable {
     
    private Contact contact;
     
    private List<Contact> contacts;
     
    @PostConstruct
    public void init() {
        contact = new Contact();
        contacts = new ArrayList<Contact>();
    }
         
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
     
    public List<Contact> getContacts() {
        return contacts;
    }
     
    public String saveContact(){
        if(!contacts.contains(contact)) {
            contacts.add(contact);
        }
         
        return "pm:list?transition=flip";
    }
     
    public void deleteContact(){
        if(contacts.contains(contact)) {
            contacts.remove(contact);
        }                
    }    
     
    public String prepareNewContact() {
        contact = new Contact();
         
       // return "pm:edit?transition=flip";
        return "Account.jsf";
    }
    public String back() {
    	System.out.println("Se ejecuta el evento");
    	return "../";
    }
 
}