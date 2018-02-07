package sml.instructions

import sml.Instruction
import sml.Machine

class OutInstruction(label: String, private val op1: Int): Instruction(label, "out") {
    override fun execute(m: Machine) {
        val value = m.registers.getRegister(op1)
        println(value)
    }

    override fun toString(): String {
        return super.toString() + " prints register: $op1"
    }



}