package stepDefinations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class stepDefination extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver=initializeDriver();
    }
    @And("^Navigate \"([^\"]*)\" site$")
    public void navigate_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    @And("^Click on the Login link in home page to land on Secure sign in page$")
    public void click_on_the_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		l.getLogin().click();
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys(strArg1);
		lp.getpassword().sendKeys(strArg2);
		lp.getLogIn().click();
    }

    @Then("Verify that user is Succesfully logged in")
    public void verify_that_user_is_succesfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("Succesfully click on login button");
    }

    

    

}