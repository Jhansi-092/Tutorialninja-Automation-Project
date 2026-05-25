package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before

    public void setup() {

        System.out.println(
        "Initializing driver");

        DriverFactory.initDriver();
    }

    @After

    public void tearDown() {

        DriverFactory.quitDriver();

        System.out.println(
        "Driver closed");
    }
}