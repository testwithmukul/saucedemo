package swaglabs.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import swaglabs.base.TestBase;

//Here we will write the login page objects/methods
public class LoginPage extends TestBase {

    //Page Factory: OR

    @FindBy(name = "user-name")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@name = 'login-button']")
    WebElement loginBtn;

    //Now initialize all above WebElements

    public LoginPage() {
        PageFactory.initElements(driver, this);     //this is current class object i.e. variables/web_elements here listed above
    }

    //Defining different "ACTIONS":

    public ProductsPage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new ProductsPage();
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }















}
