package testCases;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import testCases.utilitarios.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"junit:junitResult.xml"},
        features = "src/main/resources/features",
        //tags = "@test",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ApiMasterRunner extends BaseTest {

    @BeforeClass
    public static void setUp() {

        basePath = "http://localhost:8080";
        endPoint = null;
    }
}
