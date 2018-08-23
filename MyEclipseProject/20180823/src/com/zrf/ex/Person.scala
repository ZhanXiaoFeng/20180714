package com.zrf.ex

import scala.Equals
import scala.collection.mutable._
import scala.math.Ordering
/*
	�������ֱ�ӱ���
	����ʱ����Ҫ��scala��װĿ¼�µ�libĿ¼�е�����jar���õ���·���У�Ҳ���Ǳ�׼��չĿ¼��
	jdk��װĿ¼/jre/lib/ext
*/

class Person(val name: String, var age: Int) extends Ordered[Person] {
  var height: Double = 170

  //scala�п����ڹ��캯���н������
  //println("gougou")

  //����������(����������ʹ��֮ǰ���ȵ�����������)
  def this() {
    //������������
    this("wanger", 17)
    height = 180
  }

  def this(name: String, age: Int, height: Double) {
    this(name, age)
    this.height = height
  }

  //��д����
  override def toString(): String = {
    name + "\t" + age + "\t" + height
  }

  override def equals(pp: Any): Boolean = {
    //����ת��
    if (pp.isInstanceOf[Person]) {
      var p: Person = pp.asInstanceOf[Person]
      return name.equals(p.name) && age == p.age && height == p.height
    }
    false
  }

  /*
	abstract def compare(x: T, y: T): Int 
	*/

  override def compare(y: Person): Int = {
    var res: Int = this.name.compare(y.name)
    if (res == 0) {
      res = this.age - y.age

      if (res == 0) {
        (this.height - y.height).compare(0)
      } else {
        return res
      }
    } else {
      res
    }
  }

}

object Person { //��������
  def main(args: Array[String]): Unit = {
    //go()
    testMax()
  }

  def go(): Unit = {
    var p = new Person("zhangsan", 18);
    println(p)

    //�޸�ֵ
    p.age = 20
    p.height = 175
    println(p.name + "\t" + p.age + "\t" + p.height)

    println(new Person("lisi", 21))

    //���ø���������
    var p1 = new Person
    println(p1)
  }

  def testMax() {
    val set: Set[Person] = new TreeSet[Person]()
    var p: Person = new Person("zhangsan", 21, 167)
    set += p
    p = new Person("wangwu", 17, 163)
    set += p

    p = new Person("liusan", 19, 165)
    set += p

    set.foreach(println)
    println("*******���ֵ*************")
    println(set.max)
    println("*******���ֵ*************")

    set.foreach(println)
  }

}