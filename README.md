# Design Patterns & SOLID: The "Why" and "How"

This repository serves as a practical laboratory for mastering **clean code** and **software architecture**. Instead of just showing the final result, each module explores the **problematic** (the mess) before presenting the **architectural solution**.

---

## 🏗️ Repository Structure

The project is organized into two primary domains:

### 1. [SOLID](./SOLID)
Focuses on the five core principles of Object-Oriented Design that prevent code from becoming rigid and fragile.
* **Problematic:** Real-world "Code Smells" where logic is tangled or hard to extend.
* **Bad Code:** A "dirty" implementation that violates the specific principle.
* **Solution:** Refactored code demonstrating how the principle cleans up the architecture.

### 2. [Design Patterns (DP)](./DP)
Explores Creational, Structural, and Behavioral patterns used to solve recurring design challenges.
* **Context:** The specific architectural problem (e.g., hard-coded dependencies or inefficient object creation).
* **Implementation:** A "Before vs. After" approach to see the pattern's impact on code quality.

---

## 🚀 How to use this repo
1. Navigate to a specific principle (e.g., `/SOLID/*`) or pattern (e.g., `/DP/Creational/*`).
2. Read the local `README.md` to understand the **Problematic** and the "Contract" being broken.
3. Review the `/bad` directory to see the consequences of poor design.
4. Study the `/solution` directory to see the architectural fix.