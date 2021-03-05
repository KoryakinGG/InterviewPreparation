package ru.koryaking.eigthhomework;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class MainController {

   @GetMapping("/")
   public String main () {
       return "index";
   }

   @GetMapping("/authenticated")
    public String authenticatedPage (Principal principal) {
//       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//       System.out.println(Thread.currentThread().getName());
//       String out = String.format("authenticated user: %s, password: %s", principal.getName(),"-");
       return "security";
   }

    @GetMapping("/authenticated/manager")
    public String managerPage() {
        return "manager";
    }

    @GetMapping("/authenticated/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/authenticated/user")
    public String userPage() {
        return "user";
    }


}
