import multiprocessing
import os

def cpu_load():
    while True:
        pass

if __name__ == "__main__":
    cores = os.cpu_count()
    print(f"Stressing {cores} CPU cores...")
    processes = [multiprocessing.Process(target=cpu_load) for _ in range(cores)]

    for p in processes:
        p.start()

    for p in processes:
        p.join()
