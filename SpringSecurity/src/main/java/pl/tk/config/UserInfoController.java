package pl.tk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//Zadanie 8 - przed ostatnie w starszej wersji prezentacji
@Controller
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName() {
        return userService.currentUserName();
    }

}
