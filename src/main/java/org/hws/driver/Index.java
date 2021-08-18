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
import org.hws.dao.PanelDAO;
import org.hws.dblink.MSSQLConnection;
import org.pojo.Contact;

@ManagedBean(name="index")
@ViewScoped
public class Index implements Serializable {

	static final long serialVersionUID = 1L;
	private PanelDAO dao;
	private List lst;
	private MSSQLConnection mysql;
	public Connection con;
	private Contact contact;
	
	
	 @PostConstruct
    public void init() {
	      
    }
	public Index() {
		/*this.dao=new PanelDAO();
		this.mysql=new MSSQLConnection();*/
		this.contact=new Contact();
	
	}
	public void buttonActionXML(ActionEvent actionEvent) {
		 addMessage("Welcome to Primefaces XML!!");
   
    }
	public void addMessage(String summary) {
		 	this.lst=dao.DBPanel();		 
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	public void buttonActionNoXML(ActionEvent actionEvent) {
		 this.con=this.mysql.getConnection();
		 this.mysql.close(con);
		
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No XMl",  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
   
    }
	public String leafAccount() {
		System.out.println("Se ejecuta el Metodo leafAccount");
		return "Account.jsf";
		
	}

}
