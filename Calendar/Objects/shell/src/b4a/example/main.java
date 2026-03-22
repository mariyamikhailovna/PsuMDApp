
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _calendarmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _kvs = RemoteObject.declareNull("b4a.example.keyvaluestore");
public static RemoteObject _months = null;
public static RemoteObject _calendarpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _weekpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _day_of_week = RemoteObject.createImmutable("");
public static RemoteObject _monthsp = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _yearsp = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _menupanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _month_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static b4a.example.starter _starter = null;
public static b4a.example.week_module _week_module = null;
public static b4a.example.day_module _day_module = null;
public static b4a.example.schedule_module _schedule_module = null;
public static b4a.example.add_events_module _add_events_module = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"Add_Events_MODULE",Debug.moduleToString(b4a.example.add_events_module.class),"CalendarMap",main._calendarmap,"calendarpanel",main.mostCurrent._calendarpanel,"Day_MODULE",Debug.moduleToString(b4a.example.day_module.class),"day_of_week",main.mostCurrent._day_of_week,"kvs",main._kvs,"menupanel",main.mostCurrent._menupanel,"Month_btn",main.mostCurrent._month_btn,"Months",main.mostCurrent._months,"MonthSp",main.mostCurrent._monthsp,"Schedule_MODULE",Debug.moduleToString(b4a.example.schedule_module.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"Week_MODULE",Debug.moduleToString(b4a.example.week_module.class),"weekpanel",main.mostCurrent._weekpanel,"xui",main._xui,"YearSP",main.mostCurrent._yearsp};
}
}