package hu.kry.robotweb.controller.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/counter")
public class CounterController {

	private int counterValue = 0;

	@GetMapping()
	ModelAndView main(@CookieValue(value = "cookieCounter", defaultValue = "0") String cookieCounter) {
		return new ModelAndView("counter")
				.addObject("counterValue", counterValue)
				.addObject("localCounterValue", 0)
				.addObject("cookieCounter", cookieCounter);
	}

	@PostMapping()
	ModelAndView mainPost(@RequestParam(name="action") String operation,
			@RequestParam(name="localCounterValue") Integer localCounterValue,
			@CookieValue(value = "cookieCounter", defaultValue = "0") String cookieCounter,
			HttpServletResponse response) {
		counterValue = determineActualValue(counterValue, operation);
		localCounterValue = determineActualValue(localCounterValue, operation);
		Integer cookieCounterInt = determineActualValue(Integer.parseInt(cookieCounter), operation);

		response.addCookie( new Cookie("cookieCounter", cookieCounterInt.toString()));

		return new ModelAndView("counter")
				.addObject("counterValue", counterValue)
				.addObject("localCounterValue", localCounterValue)
				.addObject("cookieCounter", cookieCounterInt);
	}

	private Integer determineActualValue(Integer value, String operation) {
		if (value == null) {
			value = 0;
		}

		if ("+".equals(operation)) {
			value++;
		} else
		if ("-".equals(operation)) {
			value--;
		} else {
			value = 0;
		}

		return value;
	}

}
