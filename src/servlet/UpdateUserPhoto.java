package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.models.Message;
import com.models.Position;
import com.models.UserPhoto;

public class UpdateUserPhoto extends HttpServlet{

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
		try {
			String yourjson = req.getParameter("json");
			System.out.println(yourjson);
			//System.out.println(yourjson);
			JSONObject jsonObject = new JSONObject(yourjson);
			int userId = jsonObject.getInt("userId");
			String urlImage = jsonObject.getString("imageUrl");
			UserPhoto userPhoto = new UserPhoto();
			userPhoto.setImageUrl(urlImage);
			userPhoto.setUserId(userId);
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			String selectststement = "userphoto.getPhotoById";
			String statement = "userphoto.insertIntoUserPhoto";
			String updatestement = "userphoto.updatePhoto";
			UserPhoto userPhoto2 = null;
			userPhoto2 = session.selectOne(selectststement,userId);
			if (userPhoto2 == null) {
				session.insert(statement,userPhoto);
				session.commit();
			}else {
				session.update(updatestement,userPhoto);
				session.commit();
				System.out.println("跟新");
			}
			resp.getWriter().write(urlImage);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
		
	}
	
}
