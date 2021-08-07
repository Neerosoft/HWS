package org.hws.driver;
import java.sql.Connection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.hws.dao.PanelDAO;
import org.hws.dblink.MSSQLConnection;

@SessionScoped
@ManagedBean(name="index")
public class Index {
	private PanelDAO dao;
	private List lst;
	private MSSQLConnection mysql;
	public Connection con;

	public Index() {
		this.dao=new PanelDAO();
		this.mysql=new MSSQLConnection();
	
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

}
