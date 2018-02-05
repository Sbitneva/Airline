# GL Entry Task

## Airline

1. Define aircraft class hierarchy. There should be 3 levels of the hierarchy.
1. Create an airline company that stores airplanes.
1. Calculate total capacity and carrying capacity of all the aircraft in the airline.
1. Sort the aircrafts by flight range (from smaller to larger) and display it on screen.
1. Find aircraft corresponding to the specified range of fuel consumption parameters (liters per hour).
1. Console menu should contain following commands at bare minimum:
    - Calculate the total capacity and carrying capacity of all the aircraft in the airline.
    - Display the list of aircraft of the company sorted by flight range.
    - Find airplanes corresponding to a given range of fuel consumption parameters.

## Requirements

- Linux Ubuntu 16.04
- git
- OpenJDK 8 (JRE)
- maven

## Build

1. Clone the project
    ```bash
    git clone https://www.github.com/Sbitneva/Airline
    ```

2. Change directory
    ```bash
    cd Airline
    ```

3. Run clean and default lifecycles (inclusive up to install phase)
    ```bash
    mvn clean install
    ```

## Run

```bash
java -jar target/airline-1.0-SNAPSHOT.jar
```
