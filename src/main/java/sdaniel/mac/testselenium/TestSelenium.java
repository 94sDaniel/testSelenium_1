package sdaniel.mac.testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
public class TestSelenium {

    public static void main(String[] args) {

    }


    WebDriver driver;

    @BeforeTest
    public void setup() {

        // configurar  Selenium
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        // inicializar navegador
        driver = new ChromeDriver();
    }
    
    @AfterClass
    public void tearDown() {
        //Cerrar la ventana del navegador
        //driver.quit();
    }
    /**
     *
     */
    @Test
    public void filtrarProductos() {
        // navegar a la página de WEH
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.weh.com/products/quick-connectors/automation");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);

        // hacer clic en el checkbox Testing
        WebElement checkboxTesting = driver.findElement(By.cssSelector("label[data-filter-value='Testing']"));
        checkboxTesting.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // hacer clic en el checkbox Female threads
        var foo = wait.until(driver -> {
            return driver.findElement(By.cssSelector("label[data-filter-value='Female threads']"));
        });

        foo.click();

        WebElement viewMore = driver.findElement(By.cssSelector("#CartButton_036124a315644c4290a1c8a03b501fdd"));

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //4. Dar click en el botón "View more" del producto WEH Connector TW17V
        WebElement viewMoreButton = driver.findElement(By.xpath("//img[@src ='https://www.weh.com/Admin/Public/GetImage.ashx?width=300&height=300&crop=5&Compression=75&FillCanvas=true&DoNotUpscale=true&image=%2fFiles%2fImages%2f10-Product-Images%2fQuick-Connectors%2fTW17%2fTW17V_ADT_C1-14835_r_web.jpg]"));
        viewMoreButton.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //5. Seleccionar los valores de los campos "Connects to" y "Operating Pressure PS"
        WebElement connectsToDropDown = driver.findElement(By.id("VariantSelector_VARGRP62"));
        Select dropDown = new Select(connectsToDropDown);
        dropDown.selectByVisibleText("M10X1.0 Female Thread");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement operatingPressurePSDropDown = driver.findElement(By.id("VariantSelector_VARGRP65"));
        Select dropPDown = new Select(connectsToDropDown);
        dropPDown.selectByVisibleText("50 bar");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //6. Dar click en el botón Request Free Quote
        WebElement requestFreeQuoteButton = driver.findElement(By.xpath("//*[@href='Request Free Quote']"));
        requestFreeQuoteButton.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //7. Diligenciar los campos obligatorios del formulario
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Daniel");
        
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("Sierra");
        
        WebElement companyField = driver.findElement(By.id("Company"));
        companyField.sendKeys("Davivienda");  

        WebElement addressField = driver.findElement(By.id("Address"));
        addressField.sendKeys("Cra 59a 135 60");  

        WebElement cityField = driver.findElement(By.id("City"));
        cityField.sendKeys("johndoe@example.com");        

        WebElement zipField = driver.findElement(By.id("Zip"));
        zipField.sendKeys("111011");
        
        WebElement countryField = driver.findElement(By.id("Country"));
        countryField.sendKeys("Bogota");
        
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("daniel.sierra@davivienda.com");
        
        WebElement messageField = driver.findElement(By.id("Comments"));
        messageField.sendKeys("Please send me a quote for the WEH Connector TW17V");
        
        //8. Seleccionar el check que permite obtener la autorización del cliente
        WebElement authorizationCheckBox = driver.findElement(By.cssSelector("label[data-filter-value='ConsentGDPR']"));
        authorizationCheckBox.click();

        //9. Click Send
        WebElement sendCheck = driver.findElement(By.id("Send"));
        sendCheck.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    
    
    @AfterTest
    public void teardown() {
        // cerrar el navegador
        driver.quit();
    }
}

