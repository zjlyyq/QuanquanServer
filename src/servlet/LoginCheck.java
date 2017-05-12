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

public class LoginCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		doPost(req, resp);
		resp.getWriter().write("用户名或密码不正确");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	
		try {
			String yourjson = request.getParameter("json");
			System.out.println(yourjson);
			JSONObject userJson = new JSONObject(yourjson);
			String email = userJson.getString("userName");
			String password = userJson.getString("password");
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			User user = null;
			String statement = "userinfo.getUserInfoByEmail";
			user = session.selectOne(statement,email);
			if (user == null) {
				resp.getWriter().write("用户名或密码不正确");
			}else {
				String passwd = user.getPassword();
				if (passwd.equals(password)) {
					System.out.println("passwd="+passwd);
					resp.getWriter().write(""+user.getUserId());
				}else{
					resp.getWriter().write("用户名或密码不正确");
				}
			}
			session.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
	}
}
