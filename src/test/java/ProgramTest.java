import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class ProgramTest
{
    private ByteArrayOutputStream getWriterAndSetConsole()
    {
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        System.setErr(new PrintStream(newConsole));
        return newConsole;
    }

    @Test
    public void goldenMaster_with_all_defaults()
    {
        DomainApplicationTime.setNow(LocalDateTime.now());
        ByteArrayOutputStream console = getWriterAndSetConsole();
        InfrastructureProgram.main(new String[]{});
        String consoleOutput = console.toString();

        assertEquals("Good night World\n", consoleOutput);
    }

    @Test
    public void refactored_should_return_morning_in_the_morning_with_defaults()
    {
        DomainApplicationTime.setNow(LocalDateTime.of(2020, 3, 10, 10, 0, 0));
        ByteArrayOutputStream console = getWriterAndSetConsole();
        InfrastructureProgram.main(new String[]{});
        String consoleOutput = console.toString();

        assertEquals("Good morning World\n", consoleOutput);
    }

    @Test
    public void refactored_should_return_morning_in_the_morning_with_name()
    {
        DomainApplicationTime.setNow(LocalDateTime.of(2020, 3, 10, 10, 0, 0));

        InMemoryOutput inMemoryOutput = new InMemoryOutput();
        DomainApplication app = new DomainApplication(inMemoryOutput);
        app.run("Toto");
        String result = inMemoryOutput.getValue();

        assertEquals("Good morning Toto", result);
    }
}

class InMemoryOutput implements DomainIOutput
{
    private String output = "";

    String getValue()
    {
        return output;
    }

    @Override
    public void send(String message)
    {
        output += message;
    }
}
