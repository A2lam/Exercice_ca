public class InfrastructureProgram
{
    public static void main(String[] args)
    {
        String name = args.length > 0 ? args[0] : "World";

        DomainIClock localDateTime = new InfrastructureLocalDateTime();
        DomainIOutput consoleOutput = new InfrastructureConsoleOutput();

        DomainApplication app = new DomainApplication(localDateTime, consoleOutput);
        app.run(name);
    }
}
