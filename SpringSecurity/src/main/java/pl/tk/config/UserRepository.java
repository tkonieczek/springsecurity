package pl.tk.config;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Do zadania 4
@Component
public class UserRepository  {


    private Map<String, UserData> usersMap;

    public UserRepository() {
        usersMap = new HashMap<>();
        List<String> mariolaAuthorities = new ArrayList<>();
        mariolaAuthorities.add("USER");
        usersMap.put("mariola", new UserData("mariola","{noop}mariola123", mariolaAuthorities));
        List<String> marianAuthorities = new ArrayList<>();
        marianAuthorities.add("USER");
        usersMap.put("marian", new UserData("marian","{noop}marian12345", marianAuthorities));
        List<String> adminAuthorities = new ArrayList<>();
        adminAuthorities.add("USER");
        adminAuthorities.add("ADMIN");
        usersMap.put("admin", new UserData("admin","{noop}admin", adminAuthorities));
    }

    public UserData getUserByName(String userName) {
        return usersMap.get(userName);
    }

}


