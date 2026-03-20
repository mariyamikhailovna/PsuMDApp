package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class clockactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (clockactivity) ","clockactivity",2,clockactivity.mostCurrent.activityBA,clockactivity.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.clockactivity.remoteMe.runUserSub(false, "clockactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",clockactivity.mostCurrent._starter._darkmode /*RemoteObject*/ ,clockactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"clocklayout\")";
Debug.ShouldStop(524288);
clockactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("clocklayout")),clockactivity.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"clocklayoutDark\")";
Debug.ShouldStop(2097152);
clockactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("clocklayoutDark")),clockactivity.mostCurrent.activityBA);
 };
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (clockactivity) ","clockactivity",2,clockactivity.mostCurrent.activityBA,clockactivity.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.clockactivity.remoteMe.runUserSub(false, "clockactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (clockactivity) ","clockactivity",2,clockactivity.mostCurrent.activityBA,clockactivity.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.clockactivity.remoteMe.runUserSub(false, "clockactivity","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("exitBtn_Click (clockactivity) ","clockactivity",2,clockactivity.mostCurrent.activityBA,clockactivity.mostCurrent,36);
if (RapidSub.canDelegate("exitbtn_click")) { return b4a.example.clockactivity.remoteMe.runUserSub(false, "clockactivity","exitbtn_click");}
 BA.debugLineNum = 36;BA.debugLine="Private Sub exitBtn_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
clockactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}