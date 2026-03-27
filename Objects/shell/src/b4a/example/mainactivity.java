
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

public class mainactivity implements IRemote{
	public static mainactivity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public mainactivity() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("mainactivity"), "b4a.example.mainactivity");
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
		pcBA = new PCBA(this, mainactivity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _timerclock = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _kvs = RemoteObject.declareNull("b4a.example3.keyvaluestore");
public static RemoteObject _format24h = RemoteObject.createImmutable(false);
public static RemoteObject _reglayout = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _darkmodelayout = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _size = RemoteObject.createImmutable(0);
public static RemoteObject _hsv = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
public static RemoteObject _computergif = RemoteObject.declareNull("b4a.example.b4xgifview");
public static RemoteObject _dcomputergif = RemoteObject.declareNull("b4a.example.b4xgifview");
public static RemoteObject _clockbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _clocklightbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _infopnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _infotitlelbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _infodesclbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _infopagelbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _infopage = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.navactivity _navactivity = null;
public static b4a.example.helpactivity _helpactivity = null;
public static b4a.example.clockactivity _clockactivity = null;
public static b4a.example.noteactivity _noteactivity = null;
public static b4a.example.editnote _editnote = null;
public static b4a.example.corkactivity _corkactivity = null;
public static b4a.example.todoactivity _todoactivity = null;
public static b4a.example.musicservice _musicservice = null;
public static b4a.example.musicactivity _musicactivity = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",mainactivity.mostCurrent._activity,"clockActivity",Debug.moduleToString(b4a.example.clockactivity.class),"clockBtn",mainactivity.mostCurrent._clockbtn,"clockLightBtn",mainactivity.mostCurrent._clocklightbtn,"computerGif",mainactivity.mostCurrent._computergif,"corkActivity",Debug.moduleToString(b4a.example.corkactivity.class),"darkModeLayout",mainactivity.mostCurrent._darkmodelayout,"dcomputerGif",mainactivity.mostCurrent._dcomputergif,"editnote",Debug.moduleToString(b4a.example.editnote.class),"format24h",mainactivity._format24h,"helpActivity",Debug.moduleToString(b4a.example.helpactivity.class),"hsv",mainactivity.mostCurrent._hsv,"infoDescLbl",mainactivity.mostCurrent._infodesclbl,"infoPage",mainactivity._infopage,"infoPageLbl",mainactivity.mostCurrent._infopagelbl,"infoPnl",mainactivity.mostCurrent._infopnl,"infoTitleLbl",mainactivity.mostCurrent._infotitlelbl,"kvs",mainactivity._kvs,"Main",Debug.moduleToString(b4a.example.main.class),"musicActivity",Debug.moduleToString(b4a.example.musicactivity.class),"musicService",Debug.moduleToString(b4a.example.musicservice.class),"navActivity",Debug.moduleToString(b4a.example.navactivity.class),"noteActivity",Debug.moduleToString(b4a.example.noteactivity.class),"regLayout",mainactivity.mostCurrent._reglayout,"size",mainactivity._size,"Starter",Debug.moduleToString(b4a.example.starter.class),"timerClock",mainactivity._timerclock,"todoActivity",Debug.moduleToString(b4a.example.todoactivity.class),"xui",mainactivity._xui};
}
}