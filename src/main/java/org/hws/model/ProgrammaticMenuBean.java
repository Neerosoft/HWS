package org.hws.model;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;


/**
 * ProgrammaticMenuBean
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean(name="menu")
@ViewScoped
public class ProgrammaticMenuBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuModel model;
	

    public void setModel(MenuModel model) {
		this.model = model;
	}

	@PostConstruct
    protected void init() {
        model = new DefaultMenuModel();

        // first submenu
        DefaultSubMenu submenu = new DefaultSubMenu();
       // submenu.setLabel("EosSoft.com");

        // menu items
        DefaultMenuItem item = new DefaultMenuItem();
        item.setValue("Perfil");      
        item.setOutcome("Perfil");
        submenu.addElement(item);

        item = new DefaultMenuItem();
        item.setValue("Yahoo UI");
        item.setUrl("http://yuilibrary.com");
        submenu.addElement(item);

        item = new DefaultMenuItem();
        item.setValue("Prototype");
        item.setUrl("http://prototypejs.org");
        submenu.addElement(item);

        model.addElement(submenu);

        // second submenu
       // submenu = new DefaultSubMenu();
      //  submenu.setLabel("Operations");

        // menu items
       /* item = new DefaultMenuItem();
        item.setValue("Save");
        item.setCommand("#{positionedMenuBean.save}");
        item.setUpdate("growl");
        submenu.addElement(item);

        item = new DefaultMenuItem();
        item.setValue("Update");
        item.setCommand("#{positionedMenuBean.update}");
        item.setUpdate("growl");
        submenu.addElement(item);

        item = new DefaultMenuItem();
        item.setValue("Delete");
        item.setCommand("#{positionedMenuBean.delete}");
        item.setUpdate("growl");
        submenu.addElement(item);*/

        //model.addElement(submenu);
    }

    public MenuModel getModel() {
        return model;
    }
}
