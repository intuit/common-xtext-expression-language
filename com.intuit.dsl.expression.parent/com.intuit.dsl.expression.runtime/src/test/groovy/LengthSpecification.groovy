import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import com.intuit.dsl.expression.runtime.model.NumberValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.NUMBER

class LengthSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    Map<String, JsonNode> inputData = new HashMap<String, JsonNode>()

    def setup() {
        Map<String, Object> dataSet1 = new HashMap<>()
        Map<String, Object> dataSet2 = new HashMap<>()
        dataSet2.put("someList", ImmutableList.of(
                ImmutableMap.of(
                        "stringAttribute", "SomeStringValue1",
                        "booleanAttribute", true
                ),
                ImmutableMap.of(
                        "stringAttribute", "SomeStringValue2",
                        "booleanAttribute", false
                ),
        ))
        ObjectMapper mapper = new ObjectMapper()
        inputData.put("dataSet1", mapper.convertValue(dataSet1, JsonNode.class))
        inputData.put("dataSet2", mapper.convertValue(dataSet2, JsonNode.class))
    }

    def "Should give correct size for a filter expression"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()


        expect:
        expectedType == actualResult.getType()

        NumberValue numberValue = actualResult.getValue()
        expectedLength == numberValue.get()

        where:
        input                                                                               | expectedType  | expectedLength
        ''' length(filter(dataSet2.someList, booleanAttribute == true)) '''                 | NUMBER        | 1
        ''' length(filter(dataSet2.someList, booleanAttribute == false)) '''                | NUMBER        | 1
        ''' length(filter(dataSet2.someList, stringAttribute == "SomeStringValue1")) '''    | NUMBER        | 1
        ''' length(filter(dataSet2.someList, stringAttribute == "SomeStringValue2")) '''    | NUMBER        | 1
        ''' length(filter(dataSet2.someList, stringAttribute == "Not Present in List")) ''' | NUMBER        | 0
        ''' length(filter(dataSet2.someList, stringAttribute != "Not Present in List")) ''' | NUMBER        | 2
    }
}
