package org.hws.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hws.dblink.MyBatisConnectionFactory;
import org.hws.repo.Panel;

public class PanelDAO {
	private SqlSessionFactory sqlSessionFactory=null;

	public PanelDAO() {
		this.sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();		
		
	}
	
	public List<Panel>DBPanel(){
		List<Panel>nombre_cias=new ArrayList<Panel>();		
		SqlSession session=sqlSessionFactory.openSession();
		try {			
			nombre_cias=session.selectList("Panel.vistapanel");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			session.close();
		}	
		System.out.println("DBPanel()-->"+nombre_cias+"\n");
		for(Panel p:nombre_cias) {
			System.out.println(p.getIdpanel()+ " "+p.getTitle()+" "+p.getCmp());
		}
		return nombre_cias;
		
	}

}
