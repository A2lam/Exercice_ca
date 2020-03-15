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
        ByteArrayOutputStream console = this.getWriterAndSetConsole();
        InfrastructureProgram.main(new String[]{});
        String consoleOutput = console.toString();

        assertEquals("Good night World\n", consoleOutput);
    }

    /*
    Ce n'est plus possible d'appeler le programme par défaut avec ApplicationTime
    car maintenant le temps est une abstraction et ne fait plus partie du domaine.

    @Test
    public void refactored_should_return_morning_in_the_morning_with_defaults()
    {
        DomainApplicationTime.setNow(LocalDateTime.of(2020, 3, 10, 10, 0, 0));
        ByteArrayOutputStream console = getWriterAndSetConsole();
        InfrastructureProgram.main(new String[]{});
        String consoleOutput = console.toString();

        assertEquals("Good morning World\n", consoleOutput);
    }*/

    @Test
    public void refactored_should_return_afternoon_in_the_afternoon_with_name()
    {
        InfrastructureLocalDateTime localDateTime = new InfrastructureLocalDateTime();
        InfrastructureInMemoryOutput inMemoryOutput = new InfrastructureInMemoryOutput();

        localDateTime.setNow(LocalDateTime.of(2020, 3, 20, 18, 0, 0));

        DomainApplication app = new DomainApplication(localDateTime, inMemoryOutput);
        app.run("Toto");
        String result = inMemoryOutput.getValue();

        assertEquals("Good afternoon Toto", result);
    }

    @Test
    public void refactored_should_return_morning_in_the_morning_with_name()
    {
        InfrastructureLocalDateTime localDateTime = new InfrastructureLocalDateTime();
        InfrastructureInMemoryOutput inMemoryOutput = new InfrastructureInMemoryOutput();

        localDateTime.setNow(LocalDateTime.of(2020, 3, 10, 10, 0, 0));

        DomainApplication app = new DomainApplication(localDateTime, inMemoryOutput);
        app.run("Toto");
        String result = inMemoryOutput.getValue();

        assertEquals("Good morning Toto", result);
    }
}
