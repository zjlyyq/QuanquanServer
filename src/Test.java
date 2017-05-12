import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.models.User;
import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;


public class Test {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		String selectstatement = "userinfo.getStudentById";
		System.out.println("¿ªÊ¼²éÑ¯");
		User user = session.selectOne(selectstatement,1);
		System.out.println("username = "+user.getUserName());
	}
}
