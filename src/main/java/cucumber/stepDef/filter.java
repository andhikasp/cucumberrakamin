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

public class filter {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";






    @Given("the user is logged into the SauceDemo")
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


    @When("the user click filter")
    public void theUserClickFilter() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();

    }

    @And("the user selects name z to a")
    public void theUserSelectsNameZToA() {

        driver.findElement(By.xpath("*//*[@value=\"za\"]")).click();
    }

    @Then("the user will see the all product title filtered from z to a")
    public void theUserWillSeeTheAllProductTitleFilteredFromZToA() {
        String productpage =  driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
        Assert.assertEquals(productpage, "Test.allTheThings() T-Shirt (Red)");
        driver.close();
    }

    @And("the user selects low to high")
    public void theUserSelectsLowToHigh() {
        driver.findElement(By.xpath("*//*[@value=\"lohi\"]")).click();
    }

    @Then("the user will see the all product title filtered from low to high")
    public void theUserWillSeeTheAllProductTitleFilteredFromLowToHigh() {
        String productpage =  driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(productpage, "$7.99");
        driver.close();
    }

    @And("the user selects high to low")
    public void theUserSelectsHighToLow() {

        driver.findElement(By.xpath("*//*[@value=\"hilo\"]")).click();
    }

    @Then("the user will see the all product title filtered from high to low")
    public void theUserWillSeeTheAllProductTitleFilteredFromHighToLow() {
        String productpage =  driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(productpage, "$49.99");
        driver.close();


    }
}
