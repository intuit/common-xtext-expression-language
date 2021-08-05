import com.fasterxml.jackson.databind.JsonNode
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification
import util.TestUtils

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.BOOLEAN

class ContainsSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    Map<String, JsonNode> inputData = new HashMap<String, JsonNode>()

    def setup() {

        Map<String, Object> dataSet = ImmutableMap.of(
                "stringAttribute1", "This contains searchString",
                "stringAttribute2", "SomeStringValue2",
                "booleanAttribute", true,
                "arrayOfString", ImmutableList.of("This is a string in an array"),
                "arrayOfInteger", ImmutableList.of(-4, -2, 0, 2, 4)
        )

        inputData.put("dataSet", TestUtils.MAPPER.convertValue(dataSet, JsonNode.class))
    }

    def "Should evaluate contains() function on a string"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                                      | expectedType | expectedValue
        ''' contains(dataSet.stringAttribute1, "searchString") ''' | BOOLEAN      | true
        ''' contains(dataSet.stringAttribute2, "searchString") ''' | BOOLEAN      | false
    }

    def "Should evaluate contains() function on an Array of Strings"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                                                     | expectedType | expectedValue
        ''' contains(dataSet.arrayOfString, "string in an array") '''             | BOOLEAN      | true
        ''' contains(dataSet.arrayOfString, "not a substring of any element") ''' | BOOLEAN      | false

    }

    def "Should evaluate contains() function on an Array of Integer"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                        | expectedType | expectedValue
        ''' contains(dataSet.arrayOfInteger, -2) ''' | BOOLEAN      | true
        ''' contains(dataSet.arrayOfInteger, 2) '''  | BOOLEAN      | true
        ''' contains(dataSet.arrayOfInteger, 10) ''' | BOOLEAN      | false

    }
}