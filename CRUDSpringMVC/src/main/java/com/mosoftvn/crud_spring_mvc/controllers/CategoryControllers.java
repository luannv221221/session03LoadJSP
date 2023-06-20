package com.mosoftvn.crud_spring_mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mosoftvn.crud_spring_mvc.dao.CategoryDAO;
import com.mosoftvn.crud_spring_mvc.entities.Category;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class CategoryControllers {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Category> list = categoryDAO.getAll();
		model.addAttribute("list",list);
		return "category/index";
	}
	
	@GetMapping(value = "/addCategory")
	public String add(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category/add";
	}
	
	@PostMapping(value = "/insertCategory")
	public String save(@ModelAttribute("category")Category category,Model model) {
		
		boolean check = categoryDAO.create(category);
		if(check) {
			return "redirect:/";
		}
			
		return "category/add";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String delete(@PathVariable  String id,RedirectAttributes redirectAttrs) {
		
		if(categoryDAO.delete(Integer.parseInt(id))) {
			redirectAttrs.addFlashAttribute("success", "Xóa thành công");
			return "redirect:/";
		}
		
		return "redirect:/";
		
	}
	@GetMapping("/editCategory/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		Category category = categoryDAO.find(id);
		model.addAttribute("category", category);
		return "category/edit";
	}
	
	@PostMapping(value = "/updateCategory")
	public String update(@ModelAttribute("category") Category category,RedirectAttributes redirectAttrs) {
		
		if(categoryDAO.update(category)) {
			redirectAttrs.addFlashAttribute("success", "Cập nhậtthành công");
			return "redirect:/";
		}
		
		return "redirect:/";
	}
}
