package com.kgisl.javastream;
class Person
{
    private String name;
    private long age;
    Person()
    {
        
    }
   Person(String name,long age)
   {
       this.name=name;
       this.age=age;
   }
    public String getName()
    {
        return name;
    }
    /**
     * @param age the age to set
     */
    public void setAge(long age) {
        this.age = age;
    }
    
    public long getAge()
    {
        return age;
    }
    public String toString()
    {
        return "  name: "+name+"  age: "+age;
    }
}