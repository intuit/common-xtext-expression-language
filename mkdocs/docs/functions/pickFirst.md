The pickFirst function picks the first object from various provided objects based on some condition.

# Syntax    
    firstValuePicked = pickFirst(object1, object2,... -> booleanExpression)

### Inputs 
   **_objects_** : comma separated 1 or more objects

   **_booleanExpression_** : conditional expression that applies to current object. (eg: **_it_** > 100)

### Output
   **_firstValuePicked_** : the first object value that caused the boolean expression to evaluate to true.

# Example flow 
   
    Schema triageSchema {
      coreProfile {
        number taxYear 
      }
    }

    Schema requestContext {
        number taxYear
    }
    
    value triageValue -> triageSchema {
      coreProfile {
           1980
         }
    }
    
    value requestContextValue -> requestContext { 2015 }
    
    Schema result {
    	number taxYear
    }

    Mapping finalMapping input triageValue, requestContextValue output result {
      result.taxYear = pickFirst(triageValue.coreProfile.taxYear, requestContextValue.taxYear -> it>2000)
    }
    
    Flow filterFlow {      
      Start finalMapping {
      }
    }

## Output for Example Flow
```
{ taxYear : 2015 }
```


