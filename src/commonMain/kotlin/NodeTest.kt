import kotlin.reflect.KProperty

/**
 * an xpath node test. more info [here](https://en.wikipedia.org/wiki/XPath#Node_tests)
 */
public class NodeTest(public val value: String) {
    override fun toString(): String = value
}

private class NodeDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): NodeTest = NodeTest(property.name)
}

//constants for HTML node tests (https://developer.mozilla.org/en-US/docs/Web/HTML/Element):
public val LocationPathBuilder.base: NodeTest by NodeDelegate()
public val LocationPathBuilder.head: NodeTest by NodeDelegate()
public val LocationPathBuilder.link: NodeTest by NodeDelegate()
public val LocationPathBuilder.meta: NodeTest by NodeDelegate()
public val LocationPathBuilder.style: NodeTest by NodeDelegate()
public val LocationPathBuilder.title: NodeTest by NodeDelegate()
public val LocationPathBuilder.body: NodeTest by NodeDelegate()
public val LocationPathBuilder.address: NodeTest by NodeDelegate()
public val LocationPathBuilder.article: NodeTest by NodeDelegate()
public val LocationPathBuilder.aside: NodeTest by NodeDelegate()
public val LocationPathBuilder.footer: NodeTest by NodeDelegate()
public val LocationPathBuilder.header: NodeTest by NodeDelegate()
public val LocationPathBuilder.h1: NodeTest by NodeDelegate()
public val LocationPathBuilder.h2: NodeTest by NodeDelegate()
public val LocationPathBuilder.h3: NodeTest by NodeDelegate()
public val LocationPathBuilder.h4: NodeTest by NodeDelegate()
public val LocationPathBuilder.h5: NodeTest by NodeDelegate()
public val LocationPathBuilder.h6: NodeTest by NodeDelegate()
public val LocationPathBuilder.hgroup: NodeTest by NodeDelegate()
public val LocationPathBuilder.main: NodeTest by NodeDelegate()
public val LocationPathBuilder.nav: NodeTest by NodeDelegate()
public val LocationPathBuilder.section: NodeTest by NodeDelegate()
public val LocationPathBuilder.blockquote: NodeTest by NodeDelegate()
public val LocationPathBuilder.dd: NodeTest by NodeDelegate()
public val LocationPathBuilder.div: NodeTest by NodeDelegate()
public val LocationPathBuilder.dl: NodeTest by NodeDelegate()
public val LocationPathBuilder.dt: NodeTest by NodeDelegate()
public val LocationPathBuilder.figcaption: NodeTest by NodeDelegate()
public val LocationPathBuilder.figure: NodeTest by NodeDelegate()
public val LocationPathBuilder.hr: NodeTest by NodeDelegate()
public val LocationPathBuilder.li: NodeTest by NodeDelegate()
public val LocationPathBuilder.ol: NodeTest by NodeDelegate()
public val LocationPathBuilder.p: NodeTest by NodeDelegate()
public val LocationPathBuilder.ul: NodeTest by NodeDelegate()
public val LocationPathBuilder.a: NodeTest by NodeDelegate()
public val LocationPathBuilder.abbr: NodeTest by NodeDelegate()
public val LocationPathBuilder.b: NodeTest by NodeDelegate()
public val LocationPathBuilder.bdi: NodeTest by NodeDelegate()
public val LocationPathBuilder.bdo: NodeTest by NodeDelegate()
public val LocationPathBuilder.br: NodeTest by NodeDelegate()
public val LocationPathBuilder.cite: NodeTest by NodeDelegate()
public val LocationPathBuilder.code: NodeTest by NodeDelegate()
public val LocationPathBuilder.data: NodeTest by NodeDelegate()
public val LocationPathBuilder.dfn: NodeTest by NodeDelegate()
public val LocationPathBuilder.em: NodeTest by NodeDelegate()
public val LocationPathBuilder.i: NodeTest by NodeDelegate()
public val LocationPathBuilder.kbd: NodeTest by NodeDelegate()
public val LocationPathBuilder.mark: NodeTest by NodeDelegate()
public val LocationPathBuilder.q: NodeTest by NodeDelegate()
public val LocationPathBuilder.rb: NodeTest by NodeDelegate()
public val LocationPathBuilder.rp: NodeTest by NodeDelegate()
public val LocationPathBuilder.rt: NodeTest by NodeDelegate()
public val LocationPathBuilder.rtc: NodeTest by NodeDelegate()
public val LocationPathBuilder.ruby: NodeTest by NodeDelegate()
public val LocationPathBuilder.s: NodeTest by NodeDelegate()
public val LocationPathBuilder.samp: NodeTest by NodeDelegate()
public val LocationPathBuilder.small: NodeTest by NodeDelegate()
public val LocationPathBuilder.span: NodeTest by NodeDelegate()
public val LocationPathBuilder.strong: NodeTest by NodeDelegate()
public val LocationPathBuilder.sub: NodeTest by NodeDelegate()
public val LocationPathBuilder.sup: NodeTest by NodeDelegate()
public val LocationPathBuilder.time: NodeTest by NodeDelegate()
public val LocationPathBuilder.u: NodeTest by NodeDelegate()
public val LocationPathBuilder.`var`: NodeTest by NodeDelegate()
public val LocationPathBuilder.wbr: NodeTest by NodeDelegate()
public val LocationPathBuilder.area: NodeTest by NodeDelegate()
public val LocationPathBuilder.audio: NodeTest by NodeDelegate()
public val LocationPathBuilder.img: NodeTest by NodeDelegate()
public val LocationPathBuilder.map: NodeTest by NodeDelegate()
public val LocationPathBuilder.track: NodeTest by NodeDelegate()
public val LocationPathBuilder.video: NodeTest by NodeDelegate()
public val LocationPathBuilder.embed: NodeTest by NodeDelegate()
public val LocationPathBuilder.iframe: NodeTest by NodeDelegate()
public val LocationPathBuilder.`object`: NodeTest by NodeDelegate()
public val LocationPathBuilder.param: NodeTest by NodeDelegate()
public val LocationPathBuilder.picture: NodeTest by NodeDelegate()
public val LocationPathBuilder.source: NodeTest by NodeDelegate()
public val LocationPathBuilder.canvas: NodeTest by NodeDelegate()
public val LocationPathBuilder.noscript: NodeTest by NodeDelegate()
public val LocationPathBuilder.script: NodeTest by NodeDelegate()
public val LocationPathBuilder.del: NodeTest by NodeDelegate()
public val LocationPathBuilder.ins: NodeTest by NodeDelegate()
public val LocationPathBuilder.caption: NodeTest by NodeDelegate()
public val LocationPathBuilder.col: NodeTest by NodeDelegate()
public val LocationPathBuilder.colgroup: NodeTest by NodeDelegate()
public val LocationPathBuilder.table: NodeTest by NodeDelegate()
public val LocationPathBuilder.tbody: NodeTest by NodeDelegate()
public val LocationPathBuilder.td: NodeTest by NodeDelegate()
public val LocationPathBuilder.tfoot: NodeTest by NodeDelegate()
public val LocationPathBuilder.th: NodeTest by NodeDelegate()
public val LocationPathBuilder.thead: NodeTest by NodeDelegate()
public val LocationPathBuilder.tr: NodeTest by NodeDelegate()
public val LocationPathBuilder.button: NodeTest by NodeDelegate()
public val LocationPathBuilder.datalist: NodeTest by NodeDelegate()
public val LocationPathBuilder.fieldset: NodeTest by NodeDelegate()
public val LocationPathBuilder.form: NodeTest by NodeDelegate()
public val LocationPathBuilder.input: NodeTest by NodeDelegate()
public val LocationPathBuilder.label: NodeTest by NodeDelegate()
public val LocationPathBuilder.legend: NodeTest by NodeDelegate()
public val LocationPathBuilder.meter: NodeTest by NodeDelegate()
public val LocationPathBuilder.optgroup: NodeTest by NodeDelegate()
public val LocationPathBuilder.option: NodeTest by NodeDelegate()
public val LocationPathBuilder.output: NodeTest by NodeDelegate()
public val LocationPathBuilder.progress: NodeTest by NodeDelegate()
public val LocationPathBuilder.select: NodeTest by NodeDelegate()
public val LocationPathBuilder.textarea: NodeTest by NodeDelegate()
public val LocationPathBuilder.details: NodeTest by NodeDelegate()
public val LocationPathBuilder.dialog: NodeTest by NodeDelegate()
public val LocationPathBuilder.menu: NodeTest by NodeDelegate()
public val LocationPathBuilder.summary: NodeTest by NodeDelegate()
public val LocationPathBuilder.slot: NodeTest by NodeDelegate()
public val LocationPathBuilder.template: NodeTest by NodeDelegate()
public val LocationPathBuilder.acronym: NodeTest by NodeDelegate()
public val LocationPathBuilder.applet: NodeTest by NodeDelegate()
public val LocationPathBuilder.basefont: NodeTest by NodeDelegate()
public val LocationPathBuilder.bgsound: NodeTest by NodeDelegate()
public val LocationPathBuilder.big: NodeTest by NodeDelegate()
public val LocationPathBuilder.blink: NodeTest by NodeDelegate()
public val LocationPathBuilder.center: NodeTest by NodeDelegate()
public val LocationPathBuilder.command: NodeTest by NodeDelegate()
public val LocationPathBuilder.content: NodeTest by NodeDelegate()
public val LocationPathBuilder.dir: NodeTest by NodeDelegate()
public val LocationPathBuilder.element: NodeTest by NodeDelegate()
public val LocationPathBuilder.font: NodeTest by NodeDelegate()
public val LocationPathBuilder.frame: NodeTest by NodeDelegate()
public val LocationPathBuilder.frameset: NodeTest by NodeDelegate()
public val LocationPathBuilder.image: NodeTest by NodeDelegate()
public val LocationPathBuilder.isindex: NodeTest by NodeDelegate()
public val LocationPathBuilder.keygen: NodeTest by NodeDelegate()
public val LocationPathBuilder.listing: NodeTest by NodeDelegate()
public val LocationPathBuilder.marquee: NodeTest by NodeDelegate()
public val LocationPathBuilder.menuitem: NodeTest by NodeDelegate()
public val LocationPathBuilder.multicol: NodeTest by NodeDelegate()
public val LocationPathBuilder.nextid: NodeTest by NodeDelegate()
public val LocationPathBuilder.nobr: NodeTest by NodeDelegate()
public val LocationPathBuilder.noembed: NodeTest by NodeDelegate()
public val LocationPathBuilder.noframes: NodeTest by NodeDelegate()
public val LocationPathBuilder.plaintext: NodeTest by NodeDelegate()
public val LocationPathBuilder.shadow: NodeTest by NodeDelegate()
public val LocationPathBuilder.spacer: NodeTest by NodeDelegate()
public val LocationPathBuilder.strike: NodeTest by NodeDelegate()
public val LocationPathBuilder.tt: NodeTest by NodeDelegate()
public val LocationPathBuilder.xmp: NodeTest by NodeDelegate()