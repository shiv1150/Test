package com.jet.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jet.qa.base.baseClass;

public class HomePageFlights extends baseClass {
	@FindBy(id="OneWay")
	WebElement OneWay;
	
	@FindBy(id="RoundTrip")
	WebElement RoundTrip;
	
	@FindBy (id="TripPlanner")
	WebElement MultiCity;
	
	@FindBy (xpath="//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")
	WebElement DepartureCity;
	
	@FindBy (xpath="//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT']")
	WebElement ArrivalCity;
	
	@FindBy (xpath="//input[@id='custom_date_picker_id_1']")
	WebElement Date;
	
	@FindBy (xpath="//div[@id='divpaxinfo']")
	WebElement NoOfPassengers;
	
	@FindBy (xpath="//select[contains(@id,'ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency')]")
	WebElement Currency;
	
	@FindBy (xpath="//input[contains(@id,'ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit')]")
	WebElement SubmitButton;
	
	@FindBy (xpath="//input[contains(@id,'custom_date_picker_id_2')]")
	WebElement ReturnDate;
	
	@FindBy (xpath="//a[contains(@text,'Adampur (AIP)')]")
	WebElement FromCity;
	
	@FindBy (xpath="//a[contains(@text,'Delhi (DEL)')]")
	WebElement ToCity;
	
	public HomePageFlights()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	public BookingFlightPage ValidateBookingFlightPage()
	{
		if(OneWay.isSelected())
		{
			DepartureCity.click();
			FromCity.click();
			ToCity.click();
			String dateValue="31/08";
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0],setAttribute('value','"+dateValue+"');",Date);
			
		}
		
		return new BookingFlightPage();
		
	}

}
