package config;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
		urlPatterns = { "/config" }, 
		initParams = { 
				@WebInitParam(name = "account", value = "c##jdbc"), 
				@WebInitParam(name = "password", value = "jdbc")
		})
public class ConfigServlet extends HttpServlet {
	
	String account, password;
	public void init(ServletConfig config) throws ServletException {
		account = config.getInitParameter("account");
		password = config.getInitParameter("password");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(account+" : "+password);
	}

}