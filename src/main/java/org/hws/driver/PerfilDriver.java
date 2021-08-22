package org.hws.driver;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.hws.dao.PerfilDAO;
import org.hws.repo.Perfil;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;

 
@ManagedBean(name="perfil")
@ViewScoped
public class PerfilDriver implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
    private PerfilDAO dao;
    private String perfilName;  
    private List<Perfil>datos;
    
    private InputText txtfirstname;
 
     
    @PostConstruct
    public void init() {      
        this.dao=new PerfilDAO();        
        this.txtfirstname=new InputText();
        this.datos=dao.TblPerfil();
    } 
    
    
     
    public List<Perfil> getDatos() {
		return datos;
	}



	public void setDatos(List<Perfil> datos) {
		this.datos = datos;
	}



	public InputText getFirstname() {    	
		return txtfirstname;
	}


	public void setFirstname(InputText txtfirstname) {
		this.txtfirstname = txtfirstname;
	}


	public String backHome() {             
       // return "pm:edit?transition=flip";
        return "/index.jsf";
    }

	public String getPerfilName() {
		return perfilName;
	}

	public void setPerfilName(String perfilName) {
		this.perfilName = perfilName;
	}
	
	public String btnSave_Click() {	
		
		//boolean flag=dao.NuevoPerfil();	
		//System.out.println("flag  "+flag);
		boolean flag=false;
		if(this.txtfirstname.getValue().equals("")||this.txtfirstname.getValue().equals(null)) {
			try {
			 FacesContext context = FacesContext.getCurrentInstance();
			 String viewId = context.getViewRoot().getViewId();			
			 System.out.println(viewId);	    
		      
		     context.addMessage(null, new FacesMessage("Error!!", "No se permite datos nulos"));
			}
		        catch (Exception e) {
					System.out.println("Error al volver a cargar la pagina");
		  }
			
		
		
		
			
	
	}
		else {
			try {
			System.out.println("txt:  "+this.txtfirstname.getValue().toString());
			flag=this.dao.NuevoPerfil(this.txtfirstname.getValue().toString());
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Agregado", "Echoes in eternity.");	         
			FacesContext.getCurrentInstance().addMessage(null, message);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		     ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
			} 
			catch (Exception e) {
				System.out.println("Error al volver a cargar la pagina");
			
				}
		}
		
		return "Perfil.jsf";
	
	}
}
	