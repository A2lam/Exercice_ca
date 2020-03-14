public class DomainApplication
{
    private DomainIOutput output;


    public DomainApplication(DomainIOutput output)
    {
        this.output = output;
    }

    public void run(String name)
    {
        if ((DomainApplicationTime.getNow().getHour() >= 6) && (DomainApplicationTime.getNow().getHour() < 12))
        {
            this.output.send("Good morning " + name);
            return;
        }
        else if ((DomainApplicationTime.getNow().getHour() >= 12) && (DomainApplicationTime.getNow().getHour() < 20))
        {
            output.send("Good afternoon " + name);
            return;
        }

        output.send("Good night " + name);
    }
}
