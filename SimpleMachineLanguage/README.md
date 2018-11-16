# Simple Machine Language (SML)

An interpreter for a simple machine language — SML. The general form of a machine language instruction is

label instruction register-list where:

- label: is the label for the line. Other instructions might “jump” to that label.

- instruction : Is the actual instruction. In SML, there are instructions for adding, multiplying and so on, 
  for storing and retrieving integers, and for conditionally branching to other labels (like an if state- ment).
  
- register-list: is the list of registers that the instruction manipulates. 
  Registers are simple, integer, storage areas in computer memory, much like vari- ables.
  In SML, there are 32 registers, numbered 0, 1, . . . , 31.
