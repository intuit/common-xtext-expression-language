The split function splits a string based on the splitter given and saves the result in an array.

#Syntax    
    output = split(expression, splitter)

###Inputs 
   **_expression_** : a reference to a variable or any [[expression|Expressions]].
   **_splitter_** : a string or a character based on which you want to split the string

###Output
   **_output_** : an array of strings resulted from splitting input.

#Example flow 

    Schema splitWordSchema {
        splitWord1 [string word1]
        splitWord2 [string word1]
        splitWord3 [string word1]
        splitWord4 [string word1]
        splitWord5 [string word1]
        splitWord6 [string word1]	
    }

    Schema wordSchema {
        string word1
        string word2
        string word3
        string word4
        string wordSplit
    }

    value dummyWord -> wordSchema {
        "a|b|c"
        "a.b.c"
        "[CS]v1|2C0872A1051D7A42-6000190C600082FB[CE]"
        "null"
    }


    Mapping splitMapping input dummyWord as dummyWord output splitWordSchema {
        splitWordSchema.splitWord1 = if(contains(dummyWord.word1,"a")) then split(dummyWord.word1,"\\|") else null
        splitWordSchema.splitWord2 = split(dummyWord.word2,"\\.")
        splitWordSchema.splitWord3 = split(dummyWord.word3,"\\|")
        splitWordSchema.splitWord4 = if(!contains(dummyWord.word4,"a")) then split(dummyWord.word4,"\\|") else null
        splitWordSchema.splitWord5 = split(dummyWord.word1,"\\.")
        splitWordSchema.splitWord6 =    split(splitWordSchema.splitWord3[1],"\\[") 
    }

##Output for Example Flow

    {
        "splitWord1": [
            "a",
            "b",
            "c"
        ],
        "splitWord2": [
            "a",
            "b",
            "c"
        ],
        "splitWord3": [
            "[CS]v1",
            "2C0872A1051D7A42-6000190C600082FB[CE]"
         ],
        "splitWord4": {
            "word1": null
        },
        "splitWord5": [
            "a|b|c"
        ],
        "splitWord6": [
            "2C0872A1051D7A42-6000190C600082FB",
            "CE]"
        ]
    }