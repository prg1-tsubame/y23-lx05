package prg1.lx05.ex02a_complex1

import scala.math._

// 複素数のクラスの実装例
class Complex(_re: Double, _im: Double) {
  val re = _re
  val im = _im

  // クラスの引数(_re, _im)を利用して定義した例
  def plus(c: Complex) = new Complex(_re + c.re, _im + c.im)

  // re, im関数を利用して定義した例
  def minus(c: Complex) = new Complex(re - c.re, im - c.im)

  def neg = new Complex(-re, -im)

  def abs = sqrt(re*re + im*im)
  
  override def toString(): String = {
    if (im >= 0) {
      f"($re%.01f+$im%.01fi)"
    } else {
      f"($re%.01f${im}%.01fi)"
    }
  }

  def +(c: Complex) = plus(c)
  def +(x: Double)  = new Complex(re + x, im)

  def -(c: Complex) = minus(c)
  def -(x: Double)  = new Complex(re - x, im)

  def ==(c: Complex) = re == c.re && im == c.im
  def ==(x: Double): Boolean = this==(new Complex(x, 0))

  def unary_- = neg

  def *(c: Complex) = new Complex(re * (c.re) - im * (c.im), re * (c.im) + im * (c.re))
  def *(x: Double)  = new Complex(re * x , im * x)
}

object Complex {
  def fromPolar(r: Double, theta: Double) = new Complex(r * cos(theta), r * sin(theta))
}

@main def run = {
  val c0 = new Complex(0, 0)
  val c1 = new Complex(2, 1)
  val c2 = new Complex(1, -2)
  val c3 = c1.plus(c2)
  println(s"$c1 + $c2 = $c3")
  println(s"$c1 - $c2 = ${c1.minus(c2)}")
  println(s"$c1 * $c2 = ${c1 * c2}")

  // 演算子の結合順位も正しく解釈されている
  println(s"$c1 + $c2 * 10 - $c1 = ${c1 + c2 * 10 - c1}")

  println(s"-$c1 = ${-c1}")

  val c4 = Complex.fromPolar(1, Pi)
  println(s"$c4")

  println(s"$c1 == $c1 = ${c1 == c1}")
  println(s"${new Complex(2, 0)} == 2 = ${new Complex(2, 0) == 2}")
}