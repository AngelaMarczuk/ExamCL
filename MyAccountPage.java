import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private final WebDriver driver;


    @FindBy(xpath = "//a[contains(text(), 'Addresses')]")
    private WebElement myAddressesLink;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToMyAddressesPage() {
        myAddressesLink.click();
    }
}