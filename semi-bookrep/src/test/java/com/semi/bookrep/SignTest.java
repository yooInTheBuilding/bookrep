package com.semi.bookrep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import com.semi.bookrep.dto.UserDTO;
import com.semi.bookrep.service.SignService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class SignTest {
	
	@Autowired
	private SignService signService;

	@Test
	void signInTest() {
		HttpSession session = new MockHttpSession();
		
		String view = signService.signIn(session, "ing06047", "4567");
		
		System.out.println(view);
		System.out.println(session.getAttribute("email"));
	}
	
	@Test
	void emailCheckTest() {
		System.out.println(signService.emailCheck("ing06047"));
	}
	
	@Test
	void applySignUpTest() {
		String[] arr = signService.applySignUp("dbals9926", "유시훈", "4566");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
	
	@Test
	void findPasswordTest() {
		String result = signService.findPassword("ing06047", "유시훈");
		System.out.println(result);
	}
	
	@Test
	void showModifyTest() {
		HttpSession session = new MockHttpSession();
		session.setAttribute("email", "ing06047");
		UserDTO userDTO = signService.showModify(session);
		System.out.println("email: " + userDTO.getEmail());
		System.out.println("password: " + userDTO.getPassword());
		System.out.println("name: " + userDTO.getName());
	}
	
	@Test
	void modifyTest() throws Exception {
		HttpSession session = new MockHttpSession();
		List<MultipartFile> files = null;
		UserDTO userDTO = new UserDTO("sw0263", "sw09050", "유시우우");
		signService.modify(files, userDTO, session);
	}
	
	@Test
	void resignTest() {
		HttpSession session = new MockHttpSession();
		session.setAttribute("email", "dbals9926");
		
		signService.resign(session);
	}

}
