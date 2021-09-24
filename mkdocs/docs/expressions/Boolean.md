Supported boolean operations in expressions are as follow:
* AND (&&)
* OR (||)
* NOT (!)

#Example

    Schema booleanSchema {
        boolean truthValue
        boolean falseValue
    }

    value booleans -> booleanSchema {
        true
        false
    }

    Schema outputSchema {
        boolean andTT
        boolean andTF
        boolean andFT
        boolean andFF
        boolean orTT
        boolean orTF
        boolean orFT
        boolean orFF
        boolean notF
        boolean notT
    }

    Mapping booleanMapping input booleans as booleans output outputSchema {
        outputSchema.andTT = booleans.truthValue && booleans.truthValue
        outputSchema.andTF = booleans.truthValue && booleans.falseValue
        outputSchema.andFT = booleans.falseValue && booleans.truthValue
        outputSchema.andFF = booleans.falseValue && booleans.falseValue
        outputSchema.orTT = booleans.truthValue || booleans.truthValue
        outputSchema.orTF = booleans.truthValue || booleans.falseValue
        outputSchema.orFT = booleans.falseValue || booleans.truthValue
        outputSchema.orFF = booleans.falseValue || booleans.falseValue
        outputSchema.notF = !booleans.falseValue 
        outputSchema.notT = !booleans.truthValue 
    }

##Output for Example Flow

    {
        "andTT": true,
        "andTF": false,
        "andFT": false,
        "andFF": false,
        "orTT": true,
        "orTF": true,
        "orFT": true,
        "orFF": false,
        "notF": true,
        "notT": false
    }