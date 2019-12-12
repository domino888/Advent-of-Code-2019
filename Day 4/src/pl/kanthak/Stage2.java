package pl.kanthak;

public class Stage2 {

    public static void main(String[] args) {

        boolean isDouble = false;                    // isDouble=true;                      to meet the conditions
        boolean hasPasswordDoubledDigits = false;    // hasPasswordDoubledDigits = true;    to meet the conditions
        int compareNumber = 0;                       // compareNumber=5;                    to meet the conditions
        int howManyPasswords = 0;

        for (int i = 256310; i <= 732736; i++) {
            String password = Integer.toString(i);

            hasPasswordDoubledDigits = hasPasswordDoubledDigits(password);

            for (int j = 1; j < password.length(); j++) {
                if (password.charAt(j - 1) <= password.charAt(j)) {
                    if (password.charAt(j - 1) == password.charAt(j)) {
                        isDouble = true;
                    }
                    compareNumber++;
                }
                if (compareNumber == 5 && isDouble && hasPasswordDoubledDigits) {
                    howManyPasswords++;
                }
            }
            isDouble = false;
            compareNumber = 0;
        }
        System.out.println(howManyPasswords);
    }

    static boolean hasPasswordDoubledDigits(String password) {
        char[] ch = new char[password.length()];
        int[] count = new int[100];
        boolean check = false;

        for (int i = 0; i < password.length(); i++) {
            count[password.charAt(i)]++;
        }

        for (int i = 0; i < password.length(); i++) {
            ch[i] = password.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (password.charAt(i) == ch[j]) {
                    find++;
                }
            }

            if (find == 1) {
                if (count[password.charAt(i)] == 2) {
                    check = true;
                }
            }
        }
        return check;
    }
}
