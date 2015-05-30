package remont.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import remont.dao.PropertyDAO;
import remont.model.Property;

import com.google.gson.Gson;

public class PropertyServlet extends HttpServlet {
	
	private PropertyDAO propertyDAO;
	
	public  void init() {
		propertyDAO = new PropertyDAO();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
        String json = gson.toJson(findProperty(getPropertyId(request)));
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
	
	private Property findProperty(String spiderId) {
		Integer id = -1;//invalid id is default
		
		try {
			id = Integer.parseInt(spiderId);
		} catch (NumberFormatException e) {
			return null;
		}
		
		return propertyDAO.findById(id);
	}
	
	private String getPropertyId(HttpServletRequest request) {
		if (request.getParameter("id") != null) {
			return request.getParameter("id");
		} else {
			return null;
		}
	}
}
