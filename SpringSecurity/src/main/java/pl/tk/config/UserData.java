package pl.tk.config;

import java.util.List;

//Zadanie 4
public class UserData {

    private String name;
    private String password;
    private List<String> authorities;

    public UserData(String name, String password, List<String> authorities) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public List<String> getAuthorities() {
        return authorities;
    }

}


