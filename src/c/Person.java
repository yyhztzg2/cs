package c;

//实体类---javaBean
public class Person {
	
	public int id;
	
	public String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Person(){}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
	
		return "编号："+ this.id+" 姓名："+ this.name;
	}

}
