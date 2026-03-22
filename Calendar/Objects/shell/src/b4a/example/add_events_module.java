
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

public class add_events_module implements IRemote{
	public static add_events_module mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public add_events_module() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("add_events_module"), "b4a.example.add_events_module");
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
		pcBA = new PCBA(this, add_events_module.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _eventtype = RemoteObject.createImmutable("");
public static RemoteObject _currentdate = RemoteObject.createImmutable("");
public static RemoteObject _taskrb = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _eventrb = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _birthdayrb = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _ooorb = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _timelbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _title_et = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _description_et = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.week_module _week_module = null;
public static b4a.example.day_module _day_module = null;
public static b4a.example.schedule_module _schedule_module = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",add_events_module.mostCurrent._activity,"birthdayrb",add_events_module.mostCurrent._birthdayrb,"currentDate",add_events_module._currentdate,"Day_MODULE",Debug.moduleToString(b4a.example.day_module.class),"description_et",add_events_module.mostCurrent._description_et,"eventrb",add_events_module.mostCurrent._eventrb,"eventtype",add_events_module._eventtype,"Main",Debug.moduleToString(b4a.example.main.class),"ooorb",add_events_module.mostCurrent._ooorb,"Schedule_MODULE",Debug.moduleToString(b4a.example.schedule_module.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"taskrb",add_events_module.mostCurrent._taskrb,"timelbl",add_events_module.mostCurrent._timelbl,"title_et",add_events_module.mostCurrent._title_et,"Week_MODULE",Debug.moduleToString(b4a.example.week_module.class)};
}
}