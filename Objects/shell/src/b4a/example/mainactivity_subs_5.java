package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class mainactivity_subs_5 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,34);
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
		Debug.PushSubsStack("Activity_Create (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,34);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"Layouthsv\")";
Debug.ShouldStop(4);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layouthsv")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(8);
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
 BA.debugLineNum = 37;BA.debugLine="kvs = Starter.notesKvs";
Debug.ShouldStop(16);
parent._kvs = parent.mostCurrent._starter._noteskvs /*RemoteObject*/ ;
 BA.debugLineNum = 38;BA.debugLine="kvsPref = Starter.prefKvs";
Debug.ShouldStop(32);
parent._kvspref = parent.mostCurrent._starter._prefkvs /*RemoteObject*/ ;
 BA.debugLineNum = 39;BA.debugLine="timerClock.Initialize(\"timerClock\", 1000)";
Debug.ShouldStop(64);
parent._timerclock.runVoidMethod ("Initialize",mainactivity.processBA,(Object)(BA.ObjectToString("timerClock")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 40;BA.debugLine="timerClock.Enabled = True";
Debug.ShouldStop(128);
parent._timerclock.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 43;BA.debugLine="hsv.Panel.Width = size";
Debug.ShouldStop(1024);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"setWidth",parent._size);
 BA.debugLineNum = 44;BA.debugLine="hsv.Panel.Height = size";
Debug.ShouldStop(2048);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"setHeight",parent._size);
 BA.debugLineNum = 46;BA.debugLine="regLayout = xui.CreatePanel(\"\")";
Debug.ShouldStop(8192);
parent.mostCurrent._reglayout = parent._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 47;BA.debugLine="darkModeLayout = xui.CreatePanel(\"\")";
Debug.ShouldStop(16384);
parent.mostCurrent._darkmodelayout = parent._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 49;BA.debugLine="hsv.Panel.AddView(regLayout, 0, 0, hsv.Panel.Widt";
Debug.ShouldStop(65536);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((parent.mostCurrent._reglayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getWidth")),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getHeight")));
 BA.debugLineNum = 50;BA.debugLine="hsv.Panel.AddView(darkModeLayout, 0, 0, hsv.Panel";
Debug.ShouldStop(131072);
parent.mostCurrent._hsv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((parent.mostCurrent._darkmodelayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getWidth")),(Object)(parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getHeight")));
 BA.debugLineNum = 52;BA.debugLine="Select Starter.themeNumber";
Debug.ShouldStop(524288);
if (true) break;

case 5:
//select
this.state = 12;
switch (BA.switchObjectToInt(parent.mostCurrent._starter._themenumber /*RemoteObject*/ ,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
this.state = 7;
if (true) break;
}
case 1: {
this.state = 9;
if (true) break;
}
case 2: {
this.state = 11;
if (true) break;
}
}
if (true) break;

case 7:
//C
this.state = 12;
 BA.debugLineNum = 54;BA.debugLine="regLayout.LoadLayout(\"Layout\")";
Debug.ShouldStop(2097152);
parent.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\")";
Debug.ShouldStop(4194304);
parent.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout2")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 56;BA.debugLine="computerGif.SetGif(File.DirAssets, \"BtnComputer";
Debug.ShouldStop(8388608);
parent.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("BtnComputer.GIF")));
 BA.debugLineNum = 57;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"darkbtncom";
Debug.ShouldStop(16777216);
parent.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("darkbtncomputer.GIF")));
 if (true) break;

case 9:
//C
this.state = 12;
 BA.debugLineNum = 59;BA.debugLine="regLayout.LoadLayout(\"Layout3\")";
Debug.ShouldStop(67108864);
parent.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout3")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 60;BA.debugLine="darkModeLayout.LoadLayout(\"Layout4\")";
Debug.ShouldStop(134217728);
parent.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout4")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 61;BA.debugLine="computerGif.SetGif(File.DirAssets, \"mikucomp2.G";
Debug.ShouldStop(268435456);
parent.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("mikucomp2.GIF")));
 BA.debugLineNum = 62;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"DComp2.GIF";
Debug.ShouldStop(536870912);
parent.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DComp2.GIF")));
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 64;BA.debugLine="regLayout.LoadLayout(\"Layout5\")";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout5")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 65;BA.debugLine="darkModeLayout.LoadLayout(\"Layout6\")";
Debug.ShouldStop(1);
parent.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout6")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 66;BA.debugLine="computerGif.SetGif(File.DirAssets, \"Comp3.GIF\")";
Debug.ShouldStop(2);
parent.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Comp3.GIF")));
 BA.debugLineNum = 67;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"DComp3.GIF";
Debug.ShouldStop(4);
parent.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DComp3.GIF")));
 BA.debugLineNum = 68;BA.debugLine="curtain.SetGif(File.DirAssets, \"Curtain.GIF\")";
Debug.ShouldStop(8);
parent.mostCurrent._curtain.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Curtain.GIF")));
 BA.debugLineNum = 69;BA.debugLine="dCurtain.SetGif(File.DirAssets, \"DCurtain.GIF\")";
Debug.ShouldStop(16);
parent.mostCurrent._dcurtain.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DCurtain.GIF")));
 if (true) break;
;
 BA.debugLineNum = 72;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(128);

case 12:
//if
this.state = 17;
if (parent.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
this.state = 14;
}else {
this.state = 16;
}if (true) break;

case 14:
//C
this.state = 17;
 BA.debugLineNum = 73;BA.debugLine="darkModeLayout.Visible = True";
Debug.ShouldStop(256);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 74;BA.debugLine="darkModeLayout.BringToFront";
Debug.ShouldStop(512);
parent.mostCurrent._darkmodelayout.runVoidMethod ("BringToFront");
 BA.debugLineNum = 75;BA.debugLine="regLayout.Visible = False";
Debug.ShouldStop(1024);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 77;BA.debugLine="darkModeLayout.Visible = False";
Debug.ShouldStop(4096);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 78;BA.debugLine="regLayout.BringToFront";
Debug.ShouldStop(8192);
parent.mostCurrent._reglayout.runVoidMethod ("BringToFront");
 if (true) break;

case 17:
//C
this.state = -1;
;
 BA.debugLineNum = 81;BA.debugLine="Sleep(50)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "activity_create"),BA.numberCast(int.class, 50));
this.state = 18;
return;
case 18:
//C
this.state = -1;
;
 BA.debugLineNum = 82;BA.debugLine="hsv.ScrollPosition = Max(0, (hsv.Panel.Width - 10";
Debug.ShouldStop(131072);
parent.mostCurrent._hsv.runMethod(true,"setScrollPosition",BA.numberCast(int.class, parent.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._hsv.runMethod(false,"getPanel").runMethod(true,"getWidth"),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA)}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)))));
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Pause (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,118);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 118;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Resume (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,86);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_resume");}
 BA.debugLineNum = 86;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 88;BA.debugLine="If format24h Then";
