package cli.manager;

import cli.manager.CliReader.CliReader;
import cli.manager.CliWriter.CliWriter;

import cli.manager.CliWriter.CliWriterImpl;
import cli.manager.CliReader.CliReaderImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CliManager {
    public static CliWriter getWriter(OutputStream outputStream) {
        return new CliWriterImpl(new BufferedOutputStream(outputStream));
    }

    public static CliReader getReader(InputStream inputStream) {
        return new CliReaderImpl(new BufferedInputStream(inputStream));
    }
}
