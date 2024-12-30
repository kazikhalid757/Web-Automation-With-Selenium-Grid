# Selenium Grid Setup Guide

This guide provides step-by-step instructions on how to set up and run Selenium Grid.

## Prerequisites

- Java Development Kit (JDK) installed on your machine
- Apache Maven installed for project management
- Eclipse IDE or any other IDE for running your project

## Step 1: Download Selenium Server (Grid)

1. Visit the [Selenium Downloads page](https://www.selenium.dev/downloads/).
2. Download the latest version of **Selenium Server (Grid)**.

## Step 2: Start Selenium Grid

1. Navigate to the **directory** where you downloaded the Selenium Server .jar file.
2. Open a **command prompt (CMD)** in that directory.

3. **Start the Hub:**
 Run the following command to start the Selenium Grid Hub:

    java -jar selenium-server-4.15.0.jar

4. **Start the Node**
 Open another command prompt and run the following command to start a Selenium Node connected to the Hub:

    java -jar selenium-server-4.15.0.jar node --hub http://localhost:4444 --port 5555

## Step 3: Running Your Project
 Open the terminal in your Eclipse IDE.

 **Clean your Maven project by running:**

    mvn clean
 **Run your tests with:**

    mvn test    

## Additional Step
 **For allure result by running:**

    allure serve     



Here’s a comprehensive guide to **install Jenkins on Windows**, install the required plugins, set up Python, and create a pipeline job to run your script:

---

## **1. Install Jenkins on Windows**

### **Step 1: Download Jenkins**

1. Go to the [Jenkins download page](https://www.jenkins.io/download/).
2. Download the **Windows installer**.

### **Step 2: Install Jenkins**

1. Run the downloaded installer.
2. Follow the installation steps, including selecting the installation directory and Jenkins port.
3. By default, Jenkins runs on **port 8080**.
4. After installation, Jenkins should start automatically.

### **Step 3: Unlock Jenkins**

1. Open a browser and go to `http://localhost:8080`.
2. During installation, Jenkins will generate an unlock key. You can find it at the following location:
   ```
   C:\Program Files (x86)\Jenkins\secrets\initialAdminPassword
   ```
3. Copy the unlock key and paste it into the Jenkins web interface to unlock Jenkins.

### **Step 4: Set up Jenkins for the first time**

1. Once unlocked, follow the steps to set up Jenkins:
    - Install suggested plugins.
    - Create the first admin user.

---

## **2. Install Required Jenkins Plugins**

### **Step 1: Install Plugins**

1. After logging into Jenkins, go to **Manage Jenkins** > **Manage Plugins**.
2. **Install the following plugins**:

    - **Maven Integration Plugin**: Allows Jenkins to execute Maven builds.
    - **Allure Jenkins Plugin**: Integrates Allure reports into Jenkins.
    - **Pipeline Plugin**: Provides support for defining Jenkins pipelines.
    - **JDK Plugin**: Allows Jenkins to manage JDK installations.
    - **Pipeline Utility Steps**: Provides utility steps for Jenkins pipelines.
    - **HTTP Request Plugin**: To make HTTP requests in pipeline scripts.
    - **Pyenv Pipeline Plugin**: To use Python environments.
    - **Python Plugin**: Provides Python integration for Jenkins.
    - **ShiningPanda Plugin**: Integrates Python with Jenkins, including support for virtual environments.

3. After installing the plugins, restart Jenkins if needed.

---

## **3. Install Python on Windows**

### **Step 1: Download and Install Python**

1. Download Python from the official site: [Python Downloads](https://www.python.org/downloads/).
2. During installation, ensure you check the box for **"Add Python to PATH"**.

### **Step 2: Verify Python Installation**

1. Open a Command Prompt (cmd).
2. Run the following command to verify Python is installed:
   ```bash
   python --version
   ```

---

## **4. Set Python Environment Variables (if not set automatically)**

If you didn’t check the box to add Python to the PATH, you can manually add Python to the system’s PATH environment variable.

### **Step 1: Update System PATH Variable**

1. Open the **System Properties** window by right-clicking **This PC** and selecting **Properties**.
2. Click **Advanced system settings**.
3. Click **Environment Variables**.
4. In the **System variables** section, find the **Path** variable, and click **Edit**.
5. Add the path to your Python installation, typically:
   ```
   C:\Users\<YourUser>\AppData\Local\Programs\Python\Python311\
   ```

---

## **5. Install Required Python Libraries**

### **Step 1: Open Command Prompt (cmd)**

### **Step 2: Install Libraries Using pip**

1. Install the **requests** and **psutil** libraries by running the following commands:
   ```bash
   pip install requests
   pip install psutil
   ```

---

## **6. Create a Jenkins Pipeline Job**

### **Step 1: Create New Jenkins Pipeline Job**

1. Open Jenkins and click on **New Item**.
2. Enter a name for your project (e.g., **Selenium Grid Test**).
3. Select **Pipeline** and click **OK**.

### **Step 2: Configure the Pipeline Job**

1. In the **Pipeline** section, under **Definition**, select **Pipeline script**.
2. Paste the following Jenkins Pipeline script into the **Script** box:
   ```groovy
   pipeline {
       agent any

       environment {
           PYTHON_PATH = "C:\\Users\\<YourUser>\\AppData\\Local\\Programs\\Python\\Python311\\python.exe"  // Full path to python.exe
           PYTHON_SCRIPT = "check_selenium_grid.py"  // Python script file name
       }

       stages {
           stage('Checkout') {
               steps {
                   echo 'Checking out the repository...'
                   checkout([$class: 'GitSCM',
                             branches: [[name: 'branch name']],
                             userRemoteConfigs: [[url: 'git url',
                                                  credentialsId: ' Jenkins credentialsId']]])
               }
           }

           stage('Check Selenium Grid') {
               steps {
                   echo 'Checking Selenium Grid status...'
                   script {
                       // Run Python script to check Selenium Grid using the full path to python.exe
                       def result = bat(script: "\"${PYTHON_PATH}\" ${PYTHON_SCRIPT}", returnStatus: true)
                       if (result == 0) {
                           echo "Selenium Grid is operational."
                       } else {
                           error("Selenium Grid is not ready. Aborting the pipeline.")
                       }
                   }
               }
           }

           stage('Run Tests on Selenium Grid') {
               steps {
                   echo 'Running tests on Selenium Grid...'
                   script {
                       bat """
                           mvn clean test || true
                       """
                   }
               }
           }
       }

       post {
           always {
               echo 'Publishing Allure reports...'
               allure includeProperties: false,
                       jdk: '',
                       results: [[path: 'build/allure-results']]
           }
           success {
               echo 'Build and tests completed successfully!'
           }
           failure {
               echo 'Build or tests failed.'
           }
       }
   }
   ```

3. **Save** the pipeline job.

---

## **7. Run the Jenkins Pipeline Job**

1. After saving the job, go to the **Dashboard**.
2. Click on your newly created pipeline job.
3. Click on **Build Now** to run the pipeline.

---

### **8. View Job Results**

- After the job completes, you can view the results, including logs and Allure reports.
- If the job fails, check the logs for detailed information about what went wrong.

---

### **Final Notes:**
- Ensure that your Python script (`check_selenium_grid.py`) is properly checked into the repository, and the file is accessible during the Jenkins build.
- Make sure the `mvn clean test` command is correct, and the necessary Maven dependencies are available.

This setup will allow Jenkins to run your Python checks, execute Maven tests, and report the results using Allure, all integrated into a Jenkins pipeline.