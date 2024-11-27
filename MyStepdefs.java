
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyStepdefs {
    private WebDriver driver;
    private MyAddressesPage myAddressesPage;


    @Given("I am logged in as a user with email {string} and password {string}")
    public void iAmLoggedInAsAUserWithEmailAndPassword(String email, String password) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        AuthPage authPage = new AuthPage(driver);
        authPage.loginAs(email, password);
//        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
        driver.navigate().back();
    }

    @When("I navigate to the addresses section")
    public void iNavigateToTheAddressesSection() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToMyAddressesPage();
        myAddressesPage = new MyAddressesPage(driver);
        driver.get("https://prod-course.coderslab.com/index.php?controller=address");
    }

    @And("I create a new alias {word} address {word} city {word} postal code {word} country {word} phone {word}")
    public void iCreateANewAliasAliasAddressAddressCityCityPostalCodePostalCodeCountryCountryPhonePhone(String alias, String address, String postalCode, String city, String country, String phone) {
        AddressPage newAddressPage = new AddressPage(driver);
        newAddressPage.enterAddressData(alias, address, city, postalCode, country, phone);

    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        Assertions.assertTrue(myAddressesPage.addressIsVisible(), "Created address should be visible");
    }

    @And("I remove the address")
    public void iRemoveTheAddress() {
        myAddressesPage.removeAddresses();
    }


}