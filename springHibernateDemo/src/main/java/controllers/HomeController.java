package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import entities.Category;

@Controller
public class HomeController {
	

	@GetMapping(value = "/")
	
	public String function(Model model) {
		List<Category> list = new CategoryDAOImpl().getCategory();
		model.addAttribute("listCate", list);
		return "home";
	}
}
