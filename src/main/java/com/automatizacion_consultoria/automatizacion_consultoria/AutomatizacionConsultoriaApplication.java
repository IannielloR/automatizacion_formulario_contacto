package com.automatizacion_consultoria.automatizacion_consultoria;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomatizacionConsultoriaApplication {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\webDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		   
		driver.get("https://www.consultoriaglobal.com.ar");
		System.out.println("Abre la pagina de consultoria global");
		
		driver.manage().window().maximize();
		System.out.println("Maximiza la ventana del navegador");

		WebElement btnContacto = driver.findElement(By.xpath("//*[@id='menu-item-1364']/a"));
		btnContacto.click();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb/?page_id=370");
		System.out.println("Se dirige a al apartado de contactos");
		

		//Variables
		String email = "hgmail.ar";
        String nombre= "Ro";
        String asunto = "Hola";
        WebElement txtEmail = driver.findElement(By.xpath("//*[@id='wpcf7-f1297-p370-o1']/form/p[2]/span/input"));
        WebElement txtNombre = driver.findElement(By.xpath("//*[@id='wpcf7-f1297-p370-o1']/form/p[1]/span/input"));
        WebElement txtAsunto = driver.findElement(By.xpath("//*[@id='wpcf7-f1297-p370-o1']/form/p[3]/span/input"));
		WebElement btnEnviar = driver.findElement(By.xpath("//*[@id='wpcf7-f1297-p370-o1']/form/p[7]/input"));
		
		txtEmail.sendKeys(email);
		txtNombre.sendKeys(nombre);
		txtAsunto.sendKeys(asunto);

		System.out.println("Ingresa todos los campos");

		btnEnviar.click();
		System.out.println("Clickea el boton enviar");

        //Espera hasta que google responda
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Fijarnos el mensaje de error
		boolean respuesta = driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div/main/article/div/div[1]/div[1]/div/div/form/p[2]/span/span")).getText().contains("La dirección e-mail parece inválida");
		System.out.println("Revisa si aparece el mensaje de error por el correo invalido");

		if(respuesta == true){
			System.out.println("ERROR, EMAIL IVALIDO");
		}
    
	}

}
