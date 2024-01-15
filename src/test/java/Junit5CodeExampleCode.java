import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Junit5CodeExampleCode {

    private String firstSampleJUnitCodeExample = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";

    private String secondSampleJUnitCodeExample = "class Tests {\n" +
            "  @RegisterExtension \n" +
            "  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();\n" +
            "\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";

    @Test
    void softAssertionsPageCheck() {
        open("https://github.com/selenide/selenide/wiki");
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").closest("h4").sibling(0).shouldHave(text(firstSampleJUnitCodeExample));
        $("#user-content-3-using-junit5-extend-test-class").closest("h4").sibling(2).shouldHave(text(secondSampleJUnitCodeExample));
    }

}