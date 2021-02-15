package bootstrap;

import CliReader.CliReader;
import CliWriter.CliWriter;

import java.io.Console;
import java.io.IOException;

public class CommandLineStarter {
    public static void main(String[] args) {
        CliWriter cliWriter = CliManager.getWriter(System.out);
        CliReader cliReader = CliManager.getReader(System.in);
        startInteractiveCli(cliWriter, cliReader);
    }

    private static void startInteractiveCli(CliWriter cliWriter, CliReader cliReader) {
        cliWriter.writeMessage("Welcome to the Personal-Architect project.");
        cliWriter.writeMessage("Please select appropriate number/option:");
        cliWriter.writeMessage("       (1) Create new project");
        cliWriter.writeMessage("       (2) Analyze existing project");
        cliWriter.flush();


        String input = cliReader.readCommand();
        cliWriter.writeMessage("You have chosen: " + input);
    }
}
