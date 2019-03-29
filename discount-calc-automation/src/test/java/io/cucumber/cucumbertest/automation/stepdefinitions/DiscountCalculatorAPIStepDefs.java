
package io.cucumber.cucumbertest.automation.stepdefinitions;

import cucumber.api.java8.En;
import io.codecamp.cucumber.discountcalc.api.DiscountCalculator;
import org.junit.Assert;

public class DiscountCalculatorAPIStepDefs implements En {
    DiscountCalculator discountCalculator;

    public DiscountCalculatorAPIStepDefs() {
        Given("^I am a customer who is looking for a discount$", () -> {
            discountCalculator = new DiscountCalculator();
        });

        And("^My address is in \"([^\"]*)\"$", (String state) -> {
            discountCalculator.setState(state);
        });

        When("^I view my discount$", () -> {
        });

        Then("^I expect a \"([^\"]*)\" percent discount$", (String discount) -> {
            Assert.assertEquals(discount, Integer.toString(discountCalculator.calculateDiscount()));
        });

        And("^My Profession is \"([^\"]*)\"$", (String profession) -> {
            discountCalculator.setProfession(profession);
        });
    }
}
