import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.BOOLEAN
import static com.intuit.dsl.expression.runtime.model.DataValue.Type.STRING

class CaseSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    def "Should perform lowercase operations correctly"() {
        setup:
            DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
            DataValue.Type outputType = value.getType()
            def actualValue = value.getValue()

        expect:
            outputType == expectedType
            actualValue == expectedValue

        where:
            input                       |   expectedType     | expectedValue
            'lowerCase("ABC")'          |    STRING          |     "abc"
            'lowerCase("ABCxyz001")'    |    STRING          |     "abcxyz001"
            'lowerCase("001")'          |    STRING          |     "001"
            'lowerCase("$$,,...^%&")'   |    STRING          |     "\$\$,,...^%&"
    }

    def "Should perform uppercase operations correctly"() {
        setup:
        DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
        DataValue.Type outputType = value.getType()
        def actualValue = value.getValue()

        expect:
        outputType == expectedType
        actualValue == expectedValue

        where:
        input                       |   expectedType     | expectedValue
        'upperCase("ABC")'          |    STRING          |     "ABC"
        'upperCase("abc")'          |    STRING          |     "ABC"
        'upperCase("abcXYZ001")'    |    STRING          |     "ABCXYZ001"
        'upperCase("001")'          |    STRING          |     "001"
        'upperCase("$$,,...^%&")'   |    STRING          |     "\$\$,,...^%&"
    }
}
