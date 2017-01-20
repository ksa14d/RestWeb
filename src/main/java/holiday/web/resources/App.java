package holiday.web.resources;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("webapi")
public class App extends Application
{
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();       
         classes.add(MyResource.class);  
         classes.add(UserResource.class);
         classes.add(CheckoutResource.class);
         classes.add(CheckoutCartResource.class);
         classes.add(LocationResource.class);
         classes.add(HolidayResource.class);
         classes.add(MyResource.class);       
        return classes;
    }
}
