package com.zrf.ex

object ListEx {
  def main(args: Array[String]): Unit = {
    testTab()
    //test()
  }

  def test(): Unit = {
    val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
    val nums = Nil

    println("��һ��վ�� : " + site.head)
    println("���һ����վ�� : " + site.tail)
    println("�鿴�б� site �Ƿ�Ϊ�� : " + site.isEmpty)
    println("�鿴 nums �Ƿ�Ϊ�� : " + nums.isEmpty)

    val site1 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
    val site2 = "Facebook" :: ("Taobao" :: Nil)

    // ʹ�� ::: �����  ǰǰ���
    var fruit = site1 ::: site2
    println("site1 ::: site2 : " + fruit)

    // ʹ�� List.:::() ����  ��ǰǰ��
    fruit = site1.:::(site2)
    println("site1.:::(site2) : " + fruit)

    // ʹ�� concat ����
    fruit = List.concat(site1, site2)
    println("List.concat(site1, site2) : " + fruit)

    println("************:::**********")
    val site3 = List.fill(2)("aaaaaa")
    val site4 = List.fill(4)("111111")
    val site5 = site3 ::: site4
    site5.foreach(println)

    println("************reverse**********")
    val site6 = site5.reverse
    site6.foreach(println)

    println("************distinct**********")
    site6.distinct.foreach(println)

    println("************dropWhile**********")
    site6.dropWhile { x => x.contains("11") }.foreach(println)
  }

  def testTab(): Unit = {
    // ͨ�������ĺ������� 4 ��Ԫ��(0,1,2,3)
    val squares = List.tabulate(4)(n => n * n)
    println("һά : " + squares)

    // ������ά�б�()
    val mul = List.tabulate(2, 3)(_ * _)
    println("��ά : " + mul)
  }
}