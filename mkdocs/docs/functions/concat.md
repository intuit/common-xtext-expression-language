The concat function concats two or more objects and gives an object back.

#Syntax 
    output = concat(expression, expression)

###Inputs 
   **_expression_** : a reference to a variable or any [[expression|Expressions]].

###Output
   **_output_** : a concatenated object from input.

#Example flow 

    Schema input1 {
        string a
        b [string c]
        d {string e}
    }

    Schema input2 {
        string p
        q [string r]
        s {string t}
    }

    Schema concatOutput {
        string result1
        result2 [
            string op
        ]
        string result3
        string result4
        result5 [
            string op
        ]
        string result6
    }

    value inputValue1 -> input1 {
        "hello"
        b[{"12345"}]
        d{ "V1-120-a3qteenpmrvmjzjm45hrlr"}
    }

    value inputValue2 -> input2 {
        "world"
        q[{"V1-120-a3qteenpmrvmjzjm45hrlr"}]
        s{"12345"}
    }

    Mapping concatMapping input inputValue1 as x, inputValue2 as y output concatOutput as op {
        op.result1 = concat(x.a,y.p)
        op.result2 = concat(x.b,y.q)
        op.result3 = concat(x.d.e,y.s.t)  
        op.result4 = concat("",null) 
        op.result5 = concat(x.b,null)
        op.result6 = concat(null,null)
    }

##Output for Example Flow

    {
        "result1": "helloworld",
        "result2": [
            {
                "c": "12345"
            },
            {
                "r": "V1-120-a3qteenpmrvmjzjm45hrlr"
            }
        ],
        "result3": "V1-120-a3qteenpmrvmjzjm45hrlr12345",
        "result4": "",
        "result5": [
            {
                "c": "12345"
            }
        ],
        "result6": null
    }


