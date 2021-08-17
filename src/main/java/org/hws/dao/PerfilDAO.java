package org.hws.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hws.dblink.MyBatisConnectionFactory;
import org.hws.repo.Perfil;
/*
 *SELECT IFNULL(max(p.idperfil),0) from perfil p
 */

public class PerfilDAO {
	private SqlSessionFactory sqlSessionFactory=null;
	

	public PerfilDAO() {
		this.sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();	
	}
	public List<Perfil>TblPerfil(){
		List<Perfil>lista_perfil=new ArrayList<Perfil>();		
		SqlSession session=sqlSessionFactory.openSession();
		try {			
			lista_perfil=session.selectList("Perfil.vistaperfil");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			session.close();
		}	
		System.out.println("lista_perfil-->"+lista_perfil+"\n");
		for(Perfil p:lista_perfil) {
			System.out.println(p.getIdperfil()+ " "+p.getPerfilname());
		}
		return lista_perfil;
		
	}

}
