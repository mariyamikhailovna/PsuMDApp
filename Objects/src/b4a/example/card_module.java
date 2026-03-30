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

public class card_module extends Activity implements B4AActivity{
	public static card_module mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.card_module");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (card_module).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.card_module");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.card_module", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (card_module) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (card_module) Resume **");
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
		return card_module.class;
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
            BA.LogInfo("** Activity (card_module) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (card_module) Pause event (activity is not paused). **");
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
            card_module mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (card_module) Resume **");
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
public static String _subdeck = "";
public static boolean _isedit = false;
public static int _editindex = 0;
public anywheresoftware.b4a.objects.LabelWrapper _subdecklabel = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _deleteconfirmation = null;
public static int _numtag = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.todoactivity _todoactivity = null;
public static String  _activerecall_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activerecall_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activerecall_click", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
anywheresoftware.b4a.objects.collections.List _subdeckcards = null;
int _number_of_cards = 0;
RDebugUtils.currentLine=17170432;
 //BA.debugLineNum = 17170432;BA.debugLine="Private Sub activerecall_Click";
RDebugUtils.currentLine=17170434;
 //BA.debugLineNum = 17170434;BA.debugLine="Dim tappedDeck As Map = FlashcardActivity.deck.Ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=17170435;
 //BA.debugLineNum = 17170435;BA.debugLine="Dim subdeckcards As List = tappedDeck.Get(Subdeck";
_subdeckcards = new anywheresoftware.b4a.objects.collections.List();
_subdeckcards = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_tappeddeck.Get((Object)(mostCurrent._subdeck_module._selectedsubdeck /*String*/ ))));
RDebugUtils.currentLine=17170436;
 //BA.debugLineNum = 17170436;BA.debugLine="Dim number_of_cards As Int = subdeckcards.size";
_number_of_cards = _subdeckcards.getSize();
RDebugUtils.currentLine=17170438;
 //BA.debugLineNum = 17170438;BA.debugLine="If number_of_cards = 0 Then";
if (_number_of_cards==0) { 
RDebugUtils.currentLine=17170439;
 //BA.debugLineNum = 17170439;BA.debugLine="MsgboxAsync(\"No cards available\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("No cards available"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=17170440;
 //BA.debugLineNum = 17170440;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=17170442;
 //BA.debugLineNum = 17170442;BA.debugLine="StartActivity(active_recall)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._active_recall.getObject()));
RDebugUtils.currentLine=17170443;
 //BA.debugLineNum = 17170443;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
anywheresoftware.b4a.objects.collections.List _subdeckcards = null;
RDebugUtils.currentLine=16711680;
 //BA.debugLineNum = 16711680;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=16711683;
 //BA.debugLineNum = 16711683;BA.debugLine="Activity.LoadLayout(\"Card_MOduleLayout\")";
mostCurrent._activity.LoadLayout("Card_MOduleLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=16711685;
 //BA.debugLineNum = 16711685;BA.debugLine="subdecklabel.Text = Subdeck_Module.selectedsubdec";
mostCurrent._subdecklabel.setText(BA.ObjectToCharSequence(mostCurrent._subdeck_module._selectedsubdeck /*String*/ ));
RDebugUtils.currentLine=16711687;
 //BA.debugLineNum = 16711687;BA.debugLine="Dim tappedDeck As Map = FlashcardActivity.deck.Ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=16711688;
 //BA.debugLineNum = 16711688;BA.debugLine="Dim subdeckcards As List = tappedDeck.Get(Subdeck";
_subdeckcards = new anywheresoftware.b4a.objects.collections.List();
_subdeckcards = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_tappeddeck.Get((Object)(mostCurrent._subdeck_module._selectedsubdeck /*String*/ ))));
RDebugUtils.currentLine=16711691;
 //BA.debugLineNum = 16711691;BA.debugLine="ShowSubdeckCards(subdeckcards)";
_showsubdeckcards(_subdeckcards);
RDebugUtils.currentLine=16711693;
 //BA.debugLineNum = 16711693;BA.debugLine="End Sub";
return "";
}
public static String  _showsubdeckcards(anywheresoftware.b4a.objects.collections.List _cardslist) throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showsubdeckcards", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showsubdeckcards", new Object[] {_cardslist}));}
int _toppos = 0;
int _cardheight = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _card = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _btnwidth = 0;
anywheresoftware.b4a.objects.ButtonWrapper _editbtn = null;
anywheresoftware.b4a.objects.ButtonWrapper _deletebtn = null;
RDebugUtils.currentLine=16777216;
 //BA.debugLineNum = 16777216;BA.debugLine="Sub ShowSubdeckCards(cardsList As List)";
