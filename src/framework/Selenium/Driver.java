package framework.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Driver {

    public static WebDriver Instance;
    public static String baseAddress = "http://localhost:8080/";

    static WebDriver getInstance() {
        if (Instance == null)
        {
            Instance = new FirefoxDriver();
            return Instance;
        }
        return Instance;
    }

    public static void Initialize()
    {
        Instance = new FirefoxDriver();
        TurnOnWait();
    }

    public static void waita(Long time) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS));
    }

    public static void noWait(Action action)
    {
        TurnOffWait();
        action.perform();
        TurnOnWait();
    }

    private static void TurnOffWait()
    {
        Instance.manage().timeouts().implicitlyWait(0, SECONDS);
    }

    private static void TurnOnWait()
    {
        Instance.manage().timeouts().implicitlyWait(5, SECONDS);
    }

    public static void close()
    {
        Instance.close();
    }
}
