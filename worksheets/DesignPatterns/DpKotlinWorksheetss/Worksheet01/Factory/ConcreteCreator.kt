package Worksheet01.Factory

class ConcreteCreator: Creator{

    override fun create(inpt: Any): Product {
      return  ConcreteProduct(inpt)
    }



}