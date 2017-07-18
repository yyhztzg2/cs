package e_eg;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.itcast.b_reflect.JdbcUtils;
import cn.itcast.utils.Column;
import cn.itcast.utils.Id;
import cn.itcast.utils.Table;

/**
 * ����Ż������⣺
 * 	  1. �����ݿ������������һ�¡� 
 *    2. �ֶ������Բ�һ����
 *    3. ��������id 
 *    
 */
public class BaseDao<T> {
	
	// ��ǰ�����������
	private Class<T> clazz;
	// ����
	private String tableName;
	// ����
	private String id_primary;

	// �õ���ǰ������Ĳ�����������ʵ�ʵ�����  ( BaseDao<Admin> ,  Admin.class)
	public BaseDao(){
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		clazz = (Class<T>) types[0];
		
		//�Ѿ��õ���  Admin.class
		
		/*******1. ��ȡ����*******/
		Table table = clazz.getAnnotation(Table.class);
		tableName = table.tableName();
		
		/*******2. ��ȡ�����ֶ�*******/
		//��ȡ��ǰ������������ֶΡ���������ȡÿһ���ֶ��ϵ�idע��
		Field[] fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			
			// ����ǿ�Ʒ���
			f.setAccessible(true);
			
			// ��ȡÿһ���ֶ��ϵ�idע��
			Id anno_id = f.getAnnotation(Id.class);
			
			// �ж�
			if (anno_id != null) {
				// ����ֶ�����idע�⣬��ǰ�ֶ�(field)�������� �ٻ�ȡ�ֶ�����
				Column column = f.getAnnotation(Column.class);
				// ����
				id_primary = column.columnName();
				// ����ѭ��
				break;
			}
		}
		
		System.out.println("��" + tableName);
		System.out.println("������" + id_primary);
	}
	
	
	public T findById(int id){
		try {
			String sql = "select * from " + tableName + " where " + id_primary +"=?";
			/*
			 * DbUtils���Ѿ���װ�õĹ����ࣺBeanHandler?   ����=�ֶ�
			 */
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<T>(clazz), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<T> getAll(){
		try {
			String sql = "select * from " + tableName;
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<T>(clazz));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

/**
 * �Զ�����������װ����Bean����
 */
class BeanHandler<T> implements ResultSetHandler<T>{
	// ���洫���Ҫ��װ������ֽ���
	private Class<T> clazz;
	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	// ��װ������ķ���
	@Override
	public T handle(ResultSet rs) throws SQLException {
		try {
			// ����Ҫ��װ�Ķ���  ��1��
			T t = clazz.newInstance(); 
			// ���¶�һ��
			if (rs.next()) {
				
				// a. ��ȡ������е�Field�ֶ�����
				Field[] fs = clazz.getDeclaredFields();
				
				// b. ������ �õ�ÿһ���ֶ����ͣ�Field
				for (Field f : fs) {
				
					// c. ��ȡ���������ơ�
					String fieldName = f.getName();
					
					// e. ��ȡField�ֶ���ע��   ��@Column(columnName = "a_userName")��
					Column column =  f.getAnnotation(Column.class);
					
					// f. ���ֶ�����
					String columnName = column.columnName();        // ���ݿ����ֶ� a_userName
					
					// g. �ֶ�ֵ
					Object columnValue = rs.getObject(columnName);
					
					// ���ã�BeanUtils�����
					BeanUtils.copyProperty(t, fieldName, columnValue);
				}
			}
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}


/**
 * �Զ�����������װ���Bean����List����
 */
class BeanListHandler<T> implements ResultSetHandler<List<T>>{
	
	// Ҫ��װ�ĵ�������
	private Class<T> clazz;
	public BeanListHandler(Class<T> clazz){
		this.clazz = clazz;
	}

	// �Ѵ����ݿ��ѯ����ûһ�м�¼����װΪһ���������ύ��list���ϣ� ����List<T>
	@Override
	public List<T> handle(ResultSet rs) throws SQLException {
		List<T> list = new ArrayList<T>();
		try {
			// ���¶�һ��
			while (rs.next()) {
				
				// ����Ҫ��װ�Ķ���  ��1��
				T t = clazz.newInstance(); 
				
				// a. ��ȡ������е�Field�ֶ�����
				Field[] fs = clazz.getDeclaredFields();
				
				// b. ������ �õ�ÿһ���ֶ����ͣ�Field
				for (Field f : fs) {
				
					// c. ��ȡ���������ơ�
					String fieldName = f.getName();
					
					// e. ��ȡField�ֶ���ע��   ��@Column(columnName = "a_userName")��
					Column column =  f.getAnnotation(Column.class);
					
					// f. ���ֶ�����
					String columnName = column.columnName();        // ���ݿ����ֶ� a_userName
					
					// g. �ֶ�ֵ
					Object columnValue = rs.getObject(columnName);
					
					// ���ã�BeanUtils�����
					BeanUtils.copyProperty(t, fieldName, columnValue);
				}
				// ������ӵ�����
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

















