package sml.instructions

import sml.Instruction
import sml.Machine
/**
 * Describes the SML DIV instruction
 *
 */
class DivInstruction(label: String, private val result: Int, private val op1: Int, private val op2: Int)
    : Instruction(label, "div") {


    /**
     * Executes the div instruction.
     * Divides the content of op1 register by the contents of register op2
     * and sets the result to the required register(result)
     */
    override fun execute(m: Machine) {
        val value1 = m.registers.getRegister(op1)
        val value2 = m.registers.getRegister(op2)
        m.registers.setRegister(result, value1 / value2)
    }

    override  fun toString(): String {
        return super.toString() + " $op1 / $op2 and store the result to register $result"
    }

}