RDebugUtils.currentLine=16777218;
 //BA.debugLineNum = 16777218;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
mostCurrent._scrollview1.getPanel().RemoveAllViews();
RDebugUtils.currentLine=16777220;
 //BA.debugLineNum = 16777220;BA.debugLine="Dim topPos As Int = 0";
_toppos = (int) (0);
RDebugUtils.currentLine=16777221;
 //BA.debugLineNum = 16777221;BA.debugLine="Dim cardHeight As Int = 150dip 'height";
_cardheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150));
RDebugUtils.currentLine=16777223;
 //BA.debugLineNum = 16777223;BA.debugLine="For i = 0 To cardsList.Size -1";
{
final int step4 = 1;
final int limit4 = (int) (_cardslist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=16777224;
 //BA.debugLineNum = 16777224;BA.debugLine="Dim card As Map = cardsList.Get(i)";
_card = new anywheresoftware.b4a.objects.collections.Map();
_card = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_cardslist.Get(_i)));
RDebugUtils.currentLine=16777225;
 //BA.debugLineNum = 16777225;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=16777226;
 //BA.debugLineNum = 16777226;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=16777227;
 //BA.debugLineNum = 16777227;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=16777228;
 //BA.debugLineNum = 16777228;BA.debugLine="ScrollView1.Panel.AddView(p, 10dip, topPos, Scro";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_toppos,(int) (mostCurrent._scrollview1.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_cardheight);
RDebugUtils.currentLine=16777230;
 //BA.debugLineNum = 16777230;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=16777231;
 //BA.debugLineNum = 16777231;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=16777232;
 //BA.debugLineNum = 16777232;BA.debugLine="lbl.Text = \"Q: \" & card.Get(\"Q\") & CRLF & \"A: \"";
_lbl.setText(BA.ObjectToCharSequence("Q: "+BA.ObjectToString(_card.Get((Object)("Q")))+anywheresoftware.b4a.keywords.Common.CRLF+"A: "+BA.ObjectToString(_card.Get((Object)("A")))));
RDebugUtils.currentLine=16777233;
 //BA.debugLineNum = 16777233;BA.debugLine="lbl.TextColor = Colors.black";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=16777234;
 //BA.debugLineNum = 16777234;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
RDebugUtils.currentLine=16777235;
 //BA.debugLineNum = 16777235;BA.debugLine="lbl.SingleLine = False";
