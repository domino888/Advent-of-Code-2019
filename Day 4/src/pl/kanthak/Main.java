package pl.kanthak;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Character[]> passwordsList = new ArrayList<>();
        String passwordText;
        Character[] password;


        for (Integer i = 256310; i < 732736; i++) {
            passwordText = i.toString();
            password = new Character[6];
            for (int j = 0; j < 6; j++) {
                password[j] = passwordText.charAt(j);
            }
            passwordsList.add(password);
        }
        for (Character[] characters : passwordsList) {
            for (Character character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }


    }
}