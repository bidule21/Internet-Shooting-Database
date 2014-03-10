package net.vl0w.isd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {

	@RequestMapping("/event")
	@ResponseBody
	public String event(
			@RequestParam(value = "name", required = true) String name) {
		return name;
	}
}
