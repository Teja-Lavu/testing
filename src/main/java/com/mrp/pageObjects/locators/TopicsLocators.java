package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopicsLocators {

	@FindBy(xpath = "//a[@href='/mvp/admin/topics']/span")
    public static WebElement btnTopics;	
	
	@FindBy(xpath = "//button[text()='Create Subscription']")
    public static WebElement btnCreateSubsciption;	
	
	@FindBy(xpath = "//h2[text()='Subscribe to New Topics']")
    public static WebElement lblSubsciptionPopup;	

	@FindBy(xpath = "//button[text()='Subscribe']")
    public static WebElement btnSubscribe;	
	
	@FindBy(xpath = "//button[text()='Cancel']")
    public static WebElement btnCancel;	
	
	@FindBy(xpath = "//label/span/following-sibling::div/div/div[2]")
    public static WebElement drpDownTopic;	
	
	@FindBy(xpath = "//*[@id=\"modal\"]/div/div/div[3]/div[2]/div[1]/label/div/div[2]/div/div")
	public static List<WebElement> listTopic;
	
	@FindBy(xpath = "//*[@id='modal']/div/div/div[3]/div[2]/div[1]/label/div/div[2]/div")
    public static WebElement listdrpDownTopic;	

	@FindBy(xpath = "//div[text()='Account Management']")
    public static WebElement selectTopic;	

	@FindBy(xpath = "//h2[text()='A new topic subscription has been created!']")
    public static WebElement mdlCreatedSubs;
	
	@FindBy(xpath = "//button[text()='Close Window']")
    public static WebElement btnCloseWindow;
	
	@FindBy(xpath = "//h1[text()='Account Management']")
    public static WebElement lblAccountManagement;
	
	@FindBy(xpath = "//div[text()='Accounts Payable']")
    public static WebElement selectTopicAccountsPayable;	
	
	@FindBy(xpath = "//div[text()='Accounts Receivable']")
    public static WebElement selectTopicAccountsReceivable;	
	
	@FindBy(xpath = "//div[text()='Anti-Virus']")
    public static WebElement selectTopicAntiVirus;	
	
	@FindBy(xpath = "//div[text()='ABM' or text()='App Dev']")
    public static WebElement selectTopicABM;	
	
	@FindBy(xpath = "//h1[text()='ABM']")
    public static WebElement lblABM;
	
	@FindBy(xpath = "//h1[text()='Accounts Payable']")
    public static WebElement lblAccountsPayable;
	
	@FindBy(xpath = "//h1[text()='Accounts Receivable']")
    public static WebElement lblAccountsReceivable;
	
	@FindBy(xpath = "//h1[text()='Anti-Virus']")
    public static WebElement lblAntiVirus;
	
	@FindBy(xpath = "//div[text()='App Dev']")
    public static WebElement selectTopicAppDev;	
	
	@FindBy(xpath = "//h1[text()='App Dev']")
    public static WebElement lblAppDev;
	
	@FindBy(xpath = "//h1[text()='ABM']/following-sibling::div/button")
    public static WebElement btnThreeDots;
	
	@FindBy(xpath = "//h1[text()='Account Management']/following-sibling::div/button")
    public static WebElement btnThreeDotsAM;
	
	@FindBy(xpath = "//h1[text()='Accounts Payable']/following-sibling::div/button")
    public static WebElement btnThreeDotsAP;
	
	@FindBy(xpath = "//h1[text()='Accounts Receivable']/following-sibling::div/button")
    public static WebElement btnThreeDotsAR;
	
	@FindBy(xpath = "//h1[text()='Anti-Virus']/following-sibling::div/button")
    public static WebElement btnThreeDotsAV;
	
	@FindBy(xpath = "//h1[text()='App Dev']/following-sibling::div/button")
    public static WebElement btnThreeDotsAD;
	
	@FindBy(xpath = "//button[text()='Unsubscribe']")
    public static WebElement btnUnsubscribe;

	@FindBy(xpath = "//h2[text()='Are you sure you want to unsubscribe from Accounts Payable?']")
    public static WebElement mdlUnsubscribe;
	
	@FindBy(xpath = "//h2[text()='Are you sure you want to unsubscribe from ABM?']")
    public static WebElement mdlUnsubscribeABM;
	
	@FindBy(xpath = "//h2[text()='Are you sure you want to unsubscribe from App Dev?']")
    public static WebElement mdlUnsubscribeAppDev;
	
	@FindBy(xpath = "//button[text()='Cancel']/following-sibling::button[text()='Unsubscribe']")
    public static WebElement btnmdlUnsubscribe;

	@FindBy(xpath = "//h1[text()='Topic Subscription']")
    public static WebElement lblTopicSubscription;
	
	@FindBy(xpath = "//h2[text()='You have successfully unsubscribed.']")
    public static WebElement mdlUnSubscriptionSuccess;
	
	@FindBy(xpath = "//a[text()='click here.']")
    public static WebElement linkClickHere;

}
