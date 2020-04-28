package com.java.spring.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.spring.models.Staff;
import com.java.spring.sevices.StaffService;

// Lớp này để đọc ảnh và hiển thị lên
@Controller
public class ImageController {
	@Autowired
	private StaffService staffService;
	
	// id này chính là id của Staff
	@RequestMapping(value = "getimage/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> downloadLinkImage(@PathVariable Long id) {
		// Lấy id của Staff
		Optional<Staff> sop = staffService.findById(id);
		
		// Nếu có Staff
		if (sop.isPresent()) {
			Staff staff = sop.get();
			try {
				// Lấy đường dẫn của Staff đó
				Path fileName = Paths.get("images", staff.getPhoto());
				// readAllBytes: chỉ phù hợp với hình ảnh có size nhỏ, lớn thì sẽ gây tràn bộ đệm
				byte[] buffer = Files.readAllBytes(fileName);
				
				
				ByteArrayResource bsr = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png")).body(bsr);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Nếu tìm k thấy Staff sẽ trả về badRequest
		return ResponseEntity.badRequest().build();
	}
}
