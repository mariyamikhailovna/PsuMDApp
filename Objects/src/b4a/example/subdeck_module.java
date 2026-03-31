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

public class subdeck_module extends Activity implements B4AActivity{
	public static subdeck_module mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.subdeck_module");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (subdeck_module).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.subdeck_module");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.subdeck_module", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (subdeck_module) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (subdeck_module) Resume **");
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
		return subdeck_module.class;
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
            BA.LogInfo("** Activity (subdeck_module) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (subdeck_module) Pause event (activity is not paused). **");
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
            subdeck_module mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (subdeck_module) Resume **");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _selectedsubdeck = "";
public anywheresoftware.b4a.objects.ButtonWrapper _addbtn = null;
public anywheresoftware.b4a.objects.PanelWrapper _addpanel2 = null;
public anywheresoftware.b4a.objects.collections.Map _alldecks = null;
public static String _selecteddeck = "";
public anywheresoftware.b4a.objects.ListViewWrapper _lvsubdecks = null;
public anywheresoftware.b4a.objects.LabelWrapper _decknamelabel = null;
public anywheresoftware.b4a.objects.PanelWrapper _addpanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _ar_confirmationpanel = null;
public anywheresoftware.b4a.objects.LabelWrapper _confirmlabel = null;
public static int _number_of_cards = 0;
public anywheresoftware.b4a.objects.PanelWrapper _alterpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _renamepanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _renameet = null;
public anywheresoftware.b4a.objects.PanelWrapper _deleteconfirmation = null;
public b4a.example.main _main = null;
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
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.starter _starter = null;
public b4a.example.todoactivity _todoactivity = null;
public static String  _activerecall_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activerecall_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activerecall_click", null));}
anywheresoftware.b4a.objects.collections.Map _chosendeck = null;
String _deckname = "";
anywheresoftware.b4a.objects.collections.List _flashacards = null;
RDebugUtils.currentLine=24313856;
 //BA.debugLineNum = 24313856;BA.debugLine="Private Sub activerecall_Click";
RDebugUtils.currentLine=24313859;
 //BA.debugLineNum = 24313859;BA.debugLine="number_of_cards = 0";
_number_of_cards = (int) (0);
RDebugUtils.currentLine=24313861;
 //BA.debugLineNum = 24313861;BA.debugLine="Dim chosendeck As Map = alldecks.Get(selecteddeck";
_chosendeck = new anywheresoftware.b4a.objects.collections.Map();
_chosendeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._alldecks.Get((Object)(mostCurrent._selecteddeck))));
RDebugUtils.currentLine=24313863;
 //BA.debugLineNum = 24313863;BA.debugLine="For Each deckName As String In chosendeck.keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _chosendeck.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_deckname = BA.ObjectToString(group3.Get(index3));
RDebugUtils.currentLine=24313864;
 //BA.debugLineNum = 24313864;BA.debugLine="Dim flashacards As List = chosendeck.Get(deckNam";
_flashacards = new anywheresoftware.b4a.objects.collections.List();
_flashacards = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_chosendeck.Get((Object)(_deckname))));
RDebugUtils.currentLine=24313865;
 //BA.debugLineNum = 24313865;BA.debugLine="number_of_cards = number_of_cards + flashacards.";
_number_of_cards = (int) (_number_of_cards+_flashacards.getSize());
 }
};
RDebugUtils.currentLine=24313868;
 //BA.debugLineNum = 24313868;BA.debugLine="AR_confirmationpanel.Visible = True";
mostCurrent._ar_confirmationpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24313869;
 //BA.debugLineNum = 24313869;BA.debugLine="confirmlabel.Text = \"You got \" & number_of_cards";
mostCurrent._confirmlabel.setText(BA.ObjectToCharSequence("You got "+BA.NumberToString(_number_of_cards)+" cards"));
RDebugUtils.currentLine=24313870;
 //BA.debugLineNum = 24313870;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _radius = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
RDebugUtils.currentLine=23592960;
 //BA.debugLineNum = 23592960;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=23592961;
 //BA.debugLineNum = 23592961;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=23592962;
 //BA.debugLineNum = 23592962;BA.debugLine="Activity.LoadLayout(\"Subdeck_ModuleLayout\")";
