#Syntax
    dateFormat(inputFormat, outputFormat, expression, inputTimeZone, outputTimeZone)

**_inputFormat_** : Input format can be any input from the following pre defined formats.
    
**_outputFormat_** : Output format can be any input from the following pre defined formats.

### Input/ Output Formats   
    MM/dd/yyyy
    yyyyMMdd
    yyyy-MM-dd
    yyyy-MM-dd'T'HH:mm:ssZ
    ms   - miliseconds (representing epoch time)

**_expression_** : Expression is the value of date which needs to be converted. 

**_inputTimeZone_** : Input TimeZone. It is an optional parameter. The default value is V4OS system timezone. If you are at west, it will be PST. If you are at east, it will be EST. The ID for a TimeZone, either an abbreviation such as "PST", a full name such as "America/Los_Angeles", or a custom ID such as "GMT-8:00". See details [here](https://docs.oracle.com/javase/7/docs/api/java/util/TimeZone.html#getTimeZone(java.lang.String))

**_outputTimeZone_** : Output TimeZone. It is an optional parameter.  It is an optional parameter. The default value is V4OS system timezone. If you are at west, it will be PST. If you are at east, it will be EST. The ID for a TimeZone, either an abbreviation such as "PST", a full name such as "America/Los_Angeles", or a custom ID such as "GMT-8:00". See details [here](https://docs.oracle.com/javase/7/docs/api/java/util/TimeZone.html#getTimeZone(java.lang.String))

#Example Flow

    Schema datesSchema {
      string MMddyyyy_slash
      string yyyyMMdd
      string yyyyMMdd_hyphen
      number msNumber
      string msString
      string fromTimeZone
      string toTimeZone
    }

    Schema formatedDates {
      string date1
      string date2
      string date3
      string date4
      number date5
      string date6
      string date7
      string date8
      string date9
      string date10
      string date11
      string date12
      string date13
      string date14
    }

    value dates -> datesSchema {
      "02/20/1991"
      "19910220"
      "1991-02-20"
      94670856000
      "667036800000"
      "UTC"
      "GMT-0400"
    }

    Mapping dateFormatMapping input dates as dates output formatedDates as formatedDates {	
      formatedDates.date1 = dateFormat("MM/dd/yyyy","yyyyMMdd", dates.MMddyyyy_slash)
      formatedDates.date2 = dateFormat("yyyyMMdd","yyyy-MM-dd", dates.yyyyMMdd)
      formatedDates.date3 = dateFormat("yyyy-MM-dd","MM/dd/yyyy", dates.yyyyMMdd_hyphen)
      formatedDates.date4 = dateFormat("MM/dd/yyyy","ms", dates.MMddyyyy_slash)
      formatedDates.date5 = dateFormat("MM/dd/yyyy","ms", dates.MMddyyyy_slash) + dates.msNumber
      formatedDates.date6 = dateFormat("ms","MM/dd/yyyy", dates.msString)
      formatedDates.date7 = dateFormat("ms","yyyyMMdd", dates.msString)
      formatedDates.date8 = dateFormat("ms","yyyy-MM-dd", dates.msString)
      formatedDates.date9 = dateFormat("MM/dd/yyyy","MM/dd/yyyy", dates.MMddyyyy_slash)
      formatedDates.date10 = dateFormat("yyyyMMdd","yyyyMMdd", dates.yyyyMMdd)
      formatedDates.date11 = dateFormat("yyyy-MM-dd","yyyy-MM-dd", dates.yyyyMMdd_hyphen)
      formatedDates.date12 = dateFormat("ms","ms", dates.msString)
      formatedDates.date13 = dateFormat("yyyyMMdd","yyyy-MM-dd", dates.MMddyyyy_slash)
      formatedDates.date14 = dateFormat("ms","yyyy-MM-dd'T'HH:mm:ssZ", "1630624704000", dates.fromTimeZone, dates.toTimeZone)
    }

    End end

    Flow dateFormatFlow {
      Start dateFormatMapping {
        transition {
             true ? end : end
        }
    }
    
      end {}
    }

#Example Output

    {
      "date1": "19910220",
      "date2": "1991-02-20",
      "date3": "02/20/1991",  
      "date4": "667036800000",
      "date5": 761707656000,
      "date6": "02/20/1991",
      "date7": "19910220",
      "date8": "1991-02-20",
      "date9": "02/20/1991",
      "date10": "19910220",
      "date11": "1991-02-20",
      "date12": "667036800000",
      "date13": "02/20/1991",
      "date14": "2021-09-02T19:18:24-0400",
    }