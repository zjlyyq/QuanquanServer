package servlet;
import java.util.List;
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

import com.models.Message;
import com.models.Position;
import com.mysql.fabric.xmlrpc.base.Array;

public class GetMessages extends HttpServlet{

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
			//System.out.println(yourjson);
			JSONObject jsonObject = new JSONObject(yourjson);
			double minLongitude = jsonObject.getDouble("lx");
			double minLatitude = jsonObject.getDouble("ly");
			double maxLongitude = jsonObject.getDouble("rx");
			double maxLatitude = jsonObject.getDouble("ry");
			//System.out.println("lx = "+minLongitude);
			//System.out.println("rx = "+maxLongitude);
			Position position = new Position();
			position.setMaxLatitude(maxLatitude);
			position.setMaxLongitude(maxLongitude);
			position.setMinLatitude(minLatitude);
			position.setMinLongitude(minLongitude);
			SqlSessionFactory factory = SqlSessionTool.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			String statement = "messageinfo.getUserInfoByPosition";
			List<Message> messages = session.selectList(statement, position);
			//System.out.println(messages);
			JSONObject messageUnion = new JSONObject();
			messageUnion.put("count", messages.size());          
			JSONArray array = new JSONArray();
			for(int i = 0;i < messages.size();i ++){
				JSONObject message = new JSONObject(messages.get(i));
				messageUnion.put("message"+i,message);
			}
			//System.out.println(messageUnion.toString());
			resp.getWriter().write(messageUnion.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("error");
		}
		
	}
	
}
