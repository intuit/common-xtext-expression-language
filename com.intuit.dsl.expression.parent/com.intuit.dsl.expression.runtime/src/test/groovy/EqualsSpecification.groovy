import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.BOOLEAN

class EqualsSpecification extends Specification{

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    def "Should evaluate equals operation correct"() {
        setup:
        DataValue actualResult = expressionRuntime.withExpressionContent(input).evaluate()

        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.value

        where:
        input                                   |  expectedType    | expectedValue
        '1.0 == 1.0'                            |   BOOLEAN        |    true
        '1.0 == 2.0'                            |   BOOLEAN        |    false
        '1 == 1'                                |   BOOLEAN        |    true
        '1 == 2'                                |   BOOLEAN        |    false
        'false == false'                        |   BOOLEAN        |    true
        'true == false'                         |   BOOLEAN        |    false
        '"SameStr" == "SameStr"'                |   BOOLEAN        |    true
        '"SameStr" == "NotTheSameStr"'          |   BOOLEAN        |    false
        '\'a\' == \'a\''                        |   BOOLEAN        |    true
        '\'a\' == \'b\''                        |   BOOLEAN        |    false
    }

}
