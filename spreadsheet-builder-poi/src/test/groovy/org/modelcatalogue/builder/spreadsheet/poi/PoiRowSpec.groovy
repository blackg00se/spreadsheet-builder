package org.modelcatalogue.builder.spreadsheet.poi

import spock.lang.Specification
import spock.lang.Unroll

class PoiRowSpec extends Specification {

    @Unroll
    def "parse column #column to number #index"() {
        expect:
        PoiRow.parseColumn(column) == index
        where:
        column  | index
        'A'     | 1
        'B'     | 2
        'Z'     | 26
        'AA'    | 27
        'AB'    | 28
        'DA'    | 105
    }

}
