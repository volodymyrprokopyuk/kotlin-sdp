package org.vld.sdp.creational

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractFactoryTest {

    @DisplayName("Given an abstract factory. When create a familiy of products. Then return the requested products")
    @ParameterizedTest(name = "{1}, {2}")
    @MethodSource("abstractFactoryProvider")
    fun givenAbstractFactory_whenCreateProducts_thenReturnRequestedProducts(
            abstractFactory: DocumentCreator,
            letterName: String,
            resumeName: String,
            expectedLetter: Letter,
            expectedResume: Resume
    ) {
        // Given & When
        // client works only with abstract factory interface (DocumentCreator)
        // and family product interfaces (Letter and Resume)
        val letter: Letter = abstractFactory.createLetter(letterName)
        val resume: Resume = abstractFactory.createResume(resumeName)
        // Then
        assertThat(letter).isEqualTo(expectedLetter)
        assertThat(resume).isEqualTo(expectedResume)
    }

    fun abstractFactoryProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                    ModernDocumentCreator,
                    "Modern Letter",
                    "Modern Resume",
                    ModernLetter("Modern Letter"),
                    ModernResume("Modern Resume")
            ),
            Arguments.of(
                    FancyDocumentCreator,
                    "Fancy Letter",
                    "Fancy Resume",
                    FancyLetter("Fancy Letter"),
                    FancyResume("Fancy Resume")
            )
    )

}
