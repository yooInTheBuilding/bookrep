package com.semi.bookrep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.semi.bookrep.dto.UserDTO;
import com.semi.bookrep.service.SignService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignController {

	@Autowired
	SignService signService;

	// 로그인 이동
	@GetMapping("sign-in")
	public String showSignIn() {
		log.info("로그인 화면 이동");
		return "signIn";
	}

	// 로그인 로직
	@PostMapping("sign-in")
	public String signIn(HttpSession session, @RequestParam String email, @RequestParam String password) {
		log.info("email:{}, pw:{}", email, password);

		String view = signService.signIn(session, email, password);
		log.info(view);
		return view;
	}

	// 로그아웃 로직
	@GetMapping("sign-out")
	public String signOut(HttpSession session) {
		session.invalidate();
		log.info("로그아웃");
		return "home1";
	}
	
	@GetMapping("sign-up")
	public String signUp() {
		log.info("signUp()");
		
		return "signUp";
	}
	
	@PostMapping("/emailCheck")
	@ResponseBody
	public String emailCheck(@RequestParam("email") String email) {
		log.info("emailCheck()");
		
		int cnt = signService.emailCheck(email);
		
		return String.valueOf(cnt);
	}
	
	@PostMapping("sign-up")
	public String applySignUp(
			@RequestParam("email") String email,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			RedirectAttributes rttr) {
		
		log.info("applySignUp()");
		
		String[] arr =  signService.applySignUp(email, name, password);
		
		rttr.addFlashAttribute("msg", arr[0]);
		
		return arr[1];
	}
	
	@GetMapping("find-password")
	public String showPassFinder() {
		log.info("showPassFinder");
		
		return "findPassword";
	}
	
	@PostMapping(value = "find-password", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String findPassword(@RequestParam("email") String email, @RequestParam("name") String name) {
		log.info("findPassword");
		
		String result = signService.findPassword(email, name);
		
		return result;
	}
	
	@GetMapping("update")
	public String showModify(HttpSession session, Model model) {
		log.info("showModify()");
		
		UserDTO userDTO = signService.showModify(session);
		model.addAttribute("user", userDTO);
		
		return "update";
	}
	
	@PostMapping("update")
	public String modify(@RequestPart List<MultipartFile> files, UserDTO userDTO, HttpSession session) throws Exception {
		log.info("modify()");
		
		signService.modify(files, userDTO, session);
		
		return "redirect:/";
	}
	
	@GetMapping("resign")
	public String resign(HttpSession session) {
		log.info("resign()");
		
		signService.resign(session);
		
		return "redirect:/";
	}
	
	
	
	
	
	
}