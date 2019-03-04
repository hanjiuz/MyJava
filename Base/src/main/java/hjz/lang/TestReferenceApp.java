package hjz.lang;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Hello world!
 *
 */
public class TestReferenceApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        TestReferenceApp myApp = new TestReferenceApp();
        
        //Strong reference will never be garbage collected.
        //Soft reference will be garbage collected once memory is insufficient.
        //Weak reference will be queued first, than gc (regardless memory is sufficient or not).
        //Phantom reference is used for some cleanup operation before GCed, flexible than finalize() method.
        
        myApp.testSoftRef();
        
        myApp.testWeakRef();
        
        myApp.testPhantomRef();
        
             
        
    }
    
    public void testSoftRef() {
    	
    	System.out.println("testSoftRef()");
    	
		Object obj = new Object();
		ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
		SoftReference<Object> softRef = new SoftReference<Object>(obj, refQueue);
		
		//it is different to put obj or softRef to cache (e.g. HashSet)
		
		System.out.println(softRef.get());    //should not null
		System.out.println(refQueue.poll());  //should null
		
		//only softref now
		obj = null;
		
		System.out.println(softRef.get());      //should not null
		System.out.println(refQueue.poll());    //should null
		
		System.gc();
		
		//how to exhost the JVM memory?
		
		System.out.println(softRef.get());     //should not null
		System.out.println(refQueue.poll());   //should null
		
		
	}

	public void testWeakRef() {
		
		System.out.println("testWeakRef()");
		
    	Object obj = new Object();
    	ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
    	
    	WeakReference<Object> weakRef = new WeakReference<Object>(obj, refQueue);
    	
    	System.out.println(weakRef.get());  //should not null
    	System.out.println(refQueue.poll());  //should null
    	
    	obj = null;
    	
    	System.gc();
    	
    	System.out.println(weakRef.get());	//should not null
    	System.out.println(refQueue.poll()); //should not null
    	
    }
    
    public void testPhantomRef() {
    	
    	System.out.println("testPhantomRef()");
    	
    	
    	Object obj = new MyObject();
    	ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
    	
    	PhantomReference<Object> phantomRef = new PhantomReference<Object>(obj, refQueue);
    	
    	System.out.println(phantomRef.get());    //will always null
    	System.out.println(refQueue.poll());   //might null
    	
    	obj = null;
    	System.gc();
    
    	
//    	try {
//    		//wait 3s
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	System.out.println(phantomRef.get());    //will always null
    	System.out.println(refQueue.poll());  //should not null
    	
    }
    
    private static class MyObject {
    	
    	protected void finalize() throws Throwable {
    		super.finalize();
    		System.out.println("MyObject is finalizing...");
    	}
    }
    
}
