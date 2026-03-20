
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
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _boardpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _addpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _canvabtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imgbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _stickybtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _notepnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _canvaspnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _lastx = RemoteObject.createImmutable(0f);
public static RemoteObject _lasty = RemoteObject.createImmutable(0f);
public static RemoteObject _dragmanager = RemoteObject.declareNull("b4a.example.dragdropview");
public static RemoteObject _place1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place7 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place8 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place9 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place10 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place11 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _place12 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _r = RemoteObject.createImmutable(0);
public static RemoteObject _g = RemoteObject.createImmutable(0);
public static RemoteObject _b = RemoteObject.createImmutable(0);
public static RemoteObject _r2 = RemoteObject.createImmutable(0);
public static RemoteObject _g2 = RemoteObject.createImmutable(0);
public static RemoteObject _b2 = RemoteObject.createImmutable(0);
public static RemoteObject _penspnr = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _width = RemoteObject.createImmutable(0);
public static RemoteObject _height = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.clock _clock = null;
public static b4a.example.note _note = null;
public static b4a.example.editnote _editnote = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",cork.mostCurrent._activity,"addPnl",cork.mostCurrent._addpnl,"B",cork._b,"B2",cork._b2,"boardPnl",cork.mostCurrent._boardpnl,"canvaBtn",cork.mostCurrent._canvabtn,"canvasPnl",cork.mostCurrent._canvaspnl,"clock",Debug.moduleToString(b4a.example.clock.class),"DragManager",cork.mostCurrent._dragmanager,"editnote",Debug.moduleToString(b4a.example.editnote.class),"G",cork._g,"G2",cork._g2,"Height",cork._height,"imgBtn",cork.mostCurrent._imgbtn,"imgPicker",cork._imgpicker,"imgView",cork.mostCurrent._imgview,"LastX",cork._lastx,"LastY",cork._lasty,"Main",Debug.moduleToString(b4a.example.main.class),"note",Debug.moduleToString(b4a.example.note.class),"notePnl",cork.mostCurrent._notepnl,"penSpnr",cork.mostCurrent._penspnr,"place1",cork.mostCurrent._place1,"place10",cork.mostCurrent._place10,"place11",cork.mostCurrent._place11,"place12",cork.mostCurrent._place12,"place2",cork.mostCurrent._place2,"place3",cork.mostCurrent._place3,"place4",cork.mostCurrent._place4,"place5",cork.mostCurrent._place5,"place6",cork.mostCurrent._place6,"place7",cork.mostCurrent._place7,"place8",cork.mostCurrent._place8,"place9",cork.mostCurrent._place9,"R",cork._r,"R2",cork._r2,"Starter",Debug.moduleToString(b4a.example.starter.class),"stickyBtn",cork.mostCurrent._stickybtn,"Width",cork._width,"xui",cork._xui};
}
}