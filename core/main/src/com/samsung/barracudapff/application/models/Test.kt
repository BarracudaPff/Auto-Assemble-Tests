package com.samsung.barracudapff.application.models

import java.time.LocalDate

class Test(
    var testId: Int? = null,
    var sourceCode: String? = null,
    var clientId: Int? = null,
    var date: LocalDate? = null
) {
    override fun toString(): String {
        return "Test(testId=$testId, sourceCode=$sourceCode, clientId=$clientId, date=$date)"
    }
}
