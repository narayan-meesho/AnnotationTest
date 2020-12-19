public class Button {

    String locatorName;

    String locator;

    public Button(String locatorName,String locator)
    {
        this.locator = locator;
        this.locatorName = locatorName;
    }

    public void tap()
    {
        System.out.println("Tapping Button "+locatorName+", with locator: "+locator);
    }
}
