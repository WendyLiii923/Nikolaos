package com.java18.nikolaos.login.model;

import javax.servlet.http.HttpSession;
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
//		MemberBean mb = (MemberBean)session.getAttribute("loginMember");
//		String email = "";
//		if (mb != null) {
//			email = mb.getEmail();
//		} else {
//			email = "(未知)";
//		}
		session.invalidate();
		return 0;
	}
}
