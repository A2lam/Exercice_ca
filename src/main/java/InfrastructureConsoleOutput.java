public class InfrastructureConsoleOutput implements DomainIOutput
{
    private String message;

    @Override
    public void send(String message)
    {
        this.message = message;
        System.out.println(message);
    }

    @Override
    public String getValue()
    {
        return this.message;
    }
}