_lbl.setSingleLine(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=16777237;
 //BA.debugLineNum = 16777237;BA.debugLine="p.AddView(lbl, 10dip, 10dip, ScrollView1.Width -";
_p.AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (mostCurrent._scrollview1.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=16777238;
 //BA.debugLineNum = 16777238;BA.debugLine="topPos = topPos + lbl.height + 10dip";
_toppos = (int) (_toppos+_lbl.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
RDebugUtils.currentLine=16777240;
 //BA.debugLineNum = 16777240;BA.debugLine="Dim btnwidth As Int = 100dip";
_btnwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=16777242;
 //BA.debugLineNum = 16777242;BA.debugLine="Dim editbtn As Button";
_editbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=16777243;
 //BA.debugLineNum = 16777243;BA.debugLine="editbtn.Initialize(\"Editbtn\") 'btn name";
_editbtn.Initialize(mostCurrent.activityBA,"Editbtn");
RDebugUtils.currentLine=16777244;
 //BA.debugLineNum = 16777244;BA.debugLine="editbtn.Tag = i 'tag/index";
_editbtn.setTag((Object)(_i));
RDebugUtils.currentLine=16777245;
 //BA.debugLineNum = 16777245;BA.debugLine="editbtn.Text = \"Edit\" 'button text display";
_editbtn.setText(BA.ObjectToCharSequence("Edit"));
RDebugUtils.currentLine=16777246;
 //BA.debugLineNum = 16777246;BA.debugLine="p.AddView(editbtn, 10dip, 115dip, btnwidth, 40di";
_p.AddView((android.view.View)(_editbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (115)),_btnwidth,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=16777248;
 //BA.debugLineNum = 16777248;BA.debugLine="Dim deletebtn As Button";
_deletebtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=16777249;
 //BA.debugLineNum = 16777249;BA.debugLine="deletebtn.Initialize(\"Deletebtn\")";
_deletebtn.Initialize(mostCurrent.activityBA,"Deletebtn");
RDebugUtils.currentLine=16777250;
 //BA.debugLineNum = 16777250;BA.debugLine="deletebtn.Tag = i";
_deletebtn.setTag((Object)(_i));
RDebugUtils.currentLine=16777251;
 //BA.debugLineNum = 16777251;BA.debugLine="deletebtn.Text = \"Delete\"";
_deletebtn.setText(BA.ObjectToCharSequence("Delete"));
RDebugUtils.currentLine=16777252;
 //BA.debugLineNum = 16777252;BA.debugLine="p.AddView(deletebtn, 200dip, 115dip, btnwidth, 4";
_p.AddView((android.view.View)(_deletebtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (115)),_btnwidth,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=16777253;
 //BA.debugLineNum = 16777253;BA.debugLine="topPos = topPos + cardHeight + 10dip";
_toppos = (int) (_toppos+_cardheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 }
};
RDebugUtils.currentLine=16777255;
 //BA.debugLineNum = 16777255;BA.debugLine="ScrollView1.Panel.Height = topPos + 10dip";
mostCurrent._scrollview1.getPanel().setHeight((int) (_toppos+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=16777256;
 //BA.debugLineNum = 16777256;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="card_module";
RDebugUtils.currentLine=17039360;
 //BA.debugLineNum = 17039360;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=17039362;
 //BA.debugLineNum = 17039362;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
anywheresoftware.b4a.objects.collections.List _subdeckcards = null;
RDebugUtils.currentLine=16973824;
 //BA.debugLineNum = 16973824;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=16973826;
 //BA.debugLineNum = 16973826;BA.debugLine="If active_recall.praise = True Then";
if (mostCurrent._active_recall._praise /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=16973827;
 //BA.debugLineNum = 16973827;BA.debugLine="active_recall.praise = False";
mostCurrent._active_recall._praise /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=16973828;
 //BA.debugLineNum = 16973828;BA.debugLine="MsgboxAsync(\"You Finished Your Sub-Deck\", \"Congr";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("You Finished Your Sub-Deck"),BA.ObjectToCharSequence("Congratulations"),processBA);
 };
RDebugUtils.currentLine=16973831;
 //BA.debugLineNum = 16973831;BA.debugLine="Dim tappedDeck As Map = FlashcardActivity.deck.Ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=16973832;
 //BA.debugLineNum = 16973832;BA.debugLine="Dim subdeckcards As List = tappedDeck.Get(Subdeck";
_subdeckcards = new anywheresoftware.b4a.objects.collections.List();
_subdeckcards = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_tappeddeck.Get((Object)(mostCurrent._subdeck_module._selectedsubdeck /*String*/ ))));
RDebugUtils.currentLine=16973833;
 //BA.debugLineNum = 16973833;BA.debugLine="ShowSubdeckCards(subdeckcards)";
_showsubdeckcards(_subdeckcards);
RDebugUtils.currentLine=16973834;
 //BA.debugLineNum = 16973834;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addbtn_click", null));}
RDebugUtils.currentLine=17235968;
 //BA.debugLineNum = 17235968;BA.debugLine="Private Sub addbtn_Click";
RDebugUtils.currentLine=17235970;
 //BA.debugLineNum = 17235970;BA.debugLine="subdeck = Subdeck_Module.selectedsubdeck";
_subdeck = mostCurrent._subdeck_module._selectedsubdeck /*String*/ ;
RDebugUtils.currentLine=17235971;
 //BA.debugLineNum = 17235971;BA.debugLine="StartActivity(add_card_module2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._add_card_module2.getObject()));
RDebugUtils.currentLine=17235972;
 //BA.debugLineNum = 17235972;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=17104896;
 //BA.debugLineNum = 17104896;BA.debugLine="Private Sub backbtn_Click";
RDebugUtils.currentLine=17104898;
 //BA.debugLineNum = 17104898;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=17104899;
 //BA.debugLineNum = 17104899;BA.debugLine="End Sub";
return "";
}
public static String  _canceldelete_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canceldelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canceldelete_click", null));}
RDebugUtils.currentLine=17367040;
 //BA.debugLineNum = 17367040;BA.debugLine="Private Sub canceldelete_Click";
RDebugUtils.currentLine=17367041;
 //BA.debugLineNum = 17367041;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17367042;
 //BA.debugLineNum = 17367042;BA.debugLine="End Sub";
return "";
}
public static String  _confirmdelete_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "confirmdelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "confirmdelete_click", null));}
anywheresoftware.b4a.objects.collections.Map _tappeddeck = null;
anywheresoftware.b4a.objects.collections.List _cards = null;
RDebugUtils.currentLine=17301504;
 //BA.debugLineNum = 17301504;BA.debugLine="Private Sub confirmdelete_Click";
RDebugUtils.currentLine=17301505;
 //BA.debugLineNum = 17301505;BA.debugLine="Dim tappedDeck As Map = FlashcardActivity.deck.Ge";
_tappeddeck = new anywheresoftware.b4a.objects.collections.Map();
_tappeddeck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._flashcardactivity._deck /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._flashcardactivity._selecteddeck /*String*/ ))));
RDebugUtils.currentLine=17301506;
 //BA.debugLineNum = 17301506;BA.debugLine="Dim cards As List = tappedDeck.Get(Subdeck_Module";
