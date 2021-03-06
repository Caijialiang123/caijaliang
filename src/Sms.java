package com.mycode.zpc;
import java.util.Scanner;
public class Sms
{	private Teacher[] stus = new Teacher[3];			
	private int index = 0;
	/**
	*
	*/
	public void save(Teacher teacher){
		if(index>=stus.length){
			 Teacher[] demo = new Teacher[stus.length+3];
			System.arraycopy(stus,0,demo,0,index);
			stus = demo;
		
		
		
		}
		stus[index++] = teacher;

	
	
	
	}
	/**
	*
	*/
	public void update(Teacher teacher){
		for(int i=0;i<index;i++){
			 if(stus[i].getId()==teacher.getId())
			{
				//stus[i].setName(teacher.getName());
				stus[i].setAge(teacher.getAge());
				stus[i].setName(teacher.getName());
			 
			 
			 
			 }
		
		
		}
	
	
	
	}
	/**
	*
	*/
	public void deleteById(long id){
		int i;
		i = getIndexById(id);
		for(int j=i;j<index-1;j++){
			stus[j]=stus[j+1];
		
		
		}
		stus[--index]=null;

	
	
	}
	/**
	*
	*/
	public Teacher[] queryAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(stus,0,demo,0,index);
		return demo;
	
	
	}
	/**
	*
	*/
	public Teacher queryById(long id){
		 int num;
		 num = getIndexById(id);
		 return num==-1?null:stus[num];
	
	
	}
	private int getIndexById(long id){
		int num = -1;
		for(int j=0;j<index;j++){
			if(stus[j].getId()==id){
				num = j;
				break;}
	}
	
	return num;
}





	public void meau(){
		System.out.println("********学生信息管理系统********");
		System.out.println("*1 查找所有老师信息");
		System.out.println("*2 录入老师信息");
		System.out.println("*3 删除老师信息");
		System.out.println("*4 通过老师id查找");
		System.out.println("*5 修改老师信息");
		System.out.println("*exit 退出系统！");
		System.out.println("*help 获取帮助！");
		System.out.println("********************************");
	
	
	
	
	}
	public static void main(String[] args){
		Sms sms = new Sms();
		sms.meau();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("请输入对应指令:");
			String option = sc.nextLine();
			switch(option){
				case "1":			//查询所有
				System.out.println("以下是学生信息");
				Teacher[] stus = sms.queryAll();
				for(Teacher stus1 :stus)
				{	System.out.println(stus1);
				}
				System.out.println("查询到"+sms.index+"个学生");

				



				break;
				case "2":			//录入
				while(true){
				System.out.println("请输入学生信息【id#name#age】或输入【break】返回上一级目录");
				String stuStr = sc.nextLine();
				String biaodashi ="\\w+";
				if(stuStr.matches(biaodashi)){
					break;
				
				
				}
				if(stuStr.equals("break")){
					break;
				}
				
				String stuArr[] = stuStr.split("#");
				long id = Long.parseLong(stuArr[0]);
				String name = stuArr[1];
				int age = Integer.parseInt(stuArr[2]);
				Teacher stu = new Teacher(id,name,age);
				sms.save(stu);



				System.out.println("储存信息成功!");




				}
				break;
				case "3":			//删除
				System.out.println("请输入要删除的学生id:或输入【break】退出");
				String stuId = sc.nextLine();
				if(stuId.equals("break")){
					break;
				}
				long id2 = Long.parseLong(stuId);
				Teacher stu2 = sms.queryById(id2);
				System.out.println("你将要删除的学生为：");
				System.out.println(stu2);
				System.out.println("是否继续删除？请输入yes继续或no退出,");
				String choice =sc.nextLine();
				if(choice.equals("yes")){
					
					sms.deleteById(id2);
					System.out.println("删除成功！");
				
				
				
				}
				if(choice.equals("no")){
				break;
				
				
				}




				break;				
				case "4":			//通过id获取
				System.out.println("请输入要查找的学生的id,或者输入break返回上一级目录");
				String idStr = sc.nextLine();
				if(idStr.equals("break")){
					break;
				}
				long id = Long.parseLong(idStr);
				Teacher stuid = sms.queryById(id);
				System.out.println(stuid==null?"sorry ,not found!":stuid);

				break;
				case "5":			//修改
				System.out.println("请输入要修改学生的id,或者输入break返回上一级");
				String idStr1 = sc.nextLine();
				if(idStr1.equals("break")){
					break;
				
				}
				long id1 = Long.parseLong(idStr1);
				Teacher stu = sms.queryById(id1);
				if(stu==null){
					System.out.println("你要修改的信息不存在");

				
				
				
				}
				System.out.println("原信息为："+stu);
				System.out.println("请输入新信息【name#age】:");
				String str = sc.nextLine();
				String[] stuArr = str.split("#");			
				String name = stuArr[0];
				int age = Integer.parseInt(stuArr[1]);
				Teacher newStu = new Teacher(id1,name,age);
				sms.update(newStu);
				System.out.println("修改成功!");





				break;
				case "exit":
					System.out.println("已经退出学生管理系统");
				System.exit(0);
				break;
				case "help":
				sms.meau();
				break;
				default:
					System.out.println("sorry 输入有误！");
				}
		
		}

	
	
	
	
	}




}