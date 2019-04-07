package edf3ly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class steps extends allParameters{

	//opening specific browser according to the submitted parameters
    public void launchingbrowser() {
      
  	  if(browser=="chrome") {
  		  
  		  System.setProperty("webdriver.chrome.driver", driverPath);
  		  driver=new ChromeDriver();  		  
  		  
  	  }else if(browser=="firefox"){
  		  
  		  System.setProperty("webdriver.gecko.driver", driverPath);
  		  driver=new FirefoxDriver();
  		  
  	  }else {
  		  System.out.println("No such Browser");
  	  }
  	
    }
    //maximize browser and navigate to cart URL
    public void OpenCart() {
    	try {
    	 driver.manage().window().maximize();
   	     driver.navigate().to(edf3lyURL);
    	}catch(Exception e) {
    		System.out.println("Error when opening shopping cart: "+e);
    	}
    }
    //adding products
    public void addproduct(String product[],String color[],String size[], String quantity[]) {
    	try {
    		WebElement itemURL=driver.findElement(By.xpath("//*[@id=\"cart-basic-box\"]/div[2]/div[2]/div[2]/input")); //itemURL field
    		
    		//when trying to find itemURL with "name" this error is displayed.
    		//	WebElement itemURL=driver.findElement(By.name("url"));
    		/*Error on adding product: org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
    		  (Session info: chrome=73.0.3683.86)
    		  (Driver info: chromedriver=2.44.609538 (b655c5a60b0b544917107a59d4153d4bf78e1b90),platform=Windows NT 10.0.17763 x86_64) (WARNING: The server did not provide any stacktrace information)
    		Command duration or timeout: 0 milliseconds
    		For documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html
    		Build info: version: '3.8.0', revision: '924c4067df', time: '2017-11-30T11:36:59.109Z'
    		System info: host: 'DESKTOP-LEFNIKN', ip: '192.168.1.2', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '12'
    		Driver info: org.openqa.selenium.chrome.ChromeDriver
    		Capabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.44.609538 (b655c5a60b0b54..., userDataDir: C:\Users\Salah\AppData\Loca...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:1695}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 73.0.3683.86, webStorageEnabled: true}
    		Session ID: a7a9b39286e4db22e178967242e7e856*/
    		
    		for(int i=0;i<product.length;i++) {
    			if(i!=0) {
    				Thread.sleep(2000);
    				itemURL=driver.findElement(By.xpath("//*[@id=\"cart-basic-box\"]/div[2]/div[1]/div/input"));
    				//item url field "xpath" to be used after  sending starting from the second product
    			}

    			itemURL.sendKeys(product[i]); //entring product url
    			Thread.sleep(2000);
    			//verifying store is avilable
    			String ErrorMsg=itemURL.getAttribute("class");
	    		if("borderRadius3 fColorWhite F18 notValid engFont ng-touched ng-valid-url ng-not-empty ng-dirty ng-valid ng-valid-required errorProhibited".equals(ErrorMsg)) {
    				System.out.println("Store isn't avilable");
    				
    			}else {
    				System.out.println(ErrorMsg);
    			Thread.sleep(2000);
//    		
//    			if(itemNameValue!=null){
    				//in case of automated one
    			
    				//set color field value
    				colorField=driver.findElement(By.cssSelector("#cart-basic-box > div.RW100-mob.Pbottom40.rest > div:nth-child(6) > div:nth-child(2) > div > select"));
    				Select colorValue=new Select(colorField);
    				colorValue.selectByVisibleText(color[i]);
    				//set quantity field value
    				quantityField=driver.findElement(By.cssSelector("#categoryContainer > div.column2-12.Pleft5.Pright5.Ptop5.Pbottom5 > div > div > input"));
    				quantityField.clear();
    				quantityField.sendKeys(quantity[i]);
    				//set size field value
    				if(i==0) {
    				sizeField=driver.findElement(By.cssSelector("#product-size-text"));
    				//for the first product which is text
					sizeField.sendKeys(size[i]);
    				}else {
    					sizeField=driver.findElement(By.cssSelector("#cart-basic-box > div.RW100-mob.Pbottom40.rest > div:nth-child(6) > div:nth-child(3) > div > select"));
    					//for the second product where size is drop down list
    					Select sizeValue=new Select(sizeField);
        				sizeValue.selectByVisibleText(size[i]);
//    					System.out.println(fieldType);

    				}
//    			
//    				
//    			}else {
//    				//non automated product
//    				System.out.println("non automated: item name is empty");
//    			}
    				//click on "add" button
    			driver.findElement(By.xpath("//*[@id=\"sb-site\"]/div[1]/div[1]/div[2]/div/div[2]/form/div[2]/div/div[2]/input[1]")).click();		
    		}
    		}
    	}catch(Exception e) {
    		System.out.println("Error on adding product: "+e);
    	}
    }
    
}
