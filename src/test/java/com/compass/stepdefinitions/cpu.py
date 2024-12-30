import psutil
import time

# File to save the CPU usage data
output_file = "cpu_usage.txt"

while True:
    # Get the current CPU usage
    cpu_usage = psutil.cpu_percent(interval=1)
    
    # Get the current timestamp
    timestamp = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
    
    # Write the latest data to the file (overwriting previous content)
    with open(output_file, "w") as file:
        file.write(f"{timestamp}: CPU Usage: {cpu_usage}%\n")
    
    # Print the data to the console (optional)
    print(f"{timestamp}: CPU Usage: {cpu_usage}%")
    
    # Wait for 10 seconds
    time.sleep(10)
