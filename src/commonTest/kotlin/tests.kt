import components.xpath
import kotlin.test.Test
import kotlin.test.assertEquals

class test {
    @Test
    fun attributeAndChild() =
        assertEquals(
            "descendant-or-self::node()/child::div[attribute::id = '1']/child::span",
            xpath { any(div)[{ attr("id") equal "1" }] / span }.toString()
        )

    @Test
    fun indexTest() =
        assertEquals(
            "descendant-or-self::node()/child::div[position() = '1']", xpath { any(div)[1] }.toString()
        )

    @Test
    fun innertext() =
        assertEquals(
            "descendant-or-self::node()/child::div[attribute::id = 'thing' and translate(normalize-space(self::node()),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = 'sdfg']",
            xpath {
                any(div)[{attr("id") equal "thing" and textIs("sdfg")}]
            }.toString()
        )

    @Test
    fun child() =
        assertEquals(
            "descendant-or-self::node()/child::div/child::p[attribute::class = 'asdf']", xpath {
                any(div) / p[{attr("class") equal "asdf"}]
            }.toString()
        )

    //TODO: make these old tests work with the new rewrite
//    @Test
//    fun nested() =
//        assertEquals(
//            "//div[./div[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='asdf']]/div/components.getP[1]",
//            xpath {
//                descendantOrSelf / div { div("Asdf") } / div / components.getP(1)
//            }.toString()
//        )
//
//    @Test
//    fun escapequotes() =
//        //https://stackoverflow.com/questions/14822153/escape-single-quote-in-xpath-with-nokogiri
//        assertEquals(
//            "//*[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')=concat('\"that',\"'\",'components.getS mine\", he said.')]",
//            xpath {
//                anything("\"That'components.getS mine\", he said.")
//            }.toString()
//        )
//
//    @Test
//    fun innertextString() =
//        assertEquals(
//            "//asdf[@id='thing' and translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='sdfg']",
//            xpath {
//                descendantOrSelf / "asdf"("id" to "thing", text = "sdfg")
//            }.toString()
//        )
//
//    @Test
//    fun childstring() =
//        assertEquals(
//            "//div/components.getP[@class='asdf']",
//            xpath {
//                descendantOrSelf / "div" / "components.getP"("class" to "asdf")
//            }.toString()
//        )
//
//    @Test
//    fun nestedstring() =
//        assertEquals(
//            "//div[./div[translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='asdf']]/div/components.getP[1]",
//            xpath {
//                descendantOrSelf / "div" { "div"("Asdf") } / "div" / "components.getP"(1)
//            }.toString()
//        )
}