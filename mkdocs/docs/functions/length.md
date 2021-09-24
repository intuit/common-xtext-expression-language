The length function gives the length of an expression. The expression is mostly a variable 

#Syntax    
    output = length(expression)

###Inputs 
   **_expression_** : a reference to a variable or any [[expression|Expressions]].

###Output
   **_output_** : a numerical value which represents the length of the input expression.

#Example flow 
   
    Schema dummy{
      a [string b]
    }
    Schema dummyOutput{
      number x 
    }
    value dummyValue -> dummy {
      a[{"x"}{"y"}]
    }

    Mapping dummyMapping input dummyValue as p output dummyOutput as q {
     q.x = length(p.a)
    }

##Output for Example Flow
    { x : 2 }

