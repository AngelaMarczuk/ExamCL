import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {
    private final WebDriver driver;
    @FindBy(name = "email")
    private WebElement loginEmailInput;
    @FindBy(name = "password")
    private WebElement loginPasswdInput;
    @FindBy(id = "submit-login")
    private WebElement loginBtn;
    public AuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);
        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(password);
        loginBtn.click();
    }
}