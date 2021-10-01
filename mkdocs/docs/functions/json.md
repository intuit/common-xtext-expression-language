The json function converts the variable representing TSI xml data to a json.

#Syntax    
    output = json(expression)

###Inputs 
   **_expression_** : a reference to a TSI variable with xml data.

###Output
   **_output_** : a json representation of the TSI data.

#Example flow 
   
    Schema outputSchema {
      op [
        string HCY
        string HLY
      ]
    }

    Schema tsiSchema {
      S2016US1040PER {
        form FONLINE {
          field HCY
          field HLY
          field PRODTYPE
        }
      }
    }
    
    Service tsiService as getTsi input requestContext output tsiSchema {}

    Mapping finalMapping input tsiSchema output outputSchema {
      outputSchema.op = json(S2016US1040PER.FONLINE)
    }
    
    Flow tsiFlow {
      
      Start getTsi {
         transition {  finalMapping{} } 
      }
      finalMapping{}
    }

##Output for Example Flow
    { 
      op :  { HCLX : "b", HCLY : "a" }
    }

