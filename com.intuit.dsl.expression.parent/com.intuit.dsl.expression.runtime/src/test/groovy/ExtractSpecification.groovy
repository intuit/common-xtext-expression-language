import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.STRING

class ExtractSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    Map<String, JsonNode> inputData = new HashMap<String, JsonNode>()

    def setup() {
        Map<String, Object> dataSet = new HashMap<>()
        dataSet.put("someObject", ImmutableMap.of(
                "stringAttribute", "SomeStringValue1",
                "numberStringAttribute", "1234",
                "booleanAttribute", true
        ))
        ObjectMapper mapper = new ObjectMapper()
        inputData.put("dataSet", mapper.convertValue(dataSet, JsonNode.class))
    }

    def "Should extract correct value for a given range"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                                         | expectedType | expectedValue
        ''' extract("0123456789",0..) '''                             | STRING       | "0123456789"
        ''' extract("0123456789",2..) '''                             | STRING       | "23456789"
        ''' extract(dataSet.someObject.numberStringAttribute,2..) ''' | STRING       | "34"
    }

}
