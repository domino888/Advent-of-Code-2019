package pl.kanthak;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        readLineFromConsole(integerList);

        for (int i = 0; i < integerList.size(); i += 4){
            switch (integerList.get(i)) {
                case 1: {
                     integerList.get(integerList.get(i+3)) =  integerList.get(integerList.get(i+1)) + integerList.get(integerList.get(i+2));

                }
                case 2: //pomnoz;
                case 99: //end
            }
        }
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
