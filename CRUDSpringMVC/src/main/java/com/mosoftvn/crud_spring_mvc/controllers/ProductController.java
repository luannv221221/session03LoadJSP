package com.mosoftvn.crud_spring_mvc.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mosoftvn.crud_spring_mvc.dao.ProductDAO;
import com.mosoftvn.crud_spring_mvc.dao.CategoryDAO;
import com.mosoftvn.crud_spring_mvc.entities.Category;
import com.mosoftvn.crud_spring_mvc.entities.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = "/product")
	public String index(Model model) {
		List<Product> list = productDAO.getAll();
		model.addAttribute("list", list);
		return "product/index";
	}
	@RequestMapping(value = "/addProduct")
	public String add(Model model) {
		Product product = new Product();
		List<Category> listCategory = categoryDAO.getAll();
		model.addAttribute("product", product);
		model.addAttribute("listCategory",listCategory);
		return "product/add";
	}
	
	@RequestMapping(value = "/insertProduct")
	public String save(@ModelAttribute("product")Product product,BindingResult result,@RequestParam("image")MultipartFile fileImage,HttpServletRequest request) {
		
		// xu ly upload file 
		String path = request.getServletContext().getRealPath("uploads/images");
		File f = new File(path);
		String fileName = fileImage.getOriginalFilename();
		File distination = new File(f.getAbsolutePath()+"/"+fileName);
		if(!distination.exists()) {
			try {
				Files.write(distination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		product.setImage(fileName);
		
		if(productDAO.create(product)) {
			return "redirect:/product";
		} else {
			return "redirect:/addProduct";
		}
		
	}
	
	@RequestMapping(value = "/editProduct/{id}")
	public String edit(Model model,@PathVariable Integer id) {
		Product product = productDAO.find(id);
		List<Category> listCategory = categoryDAO.getAll();
		model.addAttribute("product", product);
		
		model.addAttribute("listCategory",listCategory);
		return "product/edit";
	}
	
	@RequestMapping(value = "/updateProduct")
	public String update(@ModelAttribute("product")Product product,BindingResult result,@RequestParam("fileImage")MultipartFile fileImage,HttpServletRequest request) {
		// xu ly upload file 
				String fileName = fileImage.getOriginalFilename();
				boolean isEmpty = fileName == null || fileName.trim().length() == 0;
				if(!isEmpty) {
					String path = request.getServletContext().getRealPath("uploads/images");
					File f = new File(path);
					
					File distination = new File(f.getAbsolutePath()+"/"+fileName);
					if(!distination.exists()) {
						try {
							Files.write(distination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					product.setImage(fileName);
				}
				
				if(productDAO.update(product)) {
					return "redirect:/product";
				} else {
					return "redirect:/updateProduct";
				}
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String delete(@PathVariable  String id,RedirectAttributes redirectAttrs) {
		
		if(productDAO.delete(Integer.parseInt(id))) {
			redirectAttrs.addFlashAttribute("success", "Xóa thành công");
			return "redirect:/product";
		}
		
		return "redirect:/";
		
	}
}
