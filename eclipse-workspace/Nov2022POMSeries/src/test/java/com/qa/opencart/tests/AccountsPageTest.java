package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetUP() {
		accPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@Test
	public void accPageTitleTest() {
		String actTitle=accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void accPageURLTest() {
		String actURL=accPage.getAccPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTIONVALUE));
	}
	
	@Test
	public void LogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void SearchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	@Test
	public void accPageHeadersListTest() {
		List<String> actualAccPageHeadersList=accPage.getAccountsPageHeadersList();
		
		System.out.println("accounts page header list:"+actualAccPageHeadersList);
		Assert.assertEquals(actualAccPageHeadersList.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
		
	}
	
	@Test
	public void accPageHeadersValueTest() {
		
		List<String> actualAccPageHeadersList=accPage.getAccountsPageHeadersList();
		System.out.println("Actual Acc Page Headers List :"+actualAccPageHeadersList);
		
		Assert.assertEquals(actualAccPageHeadersList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
		
		
	}
	@Test
	public void searchProductCountTest() {
		searchPage=accPage.performSearch("Macbook");
		Assert.assertTrue(searchPage.getSearchProductsCount()>0);
		
	}

}
