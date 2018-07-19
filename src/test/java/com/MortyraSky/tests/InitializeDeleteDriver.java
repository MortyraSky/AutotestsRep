
public class MainTest {

    private static WebDriver driver;
    

    @BeforeClass
    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru");

    }   
    
        
    @AfterClass
    public static void tearDown() {      

        driver.quit();
    }

}
