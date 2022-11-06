package street.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import street.SmsApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { SmsApplication.class })
public class CucumberSpingConfiguration {}
