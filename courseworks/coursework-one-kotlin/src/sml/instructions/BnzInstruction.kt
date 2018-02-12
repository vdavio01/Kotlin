package sml.instructions

import sml.Instruction
import sml.Machine

/**
 * Describes the SML Bnz instruction
 *
 */
class BnzInstruction(label: String, private val registerToCheck : Int, private val jumpTo: String)

    : Instruction(label, "bnz") {

    /**
     * Executes the bnz instruction.
     * If the content of register registerToCheck is not 0 it jumps
     * to the statement labeled (jumpTo)
     */
    override fun execute(m: Machine) {
        if(m.registers.getRegister(registerToCheck) != 0) {
            m.pc = m.labels.getLabels().indexOf(jumpTo)
        }
    }

    override fun toString(): String {
        return super.toString() + " if the content of register $registerToCheck is not zero," +
                " then execute the statement labeled [$jumpTo] otherwise move to the next statement. "
    }

}