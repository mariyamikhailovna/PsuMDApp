
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class noteactivity implements IRemote{
	public static noteactivity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public noteactivity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("noteactivity"), "b4a.example.noteactivity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, noteactivity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _kvs = RemoteObject.declareNull("b4a.example3.keyvaluestore");
public static RemoteObject _addbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _noteclv = RemoteObject.declareNull("b4a.example3.customlistview");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.mainactivity _mainactivity = null;
public static b4a.example.navactivity _navactivity = null;
public static b4a.example.helpactivity _helpactivity = null;
public static b4a.example.clockactivity _clockactivity = null;
public static b4a.example.editnote _editnote = null;
public static b4a.example.corkactivity _corkactivity = null;
public static b4a.example.todoactivity _todoactivity = null;
public static b4a.example.musicservice _musicservice = null;
public static b4a.example.musicactivity _musicactivity = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",noteactivity.mostCurrent._activity,"addBtn",noteactivity.mostCurrent._addbtn,"clockActivity",Debug.moduleToString(b4a.example.clockactivity.class),"corkActivity",Debug.moduleToString(b4a.example.corkactivity.class),"editnote",Debug.moduleToString(b4a.example.editnote.class),"helpActivity",Debug.moduleToString(b4a.example.helpactivity.class),"kvs",noteactivity._kvs,"Main",Debug.moduleToString(b4a.example.main.class),"MainActivity",Debug.moduleToString(b4a.example.mainactivity.class),"musicActivity",Debug.moduleToString(b4a.example.musicactivity.class),"musicService",Debug.moduleToString(b4a.example.musicservice.class),"navActivity",Debug.moduleToString(b4a.example.navactivity.class),"noteClv",noteactivity.mostCurrent._noteclv,"Starter",Debug.moduleToString(b4a.example.starter.class),"todoActivity",Debug.moduleToString(b4a.example.todoactivity.class),"xui",noteactivity._xui};
}
}