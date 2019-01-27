package fr.walexmine.OktaliaAuth.managers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class Reflection
{
  public static <T> FieldAccessor<T> getField(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return getField(paramClass, paramString, paramClass1, 0);
  }
  
  public static <T> FieldAccessor<T> getField(String paramString1, String paramString2, Class<T> paramClass)
  {
    return getField(getClass(paramString1), paramString2, paramClass, 0);
  }
  
  public static <T> FieldAccessor<T> getField(Class<?> paramClass, Class<T> paramClass1, int paramInt)
  {
    return getField(paramClass, null, paramClass1, paramInt);
  }
  
  public static <T> FieldAccessor<T> getField(String paramString, Class<T> paramClass, int paramInt)
  {
    return getField(getClass(paramString), paramClass, paramInt);
  }
  
  private static <T> FieldAccessor<T> getField(Class<?> paramClass, String paramString, Class<T> paramClass1, int paramInt)
  {
    for (Field localField : paramClass.getDeclaredFields()) {
      if (((paramString == null) || (localField.getName().equals(paramString))) && 
        (paramClass1.isAssignableFrom(localField.getType())) && (paramInt-- <= 0))
      {
        localField.setAccessible(true);
        
        new FieldAccessor()
        {
          private Object val$field;

		public T get(Object paramAnonymousObject)
          {
            try
            {
              return (T)((Field) this.val$field).get(paramAnonymousObject);
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              throw new RuntimeException("Cannot access reflection.", localIllegalAccessException);
            }
          }
          
          public void set(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            try
            {
              ((Field) this.val$field).set(paramAnonymousObject1, paramAnonymousObject2);
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              throw new RuntimeException("Cannot access reflection.", localIllegalAccessException);
            }
          }
          
          public boolean hasField(Object paramAnonymousObject)
          {
            return ((Executable) this.val$field).getDeclaringClass().isAssignableFrom(paramAnonymousObject.getClass());
          }
        };
      }
    }
    if (paramClass.getSuperclass() != null) {
      return getField(paramClass.getSuperclass(), paramString, paramClass1, paramInt);
    }
    throw new IllegalArgumentException("Cannot find field with type " + paramClass1);
  }
  
  public static MethodInvoker getMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    return getTypedMethod(getClass(paramString1), paramString2, null, paramVarArgs);
  }
  
  public static MethodInvoker getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    return getTypedMethod(paramClass, paramString, null, paramVarArgs);
  }
  
  public static MethodInvoker getTypedMethod(Class<?> paramClass1, String paramString, Class<?> paramClass2, Class<?>... paramVarArgs)
  {
    for (Method localMethod : paramClass1.getDeclaredMethods()) {
      if (((paramString != null) && (!localMethod.getName().equals(paramString))) || ((paramClass2 == null) || (
        (localMethod.getReturnType().equals(paramClass2)) && 
        (Arrays.equals(localMethod.getParameterTypes(), paramVarArgs)))))
      {
        localMethod.setAccessible(true);
        new MethodInvoker()
        {
          private Object val$method;

		public Object invoke(Object paramAnonymousObject, Object... paramAnonymousVarArgs)
          {
            try
            {
              return ((Method) this.val$method).invoke(paramAnonymousObject, paramAnonymousVarArgs);
            }
            catch (Exception localException)
            {
              throw new RuntimeException("Cannot invoke method " + this.val$method, localException);
            }
          }
        };
      }
    }
    if (paramClass1.getSuperclass() != null) {
      return getMethod(paramClass1.getSuperclass(), paramString, paramVarArgs);
    }
    throw new IllegalStateException(String.format("Unable to find method %s (%s).", new Object[] { paramString, 
      Arrays.asList(paramVarArgs) }));
  }
  
  public static ConstructorInvoker getConstructor(String paramString, Class<?>... paramVarArgs)
  {
    return getConstructor(getClass(paramString), paramVarArgs);
  }
  
  public static ConstructorInvoker getConstructor(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    for (Constructor localConstructor : paramClass.getDeclaredConstructors()) {
      if (Arrays.equals(localConstructor.getParameterTypes(), paramVarArgs))
      {
        localConstructor.setAccessible(true);
        new ConstructorInvoker()
        {
          private Object val$constructor;

		public Object invoke(Object... paramAnonymousVarArgs)
          {
            try
            {
              return ((Constructor) this.val$constructor).newInstance(paramAnonymousVarArgs);
            }
            catch (Exception localException)
            {
              throw new RuntimeException("Cannot invoke constructor " + this.val$constructor, localException);
            }
          }
        };
      }
    }
    throw new IllegalStateException(String.format("Unable to find constructor for %s (%s).", new Object[] { paramClass, 
      Arrays.asList(paramVarArgs) }));
  }
  
  public static Class<Object> getUntypedClass(String paramString)
  {
    Class localClass = getClass(paramString);
    return localClass;
  }
  
  public static Class<?> getClass(String paramString)
  {
    return getCanonicalClass(paramString);
  }
  
  private static Class<?> getCanonicalClass(String paramString)
  {
    try
    {
      return Class.forName(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalArgumentException("Cannot find " + paramString, localClassNotFoundException);
    }
  }
  
  public static abstract interface FieldAccessor<T>
  {
    public abstract T get(Object paramObject);
    
    public abstract void set(Object paramObject1, Object paramObject2);
    
    public abstract boolean hasField(Object paramObject);
  }
  
  public static abstract interface MethodInvoker
  {
    public abstract Object invoke(Object paramObject, Object... paramVarArgs);
  }
  
  public static abstract interface ConstructorInvoker
  {
    public abstract Object invoke(Object... paramVarArgs);
  }
}