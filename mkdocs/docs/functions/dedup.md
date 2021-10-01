This function builds a new list dropping duplicates except the first occurrence from a given list. It has an optional key parameter to specify the attribute to be used to make comparison from each element in list. 

# Syntax    
    deduplicatedArray = dedup(array)
    deduplicatedArray = dedup(array, schemaVariable)

### Inputs 
   **_array_** : a reference to an array.

   **_schemaVariable_** : object’s attribute to be used for comparison.

### Output
   **_deduplicatedArray_** : array after dropping duplicates except the first occurrence based on the key **_schemaVariable_** if present.

# Example flow 
```
Schema companyData {
	employees [ 
		number id
		string name
		string city
		boolean isPermanent
	]
}

value employeeData -> companyData {
	employees [
		{
			321
			"Bhavin"
			"San diego"
			true
		}
		{
			321
			"Bhavin"
			"San diego"
			true
		}
		{
			345
			"Alex"
			"San diego"
			false
		}
		{
			456
			"Bhavin"
			"New York"
			false
		}
		{
			456
			"Alex"
			"San diego"
			true
		}
	]
}

Schema ResultSchema {
	dedupByName -> companyData
	dedupByEmployee -> companyData
}

Mapping dedupMapping input employeeData as empData output ResultSchema {
	ResultSchema.dedupByName.employees = dedup(empData.employees, name)
	ResultSchema.dedupByEmployee.employees = dedup(empData.employees)
}

Flow dedup {
	Start dedupMapping {
		
	}
}
```
    
## Output for Example Flow
```
{
    "dedupByName": {
        "employees": [
            {
                "id": 321,
                "name": "Bhavin",
                "city": "San diego",
                "isPermanent": true
            },
            {
                "id": 345,
                "name": "Alex",
                "city": "San diego",
                "isPermanent": false
            }
        ]
    },
    "dedupByEmployee": {
        "employees": [
            {
                "id": 321,
                "name": "Bhavin",
                "city": "San diego",
                "isPermanent": true
            },
            {
                "id": 345,
                "name": "Alex",
                "city": "San diego",
                "isPermanent": false
            },
            {
                "id": 456,
                "name": "Bhavin",
                "city": "New York",
                "isPermanent": false
            },
            {
                "id": 456,
                "name": "Alex",
                "city": "San diego",
                "isPermanent": true
            }
        ]
    }
}
```

## Explanation

The context of the variable **_name_** in the example is the array, which is **_empData.employees_**. (You don't have to specify the whole path i.e `empData.employees.name` to **_dedup_** using the name attribute for comparison).

In order to **_dedup_** the array on employee objects, We do not need to pass any parameter for **_schemaVariable_** attribute, by default the elements of the passed array are compared.


