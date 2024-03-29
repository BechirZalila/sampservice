package com.android.sampservice;
 
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog; 
import java.util.HashSet;
import java.util.Set;

public class SampManager {
    private static final String REMOTE_SERVICE_NAME =
	ISampService.class.getName();  
    private final ISampService service;
  
    public static SampManager getInstance() {
	return new SampManager();
    }
 
    public int add(int a,int b) 
    {
	try
	    {
		return service.add(a,b);
	    }catch(Exception ec){}
	return 0;
    }
 
    public int sub(int a,int b) 
    {
	try
	    {
		return service.sub(a,b);
	    }catch(Exception ec){}
	return 0;
    }
    
    private SampManager() {
	this.service = ISampService.Stub.asInterface
	    (ServiceManager.getService(REMOTE_SERVICE_NAME));             
	if (this.service == null) {
	    throw new IllegalStateException
		("Failed to find ISampService by name ["
		 + REMOTE_SERVICE_NAME + "]");
	}
    }    
}
