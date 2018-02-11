package sml.instructions

import sml.Instruction

/**
 * InstructionFactory Class
 * @param instruction Instruction of the language
 * @param args the arguments for the operation
 */
class InstructionFactory(private val instruction: String, private val args: Array<String> ) {

    /**
     * Generates the required Instruction
     * by calling different functions of the class
     * @return the required Instruction for the SML Machine
     */
    fun generateInstruction() : Instruction {

        val myCLass = generateClass()
        val requiredArgumentTypes = myCLass.constructors[0].parameterTypes

        val k =  constructorArguments(requiredArgumentTypes, args)

        return myCLass.getConstructor(*requiredArgumentTypes).newInstance(*k) as Instruction
    }

    /**
     * Generates the required class by formatting the instruction string that was given to the class
     * and calling Class.forName function
     * @return the required Class
     */
    private fun generateClass(): Class<*> {

        return Class.forName("sml.instructions."
                + instruction.substring(0,1).toUpperCase() + instruction.substring(1) + "Instruction")
    }

    /**
     * Creates an array with required arguments from the constructor
     * @param requiredTypes an array with the class of each argument required by the constructor
     * @param inputArray an array of strings with the input of the user
     * @return an array of objects which will be passed the to constructor
     */
    private fun constructorArguments(requiredTypes : Array<Class<*>>, inputArray: Array<String>): Array<Any> {


        if(requiredTypes.size != inputArray.size) {
            throw IllegalArgumentException("Invalid input for the $instruction instruction")
        }

        val myArray = Array<Any>(requiredTypes.size,{1}) //creating an array with size equal to the constructors
        // argument, with initial values set to 1
        var i = 0
        for(e in requiredTypes) {
            when {
                e.simpleName == "int" -> {// if the required type is int then we cant the given value to int and we add
                    //to the array we are going to return

                    myArray[i] = inputArray[i].toInt()
                    i+=1
                }
                else -> { // we assume that it's an String
                    myArray[i] = inputArray[i]
                    i+=1
                }
            }

        }
        return myArray

    }
}


