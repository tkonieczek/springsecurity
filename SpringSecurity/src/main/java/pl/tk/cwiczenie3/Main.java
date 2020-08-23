package pl.tk.cwiczenie3;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Zadanie 3 - zaszyfrowanie haseł
public class Main {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String marian12345 = bCryptPasswordEncoder.encode("marian12345");
        String mariola123 = bCryptPasswordEncoder.encode("mariola123");
        String admin = bCryptPasswordEncoder.encode("admin");
        System.out.println(marian12345);
        System.out.println(mariola123);
        System.out.println(admin);
    }
}
