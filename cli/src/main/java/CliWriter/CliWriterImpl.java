package CliWriter;

import java.io.OutputStream;
import java.io.PrintWriter;

public class CliWriterImpl implements CliWriter{
    private PrintWriter printWriter;

    public CliWriterImpl(OutputStream outputStream){
        printWriter = new PrintWriter(outputStream);
    }

    @Override
    public void writeMessage(String message) {
        printWriter.println(message);
    }

    @Override
    public void flush() {
        printWriter.flush();
    }
}
