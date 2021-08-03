import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.BOOLEAN

class EqualitySpecification extends Specification{

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    def "Should evaluate == operation correctly"() {
        setup:
        DataValue actualResult = expressionRuntime.withExpressionContent(input).evaluate()

        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.value

        where:
        input                                               |   expectedType    | expectedValue
        '1.0 == 1.0'                                        |   BOOLEAN        |    true
        '1.0 == 2.0'                                        |   BOOLEAN        |    false
        '1 == 1'                                            |   BOOLEAN        |    true
        '1 == 2'                                            |   BOOLEAN        |    false
        '-1 == -1'                                          |   BOOLEAN        |    true
        '-1 == 1'                                           |   BOOLEAN        |    false
        '9223372036854775807 == 9223372036854775807'        |   BOOLEAN        |    true
        '9223372036854775807 == 9223372036854775806'        |   BOOLEAN        |    false
        '9.999999999999999 == 9.999999999999999'            |   BOOLEAN        |    true
        '9.99999999999999999999 == 9.99999999999999999999'  |   BOOLEAN        |    true
        'false == false'                                    |   BOOLEAN        |    true
        'true == false'                                     |   BOOLEAN        |    false
        '"SameStr" == "SameStr"'                            |   BOOLEAN        |    true
        '"SameStr" == "NotTheSameStr"'                      |   BOOLEAN        |    false
        '\'a\' == \'a\''                                    |   BOOLEAN        |    true
        '\'a\' == \'b\''                                    |   BOOLEAN        |    false
    }

    def "Should evaluate != operation correctly"() {
        setup:
        DataValue actualResult = expressionRuntime.withExpressionContent(input).evaluate()

        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.value

        where:
        input                                               |   expectedType    | expectedValue
        '1.0 != 1.0'                                        |   BOOLEAN        |    false
        '1.0 != 2.0'                                        |   BOOLEAN        |    true
        '1 != 1'                                            |   BOOLEAN        |    false
        '1 != 2'                                            |   BOOLEAN        |    true
        '-1 != -1'                                          |   BOOLEAN        |    false
        '-1 != 1'                                           |   BOOLEAN        |    true
        '9223372036854775807 != 9223372036854775807'        |   BOOLEAN        |    false
        '9223372036854775807 != 9223372036854775806'        |   BOOLEAN        |    true
        '9.999999999999999 != 9.999999999999999'            |   BOOLEAN        |    false
        '9.99999999999999999999 != 9.99999999999999999999'  |   BOOLEAN        |    false
        'false != false'                                    |   BOOLEAN        |    false
        'true != false'                                     |   BOOLEAN        |    true
        '"SameStr" != "SameStr"'                            |   BOOLEAN        |    false
        '"SameStr" != "NotTheSameStr"'                      |   BOOLEAN        |    true
        '\'a\' != \'a\''                                    |   BOOLEAN        |    false
        '\'a\' != \'b\''                                    |   BOOLEAN        |    true
    }

    def "Should evaluate < operation correctly"() {
        setup:
        DataValue actualResult = expressionRuntime.withExpressionContent(input).evaluate()

        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.value

        where:
        input                                               |   expectedType    | expectedValue
        '1.0 < 1.0'                                         |   BOOLEAN         |    false
        '1.0 < 2.0'                                         |   BOOLEAN         |    true
        '0.0 < 1.0'                                         |   BOOLEAN         |    true
        '0 < 0'                                             |   BOOLEAN         |    false
        '-1 < 0'                                            |   BOOLEAN         |    true
        '0 < 1'                                             |   BOOLEAN         |    true
        '9223372036854775806 < 9223372036854775807'         |   BOOLEAN         |    true
        '9223372036854775807 < 9223372036854775806'         |   BOOLEAN         |    false
        '9.99999999999999999998 < 9.99999999999999999999'   |   BOOLEAN         |    true
        '9.99999999999999999999 < 9.99999999999999999998'   |   BOOLEAN         |    false

        // currently returns false if not a number
        //'"A" < "B"'                                         |   BOOLEAN        |    true
        //'"a" < "b"'                                         |   BOOLEAN        |    true
    }

    def "Should evaluate > operation correctly"() {
        setup:
        DataValue actualResult = expressionRuntime.withExpressionContent(input).evaluate()

        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.value

        where:
        input                                               |   expectedType    | expectedValue
        '2.0 > 1.0'                                         |   BOOLEAN         |    true
        '1.0 > 2.0'                                         |   BOOLEAN         |    false
        '0.0 > 1.0'                                         |   BOOLEAN         |    false
        '1 > 0'                                             |   BOOLEAN         |    true
        '-1 > 0'                                            |   BOOLEAN         |    false
        '0 > 1'                                             |   BOOLEAN         |    false
        '9223372036854775806 > 9223372036854775807'         |   BOOLEAN         |    false
        '9223372036854775807 > 9223372036854775806'         |   BOOLEAN         |    true
        '9.99999999999999999998 > 9.99999999999999999999'   |   BOOLEAN         |    false
        '9.99999999999999999999 > 9.99999999999999999998'   |   BOOLEAN         |    true

        // currently returns false if not a number
        //'"A" < "B"'                                         |   BOOLEAN        |    true
        //'"a" < "b"'                                         |   BOOLEAN        |    true
    }

}
