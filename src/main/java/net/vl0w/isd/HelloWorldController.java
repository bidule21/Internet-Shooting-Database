package net.vl0w.isd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping("/hi")
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}
}
