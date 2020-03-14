public class InfrastructureConsoleOutput implements DomainIOutput
{
    @Override
    public void send(String message)
    {
        System.out.println(message);
    }
}
