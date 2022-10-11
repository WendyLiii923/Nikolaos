package com.java18.nikolaos.login.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.java18.nikolaos.register.model.MemberBean;
// 登出時需要做的事寫在這裡，如session.invalidate()
public class LogoutBean {
   
//	private static Logger log = LoggerFactory.getLogger(LogoutBean.class);
	HttpSession session;
	
	public LogoutBean(HttpSession session) {
		this.session = session;
	}

	public LogoutBean() {
	}

	public HttpSession getSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public Integer getLogout() {
		MemberBean mb = (MemberBean)session.getAttribute("loginMember");
		String email = "";
		if (mb != null) {
			email = mb.getEmail();
		} else {
			email = "(未知)";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		log.info("使用者:" + userId + "已於 " + sdf.format(new Date())  + " 登出...");
		session.invalidate();
		return 0;
	}
}
