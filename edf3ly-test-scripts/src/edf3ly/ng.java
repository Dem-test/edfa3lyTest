package edf3ly;
import org.testng.annotations.Test;
/*
 * To run the code, Enter "driverPath", and "browser"*/
public class ng extends allParameters{
	public static steps s;
  @Test
  public void neededParams() {
      driverPath="D:\\chromedriver_win32\\chromedriver.exe";  //chrome path
//	  driverPath="E:\\automation\\geckoDriver\\geckodriver.exe"; //firefox
	  browser="chrome"; //the avilable options are "firefox" or "chrome"
	  edf3lyURL="https://www.edfa3ly.com/cart";// edf3ly shopping cart
	  s=new steps();
  }
  //opening browser
  @Test(dependsOnMethods= {"neededParams"})
  public void launchBrowser() {
	  s.launchingbrowser();
	  
  }
  @Test(dependsOnMethods= {"launchBrowser"})
  public void edf3lyOpenning() {
	 s.OpenCart();
  }
  @Test(dependsOnMethods= {"edf3lyOpenning"})
  public void buyProduct() {
//	  String[] productArr= {"https://www.nike.com/t/air-max-deluxe-se-mens-shoe-TLtmJ0/AO8284-001"};
	  String[] productArr= {"http://www.amazon.com/dp/B01DBGVB7K/ref=twister_dp_update?ie=UTF8&psc=1","http://www.amazon.com/dp/B06XK2SVFP/ref=twister_dp_update?ie=UTF8&psc=1","https://www.nike.com/t/air-max-deluxe-se-mens-shoe-TLtmJ0/AO8284-001"};
	  String[] colorArr= {"4GB RAM | 16GB Storage","Black/White - Anthracite",""};
	  String[] sizeArr= {"","6 W US",""};
	  String[] quanArr= {"4","2",""};
	  s.addproduct(productArr, colorArr, sizeArr, quanArr);
	  
  }
}
