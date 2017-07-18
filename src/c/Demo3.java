package c;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/*
 BeanUtils��
 
 BeanUtils��Ҫ��� �����⣺ �Ѷ�����������ݷ�װ �������С�
 
 BeanUtils�ĺô���
 	1. BeanUtils��������ֵ��ʱ����������ǻ������� ���ͣ�BeanUtils���Զ�����ת���������͡�
  	2. BeanUtils��������ֵ��ʱ��ײ�Ҳ��������get����Set���������Լ���ȡ����ֵ�ġ�
  	3. BeanUtils��������ֵ,������õ����������������� �������ݣ���ô��ʱ�����Ҫע��һ������ת������
  	
 
 

 BeanUtilssʹ�õĲ��裺
 	1. ����commons-logging.jar �� commons-beanutils-1.8.0.jar

 */
public class Demo3 {

	public static void main(String[] args) throws Exception {
		//���ļ��ж�ȡ�������ݶ����ַ��������ݣ������Ǳ��ύ�����ݻ�ȡ����ʱ��Ҳ���ַ��������ݡ�
		String id ="110";
		String name="����";
		String salary = "1000.0";
		String birthday = "2013-12-10";
		
		
		//ע��һ������ת����
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) { // type : Ŀǰ���������������͡�  value :Ŀǰ������ֵ��
				Date date = null;
				try{
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					date = dateFormat.parse((String)value);
				}catch(Exception e){
					e.printStackTrace();
				}
				return date;
			}
			
		}, Date.class);
		
		
		Emp  e = new Emp();
		BeanUtils.setProperty(e, "id", id);
		BeanUtils.setProperty(e, "name",name);
		BeanUtils.setProperty(e, "salary",salary);
		BeanUtils.setProperty(e, "birthday",birthday);
		
		
		System.out.println(e);
		
		
		
		
	}
	
}