_cards = new anywheresoftware.b4a.objects.collections.List();
_cards = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_tappeddeck.Get((Object)(mostCurrent._subdeck_module._selectedsubdeck /*String*/ ))));
RDebugUtils.currentLine=17301508;
 //BA.debugLineNum = 17301508;BA.debugLine="cards.RemoveAt(numtag)";
_cards.RemoveAt(_numtag);
RDebugUtils.currentLine=17301509;
 //BA.debugLineNum = 17301509;BA.debugLine="ShowSubdeckCards(cards)";
_showsubdeckcards(_cards);
RDebugUtils.currentLine=17301510;
 //BA.debugLineNum = 17301510;BA.debugLine="deleteconfirmation.Visible = False";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=17301511;
 //BA.debugLineNum = 17301511;BA.debugLine="End Sub";
return "";
}
public static String  _deletebtn_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "deletebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "deletebtn_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
int _index = 0;
RDebugUtils.currentLine=16908288;
 //BA.debugLineNum = 16908288;BA.debugLine="Sub deletebtn_click";
RDebugUtils.currentLine=16908290;
 //BA.debugLineNum = 16908290;BA.debugLine="Dim b As Button = Sender";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
_b = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=16908291;
 //BA.debugLineNum = 16908291;BA.debugLine="Dim index As Int = b.Tag";
_index = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=16908292;
 //BA.debugLineNum = 16908292;BA.debugLine="numtag = index";
_numtag = _index;
RDebugUtils.currentLine=16908293;
 //BA.debugLineNum = 16908293;BA.debugLine="deleteconfirmation.Visible = True";
mostCurrent._deleteconfirmation.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=16908295;
 //BA.debugLineNum = 16908295;BA.debugLine="End Sub";
return "";
}
public static String  _editbtn_click() throws Exception{
RDebugUtils.currentModule="card_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "editbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "editbtn_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
int _index = 0;
RDebugUtils.currentLine=16842752;
 //BA.debugLineNum = 16842752;BA.debugLine="Sub editbtn_Click";
RDebugUtils.currentLine=16842754;
 //BA.debugLineNum = 16842754;BA.debugLine="subdeck = Subdeck_Module.selectedsubdeck";
_subdeck = mostCurrent._subdeck_module._selectedsubdeck /*String*/ ;
RDebugUtils.currentLine=16842755;
 //BA.debugLineNum = 16842755;BA.debugLine="Dim b As Button = Sender";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
_b = (anywheresoftware.b4a.objects.ButtonWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ButtonWrapper(), (android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=16842756;
 //BA.debugLineNum = 16842756;BA.debugLine="Dim index As Int = b.Tag";
_index = (int)(BA.ObjectToNumber(_b.getTag()));
RDebugUtils.currentLine=16842757;
 //BA.debugLineNum = 16842757;BA.debugLine="editindex = index";
_editindex = _index;
RDebugUtils.currentLine=16842758;
 //BA.debugLineNum = 16842758;BA.debugLine="isEdit = True";
_isedit = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=16842760;
 //BA.debugLineNum = 16842760;BA.debugLine="StartActivity(add_card_module2)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._add_card_module2.getObject()));
RDebugUtils.currentLine=16842762;
 //BA.debugLineNum = 16842762;BA.debugLine="End Sub";
return "";
}
}