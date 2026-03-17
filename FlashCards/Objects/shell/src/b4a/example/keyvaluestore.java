
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
public static b4a.example.subdeck_module _subdeck_module = null;
public static b4a.example.card_module _card_module = null;
public static b4a.example.all_active_recall _all_active_recall = null;
public static b4a.example.add_card_module2 _add_card_module2 = null;
public static b4a.example.deck_all_cards _deck_all_cards = null;
public static b4a.example.add_card_module _add_card_module = null;
public static b4a.example.active_recall _active_recall = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ser",_ref.getField(false, "_ser"),"sql1",_ref.getField(false, "_sql1")};
}
}