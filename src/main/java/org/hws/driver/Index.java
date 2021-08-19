package org.hws.driver;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.hws.dao.PerfilDAO;
import org.hws.dblink.SQLiteConnection;
import org.pojo.Contact;

@ManagedBean(name="index")
@ViewScoped
public class Index implements Serializable {

	static final long serialVersionUID = 1L;
	private PerfilDAO dao;
	private List lst;
	private SQLiteConnection sqlite;
	public Connection con;
	private Contact contact;
	
	
	 @PostConstruct
    public void init() {
	      
    }
	public Index() {
		this.dao=new PerfilDAO();
		this.sqlite=new SQLiteConnection();
		this.contact=new Contact();
	
	}
	public void buttonActionXML(ActionEvent actionEvent) {
		 addMessage("Welcome to Primefaces XML!!");
   
    }
	public void addMessage(String summary) {
		 	this.lst=dao.TblPerfil();		 
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	public void buttonActionNoXML(ActionEvent actionEvent) {
		/* this.con=this.mysql.getConnection();
		 this.mysql.close(con);*/
		
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No XMl",  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
   
    }
	public String leafAccount() {
		System.out.println("Se ejecuta el Metodo leafAccount");
		return "Account.jsf";
		
	}
	public void  btnCnxDBActionListener(ActionEvent actionEvent) {
		this.lst=this.dao.TblPerfil();
		this.con=this.sqlite.getConnection();
		
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No XMl",  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
  
   }

}
