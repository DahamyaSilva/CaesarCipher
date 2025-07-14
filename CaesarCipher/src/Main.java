import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the cipher text: ");
        String cipherText = scanner.nextLine();

        System.out.println("Enter the known word: ");
        String knownWord = scanner.nextLine();

        String result = Decipher.decipher(cipherText, knownWord);
        System.out.println(result);

    }
}
