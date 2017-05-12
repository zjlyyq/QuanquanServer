package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.models.MessageImage;
import com.models.User;
import com.models.UserPhoto;

import java.util.List;

public class GetImagesByMessageId extends HttpServlet{

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

		String yourjson = req.getParameter("json");
		try {
			JSONObject userJson = new JSONObject(yourjson);
			int messageId = userJson.getInt("messageId");
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			String statement = "messageimage.getMessageImage";
			//ArrayList<MessageImage> messageImages = new ArrayList<MessageImage>();
			List<MessageImage> messageImages = (List) session.selectList(statement,messageId);
			JSONObject messageUnion = new JSONObject();
			messageUnion.put("count", messageImages.size());          
			for(int i = 0;i < messageImages.size();i ++){
				messageUnion.put("imageUrl"+i,messageImages.get(i).getImageUrl());
			}
			resp.getWriter().write(messageUnion.toString());
			session.close();
		} catch (JSONException e) {
			e.printStackTrace();
			resp.getWriter().write("error");
		}
	}
}
