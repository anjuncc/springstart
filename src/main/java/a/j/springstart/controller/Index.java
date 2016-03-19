/**
 * 
 */
package a.j.springstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
}
