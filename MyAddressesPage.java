import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAddressesPage {
    private final WebDriver driver;


    @FindBy(xpath = "//a[contains(@data-link-action, 'add-address')]")
    private WebElement newAddressBtn;

    @FindBy(xpath = "//h1[contains(text(), 'Your addresses')]")
    private List<WebElement> addresses;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean addressIsVisible() {
        return !addresses.isEmpty();
    }

    public void addNewAddress() {
        newAddressBtn.click();
    }

    public void removeAddresses() {
        for (WebElement address : addresses) {
            address.findElement(By.xpath("//a[contains(@data-link-action, 'delete-address')]")).click();
            driver.switchTo().alert().accept();
        }
    }
}
