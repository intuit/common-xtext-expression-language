import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.ARRAY

class FilterSpecification extends Specification {

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

    def "Should filter with == expression correctly"() {
        setup:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(input)
                .withData(inputData)
                .evaluate()
        ArrayNode arrayNode = actualResult.value


        expect:
        expectedType == actualResult.getType()
        expectedSize == arrayNode.size()

        where:
        input                                                                       | expectedType | expectedSize
        ''' filter(dataSet2.someList, booleanAttribute == true) '''                 | ARRAY        | 1
        ''' filter(dataSet2.someList, booleanAttribute == false) '''                | ARRAY        | 1
        ''' filter(dataSet2.someList, stringAttribute == "SomeStringValue1") '''    | ARRAY        | 1
        ''' filter(dataSet2.someList, stringAttribute == "SomeStringValue2") '''    | ARRAY        | 1
        ''' filter(dataSet2.someList, stringAttribute == "Not Present in List") ''' | ARRAY        | 0
        ''' filter(dataSet2.someList, stringAttribute != "Not Present in List") ''' | ARRAY        | 2
        //''' filter(dataSet2.nonInDataSet2,
        //    stringAttribute == "SomeStringValue1") '''                              | ARRAY        | 0

    }

}
