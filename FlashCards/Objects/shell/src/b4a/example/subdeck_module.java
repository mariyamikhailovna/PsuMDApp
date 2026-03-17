
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

public class subdeck_module implements IRemote{
	public static subdeck_module mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public subdeck_module() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("subdeck_module"), "b4a.example.subdeck_module");
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
		pcBA = new PCBA(this, subdeck_module.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _selectedsubdeck = RemoteObject.createImmutable("");
public static RemoteObject _addbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _addpanel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _alldecks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _selecteddeck = RemoteObject.createImmutable("");
public static RemoteObject _lvsubdecks = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _decknamelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _addpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _et1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _ar_confirmationpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _confirmlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _number_of_cards = RemoteObject.createImmutable(0);
public static RemoteObject _alterpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _renamepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _renameet = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _deleteconfirmation = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.card_module _card_module = null;
public static b4a.example.all_active_recall _all_active_recall = null;
public static b4a.example.add_card_module2 _add_card_module2 = null;
public static b4a.example.deck_all_cards _deck_all_cards = null;
public static b4a.example.add_card_module _add_card_module = null;
public static b4a.example.active_recall _active_recall = null;
  public Object[] GetGlobals() {
		return new Object[] {"ACTIVE_RECALL",Debug.moduleToString(b4a.example.active_recall.class),"Activity",subdeck_module.mostCurrent._activity,"Add_Card_Module",Debug.moduleToString(b4a.example.add_card_module.class),"Add_Card_Module2",Debug.moduleToString(b4a.example.add_card_module2.class),"Addbtn",subdeck_module.mostCurrent._addbtn,"addpanel",subdeck_module.mostCurrent._addpanel,"addpanel2",subdeck_module.mostCurrent._addpanel2,"ALL_ACTIVE_RECALL",Debug.moduleToString(b4a.example.all_active_recall.class),"alldecks",subdeck_module.mostCurrent._alldecks,"alterpanel",subdeck_module.mostCurrent._alterpanel,"AR_confirmationpanel",subdeck_module.mostCurrent._ar_confirmationpanel,"Card_Module",Debug.moduleToString(b4a.example.card_module.class),"confirmlabel",subdeck_module.mostCurrent._confirmlabel,"DECK_ALL_CARDS",Debug.moduleToString(b4a.example.deck_all_cards.class),"decknamelabel",subdeck_module.mostCurrent._decknamelabel,"deleteconfirmation",subdeck_module.mostCurrent._deleteconfirmation,"et1",subdeck_module.mostCurrent._et1,"LVSubdecks",subdeck_module.mostCurrent._lvsubdecks,"Main",Debug.moduleToString(b4a.example.main.class),"number_of_cards",subdeck_module._number_of_cards,"renameet",subdeck_module.mostCurrent._renameet,"renamepanel",subdeck_module.mostCurrent._renamepanel,"selecteddeck",subdeck_module.mostCurrent._selecteddeck,"selectedsubdeck",subdeck_module._selectedsubdeck,"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}