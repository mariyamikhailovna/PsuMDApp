
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class keyvaluestore {
    public static RemoteObject myClass;
	public keyvaluestore() {
	}
    public static PCBA staticBA = new PCBA(null, keyvaluestore.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sql1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _ser = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.B4XSerializator");
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
		return new Object[] {"ser",_ref.getField(false, "_ser"),"sql1",_ref.getField(false, "_sql1")};
}
}