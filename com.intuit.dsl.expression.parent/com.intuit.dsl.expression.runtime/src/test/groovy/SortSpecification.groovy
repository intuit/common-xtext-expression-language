import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import spock.lang.Specification
import util.TestUtils

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.ARRAY

class SortSpecification extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    Map<String, JsonNode> inputData = new HashMap<String, JsonNode>()

    def setup() {
        Map<String, Object> dataSet = new HashMap<>()
        dataSet.put("someList", ImmutableList.of(
                ImmutableMap.of(
                        "id", 2,
                        "stringAttribute", "SomeStringValue1",
                        "booleanAttribute", true
                ),
                ImmutableMap.of(
                        "id", 1,
                        "stringAttribute", "SomeStringValue2",
                        "booleanAttribute", false
                ),
                ImmutableMap.of(
                        "id", 3,
                        "stringAttribute", "SomeStringValue3",
                        "booleanAttribute", true
                ),
        ))
        inputData.put("dataSet", TestUtils.MAPPER.convertValue(dataSet, JsonNode.class))
    }

    def "Should sort correctly in ascending order"() {
        given:
        def sortExpression =
                '''
                    sort(dataSet.someList, id)
                '''

        when:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(sortExpression)
                .withData(inputData)
                .evaluate()

        then:
        actualResult.getType() == ARRAY

        ArrayNode actualArrayNode = (ArrayNode)actualResult.getValue()
        actualArrayNode.size() == 3
        actualArrayNode.get(0).get("id").asInt() == 1;
        actualArrayNode.get(1).get("id").asInt() == 2;
        actualArrayNode.get(2).get("id").asInt() == 3;
    }

    def "Should sort correctly in descending order"() {
        given:
        def sortExpression =
                '''
                    sort(dataSet.someList, id, descending)
                '''

        when:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(sortExpression)
                .withData(inputData)
                .evaluate()

        then:
        actualResult.getType() == ARRAY

        ArrayNode actualArrayNode = (ArrayNode)actualResult.getValue()
        actualArrayNode.size() == 3
        actualArrayNode.get(0).get("id").asInt() == 3;
        actualArrayNode.get(1).get("id").asInt() == 2;
        actualArrayNode.get(2).get("id").asInt() == 1;
    }
}
