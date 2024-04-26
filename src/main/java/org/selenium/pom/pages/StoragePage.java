package org.selenium.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;

import java.time.Duration;
import java.util.Objects;
import java.util.Random;

public class StoragePage extends BasePage {
private final By searchFld =By.cssSelector("#mainSearchbar");
private final By articleFoundSelector = By.cssSelector(".a-plp-results-title");
private final By armaniBtnId = By.id("brand-A/X ARMANI EXCHANGE");
private final By priceMin = By.id("min-price-filter");
private final By priceMax = By.id("max-price-filter");
private final By btnPriceFilter = By.cssSelector(".a-price__filterButton");
private final By smartTvEncontradasPrecioSelector = By.cssSelector(".a-plp-results-title");
private final By inicioSesionBtn=By.cssSelector("span[class='a-header__topLink']");
private final By btnCrearCuenta = By.cssSelector("a[class='c0ce114f8 c1fd98bd1']");
private final By userCreateFld = By.xpath("//input[@id='email']");
private final By pswdCreateFld = By.xpath("//input[@id='password']");
private final By btnNuevaCuenta = By.xpath("//button[.='Crear cuenta']");


public StoragePage(WebDriver driver) {
        super(driver);
    }

//////// function to search articles
    public StoragePage searchArticle(String searchFor){

    driver.findElement(searchFld).sendKeys(searchFor);
    driver.findElement(searchFld).sendKeys(Keys.ENTER);
    return this;
    }

   public StoragePage findArticles(){
      // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       //wait.until(ExpectedConditions.visibilityOf((WebElement) articleFoundSelector));
    try{

            String articleQuantity = driver.findElement(articleFoundSelector).getText();
                System.out.println("/////////////////////////////////");
                System.out.println(articleQuantity);
                 System.out.println("/////////////////////////////////");


        }catch (NoSuchElementException e){

        System.out.println("Articulo no encontrado");

        }
        return this;
   }
   public StoragePage filterByBrand() {

        driver.findElement(armaniBtnId).click();
    return this;
   }

   public StoragePage filterByPrice(String minimo, String maximo) throws InterruptedException {
    driver.findElement(priceMin).sendKeys(minimo);
    driver.findElement(priceMax).sendKeys(maximo);
    driver.findElement(btnPriceFilter).click();
    //wait until filter text appears
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='plp-head-filter'] a")));

   String smartTvEncontradas = driver.findElement(By.cssSelector(".a-plp-results-title")).getText();
    System.out.println("Productos encontrados despues del Filtro: " +smartTvEncontradas);
    return this;
   }

   public StoragePage selecTv(){
        driver.findElement(By.xpath("//*[@alt='Pantalla Smart TV Hisense LED de 50 pulgadas 4K/UHD 50A7K con Google TV']")).click();
   return this;
    }

    public StoragePage buyingTv(String usuario, String password){
        driver.findElement(By.cssSelector("#opc_pdp_buyNowButton")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys(usuario);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[value='default']")).click();
        try
        {
            String prom = driver.findElement(By.cssSelector(".a-btn.a-btn--action.--secondary.a-checkout__btnPromotion.text-promotions.show")).getText();
            System.out.println("Tiene una promocion de: "+prom);
        } catch (NoSuchElementException e) {
            System.out.println("El articulo no tiene promociones");
        }
        driver.findElement(By.xpath("//button[@id='submitForOther']")).click();
        try
        {
            System.out.println("Compra realizada");
        }catch (NoSuchElementException e){
            System.out.println("Error en compra");
        }
        return this;
    }
//Pruebas Datos de Usuario
    public StoragePage datosUsuario() throws InterruptedException {
        String nombre = "Enrique";
        String apellido = "Ortiz";
        String aliasDireccion = "Casa";
        String codigoPostal = "87000";
        String estado = "TAMULIPAS";
        String ciudad = "VICTORIA";
        String colonia = "ARCOIRIS";
        String calle ="Calle 100";
        String num = "888";
        String telefonoCelular ="8341663946";
        String telefonoFijo ="8343160430";
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".a-btn.a-btn--tertiary.d-none.d-sm-block.font-weight-bold")).click();
        driver.findElement(By.xpath("//input[@labeltext='Nombre']")).sendKeys(nombre);
        driver.findElement(By.xpath("//input[@labeltext='Apellido Paterno']")).sendKeys(apellido);
        driver.findElement(By.xpath("//input[@labeltext='Alias de la dirección']")).sendKeys(aliasDireccion);
        driver.findElement(By.xpath("//input[@labeltext='Código Postal']")).sendKeys(codigoPostal);
       driver.findElement(By.xpath("//input[@name='city']")).sendKeys(ciudad);
        // WebElement dropEstado = driver.findElement(By.xpath("//select[@name='stateId']"));
        //Select dropdownEstado = new Select(dropEstado);
       // dropdownEstado.selectByValue();
        driver.findElement(By.xpath("//input[@name='street']")).sendKeys(calle);
