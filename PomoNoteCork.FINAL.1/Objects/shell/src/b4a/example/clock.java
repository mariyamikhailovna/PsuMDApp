
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

public class clock implements IRemote{
	public static clock mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public clock() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("clock"), "b4a.example.clock");
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
		pcBA = new PCBA(this, clock.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _timercount = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _secondsremain = RemoteObject.createImmutable(0);
public static RemoteObject _pomotimerlbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _playbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pomocounter = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _settingsbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _settingspnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _pomotxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _shorttxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _longtxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _timerstate = RemoteObject.createImmutable(0);
public static RemoteObject _counter = RemoteObject.createImmutable(0);
public static RemoteObject _pomodef = RemoteObject.createImmutable(0);
public static RemoteObject _shortdef = RemoteObject.createImmutable(0);
public static RemoteObject _longdef = RemoteObject.createImmutable(0);
public static RemoteObject _centerleft = RemoteObject.createImmutable(0);
public static RemoteObject _centertop = RemoteObject.createImmutable(0);
public static RemoteObject _playing = RemoteObject.createImmutable(false);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.note _note = null;
public static b4a.example.editnote _editnote = null;
public static b4a.example.cork _cork = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",clock.mostCurrent._activity,"centerLeft",clock._centerleft,"centerTop",clock._centertop,"cork",Debug.moduleToString(b4a.example.cork.class),"counter",clock._counter,"editnote",Debug.moduleToString(b4a.example.editnote.class),"longDef",clock._longdef,"longTxt",clock.mostCurrent._longtxt,"Main",Debug.moduleToString(b4a.example.main.class),"note",Debug.moduleToString(b4a.example.note.class),"playBtn",clock.mostCurrent._playbtn,"playing",clock._playing,"pomoCounter",clock.mostCurrent._pomocounter,"pomoDef",clock._pomodef,"pomotimerLbl",clock.mostCurrent._pomotimerlbl,"pomoTxt",clock.mostCurrent._pomotxt,"secondsRemain",clock._secondsremain,"settingsBtn",clock.mostCurrent._settingsbtn,"settingsPnl",clock.mostCurrent._settingspnl,"shortDef",clock._shortdef,"shortTxt",clock.mostCurrent._shorttxt,"Starter",Debug.moduleToString(b4a.example.starter.class),"timerCount",clock._timercount,"timerState",clock._timerstate,"xui",clock._xui};
}
}