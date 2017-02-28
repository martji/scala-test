/**
  * Created by Guoqing on 2016/10/20.
  */

object FeatureTest {

    def main(args: Array[String]): Unit = {
        val nodeArr: Array[MNode] = new Array[MNode](8)
        for (i <- 0 to 7) {
            nodeArr(i) = new MNode(i+1)
        }

        nodeArr(0).left = nodeArr(1)
        nodeArr(0).right = nodeArr(2)

        nodeArr(1).left = nodeArr(3)
        nodeArr(1).right = nodeArr(4)
        nodeArr(1).parent = nodeArr(0)

        nodeArr(2).parent = nodeArr(0)

        nodeArr(3).right = nodeArr(5)
        nodeArr(3).parent = nodeArr(1)

        nodeArr(4).right = nodeArr(6)
        nodeArr(4).parent = nodeArr(1)

        nodeArr(5).parent = nodeArr(3)

        nodeArr(6).parent = nodeArr(4)

        val tmp = findPreMNode(nodeArr(3))
        if (tmp != null) {
            println(tmp.value)
        } else {
            println("null")
        }
    }

    def findPreMNode(node: MNode): MNode = {
        if (node == null) {
            return null
        }
        if (node.left != null) {
            var p = node.left
            while(p.right != null) {
                p = p.right
            }
            return p
        } else {
            if (node.parent == null) {
                return null
            }
            var p = node
            while (p.parent != null && p == p.parent.left) {
                p = p.parent
            }
            return p.parent
        }
    }

    class MNode(x: Int) {
        val value = x
        var left: MNode = null
        var right: MNode = null
        var parent: MNode = null
    }
}