package GlobalClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.Test.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Baseclass extends Listeners{

    WebDriver driver;
    public Loginpage logIn;
    public InterviewPage interview;
    public AddCandidatePage addCandidatePage;

    public CandidateListPage candidateListPage;

    @BeforeClass
    public void WebDriverConfigure() throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
       driver = new ChromeDriver(options);
       driver.manage().window().maximize();
       driver.get("https://d20omqbtwm8stm.cloudfront.net/");
        this.logIn= new Loginpage(driver);
        interview = new InterviewPage(driver);
        addCandidatePage = new AddCandidatePage(driver);
        candidateListPage = new CandidateListPage(driver);
    }
    public List<HashMap<String, String>> getJsonDataTOMap(String filePath) throws IOException {
        // read json to String
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        // string to hashMap Jackon databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {

                });
        return data;
    }
//   @AfterClass
//    public void tear(){
//        driver.quit();
}
