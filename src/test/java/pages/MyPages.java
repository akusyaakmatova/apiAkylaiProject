package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyPages {




        WebDriver driver;

        public MyPages() {
            this.driver = Driver.driversSetUp("chrome");
            PageFactory.initElements(driver, this);
        }
        @FindBy(xpath = "//input[@id='user_login']")
        public WebElement login;
        @FindBy(xpath = "//input[@id='user_pass']")
        public WebElement password;
        @FindBy(xpath = "//input[@id='wp-submit']")
        public WebElement signInButton;
        @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")
        public WebElement postsLink;
        @FindBy(xpath = "//a[@class='page-title-action']")
        public WebElement addNewPost;
        @FindBy(className = "editor-post-title__input")
        public WebElement addPostText;
        @FindBy(xpath = "//button[@class='components-button editor-post-publish-panel__toggle is-button is-primary']")
        public WebElement publishPost;
        @FindBy(xpath = "//button[@class='components-button editor-post-publish-button is-button is-primary']")
        public WebElement publishPostVerify;





    }


