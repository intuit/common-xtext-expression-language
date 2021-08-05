import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.BOOLEAN

class BooleanSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    def "Should perform boolean operations(|| and &&) correctly"() {
        setup:
            DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
            DataValue.Type outputType = value.getType()
            def actualValue = value.getValue()

        expect:
            outputType == expectedType
            actualValue == expectedValue

        where:
            input                       |   expectedType     | expectedValue
            'true || true'              |    BOOLEAN         |     true
            'true && true'              |    BOOLEAN         |     true
            'true || false'             |    BOOLEAN         |     true
            'false || false'            |    BOOLEAN         |     false
            'false && true'             |    BOOLEAN         |     false
            'false && false'            |    BOOLEAN         |     false
//            'true || 0'                 |    BOOLEAN         |     true
//            'false || 0'                |    BOOLEAN         |     true
//            '0 || 0'                    |    BOOLEAN         |     false

    }

    def "Should perform boolean operations(OR and AND) correctly"() {
        setup:
        DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
        DataValue.Type outputType = value.getType()
        def actualValue = value.getValue()

        expect:
        outputType == expectedType
        actualValue == expectedValue

        where:
        input                       |   expectedType     | expectedValue
        'true OR true'              |    BOOLEAN         |     true
        'true AND true'             |    BOOLEAN         |     true
        'true OR false'             |    BOOLEAN         |     true
        'false or false'            |    BOOLEAN         |     false
        'false and true'            |    BOOLEAN         |     false
        'false and false'           |    BOOLEAN         |     false
//        'true OR 0'                 |    BOOLEAN         |     true
//        'false OR 0'                |    BOOLEAN         |     true
//        '0 OR 0'                    |    BOOLEAN         |     false

    }

    def "Should perform compound boolean operations(&& and ||) correctly"() {
        setup:
        DataValue value = expressionRuntime.withExpressionContent(input).evaluate()
        DataValue.Type outputType = value.getType()
        def actualValue = value.getValue()

        expect:
        outputType == expectedType
        actualValue == expectedValue

        where:
        input                                       |   expectedType     | expectedValue
        '(false || false) || false'                 |    BOOLEAN         |     false
        '(false || true) || true'                   |    BOOLEAN         |     true
        'false || (false || false)'                 |    BOOLEAN         |     false
        'true  || (false || true)'                  |    BOOLEAN         |     true
        '(false || false)  || (false || false)'     |    BOOLEAN         |     false
        '(false || true)   || (false || true)'      |    BOOLEAN         |     true
        '((1+1) == 2) || (2+2 == 4)'                |    BOOLEAN         |     true
        '((1+1) == 3) || (2+2 == 4)'                |    BOOLEAN         |     true
        '((1+1) == 2) || (2+2 == 5)'                |    BOOLEAN         |     true
        '((1+1) == 3) || (2+2 == 5)'                |    BOOLEAN         |     false
        '(false && false) && false'                 |    BOOLEAN         |     false
        'false && (false && false)'                 |    BOOLEAN         |     false
        'true && (true && true)'                    |    BOOLEAN         |     true
        '(false && false)  && (false && false)'     |    BOOLEAN         |     false
        '(true && true)   && (true && true)'        |    BOOLEAN         |     true
        '((1+1) == 2) && (2+2 == 4)'                |    BOOLEAN         |     true
        '((1+1) == 3) && (2+2 == 4)'                |    BOOLEAN         |     false
        '((1+1) == 2) && (2+2 == 5)'                |    BOOLEAN         |     false
    }
}