Debug.ShouldStop(8388608);
if (mainactivity._format24h.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 89;BA.debugLine="DateTime.TimeFormat = \"HH:mm\" ' 24-Hour Format";
Debug.ShouldStop(16777216);
mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 }else {
 BA.debugLineNum = 91;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\" ' AM/PM Format";
Debug.ShouldStop(67108864);
mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh:mm a"));
 };
 BA.debugLineNum = 94;BA.debugLine="regLayout.RemoveAllViews";
Debug.ShouldStop(536870912);
mainactivity.mostCurrent._reglayout.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 95;BA.debugLine="darkModeLayout.RemoveAllViews";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent._darkmodelayout.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 97;BA.debugLine="Select Starter.themeNumber";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(mainactivity.mostCurrent._starter._themenumber /*RemoteObject*/ ,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 99;BA.debugLine="regLayout.LoadLayout(\"Layout\")";
Debug.ShouldStop(4);
mainactivity.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 100;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\")";
Debug.ShouldStop(8);
mainactivity.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout2")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 101;BA.debugLine="computerGif.SetGif(File.DirAssets, \"BtnComputer";
Debug.ShouldStop(16);
mainactivity.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("BtnComputer.GIF")));
 BA.debugLineNum = 102;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"darkbtnCom";
Debug.ShouldStop(32);
mainactivity.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("darkbtnComputer.GIF")));
 break; }
case 1: {
 BA.debugLineNum = 104;BA.debugLine="regLayout.LoadLayout(\"Layout3\")";
Debug.ShouldStop(128);
mainactivity.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout3")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 105;BA.debugLine="darkModeLayout.LoadLayout(\"Layout4\")";
Debug.ShouldStop(256);
mainactivity.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout4")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 106;BA.debugLine="computerGif.SetGif(File.DirAssets, \"mikucomp2.G";
Debug.ShouldStop(512);
mainactivity.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("mikucomp2.GIF")));
 BA.debugLineNum = 107;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"DComp2.GIF";
Debug.ShouldStop(1024);
mainactivity.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DComp2.GIF")));
 break; }
