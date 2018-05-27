package github.npospolita.twino.table

import spock.lang.Specification

/**
 * @author NPospolita
 * @since 26.05.2018
 */
class SimpleMemoryTableTest extends Specification {

    private SimpleMemoryTable table

    def setup() {
        table = new SimpleMemoryTable(10, 15)
    }

    def "Put method should return previous value or null"() {
        expect:
        table.put(5, 7, value) == null
        table.put(5, 6, newValue) == value


        where:
        value  | newValue
        "test" | "newTest"
    }

    def "Put method should throw an exception, when accessed incorrectly"() {
        when:
        table.put(column, row, null)

        then:
        thrown(IllegalArgumentException)

        where:
        column | row
        999    | 0
        0      | 999
        999    | 999
    }

    def "Get method should return previous value or null"() {
        when:
        table.get(5, 7) == null
        table.put(5, 7, value)

        then:
        table.get(5, 7) == value

        where:
        value << "test"
    }


    def "Get method should throw an exception, when accessed incorrectly"() {
        when:
        table.get(column, row)

        then:
        thrown(IllegalArgumentException)

        where:
        column | row
        999    | 0
        0      | 999
        999    | 999
    }

}
