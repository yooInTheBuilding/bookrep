package com.semi.bookrep.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semi.bookrep.dao.UserDao;
import com.semi.bookrep.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignService {
	
	@Autowired 
	private UserDao userDao;

	public String signIn(HttpSession session, String email, String password) {
		log.info("signIn()");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		int loginResult = userDao.signIn(map);
		
		if(loginResult != 0) {
			log.info("로그인 성공");
			
			session.setAttribute("email", email);
			
			return "redirect:/home";
			
		} else {
			log.info("로그인 실패");
			return "signIn";
		}
		
	}

	public int emailCheck(String email) {
		log.info("emailCheck()");
		
		int cnt = userDao.emailCheck(email);
		return cnt;
	}

	public String[] applySignUp(String email, String name, String password) {
		log.info("applySignUp()");
		
		String msg = "회원가입 성공";
		String view = "redirect:/";
		UserDTO userDTO = new UserDTO(email, password, name);
		
		try {
			userDao.applySignUp(userDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "중복된 이메일입니다";
			view = "redirect:sign-up";
		}
		String[] arr = {msg, view};
		
		return arr;
	}

	public String findPassword(String email, String name) {
		log.info("findPassword()");
		
		String result = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("name", name);
		String password = userDao.getPassword(map);
		if (password == null || password.isEmpty()) {
			result = "No matching account";
		}else {
			result = "Your password is " + password;
		}
		
		return result;
	}

	public UserDTO showModify(HttpSession session) {
		log.info("showModify()");
		
		String email = (String)session.getAttribute("email");
		UserDTO userDTO = userDao.showModify(email);
		
		return userDTO;
	}

	public void modify(List<MultipartFile> files, UserDTO userDTO, HttpSession session) throws Exception {
		log.info("modify()");
		String upFile = null;
		if (files != null && !files.isEmpty()) {
			upFile = files.get(0).getOriginalFilename();
		}
		if (upFile != null && !upFile.isEmpty() && !upFile.isBlank()) {
			fileUpload(files, session, userDTO);
		}
		
		userDao.modify(userDTO);
		
	}
	
	private void fileUpload(List<MultipartFile> files,
            HttpSession session,
            UserDTO userDTO) throws Exception {
		log.info("fileUpload()");
		String image = null;
		String original = null;
		
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/upload/";
		File folder = new File(realPath);
		if(folder.isDirectory() == false){
		folder.mkdir();
		}
		
		MultipartFile mf = files.get(0);
		original = mf.getOriginalFilename();
		
		image = System.currentTimeMillis()
				+ original.substring(original.lastIndexOf("."));
		
		File file = new File(realPath + image);
	
		mf.transferTo(file);
		userDTO.setImage(image);
	}

	public void resign(HttpSession session) {
		log.info("resign()");
		
		String email = (String)session.getAttribute("email");
		
		userDao.resign(email);
		
		session.invalidate();
	}

}