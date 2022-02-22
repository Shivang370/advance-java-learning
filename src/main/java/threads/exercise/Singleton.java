package threads.exercise;

public class Singleton {
    private static Singleton instance; // It will store the instance , It is done when we do not want to manage states.In logging Singleton is used
    private Singleton(){}
    public static  synchronized Singleton getInstance()  // For Static Singleton class itself acts as a key.
    {
        if(instance==null)
        {
            instance=new Singleton();
            return instance;
        }
        return instance;
    }
}
