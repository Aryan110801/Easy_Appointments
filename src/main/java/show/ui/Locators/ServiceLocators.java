package show.ui.Locators;

public class ServiceLocators {
    public static final String Services = "//a[normalize-space()='Services']";
    public static final String Add = "//button[@id='add-service']";
    public static final String Name = "//input[@id='service-name']";
    public static final String Duration = "//input[@id='service-duration']";
    public static final String Price = "//input[@id='service-price']";
    public static final String Currency = "//input[@id='service-currency']";
    public static final String Category = "//select[@id='service-category']";
    public static final String Select_Category = "//select[@id='service-category']//option[contains(text(),'Lesson Plans')]";
    public static final String Availabilities = "//select[@id='service-availabilities-type']";
    public static final String Availability_Type = "//select[@id='service-availabilities-type']//option[@value='flexible']";
    public static final String Attendants = "//input[@id='service-attendants-number']";
    public static final String Location = "//input[@id='service-location']";
    public static final String Description = "//textarea[@id='service-description']";
    public static final String Save = "//button[@id='save-service']";
    public static final String Cancel = "//button[@id='cancel-service']";
}
