package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class flashcardactivity extends Activity implements B4AActivity{
	public static flashcardactivity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.flashcardactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (flashcardactivity).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.flashcardactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.flashcardactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (flashcardactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (flashcardactivity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return flashcardactivity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (flashcardactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (flashcardactivity) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            flashcardactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (flashcardactivity) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.collections.Map _deck = null;
public static String _selecteddeck = "";
public static String _item_longclick = "";
public static b4a.example3.keyvaluestore _kvs = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lvdecks = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addbtn = null;
public anywheresoftware.b4a.objects.PanelWrapper _addpanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _decknamelabel = null;
public anywheresoftware.b4a.objects.PanelWrapper _decksettingpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _renamepanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _newdeckname = null;
public anywheresoftware.b4a.objects.PanelWrapper _newsubdeckpanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _newsubdecket = null;
public anywheresoftware.b4a.objects.PanelWrapper _deleteconfirmation = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.day_module _day_module = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.card_module _card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.navactivity _navactivity = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _radius = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 42;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"FlashCardLayout\")";
mostCurrent._activity.LoadLayout("FlashCardLayout",mostCurrent.activityBA);
 }else {
 //BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"FlashCardLayoutDark\")";
mostCurrent._activity.LoadLayout("FlashCardLayoutDark",mostCurrent.activityBA);
 };
 //BA.debugLineNum = 49;BA.debugLine="Dim radius As Int = Addbtn.Width/2";
_radius = (int) (mostCurrent._addbtn.getWidth()/(double)2);
 //BA.debugLineNum = 50;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 51;BA.debugLine="cd.Initialize(Colors.Gray, radius)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Gray,_radius);
 //BA.debugLineNum = 52;BA.debugLine="Addbtn.Background = cd";
mostCurrent._addbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 55;BA.debugLine="LVdecks.SingleLineLayout.Label.textcolor = Colors";
mostCurrent._lvdecks.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 57;BA.debugLine="kvs = Starter.deckKvs";
_kvs = mostCurrent._starter._deckkvs /*b4a.example3.keyvaluestore*/ ;
 //BA.debugLineNum = 58;BA.debugLine="deck = Starter.deck";
_deck = mostCurrent._starter._deck /*anywheresoftware.b4a.objects.collections.Map*/ ;
 //BA.debugLineNum = 63;BA.debugLine="refreshbtn_Click";
_refreshbtn_click();
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Private Sub Addbtn_Click";
 //BA.debugLineNum = 82;BA.debugLine="If addpanel.Visible = True Then";
if (mostCurrent._addpanel.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 83;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 85;BA.debugLine="addpanel.Visible = True";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _addcards_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
 //BA.debugLineNum = 151;BA.debugLine="Private Sub addcards_Click";
 //BA.debugLineNum = 152;BA.debugLine="Dim tappeddeck As Map = deck.Get(item_longclick)";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deck.Get((Object)(_item_longclick))));
 //BA.debugLineNum = 153;BA.debugLine="If tappeddeck.Size = 0 Then";
if (_tappeddeck.getSize()==0) { 
 //BA.debugLineNum = 154;BA.debugLine="MsgboxAsync(\"Create A Sub-Deck first\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Create A Sub-Deck first"),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 155;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 157;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 158;BA.debugLine="StartActivity(Add_card_module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._add_card_module.getObject()));
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public static String  _browse_cards_click() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Private Sub browse_cards_Click";
 //BA.debugLineNum = 177;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 178;BA.debugLine="StartActivity(deck_all_cards)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._deck_all_cards.getObject()));
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static String  _cancel_click() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Private Sub cancel_Click";
 //BA.debugLineNum = 90;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 92;BA.debugLine="et1.Text = \"\"";
mostCurrent._et1.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _cancelbtn_click() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Private Sub cancelbtn_Click";
 //BA.debugLineNum = 182;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public static String  _canceldelete_click() throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Private Sub canceldelete_Click";
 //BA.debugLineNum = 245;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public static String  _cancelnew_click() throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Private Sub cancelnew_Click";
 //BA.debugLineNum = 207;BA.debugLine="newdeckname.text = False";
mostCurrent._newdeckname.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 208;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public static String  _cancelnewsubdeck_click() throws Exception{
 //BA.debugLineNum = 232;BA.debugLine="Private Sub cancelnewsubdeck_Click";
 //BA.debugLineNum = 233;BA.debugLine="newsubdecket.Text = \"\"";
mostCurrent._newsubdecket.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 234;BA.debugLine="newsubdeckpanel.Visible = False";
mostCurrent._newsubdeckpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public static String  _confirmdelete_click() throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Private Sub confirmdelete_Click";
 //BA.debugLineNum = 238;BA.debugLine="deck.Remove(item_longclick)";
_deck.Remove((Object)(_item_longclick));
 //BA.debugLineNum = 239;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 240;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 241;BA.debugLine="refreshbtn_Click";
_refreshbtn_click();
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public static String  _confirmnew_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _getsubdeck = null;
String _names = "";
 //BA.debugLineNum = 185;BA.debugLine="Private Sub confirmnew_Click";
 //BA.debugLineNum = 186;BA.debugLine="Dim getsubdeck As Map";
_getsubdeck = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 187;BA.debugLine="If newdeckname.Text = \"\" Then";
if ((mostCurrent._newdeckname.getText()).equals("")) { 
 //BA.debugLineNum = 188;BA.debugLine="MsgboxAsync(\"New Name must have a name\", \"Error\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("New Name must have a name"),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 189;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 191;BA.debugLine="For Each names As String In deck.keys";
{
final anywheresoftware.b4a.BA.IterableList group6 = _deck.Keys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_names = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 192;BA.debugLine="getsubdeck = deck.Get(item_longclick)";
_getsubdeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deck.Get((Object)(_item_longclick))));
 //BA.debugLineNum = 193;BA.debugLine="If newdeckname.Text = names Then";
if ((mostCurrent._newdeckname.getText()).equals(_names)) { 
 //BA.debugLineNum = 194;BA.debugLine="MsgboxAsync(\"Deck Name Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Deck Name Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 195;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 198;BA.debugLine="deck.Remove(item_longclick)";
_deck.Remove((Object)(_item_longclick));
 //BA.debugLineNum = 199;BA.debugLine="deck.Put(newdeckname.Text, getsubdeck)";
_deck.Put((Object)(mostCurrent._newdeckname.getText()),(Object)(_getsubdeck.getObject()));
 //BA.debugLineNum = 200;BA.debugLine="newdeckname.text = \"\"";
mostCurrent._newdeckname.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 201;BA.debugLine="SaveDecks";
_savedecks();
 //BA.debugLineNum = 202;BA.debugLine="refreshbtn_Click";
_refreshbtn_click();
 //BA.debugLineNum = 203;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public static String  _create_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _newsubdeck = null;
String _names = "";
 //BA.debugLineNum = 96;BA.debugLine="Private Sub create_Click";
 //BA.debugLineNum = 99;BA.debugLine="Dim newsubdeck As Map";
_newsubdeck = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 101;BA.debugLine="newsubdeck.initialize";
_newsubdeck.Initialize();
 //BA.debugLineNum = 104;BA.debugLine="For Each names As String In deck.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _deck.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_names = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 105;BA.debugLine="If et1.Text = names Then";
if ((mostCurrent._et1.getText()).equals(_names)) { 
 //BA.debugLineNum = 106;BA.debugLine="MsgboxAsync(\"Deck Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Deck Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 107;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 112;BA.debugLine="If et1.Text = \"\" Then";
if ((mostCurrent._et1.getText()).equals("")) { 
 //BA.debugLineNum = 113;BA.debugLine="MsgboxAsync(\"Deck must have a name\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Deck must have a name"),BA.ObjectToCharSequence("Error"),processBA);
 }else {
 //BA.debugLineNum = 116;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 117;BA.debugLine="LVdecks.AddSingleLine(et1.Text)";
mostCurrent._lvdecks.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et1.getText()));
 //BA.debugLineNum = 120;BA.debugLine="deck.Put(et1.Text, newsubdeck)";
_deck.Put((Object)(mostCurrent._et1.getText()),(Object)(_newsubdeck.getObject()));
 //BA.debugLineNum = 121;BA.debugLine="SaveDecks";
_savedecks();
 //BA.debugLineNum = 123;BA.debugLine="et1.Text = \"\"";
mostCurrent._et1.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _create_subdeck_click() throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Private Sub create_subdeck_Click";
 //BA.debugLineNum = 172;BA.debugLine="newsubdeckpanel.Visible = True";
mostCurrent._newsubdeckpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 173;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public static String  _createnewsubdeck_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _createdeck = null;
anywheresoftware.b4a.objects.collections.List _flashcard = null;
String _subdeck = "";
 //BA.debugLineNum = 211;BA.debugLine="Private Sub createnewsubdeck_Click";
 //BA.debugLineNum = 212;BA.debugLine="If newsubdecket.Text = \"\" Then";
if ((mostCurrent._newsubdecket.getText()).equals("")) { 
 //BA.debugLineNum = 213;BA.debugLine="MsgboxAsync(\"New Sub Deck must have a name\", \"Er";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("New Sub Deck must have a name"),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 214;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 216;BA.debugLine="Dim createdeck As Map = deck.Get(item_longclick)";
_createdeck = new anywheresoftware.b4a.objects.collections.Map();
_createdeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deck.Get((Object)(_item_longclick))));
 //BA.debugLineNum = 217;BA.debugLine="Dim flashcard As List";
_flashcard = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 218;BA.debugLine="flashcard.Initialize";
_flashcard.Initialize();
 //BA.debugLineNum = 219;BA.debugLine="For Each subdeck As String In createdeck.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _createdeck.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_subdeck = BA.ObjectToString(group8.Get(index8));
 //BA.debugLineNum = 220;BA.debugLine="If newsubdecket.Text = subdeck Then";
if ((mostCurrent._newsubdecket.getText()).equals(_subdeck)) { 
 //BA.debugLineNum = 221;BA.debugLine="MsgboxAsync(\"Subdeck Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Subdeck Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
 //BA.debugLineNum = 222;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 225;BA.debugLine="createdeck.Put(newsubdecket.Text, flashcard)";
_createdeck.Put((Object)(mostCurrent._newsubdecket.getText()),(Object)(_flashcard.getObject()));
 //BA.debugLineNum = 226;BA.debugLine="SaveDecks";
_savedecks();
 //BA.debugLineNum = 227;BA.debugLine="newsubdecket.Text = \"\"";
mostCurrent._newsubdecket.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 228;BA.debugLine="newsubdeckpanel.Visible = False";
mostCurrent._newsubdeckpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 229;BA.debugLine="StartActivity(Subdeck_Module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._subdeck_module.getObject()));
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public static String  _delete_deck_click() throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Private Sub delete_deck_Click";
 //BA.debugLineNum = 167;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 168;BA.debugLine="deleteconfirmation.Visible = True";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private LVdecks As ListView";
mostCurrent._lvdecks = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private Addbtn As Button";
mostCurrent._addbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private addpanel As Panel";
mostCurrent._addpanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private et1 As EditText";
mostCurrent._et1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private decknamelabel As Label";
mostCurrent._decknamelabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private decksettingpanel As Panel";
mostCurrent._decksettingpanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private renamepanel As Panel";
mostCurrent._renamepanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private newdeckname As EditText";
mostCurrent._newdeckname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private newsubdeckpanel As Panel";
mostCurrent._newsubdeckpanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private newsubdecket As EditText";
mostCurrent._newsubdecket = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private deleteconfirmation As Panel";
mostCurrent._deleteconfirmation = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _lvdecks_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Private Sub LVdecks_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 138;BA.debugLine="selecteddeck = Value";
_selecteddeck = BA.ObjectToString(_value);
 //BA.debugLineNum = 139;BA.debugLine="StartActivity(Subdeck_Module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._subdeck_module.getObject()));
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _lvdecks_itemlongclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Private Sub LVdecks_ItemLongClick (Position As Int";
 //BA.debugLineNum = 144;BA.debugLine="decksettingpanel.Visible = True";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 145;BA.debugLine="item_longclick = Value";
_item_longclick = BA.ObjectToString(_value);
 //BA.debugLineNum = 146;BA.debugLine="selecteddeck = Value";
_selecteddeck = BA.ObjectToString(_value);
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 13;BA.debugLine="Dim deck As Map 'to access deck created";
_deck = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 14;BA.debugLine="Dim selecteddeck As String 'selected subdeck as s";
_selecteddeck = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim item_longclick As String";
_item_longclick = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim kvs As KeyValueStore";
_kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _refreshbtn_click() throws Exception{
String _deckname = "";
 //BA.debugLineNum = 128;BA.debugLine="Private Sub refreshbtn_Click";
 //BA.debugLineNum = 130;BA.debugLine="LVdecks.clear";
mostCurrent._lvdecks.Clear();
 //BA.debugLineNum = 131;BA.debugLine="For Each deckName As String In deck.keys";
{
final anywheresoftware.b4a.BA.IterableList group2 = _deck.Keys();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_deckname = BA.ObjectToString(group2.Get(index2));
 //BA.debugLineNum = 132;BA.debugLine="LVdecks.AddSingleLine(deckName)";
mostCurrent._lvdecks.AddSingleLine(BA.ObjectToCharSequence(_deckname));
 }
};
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public static String  _rename_deck_click() throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Private Sub rename_deck_Click";
 //BA.debugLineNum = 162;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 163;BA.debugLine="renamepanel.Visible = True";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public static String  _savedecks() throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Sub SaveDecks";
 //BA.debugLineNum = 77;BA.debugLine="kvs.Put(\"deck_data\", deck)";
_kvs._put("deck_data",(Object)(_deck.getObject()));
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
}
