package com.sksamuel.kotest.annotation

import io.kotest.core.annotation.EnabledIf
import io.kotest.core.annotation.SpecEnabledIf
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FunSpec
import kotlin.reflect.KClass

class MySpecDisabler : SpecEnabledIf() {
    override fun enabled(specKlass: KClass<out Spec>): Boolean {
        return false
    }
}

@EnabledIf(MySpecDisabler::class)
class MyCompleteFailureSpec : FunSpec({
    beforeSpec { throw RuntimeException() }
    afterSpec { throw RuntimeException() }
    
    test("Should never run") {
        throw RuntimeException()
    }
})