package com.talosdigital.safebuy.persistence.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.postgresql.util.HStoreConverter;

public class HStoreUserType implements UserType {

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return deepCopy(cached);
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if(value != null){
			return  (HashMap)value;
		}
		return null;
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
		if(x == null){
			return y == null;
		}
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
		if(resultSet.getString(names[0])==null){
			return null;
		}
		HashMap<String, String> map = (HashMap<String, String>) HStoreConverter.fromString(resultSet.getString(names[0]));	
		return map;
	}

	@Override
	public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index)
			throws HibernateException, SQLException {
		if(value != null){
			preparedStatement.setObject(index, HStoreConverter.toString((Map<String, String>) value));
		}
		else {
			preparedStatement.setObject(index, null);
		}
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
