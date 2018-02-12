package sml.instructions

import sml.Instruction
import sml.Machine
/**
 * Describes the SML Lin instruction
 *
 */
class LinInstruction(label: String, private val register: Int, private val value: Int) : Instruction(label, "lin") {

    /**
     * Executes the Lin Instruction.
     * Stores the value to the required register
     */
    override fun execute(m: Machine) {
        m.registers.setRegister(register, value)
    }

    override fun toString(): String {
        return super.toString() + "(store) to register " + register + " the value of " + value
    }
}
