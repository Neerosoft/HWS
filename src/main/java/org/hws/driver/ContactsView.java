package org.hws.driver;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.pojo.Contact;
import org.hws.dao.PerfilDAO;

 
@ManagedBean(name="contactsView")
@ViewScoped
public class ContactsView implements Serializable {
     
    /**
	 * 
	 */

	private Contact contact;
    private PerfilDAO dao;
    private List lstPerfil;
     
    private List<Contact> contacts;
     
    @PostConstruct
    public void init() {
        contact = new Contact();
        contacts = new ArrayList<Contact>();
        this.dao=new PerfilDAO();
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
    
    
    public String tblPerfil() {
    	System.out.println("Se ejecuta el evento");
    	//this.lstPerfil=this.dao.TblPerfil();
    	try {
    		File f=new File(".");
        	System.out.println(f.getCanonicalPath());
			
		} catch (Exception e) {
			System.out.println("Error al obtener el camino");
			e.printStackTrace();
		}
    	
    	return "/";
    }
    
    public String getHome() {
    	
       
        return "index.jsf";
    }
    public String prepateEvento() {
    	return "Account.jsf";
    }
 
}