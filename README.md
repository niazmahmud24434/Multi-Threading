# Java Multithreading Project

## Overview
This project is a simple demonstration of multithreading in Java. It shows how multiple threads can run at the same time and how shared data can be handled safely using synchronization.

The main focus of this project is to understand thread creation, thread coordination, and data consistency in a concurrent environment.

---

## What the Program Does
The program runs two threads concurrently:

- One thread prints numbers from **1 to 10**
- Another thread prints the **square of each number from 1 to 10**

Each operation pauses for **500 milliseconds**, making the execution flow easier to observe.

The output follows an ordered pattern where a number is printed first and then its corresponding square.

---

## Thread Design
Two different approaches are used to create threads:

- A thread that extends the `Thread` class to print numbers
- A thread that implements the `Runnable` interface to print squares

Using both approaches in the same program helps show the differences and use cases of each method.

---

## Synchronization and Shared Data
Both threads access a shared counter variable. To prevent race conditions and inconsistent updates:

- Synchronized methods are used
- `wait()` and `notify()` are applied to coordinate execution between threads

This ensures safe access to shared data and maintains the correct output order.

---

## Technologies Used
- Java
- Multithreading
- Synchronization

---

## How to Run
1. Clone the repository
   ```bash
   git clone https://github.com/niazmahmud24434/Multi-Threading.git
