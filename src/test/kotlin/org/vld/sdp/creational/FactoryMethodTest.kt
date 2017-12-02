package org.vld.sdp.creational

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FactoryMethodTest {

    @DisplayName("Given a factory method. When create a single product. Then return the requested single product")
    @ParameterizedTest(name = "{1}")
    @MethodSource("factoryMethodProvider")
    fun givenFactoryMethod_whenCreateSingleProduct_thenReturnRequestedSingleProduct(
            factoryMethod: ArticleCreator,
            articleName: String,
            expectedArticle: Article
    ) {
        // Given & When
        // client works only with the ArticleCreator factory method interface
        // and the Article signle product interface
        val article: Article = factoryMethod.createArticle(articleName)
        // Then
        assertThat(article).isEqualTo(expectedArticle)
    }

    fun factoryMethodProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                    ModernArticleCreator,
                    "Modern Article",
                    ModernArticle("Modern Article")
            ),
            Arguments.of(
                    FancyArticleCreator,
                    "Fancy Article",
                    FancyArticle("Fancy Article")
            )
    )
}
