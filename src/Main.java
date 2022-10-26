import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String string = "Дорога була дуже довгою";
        getWords(string);
        String word = "grattitude";
        getLettersChange(word);
        System.out.println("Введіть рядок: ");
        String string2 = new Scanner(System.in).nextLine();
        System.out.println("Кількість слів з латинських літер: " + getLatinWordsCount(string2));
        System.out.println("Кількість слів з цифр: " + getNumberWordsCount(string2));
        System.out.println("Паліндром: " + getPalindrome(string2));
    }
    //Задано рядок, що складається з кількох слів. Вивести на консоль слова з рядка, що складаються з 4 літер.
    private static void getWords(String str) {
        System.out.println("Cлова з 4 літер: ");
        String[] words = str.split(" ");
        for (String word : words) {
            if (word.length() == 4) {
                System.out.println(word);
            }
        }
    }
    //Замінити всі символи латинського алфавіту у слові на відповідні символи російського алфавіту.
    private static void getLettersChange(String word) {
        word = word.replaceAll("a", "е");
        word = word.replaceAll("b", "б");
        word = word.replaceAll("c", "(ц|с)");
        word = word.replaceAll("d", "д");

        if (word.endsWith("e")) {
            word = word.replace("e", "");
        } else word = word.replaceAll("e", "(и|э)");

        word = word.replaceAll("f", "ф");
        word = word.replaceAll("g", "г");
        word = word.replaceAll("h", "х");
        word = word.replaceAll("i", "(и|ай)");
        word = word.replaceAll("j", "дж");
        word = word.replaceAll("k", "к");
        word = word.replaceAll("l", "л");
        word = word.replaceAll("m", "м");
        word = word.replaceAll("n", "н");
        word = word.replaceAll("o", "о");
        word = word.replaceAll("p", "п");
        word = word.replaceAll("q", "кв");
        word = word.replaceAll("r", "р");
        word = word.replaceAll("s", "с");
        word = word.replaceAll("t", "т");
        word = word.replaceAll("u", "(у|ю)");
        word = word.replaceAll("v|w", "в");
        word = word.replaceAll("x", "кс");
        word = word.replaceAll("y", "(и|ай)");
        word = word.replaceAll("z", "з");

        System.out.println(word);
    }
    //Ввести n слів із консолі. Знайти кількість слів, що містять лише символи латинського алфавіту.
     private static int getLatinWordsCount (String str) {
         boolean flag = false;
         int counter = 0;
         String[] words = str.split(" ");
         for (String word : words) {
             for (int i = 0; i < word.length(); i++) {
                 if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'  || word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                     flag = true;
                 }
                 else
                     flag = false;
             }
             if(flag)
                 counter++;
         }
         return counter;
     }
    //Ввести n слів із консолі. Знайти кількість слів, які містять лише цифри.
    private static int getNumberWordsCount (String str) {
        boolean flag = false;
        int counter = 0;
        String regex = "\\d+";
        String[] words = str.split(" ");
        for (String word : words) {

            if(word.matches(regex)) {
                flag = true;
            }
            else
                flag = false;

            if(flag)
                counter++;
        }
        return counter;
    }
    //Ввести n слів із консолі. Серед слів, що складаються лише з цифр, знайти слово-паліндром.
    public static String getPalindrome(String str) {
        boolean flag1 = false;
        boolean flag2 = false;
        int i, j;
        String regex = "\\d+";
        String palindrome = "";
        String[] words = str.split(" ");
        for (i = 0; i < words.length; i++) {
            for (j = 0; j < words[i].length(); j++) {
                if (words[i].matches(regex)) {
                    flag1 = true;
                } else
                    flag1 = false;
            }
            if (flag1) {
                int left = 0, right = words[i].length() - 1;
                while (left < right) {
                    if (words[i].charAt(left) != words[i].charAt(right)) {
                        i++;
                        flag2 = true;
                    }
                    left++;
                    right--;
                }
                if (flag2) {
                    palindrome = words[i];
                }
            }
        }
        return palindrome;
    }
}
