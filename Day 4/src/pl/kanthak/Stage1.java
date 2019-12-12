package pl.kanthak;

public class Stage1 {

    public static void main(String[] args) {

        boolean isDouble = false;       // isDouble=true;    to meet the conditions
        int compareNumber = 0;           // compareNumber=5   to meet the conditions
        int howManyPasswords = 0;

        for (int i = 256310; i <= 732736; i++) {
            String password = Integer.toString(i);

            for (int j = 1; j < password.length(); j++) {
                if (password.charAt(j - 1) <= password.charAt(j)) {
                    if (password.charAt(j - 1) == password.charAt(j)) {
                        isDouble = true;
                    }
                    compareNumber++;
                }
                if (compareNumber == 5 && isDouble) {
                    howManyPasswords++;
                }
            }
            isDouble = false;
            compareNumber = 0;
        }
        System.out.println(howManyPasswords);
    }
}
