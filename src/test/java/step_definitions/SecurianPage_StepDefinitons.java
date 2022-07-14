package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SecurianPage;

public class SecurianPage_StepDefinitons {

    SecurianPage securianPage = new SecurianPage();

    @Given("user is on the securian pre_retirment calculator page")
    public void user_is_on_the_securian_pre_retirment_calculator_page() throws InterruptedException {
        securianPage.verifySecurianCalculatorPage();
    }

    @Then("user enters required fields: {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_required_fields(String current_age, String retirement_age, String current_income,
                                            String current_total_savings, String current_annual_savings, String savings_increase_rate){
        securianPage.enterRequiredFields(current_age, retirement_age,
                current_income, current_total_savings, current_annual_savings, savings_increase_rate );
    }
    @Then("user clicks on calculate and verify for submission")
    public void user_clicks_on_calculate_and_verify_for_submission(){
        securianPage.verifyCalculatorResults();
    }
    @Then("user enters additional security field: {string}")
    public void user_enters_additional_security_field(String social_security_override){
        securianPage.additionalSecurityField(social_security_override);
    }
    @Then("user enters all fields: {string}")
    public void user_enters_all_fields(String spouse_income){
        securianPage.enterAllfields(spouse_income);
    }

    @Then("user updates default calculator values: {string}, {string}, {string}, {string}, {string}")
    public void user_updates_default_calculator_values(String additional_income, String retirement_duration, String retirement_annual_income,
                                                       String pre_retirement_roi, String post_retirement_roi){
        securianPage.updateDefaultCalculatorValues(additional_income,retirement_duration,retirement_annual_income,
                pre_retirement_roi, post_retirement_roi);
    }
}
