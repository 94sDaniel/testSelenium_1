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

        // hacer clic en el checkbox Female threads
        var foo = wait.until(driver -> {
            return driver.findElement(By.cssSelector("label[data-filter-value='Female threads']"));
        });

        foo.click();

        WebElement viewMore = driver.findElement(By.cssSelector("#CartButton_036124a315644c4290a1c8a03b501fdd"));

        //2. Filtrar por Use Case Testing
        WebElement testingCheckBox = driver.findElement(By.xpath("//label[@for='cb-filter-testing']"));
        testingCheckBox.click();
        
        //3. Filtrar por Female threads
        WebElement femaleThreadsCheckBox = driver.findElement(By.xpath("//label[@for='cb-filter-female-threads']"));
        femaleThreadsCheckBox.click();
        
        //4. Dar click en el botón "View more" del producto WEH Connector TW17V
        WebElement viewMoreButton = driver.findElement(By.xpath("//a[contains(text(),'WEH® Connector TW17V for testing of components with female thread, pneumatic actuation via valve button, vacuum up to max. 350 bar - Product family')]/../following-sibling::div/a"));
        viewMoreButton.click();
        
        //5. Seleccionar los valores de los campos "Connects to" y "Operating Pressure PS"
        WebElement connectsToDropDown = driver.findElement(By.id("//select[@for='VariantSelector_VARGRP62']"));
        Select dropDown = new Select(connectsToDropDown);
        dropDown.selectByVisibleText("M10X1.0 Female Thread");

        WebElement operatingPressurePSDropDown = driver.findElement(By.id("//select[@for='VariantSelector_VARGRP65']"));        Select dropPDown = new Select(connectsToDropDown);
        dropPDown.selectByVisibleText("50 bar");
        
        //6. Dar click en el botón Request Free Quote
        WebElement requestFreeQuoteButton = driver.findElement(By.xpath("//input[@value='Request Free Quote']"));
        requestFreeQuoteButton.click();
        
        //7. Diligenciar los campos obligatorios del formulario
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='Firstname']"));
        firstNameField.sendKeys("Daniel");
        
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='Lastname']"));
        lastNameField.sendKeys("Sierra");
        
        WebElement companyField = driver.findElement(By.xpath("//input[@id='Company']"));
        companyField.sendKeys("Davivienda");  

        WebElement addressField = driver.findElement(By.xpath("//input[@id='Address']"));
        addressField.sendKeys("Cra 59a 135 60");  

        WebElement cityField = driver.findElement(By.xpath("//input[@id='City']"));
        cityField.sendKeys("johndoe@example.com");        

        WebElement zipField = driver.findElement(By.xpath("//input[@id='Zip']"));
        zipField.sendKeys("111011");
        
        WebElement countryField = driver.findElement(By.xpath("//input[@id='Bogota']"));
        countryField.sendKeys("Bogota");
        
        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("daniel.sierra@davivienda.com");
        
        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='message']"));
        messageField.sendKeys("Please send me a quote for the WEH Connector TW17V");
        
        //8. Seleccionar el check que permite obtener la autorización del cliente
        WebElement authorizationCheckBox = driver.findElement(By.xpath("//input[@id='chk-auth']"));
        authorizationCheckBox.click();
    }
    
    
    @AfterTest
    public void teardown() {
        // cerrar el navegador
        driver.quit();
    }
}