mostCurrent._activity.LoadLayout("Subdeck_ModuleLayout",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=23592964;
 //BA.debugLineNum = 23592964;BA.debugLine="Activity.LoadLayout(\"Subdeck_ModuleLayoutDark\")";
mostCurrent._activity.LoadLayout("Subdeck_ModuleLayoutDark",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=23592968;
 //BA.debugLineNum = 23592968;BA.debugLine="Dim radius As Int = Addbtn.Width/2";
_radius = (int) (mostCurrent._addbtn.getWidth()/(double)2);
RDebugUtils.currentLine=23592969;
 //BA.debugLineNum = 23592969;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=23592970;
 //BA.debugLineNum = 23592970;BA.debugLine="cd.Initialize(Colors.Gray, radius)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Gray,_radius);
RDebugUtils.currentLine=23592971;
 //BA.debugLineNum = 23592971;BA.debugLine="Addbtn.Background = cd";
mostCurrent._addbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=23592974;
 //BA.debugLineNum = 23592974;BA.debugLine="decknamelabel.Text = selecteddeck";
mostCurrent._decknamelabel.setText(BA.ObjectToCharSequence(mostCurrent._selecteddeck));
RDebugUtils.currentLine=23592976;
 //BA.debugLineNum = 23592976;BA.debugLine="LVSubdecks.SingleLineLayout.Label.textColor = Col";
mostCurrent._lvsubdecks.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=23592978;
 //BA.debugLineNum = 23592978;BA.debugLine="Refresh";
_refresh();
RDebugUtils.currentLine=23592980;
 //BA.debugLineNum = 23592980;BA.debugLine="End Sub";
return "";
}
public static String  _refresh() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "refresh", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "refresh", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
String _deckname = "";
RDebugUtils.currentLine=23724032;
 //BA.debugLineNum = 23724032;BA.debugLine="Sub Refresh";
RDebugUtils.currentLine=23724033;
 //BA.debugLineNum = 23724033;BA.debugLine="LVSubdecks.clear";
mostCurrent._lvsubdecks.Clear();
RDebugUtils.currentLine=23724035;
 //BA.debugLineNum = 23724035;BA.debugLine="Dim tappeddeck As Map = alldecks.Get(selecteddeck";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._alldecks.Get((Object)(mostCurrent._selecteddeck))));
RDebugUtils.currentLine=23724038;
 //BA.debugLineNum = 23724038;BA.debugLine="For Each deckName As String In tappeddeck.keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _tappeddeck.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_deckname = BA.ObjectToString(group3.Get(index3));
RDebugUtils.currentLine=23724039;
 //BA.debugLineNum = 23724039;BA.debugLine="LVSubdecks.AddSingleLine(deckName)";
mostCurrent._lvsubdecks.AddSingleLine(BA.ObjectToCharSequence(_deckname));
 }
};
RDebugUtils.currentLine=23724041;
 //BA.debugLineNum = 23724041;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="subdeck_module";
RDebugUtils.currentLine=23855104;
 //BA.debugLineNum = 23855104;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=23855106;
 //BA.debugLineNum = 23855106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=23789568;
 //BA.debugLineNum = 23789568;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=23789569;
 //BA.debugLineNum = 23789569;BA.debugLine="If all_active_recall.praise = True Then";
if (mostCurrent._all_active_recall._praise /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=23789570;
 //BA.debugLineNum = 23789570;BA.debugLine="all_active_recall.praise = False";
mostCurrent._all_active_recall._praise /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=23789571;
 //BA.debugLineNum = 23789571;BA.debugLine="MsgboxAsync(\"You Finished Your Deck\", \"Congratul";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You Finished Your Deck"),BA.ObjectToCharSequence("Congratulations"),processBA);
 };
RDebugUtils.currentLine=23789573;
 //BA.debugLineNum = 23789573;BA.debugLine="AR_confirmationpanel.Visible = False";
mostCurrent._ar_confirmationpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=23789574;
 //BA.debugLineNum = 23789574;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addbtn_click", null));}
RDebugUtils.currentLine=23920640;
 //BA.debugLineNum = 23920640;BA.debugLine="Private Sub Addbtn_Click";
RDebugUtils.currentLine=23920642;
 //BA.debugLineNum = 23920642;BA.debugLine="If addpanel2.Visible = False Then";
