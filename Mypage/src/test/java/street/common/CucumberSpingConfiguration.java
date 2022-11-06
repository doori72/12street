package street.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import street.MypageApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { MypageApplication.class })
public class CucumberSpingConfiguration {}
