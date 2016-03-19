/**
 * 
 */
package a.j.springstart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author anjun
 *
 */
@Controller
@RequestMapping("/index")
public class Index {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "this a index/index");
		return "welcome";
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String init(@ModelAttribute("model") ModelMap model) {
		List<String>carList =new ArrayList<>();
		carList.add("test");
		carList.add("test2");
		carList.add("test3");
		model.addAttribute("carList", carList);
		return "index";
	}
}
