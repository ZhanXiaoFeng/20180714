package com.zrf.ex

class Person(val name: String, var age: Int) {
  var height: Double = 170
  println("gougou")

  //����������(����������ʹ��֮ǰ���ȵ�����������)
  def this() {
    //������������
    this("wanger", 17)
    height = 180
  }

  //��д����
  override def toString(): String = {
    name + "\t" + age + "\t" + height
  }

}

object Person { //��������
  def main(args: Array[String]): Unit = {
    go()
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
}