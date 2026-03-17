
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
public static RemoteObject _deck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _selecteddeck = RemoteObject.createImmutable("");
public static RemoteObject _item_longclick = RemoteObject.createImmutable("");
public static RemoteObject _kvs = RemoteObject.declareNull("b4a.example.keyvaluestore");
public static RemoteObject _lvdecks = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _addbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _addpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _decknamelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _decksettingpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _renamepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _newdeckname = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _newsubdeckpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _newsubdecket = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static b4a.example.starter _starter = null;
public static b4a.example.subdeck_module _subdeck_module = null;
public static b4a.example.card_module _card_module = null;
public static b4a.example.all_active_recall _all_active_recall = null;
public static b4a.example.active_recall _active_recall = null;
public static b4a.example.add_card_module2 _add_card_module2 = null;
public static b4a.example.deck_all_cards _deck_all_cards = null;
public static b4a.example.add_card_module _add_card_module = null;
  public Object[] GetGlobals() {
		return new Object[] {"ACTIVE_RECALL",Debug.moduleToString(b4a.example.active_recall.class),"Activity",main.mostCurrent._activity,"Add_Card_Module",Debug.moduleToString(b4a.example.add_card_module.class),"Add_Card_Module2",Debug.moduleToString(b4a.example.add_card_module2.class),"Addbtn",main.mostCurrent._addbtn,"addpanel",main.mostCurrent._addpanel,"ALL_ACTIVE_RECALL",Debug.moduleToString(b4a.example.all_active_recall.class),"Card_Module",Debug.moduleToString(b4a.example.card_module.class),"deck",main._deck,"DECK_ALL_CARDS",Debug.moduleToString(b4a.example.deck_all_cards.class),"decknamelabel",main.mostCurrent._decknamelabel,"decksettingpanel",main.mostCurrent._decksettingpanel,"et1",main.mostCurrent._et1,"item_longclick",main._item_longclick,"kvs",main._kvs,"LVdecks",main.mostCurrent._lvdecks,"newdeckname",main.mostCurrent._newdeckname,"newsubdecket",main.mostCurrent._newsubdecket,"newsubdeckpanel",main.mostCurrent._newsubdeckpanel,"renamepanel",main.mostCurrent._renamepanel,"selecteddeck",main._selecteddeck,"Starter",Debug.moduleToString(b4a.example.starter.class),"Subdeck_Module",Debug.moduleToString(b4a.example.subdeck_module.class),"xui",main._xui};
}
}