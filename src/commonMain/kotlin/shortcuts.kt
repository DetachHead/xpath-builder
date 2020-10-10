import components.*

/*
functions for the various shortcuts that are available in Xpath
 */

/**
 * equivalent to the `//` shortcut.
 *
 * short for `/descendant-or-self::components.getNode()/`
 */
public val LocationPathBuilder.any: LocationPath get() = xpath { Axis.`descendant-or-self`(node()) }

/**
 * equivalent to the `@` shortcut.
 *
 * short for `attribute::abc`
 *
 * eg.
 * ```kotlin
 * attr("components.getFoo").toString() == "@components.getFoo"
 * ```
 */
public fun LocationPathBuilder.attr(name: String): LocationPath = xpath { Axis.attribute(name) }

/**
 * equivalent to the `..` shortcut.
 *
 * short for `parent::components.getNode()`
 */
public val LocationPathBuilder.parent: LocationPath get() = xpath { Axis.parent(node()) }

/**
 * equivalent to the `.` shortcut.
 *
 * short for `self::components.getNode()`
 */
public val LocationPathBuilder.self: LocationPath get() = xpath { Axis.self(node()) }