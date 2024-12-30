import requests
import sys
import time
import psutil


SELENIUM_HUB_URL = "http://localhost:4444/wd/hub/status"
SELENIUM_NODE_URL = "http://localhost:4444/grid/console"

def is_hub_running():
    """
    Check if the Selenium Grid Hub is running and ready.
    """
    try:
        response = requests.get(SELENIUM_HUB_URL, timeout=5)
        if response.status_code == 200:
            hub_status = response.json().get("value", {}).get("ready", False)
            return hub_status
        return False
    except requests.RequestException as e:
        print(f"Error connecting to Hub: {e}")
        return False

def is_node_connected():
    """
    Check if at least one Selenium Node is connected to the Hub.
    """
    try:
        response = requests.get(SELENIUM_NODE_URL, timeout=5)
        if response.status_code == 200 and "Nodes should appear here" not in response.text:
            return True
        return False
    except requests.RequestException as e:
        print(f"Error connecting to Node Console: {e}")
        return False

def is_cpu_usage_below_threshold(threshold=30):
    """
    Check if the CPU usage is below the specified threshold.
    """
    cpu_usage = psutil.cpu_percent(interval=1)
    print(f"CPU Usage: {cpu_usage}%")
    return cpu_usage < threshold

if __name__ == "__main__":
    while True:

        print("Checking Selenium Grid...")
        if is_hub_running() and is_node_connected():
            print("Selenium Grid is operational.")

            print("Checking CPU usage...")
            if is_cpu_usage_below_threshold():
                print("CPU usage is below threshold. Proceeding with test execution.")
                sys.exit(0)
            else:
                print("CPU usage is above threshold. Waiting for it to drop...")
                time.sleep(10)
        else:
            print("Selenium Grid is not ready. Retrying...")
            time.sleep(10)
