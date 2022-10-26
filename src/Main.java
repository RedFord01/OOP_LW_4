import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String string = "������ ���� ���� ������";
        getWords(string);
        String word = "grattitude";
        getLettersChange(word);
        System.out.println("������ �����: ");
        String string2 = new Scanner(System.in).nextLine();
        System.out.println("ʳ������ ��� � ���������� ����: " + getLatinWordsCount(string2));
        System.out.println("ʳ������ ��� � ����: " + getNumberWordsCount(string2));
        System.out.println("��������: " + getPalindrome(string2));
    }
    //������ �����, �� ���������� � ������ ���. ������� �� ������� ����� � �����, �� ����������� � 4 ����.
    private static void getWords(String str) {
        System.out.println("C���� � 4 ����: ");
        String[] words = str.split(" ");
        for (String word : words) {
            if (word.length() == 4) {
                System.out.println(word);
            }
        }
    }
    //������� �� ������� ����������� ������� � ���� �� ������� ������� ���������� �������.
    private static void getLettersChange(String word) {
        word = word.replaceAll("a", "�");
        word = word.replaceAll("b", "�");
        word = word.replaceAll("c", "(�|�)");
        word = word.replaceAll("d", "�");

        if (word.endsWith("e")) {
            word = word.replace("e", "");
        } else word = word.replaceAll("e", "(�|�)");

        word = word.replaceAll("f", "�");
        word = word.replaceAll("g", "�");
        word = word.replaceAll("h", "�");
        word = word.replaceAll("i", "(�|��)");
        word = word.replaceAll("j", "��");
        word = word.replaceAll("k", "�");
        word = word.replaceAll("l", "�");
        word = word.replaceAll("m", "�");
        word = word.replaceAll("n", "�");
        word = word.replaceAll("o", "�");
        word = word.replaceAll("p", "�");
        word = word.replaceAll("q", "��");
        word = word.replaceAll("r", "�");
        word = word.replaceAll("s", "�");
        word = word.replaceAll("t", "�");
        word = word.replaceAll("u", "(�|�)");
        word = word.replaceAll("v|w", "�");
        word = word.replaceAll("x", "��");
        word = word.replaceAll("y", "(�|��)");
        word = word.replaceAll("z", "�");

        System.out.println(word);
    }
    //������ n ��� �� ������. ������ ������� ���, �� ������ ���� ������� ����������� �������.
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
    //������ n ��� �� ������. ������ ������� ���, �� ������ ���� �����.
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
    //������ n ��� �� ������. ����� ���, �� ����������� ���� � ����, ������ �����-��������.
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
