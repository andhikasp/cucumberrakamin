package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";






    @Given("the user is logged into the SauceDemo website")
    public void halaman_login_saucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        //asserthalamanlogin
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //assertdashboardpage
        String Dashboardpage =  driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]")).getText();
        Assert.assertEquals(Dashboardpage, "Swag Labs");




    }

    @When("the user clicks on the user menu")
    public void theUserClicksOnTheUserMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("the user selects {string}")
    public void theUserSelects(String arg0) {
//
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);


//        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("the user should be logged out and redirected to the login page")
    public void theUserShouldBeLoggedOutAndRedirectedToTheLoginPage() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.close();
    }
}
