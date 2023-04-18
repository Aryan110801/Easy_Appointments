package show.ui.Locators;


public class CalendarLocators {
    public static final String calendar = "//a[normalize-space()='Calendar']";
    public static final String appointment = "//button[@id='insert-appointment']";
    public static final String serve = "//select[@id='select-service']";
    public static final String serve1 = "//select[@id='select-service']//option[contains(text(),'Service')]";
    public static final String provider = "//select[@id='select-provider']";
    public static final String select_provider = "//select[@id='select-provider']//option[contains(text(),'Jane Doe')]";
    public static final String fname = "//input[@id='first-name']";
    public static final String lname = "//input[@id='last-name']";
    public static final String email = "//input[@id='email']";
    public static final String phone = "//input[@id='phone-number']";
    public static final String save = "//button[@id='save-appointment']";
    public static final String close = "//button[@class='ui-button ui-corner-all ui-widget btn btn-outline-secondary']";
}
