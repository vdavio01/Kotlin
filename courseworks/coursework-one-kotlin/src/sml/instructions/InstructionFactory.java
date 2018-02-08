package sml.instructions;

import sml.Instruction;

import java.lang.reflect.InvocationTargetException;

public class InstructionFactory {

  /**
   * Generates the required Instruction
   * @param opcode Operation of the language
   * @param args the arguments for the operation
   * @return the required Instruction for the SML Machine
   */
  public static Instruction generateInstruction(String opcode, String[] args) {

    Class myClass = classProducer(opcode);
    Object result = null;
    try {

      Class[] typeOfRequiredArguments = myClass.getConstructors()[0].getParameterTypes();

      Object[] requiredArgs = constructorArguments(typeOfRequiredArguments, args);
      result = myClass.getConstructors()[0].newInstance(requiredArgs);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
    return (Instruction)result;
  }

  /**
   * Creates an array of objects
   * @param typeOfRequiredArgument an array with the class of each argument required by the constructor
   * @param inputArgs an array of strings with the input of the user
   * @return an array of objects which will be passed the to constructor
   */
  private static Object[] constructorArguments(Class[] typeOfRequiredArgument, String[] inputArgs) {

    Object[] args = new Object[typeOfRequiredArgument.length];

    if(inputArgs.length != typeOfRequiredArgument.length) {
      throw new IllegalArgumentException("Wrong number of Arguments");
    }

    for(int i = 0 ; i < typeOfRequiredArgument.length ; i ++) {

      if(typeOfRequiredArgument[i].getSimpleName().equals("int")) {
        args[i] = Integer.parseInt(inputArgs[i]);
      } else {
        args[i] = inputArgs[i];
      }
    }
    return args;
  }

  /**
   * Capitalize the first character of the label and concatenates it with "Instruction"
   * @param label Operation of the Language
   * @return the required Class
   */
  private static Class classProducer(String label) {
    Class myClass= null;
    try {
      myClass = Class.forName("sml.instructions."+label.substring(0,1).toUpperCase() + label.substring(1)+"Instruction");
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    }

    return myClass;
  }
}
