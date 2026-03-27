package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class mainactivity_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.mainactivity parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.mainactivity parent;
RemoteObject _firsttime;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,29);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"Layouthsv\")";
Debug.ShouldStop(1073741824);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layouthsv")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1);
if (true) break;

case 1:
//if
this.state = 4;
if (_firsttime.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 34;BA.debugLine="kvs.Initialize(File.DirInternal, \"notes_data\")";
Debug.ShouldStop(2);
parent._kvs.runVoidMethod ("_initialize",mainactivity.processBA,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("notes_data")));
 BA.debugLineNum = 35;BA.debugLine="timerClock.Initialize(\"timerClock\", 1000)";
Debug.ShouldStop(4);
parent._timerclock.runVoidMethod ("Initialize",mainactivity.processBA,(Object)(BA.ObjectToString("timerClock")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 36;BA.debugLine="timerClock.Enabled = True";
Debug.ShouldStop(8);
parent._timerclock.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 39;BA.debugLine="hsv.Panel.Width = size";
Debug.ShouldStop(64);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"setWidth",parent._size);
 BA.debugLineNum = 40;BA.debugLine="hsv.Panel.Height = size";
Debug.ShouldStop(128);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"setHeight",parent._size);
 BA.debugLineNum = 42;BA.debugLine="regLayout = xui.CreatePanel(\"\")";
Debug.ShouldStop(512);
parent.mostCurrent._reglayout = parent._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 43;BA.debugLine="darkModeLayout = xui.CreatePanel(\"\")";
Debug.ShouldStop(1024);
parent.mostCurrent._darkmodelayout = parent._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 45;BA.debugLine="hsv.Panel.AddView(regLayout, 0, 0, hsv.Panel.Widt";
Debug.ShouldStop(4096);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((parent.mostCurrent._reglayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getWidth")),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getHeight")));
 BA.debugLineNum = 46;BA.debugLine="hsv.Panel.AddView(darkModeLayout, 0, 0, hsv.Panel";
Debug.ShouldStop(8192);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((parent.mostCurrent._darkmodelayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getWidth")),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getHeight")));
 BA.debugLineNum = 48;BA.debugLine="regLayout.BringToFront";
Debug.ShouldStop(32768);
parent.mostCurrent._reglayout.runVoidMethod ("BringToFront");
 BA.debugLineNum = 50;BA.debugLine="Select Starter.themeNumber";
Debug.ShouldStop(131072);
if (true) break;

case 5:
//select
this.state = 10;
switch (BA.switchObjectToInt(parent.mostCurrent._starter._themenumber /*RemoteObject*/ ,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1))) {
case 0: {
this.state = 7;
if (true) break;
}
case 1: {
this.state = 9;
if (true) break;
}
}
if (true) break;

case 7:
//C
this.state = 10;
 BA.debugLineNum = 52;BA.debugLine="regLayout.LoadLayout(\"Layout\") 'light mode for";
Debug.ShouldStop(524288);
parent.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 53;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\") 'dark mode";
Debug.ShouldStop(1048576);
parent.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout2")),mainactivity.mostCurrent.activityBA);
 if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 55;BA.debugLine="regLayout.LoadLayout(\"Layout\") 'light mode for";
Debug.ShouldStop(4194304);
parent.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 56;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\") 'dark mode";
Debug.ShouldStop(8388608);
parent.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout2")),mainactivity.mostCurrent.activityBA);
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 59;BA.debugLine="computerGif.SetGif(File.DirAssets, \"BtnComputer.G";
Debug.ShouldStop(67108864);
parent.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("BtnComputer.GIF")));
 BA.debugLineNum = 60;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"Dark BtnComp";
Debug.ShouldStop(134217728);
parent.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Dark BtnComputer.GIF")));
 BA.debugLineNum = 61;BA.debugLine="darkModeLayout.Visible = False";
