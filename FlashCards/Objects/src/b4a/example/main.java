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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (subdeck_module.mostCurrent != null);
vis = vis | (card_module.mostCurrent != null);
vis = vis | (all_active_recall.mostCurrent != null);
vis = vis | (add_card_module2.mostCurrent != null);
vis = vis | (deck_all_cards.mostCurrent != null);
vis = vis | (add_card_module.mostCurrent != null);
vis = vis | (active_recall.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (subdeck_module.previousOne != null) {
				__a = subdeck_module.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(subdeck_module.mostCurrent == null ? null : subdeck_module.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (card_module.previousOne != null) {
				__a = card_module.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(card_module.mostCurrent == null ? null : card_module.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (all_active_recall.previousOne != null) {
				__a = all_active_recall.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(all_active_recall.mostCurrent == null ? null : all_active_recall.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (add_card_module2.previousOne != null) {
				__a = add_card_module2.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(add_card_module2.mostCurrent == null ? null : add_card_module2.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (deck_all_cards.previousOne != null) {
				__a = deck_all_cards.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(deck_all_cards.mostCurrent == null ? null : deck_all_cards.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (add_card_module.previousOne != null) {
				__a = add_card_module.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(add_card_module.mostCurrent == null ? null : add_card_module.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (active_recall.previousOne != null) {
				__a = active_recall.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(active_recall.mostCurrent == null ? null : active_recall.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.collections.Map _deck = null;
public static String _selecteddeck = "";
public static String _item_longclick = "";
public static b4a.example.keyvaluestore _kvs = null;
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
public b4a.example.starter _starter = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.card_module _card_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.active_recall _active_recall = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _radius = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Dim radius As Int = Addbtn.Width/2";
_radius = (int) (mostCurrent._addbtn.getWidth()/(double)2);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="cd.Initialize(Colors.Gray, radius)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Gray,_radius);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="Addbtn.Background = cd";
mostCurrent._addbtn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="LVdecks.SingleLineLayout.Label.textcolor = Colors";
mostCurrent._lvdecks.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="kvs.Initialize(File.DirInternal, \"mydata\")";
_kvs._initialize /*String*/ (null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"mydata");
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="If  kvs.ContainsKey(\"deck_data\") Then";
if (_kvs._containskey /*boolean*/ (null,"deck_data")) { 
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="deck = kvs.Get(\"deck_data\")";
_deck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_kvs._get /*Object*/ (null,"deck_data")));
 }else {
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="deck.Initialize";
_deck.Initialize();
 };
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="refreshbtn_Click";
_refreshbtn_click();
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="End Sub";
return "";
}
public static String  _refreshbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "refreshbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "refreshbtn_click", null));}
String _deckname = "";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub refreshbtn_Click";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="LVdecks.clear";
mostCurrent._lvdecks.Clear();
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="For Each deckName As String In deck.keys";
{
final anywheresoftware.b4a.BA.IterableList group2 = _deck.Keys();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_deckname = BA.ObjectToString(group2.Get(index2));
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="LVdecks.AddSingleLine(deckName)";
mostCurrent._lvdecks.AddSingleLine(BA.ObjectToCharSequence(_deckname));
 }
};
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addbtn_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub Addbtn_Click";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="If addpanel.Visible = True Then";
if (mostCurrent._addpanel.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="addpanel.Visible = True";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="End Sub";
return "";
}
public static String  _addcards_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcards_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcards_click", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub addcards_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim tappeddeck As Map = deck.Get(item_longclick)";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deck.Get((Object)(_item_longclick))));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If tappeddeck.Size = 0 Then";
if (_tappeddeck.getSize()==0) { 
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="MsgboxAsync(\"Create A Sub-Deck first\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Create A Sub-Deck first"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="StartActivity(Add_Card_Module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._add_card_module.getObject()));
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="End Sub";
return "";
}
public static String  _browse_cards_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "browse_cards_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "browse_cards_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub browse_cards_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="StartActivity(DECK_ALL_CARDS)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._deck_all_cards.getObject()));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="End Sub";
return "";
}
public static String  _cancel_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancel_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub cancel_Click";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="et1.Text = \"\"";
mostCurrent._et1.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="End Sub";
return "";
}
public static String  _cancelbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancelbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancelbtn_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub cancelbtn_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _canceldelete_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canceldelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canceldelete_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub canceldelete_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _cancelnew_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancelnew_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancelnew_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub cancelnew_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="newdeckname.text = False";
mostCurrent._newdeckname.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="End Sub";
return "";
}
public static String  _cancelnewsubdeck_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancelnewsubdeck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancelnewsubdeck_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub cancelnewsubdeck_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="newsubdecket.Text = \"\"";
mostCurrent._newsubdecket.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="newsubdeckpanel.Visible = False";
mostCurrent._newsubdeckpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="End Sub";
return "";
}
public static String  _confirmdelete_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "confirmdelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "confirmdelete_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub confirmdelete_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="deck.Remove(item_longclick)";
_deck.Remove((Object)(_item_longclick));
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="deleteconfirmation.Visible = false";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="refreshbtn_Click";
_refreshbtn_click();
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="End Sub";
return "";
}
public static String  _confirmnew_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "confirmnew_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "confirmnew_click", null));}
anywheresoftware.b4a.objects.collections.Map _getsubdeck = null;
String _names = "";
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub confirmnew_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim getsubdeck As Map";
_getsubdeck = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="If newdeckname.Text = \"\" Then";
if ((mostCurrent._newdeckname.getText()).equals("")) { 
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="MsgboxAsync(\"New Name must have a name\", \"Error\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("New Name must have a name"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="For Each names As String In deck.keys";
{
final anywheresoftware.b4a.BA.IterableList group6 = _deck.Keys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_names = BA.ObjectToString(group6.Get(index6));
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="getsubdeck = deck.Get(item_longclick)";
_getsubdeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deck.Get((Object)(_item_longclick))));
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="If newdeckname.Text = names Then";
if ((mostCurrent._newdeckname.getText()).equals(_names)) { 
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="MsgboxAsync(\"Deck Name Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Deck Name Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="deck.Remove(item_longclick)";
_deck.Remove((Object)(_item_longclick));
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="deck.Put(newdeckname.Text, getsubdeck)";
_deck.Put((Object)(mostCurrent._newdeckname.getText()),(Object)(_getsubdeck.getObject()));
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="newdeckname.text = \"\"";
mostCurrent._newdeckname.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="SaveDecks";
_savedecks();
RDebugUtils.currentLine=1179665;
 //BA.debugLineNum = 1179665;BA.debugLine="refreshbtn_Click";
_refreshbtn_click();
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="renamepanel.Visible = False";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179667;
 //BA.debugLineNum = 1179667;BA.debugLine="End Sub";
return "";
}
public static String  _savedecks() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savedecks", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "savedecks", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub SaveDecks";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="kvs.Put(\"deck_data\", deck)";
_kvs._put /*String*/ (null,"deck_data",(Object)(_deck.getObject()));
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _create_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "create_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "create_click", null));}
anywheresoftware.b4a.objects.collections.Map _newsubdeck = null;
String _names = "";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub create_Click";
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Dim newsubdeck As Map";
_newsubdeck = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="newsubdeck.initialize";
_newsubdeck.Initialize();
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="For Each names As String In deck.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _deck.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_names = BA.ObjectToString(group3.Get(index3));
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="If et1.Text = names Then";
if ((mostCurrent._et1.getText()).equals(_names)) { 
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="MsgboxAsync(\"Deck Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Deck Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="If et1.Text = \"\" Then";
if ((mostCurrent._et1.getText()).equals("")) { 
RDebugUtils.currentLine=524305;
 //BA.debugLineNum = 524305;BA.debugLine="MsgboxAsync(\"Deck must have a name\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Deck must have a name"),BA.ObjectToCharSequence("Error"),processBA);
 }else {
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="addpanel.Visible = False";
mostCurrent._addpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524309;
 //BA.debugLineNum = 524309;BA.debugLine="LVdecks.AddSingleLine(et1.Text)";
mostCurrent._lvdecks.AddSingleLine(BA.ObjectToCharSequence(mostCurrent._et1.getText()));
RDebugUtils.currentLine=524312;
 //BA.debugLineNum = 524312;BA.debugLine="deck.Put(et1.Text, newsubdeck)";
_deck.Put((Object)(mostCurrent._et1.getText()),(Object)(_newsubdeck.getObject()));
RDebugUtils.currentLine=524313;
 //BA.debugLineNum = 524313;BA.debugLine="SaveDecks";
_savedecks();
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="et1.Text = \"\"";
mostCurrent._et1.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="End Sub";
return "";
}
public static String  _create_subdeck_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "create_subdeck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "create_subdeck_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub create_subdeck_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="newsubdeckpanel.Visible = True";
mostCurrent._newsubdeckpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _createnewsubdeck_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createnewsubdeck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createnewsubdeck_click", null));}
anywheresoftware.b4a.objects.collections.Map _createdeck = null;
anywheresoftware.b4a.objects.collections.List _flashcard = null;
String _subdeck = "";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub createnewsubdeck_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="If newsubdecket.Text = \"\" Then";
if ((mostCurrent._newsubdecket.getText()).equals("")) { 
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="MsgboxAsync(\"New Sub Deck must have a name\", \"Er";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("New Sub Deck must have a name"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Dim createdeck As Map = deck.Get(item_longclick)";
_createdeck = new anywheresoftware.b4a.objects.collections.Map();
_createdeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deck.Get((Object)(_item_longclick))));
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="Dim flashcard As List";
_flashcard = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="flashcard.Initialize";
_flashcard.Initialize();
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="For Each subdeck As String In createdeck.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _createdeck.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_subdeck = BA.ObjectToString(group8.Get(index8));
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="If newsubdecket.Text = subdeck Then";
if ((mostCurrent._newsubdecket.getText()).equals(_subdeck)) { 
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="MsgboxAsync(\"Subdeck Already Exist\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Subdeck Already Exist"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="createdeck.Put(newsubdecket.Text, flashcard)";
_createdeck.Put((Object)(mostCurrent._newsubdecket.getText()),(Object)(_flashcard.getObject()));
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="SaveDecks";
_savedecks();
RDebugUtils.currentLine=1310736;
 //BA.debugLineNum = 1310736;BA.debugLine="newsubdecket.Text = \"\"";
mostCurrent._newsubdecket.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1310737;
 //BA.debugLineNum = 1310737;BA.debugLine="newsubdeckpanel.Visible = False";
mostCurrent._newsubdeckpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310738;
 //BA.debugLineNum = 1310738;BA.debugLine="StartActivity(Subdeck_Module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._subdeck_module.getObject()));
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="End Sub";
return "";
}
public static String  _delete_deck_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "delete_deck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "delete_deck_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub delete_deck_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="deleteconfirmation.Visible = True";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="End Sub";
return "";
}
public static String  _lvdecks_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lvdecks_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lvdecks_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub LVdecks_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="selecteddeck = Value";
_selecteddeck = BA.ObjectToString(_value);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="StartActivity(Subdeck_Module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._subdeck_module.getObject()));
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="End Sub";
return "";
}
public static String  _lvdecks_itemlongclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lvdecks_itemlongclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lvdecks_itemlongclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub LVdecks_ItemLongClick (Position As Int";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="decksettingpanel.Visible = True";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="item_longclick = Value";
_item_longclick = BA.ObjectToString(_value);
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="selecteddeck = Value";
_selecteddeck = BA.ObjectToString(_value);
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return "";
}
public static String  _rename_deck_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "rename_deck_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "rename_deck_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub rename_deck_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="decksettingpanel.Visible = False";
mostCurrent._decksettingpanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="renamepanel.Visible = True";
mostCurrent._renamepanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="End Sub";
return "";
}
}