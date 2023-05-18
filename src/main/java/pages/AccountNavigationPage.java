package pages;

import com.microsoft.playwright.Page;

public class AccountNavigationPage{
    private final Page accountNavigationPage;
    private static final String ACCOUNT_BUTTON = "//button//*[text()='Account']";
    private static final String ACCOUNT_LINKS_TEMPLATE = "//a[text()='%s']";

    public AccountNavigationPage(Page page){
        this.accountNavigationPage = page;
    }

    public void navigateTo(AccountEntries location){
        accountNavigationPage.locator(ACCOUNT_BUTTON).click();
        accountNavigationPage.locator(String.format(ACCOUNT_LINKS_TEMPLATE, location.getDisplayName())).click();
    }

}
