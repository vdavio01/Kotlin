package sml.instructions

import sml.Instruction
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.createType
import kotlin.system.exitProcess


/**
 * InstructionFactory Class
 * @param instruction Instruction of the language
 * @param args the arguments for the operation
 */
class InstructionFactory(private val instruction: String, private val args: Array<String> ) {

    /**
     * Generates the required Instruction
     * @return the required Instruction for the SML Machine
     */
    fun generateInstruction() : Instruction {

        val myCLass = generateClass()
        if(myCLass!= null) {
           val myConstructor:KFunction<Any> = myCLass.constructors.elementAt(0)
           val requiredParameters = myConstructor.parameters

           val k =  constructorArguments(requiredParameters, args)
           return myConstructor.call(*k) as Instruction
        }

        return NoOpInstruction(args[0], "Unknown instruction [$instruction]" )



    }

    /**
     * Generates the required class by formatting the instruction string that was given to the class
     * and calling Class.forName function
     * @return the required Class
     */
    private fun generateClass(): KClass<out Any>? {
        var kClass :KClass<out Any>? = null
        try {
            kClass = Class.forName("sml.instructions."
                    + instruction.substring(0,1).toUpperCase() + instruction.substring(1) + "Instruction").kotlin

        } catch (e: ClassNotFoundException) {

        }
        return kClass
    }

    /**
     * Creates an array with required arguments from the constructor
     * @param requiredParameters an List with the Kparameters required by the constructor
     * @param inputArray an array of strings with the input of the user
     * @return an array which will be passed the to constructor
     */
    private fun constructorArguments(requiredParameters: List<KParameter>, inputArray: Array<String>): Array<Any> {

        // Check if the size
        if(requiredParameters.size != inputArray.size) {
            println(if(requiredParameters.size > inputArray.size) "Insufficient arguments for $instruction" else
                "Abundant arguments for $instruction."
                    + "\nRequired ${requiredParameters.size} found ${inputArray.size}")
            exitProcess(-1)
        }

        val myArray = Array<Any>(requiredParameters.size,{1}) //creating an array with size equal to the constructors
        // argument, with initial values set to 1
        var i = 0
        for(e in requiredParameters) {
            when {

                e.type == Int :: class.createType() -> {
                    // if the required type is int then we cast
                    // the given value to int and we add it to the array we are going to return
                    myArray[i] = inputArray[i].toInt()
                    i+=1
                }
                e.type == String :: class.createType() -> {

                    myArray[i] = inputArray[i]
                    i+=1
                }

            }

        }
        return myArray

    }

}



