package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.models.User;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("email = " + "��ʼ");
		request.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String yourjson = request.getParameter("json");
		try {
			JSONObject userJson = new JSONObject(yourjson);
			String email = userJson.getString("email_adress");
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			User user = null;
			String statement = "userinfo.getUserInfoByEmail";
			user = session.selectOne(statement,email);
			System.out.println("email="+email);
			System.out.println("username="+userJson.getString("userName"));
			if (user != null) {
				resp.getWriter().write("此邮箱已经注册过，请直接登录");
			}else {
				user = new User();
				user.setUserName(userJson.getString("userName"));
				user.setPassword(userJson.getString("password"));
				user.setEmail_adress(email);
				String statementinsert = "userinfo.insertIntoUserInfo";
				session.insert(statementinsert, user);
				session.commit();
				System.out.println("userid =  = " + user.getUserId());
				resp.getWriter().write(""+user.getUserId());
			}
			session.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
	}
}
