package entities;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


public class Account {
	@NotEmpty(message = "fullname không rỗng nhé")
	private String fullName;
	@NotEmpty(message = "email không rỗng nhé")
	@Email(message = "email không đúng định dạng")
	private String email;
	

	@NotBlank(message = "password không rỗng nhé")
	@Email(message = "email không đúng định dạng")
	private String password;
	
	@NotEmpty(message = "email không rỗng nhé")
	@Pattern(message = "Không ddunsgd dịnh dạng",regexp = "^[a-zA-Z0-9]{3}")
	private String phone;
	@NotNull(message = "birthday không rỗng nhé")
	private Date birthday;
	private String imgName;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	




	public Account(@NotEmpty(message = "fullname không rỗng nhé") String fullName,
			@NotEmpty(message = "email không rỗng nhé") @Email(message = "email không đúng định dạng") String email,
			@NotBlank(message = "password không rỗng nhé") @Email(message = "email không đúng định dạng") String password,
			@NotEmpty(message = "email không rỗng nhé") @Pattern(message = "Không ddunsgd dịnh dạng", regexp = "^[a-zA-Z0-9]{3}") String phone,
			@NotNull(message = "birthday không rỗng nhé") Date birthday, String imgName) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.imgName = imgName;
	}







	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	

	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
}
