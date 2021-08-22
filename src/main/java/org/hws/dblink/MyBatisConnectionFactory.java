package org.hws.dblink;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MyBatisConnectionFactory {
	
	
	public MyBatisConnectionFactory() {		
		
	}
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			String resource="config.xml"; 
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
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