if (mostCurrent._addpanel2.getVisible()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=23920643;
 //BA.debugLineNum = 23920643;BA.debugLine="addpanel2.Visible = True";
mostCurrent._addpanel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=23920645;
 //BA.debugLineNum = 23920645;BA.debugLine="addpanel2.Visible = False";
mostCurrent._addpanel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=23920648;
 //BA.debugLineNum = 23920648;BA.debugLine="End Sub";
return "";
}
public static String  _addcard_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcard_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcard_click", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
RDebugUtils.currentLine=23986176;
 //BA.debugLineNum = 23986176;BA.debugLine="Private Sub addcard_Click";
RDebugUtils.currentLine=23986178;
 //BA.debugLineNum = 23986178;BA.debugLine="Dim tappeddeck As Map = FlashcardActivity.deck.Ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=23986179;
 //BA.debugLineNum = 23986179;BA.debugLine="If tappeddeck.Size = 0 Then";
if (_tappeddeck.getSize()==0) { 
RDebugUtils.currentLine=23986180;
 //BA.debugLineNum = 23986180;BA.debugLine="MsgboxAsync(\"Create A Sub-Deck first\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Create A Sub-Deck first"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=23986181;
 //BA.debugLineNum = 23986181;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=23986183;
 //BA.debugLineNum = 23986183;BA.debugLine="StartActivity(Add_card_module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._add_card_module.getObject()));
RDebugUtils.currentLine=23986184;
 //BA.debugLineNum = 23986184;BA.debugLine="End Sub";
return "";
}
public static String  _addsub_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addsub_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addsub_click", null));}
RDebugUtils.currentLine=24051712;
 //BA.debugLineNum = 24051712;BA.debugLine="Private Sub addsub_Click";
RDebugUtils.currentLine=24051714;
 //BA.debugLineNum = 24051714;BA.debugLine="addpanel.Visible = True";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24051715;
 //BA.debugLineNum = 24051715;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=24576000;
 //BA.debugLineNum = 24576000;BA.debugLine="Private Sub backbtn_Click";
RDebugUtils.currentLine=24576001;
 //BA.debugLineNum = 24576001;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=24576002;
 //BA.debugLineNum = 24576002;BA.debugLine="End Sub";
return "";
}
public static String  _cancel_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancel_click", null));}
RDebugUtils.currentLine=24117248;
 //BA.debugLineNum = 24117248;BA.debugLine="Private Sub cancel_Click";
RDebugUtils.currentLine=24117250;
 //BA.debugLineNum = 24117250;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24117251;
 //BA.debugLineNum = 24117251;BA.debugLine="et1.Text = \"\"";
mostCurrent._et1.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=24117252;
 //BA.debugLineNum = 24117252;BA.debugLine="End Sub";
return "";
}
public static String  _cancelalter_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancelalter_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancelalter_click", null));}
RDebugUtils.currentLine=24772608;
 //BA.debugLineNum = 24772608;BA.debugLine="Private Sub cancelalter_Click";
RDebugUtils.currentLine=24772609;
 //BA.debugLineNum = 24772609;BA.debugLine="alterpanel.Visible = False";
mostCurrent._alterpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24772610;
 //BA.debugLineNum = 24772610;BA.debugLine="End Sub";
return "";
}
public static String  _cancelconfirmation_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancelconfirmation_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancelconfirmation_click", null));}
RDebugUtils.currentLine=24444928;
 //BA.debugLineNum = 24444928;BA.debugLine="Private Sub cancelconfirmation_Click";
RDebugUtils.currentLine=24444930;
 //BA.debugLineNum = 24444930;BA.debugLine="AR_confirmationpanel.Visible = False";
mostCurrent._ar_confirmationpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24444931;
 //BA.debugLineNum = 24444931;BA.debugLine="End Sub";
return "";
}
public static String  _canceldelete_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canceldelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canceldelete_click", null));}
RDebugUtils.currentLine=25100288;
 //BA.debugLineNum = 25100288;BA.debugLine="Private Sub canceldelete_Click";
RDebugUtils.currentLine=25100289;
 //BA.debugLineNum = 25100289;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25100290;
 //BA.debugLineNum = 25100290;BA.debugLine="End Sub";
