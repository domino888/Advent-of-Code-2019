package pl.kanthak;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        List<List<Character>> passwordsList = new ArrayList<>();
        List<Character> password = new ArrayList<>();
        String passwordText;
        boolean check = false;
        int counter = 0;
        int howMany = 0;

        for (int i = 256310; i < 732737; i++) {
            passwordText = Integer.toString(i);
            for (int j = 0; j < passwordText.length(); j++) {
                password.add(passwordText.charAt(j));
            }
            passwordsList.add(new ArrayList<>(password));
            password.clear();
        }

        for (List<Character> characters : passwordsList) {
            ListIterator<Character> listIterator = characters.listIterator();

            for (int i = 0; i < characters.size(); i++) {
                listIterator.next();
                if (i == characters.size() - 1) {
                    break;
                }
                if (characters.get(i) <= characters.get(listIterator.nextIndex())) {
                    if (characters.get(i) == characters.get(listIterator.nextIndex())) {
                        check = true;
                    }
                    counter++;
                }
            }
            if (counter == 5 && check) {
                howMany++;
            }
            counter = 0;
            check = false;
        }
        System.out.println(howMany);
    }
}
