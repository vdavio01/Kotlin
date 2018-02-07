package sml.instructions

import sml.Instruction
import sml.Machine

class BnzInstruction(label: String, private val registerToCheck : Int, private val jumpTo: String)

    : Instruction(label, "bnz") {
    override fun execute(m: Machine) {
        if(m.registers.getRegister(registerToCheck) != 0) {
            m.pc = m.labels.getLabels().indexOf(jumpTo)
        }
    }

    override fun toString(): String {
        return super.toString() + " if the content of register $registerToCheck is zero," +
                " then execute the statement labeled [$jumpTo] "
    }

}