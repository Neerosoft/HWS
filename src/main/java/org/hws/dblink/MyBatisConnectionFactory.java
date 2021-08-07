package org.hws.dblink;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisConnectionFactory {
	
private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {			
			String resource="org/hws/dblink/config.xml";
			Reader reader=Resources.getResourceAsReader(resource);
			
			if(sqlSessionFactory==null) {
				sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			}
			
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
