package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.models.Message;
import com.models.Position;

public class GetMessageById extends HttpServlet{

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
			System.out.println("zjl:"+yourjson);
			//System.out.println(yourjson);
			JSONObject jsonObject = new JSONObject(yourjson);
			int messageId = jsonObject.getInt("messageId");
			String statement = "messageinfo.getMessageById";
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			Message message = session.selectOne(statement,messageId);
			JSONObject messagejson = new JSONObject(message);
			resp.getWriter().write(messagejson.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
	}
	
}
