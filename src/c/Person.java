package c;

//ʵ����---javaBean
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
	
		return "��ţ�"+ this.id+" ������"+ this.name;
	}

}
