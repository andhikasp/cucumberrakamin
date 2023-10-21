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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class addtocart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is logged into the SauceDemo")
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

    @When("the user click some product")
    public void theUserClickSomeProduct() {

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        //asert
        String item1 =  driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(item1, "Sauce Labs Backpack");

        String price1 =  driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(price1, "$29.99");


    }

    @And("user click cart")
    public void userClickCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
    }

    @Then("the user will see information about product selected")
    public void theUserWillSeeInformationAboutProductSelected() {
        //asert
        String item1 =  driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(item1, "Sauce Labs Backpack");

        String price1 =  driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(price1, "$29.99");
        driver.close();
    }
}
