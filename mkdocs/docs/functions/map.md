The map function is used to perform one to one mapping on elements from an array to a result array, after some processing or as is.  

# Syntax    
    resultArray = map(array {Range} -> {
                      result_attr_i1 = array_attr_k1
                      result_attr_i2 = array_attr_k2
                  })

### Inputs 
   **_array_** : a reference to an array.

   **_Range_** :This is an **_optional_** input giving a sequence of integers. Please refer [[Range]] for the syntax. Map function will only execute on elements in the input array at given sequence of indices.  

### Output
   **_resultArray_** : Array returned after the mapping.

# Example flow 
```
Schema inputSchema {
	string a
	string b
	number c
	boolean d
	object {
		string a
		string b
	}
	array [
		string a
		string b
		string c
		number d
	]
}

value inputValue -> inputSchema {
	"A"
	"B"
	1
	true
	object {
		"a"
		"b"
	}
	array [
		{
			"a"
			"a"
			"c"
			100
		}
		{
			"a"
			"b"
			"c"
			10
		}
		{
			"a"
			"b"
			"c"
			1
		}
		{
			"a"
			"b"
			"c"
			0
		}
	]
}

Schema outputSchema {
	mapArray [
		string name
		string desc
		string amount
	]
	mapObject {
		string name
		string value
	}
	mapOperator [
		string name
		string amount
	]
	mapArrayWithRange [
		string name
		string desc
		string amount
	]
	 
}

Mapping outPutMapping input inputValue as inputValue output outputSchema {
	
	outputSchema.mapArray = map(inputValue.array->{
		name = a
		desc = b
		amount = d
	})
	
	outputSchema.mapArrayWithRange = map(inputValue.array{0..1}->{
		name = a
		desc = b
		amount = d
	})
	
	outputSchema.mapObject = map(inputValue.object->{
		name = a
		value = b
	})
	
	outputSchema.mapOperator = inputValue.array->(d==100){
		name = a
		amount = d
	}
}

Flow mapFlow {
	Start outPutMapping{}
}

```

