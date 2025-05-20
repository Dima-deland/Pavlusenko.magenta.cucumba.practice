package steps;

import components.ChangePassword;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.ConfigurationReader;
import utils.DriverFactory;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

public class Hooks {
    public Hooks(TestContext context) {
        this.context = context;
    }

    private final TestContext context;
    Scenario scenario;
    private static int testCounter = 14;

    @Before
    public void before(Scenario scenario) throws MalformedURLException, URISyntaxException {

        context.driver = DriverFactory.get(scenario);
        long duration = Long.parseLong(ConfigurationReader.get("timeout"));
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(duration));
        context.action = new Actions(context.driver);
        this.scenario = scenario;

        // the following code changes name for  parametrized tests in Allure report
        Allure.getLifecycle().updateTestCase(t -> t.setName(scenario.getName()));


        //the following code set cookies
        context.driver.get(ConfigurationReader.get("url") + "/pub/static/version1695896754/frontend/Magento/luma/en_US/Magento_Theme/favicon.ico");

        String script = "(function setCookiesAndLocalStorage() {" + "document.cookie = 'addtl_consent=1~; path=/; SameSite=Lax';" + "document.cookie = 'euconsent-v2=CQRgQAAQRgQAAAKA8AENBrFgAAAAAEPgABCYAAAWZABMNCogjLIgBCJQMIIEACgrCAigQBAAAkDRAQAmDApyBgAusJEAIAUAAwQAgABBgACAAASABCIAKACgQAAQCBQABgAQDAQAMDAAGACwEAgABAdAxTAggECwASMyKDTAlAASCAlsqEEgCBBXCEIs8AggREwUAAAIABQAAIDwWAxJICViQQBcQTQAAEAAAUQIECKTswBBQGbLUXgyfRlaYBg-YJmlMAyAIgjIyTYhN-0w8chRAAAA.YAAAAAAAAAAA; path=/; SameSite=Lax';" + "document.cookie = 'IABGPP_HDR_GppString=DBABMA~CQRiDM-QRiDM-AKA8AENBrFgAAAAAEPgABCYAAAWZABMNCogjLIgBCJQMIIEACgrCAigQBAAAkDRAQAmDApyBgAusJEAIAUAAwQAgABBgACAAASABCIAKACgQAAQCBQABgAQDAQAMDAAGACwEAgABAdAxTAggECwASMyKDTAlAASCAlsqEEgCBBXCEIs8AggREwUAAAIABQAAIDwWAxJICViQQBcQTQAAEAAAUQIECKTswBBQGbLUXgyfRlaYBg-YJmlMAyAIgjIyTYhN-0w8chRAAAA.YAAAAAAAAAAA; path=/; SameSite=Lax';" +

                "localStorage.setItem('gbc_consent', JSON.stringify([" + "{\"id\":1,\"defaultValue\":\"GRANTED\",\"selected\":false}," + "{\"id\":2,\"defaultValue\":\"GRANTED\",\"selected\":false}," + "{\"id\":3,\"defaultValue\":\"GRANTED\",\"selected\":false}," + "{\"id\":4,\"defaultValue\":\"GRANTED\",\"selected\":false}," + "{\"id\":5,\"defaultValue\":\"GRANTED\",\"selected\":false}," + "{\"id\":6,\"defaultValucde\":\"GRANTED\",\"selected\":false}," + "{\"id\":7,\"defaultValue\":\"GRANTED\",\"selected\":false}" + "]));" + "localStorage.setItem('gdpr_encoding_modes', 'TCF_AND_GPP');" + "localStorage.setItem('_cmpRepromptHash', 'CQRgQAAQRgQAAAKA8AENBrFgAAAAAEPgABCYAAAWZABMNCogjLIgBCJQMIIEACgrCAigQBAAAkDRAQAmDApyBgAusJEAIAUAAwQAgABBgACAAASABCIAKACgQAAQCBQABgAQDAQAMDAAGACwEAgABAdAxTAggECwASMyKDTAlAASCAlsqEEgCBBXCEIs8AggREwUAAAIABQAAIDwWAxJICViQQBcQTQAAEAAAUQIECKTswBBQGbLUXgyfRlaYBg-YJmlMAyAIgjIyTYhN-0w8chRAAAA.YAAAAAAAAAAA.1.jjXiZplvqkcl8hSvn6qOuA==');" + "localStorage.setItem('_gbcAcceptanceState', 'Reject');" + "localStorage.setItem('qc-cmp2-persistent-link-clicked', 'false');" + "localStorage.setItem('_acceptanceState', 'Reject');" + "})();";
        ((JavascriptExecutor) context.driver).executeScript(script);
    }

    @After
    public void after(Scenario scenario) {
        if (context.driver != null) {
            context.driver.quit();
            this.scenario = scenario;
        }
        if (scenario.isFailed()) System.out.println("Test failed: " + scenario.getName() + "😢");
        else System.out.println("Test finished successfully : " + scenario.getName() + " 🏎️💨🏁🎉");
        if (testCounter > 1) System.out.println(--testCounter + " tests are pending ⏳ 🙄");
    }

    @After("@RevertNameAfterTest")
    public void afterRevertInfo() {
        MyAccountPage myAccountPage = new MyAccountPage(context);
        myAccountPage
                .clickEditLink()
                .fillFirstNameInputField("Dima").fillLastNameInputField("De").clickSaveButton();
    }

    @After("@RevertPassAfterTest")
    public void afterRevertPassword() {
        LoginPage loginPage = new LoginPage(context);
        loginPage.fillEmailField("pavlusenko.de.cp@gmail.com").fillPasswordField("New" + ConfigurationReader.get("password")).clickSignInButton();
        MyAccountPage myAccountPage = new MyAccountPage(context);
        myAccountPage.clickChangePasswordLink();
        ChangePassword changePassword = new ChangePassword(context);
        changePassword.fillCurrentPasswordField("New" + ConfigurationReader.get("password")).fillNewPasswordField(ConfigurationReader.get("password")).fillConfirmationPasswordField(ConfigurationReader.get("password"));
        myAccountPage.clickSaveButton();
    }


}
