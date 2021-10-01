The filter function filters the objects from an array based on some condition.

# Syntax    
    filteredArray = filter(array, booleanExpression)

### Inputs 
   **_array_** : a reference to an array.

   **_booleanExpression_** : conditional expression to filter the objects in the array.

### Output
   **_filteredArray_** : filtered array based on the condition.

# Example flow 
   
    Schema w2Schema {
      w2 [
        string employerName
        number wages
      ]
    }
    
    value income -> w2Schema {
      w2 [
         {
           "Intuit, Inc.
           105000
         }
         {
           "Uber
           10000
         }
      ]
    }
    
    Schema thresholdSchema {
      number wages
    }
    
    value threshold -> thresholdSchema { 100000 }

    Mapping finalMapping input income, threshold output w2Schema as output {
      output.w2 = filter(income.w2, employerName == "Intuit, Inc." && wages > ::threshold.wages)
    }
    
    Flow filterFlow {      
      Start finalMapping {
      }
    }

## Output for Example Flow
    { 
      w2 :  [{ employerName : "Intuit, Inc.", wages : 105000 }
    }

## Explanation

The condition is `employerName == "Intuit, Inc." && wages > ::threshold.wages`. 

The first part of the condition says `employerName == "Intuit, Inc."`. The context of the variable **employerName** here is the array, which is **income.w2**. (You don't have to specify the whole path i.e `income.w2.employerName` to filter the w2s).

The second part of the condition says `wages > ::threshold.wages"`. The variable **wages** here is within the context of w2 but if you want to refer something which is outside the scope of w2, you need to refer it with a global scope operator **::**


