package com.talosdigital.safebuy.persistence.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.postgresql.util.HStoreConverter;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.talosdigital.safebuy.model.ProductProperties;;

public class HStoreUserType implements UserType {

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return deepCopy(cached);
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		HashMap<ProductProperties, String> test =  new HashMap<ProductProperties, String>();
		test.put(ProductProperties.COLOR, "blue");
		System.out.println(test.keySet().size());
		HashMap<ProductProperties, String> oldMap =
				value instanceof HashMap<?, ?>
					? (HashMap<ProductProperties, String>)value
					: null;
		HashMap<ProductProperties, String> newMap = new HashMap<ProductProperties, String>();
		for(Entry entry : oldMap.entrySet()){
			newMap.put((ProductProperties)entry.getKey(), (String)entry.getValue());
		}
//		for (ProductProperties pp : (Set<ProductProperties>)oldMap.keySet()){
//			newMap.put(pp, oldMap.get(pp));
//		}
		return newMap;
		
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		if(value!=null){
			return (Serializable)deepCopy(value);
		}
		return null;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
			throws HibernateException, SQLException {
		HashMap<ProductProperties, String> map =(HashMap<ProductProperties, String>) HStoreConverter.fromString(resultSet.getString(names[0]));	
		return map;
	}

	@Override
	public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index)
			throws HibernateException, SQLException {
		preparedStatement.setObject(index, HStoreConverter.toString((Map) value));
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return deepCopy(original);
	}

	@Override
	public Class<HashMap> returnedClass() {
		return HashMap.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[]{Types.VARCHAR};
	}

}
