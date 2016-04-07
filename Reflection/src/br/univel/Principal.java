
package br.univel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Principal {
	
	public Principal(Pessoa p) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class <?> cls = p.getClass();
		
		int c = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO" + cls.getSimpleName() + " (");

		Field[] declaredFields = cls.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field f = declaredFields[i];
			if (i < declaredFields.length - 1)
				sb.append(f.getName() + ", ");
			else
				sb.append(f.getName());
		}
		sb.append(") VALUES (");

	    Method[] declaredMethods = cls.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			Method m = declaredMethods[i];
			if (m.getName().startsWith("get")) {
				String x = "class java.lang.String";
				if (m.getTypeParameters().equals(x))
			    	sb.append("\"");

			    if (i < declaredMethods.length - 1)
			    	sb.append(m.invoke(p, null) + ", ");
			    else
			    	sb.append(m.invoke(p, null));

			    if (m.getReturnType().equals("class java.lang.String"))
			    	sb.append("\"");
			}
		}
	    
		sb.append(");");
		
		System.out.println(sb);
	}

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
	
		p.setId(1);
		p.setNome("Um");
		
    	try {
			new Principal(p);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
