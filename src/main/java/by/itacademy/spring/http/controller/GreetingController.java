package by.itacademy.spring.http.controller;


import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.repository.CompanyRepository;
import by.itacademy.spring.dto.CompanyReadDto;
import by.itacademy.spring.dto.UserReadDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }


    //@RequestMapping(value = "/hello", method = RequestMethod.GET)

   /* ModelAndView mv,
    @RequestParam("age") Integer age,  // взять значение переменной
    @RequestHeader("accept") String header,
    @CookieValue("JSESSIONID") String JSessionId,
    @PathVariable("id") Integer id // если hello/id то получить эту id*/
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("user", new UserReadDto(1L, "Igor", LocalDate.now(), "Igor1337",
                "123456", Role.USER,
                new CompanyReadDto(2)));
        return "greeting/hello";
    }

    //@RequestMapping(value = "/bye", method = RequestMethod.GET)
    @GetMapping("/bye")
    public String bye(ModelAndView mv,
                            @SessionAttribute("user") UserReadDto userReadDto) {
        return "greeting/bye";
    }
}
