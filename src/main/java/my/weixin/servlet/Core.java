package my.weixin.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import my.weixin.entity.Identity;
import my.weixin.entity.Message;

public class Core extends HttpServlet {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	private static final long serialVersionUID = -2167537127739344653L;

	public Core() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String signature = request.getParameter(Identity.P_SIGNATURE);
		String timestamp = request.getParameter(Identity.P_TIMESTAMP);
		String nonce = request.getParameter(Identity.P_NONCE);
		String echostr = request.getParameter(Identity.P_ECHOSTR);
		Identity id = new Identity(signature, timestamp, nonce, echostr);
		if(id.recognize()){
			System.out.println(id.recognize()+id.toString());
			response.getWriter().print(echostr);
		}else{
			response.getWriter().print("fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String signature = request.getParameter(Identity.P_SIGNATURE);
		String timestamp = request.getParameter(Identity.P_TIMESTAMP);
		String nonce = request.getParameter(Identity.P_NONCE);
		String echostr = request.getParameter(Identity.P_ECHOSTR);
		Identity id = new Identity(signature, timestamp, nonce, echostr);
		log.info(id.toString());
		if(id.recognize()){		
			CoreHandler handler = new CoreHandler(request.getInputStream());
			Message responseMsg = (Message)handler.process();
			if(responseMsg == null){
				response.getWriter().print(id.getEchostr());
			}else{
				InputStream res = handler.response(responseMsg);
				if(res != null){
					response.getWriter().print(IOUtils.toString(res));
				}
			}
		}else{
			response.getWriter().print("recognize-fail");
		}
	}
}
