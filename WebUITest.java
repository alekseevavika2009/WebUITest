package WebUI;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class WebUITest {

    String userLogin = "standard_user";
    String password = "secret_sauce";

    @BeforeAll
    public static void setUp() {
        open("https://www.saucedemo.com/");
    }

    @Test
    public void LoginTest(){
        $(".login_logo").shouldHave(text("Swag Labs"));
        $("#user-name").setValue(userLogin);
        $("#password").setValue(password);
        $("#login-button").click();
        $(".title").shouldBe(visible).shouldHave(text("Products"));

        sleep (3000);
    }

    @Test
    public void AddToCard(){
        SelenideElement item = $x("//div[@class='inventory_item'][1]");
        item.shouldBe(visible);

        SelenideElement itemName = $("#item_4_title_link");
        itemName.$(".inventory_item_name").shouldHave(text("Sause Labs Backpack"));
    }

}
