package org.hws.dblink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.jasper.tagplugins.jstl.core.Out;


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
