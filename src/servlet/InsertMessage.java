package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.models.Message;
import com.models.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class InsertMessage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().write("error");
		String yourjson = req.getParameter("json");
		System.out.println(yourjson);
		try {
			JSONObject jsonObject = new JSONObject(yourjson);
			String text = jsonObject.getString("text");
			int userId = jsonObject.getInt("userId");
			long publish_time = jsonObject.getLong("publish_time");
			double x = jsonObject.getDouble("x");
			double y = jsonObject.getDouble("y");
			int transmitTimes = jsonObject.getInt("transmitTimes");
			int commentTimes = jsonObject.getInt("commentTimes");
			int favourTimes = jsonObject.getInt("favourTimes");
			Date date = new Date(publish_time);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Message message = new Message();
			message.setPublish_time(simpleDateFormat.format(date));
			message.setUserId(userId);
			message.setText(text);
			message.setX(x);
			message.setY(y);
		
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			String statement = "messageinfo.insertIntoMessageInfo";
			session.insert(statement, message);
			//System.out.println(""+message.getMessageId());
			session.commit();
			resp.getWriter().write(""+message.getMessageId());
			session.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
	}
}
