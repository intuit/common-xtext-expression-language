Supported conditionals in expressions are:
* Less than (<)
* Greater than (>)
* Less than equal to (<=)
* Greater than equal to (>=)
* Equal to (==)
* Not equal to (!=)
* Fuzzy Equals (=~) (currently works only for strings with different case and numbers)
* Fuzzy not (!~) (currently works only for strings with different case and numbers)
* Ternary expression:
  Syntax : if [expression] then [trueValue] else [falseValue]

#Example

    Schema dataSchema {
        number zero
        number ten
        string lowerCaseOne
    }

    value data -> dataSchema {
        0
        10
        "one"
    }

    Schema outputSchema {
        boolean lt
        boolean gt
        boolean ltet
        boolean gtet
        boolean eq
        boolean neq
        boolean feqNumber
        boolean feqString
        boolean fneqNumber
        boolean fneqString
        string ternaryEx
    }

    Mapping conditionalMapping input data as data output outputSchema {
        outputSchema.lt = data.zero < data.ten
        outputSchema.gt = data.zero > data.ten
        outputSchema.ltet = data.zero <= data.ten
        outputSchema.gtet = data.zero >= data.ten
        outputSchema.eq = data.zero == data.ten
        outputSchema.neq = data.zero != data.ten
        outputSchema.feqNumber = data.zero =~ data.zero
        outputSchema.feqString = data.lowerCaseOne =~ "ONE"
        outputSchema.fneqNumber = data.zero !~ data.ten
        outputSchema.fneqString = data.lowerCaseOne !~ "ONES"
        outputSchema.ternaryEx = if (data.zero >= data.ten) then (data.zero * data.ten) else (data.zero + data.ten)
    }

##Output for Example Flow

    {
        "lt": true,
        "gt": false,
        "ltet": true,
        "gtet": false,
        "eq": false,
        "neq": true,
        "feqNumber": true,
        "feqString": true,
        "fneqNumber": true,
        "fneqString": true,
        "ternaryEx": "10"
     }

