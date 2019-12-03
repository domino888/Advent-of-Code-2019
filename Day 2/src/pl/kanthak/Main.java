package pl.kanthak;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        readLineFromConsole(integerList);
        integerList.stream()
                .forEach(System.out::println);
    }

    public static void readLineFromConsole(List<Integer> integerList) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] lineWithoutCommas = line.trim().split(",");

        for (String number : lineWithoutCommas) {
            integerList.add(Integer.parseInt(number));
        }
    }
}
