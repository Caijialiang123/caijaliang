package com.mycode.zpc;
/**


*/
public class Teacher {
	//1.˽������
	private long id;
	private String name;
	private int age;
	//2.������setter,getter����


	//2.������setter,getter����
	public Teacher(long id,String name,int age){
	
	this.id = id;
	this.name = name;
	this.age = age;

	}
	public Teacher(){
	}

	public void setId(long id){
		//��ʵ��id�����������е�id����
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