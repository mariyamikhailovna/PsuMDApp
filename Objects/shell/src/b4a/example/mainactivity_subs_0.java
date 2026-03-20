package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class mainactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,14);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 14;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="regLayout = xui.CreatePanel(\"\")";
Debug.ShouldStop(16384);
mainactivity.mostCurrent._reglayout = mainactivity._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 16;BA.debugLine="darkModeLayout = xui.CreatePanel(\"\")";
Debug.ShouldStop(32768);
mainactivity.mostCurrent._darkmodelayout = mainactivity._xui.runMethod(false,"CreatePanel",mainactivity.processBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 18;BA.debugLine="Activity.AddView(darkModeLayout, 0, 0, 100%x, 100";
Debug.ShouldStop(131072);
mainactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._darkmodelayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA)),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA)));
 BA.debugLineNum = 19;BA.debugLine="Activity.AddView(regLayout, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(262144);
mainactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((mainactivity.mostCurrent._reglayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA)),(Object)(mainactivity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),mainactivity.mostCurrent.activityBA)));
 BA.debugLineNum = 21;BA.debugLine="regLayout.LoadLayout(\"Layout\")";
Debug.ShouldStop(1048576);
mainactivity.mostCurrent._reglayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\")";
Debug.ShouldStop(2097152);
mainactivity.mostCurrent._darkmodelayout.runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("Layout2")),mainactivity.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,29);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Resume (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,25);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","activity_resume");}
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("clockBtn_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,55);
if (RapidSub.canDelegate("clockbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clockbtn_click");}
 BA.debugLineNum = 55;BA.debugLine="Private Sub clockBtn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="StartActivity(clockActivity)";
Debug.ShouldStop(8388608);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._clockactivity.getObject())));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("clockBtn_LongClick (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,59);
if (RapidSub.canDelegate("clockbtn_longclick")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","clockbtn_longclick");}
 BA.debugLineNum = 59;BA.debugLine="Private Sub clockBtn_LongClick";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("dlamp_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,43);
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
		Debug.PushSubsStack("dlamp_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,43);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 44;BA.debugLine="Starter.darkMode = False";
Debug.ShouldStop(2048);
parent.mostCurrent._starter._darkmode /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 45;BA.debugLine="regLayout.Visible = True";
Debug.ShouldStop(4096);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 46;BA.debugLine="regLayout.Alpha = 0";
Debug.ShouldStop(8192);
parent.mostCurrent._reglayout.runMethod(true,"setAlpha",BA.numberCast(float.class, 0));
 BA.debugLineNum = 47;BA.debugLine="regLayout.SetAlphaAnimated(250, 1)";
Debug.ShouldStop(16384);
parent.mostCurrent._reglayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 48;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 0)";
Debug.ShouldStop(32768);
parent.mostCurrent._darkmodelayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 49;BA.debugLine="Sleep(250)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "dlamp_click"),BA.numberCast(int.class, 250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 50;BA.debugLine="darkModeLayout.Visible = False";
Debug.ShouldStop(131072);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Dim regLayout, darkModeLayout As B4XView";
mainactivity.mostCurrent._reglayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
mainactivity.mostCurrent._darkmodelayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _helpbtn_click() throws Exception{
try {
		Debug.PushSubsStack("helpBtn_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,67);
if (RapidSub.canDelegate("helpbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","helpbtn_click");}
 BA.debugLineNum = 67;BA.debugLine="Private Sub helpBtn_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="StartActivity(helpActivity)";
Debug.ShouldStop(8);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._helpactivity.getObject())));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("lamp_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,33);
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
		Debug.PushSubsStack("lamp_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,33);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 34;BA.debugLine="Starter.darkMode = True";
Debug.ShouldStop(2);
parent.mostCurrent._starter._darkmode /*RemoteObject*/  = parent.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 35;BA.debugLine="darkModeLayout.Visible = True";
Debug.ShouldStop(4);
parent.mostCurrent._darkmodelayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 36;BA.debugLine="darkModeLayout.Alpha = 0";
Debug.ShouldStop(8);
parent.mostCurrent._darkmodelayout.runMethod(true,"setAlpha",BA.numberCast(float.class, 0));
 BA.debugLineNum = 37;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 1)";
Debug.ShouldStop(16);
parent.mostCurrent._darkmodelayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 1)));
 BA.debugLineNum = 38;BA.debugLine="regLayout.SetAlphaAnimated(250, 0)";
Debug.ShouldStop(32);
parent.mostCurrent._reglayout.runVoidMethod ("SetAlphaAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 39;BA.debugLine="Sleep(250)";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("Sleep",mainactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "mainactivity", "lamp_click"),BA.numberCast(int.class, 250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 40;BA.debugLine="regLayout.Visible = False";
Debug.ShouldStop(128);
parent.mostCurrent._reglayout.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
public static RemoteObject  _navbtn_click() throws Exception{
try {
		Debug.PushSubsStack("navBtn_Click (mainactivity) ","mainactivity",5,mainactivity.mostCurrent.activityBA,mainactivity.mostCurrent,63);
if (RapidSub.canDelegate("navbtn_click")) { return b4a.example.mainactivity.remoteMe.runUserSub(false, "mainactivity","navbtn_click");}
 BA.debugLineNum = 63;BA.debugLine="Private Sub navBtn_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="StartActivity(navActivity)";
Debug.ShouldStop(-2147483648);
mainactivity.mostCurrent.__c.runVoidMethod ("StartActivity",mainactivity.processBA,(Object)((mainactivity.mostCurrent._navactivity.getObject())));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}