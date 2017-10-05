package org.vld.sdp.creational

/**
 * Article Product interface
 */
interface Article {
    val name: String
}

/**
 * Article Creator Factory Method interface
 */
interface ArticleCreator {
    /**
     * Creates Article Product (factory method)
     */
    fun createArticle(name: String): Article
}

/**
 * Modern Article Product interface implementation
 */
data class ModernArticle(override val name: String) : Article

/**
 * Modern Article Creator Factory Method interface implementation
 *
 * Modern Article Creator singleton encapsulates the knowledge about the Modern Article single product
 */
object ModernArticleCreator : ArticleCreator {
    // the only place where the concrete Modern Article Product class is referenced
    override fun createArticle(name: String): Article = ModernArticle(name)
}

/**
 * Fancy Article Product interface implementation
 */
data class FancyArticle(override val name: String) : Article

/**
 * Fancy Article Creator Factory Method interface implementation
 *
 * Modern Article Creator singleton the encapsulates the knowledge about Fancy Article single product
 */
object FancyArticleCreator : ArticleCreator {
    // the only place where the concrete Fancy Article Product class is referenced
    override fun createArticle(name: String): Article = FancyArticle(name)
}
