
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

public class cork implements IRemote{
	public static cork mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public cork() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("cork"), "b4a.example.cork");
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
		pcBA = new PCBA(this, cork.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _imgpicker = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _boardpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _addpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _canvabtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imgbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _stickybtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _stringbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _stickytxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lastx = RemoteObject.createImmutable(0f);
public static RemoteObject _lasty = RemoteObject.createImmutable(0f);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.clock _clock = null;
public static b4a.example.note _note = null;
public static b4a.example.editnote _editnote = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",cork.mostCurrent._activity,"addPnl",cork.mostCurrent._addpnl,"boardPnl",cork.mostCurrent._boardpnl,"canvaBtn",cork.mostCurrent._canvabtn,"clock",Debug.moduleToString(b4a.example.clock.class),"editnote",Debug.moduleToString(b4a.example.editnote.class),"imgBtn",cork.mostCurrent._imgbtn,"imgPicker",cork._imgpicker,"imgView",cork.mostCurrent._imgview,"LastX",cork._lastx,"LastY",cork._lasty,"Main",Debug.moduleToString(b4a.example.main.class),"note",Debug.moduleToString(b4a.example.note.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"stickyBtn",cork.mostCurrent._stickybtn,"stickyTxt",cork.mostCurrent._stickytxt,"stringBtn",cork.mostCurrent._stringbtn};
}
}