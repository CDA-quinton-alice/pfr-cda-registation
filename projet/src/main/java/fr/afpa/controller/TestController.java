package fr.afpa.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	
	@RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView validationSuppression() {
		ModelAndView model = new ModelAndView();
		File f2 = new File(System.getProperty("user.home"));
		
		String str3 = "/RegiStation/";
		try {
			File f3 = new File(f2.getCanonicalPath()+str3);
			model.addObject("str1",f3.getCanonicalPath());
			model.addObject("str1V", f3.exists());
			model.addObject("str3",f2.getCanonicalPath());
			model.addObject("str3V", f2.exists());
			model.setViewName("coucou");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
