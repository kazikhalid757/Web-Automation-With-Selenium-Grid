//package com.compass.stepdefinitions;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Map;
//import java.util.Properties;
//import com.compass.utils.EncryptionUtil;
//import org.openqa.selenium.WebDriver;
//import com.compass.testbase.TestBase;
//import com.compass.testbase.TestContextSetup;
//import com.compass.utils.WaitHelper;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import static com.compass.utils.EncryptionUtil.decrypt;
//import java.lang.management.ManagementFactory;
//import com.sun.management.OperatingSystemMXBean;
//
//@SuppressWarnings("ALL")
//public class Hooks {
//    private TestContextSetup context;
//    private WaitHelper waitHelper;
//    public static Properties prop;
//
//    public Hooks(TestContextSetup testContextSetup) {
//        this.context = testContextSetup;
//    }
//
//    @Before
//    public void BeforeScenario(Scenario scenario) throws IOException, InterruptedException {
//        // Wait for CPU usage to drop below 30%
//        waitForCpuUsageBelowThreshold(30);
//
//        prop = new Properties();
//        FileInputStream ip = new FileInputStream("src/main/resources/config/global.properties");
//        prop.load(ip);
//
//        // Path to the Excel file
//        String excelPath = "src/test/java/com/compass/stepdefinitions/config.xlsx";
//        String scenarioName = scenario.getName();
//
//        // Read details from Excel
//        Map<String, String> scenarioDetails = ExcelUtil.readScenarioDetails(excelPath, scenarioName);
//        if (scenarioDetails.isEmpty()) {
//            throw new IllegalArgumentException("Scenario configuration not found in Excel for: " + scenarioName);
//        }
//
//        String nodeIP = scenarioDetails.get("Node IP");
//        String browserTag = scenarioDetails.get("Browser Tag");
//
//        System.out.println("Running scenario: " + scenarioName);
//        System.out.println("Node IP: " + nodeIP + ", Browser: " + browserTag);
//
//        context.getTestBase().RemoteDriver(nodeIP);
//        context.initializeDriver(browserTag);
//        context.getTestBase().navigateToUrl();
//    }
//
//    @After
//    public void AfterScenario() throws IOException, InterruptedException {
//        context.closeDriver();
//    }
//
//    private void waitForCpuUsageBelowThreshold(int threshold) throws InterruptedException {
//        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        double cpuLoad;
//        do {
//            cpuLoad = osBean.getSystemCpuLoad() * 100;
//            System.out.println("Current CPU Load: " + cpuLoad + "%");
//            if (cpuLoad >= threshold) {
//                System.out.println("CPU load is above " + threshold + "%, waiting...");
//                Thread.sleep(10000); // Wait for 10 seconds before checking again
//            }
//        } while (cpuLoad >= threshold);
//        System.out.println("CPU load is below " + threshold + "%, proceeding with tests.");
//    }
//}



//----------------------------------------------------------------------------------------------------------------------------------------------------------

//
//
//package com.compass.stepdefinitions;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//import java.util.Map;
//import java.util.Properties;
//import com.compass.utils.EncryptionUtil;
//import org.openqa.selenium.WebDriver;
//import com.compass.testbase.TestBase;
//import com.compass.testbase.TestContextSetup;
//import com.compass.utils.WaitHelper;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//import static com.compass.utils.EncryptionUtil.decrypt;
//
//import java.lang.management.ManagementFactory;
//import com.sun.management.OperatingSystemMXBean;
//
//@SuppressWarnings("ALL")
//public class Hooks {
//    private TestContextSetup context;
//    private WaitHelper waitHelper;
//    public static Properties prop;
//
//    public Hooks(TestContextSetup testContextSetup) {
//        this.context = testContextSetup;
//    }
//
//    @Before
//    public void BeforeScenario(Scenario scenario) throws IOException, InterruptedException {
//        // Wait for CPU usage to drop below 30%
//        waitForCpuUsageBelowThreshold(30);
//
//
//        if (!isPortOpen("localhost", 5556, 5000)) {
//            throw new IllegalStateException("Your given port is not open. Exiting...");
//        }
//
//        prop = new Properties();
//        FileInputStream ip = new FileInputStream("src/main/resources/config/global.properties");
//        prop.load(ip);
//
//        // Path to the Excel file
//        String excelPath = "src/test/java/com/compass/stepdefinitions/config.xlsx";
//        String scenarioName = scenario.getName();
//
//        // Read details from Excel
//        Map<String, String> scenarioDetails = ExcelUtil.readScenarioDetails(excelPath, scenarioName);
//        if (scenarioDetails.isEmpty()) {
//            throw new IllegalArgumentException("Scenario configuration not found in Excel for: " + scenarioName);
//        }
//
//        String nodeIP = scenarioDetails.get("Node IP");
//        String browserTag = scenarioDetails.get("Browser Tag");
//
//        System.out.println("Running scenario: " + scenarioName);
//        System.out.println("Node IP: " + nodeIP + ", Browser: " + browserTag);
//
//        context.getTestBase().RemoteDriver(nodeIP);
//        context.initializeDriver(browserTag);
//        context.getTestBase().navigateToUrl();
//    }
//
//    @After
//    public void AfterScenario() throws IOException, InterruptedException {
//        context.closeDriver();
//    }
//
//    private void waitForCpuUsageBelowThreshold(int threshold) throws InterruptedException {
//        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        double cpuLoad;
//        do {
//            cpuLoad = osBean.getSystemCpuLoad() * 100;
//            System.out.println("Current CPU Load: " + cpuLoad + "%");
//            if (cpuLoad >= threshold) {
//                System.out.println("CPU load is above " + threshold + "%, waiting...");
//                Thread.sleep(10000); // Wait for 10 seconds before checking again
//            }
//        } while (cpuLoad >= threshold);
//        System.out.println("CPU load is below " + threshold + "%, proceeding with tests.");
//    }
//
//    private boolean isPortOpen(String host, int port, int timeout) {
//        try (Socket socket = new Socket()) {
//            SocketAddress socketAddress = new InetSocketAddress(host, port);
//            socket.connect(socketAddress, timeout);
//            System.out.println("Port " + port + " is open.");
//            return true;
//        } catch (IOException e) {
//            System.err.println("Port " + port + " is not open: " + e.getMessage());
//            return false;
//        }
//    }
//}
//
//







