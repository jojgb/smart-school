package com.example.smartspring.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.antlr.SqlStatementLexer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartspring.model.SiswaModel;
import com.example.smartspring.model.UserModel;
import com.example.smartspring.service.SiswaService;
import com.example.smartspring.service.UserService;
import com.sun.el.parser.ParseException;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	public SiswaService siswaService; 
	
	
	@RequestMapping("/login")
	public String LoginSiswa() {
		String html = "/login";
		return html;
	}
	@RequestMapping("/loginprocess")
	public String SignIn(HttpServletRequest request , Model model , Connection con)throws ParseException,SQLException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String query = "SELECT U.username FROM UserModel U where U.username=? and U.password=?";
		Statement stmt = null;
	
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		
		String login = "/login";
		String siswa = "siswa/siswa";
		
		
		if (userName != null  && password != null ) {
			 if(!rs.next()) {
				 
			 }
			 return siswa;
		} else {
			return login;
		}
		
	}
	@RequestMapping("/signup")
	public String SignUpSiswa() {
		String html = "/signup";
		return html;
	}
	@RequestMapping("/createuser")
	public String CreateUser(HttpServletRequest request , Model model) throws ParseException{
		String namaUser = request.getParameter("name");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		/// instance model ///
		UserModel userModel = new UserModel();
		
		userModel.setName(namaUser);
		userModel.setUsername(userName);
		userModel.setPassword(password);
		
		this.userService.createUser(userModel);
		
		String html = "/login";
		return html;
	}
	
	public void ListSiswa(Model model) {
		
		List<SiswaModel> siswaModelList = new ArrayList<SiswaModel>();
		siswaModelList = siswaService.readData();
		model.addAttribute("siswaModelList", siswaModelList);
	}
	
//	public void ListUsername(Model model) {
//		List<UserModel> userModelList = new ArrayList<UserModel>();
//		userModelList = userService.cariUsername();
//		model.addAttribute("userModelList" , userModelList);
//	}
//	
//	public void ListPassword(Model model) {
//		List<UserModel> userModelList = new ArrayList<UserModel>();
//		userModelList = userService.cariPassword();
//		model.addAttribute("userModelList" , userModelList);
//	}
}
