package org.hws.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hws.dblink.MyBatisConnectionFactory;
import org.hws.jdbc.SQLConnection;
import org.hws.repo.Perfil;



public class PerfilDAO {
	private SqlSessionFactory sqlSessionFactory=null;
	private SQLConnection sql=null;
	

	public PerfilDAO() {
		this.sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();
		this.sql=new SQLConnection();
	}
	
	public List<Perfil>TblPerfil(){
		List<Perfil>lista_perfil=new ArrayList<Perfil>();		
		SqlSession session=sqlSessionFactory.openSession();
		try {			
			lista_perfil=session.selectList("Perfil.TPerfil");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			session.close();
		}		
		return lista_perfil;
		
	}
	

	
	public boolean NuevoPerfil(String newperfil) {

		boolean flag=false;
		SqlSession session=sqlSessionFactory.openSession();
		Map<String, String> param = new HashMap<String, String>();
		
		try {
		
			param.put("op","I");
			param.put("idperfil","0");
			param.put("perfilname",newperfil);
			
			
			String aux=(String) session.selectOne("Perfil.NuevoPerfil", param);
			
			System.out.println(aux);
	
			flag=true;
		} 
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
			
		}
		finally {
			session.close();
		}
		return flag;
	}
	
	/*private void TestJdbc() {
		Connection con=null;
		Statement orden=null;
		ResultSet salida=null;
		int disp=0;
		String sqlCommander="select * from perfil";
		
		try {
	
			
			
		} 
		catch (Exception e) {
		
		}
		
	}*/
	
	
}
