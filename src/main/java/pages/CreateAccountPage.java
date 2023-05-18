package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAccountPage {

    private final Page createAccountPage;
    private static final String FIRST_NAME = "input#firstName";
    private static final String LAST_NAME = "input#lastName";
    private static final String EMAIL = "input#email";
    private static final String PHONE = "input#phone";
    private static final String PASSWORD = "input#fld-p1";
    private static final String CONFIRM_PASSWORD = "input#reenterPassword";
    private static final String VALIDATION_MESSAGE = "span.c-input-error-message";
    private static final String RECOVERY_PHONE = "input#is-recovery-phone";

    public  CreateAccountPage(Page page){
        this.createAccountPage = page;
    }

    public void createAccount(){
        createAccountPage.locator(FIRST_NAME).fill("Praveena");
        createAccountPage.locator(LAST_NAME).fill("P Kumar");
        createAccountPage.locator(EMAIL).fill("test@test.com");
        createAccountPage.locator(PHONE).fill("123‑456‑7890");
        createAccountPage.locator(PASSWORD).fill("Password@123");
        createAccountPage.locator(CONFIRM_PASSWORD).fill("Password@123");
        assertThat(createAccountPage.locator(VALIDATION_MESSAGE)).containsText("Your passwords match!", new LocatorAssertions.ContainsTextOptions().setTimeout(30000));
        createAccountPage.locator(RECOVERY_PHONE).check();
    }

}
