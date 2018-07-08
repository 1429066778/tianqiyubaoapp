package Server;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CatchIP;
import utils.httpGet;

/**
 * Servlet implementation class localcity
 */
public class localcity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public localcity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cc = request.getParameter("city");
		
		CatchIP ip = new CatchIP();
		String city=ip.getIp(request); //获得访问者的IP地址、归属地、运营商。
		httpGet httpget = new httpGet();
		if(cc.equals("local"))
		{
			city=city;
		}else {
			city=cc;
		}
		System.out.println(city);
		String message = httpget.LoginByPost(new String(city.getBytes("UTF-8")));
		//message = message.getBytes(Charset.forName("gbk")).toString();
		response.getWriter().write(message);
		System.out.println(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
