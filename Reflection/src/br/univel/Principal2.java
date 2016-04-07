package br.univel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.univel.anotation.Tabela;
import br.univel.enums.EstadoCivil;

public class Principal2 {
	public Principal2(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> cls = obj.getClass();
		
		if(cls.isAnnotationPresent(Tabela.class)){
			Tabela t = cls.getAnnotation(Tabela.class);
			
			//System.out.println(t.value());
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO " + t.value() + " (");

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
				    	sb.append(m.invoke(obj, null) + ", ");
				    else
				    	sb.append(m.invoke(obj, null));

				    if (m.getReturnType().equals("class java.lang.String"))
				    	sb.append("\"");
				}
			}
		    
			sb.append(");");
			
			System.out.println(sb);

			
		}
	}

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		
		p.setId(1);
		p.setNome("ABC");
		p.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		try {
			new Principal2(p);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
