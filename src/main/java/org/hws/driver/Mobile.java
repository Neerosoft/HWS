package org.hws.driver;



import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="mobile")
@ViewScoped
public class Mobile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Mobile() {		
	}
    @PostConstruct
    public void init() {
      
    }
    public String backHome() {	
    	System.out.println("Se ejecuta el Metodo backHome");
        return "index.jsf";
    }
      

}
