package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import entities.Account;

@Controller
public class AccountController {
	@InitBinder
    public void initBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        s.setLenient(false);
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }
    

	@GetMapping({"/","/insertAccount"})
	public String addAccount(Model model) {
		Account account = new Account();
		model.addAttribute("acc", account);
		return "add";
	}
	
	@PostMapping("insertAccount")
	public String insertAccount(@Valid @ModelAttribute("acc") Account acc,BindingResult result, HttpSession session,@RequestParam("imageName")MultipartFile fileImage,Model model,HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "add";
		} else {
			//xu ly upload anh
			String path = request.getServletContext().getRealPath("uploads/images");
			File f = new File(path);
			
			File destination = new File(f.getAbsolutePath()+"/"+fileImage.getOriginalFilename());
			System.out.println(destination);
			if(!destination.exists()) {
				try {
					Files.write(destination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			acc.setImgName(fileImage.getOriginalFilename());
			return "infor";
		}
	
	}
}
