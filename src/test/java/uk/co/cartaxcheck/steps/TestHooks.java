package uk.co.cartaxcheck.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import uk.co.cartaxcheck.browsers.WebDriverFactory;

public class TestHooks extends EventFiringWebDriver {

        private static final WebDriver REAL_WEBDRIVER = WebDriverFactory.create();


        public static final Thread CLOSE_THREAD = new Thread(){
            @Override
            public void run (){
                REAL_WEBDRIVER.quit();
            }

        };

        @Override
        public void quit(){
            if(Thread.currentThread() != CLOSE_THREAD){
                throw new UnsupportedOperationException("You shouldn't quit at this point in time bc it still runninf and will quit when JVM exits");
            }
            super.quit();
        }

        public TestHooks(){
            super(REAL_WEBDRIVER);
        }

        static {
            Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
        }

        @Before
        public void before(){
            manage().window().maximize();
            manage().deleteAllCookies();
        }

        @After
        public void after(Scenario scenario){
            if(scenario.isFailed())
                System.out.println("After scenario, come and implement taking screenshot");
        }

    }
