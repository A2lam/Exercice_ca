class DomainApplication
{
    private DomainIOutput output;
    private DomainIClock clock;

    DomainApplication(DomainIClock clock, DomainIOutput output)
    {
        this.clock = clock;
        this.output = output;
    }

    void run(String name)
    {
        if ((this.clock.getHour() >= 6) && (this.clock.getHour() < 12))
        {
            this.output.send("Good morning " + name);
            return;
        }
        else if ((this.clock.getHour() >= 12) && (this.clock.getHour() < 20))
        {
            this.output.send("Good afternoon " + name);
            return;
        }

        this.output.send("Good night " + name);
    }
}
