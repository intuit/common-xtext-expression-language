Supported arithmetic operations in expressions are as follow:
* Plus (+)
* Minus (-)
* Multiplicationn (*)
* Division (/)
* Mod (%)


#Example

    Schema numbersSchema {
        number num1
        number num2
    }

    value numbers -> numbersSchema {
        1
        2
    }

    Schema outputSchema {
        number plusOp
        number minusOp
        number multOp
        number divOp
        number modOp
    }

    Mapping arithmeticMapping input numbers as numbers output outputSchema {
        outputSchema.plusOp = numbers.num1 + numbers.num2
        outputSchema.minusOp = numbers.num2 - numbers.num1
        outputSchema.multOp = numbers.num1 * numbers.num2
        outputSchema.divOp = numbers.num1 / numbers.num2
        outputSchema.modOp = numbers.num1 % numbers.num2
    }

##Output for Example Flow

    {
      "plusOp": 3,
      "minusOp": 1,
      "multOp": 2,
      "divOp": 0.5,
      "modOp": 1
    }