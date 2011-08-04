package edu.columbia.stat.wood.hslda.ICD9.webapp;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ICD9_webappServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
