package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entites.Category;
import com.example.demo.repo.CateRepo;



@Controller

public class HomeController {

	
	@Autowired
	private CateRepo repo;
	
	@RequestMapping(value = {"","/home"})
	public String home(Model model) {
		
		List<Category> list = repo.findAll();
		for (Category category : list) {
			System.out.println(category);
		}
		
		model.addAttribute("list", list);
		return "index";
	}
}
