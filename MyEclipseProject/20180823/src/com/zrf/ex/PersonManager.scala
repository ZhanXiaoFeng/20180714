package com.zrf.ex

class PersonManager {
  private var persons: List[Person] = Nil

  def addPerson(p: Person): Boolean = {
    persons = p :: persons
    true
  }

  def deletePerson(p: Person): Boolean = {
    val oldLen = persons.size

    persons = persons.dropWhile(_.equals(p))

    oldLen - persons.length > 0
  }

  def viewAll() {
    if (persons.size != 0) {
      println(persons.mkString("\t"))
    }
  }
}

object PersonManager {
  def main(args: Array[String]): Unit = {
    var pm = new PersonManager
    pm.viewAll

    //��ӳ�Ա
    println("************��ӳ�Ա***************")
    var p: Person = new Person("zhangsan", 21, 167)
    pm.addPerson(p)
    p = new Person("lisi", 23, 169.0)
    pm.addPerson(p)
    pm.viewAll

    //ɾ����Ա
    println("************ɾ����Ա***************")
    pm.deletePerson(new Person("lisi", 23, 169.0))
    pm.viewAll()

  }
}