import java.time.LocalDateTime;

public class DomainApplicationTime
{
    private static LocalDateTime now;

    public static LocalDateTime getNow()
    {
        if (null == now)
            now = LocalDateTime.now();

        return now;
    }

    public static void setNow(LocalDateTime newNow)
    {
        now = newNow;
    }
}