case 2: {
 BA.debugLineNum = 109;BA.debugLine="regLayout.LoadLayout(\"Layout5\")";
Debug.ShouldStop(4096);
mainactivity.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout5")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 110;BA.debugLine="darkModeLayout.LoadLayout(\"Layout6\")";
Debug.ShouldStop(8192);
mainactivity.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout6")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 111;BA.debugLine="computerGif.SetGif(File.DirAssets, \"Comp3.GIF\")";
Debug.ShouldStop(16384);
mainactivity.mostCurrent._computergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Comp3.GIF")));
 BA.debugLineNum = 112;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"DComp3.GIF";
Debug.ShouldStop(32768);
mainactivity.mostCurrent._dcomputergif.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DComp3.GIF")));
 BA.debugLineNum = 113;BA.debugLine="curtain.SetGif(File.DirAssets, \"Curtain.GIF\")";
Debug.ShouldStop(65536);
mainactivity.mostCurrent._curtain.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Curtain.GIF")));
 BA.debugLineNum = 114;BA.debugLine="dCurtain.SetGif(File.DirAssets, \"DCurtain.GIF\")";
Debug.ShouldStop(131072);
mainactivity.mostCurrent._dcurtain.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(mainactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DCurtain.GIF")));
 break; }
}
;
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("bookie_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,250);
if (RapidSub.canDelegate("bookie_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","bookie_click");}
 BA.debugLineNum = 250;BA.debugLine="Private Sub bookie_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 251;BA.debugLine="StartActivity(FlashcardActivity)";
Debug.ShouldStop(67108864);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._flashcardactivity.getObject())));
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bookie_longclick() throws Exception{
try {
		Debug.PushSubsStack("bookie_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,357);
if (RapidSub.canDelegate("bookie_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","bookie_longclick");}
 BA.debugLineNum = 357;BA.debugLine="Private Sub bookie_LongClick";
Debug.ShouldStop(16);
 BA.debugLineNum = 358;BA.debugLine="showInfoPopup";
Debug.ShouldStop(32);
_showinfopopup();
 BA.debugLineNum = 359;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 360;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(128);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 361;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(256);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 362;BA.debugLine="showInfoPage(3)";
Debug.ShouldStop(512);
_showinfopage(BA.numberCast(int.class, 3));
 BA.debugLineNum = 363;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("calendar_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,254);
if (RapidSub.canDelegate("calendar_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","calendar_click");}
 BA.debugLineNum = 254;BA.debugLine="Private Sub calendar_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 255;BA.debugLine="StartActivity(CalendarActivity)";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._calendaractivity.getObject())));
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calendar_longclick() throws Exception{
try {
		Debug.PushSubsStack("calendar_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,317);
if (RapidSub.canDelegate("calendar_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","calendar_longclick");}
 BA.debugLineNum = 317;BA.debugLine="Private Sub calendar_LongClick";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 318;BA.debugLine="showInfoPopup";
Debug.ShouldStop(536870912);
_showinfopopup();
 BA.debugLineNum = 319;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 320;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(-2147483648);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 321;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(1);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 322;BA.debugLine="showInfoPage(0)";
Debug.ShouldStop(2);
_showinfopage(BA.numberCast(int.class, 0));
 BA.debugLineNum = 323;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 325;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("clockBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,222);
if (RapidSub.canDelegate("clockbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clockbtn_click");}
 BA.debugLineNum = 222;BA.debugLine="Private Sub clockBtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 223;BA.debugLine="StartActivity(clockActivity)";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._clockactivity.getObject())));
 BA.debugLineNum = 224;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("clockBtn_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,327);
if (RapidSub.canDelegate("clockbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clockbtn_longclick");}
 BA.debugLineNum = 327;BA.debugLine="Private Sub clockBtn_LongClick";
Debug.ShouldStop(64);
 BA.debugLineNum = 328;BA.debugLine="showInfoPopup";
Debug.ShouldStop(128);
_showinfopopup();
 BA.debugLineNum = 329;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 330;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(512);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 331;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(1024);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 332;BA.debugLine="showInfoPage(1)";
Debug.ShouldStop(2048);
_showinfopage(BA.numberCast(int.class, 1));
 BA.debugLineNum = 333;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 335;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("clockLightBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,226);
if (RapidSub.canDelegate("clocklightbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clocklightbtn_click");}
 BA.debugLineNum = 226;BA.debugLine="Private Sub  clockLightBtn_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 227;BA.debugLine="StartActivity(clockActivity)";
Debug.ShouldStop(4);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._clockactivity.getObject())));
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("clockLightBtn_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,337);
if (RapidSub.canDelegate("clocklightbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clocklightbtn_longclick");}
 BA.debugLineNum = 337;BA.debugLine="Private Sub clockLightBtn_LongClick";
Debug.ShouldStop(65536);
 BA.debugLineNum = 338;BA.debugLine="showInfoPopup";
Debug.ShouldStop(131072);
_showinfopopup();
 BA.debugLineNum = 339;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 340;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(524288);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 341;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 342;BA.debugLine="showInfoPage(1)";
Debug.ShouldStop(2097152);
_showinfopage(BA.numberCast(int.class, 1));
 BA.debugLineNum = 343;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 345;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _corkie_click() throws Exception{
try {
		Debug.PushSubsStack("corkie_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,308);
if (RapidSub.canDelegate("corkie_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","corkie_click");}
 BA.debugLineNum = 308;BA.debugLine="Private Sub corkie_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 309;BA.debugLine="StartActivity(corkActivity)";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._corkactivity.getObject())));
 BA.debugLineNum = 310;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _corkie_longclick() throws Exception{
try {
		Debug.PushSubsStack("corkie_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,347);
if (RapidSub.canDelegate("corkie_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","corkie_longclick");}
 BA.debugLineNum = 347;BA.debugLine="Private Sub corkie_LongClick";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 348;BA.debugLine="showInfoPopup";
Debug.ShouldStop(134217728);
_showinfopopup();
 BA.debugLineNum = 349;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 350;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(536870912);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 351;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 352;BA.debugLine="showInfoPage(2)";
Debug.ShouldStop(-2147483648);
_showinfopage(BA.numberCast(int.class, 2));
 BA.debugLineNum = 353;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 355;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("dlamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,134);
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
		Debug.PushSubsStack("dlamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,134);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 135;BA.debugLine="Starter.darkMode = False";
Debug.ShouldStop(64);
parent.mostCurrent._starter._darkmode /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 136;BA.debugLine="kvsPref.Put(\"darkMode\", False)";
Debug.ShouldStop(128);
parent._kvspref.runVoidMethod ("_put",(Object)(BA.ObjectToString("darkMode")),(Object)((parent.mostCurrent.__c.getField(true,"False"))));
 BA.debugLineNum = 137;BA.debugLine="regLayout.Visible = True";
Debug.ShouldStop(256);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 138;BA.debugLine="regLayout.BringToFront";
Debug.ShouldStop(512);
parent.mostCurrent._reglayout.runVoidMethod ("BringToFront");
 BA.debugLineNum = 139;BA.debugLine="regLayout.Alpha = 0";
Debug.ShouldStop(1024);
parent.mostCurrent._reglayout.runMethod(true,"setAlpha",BA.numberCast(float.class, 0));
 BA.debugLineNum = 140;BA.debugLine="regLayout.SetAlphaAnimated(250, 1)";
Debug.ShouldStop(2048);
parent.mostCurrent._reglayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 141;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 0)";
Debug.ShouldStop(4096);
parent.mostCurrent._darkmodelayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 142;BA.debugLine="Sleep(250)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "dlamp_click"),BA.numberCast(int.class, 250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 143;BA.debugLine="darkModeLayout.Visible = False";
Debug.ShouldStop(16384);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static RemoteObject  _dlamp_longclick() throws Exception{
try {
		Debug.PushSubsStack("dlamp_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,417);
if (RapidSub.canDelegate("dlamp_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","dlamp_longclick");}
 BA.debugLineNum = 417;BA.debugLine="Private Sub dlamp_LongClick";
Debug.ShouldStop(1);
 BA.debugLineNum = 418;BA.debugLine="showInfoPopup";
Debug.ShouldStop(2);
_showinfopopup();
 BA.debugLineNum = 419;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 420;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(8);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 421;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(16);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 422;BA.debugLine="showInfoPage(8)";
Debug.ShouldStop(32);
_showinfopage(BA.numberCast(int.class, 8));
 BA.debugLineNum = 423;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 425;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim regLayout, darkModeLayout As B4XView";
mainactivity.mostCurrent._reglayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
mainactivity.mostCurrent._darkmodelayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim size As Int = 100%y";
mainactivity._size = mainactivity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA);
 //BA.debugLineNum = 17;BA.debugLine="Private hsv As HorizontalScrollView";
mainactivity.mostCurrent._hsv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private computerGif As B4XGifView";
mainactivity.mostCurrent._computergif = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 19;BA.debugLine="Private dcomputerGif As B4XGifView";
mainactivity.mostCurrent._dcomputergif = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 20;BA.debugLine="Private curtain As B4XGifView";
mainactivity.mostCurrent._curtain = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 21;BA.debugLine="Private dCurtain As B4XGifView";
mainactivity.mostCurrent._dcurtain = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 22;BA.debugLine="Private notesOpen As B4XGifView";
mainactivity.mostCurrent._notesopen = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 23;BA.debugLine="Private noteBook As ImageView";
mainactivity.mostCurrent._notebook = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private dnotesOpen As B4XGifView";
mainactivity.mostCurrent._dnotesopen = RemoteObject.createNew ("b4a.example.b4xgifview");
 //BA.debugLineNum = 25;BA.debugLine="Private clockBtn As Button";
mainactivity.mostCurrent._clockbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private clockLightBtn As Button";
mainactivity.mostCurrent._clocklightbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private infoPnl As B4XView";
mainactivity.mostCurrent._infopnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private infoTitleLbl As Label";
mainactivity.mostCurrent._infotitlelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private infoDescLbl As Label";
mainactivity.mostCurrent._infodesclbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private infoPageLbl As Label";
mainactivity.mostCurrent._infopagelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim infoPage As Int = 0";
mainactivity._infopage = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _helpbtn_click() throws Exception{
try {
		Debug.PushSubsStack("helpBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,234);
if (RapidSub.canDelegate("helpbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","helpbtn_click");}
 BA.debugLineNum = 234;BA.debugLine="Private Sub helpBtn_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 235;BA.debugLine="StartActivity(helpActivity)";
Debug.ShouldStop(1024);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._helpactivity.getObject())));
 BA.debugLineNum = 236;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("infoPnlClose_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,238);
if (RapidSub.canDelegate("infopnlclose_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","infopnlclose_click");}
 BA.debugLineNum = 238;BA.debugLine="Private Sub infoPnlClose_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 239;BA.debugLine="infoPnl.Visible = False";
Debug.ShouldStop(16384);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("lamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,122);
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
		Debug.PushSubsStack("lamp_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,122);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 123;BA.debugLine="Starter.darkMode = True";
Debug.ShouldStop(67108864);
parent.mostCurrent._starter._darkmode /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 124;BA.debugLine="kvsPref.Put(\"darkMode\", True)";
Debug.ShouldStop(134217728);
parent._kvspref.runVoidMethod ("_put",(Object)(BA.ObjectToString("darkMode")),(Object)((parent.mostCurrent.__c.getField(true,"True"))));
 BA.debugLineNum = 125;BA.debugLine="darkModeLayout.Visible = True";
Debug.ShouldStop(268435456);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 126;BA.debugLine="darkModeLayout.BringToFront";
Debug.ShouldStop(536870912);
parent.mostCurrent._darkmodelayout.runVoidMethod ("BringToFront");
 BA.debugLineNum = 127;BA.debugLine="darkModeLayout.Alpha = 0";
Debug.ShouldStop(1073741824);
parent.mostCurrent._darkmodelayout.runMethod(true,"setAlpha",BA.numberCast(float.class, 0));
 BA.debugLineNum = 128;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 1)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._darkmodelayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 129;BA.debugLine="regLayout.SetAlphaAnimated(250, 0)";
Debug.ShouldStop(1);
parent.mostCurrent._reglayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 130;BA.debugLine="Sleep(250)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "lamp_click"),BA.numberCast(int.class, 250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 131;BA.debugLine="regLayout.Visible = False";
Debug.ShouldStop(4);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 132;BA.debugLine="End Sub";
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
public static RemoteObject  _lamp_longclick() throws Exception{
try {
		Debug.PushSubsStack("lamp_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,407);
if (RapidSub.canDelegate("lamp_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","lamp_longclick");}
 BA.debugLineNum = 407;BA.debugLine="Private Sub lamp_LongClick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 408;BA.debugLine="showInfoPopup";
Debug.ShouldStop(8388608);
_showinfopopup();
 BA.debugLineNum = 409;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 410;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(33554432);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 411;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(67108864);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 412;BA.debugLine="showInfoPage(8)";
Debug.ShouldStop(134217728);
_showinfopage(BA.numberCast(int.class, 8));
 BA.debugLineNum = 413;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 415;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mp_click() throws Exception{
try {
		Debug.PushSubsStack("mP_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,246);
if (RapidSub.canDelegate("mp_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","mp_click");}
 BA.debugLineNum = 246;BA.debugLine="Private Sub mP_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 247;BA.debugLine="StartActivity(musicActivity)";
Debug.ShouldStop(4194304);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._musicactivity.getObject())));
 BA.debugLineNum = 248;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mp_longclick() throws Exception{
try {
		Debug.PushSubsStack("mP_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,367);
if (RapidSub.canDelegate("mp_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","mp_longclick");}
 BA.debugLineNum = 367;BA.debugLine="Private Sub mP_LongClick";
Debug.ShouldStop(16384);
 BA.debugLineNum = 368;BA.debugLine="showInfoPopup";
Debug.ShouldStop(32768);
_showinfopopup();
 BA.debugLineNum = 369;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 370;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(131072);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 371;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(262144);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 372;BA.debugLine="showInfoPage(4)";
Debug.ShouldStop(524288);
_showinfopage(BA.numberCast(int.class, 4));
 BA.debugLineNum = 373;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 375;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("navBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,230);
if (RapidSub.canDelegate("navbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","navbtn_click");}
 BA.debugLineNum = 230;BA.debugLine="Private Sub navBtn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 231;BA.debugLine="StartActivity(navActivity)";
Debug.ShouldStop(64);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._navactivity.getObject())));
 BA.debugLineNum = 232;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _navbtn_longclick() throws Exception{
try {
		Debug.PushSubsStack("navBtn_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,427);
if (RapidSub.canDelegate("navbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","navbtn_longclick");}
 BA.debugLineNum = 427;BA.debugLine="Private Sub navBtn_LongClick";
Debug.ShouldStop(1024);
 BA.debugLineNum = 428;BA.debugLine="showInfoPopup";
Debug.ShouldStop(2048);
_showinfopopup();
 BA.debugLineNum = 429;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 430;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(8192);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 431;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(16384);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 432;BA.debugLine="showInfoPage(9)";
Debug.ShouldStop(32768);
_showinfopage(BA.numberCast(int.class, 9));
 BA.debugLineNum = 433;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 435;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _notebook_click() throws Exception{
try {
		Debug.PushSubsStack("noteBook_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,258);
if (RapidSub.canDelegate("notebook_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","notebook_click");}
 BA.debugLineNum = 258;BA.debugLine="Private Sub noteBook_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 259;BA.debugLine="Select Starter.themeNumber";
Debug.ShouldStop(4);
switch (BA.switchObjectToInt(mainactivity.mostCurrent._starter._themenumber /*RemoteObject*/ ,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 261;BA.debugLine="CallSub(Me, \"NotesTransition1\")";
Debug.ShouldStop(16);
mainactivity.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",mainactivity.processBA,(Object)(mainactivity.getObject()),(Object)(RemoteObject.createImmutable("NotesTransition1")));
 break; }
case 1: {
 BA.debugLineNum = 263;BA.debugLine="CallSub(Me, \"NotesTransition2\")";
Debug.ShouldStop(64);
mainactivity.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",mainactivity.processBA,(Object)(mainactivity.getObject()),(Object)(RemoteObject.createImmutable("NotesTransition2")));
 break; }
case 2: {
 BA.debugLineNum = 265;BA.debugLine="CallSub(Me, \"NotesTransition3\")";
Debug.ShouldStop(256);
mainactivity.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",mainactivity.processBA,(Object)(mainactivity.getObject()),(Object)(RemoteObject.createImmutable("NotesTransition3")));
 break; }
}
;
 BA.debugLineNum = 267;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _notebook_longclick() throws Exception{
try {
		Debug.PushSubsStack("noteBook_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,377);
if (RapidSub.canDelegate("notebook_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","notebook_longclick");}
 BA.debugLineNum = 377;BA.debugLine="Private Sub noteBook_LongClick";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 378;BA.debugLine="showInfoPopup";
Debug.ShouldStop(33554432);
_showinfopopup();
 BA.debugLineNum = 379;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 380;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(134217728);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 381;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(268435456);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 382;BA.debugLine="showInfoPage(5)";
Debug.ShouldStop(536870912);
_showinfopage(BA.numberCast(int.class, 5));
 BA.debugLineNum = 383;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _notestransition1() throws Exception{
try {
		Debug.PushSubsStack("NotesTransition1 (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,269);
if (RapidSub.canDelegate("notestransition1")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","notestransition1");}
ResumableSub_NotesTransition1 rsub = new ResumableSub_NotesTransition1(null);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_NotesTransition1 extends BA.ResumableSub {
public ResumableSub_NotesTransition1(b4a.example.mainactivity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("NotesTransition1 (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,269);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = -1;
 BA.debugLineNum = 270;BA.debugLine="notesOpen.SetGif(File.DirAssets, \"Openbook.GIF\")";
Debug.ShouldStop(8192);
parent.mostCurrent._notesopen.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Openbook.GIF")));
 BA.debugLineNum = 271;BA.debugLine="notesOpen.mBase.Visible = True";
Debug.ShouldStop(16384);
parent.mostCurrent._notesopen.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 272;BA.debugLine="dnotesOpen.SetGif(File.DirAssets, \"Darkopenbook.G";
Debug.ShouldStop(32768);
parent.mostCurrent._dnotesopen.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Darkopenbook.GIF")));
 BA.debugLineNum = 273;BA.debugLine="dnotesOpen.mBase.Visible = True";
Debug.ShouldStop(65536);
parent.mostCurrent._dnotesopen.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 274;BA.debugLine="noteBook.Enabled = False";
Debug.ShouldStop(131072);
parent.mostCurrent._notebook.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 275;BA.debugLine="noteBook.Visible = False 'bat ayaw mawala T-T";
Debug.ShouldStop(262144);
parent.mostCurrent._notebook.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 277;BA.debugLine="Sleep(1500)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "notestransition1"),BA.numberCast(int.class, 1500));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 279;BA.debugLine="StartActivity(noteActivity)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((parent.mostCurrent._noteactivity.getObject())));
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
public static RemoteObject  _notestransition2() throws Exception{
try {
		Debug.PushSubsStack("NotesTransition2 (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,282);
if (RapidSub.canDelegate("notestransition2")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","notestransition2");}
ResumableSub_NotesTransition2 rsub = new ResumableSub_NotesTransition2(null);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_NotesTransition2 extends BA.ResumableSub {
public ResumableSub_NotesTransition2(b4a.example.mainactivity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("NotesTransition2 (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,282);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = -1;
 BA.debugLineNum = 283;BA.debugLine="notesOpen.SetGif(File.DirAssets, \"OpenNotes2.GIF\"";
Debug.ShouldStop(67108864);
parent.mostCurrent._notesopen.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("OpenNotes2.GIF")));
 BA.debugLineNum = 284;BA.debugLine="notesOpen.mBase.Visible = True";
Debug.ShouldStop(134217728);
parent.mostCurrent._notesopen.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 285;BA.debugLine="dnotesOpen.SetGif(File.DirAssets, \"DOpenNotes2.GI";
Debug.ShouldStop(268435456);
parent.mostCurrent._dnotesopen.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DOpenNotes2.GIF")));
 BA.debugLineNum = 286;BA.debugLine="dnotesOpen.mBase.Visible = True";
Debug.ShouldStop(536870912);
parent.mostCurrent._dnotesopen.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 287;BA.debugLine="noteBook.Enabled = False";
Debug.ShouldStop(1073741824);
parent.mostCurrent._notebook.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 288;BA.debugLine="noteBook.Visible = False 'bat ayaw mawala T-T";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._notebook.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 290;BA.debugLine="Sleep(1500)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "notestransition2"),BA.numberCast(int.class, 1500));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 292;BA.debugLine="StartActivity(noteActivity)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((parent.mostCurrent._noteactivity.getObject())));
 BA.debugLineNum = 293;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
public static RemoteObject  _notestransition3() throws Exception{
try {
		Debug.PushSubsStack("NotesTransition3 (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,295);
if (RapidSub.canDelegate("notestransition3")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","notestransition3");}
ResumableSub_NotesTransition3 rsub = new ResumableSub_NotesTransition3(null);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_NotesTransition3 extends BA.ResumableSub {
public ResumableSub_NotesTransition3(b4a.example.mainactivity parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("NotesTransition3 (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,295);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = -1;
 BA.debugLineNum = 296;BA.debugLine="notesOpen.SetGif(File.DirAssets, \"OpenNotes3.GIF\"";
Debug.ShouldStop(128);
parent.mostCurrent._notesopen.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("OpenNotes3.GIF")));
 BA.debugLineNum = 297;BA.debugLine="notesOpen.mBase.Visible = True";
Debug.ShouldStop(256);
parent.mostCurrent._notesopen.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 298;BA.debugLine="dnotesOpen.SetGif(File.DirAssets, \"DOpenNotes3.GI";
Debug.ShouldStop(512);
parent.mostCurrent._dnotesopen.runClassMethod (b4a.example.b4xgifview.class, "_setgif" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("DOpenNotes3.GIF")));
 BA.debugLineNum = 299;BA.debugLine="dnotesOpen.mBase.Visible = True";
Debug.ShouldStop(1024);
parent.mostCurrent._dnotesopen.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 300;BA.debugLine="noteBook.Enabled = False";
Debug.ShouldStop(2048);
parent.mostCurrent._notebook.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 301;BA.debugLine="noteBook.Visible = False 'bat ayaw mawala T-T";
Debug.ShouldStop(4096);
parent.mostCurrent._notebook.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 303;BA.debugLine="Sleep(1500)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "notestransition3"),BA.numberCast(int.class, 1500));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 305;BA.debugLine="StartActivity(noteActivity)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((parent.mostCurrent._noteactivity.getObject())));
 BA.debugLineNum = 306;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
public static RemoteObject  _plant_click() throws Exception{
try {
		Debug.PushSubsStack("plant_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,312);
if (RapidSub.canDelegate("plant_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","plant_click");}
 BA.debugLineNum = 312;BA.debugLine="Private Sub plant_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 313;BA.debugLine="StartActivity(themeActivity)";
Debug.ShouldStop(16777216);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._themeactivity.getObject())));
 BA.debugLineNum = 314;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _plant_longclick() throws Exception{
try {
		Debug.PushSubsStack("plant_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,397);
if (RapidSub.canDelegate("plant_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","plant_longclick");}
 BA.debugLineNum = 397;BA.debugLine="Private Sub plant_LongClick";
Debug.ShouldStop(4096);
 BA.debugLineNum = 398;BA.debugLine="showInfoPopup";
Debug.ShouldStop(8192);
_showinfopopup();
 BA.debugLineNum = 399;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 400;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(32768);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 401;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(65536);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 402;BA.debugLine="showInfoPage(7)";
Debug.ShouldStop(131072);
_showinfopage(BA.numberCast(int.class, 7));
 BA.debugLineNum = 403;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 405;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 10;BA.debugLine="Public kvsPref As KeyValueStore";
mainactivity._kvspref = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 11;BA.debugLine="Public format24h As Boolean = False";
mainactivity._format24h = mainactivity.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showinfopage(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("showInfoPage (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,184);
if (RapidSub.canDelegate("showinfopage")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","showinfopage", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 184;BA.debugLine="Private Sub showInfoPage(page As Int)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 185;BA.debugLine="infoPage = page";
Debug.ShouldStop(16777216);
mainactivity._infopage = _page;
 BA.debugLineNum = 186;BA.debugLine="Select page";
Debug.ShouldStop(33554432);
switch (BA.switchObjectToInt(_page,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9))) {
case 0: {
 BA.debugLineNum = 188;BA.debugLine="infoTitleLbl.Text = \"Calendar\"";
Debug.ShouldStop(134217728);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Calendar"));
 BA.debugLineNum = 189;BA.debugLine="infoDescLbl.Text = \"The calendar comes in three";
Debug.ShouldStop(268435456);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The calendar comes in three views to match however you like to plan. The Schedule view lets you see all your upcoming days at a glance, with major events and to-do items laid out on a timeline. The Day view shows you the full timeline for a single day, where you can add events, tasks, or birthdays, and color-coded backgrounds make each type of entry easy to tell apart. The Month view presents the classic calendar layout, complete with a month and year spinner to jump around quickly, a sneak peek of events on each day's cell, and neighboring dates filling in the empty cells so the grid always looks complete."));
 break; }
case 1: {
 BA.debugLineNum = 191;BA.debugLine="infoTitleLbl.Text = \"Clock\"";
Debug.ShouldStop(1073741824);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Clock"));
 BA.debugLineNum = 192;BA.debugLine="infoDescLbl.Text = \"The clock keeps you on time";
Debug.ShouldStop(-2147483648);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The clock keeps you on time and on task all in one place. A format button lets you switch between clock displays to whatever you prefer. It also comes with a built-in Pomodoro timer to help you stay focused and productive, and if the default durations don't work for you, you can freely adjust them to fit your own rhythm."));
 break; }
case 2: {
 BA.debugLineNum = 194;BA.debugLine="infoTitleLbl.Text = \"Corkboard\"";
Debug.ShouldStop(2);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Corkboard"));
 BA.debugLineNum = 195;BA.debugLine="infoDescLbl.Text = \"The corkboard gives you a c";
Debug.ShouldStop(4);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The corkboard gives you a creative space to pin your thoughts and ideas. You can place sticky notes in a variety of colors to keep things visually organized and easy to tell apart. Images from your gallery can be attached right onto the board for extra context or inspiration. And when words and notes aren't enough, you can open up a drawable canvas with a selection of colored pens and sketch, doodle, or diagram anything you have in mind."));
 break; }
case 3: {
 BA.debugLineNum = 197;BA.debugLine="infoTitleLbl.Text = \"Flashcards\"";
Debug.ShouldStop(16);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Flashcards"));
 BA.debugLineNum = 198;BA.debugLine="infoDescLbl.Text = \"The flashcard feature organ";
Debug.ShouldStop(32);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The flashcard feature organizes your cards into decks and subdecks, and you have the freedom to add, rename, or delete any of them — with a confirmation before anything gets deleted for good. Cards are automatically shuffled so every session feels fresh. A progress bar and percentage track how far you've made it through a deck, and when you're ready to dive back in, two buttons have you covered — restart the entire deck from scratch, or continue right where you left off."));
 break; }
case 4: {
 BA.debugLineNum = 200;BA.debugLine="infoTitleLbl.Text = \"Music Player\"";
Debug.ShouldStop(128);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Music Player"));
 BA.debugLineNum = 201;BA.debugLine="infoDescLbl.Text = \"The music player plays the";
Debug.ShouldStop(256);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The music player plays the music on startup, meaning the app greets you with songs! Filled with chill, lo-fi tracks, you have the freedom to choose what track you want to play--either through the previous/next song buttons, or through the list of songs below where you can click on whatever chooses your fancy. There's a segment of the song that you want to listen to again or you want to zoom through a certain bit of a song? The seek bar presents itself to you where you can navigate within the music.  "));
 break; }
case 5: {
 BA.debugLineNum = 203;BA.debugLine="infoTitleLbl.Text = \"Notepad\"";
Debug.ShouldStop(1024);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Notepad"));
 BA.debugLineNum = 204;BA.debugLine="infoDescLbl.Text = \"The notepad keeps all your";
Debug.ShouldStop(2048);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The notepad keeps all your notes in one tidy list that's easy to browse through. A search bar lets you quickly find any note by its title or tags, so nothing ever gets lost in the pile. Adding a new note is simple — just give it a title, attach some tags to keep things organized, and write away to your heart's content."));
 break; }
case 6: {
 BA.debugLineNum = 206;BA.debugLine="infoTitleLbl.Text = \"To-do List\"";
Debug.ShouldStop(8192);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("To-do List"));
 BA.debugLineNum = 207;BA.debugLine="infoDescLbl.Text = \"The to-do list enables you";
Debug.ShouldStop(16384);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The to-do list enables you to create lists with titles and, especially, tasks you want or are obligated to do. You are able to keep a lot of lists that you can easily navigate through the left side of your screen. The task section is a checklist of your tasks that you input, and once achieved, you can tick it off the list. The to-do list will also show you your progress in the list."));
 break; }
case 7: {
 BA.debugLineNum = 209;BA.debugLine="infoTitleLbl.Text = \"Themes\"";
Debug.ShouldStop(65536);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Themes"));
 BA.debugLineNum = 210;BA.debugLine="infoDescLbl.Text = \"Themes let you put your own";
Debug.ShouldStop(131072);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("Themes let you put your own fun twist on the app. Choose from a range of styles and color schemes to dress up your experience, making the space you study and plan in feel a little more like yours."));
 break; }
case 8: {
 BA.debugLineNum = 212;BA.debugLine="infoTitleLbl.Text = \"Lamp\"";
Debug.ShouldStop(524288);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Lamp"));
 BA.debugLineNum = 213;BA.debugLine="infoDescLbl.Text = \"The lamp gives you control";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("The lamp gives you control over how the app looks in any lighting. Switch effortlessly between light mode for bright environments and dark mode for low-light settings, so your eyes stay comfortable no matter when or where you're working."));
 break; }
case 9: {
 BA.debugLineNum = 215;BA.debugLine="infoTitleLbl.Text = \"Navigation\"";
Debug.ShouldStop(4194304);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Navigation"));
 BA.debugLineNum = 216;BA.debugLine="infoDescLbl.Text = \"Navigation is your home bas";
Debug.ShouldStop(8388608);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setText",BA.ObjectToCharSequence("Navigation is your home base for getting around the app. All of the app's features are laid out in one accessible spot, with clearly labeled and easy-to-read buttons so you can jump to wherever you need to be without any hassle."));
 break; }
}
;
 BA.debugLineNum = 220;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("showInfoPopup (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,152);
if (RapidSub.canDelegate("showinfopopup")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","showinfopopup");}
RemoteObject _closebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 152;BA.debugLine="Private Sub showInfoPopup";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 154;BA.debugLine="infoPnl = xui.CreatePanel(\"infoPnl\")";
Debug.ShouldStop(33554432);
mainactivity.mostCurrent._infopnl = mainactivity._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("infoPnl")));
 BA.debugLineNum = 155;BA.debugLine="Activity.AddView(infoPnl, 75dip, 225dip, 300dip,";
Debug.ShouldStop(67108864);
mainactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infopnl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 75)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220)))));
 BA.debugLineNum = 156;BA.debugLine="infoPnl.SetColorAndBorder(xui.Color_White, 2dip,";
Debug.ShouldStop(134217728);
mainactivity.mostCurrent._infopnl.runVoidMethod ("SetColorAndBorder",(Object)(mainactivity._xui.getField(true,"Color_White")),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(mainactivity._xui.getField(true,"Color_Black")),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 158;BA.debugLine="Dim closeBtn As Button";
Debug.ShouldStop(536870912);
_closebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("closeBtn", _closebtn);
 BA.debugLineNum = 159;BA.debugLine="closeBtn.Initialize(\"infoPnlClose\")";
Debug.ShouldStop(1073741824);
_closebtn.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("infoPnlClose")));
 BA.debugLineNum = 160;BA.debugLine="closeBtn.Text = \"x\"";
Debug.ShouldStop(-2147483648);
_closebtn.runMethod(true,"setText",BA.ObjectToCharSequence("x"));
 BA.debugLineNum = 161;BA.debugLine="closeBtn.TextSize = 6";
Debug.ShouldStop(1);
_closebtn.runMethod(true,"setTextSize",BA.numberCast(float.class, 6));
 BA.debugLineNum = 162;BA.debugLine="infoPnl.AddView(closeBtn, 265dip, 8dip, 28dip, 28";
Debug.ShouldStop(2);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((_closebtn.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 265)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 28)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 28)))));
 BA.debugLineNum = 164;BA.debugLine="infoTitleLbl.Initialize(\"\")";
Debug.ShouldStop(8);
mainactivity.mostCurrent._infotitlelbl.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 165;BA.debugLine="infoTitleLbl.TextSize = 16";
Debug.ShouldStop(16);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 166;BA.debugLine="infoTitleLbl.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(32);
mainactivity.mostCurrent._infotitlelbl.runMethod(true,"setGravity",mainactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 167;BA.debugLine="infoPnl.AddView(infoTitleLbl, 12dip, 12dip, 248di";
Debug.ShouldStop(64);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infotitlelbl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 248)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 169;BA.debugLine="infoDescLbl.Initialize(\"\")";
Debug.ShouldStop(256);
mainactivity.mostCurrent._infodesclbl.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 170;BA.debugLine="infoDescLbl.TextSize = 11";
Debug.ShouldStop(512);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 171;BA.debugLine="infoDescLbl.Gravity = Gravity.TOP";
Debug.ShouldStop(1024);
mainactivity.mostCurrent._infodesclbl.runMethod(true,"setGravity",mainactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 172;BA.debugLine="infoDescLbl.SingleLine = False";
Debug.ShouldStop(2048);
mainactivity.mostCurrent._infodesclbl.runVoidMethod ("setSingleLine",mainactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 173;BA.debugLine="infoPnl.AddView(infoDescLbl, 12dip, 52dip, 276dip";
Debug.ShouldStop(4096);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infodesclbl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 52)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 276)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))));
 BA.debugLineNum = 175;BA.debugLine="infoPageLbl.Initialize(\"\")";
Debug.ShouldStop(16384);
mainactivity.mostCurrent._infopagelbl.runVoidMethod ("Initialize",mainactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 176;BA.debugLine="infoPageLbl.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(32768);
mainactivity.mostCurrent._infopagelbl.runMethod(true,"setGravity",mainactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 177;BA.debugLine="infoPageLbl.TextSize = 11";
Debug.ShouldStop(65536);
mainactivity.mostCurrent._infopagelbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 178;BA.debugLine="infoPnl.AddView(infoPageLbl, 95dip, 184dip, 110di";
Debug.ShouldStop(131072);
mainactivity.mostCurrent._infopnl.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._infopagelbl.getObject())),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 95)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 184)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 22)))));
 BA.debugLineNum = 181;BA.debugLine="showInfoPage(0)";
Debug.ShouldStop(1048576);
_showinfopage(BA.numberCast(int.class, 0));
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("timerClock_Tick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,146);
if (RapidSub.canDelegate("timerclock_tick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","timerclock_tick");}
 BA.debugLineNum = 146;BA.debugLine="Sub timerClock_Tick";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="clockBtn.Text = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(262144);
mainactivity.mostCurrent._clockbtn.runMethod(true,"setText",BA.ObjectToCharSequence(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 148;BA.debugLine="clockLightBtn.Text = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(524288);
mainactivity.mostCurrent._clocklightbtn.runMethod(true,"setText",BA.ObjectToCharSequence(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(mainactivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("todolistBtn_Click (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,242);
if (RapidSub.canDelegate("todolistbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","todolistbtn_click");}
 BA.debugLineNum = 242;BA.debugLine="Private Sub todolistBtn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="StartActivity(todoActivity)";
Debug.ShouldStop(262144);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._todoactivity.getObject())));
 BA.debugLineNum = 244;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _todolistbtn_longclick() throws Exception{
try {
		Debug.PushSubsStack("todolistBtn_LongClick (mainactivity) ","mainactivity",2,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,387);
if (RapidSub.canDelegate("todolistbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","todolistbtn_longclick");}
 BA.debugLineNum = 387;BA.debugLine="Private Sub todolistBtn_LongClick";
Debug.ShouldStop(4);
 BA.debugLineNum = 388;BA.debugLine="showInfoPopup";
Debug.ShouldStop(8);
_showinfopopup();
 BA.debugLineNum = 389;BA.debugLine="If infoPnl <> Null Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("N",mainactivity.mostCurrent._infopnl)) { 
 BA.debugLineNum = 390;BA.debugLine="infoPnl.Visible = True";
Debug.ShouldStop(32);
mainactivity.mostCurrent._infopnl.runMethod(true,"setVisible",mainactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 391;BA.debugLine="infoPnl.BringToFront";
Debug.ShouldStop(64);
mainactivity.mostCurrent._infopnl.runVoidMethod ("BringToFront");
 BA.debugLineNum = 392;BA.debugLine="showInfoPage(6)";
Debug.ShouldStop(128);
_showinfopage(BA.numberCast(int.class, 6));
 BA.debugLineNum = 393;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 395;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}