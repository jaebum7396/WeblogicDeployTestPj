package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
	// 첫번째 오류: 0으로 나눴으므로 500 오류를 발생시킨다.
	@GetMapping("/divide")
	public String problem(Model model) {
		int result = 1 / 0;
		model.addAttribute("serverTime", result);
		return "home";
	}

	// 두 번째 오류: @PostMapping이므로 Get 방식으로 요청 시 405 오류를 발생시킨다.
	@PostMapping("/method")
	public String method(Model model) {
		return "home";
	}
}
