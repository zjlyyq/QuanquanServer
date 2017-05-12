package servlet;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTool {
	private static InputStream inputStream = null;
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
		SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(inputStream);
		return factory;
	}
}
