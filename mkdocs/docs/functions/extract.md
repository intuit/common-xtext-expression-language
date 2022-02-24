The extract function extracts a substring from string, part of number from a number and range of elements from an array.

#Syntax    
    output = extract(expression, range)

###Inputs 
   **_expression_** : a reference to a variable or any [[expression|Expressions]].
   **_range_** : denoted by x..y where x and y are optional and integers.
                 Default value of x = 0
                 Default value of y = length of value of expression


###Output
   **_output_** : string, number or array depending on input.

#Example flow 

    Schema dummy {
        string string1
        string nullstring
        number number1
        arrayinput [
            string key
        ]
        jsonObject {
          string jfield
        }
        boolean flag
      }

    Schema dummyOutput {
      string result1
      string result2
      string result3
      string result4
      string result5
      string result6
      string result7
      string result8
      string result9
      string result10
      string result11
      string result12
      string result13
      string result14
      string result15
      string result16
      string result17
      number result18
      number result19
      number result20
      arrayoutput1 [
        string key
      ]
      arrayoutput2 [
        string key
      ]
      arrayoutput3 [
        string key
      ]
      arrayoutput4 [
        string key
      ]
      resultJsonObject {
        string jfield
      }
      string resultJson
      string resultflag
      string invalidRange1
    }

    value dummyValue1 -> dummy {
  	  "hello"
  	  ${null}
        675575757
        arrayinput [
        	{
        		"field1"
        	}
        	{
        		"field2"	
        	}
        	{
        		"field3"	
        	}
        	{
        		"field4"	
        	}
        ]
        jsonObject {
        	"jsonField1"
        }
        true
    }

    Mapping dummyMapping input dummyValue1 as x output dummyOutput as op {
      op.result1 = extract(x.nullstring, 5..9)
      op.result2 = extract(x.nullstring, ..)
      op.result3 = extract(x.nullstring, 1..)
      op.result4 = extract(x.nullstring, ..4)
        
      op.result5 = extract(x.string1, 0..2)
      op.result6 = extract(x.string1, 5..9)
      op.result7 = extract(x.string1, 5..)
      op.result8 = extract(x.string1, 1..)
      op.result9 = extract(x.string1, 9..)
      op.result10 = extract(x.string1, ..2)
      op.result11 = extract(x.string1, ..5)
      op.result12 = extract(x.string1, ..)
      op.result13 = extract(x.string1, 0..0)
      op.result14 = extract(x.string1, 5..5)
        
      op.result15 = extract(x.number1, 5..9)
      op.result16 = extract(x.number1, 0..5)
      op.result17 = extract(x.number1, ..)
      op.result18 = extract(x.number1, ..5)
      op.result19 = extract(x.number1, 3..)
      op.result20 = extract(x.number1, 3..30)
        
      op.arrayoutput1 = extract(x.arrayinput, 1..2)
      op.arrayoutput2 = extract(x.arrayinput, ..3)
      op.arrayoutput3 = extract(x.arrayinput, 2..)
      op.arrayoutput4 = extract(x.arrayinput, ..)
        
      op.resultJsonObject = extract(x.jsonObject, ..)
      op.resultJson = extract(x.jsonObject, ..)
      
      op.resultflag = extract(x.flag, 1..2)
      
      op.invalidRange1 = extract(x.string1, hivd..fwfwedsf)
        
    }

    Flow mappingFlow {
        Start dummyMapping {}
    }

##Output for Example Flow

    {
      "result1": null,
      "result2": null,
      "result3": null,
      "result4": null,
      "result5": "he",
      "result6": null,
      "result7": "",
      "result8": "ello",
      "result9": null,
      "result10": "he",
      "result11": "hello",
      "result12": "hello",
      "result13": "hello",
      "result14": "",
      "result15": "5757",
      "result16": "67557",
      "result17": "675575757",
      "result18": 67557,
      "result19": 575757,
      "result20": null,
      "arrayoutput1": [
        {
          "key": "field2"
        }
      ],
      "arrayoutput2": [
        {
          "key": "field1"
        },
        {
          "key": "field2"
        },
        {
          "key": "field3"
        }
      ],
      "arrayoutput3": [
        {
          "key": "field3"
        },
        {
          "key": "field4"
        }
      ],
      "arrayoutput4": [
        {
          "key": "field1"
        },
        {
          "key": "field2"
        },
        {
          "key": "field3"
        },
        {
          "key": "field4"
        }
      ],
      "resultJsonObject": {
        "jfield": null
      },
      "resultJson": null,
      "resultflag": null,
      "invalidRange1": "hello"
      }

    