Debug.ShouldStop(268435456);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 63;BA.debugLine="Sleep(50)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "activity_create"),BA.numberCast(int.class, 50));
this.state = 11;
return;
case 11:
//C
this.state = -1;
;
 BA.debugLineNum = 64;BA.debugLine="hsv.ScrollPosition = Max(0, (hsv.Panel.Width - 10";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._hsv.runMethod(true,"setScrollPosition",BA.numberCast(int.class, parent.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getWidth"),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA)}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)))));
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,76);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 76;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,68);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_resume");}
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="If format24h Then";
Debug.ShouldStop(16);
if (mainactivity._format24h.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 70;BA.debugLine="DateTime.TimeFormat = \"HH:mm\" ' 24-Hour Format";
Debug.ShouldStop(32);
mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 }else {
 BA.debugLineNum = 72;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\" ' AM/PM Format";
Debug.ShouldStop(128);
mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh:mm a"));
 };
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bookie_click() throws Exception{
try {
		Debug.PushSubsStack("bookie_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,216);
if (RapidSub.canDelegate("bookie_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","bookie_click");}
 BA.debugLineNum = 216;BA.debugLine="Private Sub bookie_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="StartActivity(FlashcardActivity)";
Debug.ShouldStop(16777216);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._flashcardactivity.getObject())));
 BA.debugLineNum = 218;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calendar_click() throws Exception{
try {
		Debug.PushSubsStack("calendar_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,220);
if (RapidSub.canDelegate("calendar_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","calendar_click");}
 BA.debugLineNum = 220;BA.debugLine="Private Sub calendar_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 221;BA.debugLine="StartActivity(CalendarActivity)";
Debug.ShouldStop(268435456);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._calendaractivity.getObject())));
 BA.debugLineNum = 222;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clockbtn_click() throws Exception{
try {
		Debug.PushSubsStack("clockBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,107);
if (RapidSub.canDelegate("clockbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clockbtn_click");}
 BA.debugLineNum = 107;BA.debugLine="Private Sub clockBtn_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="StartActivity(clockActivity)";
Debug.ShouldStop(2048);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._clockactivity.getObject())));
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clockbtn_longclick() throws Exception{
try {
		Debug.PushSubsStack("clockBtn_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,115);
if (RapidSub.canDelegate("clockbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clockbtn_longclick");}
 BA.debugLineNum = 115;BA.debugLine="Private Sub clockBtn_LongClick";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="showInfoPopup";
Debug.ShouldStop(1048576);
_showinfopopup();
 BA.debugLineNum = 118;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 119;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(4194304);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 120;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(8388608);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 121;BA.debugLine="showInfoPage(1)";
Debug.ShouldStop(16777216);
_showinfopage(BA.numberCast(int.class, 1));
 BA.debugLineNum = 122;BA.debugLine="Return";
Debug.ShouldStop(33554432);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clocklightbtn_click() throws Exception{
try {
		Debug.PushSubsStack("clockLightBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,111);
if (RapidSub.canDelegate("clocklightbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clocklightbtn_click");}
 BA.debugLineNum = 111;BA.debugLine="Private Sub  clockLightBtn_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="StartActivity(clockActivity)";
Debug.ShouldStop(32768);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._clockactivity.getObject())));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clocklightbtn_longclick() throws Exception{
try {
		Debug.PushSubsStack("clockLightBtn_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,125);
if (RapidSub.canDelegate("clocklightbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clocklightbtn_longclick");}
 BA.debugLineNum = 125;BA.debugLine="Private Sub clockLightBtn_LongClick";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 127;BA.debugLine="showInfoPopup";
Debug.ShouldStop(1073741824);
_showinfopopup();
 BA.debugLineNum = 128;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 129;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(1);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 130;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(2);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 131;BA.debugLine="showInfoPage(1)";
Debug.ShouldStop(4);
_showinfopage(BA.numberCast(int.class, 1));
 BA.debugLineNum = 132;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _dlamp_click() throws Exception{
try {
		Debug.PushSubsStack("dlamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,91);
if (RapidSub.canDelegate("dlamp_click")) { b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","dlamp_click"); return;}
ResumableSub_dlamp_Click rsub = new ResumableSub_dlamp_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_dlamp_Click extends BA.ResumableSub {
public ResumableSub_dlamp_Click(b4a.example.mainactivity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("dlamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,91);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 92;BA.debugLine="Starter.darkMode = False";
Debug.ShouldStop(134217728);
parent.mostCurrent._starter._darkmode /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 93;BA.debugLine="regLayout.Visible = True";
Debug.ShouldStop(268435456);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 94;BA.debugLine="regLayout.BringToFront";
Debug.ShouldStop(536870912);
parent.mostCurrent._reglayout.runVoidMethod ("BringToFront");
 BA.debugLineNum = 95;BA.debugLine="regLayout.Alpha = 0";
Debug.ShouldStop(1073741824);
parent.mostCurrent._reglayout.runMethod(true,"setAlpha",BA.numberCast(float.class, 0));
 BA.debugLineNum = 96;BA.debugLine="regLayout.SetAlphaAnimated(250, 1)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._reglayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 97;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 0)";
Debug.ShouldStop(1);
parent.mostCurrent._darkmodelayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 98;BA.debugLine="Sleep(250)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "dlamp_click"),BA.numberCast(int.class, 250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 99;BA.debugLine="darkModeLayout.Visible = False";
Debug.ShouldStop(4);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim regLayout, darkModeLayout As B4XView";
mainactivity.mostCurrent._reglayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
mainactivity.mostCurrent._darkmodelayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim size As Int = 100%y";
mainactivity._size = mainactivity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA);
 //BA.debugLineNum = 16;BA.debugLine="Private hsv As HorizontalScrollView";
mainactivity.mostCurrent._hsv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private computerGif As B4XGifView";
mainactivity.mostCurrent._computergif = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 18;BA.debugLine="Private dcomputerGif As B4XGifView";
mainactivity.mostCurrent._dcomputergif = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 19;BA.debugLine="Private clockBtn As Button";
mainactivity.mostCurrent._clockbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private clockLightBtn As Button";
mainactivity.mostCurrent._clocklightbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Public kvs As KeyValueStore";
mainactivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 22;BA.debugLine="Private infoPnl As B4XView";
mainactivity.mostCurrent._infopnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private infoTitleLbl As Label";
mainactivity.mostCurrent._infotitlelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private infoDescLbl As Label";
mainactivity.mostCurrent._infodesclbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private infoPageLbl As Label";
mainactivity.mostCurrent._infopagelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim infoPage As Int = 0";
mainactivity._infopage = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _helpbtn_click() throws Exception{
try {
		Debug.PushSubsStack("helpBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,140);
if (RapidSub.canDelegate("helpbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","helpbtn_click");}
 BA.debugLineNum = 140;BA.debugLine="Private Sub helpBtn_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="StartActivity(helpActivity)";
Debug.ShouldStop(4096);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._helpactivity.getObject())));
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _infopnlclose_click() throws Exception{
try {
		Debug.PushSubsStack("infoPnlClose_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,204);
if (RapidSub.canDelegate("infopnlclose_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","infopnlclose_click");}
 BA.debugLineNum = 204;BA.debugLine="Private Sub infoPnlClose_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 205;BA.debugLine="infoPnl.Visible = False";
Debug.ShouldStop(4096);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _lamp_click() throws Exception{
try {
		Debug.PushSubsStack("lamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,80);
if (RapidSub.canDelegate("lamp_click")) { b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","lamp_click"); return;}
ResumableSub_lamp_Click rsub = new ResumableSub_lamp_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_lamp_Click extends BA.ResumableSub {
public ResumableSub_lamp_Click(b4a.example.mainactivity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("lamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,80);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 81;BA.debugLine="Starter.darkMode = True";
Debug.ShouldStop(65536);
parent.mostCurrent._starter._darkmode /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 82;BA.debugLine="darkModeLayout.Visible = True";
Debug.ShouldStop(131072);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 83;BA.debugLine="darkModeLayout.BringToFront";
Debug.ShouldStop(262144);
parent.mostCurrent._darkmodelayout.runVoidMethod ("BringToFront");
 BA.debugLineNum = 84;BA.debugLine="darkModeLayout.Alpha = 0";
Debug.ShouldStop(524288);
parent.mostCurrent._darkmodelayout.runMethod(true,"setAlpha",BA.numberCast(float.class, 0));
 BA.debugLineNum = 85;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 1)";
Debug.ShouldStop(1048576);
parent.mostCurrent._darkmodelayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 86;BA.debugLine="regLayout.SetAlphaAnimated(250, 0)";
Debug.ShouldStop(2097152);
parent.mostCurrent._reglayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 87;BA.debugLine="Sleep(250)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "lamp_click"),BA.numberCast(int.class, 250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 88;BA.debugLine="regLayout.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _mp_click() throws Exception{
try {
		Debug.PushSubsStack("mP_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,212);
if (RapidSub.canDelegate("mp_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","mp_click");}
 BA.debugLineNum = 212;BA.debugLine="Private Sub mP_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="StartActivity(musicActivity)";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._musicactivity.getObject())));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _navbtn_click() throws Exception{
try {
		Debug.PushSubsStack("navBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,136);
if (RapidSub.canDelegate("navbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","navbtn_click");}
 BA.debugLineNum = 136;BA.debugLine="Private Sub navBtn_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="StartActivity(navActivity)";
Debug.ShouldStop(256);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._navactivity.getObject())));
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim xui As XUI";
mainactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 8;BA.debugLine="Private timerClock As Timer";
mainactivity._timerclock = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 9;BA.debugLine="Public kvs As KeyValueStore";
mainactivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 10;BA.debugLine="Public format24h As Boolean = False";
mainactivity._format24h = mainactivity.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showinfopage(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("showInfoPage (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,177);
if (RapidSub.canDelegate("showinfopage")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","showinfopage", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 177;BA.debugLine="Private Sub showInfoPage(page As Int)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="infoPage = page";
Debug.ShouldStop(131072);
mainactivity._infopage = _page;
 BA.debugLineNum = 179;BA.debugLine="Select page";
Debug.ShouldStop(262144);
switch (BA.switchObjectToInt(_page,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6))) {
case 0: {
 BA.debugLineNum = 181;BA.debugLine="infoTitleLbl.Text = \"Calendar\"";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Calendar"));
 BA.debugLineNum = 182;BA.debugLine="infoDescLbl.Text = \"The calendar comes in three";
Debug.ShouldStop(2097152);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The calendar comes in three views to match however you like to plan. The Schedule view lets you see all your upcoming days at a glance, with major events and to-do items laid out on a timeline. The Day view shows you the full timeline for a single day, where you can add events, tasks, or birthdays, and color-coded backgrounds make each type of entry easy to tell apart. The Month view presents the classic calendar layout, complete with a month and year spinner to jump around quickly, a sneak peek of events on each day's cell, and neighboring dates filling in the empty cells so the grid always looks complete."));
 break; }
case 1: {
 BA.debugLineNum = 184;BA.debugLine="infoTitleLbl.Text = \"Clock\"";
Debug.ShouldStop(8388608);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Clock"));
 BA.debugLineNum = 185;BA.debugLine="infoDescLbl.Text = \"The clock keeps you on time";
Debug.ShouldStop(16777216);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The clock keeps you on time and on task all in one place. A format button lets you switch between clock displays to whatever you prefer. It also comes with a built-in Pomodoro timer to help you stay focused and productive, and if the default durations don't work for you, you can freely adjust them to fit your own rhythm."));
 break; }
case 2: {
 BA.debugLineNum = 187;BA.debugLine="infoTitleLbl.Text = \"Corkboard\"";
Debug.ShouldStop(67108864);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Corkboard"));
 BA.debugLineNum = 188;BA.debugLine="infoDescLbl.Text = \"The corkboard gives you a c";
Debug.ShouldStop(134217728);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The corkboard gives you a creative space to pin your thoughts and ideas. You can place sticky notes in a variety of colors to keep things visually organized and easy to tell apart. Images from your gallery can be attached right onto the board for extra context or inspiration. And when words and notes aren't enough, you can open up a drawable canvas with a selection of colored pens and sketch, doodle, or diagram anything you have in mind."));
 break; }
case 3: {
 BA.debugLineNum = 190;BA.debugLine="infoTitleLbl.Text = \"Flashcards\"";
Debug.ShouldStop(536870912);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Flashcards"));
 BA.debugLineNum = 191;BA.debugLine="infoDescLbl.Text = \"The flashcard feature organ";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The flashcard feature organizes your cards into decks and subdecks, and you have the freedom to add, rename, or delete any of them — with a confirmation before anything gets deleted for good. Cards are automatically shuffled so every session feels fresh. A progress bar and percentage track how far you've made it through a deck, and when you're ready to dive back in, two buttons have you covered — restart the entire deck from scratch, or continue right where you left off."));
 break; }
case 4: {
 BA.debugLineNum = 193;BA.debugLine="infoTitleLbl.Text = \"Music Player\"";
Debug.ShouldStop(1);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Music Player"));
 BA.debugLineNum = 194;BA.debugLine="infoDescLbl.Text = \"The music player plays the";
Debug.ShouldStop(2);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The music player plays the music on startup, meaning the app greets you with songs! Filled with chill, lo-fi tracks, you have the freedom to choose what track you want to play--either through the previous/next song buttons, or through the list of songs below where you can click on whatever chooses your fancy. There's a segment of the song that you want to listen to again or you want to zoom through a certain bit of a song? The seek bar presents itself to you where you can navigate within the music.  "));
 break; }
case 5: {
 BA.debugLineNum = 196;BA.debugLine="infoTitleLbl.Text = \"Notepad\"";
Debug.ShouldStop(8);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Notepad"));
 BA.debugLineNum = 197;BA.debugLine="infoDescLbl.Text = \"The notepad keeps all your";
Debug.ShouldStop(16);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The notepad keeps all your notes in one tidy list that's easy to browse through. A search bar lets you quickly find any note by its title or tags, so nothing ever gets lost in the pile. Adding a new note is simple — just give it a title, attach some tags to keep things organized, and write away to your heart's content."));
 break; }
case 6: {
 BA.debugLineNum = 199;BA.debugLine="infoTitleLbl.Text = \"To-do List\"";
Debug.ShouldStop(64);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("To-do List"));
 BA.debugLineNum = 200;BA.debugLine="infoDescLbl.Text = \"The to-do list enables you";
Debug.ShouldStop(128);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The to-do list enables you to create lists with titles and, especially, tasks you want or are obligated to do. You are able to keep a lot of lists that you can easily navigate through the left side of your screen. The task section is a checklist of your tasks that you input, and once achieved, you can tick it off the list. The to-do list will also show you your progress in the list."));
 break; }
}
;
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showinfopopup() throws Exception{
try {
		Debug.PushSubsStack("showInfoPopup (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,144);
if (RapidSub.canDelegate("showinfopopup")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","showinfopopup");}
RemoteObject _closebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 144;BA.debugLine="Private Sub showInfoPopup";
Debug.ShouldStop(32768);
 BA.debugLineNum = 147;BA.debugLine="infoPnl = xui.CreatePanel(\"infoPnl\")";
Debug.ShouldStop(262144);
mainactivity.mostCurrent._infopnl = mainactivity._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("infoPnl")));
 BA.debugLineNum = 148;BA.debugLine="Activity.AddView(infoPnl, 75dip, 225dip, 300dip,";
Debug.ShouldStop(524288);
mainactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infopnl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220)))));
 BA.debugLineNum = 149;BA.debugLine="infoPnl.SetColorAndBorder(xui.Color_White, 2dip,";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent._infopnl.runVoidMethod ("SetColorAndBorder",(Object)(mainactivity._xui.getField(true,"Color_White")),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(mainactivity._xui.getField(true,"Color_Black")),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 151;BA.debugLine="Dim closeBtn As Button";
Debug.ShouldStop(4194304);
_closebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("closeBtn", _closebtn);
 BA.debugLineNum = 152;BA.debugLine="closeBtn.Initialize(\"infoPnlClose\")";
Debug.ShouldStop(8388608);
_closebtn.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("infoPnlClose")));
 BA.debugLineNum = 153;BA.debugLine="closeBtn.Text = \"X\"";
Debug.ShouldStop(16777216);
_closebtn.runMethod(true,"setText",BA.ObjectToCharSequence("X"));
 BA.debugLineNum = 154;BA.debugLine="closeBtn.TextSize = 8";
Debug.ShouldStop(33554432);
_closebtn.runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 155;BA.debugLine="infoPnl.AddView(closeBtn, 265dip, 8dip, 28dip, 28";
Debug.ShouldStop(67108864);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((_closebtn.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 265)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 28)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 28)))));
 BA.debugLineNum = 157;BA.debugLine="infoTitleLbl.Initialize(\"\")";
Debug.ShouldStop(268435456);
mainactivity.mostCurrent._infotitlelbl.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 158;BA.debugLine="infoTitleLbl.TextSize = 16";
Debug.ShouldStop(536870912);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 159;BA.debugLine="infoTitleLbl.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setGravity",mainactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 160;BA.debugLine="infoPnl.AddView(infoTitleLbl, 10dip, 12dip, 248di";
Debug.ShouldStop(-2147483648);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infotitlelbl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 248)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 162;BA.debugLine="infoDescLbl.Initialize(\"\")";
Debug.ShouldStop(2);
mainactivity.mostCurrent._infodesclbl.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 163;BA.debugLine="infoDescLbl.TextSize = 13";
Debug.ShouldStop(4);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 164;BA.debugLine="infoDescLbl.Gravity = Gravity.TOP";
Debug.ShouldStop(8);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setGravity",mainactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 165;BA.debugLine="infoDescLbl.SingleLine = False";
Debug.ShouldStop(16);
mainactivity.mostCurrent._infodesclbl.runVoidMethod ("setSingleLine",mainactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 166;BA.debugLine="infoPnl.AddView(infoDescLbl, 12dip, 52dip, 276dip";
Debug.ShouldStop(32);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infodesclbl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 52)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 276)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))));
 BA.debugLineNum = 168;BA.debugLine="infoPageLbl.Initialize(\"\")";
Debug.ShouldStop(128);
mainactivity.mostCurrent._infopagelbl.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 169;BA.debugLine="infoPageLbl.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(256);
mainactivity.mostCurrent._infopagelbl.runMethod(true,"setGravity",mainactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 170;BA.debugLine="infoPageLbl.TextSize = 11";
Debug.ShouldStop(512);
mainactivity.mostCurrent._infopagelbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 171;BA.debugLine="infoPnl.AddView(infoPageLbl, 95dip, 184dip, 110di";
Debug.ShouldStop(1024);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infopagelbl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 95)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 184)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 22)))));
 BA.debugLineNum = 174;BA.debugLine="showInfoPage(0)";
Debug.ShouldStop(8192);
_showinfopage(BA.numberCast(int.class, 0));
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timerclock_tick() throws Exception{
try {
		Debug.PushSubsStack("timerClock_Tick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,102);
if (RapidSub.canDelegate("timerclock_tick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","timerclock_tick");}
 BA.debugLineNum = 102;BA.debugLine="Sub timerClock_Tick";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="clockBtn.Text = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(64);
mainactivity.mostCurrent._clockbtn.runMethod(true,"setText",BA.ObjectToCharSequence(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 104;BA.debugLine="clockLightBtn.Text = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(128);
mainactivity.mostCurrent._clocklightbtn.runMethod(true,"setText",BA.ObjectToCharSequence(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _todolistbtn_click() throws Exception{
try {
		Debug.PushSubsStack("todolistBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,208);
if (RapidSub.canDelegate("todolistbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","todolistbtn_click");}
 BA.debugLineNum = 208;BA.debugLine="Private Sub todolistBtn_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="StartActivity(todoActivity)";
Debug.ShouldStop(65536);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._todoactivity.getObject())));
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}