package nus.iss;

@FunctionalInterface
//interface does not implement any logic, it only has the functional signature/method, the implementation is in another file 
public interface MyRunnableInterface <T> {
    
    T process(T a, T b); 
    
}
