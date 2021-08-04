import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.STRING

class ConcatSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    Map<String, JsonNode> inputData = new HashMap<String, JsonNode>()

    def setup() {
        Map<String, Object> dataSet = new HashMap<>()
        dataSet.put("anObject", ImmutableMap.of(
                "aString", "abc",
                "aNumber", "123",
                "aBoolean", true
        ))
        ObjectMapper mapper = new ObjectMapper()
        inputData.put("data", mapper.convertValue(dataSet, JsonNode.class))
    }

    def "Should concat string literals correctly"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                                     | expectedType | expectedValue
        ''' concat("FirstString","SecondString") '''              | STRING       | "FirstStringSecondString"
        ''' concat("FirstString","SecondString","LastString") ''' | STRING       | "FirstStringSecondStringLastString"
    }

    def "Should concat with variables correctly"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                                             | expectedType | expectedValue
        ''' concat("a", data.anObject.aString, "z") '''                   | STRING       | "aabcz"
        ''' concat(data.anObject.aNumber, data.anObject.aString, "z") ''' | STRING       | "123abcz"
    }

    def "Should concat with output of extract function correctly"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()
        expectedValue == actualResult.getValue()

        where:
        input                                                        | expectedType | expectedValue
        ''' concat(extract(data.anObject.aString,1..), "z") '''      | STRING       | "bcz"
        ''' concat("a", extract(data.anObject.aString,1..), "z") ''' | STRING       | "abcz"
    }

}
