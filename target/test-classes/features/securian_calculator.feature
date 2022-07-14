Feature: Securian pre-retirement calculator
  @securian
    ## Verify User should be able to submit form with all required fields filled in
  Scenario Outline: Verify form submission with required fields
    Given user is on the securian pre_retirment calculator page
    Then user enters required fields: "<current_age>", "<retirement_age>", "<current_income>", "<current_total_savings>", "<current_annual_savings>", "<savings_increase_rate>"
    Then user clicks on calculate and verify for submission

    Examples:
    |current_age|retirement_age|current_income|current_total_savings|current_annual_savings|savings_increase_rate|
    |         40|68            |100000        |500000               |500000                |10                   |

  @securian
    ## Verify Additional Social Security fields should display/hide based on Social Security benefits toggle
  Scenario Outline: Verify additional security field is displayed
    Given user is on the securian pre_retirment calculator page
    Then user enters required fields: "<current_age>", "<retirement_age>", "<current_income>", "<current_total_savings>", "<current_annual_savings>", "<savings_increase_rate>"
    Then user enters additional security field: "<social_security_override>"
    Then user clicks on calculate and verify for submission
    Examples:
      |current_age|retirement_age|current_income|current_total_savings|current_annual_savings|savings_increase_rate|social_security_override|
      |         40|68            |100000        |500000               |500000                |10                   |4000                    |

  @securian
    ## Verify User should be able to submit form with all fields filled in
  Scenario Outline: Verify form submission with all fields
    Given user is on the securian pre_retirment calculator page
    Then user enters required fields: "<current_age>", "<retirement_age>", "<current_income>", "<current_total_savings>", "<current_annual_savings>", "<savings_increase_rate>"
    Then user enters all fields: "<spouse_income>"
    Then user clicks on calculate and verify for submission
    Examples:
      |current_age|retirement_age|current_income|current_total_savings|current_annual_savings|savings_increase_rate|spouse_income |
      |         40|68            |100000        |500000               |500000                |10                   |75000         |

  @securian
    ## Verify User should be able to update default calculator values
  Scenario Outline: Verify update default calculator values
    Given user is on the securian pre_retirment calculator page
    Then user updates default calculator values: "<additional_income>", "<retirement_duration>", "<retirement_annual_income>", "<pre_retirement_roi>", "<post_retirement_roi>"
  Examples:
  |additional_income|retirement_duration|retirement_annual_income|pre_retirement_roi|post_retirement_roi|
  |1000             |20                 |500000                  |8                 |5                  |