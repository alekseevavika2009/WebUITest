package WebUI;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static jdk.internal.misc.ThreadFlock.open;

public class WebUITest {

    String userLogin = "standart_user";
    String password = "secret_sauce";

    @BeforeAll
    public static void setUp() {
        open("https://www.saucedemo.com/");
    }

    @Test
    public void LoginTest(){
        $(".login_logo").shouleHave(text("Swag Labs"));
        $("user-name").setValue(userLogin);
        $("password").setValue(password);
        $("#login-button").click();
        $(".title").shouldBe(visible).shouldHave(text("Products"));

        sleep (3000);
    }

    @Test
    public void AddToCard() {
        SelenideElement item = $x("//*[@id=\"inventory_container\"]/div/div[1]");
        item.shouldBe(visible);

        SelenideElement itemName = $("#item_4_title_link");
        itemName.$(".inventory_item_name").shouldHave(text("Sauce Labs Backpack"));


    }
}
