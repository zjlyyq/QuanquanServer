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
import com.models.UserPhoto;

public class GetUserById extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	
		String yourjson = req.getParameter("json");
		//System.out.println(yourjson);
		try {
			JSONObject userJson = new JSONObject(yourjson);
			int userId = userJson.getInt("userId");
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			User user = null;
			UserPhoto userPhoto = null;
			String statement = "userinfo.getUserInfoById";
			String getPhotoStatement = "userphoto.getPhotoById";
			userPhoto = session.selectOne(getPhotoStatement,userId);
			user = session.selectOne(statement,userId);
			if (user == null) {
				System.out.println("null");
				resp.getWriter().write("no this user");
			}else {
				JSONObject object = new JSONObject(user);
				String imageUrl = "null";
				if (userPhoto != null) {
					imageUrl = userPhoto.getImageUrl();
				}
				object.put("imageUrl", imageUrl);
				resp.getWriter().write(object.toString());
			}
			session.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
		
	}
	
}
