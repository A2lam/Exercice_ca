import java.time.LocalDateTime;

public class InfrastructureLocalDateTime implements DomainIClock
{
    private LocalDateTime now;

    LocalDateTime getNow()
    {
        if (null == this.now)
            this.now = LocalDateTime.now();

        return this.now;
    }

    void setNow(LocalDateTime now)
    {
        this.now = now;
    }

    @Override
    public int getHour()
    {
        return this.getNow().getHour();
    }

    @Override
    public void setHour(int hour)
    {
        LocalDateTime newNow = this.getNow();
        newNow = LocalDateTime.of(newNow.getYear(), newNow.getMonth(), newNow.getDayOfMonth(), hour, newNow.getMinute(), newNow.getSecond());
        this.setNow(newNow);
    }
}
