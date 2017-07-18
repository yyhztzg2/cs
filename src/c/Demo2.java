package c;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/*
��ʡ--->һ����̬�ķ���.

��ʡ��Ҫ��� �����⣺ �Ѷ�����������ݷ�װ �������С�


 */
public class Demo2 {
	
	
	@Test
	public void getAllProperty() throws IntrospectionException{
		//Introspector ��ʡ�� suoyou de shuxing 
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
		//ͨ��BeanInfo��ȡ���е�����������
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors(); //��ȡһ�����е���������������
		for(PropertyDescriptor p : descriptors){
			System.out.println(p.getReadMethod()); //get����
		}
		
		
	}
	
	
	@Test
	public  void testProperty() throws Exception{
		Person p = new Person();
		//����������
		PropertyDescriptor descriptor = new PropertyDescriptor("id", Person.class);
		//��ȡ���Զ�Ӧ��get������set�������û��߻�ȡ�����ˡ�
		Method  m = descriptor.getWriteMethod();  //��ȡ���Ե�set������
		//ִ�и÷�����������ֵ
		Object invoke = m.invoke(p,110);
		System.out.println(invoke);
		Method readMethod = descriptor.getReadMethod(); //�ǻ�ȡ���Ե�get����
		Object invoke2 = readMethod.invoke(p, null);
		System.out.println(invoke2);
		System.out.println(readMethod.invoke(p, null));
	}

}
