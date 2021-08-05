import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import com.intuit.dsl.expression.runtime.ExpressionRuntime
import com.intuit.dsl.expression.runtime.model.DataValue
import org.apache.commons.lang3.BooleanUtils
import spock.lang.Specification
import util.TestUtils

import java.time.LocalDateTime
import java.time.ZoneId

import static com.intuit.dsl.expression.runtime.model.DataValue.Type.ARRAY

class ComplexExpressionTest extends Specification {

    def expressionRuntime = ExpressionRuntime.newExpressionRuntime()

    Map<String, JsonNode> inputData = new HashMap<String, JsonNode>()

    def setup() {

        ZoneId defaultZone = ZoneId.systemDefault()
        long tenDaysFromNow = LocalDateTime.now().atZone(defaultZone).plusDays(10).toInstant().toEpochMilli()

        // dataSet1
        Map<String, Object> dataSet1 = new HashMap<>()
        dataSet1.put("aNumberString", "1234")

        inputData.put("dataSet1", TestUtils.MAPPER.convertValue(dataSet1, JsonNode.class))

        // dataSet2
        Map<String, Object> dataSet2 = new HashMap<>()
        dataSet2.put("someList", ImmutableList.of(
                ImmutableMap.of(
                        "stringAttribute1", "SomeStringValue1",
                        "stringAttribute2", "SomeStringValue2",
                        "booleanAttribute", true,
                        "tenDaysFromNow", tenDaysFromNow,
                        "someArray", ImmutableList.of("abc34789")
                ),
                ImmutableMap.of(
                        "stringAttribute1", "SomeStringValue2",
                        "stringAttribute2", "SomeStringValue2",
                        "booleanAttribute", false,
                        "tenDaysFromNow", tenDaysFromNow,
                        "someArray", ImmutableList.of("abc34789")
                ),
        ))

        inputData.put("dataSet2", TestUtils.MAPPER.convertValue(dataSet2, JsonNode.class))
    }

    def "Should evaluate a complex expression correctly"() {
        given:
        def complexExpression =
            '''
                filter(
                    filter(dataSet2.someList,
                        booleanAttribute == true &&
                        (
                            (stringAttribute1 == "SomeStringValue1" && contains(stringAttribute2,"SomeStringValue2") && dateFormat("MM/dd/yyyy","ms",currentDate()) < tenDaysFromNow)
                            || (stringAttribute1 == "123" && contains(stringAttribute2,"xyz"))
                        )
                    )
                    ,contains(someArray, concat("abc",extract(::dataSet1.aNumberString,2..),"789") )
                )
            '''

        when:
        DataValue actualResult = expressionRuntime
                .withExpressionContent(complexExpression)
                .withData(inputData)
                .evaluate()


        then:
        actualResult.getType() == ARRAY

        ArrayNode actualArrayNode = (ArrayNode)actualResult.getValue()
        actualArrayNode.size() == 1
        actualArrayNode.get(0).get("stringAttribute1").asText() == "SomeStringValue1"
        BooleanUtils.isTrue(actualArrayNode.get(0).get("booleanAttribute").asBoolean())

    }
}
