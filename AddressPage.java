import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

    private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

     @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;

   @FindBy(id = "field-id_country")
    private WebElement countryInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(name = "submitAddress")
    private WebElement submitBtn;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterAddressData(String alias, String address, String city, String postalCode, String country, String phone) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        cityInput.clear();
        cityInput.sendKeys(city);

        countryInput.clear();
        countryInput.sendKeys(country);

        phoneInput.clear();
        phoneInput.sendKeys(phone);

        submitBtn.click();
    }
}

