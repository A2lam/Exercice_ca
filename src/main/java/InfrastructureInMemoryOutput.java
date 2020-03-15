public class InfrastructureInMemoryOutput implements DomainIOutput
{
    private String output = "";

    @Override
    public void send(String message)
    {
        this.output += message;
    }

    @Override
    public String getValue()
    {
        return this.output;
    }
}
