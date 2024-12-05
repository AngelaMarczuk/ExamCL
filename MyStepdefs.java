
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStepdefs {
    private WebDriver driver;

    @Given("I am logged in as a user with email {string} and password {string}")
    public void iAmLoggedInAsAUserWithEmailAndPassword(String email, String password) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        AuthPage authPage = new AuthPage(driver);
        authPage.loginAs(email, password);
        driver.navigate().back();
    }

    @When("I navigate to the addresses section")
    public void iNavigateToTheAddressesSection() {
        driver.get("https://prod-course.coderslab.com/index.php?controller=address");
    }

    @And("I create a new alias {string} address {string} city {string} postal code {string} country {string} phone {string}")
    public void iCreateANewAliasAddressCityPostalCodeCountryPhone(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {

        driver.findElement(By.id("field-alias")).sendKeys(arg0);
        driver.findElement(By.id("field-address1")).sendKeys(arg1);
        driver.findElement(By.id("field-city")).sendKeys(arg2);
        driver.findElement(By.id("field-postcode")).sendKeys(arg3);
        driver.findElement(By.id("field-id_country")).sendKeys(arg4);
        driver.findElement(By.id("field-phone")).sendKeys(arg5);
    }

    @And("I save the new address")
    public void iSaveTheNewAddress() {
        driver.findElement((By.cssSelector("button.btn.btn-primary.form-control-submit.float-xs-right[type='submit']"))).click();
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        List<WebElement> elements = driver.findElements(By.cssSelector("a[data-link-action='edit-address']"));
        WebElement lastElement = elements.get(elements.size() - 1);
        lastElement.click();
    }

    @And("I verify new alias {string} address {string} city {string} postal code {string} country {string} phone {string}")
    public void iVerifyNewAliasAddressCityPostalCodeCountryPhone(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        verifyField("field-alias", arg0);
        verifyField("field-address1", arg1);
        verifyField("field-city", arg2);
        verifyField("field-postcode", arg3);
//        verifyField("field-id_country", arg4);
        verifyField("field-phone", arg5);
    }

    private void verifyField(String fieldId, String expectedValue) {
        WebElement element = driver.findElement(By.id(fieldId));
        String received = element.getAttribute("value");
        Assertions.assertTrue(received.contains(expectedValue), "Expected: " + expectedValue + ", but got: " + received);
    }

    @And("Go to control address page")
    public void goToControlAddressPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
    }

    @And("I delete address")
    public void iDeleteAddress() {
        List<WebElement> elements = driver.findElements(By.cssSelector("a[data-link-action='delete-address']"));
        if (!elements.isEmpty()) {
            WebElement lastElement = elements.get(elements.size() - 1);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            lastElement.click();
        } else {
            throw new NoSuchElementException("No elements found");
        }
    }
}