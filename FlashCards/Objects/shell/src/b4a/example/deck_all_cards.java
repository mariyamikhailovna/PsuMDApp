
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

public class deck_all_cards implements IRemote{
	public static deck_all_cards mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public deck_all_cards() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("deck_all_cards"), "b4a.example.deck_all_cards");
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
		pcBA = new PCBA(this, deck_all_cards.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _deckname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.subdeck_module _subdeck_module = null;
public static b4a.example.card_module _card_module = null;
public static b4a.example.all_active_recall _all_active_recall = null;
public static b4a.example.add_card_module2 _add_card_module2 = null;
public static b4a.example.add_card_module _add_card_module = null;
public static b4a.example.active_recall _active_recall = null;
  public Object[] GetGlobals() {
		return new Object[] {"ACTIVE_RECALL",Debug.moduleToString(b4a.example.active_recall.class),"Activity",deck_all_cards.mostCurrent._activity,"Add_Card_Module",Debug.moduleToString(b4a.example.add_card_module.class),"Add_Card_Module2",Debug.moduleToString(b4a.example.add_card_module2.class),"ALL_ACTIVE_RECALL",Debug.moduleToString(b4a.example.all_active_recall.class),"Card_Module",Debug.moduleToString(b4a.example.card_module.class),"cards",deck_all_cards.mostCurrent._cards,"deckname",deck_all_cards.mostCurrent._deckname,"Main",Debug.moduleToString(b4a.example.main.class),"ScrollView1",deck_all_cards.mostCurrent._scrollview1,"Starter",Debug.moduleToString(b4a.example.starter.class),"Subdeck_Module",Debug.moduleToString(b4a.example.subdeck_module.class)};
}
}