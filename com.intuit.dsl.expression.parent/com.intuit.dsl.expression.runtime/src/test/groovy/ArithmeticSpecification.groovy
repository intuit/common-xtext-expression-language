import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import com.intuit.dsl.expression.runtime.model.NumberValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.NUMBER

class ArithmeticSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    def "Should perform addition operations correctly"() {
        setup:
            DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
            DataValue.Type outputType = value.getType()
            NumberValue numberValue = value.getValue()
            def actualValue = numberValue.get()

        expect:
            outputType == expectedType
            actualValue == expectedValue

        where:
            input                       |   expectedType    | expectedValue
            '1+2'                       |    NUMBER         |      3
            '0+(-5)'                    |    NUMBER         |     -5
            '(-10)+(-5)'                |    NUMBER         |     -15
            '0+0'                       |    NUMBER         |     0
            '100+0.0001'                |    NUMBER         |     100.0001
            '0.99999999999999+0.01'     |    NUMBER         |     1.00999999999999
    }

    def "Should perform subtraction operations correctly"() {
        setup:
        DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
        DataValue.Type outputType = value.getType()
        NumberValue numberValue = value.getValue()
        def actualValue = numberValue.get()

        expect:
        outputType == expectedType
        actualValue == expectedValue

        where:
        input           | expectedType | expectedValue
        '-2-0'          |    NUMBER    |     -2
        '5-5'           |    NUMBER    |     0
        '0-1'           |    NUMBER    |     -1
        '-2-(-5)'       |    NUMBER    |     3

    }

    def "Should perform division operations correctly"() {
        setup:
        DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
        DataValue.Type outputType = value.getType()
        NumberValue numberValue = value.getValue()
        def actualValue = numberValue.get()

        expect:
        outputType == expectedType
        actualValue == expectedValue

        where:
        input           | expectedType | expectedValue
        '1/1'           |    NUMBER    |     1
        '355/5'         |    NUMBER    |     71
        '1/2'           |    NUMBER    |     0.5
        '-221/2'        |    NUMBER    |     -110.5
    }

    def "Should perform multiplication operations correctly"() {
        setup:
        DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
        DataValue.Type outputType = value.getType()
        NumberValue numberValue = value.getValue()
        def actualValue = numberValue.get()

        expect:
        outputType == expectedType
        actualValue == expectedValue

        where:
        input           | expectedType | expectedValue
        '1*0'           |    NUMBER    |     0
        '300*5'         |    NUMBER    |     1500
        '0.01*0.0009'   |    NUMBER    |     0.000009
        '-221.9*-2'     |    NUMBER    |     443.8
    }

    def "Should throw exception for incorrect inputs"() {
        when:
        expressionRuntime.withExpressionContent(input).evaluate()

        then:
        def error = thrown(expectedException)
        error.message == expectedMessage

        where:
        input                |     expectedException        | expectedMessage
        '1/0'                |     ArithmeticException      |    '/ by zero'
    }

}
