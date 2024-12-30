import requests
import json
import time
import sys

# URL of the Selenium Grid GraphQL endpoint
GRID_URL = "http://localhost:4444/graphql"

def get_queue_size():
    # Define the GraphQL query to fetch session queue size
    query = {
        "query": "query { grid { sessionCount } }"
    }

    try:
        # Make a POST request to the GraphQL endpoint with the query
        response = requests.post(GRID_URL, json=query)
        response.raise_for_status()

        # Parse the JSON response
        data = response.json()
        queue_size = data.get("data", {}).get("grid", {}).get("sessionCount")

        return queue_size

    except requests.exceptions.RequestException as e:
        print(f"HTTP error occurred: {e}")
        return -1
    except json.JSONDecodeError:
        print("Error decoding JSON response.")
        return -1
    except Exception as e:
        print(f"Unexpected error: {e}")
        return -1

if __name__ == "__main__":
    while True:
        queue_size = get_queue_size()
        if queue_size == -1:
            print("Error fetching session count. Retrying in 10 seconds...")
        else:
            print(f"Session Count: {queue_size}")

        # Exit condition: queue size is 0
        if queue_size == 0:
            print("Queue is empty. Exiting...")
            sys.exit(0)

        # Wait 10 seconds before the next request
        time.sleep(10)


