package mvc.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.member.action.SuperAction;

public class BoardController extends HttpServlet {

	Map<String, SuperAction> map = new HashMap<String, SuperAction>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertiesPath = config.getInitParameter("boardURI");
		Properties p = new Properties();
		FileInputStream f = null;
		try {
			f = new FileInputStream(propertiesPath);
			p.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Iterator iter = p.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String)iter.next();
			String value = p.getProperty(key);
			try {
				Class c = Class.forName(value);
				SuperAction action = (SuperAction)c.newInstance();
				map.put(key, action);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		SuperAction sa = map.get(uri);
		String view = sa.action(request, response);
		request.getRequestDispatcher(view).forward(request, response);
	}
}