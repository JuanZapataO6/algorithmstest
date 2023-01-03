import java.sql.Array;
import java.text.CollationElementIterator;
import java.time.LocalDate;
import java.util.*;

public class App {

    //Invertir una Cadena
    private void m1InvertString (String text){
        /*String[] array = text.split("");
        //String reverseWord="";
        //this class it's better because their mutability
        StringBuilder reverseWord = new StringBuilder();
        for (int i = array.length-1; i >=0 ; i--) {
            //Without string builder
            //reverseWord = reverseWord+ array[i];
            reverseWord.append(array[i]);
        }
        System.out.println(reverseWord);*/
        //Since Java 5 with specials functions the language
        String newWord = new StringBuilder(text).reverse().toString();
        System.out.println(newWord);
    }
    //Verify if a number is capicua
    private boolean m2IsCapicua (int number){
        String numberText = String.valueOf(number);
        System.out.println(numberText);
        String reverseNumber = new StringBuilder(numberText).reverse().toString();
        System.out.println(reverseNumber);
        if (numberText.equals(reverseNumber)){
            System.out.println("Is Capicua");
            return true;
        }
        else {
            System.out.println("No is Capicua");
            return false;
        }
    }
    //
    private void m3CounterCharacterItems (String text){
        int listAscii[] = new int[256];
        for (int i = 0; i < text.length(); i++) {
            listAscii[text.charAt(i)]++;
        }
        for (int j = 0; j < 256; j++) {
            if(listAscii[j] != 0){
                System.out.println((char)j + ": " + listAscii[j]);
            }
        }
    }
    private void m4FindRepeatItem(String text){
        int listAscii[] = new int[256];
        for (int i = 0; i < text.length(); i++) {
            listAscii[text.charAt(i)]++;
        }
        for (int j = 0; j < 256; j++) {
            if(listAscii[j] > 1){
                System.out.println((char)j + ": " + listAscii[j]);
            }
        }
    }
    private boolean m5IsMultipleOf2(int number){
        if(number % 2 == 0){
            System.out.println("Is Multiple");
            return true;
        }
        else {
            System.out.println("No is multiple");
            return false;
        }

    }
    public void m6IsLeapYear (int year){
        System.out.println(LocalDate.of(year,1,1).isLeapYear());
    }
    public void m7RandomOrderString (String text){
        String[] array = text.split("");
        List<String> list =Arrays.asList(array);
        Collections.shuffle(list);
        for (String i : list) System.out.print(i);
        System.out.println();

    }
    public void m8GetOnlyNotDuplicatesList(List<Integer> list){
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println(set);
    }
    public void m9CheckIfVowelIsPresent (String text){
        String[] array =text.split("");
        boolean vowelIsPresent = false;
        for (String s:array) {
            if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")) {
                vowelIsPresent = true;
            }
        }
        System.out.println(vowelIsPresent);
    }
    public void m10IsPalindrome(String text){
        boolean isPalindrome = true;
        String textWithoutSpaces = text.replaceAll(" ","");
        textWithoutSpaces = textWithoutSpaces.toLowerCase();
        //System.out.println(textWithoutSpaces);
        //String[] array = text.split("");
        int length = textWithoutSpaces.length();
        for (int i = 0; i < length/2 ; i++) {
            if(textWithoutSpaces.charAt(i) != textWithoutSpaces.charAt(length-1-i)){
                isPalindrome = false;
            }
        }
        System.out.println(isPalindrome);
    }
    public void findCharacterictis(float width, float height, float lenght, float mass){
        //enum 1=bulky 2=
        int count =0;
        final int MAX_CENTIMETERS = 150;
        final int MAX_KILOGRAMS = 20;
        final int MAX_VOLUMEN = 1000000;
        float volume=0;
        volume = width*height*lenght;
        if (width>= MAX_CENTIMETERS || height>=MAX_CENTIMETERS || lenght>=MAX_CENTIMETERS || volume>= MAX_VOLUMEN) {
            count++;
        }
        if (mass >= MAX_KILOGRAMS){
            count ++;
        }
        switch (count){
            case 0:
                System.out.println("STANDARD");
                break;
            case 1:
                System.out.println("SPECIAL");
                break;
            case 2:
                System.out.println("REJECTED");
                break;
        }
    }
    public List<Integer> requestInformationVector (){
        int quantity=0;
        int count=0;
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Please Insert the numbers of values: ");
        Scanner inScanner = new Scanner(System.in);
        quantity = inScanner.nextInt();
        do {
            count++;
            System.out.println("Please Insert the value number "+ count + ":");
            numbers.add(inScanner.nextInt());
        }
        while (count<quantity);
        return(numbers);
    }
    public int m11FindValueCloseZero(List<Integer> vectorIn){
        if (vectorIn.isEmpty()) {
            return(0);
        }
        else {
            int numberToZero=vectorIn.get(0);
            for (int i = 1; i < vectorIn.size()-1; i++) {
                if(Math.abs(numberToZero)>Math.abs(vectorIn.get(i))){
                    numberToZero=vectorIn.get(i);
                }
            }
            return (vectorIn.contains(Math.abs(numberToZero))?Math.abs(numberToZero):numberToZero);
        }
    }
    public int m12SmallerInterval(List<Integer> vectorIn){
        Collections.sort(vectorIn);
        int valueLower;
        int valueUpper;
        List<Integer> interval = new ArrayList<>();
        System.out.println(vectorIn);
        for (int i = 0; i <vectorIn.size()-1; i++) {
            valueLower =vectorIn.get(i);
            System.out.println("VL: "+ valueLower);
            for (int j =i+1; j < vectorIn.size(); j++) {
                valueUpper = vectorIn.get(j);
                System.out.println("VU: "+ valueUpper);
                if((valueLower<0 && valueUpper<0)||(valueLower>0 && valueUpper>0)){
                    interval.add(Math.abs(Math.abs(valueLower)- Math.abs(valueUpper)));
                    System.out.println("1: " + interval);
                }
                else {
                    if(valueLower<=0){
                        interval.add(Math.abs(valueLower)+ valueUpper);
                        System.out.println("2: " + interval);
                    }
                    else {
                        interval.add(Math.abs(valueUpper)+valueLower);
                        System.out.println("3: " + interval);
                    }
                }
            }
        }
        Collections.sort(interval);
        return interval.get(0);
    }

    public static void main(String[] args) {
        App app = new App();
        //app.m1InvertString("Juan Pablo");
        //System.out.println(app.m2IsCapicua(525));
        //app.m3CounterCharacterItems("Juan PabloJuanPablo ");
        //app.m4FindRepeatItem("JuanPablo");
        //System.out.println(app.m5IsMultipleOf2(2));
        //app.m6IsLeapYear(2018);
        //app.m7RandomOrderString("Juan Pablo");
        //app.m8GetOnlyNotDuplicatesList(Arrays.asList(1,2,3,45,0));
        //app.m9CheckIfVowelIsPresent("JuanPablo");
        //app.m10IsPalindrome("dabale arroz a la zorra el abad");

        //System.out.println(app.requestInformationVector());

        //System.out.println(app.m11FindValueCloseZero(app.requestInformationVector()));
        System.out.println(app.m12SmallerInterval(Arrays.asList(5,-1,2,3)));
        /*float width = 0;
        float height =0;
        float lenght =0;
        float mass = 0;
        float volume = 0;*/
        //int valueResult=0;
        /*
        /*width = inScanner.nextFloat();
        System.out.println("Please Insert the height in centimeters: ");
        height = inScanner.nextFloat();
        System.out.println("Please Insert the lenght in centimeters: ");
        lenght = inScanner.nextFloat();
        System.out.println("Please Insert the mass in kilograms: ");
        mass = inScanner.nextFloat();
        app.findCharacterictis(width,height,lenght,mass);
        /*volume = width*height*lenght;
        System.out.println(width);
        System.out.println(height);
        System.out.println(lenght);
        System.out.println(mass);
        System.out.println(volume);*/


    }
}
