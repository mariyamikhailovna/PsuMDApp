
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

public class editnote implements IRemote{
	public static editnote mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public editnote() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("editnote"), "b4a.example.editnote");
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
		pcBA = new PCBA(this, editnote.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _activenote = RemoteObject.declareNull("b4a.example.main._mynote");
public static RemoteObject _contenttxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _savebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _tagstxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _titletxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _defaultid = RemoteObject.createImmutable(0L);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.clock _clock = null;
public static b4a.example.note _note = null;
public static b4a.example.cork _cork = null;
  public Object[] GetGlobals() {
		return new Object[] {"ActiveNote",editnote._activenote,"Activity",editnote.mostCurrent._activity,"clock",Debug.moduleToString(b4a.example.clock.class),"contentTxt",editnote.mostCurrent._contenttxt,"cork",Debug.moduleToString(b4a.example.cork.class),"defaultID",editnote._defaultid,"Main",Debug.moduleToString(b4a.example.main.class),"note",Debug.moduleToString(b4a.example.note.class),"saveBtn",editnote.mostCurrent._savebtn,"Starter",Debug.moduleToString(b4a.example.starter.class),"tagsTxt",editnote.mostCurrent._tagstxt,"titleTxt",editnote.mostCurrent._titletxt};
}
}