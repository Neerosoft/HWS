package org.hws.dblink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MyBatisConnectionFactory {
	private String ap="";
	private File f;
	
	public MyBatisConnectionFactory() {		
		
	}
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			String resource="config.xml"; 
			InputStream inputStream = Resources.getResourceAsStream(resource);
		
			File f=new File(".");
			//Reader reader = Resources.getResourceAsReader("config.xml");
			
			System.out.println("\n\nDirectorio "+f.getAbsolutePath());
			String[] listado = f.list();
			if (listado == null || listado.length == 0) {
			    System.out.println("No hay elementos dentro de la carpeta actual");
			    
			}
			else {
			    for (int i=0; i< listado.length; i++) {
			        System.out.println(listado[i]);
			    }
			}
			
		
		
			if(sqlSessionFactory==null) {
				sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			}
			System.out.println("factory = " + sqlSessionFactory);
			
	}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
		
	}

}