/*        WebElement dropCiudad = driver.findElement(By.xpath("//select[@name='municipality']"));
        Select dropdownCiudad = new Select(dropCiudad);
        dropdownCiudad.selectByValue(ciudad);*/
       // WebElement dropColonia = driver.findElement(By.xpath("//select[@name='colony']"));
        //Select dropdownColonia = new Select(dropColonia);
       // dropdownColonia.selectByValue(colonia);
        driver.findElement(By.xpath("//input[@name='noExt']")).sendKeys(num);
        driver.findElement(By.cssSelector("div[class='col-sm-6 col-lg-2 mt-2 mt-lg-0 buttonAddAdressWeb'] button[class='a-btn a-btn--primary']")).click();
        driver.findElement(By.xpath("//input[@labeltext='Teléfono Celular']")).sendKeys(telefonoCelular);
        driver.findElement(By.xpath("//input[@labeltext='Teléfono Fijo']")).sendKeys(telefonoFijo);
        driver.findElement(By.xpath("//div[@class='col-sm-6 col-lg-2 mt-2 mt-lg-0 buttonAddAdressWeb']")).click();

        return this;
    }


    public StoragePage promocion(){
        try
        {
           String prom = driver.findElement(By.cssSelector(".a-btn.a-btn--action.--secondary.a-checkout__btnPromotion.text-promotions.show")).getText();
            System.out.println("Tiene una promocion de: "+prom);
        } catch (NoSuchElementException e) {
            System.out.println("El articulo no tiene promociones");
        }
        return this;
    }



/////////////////////////////////////////////////Generar cuenta
    public StoragePage createAccount() {
        String ingresarCorreo = "correoprueba";
        int numAl=0;
        String arroba = "@gmail.com";
        String passNewUser = "Apex1234";


/////////////// Generar correos aleatorios
        Random random = new Random();
        numAl = random.nextInt(100,1000);
        String correoGenerado = ingresarCorreo + numAl + arroba;


        System.out.println(correoGenerado);


//////////////Crear Cuenta
       driver.findElement(inicioSesionBtn).click();
        driver.findElement(By.cssSelector("a[class='c8ab37d93 c58e794fd']")).click();
       //       driver.findElement((btnCrearCuenta)).click();
       driver.findElement(userCreateFld).sendKeys(correoGenerado);
       driver.findElement(pswdCreateFld).sendKeys(passNewUser);
       /////////// Información de usuario
       driver.findElement(btnNuevaCuenta).click();


    return this;
    }

    public StoragePage datosNuevoUsuario(){
        String nameNew = "Nombre";
        String apellidoNew = "Apellido";
        String telCelUserNew = "8341663946";


        driver.findElement(By.xpath("//input[@id='input-user__name']")).sendKeys(nameNew);
        driver.findElement(By.xpath("//input[@id='input-user__apaterno']")).sendKeys(apellidoNew);
        WebElement dropdownDia = driver.findElement(By.xpath("//select[@id='daySelectorLabel']"));
        Select dropdownDiaNam = new Select(dropdownDia);
        dropdownDiaNam.selectByValue("26");
        WebElement dropdownMes = driver.findElement(By.xpath("//select[@id='monthSelectorLabel']"));
        Select dropdownMesNam = new Select(dropdownMes);
        dropdownMesNam.selectByValue("Sep");
        WebElement dropdownYear = dropdownMes.findElement(By.xpath("//select[@id='yearSelectorLabel']"));
        Select dropdownYearNam = new Select(dropdownYear);
        dropdownYearNam.selectByValue("1993");
        driver.findElement((By.xpath("//input[@id='male']"))).click();
        driver.findElement((By.xpath("//button"))).click();
        driver.findElement((By.xpath("//input[@name='phone']"))).sendKeys(telCelUserNew);
        driver.findElement(By.xpath("//button[@type='submit' and @value='default']")).click();
        //driver.findElement(By.xpath("//button[@value='default']")).click();
        driver.findElement(By.cssSelector("button[class='a-btn a-btn--primary btn-WelcomeMS']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sesionInic = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-header__topLink popover-session']")));
       String txtInicioSesion = driver.findElement(By.xpath("//span[@class='a-header__topLink popover-session']")).getText();
      //  System.out.println("Lo que está detectando es: "+txtInicioSesion);

     if(Objects.equals(txtInicioSesion, "Hola Nombre")){
          System.out.println("Usuario logeado");
      }  else {
          System.out.println("Usuario no logeado");
      }

        return this;

    }





}
