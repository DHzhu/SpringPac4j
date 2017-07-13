/**
 * 
 */
package com.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月11日
 */
@Controller
public class BasicController {
	@RequestMapping(value = "/login.do") 
	public String showLogin(HttpServletRequest request, HttpServletResponse response, RedirectAttributesModelMap model){
		String error = request.getParameter("error");
		if(error != null && !error.equals("")){
			model.addFlashAttribute("username", request.getParameter("username"));
			model.addFlashAttribute("result", error);
			return "redirect:/login.do";
		}
		
		return "login";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/index.do")
	public String showIndex(HttpServletRequest request, HttpServletResponse response, Model model){
		final WebContext context = new J2EContext(request, response);
		final ProfileManager manager = new ProfileManager(context);
		final Optional<CommonProfile> profile = manager.get(true);
		model.addAttribute("username", profile.get().getId());
		return "index";
	}
	
}
