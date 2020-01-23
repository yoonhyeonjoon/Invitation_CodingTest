
import java.io.*
import java.util.*


/*
    기능 :
      Data를 넣으면 트리가 형성된다.(크기 비교를 위해 Int로 한정)
      ADD : Int 크기에 맞추어 값이 정렬된다. 즉 가장 큰 값이 최상단에 위치하도록한다(자식 노드는 부모노드보다 클 수 없다)
      Remove : 해당 Int를 제거하고 노드를 정렬한다.
      Find : 해당 Int의 유무를 출력하고, 있다면, 탐색순서를 표현, 어디에 위치하고 있는지를 알린다.
      Clear : 노드를 모두 제거한다.
*/

fun main(args: Array<String>) {

    val queue:BasicTree<Int> = BasicTree()


}


class BasicRedBlackTree<T> {



    private class TreeNode<T> constructor(var TreeNodeLeft: T, var TreeNodeRight: T)
    {

    }

    private fun Rearrange()
    {

    }

    fun add(item: T) {

    }

    fun remove(): T? {
        return null
    }

    fun peek(): T? {
        return null
    }

    fun isEmpty(): Boolean {       // todo
        return false
    }
}