package cli.shellComponents;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class InitShellCommands {

    @ShellMethod("Add two integers")
    public int add(int a, int b){
        return a + b;
    }
}
