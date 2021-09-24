The join function joins an array based on the key with a delimiter and last_delimiter.

# Syntax 
    output = join(expression,key,delimiter,last_delimiter)

### Inputs 
   **_expression_** : a reference to a variable or any [[expression|Expressions]]. This variable needs to be a json array or a string array

   **_key_** : This is optional. It represents the key if the expression is a json array. Skip this parameter in case of String array.
   
   **_delimiter_** : The delimiter to join on.

   **_last_delimiter_** : The last delimiter.

### Output
   **_output_** : The joined string.

# Example flow 
    Schema dependentsSchema {
        spouse {
           string name
        }
        children[
           string name
        ]
    }

    Schema joinOutputSchema {
        string dependentsText
    }

    value dependents -> dependentsSchema {
        spouse { "Foo" }
        children [
           { "A" }
           { "B" }
           { "C" }
        ]
    }

    Mapping finalMapping input dependents output joinOutputSchema {
        joinOutputSchema.dependentsText = join(dependents.children,name,",","and")
    }

## Output for Example Flow
    {
       "dependentsText" : "A, B and C"
    }