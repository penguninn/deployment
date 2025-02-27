package com.example.demo.selenium_webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumWebdriverTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testRegisterAndLogin() {
        driver.get("https://vitimex.com.vn/");

        // Click the "Đăng ký" (Register) link
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Đăng ký tài khoản mới"))).click();

        // Fill in the registration form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Nguyen");
        driver.findElement(By.id("lastName")).sendKeys("An");
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("confirmPassword")).sendKeys("Test@1234");

        // Submit registration
        driver.findElement(By.id("registerButton")).click();
        wait.until(ExpectedConditions.urlContains("account"));
        assertTrue(driver.getCurrentUrl().contains("account"));

        // Logout
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Đăng xuất"))).click();

        // Click the "Đăng nhập" (Login) link
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Đăng nhập"))).click();

        // Fill in login form and submit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("loginButton")).click();

        // Confirm login was successful
        wait.until(ExpectedConditions.urlContains("account"));
        assertTrue(driver.getCurrentUrl().contains("account"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
