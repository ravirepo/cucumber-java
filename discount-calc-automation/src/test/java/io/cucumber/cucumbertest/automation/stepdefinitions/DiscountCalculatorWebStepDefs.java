
package io.cucumber.cucumbertest.automation.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.codecamp.cucumber.discountcalc.api.DiscountCalculator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DiscountCalculatorWebStepDefs implements En {
    DiscountCalculator discountCalculator;
    WebDriver driver;

    public DiscountCalculatorWebStepDefs() {

        Before(() -> {
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        });

        After(() -> {
            driver.quit();
        });
        Given("^I am a customer who is looking for a discount on the website$", () -> {
            driver.get("http://localhost:51806/");
        });
        And("^My address is in \"([^\"]*)\" on the website$", (String state) -> {
            driver.findElement(By.id("MainContent_ddlState")).sendKeys(state);
        });
        When("^I view my discount on the website$", () -> {
            driver.findElement(By.id("MainContent_btnSubmit")).click();
        });
        Then("^I expect a \"([^\"]*)\" percent discount on the website$", (String discount) -> {
            Assert.assertEquals(discount, driver.findElement(By.id("MainContent_lblDiscount")).getText());
        });
    }
}