return "";
}
public static String  _cancelrename_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancelrename_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancelrename_click", null));}
RDebugUtils.currentLine=24903680;
 //BA.debugLineNum = 24903680;BA.debugLine="Private Sub cancelrename_Click";
RDebugUtils.currentLine=24903681;
 //BA.debugLineNum = 24903681;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24903682;
 //BA.debugLineNum = 24903682;BA.debugLine="renameet.Text = \"\"";
mostCurrent._renameet.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=24903683;
 //BA.debugLineNum = 24903683;BA.debugLine="End Sub";
return "";
}
public static String  _confirmdelete_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "confirmdelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "confirmdelete_click", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
RDebugUtils.currentLine=25034752;
 //BA.debugLineNum = 25034752;BA.debugLine="Private Sub confirmdelete_Click";
RDebugUtils.currentLine=25034753;
 //BA.debugLineNum = 25034753;BA.debugLine="Dim tappeddeck As Map = FlashcardActivity.deck.ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=25034754;
 //BA.debugLineNum = 25034754;BA.debugLine="tappeddeck.Remove(selectedsubdeck)";
_tappeddeck.Remove((Object)(_selectedsubdeck));
RDebugUtils.currentLine=25034755;
 //BA.debugLineNum = 25034755;BA.debugLine="SaveDecks";
_savedecks();
RDebugUtils.currentLine=25034756;
 //BA.debugLineNum = 25034756;BA.debugLine="Refresh";
_refresh();
RDebugUtils.currentLine=25034757;
 //BA.debugLineNum = 25034757;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25034758;
 //BA.debugLineNum = 25034758;BA.debugLine="End Sub";
return "";
}
public static String  _savedecks() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savedecks", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "savedecks", null));}
RDebugUtils.currentLine=23658496;
 //BA.debugLineNum = 23658496;BA.debugLine="Sub SaveDecks";
RDebugUtils.currentLine=23658497;
 //BA.debugLineNum = 23658497;BA.debugLine="FlashcardActivity.kvs.Put(\"deck_data\", FlashcardA";
mostCurrent._flashcardactivity._kvs /*b4a.example3.keyvaluestore*/ ._put("deck_data",(Object)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .getObject()));
RDebugUtils.currentLine=23658498;
 //BA.debugLineNum = 23658498;BA.debugLine="End Sub";
return "";
}
public static String  _confirmrename_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "confirmrename_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "confirmrename_click", null));}
anywheresoftware.b4a.objects.collections.List _getsubdeck = null;
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
String _names = "";
RDebugUtils.currentLine=24969216;
 //BA.debugLineNum = 24969216;BA.debugLine="Private Sub confirmrename_Click";
RDebugUtils.currentLine=24969218;
 //BA.debugLineNum = 24969218;BA.debugLine="Dim getsubdeck As List";
_getsubdeck = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=24969219;
 //BA.debugLineNum = 24969219;BA.debugLine="Dim tappeddeck As Map = FlashcardActivity.deck.Ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=24969220;
 //BA.debugLineNum = 24969220;BA.debugLine="If renameet.Text = \"\" Then";
if ((mostCurrent._renameet.getText()).equals("")) { 
RDebugUtils.currentLine=24969221;
 //BA.debugLineNum = 24969221;BA.debugLine="MsgboxAsync(\"New Name must have a name\", \"Error\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("New Name must have a name"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=24969222;
 //BA.debugLineNum = 24969222;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=24969224;
 //BA.debugLineNum = 24969224;BA.debugLine="For Each names As String In tappeddeck.keys";
{
final anywheresoftware.b4a.BA.IterableList group7 = _tappeddeck.Keys();
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_names = BA.ObjectToString(group7.Get(index7));
RDebugUtils.currentLine=24969225;
 //BA.debugLineNum = 24969225;BA.debugLine="getsubdeck = tappeddeck.Get(selectedsubdeck)";
_getsubdeck = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_tappeddeck.Get((Object)(_selectedsubdeck))));
RDebugUtils.currentLine=24969226;
 //BA.debugLineNum = 24969226;BA.debugLine="If renameet.Text = names Then";
