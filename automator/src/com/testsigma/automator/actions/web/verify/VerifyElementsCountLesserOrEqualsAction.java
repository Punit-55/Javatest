package com.testsigma.automator.actions.web.verify;

import com.testsigma.automator.formatters.NumberFormatter;
import com.testsigma.automator.actions.ElementAction;
import org.springframework.util.Assert;

public class VerifyElementsCountLesserOrEqualsAction extends ElementAction {
  private static final String SUCCESS_MESSAGE = "Successfully verified that the elements count is lesser than or equals given test data." +
    "<br>Expected:%s<br>Actual(to be greater than expected):%s";

  private static final String FAILURE_MESSAGE = "The elements count corresponding to locator <b>\"%s:%s\"</b> is greater than " +
    "expected value. <br>Expected:\"%s\" <br>Actual(To be lesser/equals than expected):\"%s\"";
  private static final String FAILURE_NOT_A_NUMBER = "Please provide a valid number in test data, given test data <b>%s</b> is not a number.";

  @Override
  protected void execute() throws Exception {
    findElement();
    double elementsSize = getElements().size();
    double expectedCount = NumberFormatter.getDoubleValue(getTestData(), String.format(FAILURE_NOT_A_NUMBER, getTestDataMaskResult()));
    Assert.isTrue((elementsSize <= expectedCount), String.format(FAILURE_MESSAGE, getFindByType(), getLocatorValue(),
      expectedCount, (int) elementsSize));
    setSuccessMessage(String.format(SUCCESS_MESSAGE, expectedCount, (int) elementsSize));
  }
}
