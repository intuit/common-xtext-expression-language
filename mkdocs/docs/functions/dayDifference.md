#Syntax
    dayDifference(input1, input2, format)

**_input1_** : Value of Date form which you want to subtract.

**_input2_** : Value of Date to be subtracted.

**_format_** : Format can be any input from the following pre defined formats but both the inputs need to be in same format.
    
### Formats   
    MM/dd/yyyy
    yyyyMMdd
    yyyy-MM-dd



#Example Flow

    Schema dummy1 {
      string a
      string b
      string c
      string d
    }

    Schema dummy2 {
      string p
      string q
      string r
      string s
    }

    Schema dummyOutput {
      number result1
      number result2
      number result3
      number result4
      number result5
      number result6
    }

    value dummyValue1 -> dummy1 {
      "10/16/1990"
      "10/16/2018"
      "20161209"
      "2000-11-2"
    }

    value dummyValue2 -> dummy2 {
      "10/16/1990"
      "10/19/2018"
      "20161215"
      "2000-11-12"
    }

    Mapping dummyMapping input dummyValue1 as x, dummyValue2 as y output dummyOutput as op {
      op.result1 = dayDifference(x.a, y.p, "MM/dd/yyyy")
      op.result2 = dayDifference(x.b, y.q, "MM/dd/yyyy")
      op.result3 = dayDifference(x.b, y.p, "MM/dd/yyyy")
      op.result4 = dayDifference(x.a, y.q, "MM/dd/yyyy")
      op.result5 = dayDifference(x.c, y.r, "yyyyMMdd")
      op.result6 = dayDifference(x.d, y.s, "yyyy-MM-dd")
    }

    End end

    Flow mappingFlow {
      Start dummyMapping {
        transition {
             true ? end : end
          }
      }
      end  {}
    }

#Example Output

    {
      "result1": 0,
      "result2": 3,
      "result3": -10227,
      "result4": 10230,
      "result5": 6,
      "result6": 10
    }