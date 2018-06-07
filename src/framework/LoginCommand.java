package framework;

import framework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginCommand {
    private String username;
    private String password;


    public LoginCommand(String username)
    {
        this.username = username;
    }

    public LoginCommand usingPassword(String password)
    {
        this.password = password;
        return this;
    }

    public void login()
    {
        WebElement loginInput = Driver.Instance.findElement(By.id("user_login"));
        loginInput.sendKeys(username);

        WebElement passwordInpiut = Driver.Instance.findElement(By.id("user_pass"));
        passwordInpiut.sendKeys(password);

        WebElement loginButton = Driver.Instance.findElement(By.id("wp-submit"));
        loginButton.click();

    }
}
