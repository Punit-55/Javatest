package com.testsigma.automator.actions.web.generic;

import com.testsigma.automator.actions.ElementAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GetSelectedOptionsFromListAction extends ElementAction {
  private static final String SUCCESS_MESSAGE_WITH_DATA = "Below are the selected options in list::<br>%s";

  @Override
  protected void execute() throws Exception {
    StringBuffer sb = new StringBuffer();
    findElement();
    Select selElement = new Select(getElement());
    List<WebElement> options = selElement.getAllSelectedOptions();
    for (WebElement opt : options) {
      sb.append(opt.getText());
      sb.append("<br>");
    }
    setSuccessMessage(String.format(SUCCESS_MESSAGE_WITH_DATA, sb));
  }
}
