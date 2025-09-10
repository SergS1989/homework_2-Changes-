import java.util.Scanner;

public class WriteReadFile {
    public static void main(String[] args) {
        System.out.println("Введите данные: ");
        String str;

        try (Scanner sc = new Scanner(System.in)) {
            str = sc.nextLine();
            FilesHandler file = new FilesHandler("test.txt");
            file.writeToFile(str);
            System.out.println("Содержимое файла: " + file.readFromFile());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
