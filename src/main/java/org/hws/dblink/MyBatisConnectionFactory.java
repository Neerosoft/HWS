package org.hws.dblink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
			 Reader reader = Resources.getResourceAsReader("config.xml");
			
			if(sqlSessionFactory==null) {
				sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
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
