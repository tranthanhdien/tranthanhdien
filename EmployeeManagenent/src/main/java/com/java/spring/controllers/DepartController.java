package com.java.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.models.Depart;
import com.java.spring.sevices.DepartService;

@Controller
@RequestMapping("/departs") // để phân biệt với các Controller #
public class DepartController {
	@Autowired
	private DepartService departService;

	@GetMapping(value = "/list")
	public String list(ModelMap model) {
		List<Depart> list = departService.findAll();
		model.addAttribute("departs", list); // bên view sẽ lấy và hiển thị
		return "departs/list"; // trả về view
	}

	// Add và Edit dùng chung 1 view
	@GetMapping(value = "/add")
	public String add(ModelMap model) {
		model.addAttribute("depart", new Depart());
		return "departs/addOrEdit"; // chỉ trả về view
	}

	@PostMapping(value = "/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, Depart depart) {
		// tạo biến để khi lưu xong xuất ra thông báo
		String msg = "New depart inserted!";
		// nếu đã updated (>0)
		// note: nếu là lần đầu tiên chạy thì id sẽ null nên sẽ báo lỗi ==> set !=null
		if (depart.getId() != null && depart.getId() > 0) {
			msg = "The depart updated!";
		}

		// gọi phthuc save bên Service
		departService.save(depart);
		model.addAttribute(depart); // cho phép hiển thị lại thông tin vừa add
		model.addAttribute("message", msg); // addAtribute sau khi đã saveOrUpdate thành công
		return "departs/addOrEdit";
	}

	// tìm kiếm Depart trong DB
	@GetMapping(value = "/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Integer id) {
		// đầu tiên tìm id cần sửa
		Optional<Depart> optDapart = departService.findById(id); // xác định xem tìm thấy hay k
		if (optDapart.isPresent()) { // nếu có giá trị
			model.addAttribute("depart", optDapart.get());
		} else {
			// ngược lại không có giá trị
			return list(model);
		}

		return "departs/addOrEdit";
	}

	// delete
	@GetMapping(value = "/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Integer id) {
		// đầu tiên kiểm tra thông tin user nhập vào có chính xác k
		departService.deleteById(id);
		return list(model); // gọi lại pthuc list để hiển thị lại
	}

	// tìm kiếm tên theo dạng 'LIKE'
	// defaultValue = "": nghĩa là mặc định tham số truyền vào sẽ là rỗng khi lần
	// đầu chạy ==> ko xảy ra lỗi
	@GetMapping(value = "/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		// B1: Gọi pthuc thư viện làm sẵn ==> trả về danh sách kết quả tìm kiếm
		List<Depart> list = departService.findByNameLikeOrderByName(name);
		// B2: Thêm vào model, sau đó qua view sẽ lấy nó ra để hiển thị
		model.addAttribute("departs", list);

		return "departs/list"; // return về trang find (view)
	}

}