package com.compass.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import com.compass.utils.EncryptionUtil;
import lombok.var;
import org.json.JSONArray;
import org.json.JSONObject;
import com.compass.testbase.TestContextSetup;
import com.compass.utils.WaitHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.compass.utils.EncryptionUtil.decrypt;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

@SuppressWarnings("ALL")
public class Hooks {
    private TestContextSetup context;
    private WaitHelper waitHelper;
    public static Properties prop;

    public Hooks(TestContextSetup testContextSetup) {
        this.context = testContextSetup;
    }

    @Before
    public void BeforeScenario(Scenario scenario) throws IOException, InterruptedException {
        // Wait for CPU usage to drop below 30%
       // waitForCpuUsageBelowThreshold(30);

//        if (!isPortOpen("localhost", 5556, 5000)) {
//            throw new IllegalStateException("Your given port is not open. Exiting...");
//        }

        // Check Selenium Grid status
        //checkSeleniumGridStatus("http://localhost:4444");

        prop = new Properties();
        FileInputStream ip = new FileInputStream("src/main/resources/config/global.properties");
        prop.load(ip);

        // Path to the Excel file
        String excelPath = "src/test/java/com/compass/stepdefinitions/config.xlsx";
        String scenarioName = scenario.getName();

        // Read details from Excel
        Map<String, String> scenarioDetails = ExcelUtil.readScenarioDetails(excelPath, scenarioName);
        if (scenarioDetails.isEmpty()) {
            throw new IllegalArgumentException("Scenario configuration not found in Excel for: " + scenarioName);
        }

        String nodeIP = scenarioDetails.get("Node IP");
        String browserTag = scenarioDetails.get("Browser Tag");

        System.out.println("Running scenario: " + scenarioName);
        System.out.println("Node IP: " + nodeIP + ", Browser: " + browserTag);

        context.getTestBase().RemoteDriver(nodeIP);
        context.initializeDriver(browserTag);
        context.getTestBase().navigateToUrl();
    }

    @After
    public void AfterScenario() throws IOException, InterruptedException {
        context.closeDriver();
    }

    private void waitForCpuUsageBelowThreshold(int threshold) throws InterruptedException {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuLoad;
        do {
            cpuLoad = osBean.getSystemCpuLoad() * 100;
            System.out.println("Current CPU Load: " + cpuLoad + "%");
            if (cpuLoad >= threshold) {
                System.out.println("CPU load is above " + threshold + "%, waiting...");
                Thread.sleep(10000); // Wait for 10 seconds before checking again
            }
        } while (cpuLoad >= threshold);
        System.out.println("CPU load is below " + threshold + "%, proceeding with tests.");
    }

    private boolean isPortOpen(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            SocketAddress socketAddress = new InetSocketAddress(host, port);
            socket.connect(socketAddress, timeout);
            System.out.println("Port " + port + " is open.");
            return true;
        } catch (IOException e) {
            System.err.println("Port " + port + " is not open: " + e.getMessage());
            return false;
        }
    }

    private void checkSeleniumGridStatus(String gridUrl) {
        try {
            URL url = new URL(gridUrl + "/status");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                throw new IllegalStateException("Failed to connect to Selenium Grid at " + gridUrl);
            }

            StringBuilder response = new StringBuilder();
            try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject value = jsonResponse.getJSONObject("value");

            boolean isReady = value.getBoolean("ready");
            if (!isReady) {
                throw new IllegalStateException("Selenium Grid is not ready.");
            }

            JSONArray nodes = value.getJSONArray("nodes");
            if (nodes.isEmpty()) {
                throw new IllegalStateException("No nodes are connected to Selenium Grid.");
            }

            System.out.println("Selenium Grid is ready and has " + nodes.length() + " nodes connected.");
        } catch (Exception e) {
            throw new IllegalStateException("Error checking Selenium Grid status: " + e.getMessage(), e);
        }
    }
}


