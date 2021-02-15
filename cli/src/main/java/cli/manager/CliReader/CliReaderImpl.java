package cli.manager.CliReader;

import java.io.InputStream;
import java.util.Scanner;

public class CliReaderImpl implements CliReader {

    private Scanner scanner;

    public CliReaderImpl(InputStream inputStream) {
        scanner = new Scanner(inputStream).useDelimiter("\\s");
    }

    @Override
    public String readCommand() {
        return scanner.next();
    }
}
