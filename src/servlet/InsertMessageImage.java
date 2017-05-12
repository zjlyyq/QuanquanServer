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

import com.models.MessageImage;
import com.models.UserPhoto;

public class InsertMessageImage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			String yourjson = req.getParameter("json");
			System.out.println(yourjson);
			//System.out.println(yourjson);
			JSONObject jsonObject = new JSONObject(yourjson);
			System.out.println(jsonObject.toString());
			int messageId = jsonObject.getInt("messageId");
			String urlImage = jsonObject.getString("imageUrl");
			MessageImage messageImage = new MessageImage();
			messageImage.setImageUrl(urlImage);
			messageImage.setMessageId(messageId);
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			String statement = "messageimage.insertIntoMessageImage";
			session.insert(statement,messageImage);
			session.commit();
			resp.getWriter().write(urlImage);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
	}

}
