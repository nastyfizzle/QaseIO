package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class TextArea {

    String label;
    String textAreaLocator = "//label[text()='%s']/ancestor::div[contains(@class,'form-group')]";
    //"//*[text()='%s']/parent::div//*[contains(@class, 'empty-node')]";
    //"//label[text()='%s']/ancestor::div[contains(@class,'form-group')]";

    public TextArea(String label) {
        this.label = label;
    }

    public void write(String textAreaLocator, String text) {
        $x(String.format(textAreaLocator, label)).sendKeys(text);
    }
}
