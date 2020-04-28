package com.java.spring.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.models.Depart;

// lớp này chứa tất cả các định nghĩa của lớp Staff, ko phải ánh xạ tới CSDL
public class StaffDto implements Serializable {
	// Các Annotation cho phép kiểm tra dữ liệu nhậpư
	private Long id;
	@NotNull
	@NotEmpty(message = "Name is not empty!") // đây là kĩ thuật check validation dữ liệu nhập vào
	@Length(min = 5, max = 50, message = "Name is out of range!") // min: 5 kí tự, max: 50 kí tự và thông báo một // message																	
	private String name;

	@NotNull
	private MultipartFile image; // đổi lại kiểu String --> MultipartFile

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;

	@NotNull
	private Integer departId;
	
	public StaffDto() {
		super();
	}

	public StaffDto(Long id,
			@NotNull @NotEmpty(message = "Name is not empty!") @Length(min = 5, max = 50, message = "Name is out of range!") String name,
			@NotNull MultipartFile image, @NotNull Date birthday, @NotNull Integer departId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.birthday = birthday;
		this.departId = departId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	
	

}
