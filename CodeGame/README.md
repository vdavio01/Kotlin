# Task

The approach to the solution of the project was to divide the functionality into independent single-responsibility classes 
in order to maintain a clean structure and future-proof expandable design. In order to support invertion of control principle
we use spring framework for dependency injection. 

# GamePlay

The program is configured and started with a number of predefined values. Once the program is running, a secret code is generated and the user is prompted to find the code in a series of inputs. For each input the user receives a feedback. Once all available tries have been used, the user is prompted to either terminate or restart the game.

Separation of responsibilities

The aforementioned functionality is separated into a number of Interfaces each responsible for a contained task.

Game: Central point of the application.
Scanner: Receives an game inputs.
MessageCenter: Produces prompts, instructions and feedback.
Peg: Representation of the Peg using which the game is played.
ColorCodeGenerator: Generates all available Pegs which the user is allowed to use.
Validator: Validates that the user input is valid and evaluates whether it is correct.

# MasterMidDriver

This is from where the application is prepared and executed. A Game is instantiated and it's function runGames() called marking the start of the game.

# Scanner

Interaction of the user with the game. It is implemented as ScannerImpl, which receives game data directly from the console. It is possible to another class as Scanner should a different source of data be required i.e a text file or database query etc...

# MessageCenter

Feedback is provided via the MessageCenter. Currently implemented as MessageCenterImpl, which contains responses as string values and returns them upon function calls.

# Peg

The Peg class can be of any color defined in the PegColor enum class and has a single function returning the first character of it's color name.

# ColorCodeGenerator

Responsible for generating the secret code to be cracked by the user. arrayOfPegs represents all valid pegs which can be used to generate the secret code.

# Validator

Validator is used to validate the input for compliance with game rules as well as for correctness against the secret code. validInput contains the Pegs which the user is allowed to use. Verifies that the input follows game rules.Returns true if input is valid and false otherwise.Compares the input against the secret code and returns a Pair of a Boolean indicating whether the input and code are the same and a Pair of the number of Black and White pegs (in that order).

# Testing

The game contains relevant tests for all logic parts such as input validation and code generation.
