package tdv;

import java.time.Duration;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//orden de test segun su nombre (debido a limitaciones de jUnit 4)
public class WikipediaTest {

	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setDomain() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1_cargarPagina() {
		
		driver.navigate().to("https://es.wikipedia.org/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Wikipedia, la enciclopedia libre");
	}
	
	@Test
	public void test2_logIn() {
	
		WebDriverWait cargadoPagina = new WebDriverWait(driver,  Duration.ofSeconds(1000));
		WebElement botonLogIn = (WebElement) cargadoPagina.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/nav/div/ul/li[5]/a")));
		botonLogIn.click();
		
			
		WebDriverWait cargadoUser = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement user = (WebElement) cargadoUser.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpName1")));
		user.sendKeys("Frannnnfff");
		
		WebDriverWait cargadoContraseña = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement pass = (WebElement) cargadoContraseña.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpPassword1")));
		pass.sendKeys("42573720");
		
		WebElement botonIngresar = (WebElement) new WebDriverWait(driver,  Duration.ofSeconds(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("wpLoginAttempt")));
		botonIngresar.click();
	}
	
	@Test
	public void test3_SearchWord() {
	
		WebDriverWait cargadoLogin = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement usuario = (WebElement) cargadoLogin.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
		usuario.sendKeys("churrasco");
		
		WebElement botonsiguientePaso = (WebElement) new WebDriverWait(driver,  Duration.ofSeconds(1000)).until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton")));
		botonsiguientePaso.click();
		
	}
	
	
}
