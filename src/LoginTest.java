import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("In Before Class");
        initialise(this);
    }

    @AnnotBL
    public HomeBL homeBL;

    @AnnotBL
    public AccountsBL accountsBL;


    @Test
    public void Test1()
    {
        homeBL.homePage.BtnLogin.tap();
        homeBL.accountPage.BtnJourney.tap();
        accountsBL.accountPage.BtnViewProfile.tap();
    }
}
