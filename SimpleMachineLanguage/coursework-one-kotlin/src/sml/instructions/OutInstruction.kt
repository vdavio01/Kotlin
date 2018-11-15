package sml.instructions

import sml.Instruction
import sml.Machine


/**
 * Describes the SML Out Instruction
 */
class OutInstruction(label: String, private val op1: Int): Instruction(label, "out") {

    /**
     * Prints the content of register op1
     */
    override fun execute(m: Machine) {
        val value = m.registers.getRegister(op1)
        println("The content of register $op1 is $value")
    }

    override fun toString(): String {
        return super.toString() + " prints the content of register: $op1"
    }



}