# Logic Gates

This java project implements:
* logic gates
  * NAND
  * AND, OR, NOR, XOR (using the NAND gate)
* latches
  * Gated D Latch (using the NAND gate implementation)
  * D Type Flip Flop (using the Gated D Latch implementation)
* counters
  * Binary Counter (using the D Type Flip Flop implementation)
  * N-bit Binary Counter (using the Binary Counter implementation) 

The preconfigured exec method demonstrates the N-bit Binary Counter implementation on 4-bit counter, printing numbers to standard output.

The project includes unit tests, covering all the implemented logic.

## Prerequisites

- Java 21
- Maven 3.6.0 or higher

## Building the Project

To build & test & package the project, run the following command:

```sh
mvn clean install
```

## Building and Running the Main Class
To build and run the preconfigured main class, use the following commands:

```sh
mvn clean compile exec:java
```

## Running Tests

To run the tests, use the following command:

```sh
mvn test
```

## Generating Test Coverage Report

To generate a test coverage report, use the following command:

```sh
mvn clean test jacoco:report
```

The generated test coverage report will be located in the `target/site/jacoco` directory.

## Generating Javadocs

To generate Javadocs, use the following command:

```sh
mvn javadoc:javadoc
```

The generated Javadocs will be located in the `target/reports/apidocs` directory.
