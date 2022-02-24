This function builds a new sorted list from a given list. It has a key parameter to specify the attribute to be used to make comparison from each element in list. 

# Syntax    
    sortedArray = sort(array, schemaVariable)
    sortedArray = sort(array, schemaVariable, orderType)

### Inputs 
   **_array_** : a reference to an array.

   **_schemaVariable_** : object’s attribute to be used for comparison.
   
   **_orderType_** : optional parameter to specify `ascending` (default value) or `descending` order  


### Output
   **_sortedArray_** : sorted array based on the **_orderType_**.

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
			"Bhavin"
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
}

Schema ResultSchema {
	sortById -> companyData
	reverseSortById -> companyData
}

Mapping sortMapping input employeeData as empData output ResultSchema {
	ResultSchema.sortById.employees = sort(empData.employees, id)
	ResultSchema.reverseSortById.employees = sort(empData.employees, id, descending)
}

Flow Sort {
	Start sortMapping {
	}
}
```
    
## Output for Example Flow
```
{
    "sortById": {
        "employees": [
            {
                "id": 321,
                "name": "Bhavin",
                "city": "San diego"
            },
            {
                "id": 456,
                "name": "Sam",
                "city": "Seattle"
            },
            {
                "id": 534,
                "name": "Alex",
                "city": "New York"
            }
        ]
    },
    "reverseSortById": {
        "employees": [
            {
                "id": 534,
                "name": "Alex",
                "city": "New York"
            },
            {
                "id": 456,
                "name": "Sam",
                "city": "Seattle"
            },
            {
                "id": 321,
                "name": "Bhavin",
                "city": "San diego"
            }
        ]
    }
}
```

## Explanation

The context of the variable **_id_** here is the array, which is **_empData.employees_**. (You don't have to specify the whole path i.e `empData.employees.id` to sort using the id for comparison).

In order to sort the array in reverse using the id, The parameter `descending` is passed. There is no need to pass an `ascending` parameter as by default the array is sorted in ascending order. 


