package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if (c == 0 || c == r) then 1 
    else pascal(c-1,r-1) + pascal(c,r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkParenthesis(chars: List[Char], opened: Int): Boolean =
      if (chars.isEmpty) then opened == 0
      else if (opened < 0) then false
      else if (chars.head == '(') then checkParenthesis(chars.tail, opened + 1)
      else if (chars.head == ')') then checkParenthesis(chars.tail, opened - 1)
      else checkParenthesis(chars.tail, opened)

    checkParenthesis(chars, 0)
  }
    

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if(money == 0) then 1
    else if(money < 0) then 0
    else if(coins.isEmpty) then 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
}
