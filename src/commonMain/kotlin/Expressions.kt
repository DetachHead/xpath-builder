/**
 * any valid Xpath expression, not necessarily a [LocationPath]
 */
public open class Expression(public val value: String) {
    public constructor(value: XpathString) : this(value.toString())
    public constructor(value: Boolean) : this(XpathString(value.toString()))
    public constructor(value: Int) : this(value.toString())

    override fun toString(): String = value
}

/** a string represented in an xpath [Expression]. automatically handles escaping quote characters */
public class XpathString(public val value: String) {
    override fun toString(): String = when {
        //xpath has no real way of escaping, so use various ways to esc values with quotes.
        //https://stackoverflow.com/questions/14822153/escape-single-quote-in-xpath-with-nokogiri
        value.contains("'") && value.contains("\"") ->
            "concat('${value.replace("'", "',\"'\",'")}')"
        value.contains("'") -> "\"$value\""
        else -> "'$value'"
    }
}

/** combines two [Expression]s together with an [Operator] */
private fun operatorExpression(first: Expression, operator: Operator, second: Expression): Expression =
    Expression("$first $operator $second")

/** creates an expression with an xpath [function call](https://en.wikipedia.org/wiki/XPath#Functions_and_operators) */
private fun functionExpression(name: String, args: List<Expression?> = listOf()): Expression =
    Expression("$name(${args.filterNotNull().joinToString(",")})")

/**
 * typesafe builder for [Expression] for use as [predicates](https://en.wikipedia.org/wiki/XPath#Predicates)
 */
public class PredicateBuilder : Buildable<Expression> {
    private lateinit var predicate: Expression
    override fun build(): Expression = predicate

    private fun Expression.operator(
        operator: Operator,
        other: Expression
    ): Expression = operatorExpression(this, operator, other).also { predicate = it }

    /* Xpath operators */
    //=:
    public infix fun Expression.equal(other: Expression): Expression = this.operator(ComparisonOperator.`=`, other)
    public infix fun Expression.equal(other: String): Expression = this equal Expression(XpathString(other))
    public infix fun String.equal(other: Expression): Expression = Expression(this) equal other
    public infix fun String.equal(other: String): Expression = Expression(this) equal other

    //!=:
    public infix fun Expression.not(other: Expression): Expression = this.operator(ComparisonOperator.`=`, other)
    public infix fun Expression.not(other: String): Expression = this not Expression(XpathString(other))
    public infix fun String.not(other: Expression): Expression = Expression(this) not other
    public infix fun String.not(other: String): Expression = Expression(this) not other

    //>:
    public infix fun Expression.greaterThan(other: Expression): Expression = operator(ComparisonOperator.greater, other)
    public infix fun Expression.greaterThan(other: Int): Expression = greaterThan(Expression(other))
    public infix fun Int.greaterThan(other: Expression): Expression = Expression(this) greaterThan other
    public infix fun Int.greaterThan(other: Int): Expression = Expression(this) greaterThan other

    //>=:
    public infix fun Expression.greaterThanOrEqualTo(other: Expression): Expression =
        operator(ComparisonOperator.greaterOrEqual, other)

    public infix fun Expression.greaterThanOrEqualTo(other: Int): Expression =
        greaterThanOrEqualTo(Expression(other.toString()))

    public infix fun Int.greaterThanOrEqualTo(other: Expression): Expression =
        Expression(toString()) greaterThanOrEqualTo other

    public infix fun Int.greaterThanOrEqualTo(other: Int): Expression =
        Expression(toString()) greaterThanOrEqualTo other

    //<:
    public infix fun Expression.lessThan(other: Expression): Expression = operator(ComparisonOperator.less, other)
    public infix fun Expression.lessThan(other: Int): Expression = lessThan(Expression(other.toString()))
    public infix fun Int.lessThan(other: Expression): Expression = Expression(toString()) lessThan other
    public infix fun Int.lessThan(other: Int): Expression = Expression(toString()) lessThan other

    //<=:
    public infix fun Expression.lessThanOrEqualTo(other: Expression): Expression =
        operator(ComparisonOperator.lessOrEqual, other)

    public infix fun Expression.lessThanOrEqualTo(other: Int): Expression =
        greaterThanOrEqualTo(Expression(other.toString()))

    public infix fun Int.lessThanOrEqualTo(other: Expression): Expression =
        Expression(toString()) lessThanOrEqualTo other

    public infix fun Int.lessThanOrEqualTo(other: Int): Expression =
        Expression(toString()) lessThanOrEqualTo other

    //and:
    public infix fun Expression.and(other: Expression): Expression = operator(BooleanOperator.and, other)

    //or:
    public infix fun Expression.or(other: Expression): Expression = operator(BooleanOperator.or, other)

    /*
     * [Xpath functions](https://en.wikipedia.org/wiki/XPath#Functions_and_operators)
     */
    public fun LocationPath.compare(operator: ComparisonOperator, other: String): Expression =
        this.toString().compare(operator, other)

    public infix fun String.equals(other: String): Expression = this.compare(ComparisonOperator.`=`, other)
    public infix fun LocationPath.equals(other: String): Expression = this.toString() equals other

    public infix fun String.greaterThan(other: Int): Expression =
        this.compare(ComparisonOperator.greater, other.toString())

    public infix fun LocationPath.equals(other: Int): Expression = this.toString() greaterThan other
}