/**
 * 
 */
package com.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pac4j.core.config.Config;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.springframework.web.LogoutController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Autowired
	private Config config;
	
	@Value("${pac4j.defaultUrl:#{null}}")
	private String defaultUrl;
	
	private LogoutController logoutController;
	
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
		model.addAttribute("username", profile.get().getAttribute("username"));
		return "index";
	}
	
	@PostConstruct
    protected void afterPropertiesSet() {
        logoutController = new LogoutController();
        logoutController.setDefaultUrl(defaultUrl);
        logoutController.setLocalLogout(true); //本地是否退出
        logoutController.setCentralLogout(true);
        logoutController.setConfig(config);
        logoutController.setDestroySession(true);
    }
	
	@RequestMapping("/logout.do")
    public void centralLogout(HttpServletRequest request, HttpServletResponse response) {
        logoutController.logout(request, response);
    }
}
