package timebasedonlocation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DisplayTimeBasedOnLocation extends HttpServlet {
	public void service(ServletRequest request,ServletResponse response){
		try {
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		String location = request.getParameter("city");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getTimeZone(location));
		sdf.applyPattern("dd MMM yyyy HH:mm:ss z");
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/DisplayTime.html");
		rDispatcher.include(request, response);
		print.println("<h1>"+location+"--------"+sdf.format(Calendar.getInstance().getTime())+"</h1>");
		}
		catch (Exception ee) {
			System.out.println(ee);
		}
	}

}