if ((mostCurrent._renameet.getText()).equals(_names)) { 
RDebugUtils.currentLine=24969227;
 //BA.debugLineNum = 24969227;BA.debugLine="MsgboxAsync(\"Sub Deck Name Already Exist\", \"Err";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Sub Deck Name Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=24969228;
 //BA.debugLineNum = 24969228;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=24969231;
 //BA.debugLineNum = 24969231;BA.debugLine="tappeddeck.Remove(selectedsubdeck)";
_tappeddeck.Remove((Object)(_selectedsubdeck));
RDebugUtils.currentLine=24969232;
 //BA.debugLineNum = 24969232;BA.debugLine="tappeddeck.Put(renameet.Text, getsubdeck)";
_tappeddeck.Put((Object)(mostCurrent._renameet.getText()),(Object)(_getsubdeck.getObject()));
RDebugUtils.currentLine=24969233;
 //BA.debugLineNum = 24969233;BA.debugLine="renameet.text = \"\"";
mostCurrent._renameet.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=24969234;
 //BA.debugLineNum = 24969234;BA.debugLine="SaveDecks";
_savedecks();
RDebugUtils.currentLine=24969235;
 //BA.debugLineNum = 24969235;BA.debugLine="Refresh";
_refresh();
RDebugUtils.currentLine=24969236;
 //BA.debugLineNum = 24969236;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24969237;
 //BA.debugLineNum = 24969237;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24969240;
 //BA.debugLineNum = 24969240;BA.debugLine="End Sub";
return "";
}
public static String  _create_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "create_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "create_click", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
anywheresoftware.b4a.objects.collections.List _flashcards = null;
Object _name = null;
RDebugUtils.currentLine=24182784;
 //BA.debugLineNum = 24182784;BA.debugLine="Private Sub create_Click";
RDebugUtils.currentLine=24182787;
 //BA.debugLineNum = 24182787;BA.debugLine="Dim tappeddeck As Map = alldecks.Get(selecteddeck";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._alldecks.Get((Object)(mostCurrent._selecteddeck))));
RDebugUtils.currentLine=24182788;
 //BA.debugLineNum = 24182788;BA.debugLine="Dim flashcards As List";
_flashcards = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=24182790;
 //BA.debugLineNum = 24182790;BA.debugLine="flashcards.initialize";
_flashcards.Initialize();
RDebugUtils.currentLine=24182793;
 //BA.debugLineNum = 24182793;BA.debugLine="For Each name In tappeddeck.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _tappeddeck.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_name = group4.Get(index4);
RDebugUtils.currentLine=24182794;
 //BA.debugLineNum = 24182794;BA.debugLine="If et1.Text = name Then";
if ((mostCurrent._et1.getText()).equals(BA.ObjectToString(_name))) { 
RDebugUtils.currentLine=24182795;
 //BA.debugLineNum = 24182795;BA.debugLine="MsgboxAsync(\"Sub-Deck Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Sub-Deck Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=24182796;
 //BA.debugLineNum = 24182796;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=24182801;
 //BA.debugLineNum = 24182801;BA.debugLine="If et1.Text = \"\" Then";
if ((mostCurrent._et1.getText()).equals("")) { 
RDebugUtils.currentLine=24182802;
 //BA.debugLineNum = 24182802;BA.debugLine="MsgboxAsync(\"Sub-Deck must have a name\", \"Error\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Sub-Deck must have a name"),BA.ObjectToCharSequence("Error"),processBA);
 }else {
RDebugUtils.currentLine=24182805;
 //BA.debugLineNum = 24182805;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24182806;
 //BA.debugLineNum = 24182806;BA.debugLine="LVSubdecks.AddSingleLine(et1.Text)";
mostCurrent._lvsubdecks.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et1.getText()));
RDebugUtils.currentLine=24182807;
 //BA.debugLineNum = 24182807;BA.debugLine="tappeddeck.Put(et1.Text, flashcards)";
_tappeddeck.Put((Object)(mostCurrent._et1.getText()),(Object)(_flashcards.getObject()));
RDebugUtils.currentLine=24182808;
 //BA.debugLineNum = 24182808;BA.debugLine="SaveDecks";
_savedecks();
RDebugUtils.currentLine=24182810;
 //BA.debugLineNum = 24182810;BA.debugLine="et1.Text = \"\"";
