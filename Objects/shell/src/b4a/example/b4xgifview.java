
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class b4xgifview {
    public static RemoteObject myClass;
	public b4xgifview() {
	}
    public static PCBA staticBA = new PCBA(null, b4xgifview.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _mbase = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _tag = RemoteObject.declareNull("Object");
public static RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _gifdrawable = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.mainactivity _mainactivity = null;
public static b4a.example.navactivity _navactivity = null;
public static b4a.example.helpactivity _helpactivity = null;
public static b4a.example.clockactivity _clockactivity = null;
public static b4a.example.noteactivity _noteactivity = null;
public static b4a.example.editnote _editnote = null;
public static b4a.example.corkactivity _corkactivity = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"GifDrawable",_ref.getField(false, "_gifdrawable"),"iv",_ref.getField(false, "_iv"),"mBase",_ref.getField(false, "_mbase"),"mCallBack",_ref.getField(false, "_mcallback"),"mEventName",_ref.getField(false, "_meventname"),"Tag",_ref.getField(false, "_tag"),"xui",_ref.getField(false, "_xui")};
}
}