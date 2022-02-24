This function builds a new shuffled array from a given array. Shuffled array means the order of elements in the array is changed in random manner. It works only on collection. Doesn't work on primitive types like String, Int etc

# Syntax    
    shuffledArray = shuffle(array)

### Inputs 
   **_array_** : a reference to an array. 

### Output
   **_shuffledArray_** : shuffled array

# Example flow 
```
Schema companyData {
	employees [ 
		number id
		string name
		string city
	]
}

value employeeData -> companyData {
	employees [
		{
			321
			"John"
			"San diego"
		}
		{
			534
			"Alex"
			"New York"
		}
		{
			456
			"Sam"
			"Seattle"
		}
	]
        numberArray [
		1
		2
		3
		4
	]
	shuffleString: "abcd"
	shuffleNumber: 1234
	shuffleNull: ${null}
}

Mapping sortMapping input employeeData as empData output companyData as resultSchema {
	resultSchema.employees = shuffle(empData.employees)
	resultSchema.numberArray = shuffle(empData.numberArray)
	resultSchema.shuffleString = shuffle(empData.shuffleString)
	resultSchema.shuffleNumber = shuffle(empData.shuffleNumber)
	resultSchema.shuffleNull = shuffle(empData.shuffleNull)
}

Flow Shuffle {
	Start shuffleMapping {}
}
```
    
## Output for Example Flow
```
{
  "employees": [
    {
      "id": 534,
      "name": "Alex",
      "city": "New York"
    },
    {
      "id": 321,
      "name": "John",
      "city": "San diego"
    },
    {
      "id": 456,
      "name": "Sam",
      "city": "Seattle"
    }
  ],
  "numberArray": [
    4,
    1,
    3,
    2
  ],
  "shuffleString": "abcd",
  "shuffleNumber": 1234,
  "shuffleNull": null
}
```



