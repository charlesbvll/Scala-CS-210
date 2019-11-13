package quickcheck

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop.{BooleanOperators => _, _}

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    a <- arbitrary[Int]
    h <- oneOf(const(empty), genHeap)
  } yield insert(a, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("min1") = forAll { (a: Int) =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if isEmpty(h) then 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("smallest") = forAll { (a: Int, b: Int) =>
    val h = insert(b, insert(a, empty))
    val min = if (a<b) then a else b
    if (a==b) true else
      findMin(h) == min
  }

  property("deleteSingle") = forAll { (a: Int) =>
    val h = insert(a, empty)
    val h1 = deleteMin(h)
    isEmpty(h1)
  }

  def multiMins(h: H, l: List[Int]): List[Int] = {
    if (isEmpty(h)) then l
    else findMin(h) :: multiMins(deleteMin(h), l)
  }

  property("multiMins") = forAll { (h1: H) =>
    val xs = multiMins(h1, Nil)
    xs == xs.sorted
  }

  property("meldMin") = forAll { (h1: H, h2: H) =>
    val min1 = findMin(h1)
    val min2 = findMin(h2)
    val m = meld(h1, h2)
    val minMeld = findMin(m)
    minMeld == min1 || minMeld == min2
  }

  property("meldMinMove") = forAll { (h1: H, h2: H) =>
    val meld1 = meld(h1, h2)
    val min1 = findMin(h1)
    val meld2 = meld(deleteMin(h1), insert(min1, h2))
    val xs1 = multiMins(meld1, Nil)
    val xs2 = multiMins(meld2, Nil)
    xs1 == xs2
  }
}
