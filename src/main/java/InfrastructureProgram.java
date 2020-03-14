public class InfrastructureProgram
{
    public static void main(String[] args)
    {
        String name = args.length > 0 ? args[0] : "World";

        DomainApplication app = new DomainApplication(new InfrastructureConsoleOutput());
        app.run(name);
    }
}
