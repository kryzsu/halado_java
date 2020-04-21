package hu.kry.robotweb.controller.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private static final String SESSION_COUNTER_NAME = "sessionCounter";
	private static final String LOCAL_COUNTER_NAME = "localCounterValue";
	private static final String COOKIE_COUNTER_NAME = "cookieCounter";

	@GetMapping()
	public ModelAndView main(@CookieValue(value = "cookieCounter", defaultValue = "0") String cookieCounter,
			HttpSession httpSession) {
		return new ModelAndView("counter")
				.addObject("counterValue", counterValue)
				.addObject(LOCAL_COUNTER_NAME, 0)
				.addObject(COOKIE_COUNTER_NAME, cookieCounter)
				.addObject(SESSION_COUNTER_NAME,
						httpSession.getAttribute(SESSION_COUNTER_NAME) != null ?
								httpSession.getAttribute(SESSION_COUNTER_NAME) : 0
				);
	}

	@PostMapping()
	public ModelAndView mainPost(@RequestParam(name = "action") String operation,
			@RequestParam(name = LOCAL_COUNTER_NAME) Integer localCounterValue,
			@CookieValue(value = COOKIE_COUNTER_NAME, defaultValue = "0") String cookieCounter,
			HttpServletResponse response,
			HttpSession httpSession) {

		counterValue = determineActualValue(counterValue, operation);
		localCounterValue = determineActualValue(localCounterValue, operation);
		Integer cookieCounterInt = determineActualValue(Integer.parseInt(cookieCounter), operation);

		Integer sessionCounter =
				determineActualValue((Integer) httpSession.getAttribute(SESSION_COUNTER_NAME), operation);

		response.addCookie(new Cookie(COOKIE_COUNTER_NAME, cookieCounterInt.toString()));
		httpSession.setAttribute(SESSION_COUNTER_NAME, sessionCounter);

		return new ModelAndView("counter")
				.addObject("counterValue", counterValue)
				.addObject(LOCAL_COUNTER_NAME, localCounterValue)
				.addObject(COOKIE_COUNTER_NAME, cookieCounterInt)
				.addObject(SESSION_COUNTER_NAME, sessionCounter);
	}

	private Integer determineActualValue(Integer value, String operation) {
		if (value == null) {
			value = 0;
		}

		if ("+".equals(operation)) {
			value++;
		} else if ("-".equals(operation)) {
			value--;
		} else {
			value = 0;
		}

		return value;
	}

}
