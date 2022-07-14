package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class SecurianPage {

    public WebDriver webDriver = Driver.get();

    /*
    This method is used to verify user is on the retirement calculator page
     */
    public void verifySecurianCalculatorPage() {
        webDriver.get("https://www.securian.com/insights-tools/retirement-calculator.html");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//h2[contains(text(),'Pre-retirement calculator')]")).isDisplayed();
    }

    /*
    This method is used to submit the required fields in the retirement calculator form
     */
    public void enterRequiredFields(String current_age, String retirement_age, String current_income,
                                    String current_total_savings, String current_annual_savings, String savings_increase_rate ){
        webDriver.findElement(By.id("current-age")).sendKeys(current_age);
        webDriver.findElement(By.id("retirement-age")).sendKeys(retirement_age);
        webDriver.findElement(By.id("current-income")).sendKeys(current_income);
        webDriver.findElement(By.id("current-total-savings")).sendKeys(current_total_savings);
        webDriver.findElement(By.id("current-annual-savings")).sendKeys(current_annual_savings);
        webDriver.findElement(By.id("savings-increase-rate")).sendKeys(savings_increase_rate);
    }

    /*
    This method is used to submit the additional security fields in the retirement calculator form
    */
    public void additionalSecurityField(String social_security_override){
        webDriver.findElement(By.id("yes-social-benefits")).click();
        webDriver.findElement(By.id("social-security-override")).sendKeys(social_security_override);
    }

    /*
    This method is used to submit the optional fields in the retirement calculator form
    */
    public void enterAllfields(String spouse_income){
        webDriver.findElement(By.id("spouse-income")).sendKeys(spouse_income);
    }

    /*
    This method is used to update the default values of the retirement calculator
    */
    public void updateDefaultCalculatorValues(String additional_income, String retirement_duration, String retirement_annual_income,
                                              String pre_retirement_roi, String post_retirement_roi){
        webDriver.findElement(By.xpath("//a[contains(text(),'Adjust default values')]")).click();
        webDriver.findElement(By.id("additional-income")).sendKeys(additional_income);
        webDriver.findElement(By.id("retirement-duration")).sendKeys(retirement_duration);
        webDriver.findElement(By.id("retirement-annual-income")).sendKeys(retirement_annual_income);
        webDriver.findElement(By.id("pre-retirement-roi")).sendKeys(pre_retirement_roi);
        webDriver.findElement(By.id("post-retirement-roi")).sendKeys(post_retirement_roi);

        webDriver.findElement(By.xpath("//button[contains(text(),'Save changes')]")).click();
    }

    /*
    This method is used to click on the Calculate button and verify results are displayed
    */
    public void verifyCalculatorResults(){
        webDriver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).click();
        webDriver.findElement(By.xpath("//h3[contains(text(),'Results')]")).isDisplayed();
    }
}
