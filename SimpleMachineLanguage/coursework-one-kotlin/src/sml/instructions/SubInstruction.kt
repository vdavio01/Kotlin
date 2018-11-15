package sml.instructions

import sml.Instruction
import sml.Machine

/**
 * Describes the SML SUB instruction
 */
class SubInstruction(label: String, private val result: Int, private val op1: Int, private val op2: Int)

    : Instruction(label, "sub") {

    /**
     * Executes the Sub instruction.
     * Subtracts the content of register op2 from the content of register op1
     * and stores the result to the required register
     */
    override fun execute(m: Machine) {
        val value1 = m.registers.getRegister(op1)
        val value2 = m.registers.getRegister(op2)
        m.registers.setRegister(result, value1 - value2)


    }

    override fun toString(): String {
        return super.toString() + " $op1 - $op2 to $result"
    }

}