import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BaseTest {

    public void initialise(Object object)
    {
        System.out.println("In initialise");
        initialiseBusineesLayersInTestClass(object);
    }

    private void initialiseBusineesLayersInTestClass(Object object) {

        System.out.println("In initialiseBusineesLayersInTestClass "+object.getClass().getName());

        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for(int i=0;i<fields.length;i++)
        {
            if(fields[i].getAnnotation(AnnotBL.class) != null)
            {
                try{
                    try {
                        Constructor constructor = fields[i].getType().getDeclaredConstructor();
                        fields[i].set(object,constructor.newInstance());
                        initialisePagesInBussinessLayer(fields[i].get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    private void initialisePagesInBussinessLayer(Object object) {

        System.out.println("In initialisePagesInBussinessLayer "+object.getClass().getName());

        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for(int i=0;i<fields.length;i++)
        {
            if(fields[i].getAnnotation(AnnotPage.class) != null)
            {
                try{
                    try {
                        Constructor constructor = fields[i].getType().getDeclaredConstructor();
                        fields[i].set(object,constructor.newInstance());
                        initialiseFieldsInPage(fields[i].get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void initialiseFieldsInPage(Object object) {

        System.out.println("In initialiseFieldsInPage "+object.getClass().getName());

        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for(int i=0;i<fields.length;i++)
        {
            if(fields[i].getAnnotation(AnnotButton.class) != null)
            {
                try{
                        fields[i].set(object,new Button(fields[i].getName(),fields[i].getAnnotation(AnnotButton.class).value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
