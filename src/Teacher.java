package com.mycode.zpc;
/**


*/
public class Teacher {
	//1.私有属性
	private long id;
	private String name;
	private int age;
	//2.公共的setter,getter方法


	//2.公共的setter,getter方法
	public Teacher(long id,String name,int age){
	
	this.id = id;
	this.name = name;
	this.age = age;

	}
	public Teacher(){
	}

	public void setId(long id){
		//将实参id赋给本对象中的id属性
		this.id = id;
	}
	public long getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
		}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}

public String toString(){

	return "Teacher[ id:"+this.id+",name:"+this.name+",age:"+this.age+"]";
}
}