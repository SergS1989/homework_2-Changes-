import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesHandler {
    private final File file;
    private final String filName;

    public FilesHandler(String fileName) {
        this.file = new File(fileName);
        this.filName = fileName;
    }

    public void writeToFile(String data) throws MyException {
        try {
            Files.write(Paths.get(filName), data.getBytes(), StandardOpenOption.CREATE);
        } catch (FileNotFoundException e) {
            throw new MyException("Файл не найден " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            throw new MyException("Файл уже существует " + e.getMessage());
        } catch (IOException e) {
            throw new MyException("Ошибка ввода вывода " + e.getMessage());
        }
    }

    public String readFromFile() throws MyException {
        StringBuilder result = new StringBuilder();
        try {
            result.append(Files.readString(Paths.get(filName)));
        } catch (IOException e) {
            throw new MyException("Ошибка ввода вывода " + e.getMessage());
        }
        return result.toString();
    }
}
