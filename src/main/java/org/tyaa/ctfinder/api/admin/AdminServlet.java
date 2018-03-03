package org.tyaa.ctfinder.api.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tyaa.ctfinder.entity.State;
import org.tyaa.ctfinder.entity.Task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class TasksServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		
		ObjectifyService.register(State.class);
		ObjectifyService.register(Task.class);
	}	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");

	    //Преобразователь из объектов Java в строки JSON
	    Gson gson =// new Gson();
	    		new GsonBuilder()
	    		.setDateFormat("yyyy-MM-dd").create();
	    
	  //Открываем выходной поток - с сервера к клиенту (браузеру/мобильному приложению)
	    try (PrintWriter out = resp.getWriter()) {
	    	System.out.println("sendRedirect1");
	    	if (req.getParameterMap().containsKey("action")) {
				
	    		String actionString = req.getParameter("action");
	    	} else if(req.getParameterMap().isEmpty()){
				System.out.println("sendRedirect");
				resp.sendRedirect("/admin/index.html");
	    	}
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
