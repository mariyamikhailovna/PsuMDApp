package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class navactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"navAct\")";
Debug.ShouldStop(524288);
navactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("navAct")),navactivity.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_Pause (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Resume (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,24);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","activity_resume");}
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calendarbtn_click() throws Exception{
try {
		Debug.PushSubsStack("calendarBtn_Click (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,33);
if (RapidSub.canDelegate("calendarbtn_click")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","calendarbtn_click");}
 BA.debugLineNum = 33;BA.debugLine="Private Sub calendarBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="StartActivity(CalendarActivity)";
Debug.ShouldStop(2);
navactivity.mostCurrent.__c.runVoidMethod ("StartActivity",navactivity.processBA,(Object)((navactivity.mostCurrent._calendaractivity.getObject())));
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clkbtn_click() throws Exception{
try {
		Debug.PushSubsStack("clkBtn_Click (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,37);
if (RapidSub.canDelegate("clkbtn_click")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","clkbtn_click");}
 BA.debugLineNum = 37;BA.debugLine="Private Sub clkBtn_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="StartActivity(clockActivity)";
Debug.ShouldStop(32);
navactivity.mostCurrent.__c.runVoidMethod ("StartActivity",navactivity.processBA,(Object)((navactivity.mostCurrent._clockactivity.getObject())));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _corkpadbtn_click() throws Exception{
try {
		Debug.PushSubsStack("corkpadBtn_Click (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,41);
if (RapidSub.canDelegate("corkpadbtn_click")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","corkpadbtn_click");}
 BA.debugLineNum = 41;BA.debugLine="Private Sub corkpadBtn_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="StartActivity(corkActivity)";
Debug.ShouldStop(512);
navactivity.mostCurrent.__c.runVoidMethod ("StartActivity",navactivity.processBA,(Object)((navactivity.mostCurrent._corkactivity.getObject())));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _exitbtn_click() throws Exception{
try {
		Debug.PushSubsStack("exitBtn_Click (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,61);
if (RapidSub.canDelegate("exitbtn_click")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","exitbtn_click");}
 BA.debugLineNum = 61;BA.debugLine="Private Sub exitBtn_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="Activity.Finish";
Debug.ShouldStop(536870912);
navactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _flashbtn_click() throws Exception{
try {
		Debug.PushSubsStack("flashBtn_Click (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,45);
if (RapidSub.canDelegate("flashbtn_click")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","flashbtn_click");}
 BA.debugLineNum = 45;BA.debugLine="Private Sub flashBtn_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="StartActivity(FlashcardActivity)";
Debug.ShouldStop(8192);
navactivity.mostCurrent.__c.runVoidMethod ("StartActivity",navactivity.processBA,(Object)((navactivity.mostCurrent._flashcardactivity.getObject())));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _ntpdbtn_click() throws Exception{
try {
		Debug.PushSubsStack("ntpdBtn_Click (navactivity) ","navactivity",3,navactivity.mostCurrent.activityBA,navactivity.mostCurrent,53);
if (RapidSub.canDelegate("ntpdbtn_click")) { return b4a.example.navactivity.remoteMe.runUserSub(false, "navactivity","ntpdbtn_click");}
 BA.debugLineNum = 53;BA.debugLine="Private Sub ntpdBtn_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="StartActivity(noteActivity)";
Debug.ShouldStop(2097152);
navactivity.mostCurrent.__c.runVoidMethod ("StartActivity",navactivity.processBA,(Object)((navactivity.mostCurrent._noteactivity.getObject())));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}