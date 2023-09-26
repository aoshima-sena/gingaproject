package jp.co.ginga.spring.base.step3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Step3Controller {

	@GetMapping("/step3")
	public String createIndexGet() {
	    return "step3/index.html";
	}

}
