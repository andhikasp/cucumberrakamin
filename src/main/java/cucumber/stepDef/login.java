package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;



public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("halaman login saucedemo")
    public void halaman_login_saucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //assert
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
//        Assert.assertEquals(loginPageAssert),actual "Swag Labs");

    }

    @When("user input username")
    public void userInputARegisteredUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }


    @And("user input password")
    public void userInputRegisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }


    @Then("user tap login button")
    public void userTapLoginButton()  {
        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        driver.findElement(By.id("login-button")).click();

    }

    @Then("user direct to dashboard page")
    public void userDirectToDashboardPage() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]"));
        driver.close();
    }


    @And("user invaliid input password")
    public void userInvaliidInputPassword() {
        driver.findElement(By.id("password")).sendKeys("123455");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {

        driver.findElement(By.xpath(" //*[@id=\"login_button_container\"]/div/form/div[3]"));
        driver.close();
    }
}
