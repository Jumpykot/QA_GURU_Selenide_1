import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        $$("div.markdown-body li").findBy(text("Soft assertions")).shouldHave(text("Soft assertions"));

    }

    @Test
    void jUnitExampleCode() {

        open("https://github.com/selenide/selenide/wiki");
        $("div#wiki-content").shouldHave(text("Soft assertions"));
        $("div#wiki-content").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").closest("h4")
                .sibling(0).shouldHave(text(firstSampleJUnitCodeExample));
        $("#user-content-3-using-junit5-extend-test-class").closest("h4")
                .sibling(2).shouldHave(text(secondSampleJUnitCodeExample));

    }

}