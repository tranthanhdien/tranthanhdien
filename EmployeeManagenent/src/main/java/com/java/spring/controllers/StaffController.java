package com.java.spring.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.dtos.StaffDto;
import com.java.spring.models.Depart;
import com.java.spring.models.Staff;
import com.java.spring.repositories.StaffRepository;
import com.java.spring.sevices.StaffService;

@Controller
@RequestMapping("/staffs") // để phân biệt với các Controller #
public class StaffController {
	@Autowired
	private StaffRepository staffRe;
	@Autowired
	private StaffService staffService;

	@RequestMapping("/list")
	public String list(ModelMap model, @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
			@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		Pageable pageable = PageRequest.of(page, size, sortable);

		model.addAttribute("staffs", staffRe.findStaffs(pageable));
		model.addAttribute("currentPage", page);
		return "staffs/list";
	}

//	@GetMapping(value = "/list")
//	public String list(ModelMap model, @RequestParam(defaultValue = "0") int page) {
//		Pageable pageable = PageRequest.of(page, 10);
//		// B1: Gọi pthuc để lấy toàn bộ Staff
//		List<Staff> list = staffRe.findAll();
//		// B2: Add list Staff vào Atribute, sau đó qua bên View sẽ dựa vào nó và lấy ra
//		model.addAttribute("staffs", staffRe.findStaffs(pageable));
//
//		return "staffs/list"; // trả về view
//	}

	// P.thuc này để mở form add
	@GetMapping("/add")
	public String add(ModelMap model) {
		StaffDto staffDto = new StaffDto(); // ban đầu dùng Staff, nhưng để check validation ==> thay == StaffDto
		// staff.setDepart(new Depart());
		model.addAttribute("staffDto", staffDto);

		return "staffs/addOrEdit";
	}

	// Validated: để kiểm tra lỗi, BindingResult: để xuất ra thông báo lỗi
	@PostMapping(value = "/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @Validated StaffDto staffDto, BindingResult result) {
		// B1: Đầu tiên kiểm tra có lỗi hay k
		if (result.hasErrors()) {
			// Có thì addAttribute, qua view hiển thị lỗi lên
			model.addAttribute("message", "Please input all required fields!");
			// Sau đó trả lại StaffDto cho user biết
			model.addAttribute("staffDto", staffDto);
			// Sau đó return về trang view để nhập liệu
			return "staffs/addOrEdit";
		}

		// nếu đã updated (>0)
		// note: nếu là lần đầu tiên chạy thì id sẽ null nên sẽ báo lỗi ==> set !=null
		if (staffDto.getId() != null && staffDto.getId() > 0) {
			// addAtribute sau khi đã saveOrUpdate thành công
			model.addAttribute("message", "The Staff updated!");
		} else {
			// addAtribute sau khi đã saveOrUpdate thành công
			model.addAttribute("message", "New Staff inserted!");
		}

		// upload hình ảnh
		// thư mục lưu trữ ảnh
		Path path = Paths.get("images/");
		try {
			InputStream inputStream = staffDto.getImage().getInputStream();
			Files.copy(inputStream, path.resolve(staffDto.getImage().getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			String fileName = staffDto.getImage().getOriginalFilename();

			// sau khi upload thành công, xuất ra thông báo
			// model.addAttribute("message", fileName + " uploaded!");
		} catch (Exception e) {
			// xuất ra lỗi
			e.printStackTrace();
			model.addAttribute("message", "Error: " + e.getMessage());
		}

		// Bắt đầu lưu đối tượng vào CSDL
		Staff staff = new Staff();
		staff.setName(staffDto.getName());
		staff.setBirthday(staffDto.getBirthday());
		staff.setPhoto(staffDto.getImage().getOriginalFilename());

		Depart depart = new Depart();
		depart.setId(staffDto.getDepartId());
		staff.setDepart(depart);
		
		
		// lưu xuống CSDL
		staffService.save(staff);
		model.addAttribute("staffDto", staffDto); // cho phép hiển thị lại thông tin vừa add
		model.addAttribute("count", staffRe.countStaff());
		return "staffs/addOrEdit";
	}

	// tìm kiếm Staff trong DB
	@GetMapping(value = "/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Long id) {
		// đầu tiên tìm id cần sửa
		Optional<Staff> optStaff = staffService.findById(id); // xác định xem tìm thấy hay k
		if (optStaff.isPresent()) { // nếu có giá trị
			model.addAttribute("staff", optStaff.get());
		} else {
			// ngược lại không có giá trị
			return list(model, 0, 0, "");
		}

		return "staffs/addOrEdit";
	}

	// delete 1 Staff
	@GetMapping(value = "/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Long id) {
		// đầu tiên kiểm tra thông tin user nhập vào có chính xác k
		staffService.deleteById(id);
		return list(model, 0, 0, ""); // gọi lại pthuc list để hiển thị lại
	}

	// tìm kiếm tên theo dạng 'LIKE'
	// defaultValue = "": nghĩa là mặc định tham số truyền vào sẽ là rỗng khi lần
	// đầu chạy ==> ko xảy ra lỗi
	@GetMapping(value = "/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		// B1: Gọi pthuc thư viện làm sẵn ==> trả về danh sách kết quả tìm kiếm
		List<Staff> list = staffService.findByNameLikeOrderByName(name);
		// B2: Thêm vào model, sau đó qua view sẽ lấy nó ra để hiển thị
		model.addAttribute("staffs", list);

		return "staffs/list"; // return về trang find (view)
	}

	// Lấy toàn bộ depart để hiển thị qua view Staff
	@ModelAttribute(value = "departs")
	public List<Depart> getListDepart() {
		return staffService.findAllDepart();
	}

//	// Lấy toàn bộ depart để hiển thị qua view Staff
//	@ModelAttribute(value = "staffs")
//	public Long getListStaff() {
//		return staffService.count();
//	}

}
