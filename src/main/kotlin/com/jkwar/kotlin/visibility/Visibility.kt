package visibility

class Garden

class Flower

/**
 * 我自己家的花园和小河
 * 不能给别人看
 */
class My {
    private val graden: Garden = Garden()
    private val flower: Flower = Flower()
}


/**
 * 紫禁城
 */
class TheforbiddenCity {
    //模块内可见
    internal val graden = arrayOf(Garden(), Garden())
    //默认是public
    val flowers = arrayOf(Flower(), Flower())
}

fun main(args: Array<String>) {
    val my = My()
    val tfc = TheforbiddenCity()
    println( tfc.flowers)
    println(  tfc.graden)
}