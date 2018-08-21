package com.zrf.ex

import scala.collection.mutable.ArrayBuffer

object ForEx {
  def main(args: Array[String]) {
    //for1()
    //testArrayBuffer
    //testFunction
    testCurringFunction()
  }

  /**
   * �������ﻯ
   */
  def testCurringFunction(): Unit = {
    //��������
    def multiple1(x: Int, y: Int) = x * y
    println(multiple1(2, 3))
    
    //����һ��������Ϊ����ֵ
    def multiple2(x: Int) = (y: Int) => x * y
    println(multiple2(3)(4))

    //���ﻯ
    def multiple3AfterCurring(x: Int)(y: Int) = x * y
    println(multiple3AfterCurring(4)(5)) //���봫������������������뱨��
  }

  //���巽��
  def testFunction(): Unit = {
    //���庯��
    val f2 = (i: Int) => i * 5
    val f3 = (i: Int) => i * 6

    //f1��������ֵ(����Int���͵�j,�β�f(����ֵΪInt����,����ֵΪInt����)):�����崫��ֵΪInt����
    def f1(j: Int, f: Function[Int, Int]): Int = {
      var i = j
      i += 1
      i *= 10
      f(i)
    }
    println(f1(4, f3))
  }

  def for1() {
    var list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18)
    var temp = 0
    val filterList = for {
      temp <- list
      if (temp & 1) == 0
      if (temp % 3) == 0
    } yield temp

    filterList.foreach(println)
    println("----------------")
    println(filterList.toString())
  }

  def testArrayBuffer(): Unit = {
    var arrayBuffer = new ArrayBuffer[Int]
    arrayBuffer = (1 +: 2 +: 3 +: 4 +: arrayBuffer)
    //arrayBuffer.foreach(println)
    println(arrayBuffer.toString())

    //ƴ�ռ���
    println("-----------------")
    var list = List(5, 6, 7, 8)
    arrayBuffer = arrayBuffer ++ list
    //arrayBuffer.foreach(println)
    println(arrayBuffer.toString())

    //ɾ��ָ��λ��a[7]��Ԫ��
    println("-----------------")
    arrayBuffer.remove(7)
    println(arrayBuffer.toString())

    //ɾ��5��Ԫ��(ɾ��a[1]��a[5])
    println("-----------------")
    arrayBuffer.remove(1, 5)
    println(arrayBuffer.toString())

    //Ԫ�ظ���(��a[1]Ԫ�ص�ֵ�滻Ϊ2)
    println("-----------------")
    arrayBuffer.update(1, 2)
    println(arrayBuffer.toString())
  }
}