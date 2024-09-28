
# Game of Life Simulation

### Author: Mori Sason

---

## Overview

This project simulates the Game of Life using a graphical user interface (GUI) created with Java Swing. The simulation allows users to interact with the grid, flipping cells on and off, and observe how the grid evolves based on the rules of the Game of Life.

The project consists of three main components:
- **GOLMatrix**: Handles the state of the grid and the logic for the Game of Life, including the next generation evolution.
- **GOLPanel**: The Swing component that draws the grid and handles user interaction.
- **GameOfLifeSimulation**: The main class that initializes and runs the application, allowing the user to observe and interact with the simulation.

---

## Files

- `GameOfLifeSimulation.java`: The main class that sets up and runs the simulation.
- `GOLMatrix.java`: Contains the logic for the Game of Life, including grid initialization, flipping cells, and generating the next state of the grid.
- `GOLPanel.java`: Handles the graphical display of the grid and user interactions through mouse clicks.
- `ArrayCheck.java`: (If necessary, describe what this class does, or remove if not applicable.)

---

## How to Run the Simulation

### Prerequisites:
- You must have Java SDK (JDK) installed. Version 8 or above is recommended.
- IntelliJ IDEA or any Java IDE.

### Steps to Run:
1. **Clone or Download the Project:**
   - Download the project and place all files in the same directory.
   
2. **Open the Project in IntelliJ:**
   - Open IntelliJ IDEA.
   - Go to **File -> New -> Project from Existing Sources** and navigate to the folder containing your Java files.
   - IntelliJ will import the project.

3. **Set Up the SDK:**
   - Make sure the JDK is set up in IntelliJ by going to **File -> Project Structure -> Project** and selecting the correct JDK.
   - Ensure that all `.java` files are inside the `src/GameOfLife` folder to match the package declaration.

4. **Run the Program:**
   - Right-click on `GameOfLifeSimulation.java` and select **Run 'GameOfLifeSimulation.main()'**.
   - This will compile and run the program.
   - The GUI window for the Game of Life simulation should appear.

---

## Features

- **Interactive Grid**: Click on cells to toggle between alive and dead states.
- **Step-by-Step Evolution**: Click the "Next Generation" button to see the grid evolve based on the rules of the Game of Life.
- **Clear Grid**: Clear the entire grid to start fresh.

---

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

---

## Author

Mori Sasson  
LinkedIn: https://www.linkedin.com/in/mori-sason-9a4811281  
Email: 8mori8@gmail.com
