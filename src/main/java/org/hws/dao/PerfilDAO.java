package org.hws.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hws.dblink.MyBatisConnectionFactory;
import org.hws.repo.Perfil;
import org.hws.dblink.SQLiteConnection;
/*
 *SELECT IFNULL(max(p.idperfil),0) from perfil p
 */

public class PerfilDAO {
	private SqlSessionFactory sqlSessionFactory=null;
	private SQLiteConnection sqlite=null;
	

	public PerfilDAO() {
		this.sqlSessionFactory=MyBatisConnectionFactory.getSqlSessionFactory();	
		this.sqlite=new SQLiteConnection();
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
	
	public void ViewRows() {
		Connection con=null;;
		String sqlCommander="select * from perfil";
		Statement orden=null;
		ResultSet salida=null;
		try {
			con=this.sqlite.getConnection();
			orden=con.createStatement();
			salida=orden.executeQuery(sqlCommander);
			while(salida.next()) {
				System.out.print(salida.getString("idperfil")+"     ");
				System.out.println(salida.getString("perfilname"));
			}
			salida.close();
			orden.close();
			this.sqlite.close(con);
			
		} 
		catch (Exception e) {
			System.out.println("Error al mostrar los datos ");
			e.printStackTrace();
		}
		
	}

}
