package org.hws.driver;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
//import org.hws.dao.PerfilDAO;

import org.primefaces.component.menu.Menu;
import org.primefaces.model.menu.MenuItem;



@ManagedBean(name="index")
@ViewScoped
public class Index implements Serializable {

	static final long serialVersionUID = 1L;
	private MenuItem mnPerfil; 
	/*private PerfilDAO dao;
	private List lst;*/	
	
	 @PostConstruct
    public void init() {
		
	      
    }
	 
	 
	public MenuItem getMnPerfil() {
		
		return mnPerfil;
	}


	public void setMnPerfil(MenuItem mnPerfil) {
		this.mnPerfil = mnPerfil;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Index() {
		//this.dao=new PerfilDAO();
	
	}
	public void buttonActionXML(ActionEvent actionEvent) {
		 addMessage("Welcome to Primefaces XML!!");
   
    }
	public void addMessage(String summary) {
			 
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	public void buttonActionNoXML(ActionEvent actionEvent) {
		/* this.con=this.mysql.getConnection();
		 this.mysql.close(con);*/
		
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No XMl",  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
   
    }
	public String perfilPage() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 String viewId = context.getViewRoot().getViewId();

		
		 System.out.println(viewId);
		
		return "Perfil";
		
	}
	public void  btnCnxDBActionListener(ActionEvent actionEvent) {
		/*this.lst=this.dao.TblPerfil();	
		int h=dao.getPerfilID();*/		
		
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No XMl",  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
  
   }

}
