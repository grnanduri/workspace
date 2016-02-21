package JavaNut4Examples;
/** 
 * A queue. One thread calls push() to put an object on the queue. 
 * Another calls pop() to get an object off the queue. If there is no
 * data, pop() waits until there is some, using wait()/notify(). 
 * wait() and notify() must be used within a synchronized method or
 * block. 
 */
import java.util.*;

public class Queue {
  LinkedList q = new LinkedList();  // Where objects are stored
  public synchronized void push(Object o) {
    q.add(o);      // Append the object to the end of the list
    this.notify(); // Tell waiting threads that data is ready
  }
  public synchronized Object pop() {
    while(q.size() == 0) {
      try { this.wait(); }
      catch (InterruptedException e) { /* Ignore this exception */ }
    }
    return q.remove(0);
  }
}