mostCurrent._et1.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=24182813;
 //BA.debugLineNum = 24182813;BA.debugLine="End Sub";
return "";
}
public static String  _deletesubdeck_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "deletesubdeck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "deletesubdeck_click", null));}
RDebugUtils.currentLine=24641536;
 //BA.debugLineNum = 24641536;BA.debugLine="Private Sub deletesubdeck_Click";
RDebugUtils.currentLine=24641537;
 //BA.debugLineNum = 24641537;BA.debugLine="alterpanel.Visible = False";
mostCurrent._alterpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24641538;
 //BA.debugLineNum = 24641538;BA.debugLine="deleteconfirmation.Visible = True";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24641539;
 //BA.debugLineNum = 24641539;BA.debugLine="End Sub";
return "";
}
public static String  _goback_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "goback_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "goback_click", null));}
RDebugUtils.currentLine=24248320;
 //BA.debugLineNum = 24248320;BA.debugLine="Private Sub goback_Click";
RDebugUtils.currentLine=24248322;
 //BA.debugLineNum = 24248322;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=24248323;
 //BA.debugLineNum = 24248323;BA.debugLine="End Sub";
return "";
}
public static String  _lvsubdecks_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lvsubdecks_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lvsubdecks_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=24510464;
 //BA.debugLineNum = 24510464;BA.debugLine="Private Sub LVSubdecks_ItemClick (Position As Int,";
RDebugUtils.currentLine=24510466;
 //BA.debugLineNum = 24510466;BA.debugLine="selectedsubdeck = Value 'gives the chsoen subdeck";
_selectedsubdeck = BA.ObjectToString(_value);
RDebugUtils.currentLine=24510468;
 //BA.debugLineNum = 24510468;BA.debugLine="StartActivity(Card_Module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._card_module.getObject()));
RDebugUtils.currentLine=24510469;
 //BA.debugLineNum = 24510469;BA.debugLine="End Sub";
return "";
}
public static String  _lvsubdecks_itemlongclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lvsubdecks_itemlongclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lvsubdecks_itemlongclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=24838144;
 //BA.debugLineNum = 24838144;BA.debugLine="Private Sub LVSubdecks_ItemLongClick (Position As";
RDebugUtils.currentLine=24838145;
 //BA.debugLineNum = 24838145;BA.debugLine="alterpanel.Visible = True";
mostCurrent._alterpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24838146;
 //BA.debugLineNum = 24838146;BA.debugLine="selectedsubdeck = Value";
_selectedsubdeck = BA.ObjectToString(_value);
RDebugUtils.currentLine=24838147;
 //BA.debugLineNum = 24838147;BA.debugLine="End Sub";
return "";
}
public static String  _renamesubdeck_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "renamesubdeck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "renamesubdeck_click", null));}
RDebugUtils.currentLine=24707072;
 //BA.debugLineNum = 24707072;BA.debugLine="Private Sub renamesubdeck_Click";
RDebugUtils.currentLine=24707073;
 //BA.debugLineNum = 24707073;BA.debugLine="alterpanel.Visible = False";
mostCurrent._alterpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=24707074;
 //BA.debugLineNum = 24707074;BA.debugLine="renamepanel.visible = True";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=24707075;
 //BA.debugLineNum = 24707075;BA.debugLine="End Sub";
return "";
}
public static String  _startarbtn_click() throws Exception{
RDebugUtils.currentModule="subdeck_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "startarbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "startarbtn_click", null));}
RDebugUtils.currentLine=24379392;
 //BA.debugLineNum = 24379392;BA.debugLine="Private Sub startArbtn_Click";
RDebugUtils.currentLine=24379394;
 //BA.debugLineNum = 24379394;BA.debugLine="If number_of_cards = 0 Then";
if (_number_of_cards==0) { 
RDebugUtils.currentLine=24379395;
 //BA.debugLineNum = 24379395;BA.debugLine="MsgboxAsync(\"No cards available\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("No cards available"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=24379396;
 //BA.debugLineNum = 24379396;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=24379398;
 //BA.debugLineNum = 24379398;BA.debugLine="StartActivity(all_active_recall)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._all_active_recall.getObject()));
RDebugUtils.currentLine=24379399;
 //BA.debugLineNum = 24379399;BA.debugLine="End Sub";
return "";
}
}