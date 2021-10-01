Given a string or a number, contains function will check for a specified substring in it.

# Syntax    
    output = contains(expression, searchText)

### Inputs 
   **_expression_** : a reference to a variable or any [[expression|Expressions]].

   **_searchText_** : A substring or a number to search from input expression value.

### Output
   **_output_** : A boolean depending on if substring is found or not in the input expression value.

# Example flow 
    Schema splitWordSchema {
        boolean containsInString
        boolean containsInNumber
        boolean containsStringNum
        boolean containsNumString
    }

    Schema wordSchema {
        string recipes
        string strNum
        number num
    }

    value dummyWord -> wordSchema {
        "GTKM=B&RTP=B"
        "GTKM=B&RTP=B89"
        8766756
    }

    Mapping containsMapping input dummyWord as dummyWord output splitWordSchema {
        splitWordSchema.containsInString =    contains(dummyWord.recipes, "RTP=B")
        splitWordSchema.containsInNumber =    contains(dummyWord.num, 7)
        splitWordSchema.containsStringNum =    contains(dummyWord.num, "7")
        splitWordSchema.containsNumString =    contains(dummyWord.strNum, "8")
    }

## Output for Example Flow

   
    {
        "containsInString": true,
        "containsInNumber": true,
        "containsStringNum": true,
        "containsNumString": true
    }
