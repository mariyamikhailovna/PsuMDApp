package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class test_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (test) ","test",2,test.mostCurrent.activityBA,test.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.test.remoteMe.runUserSub(false, "test","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="Activity.LoadLayout(\"test\")";
Debug.ShouldStop(262144);
test.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("test")),test.mostCurrent.activityBA);
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Pause (test) ","test",2,test.mostCurrent.activityBA,test.mostCurrent,26);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.test.remoteMe.runUserSub(false, "test","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Resume (test) ","test",2,test.mostCurrent.activityBA,test.mostCurrent,22);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.test.remoteMe.runUserSub(false, "test","activity_resume");}
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (test) ","test",2,test.mostCurrent.activityBA,test.mostCurrent,31);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.test.remoteMe.runUserSub(false, "test","button2_click");}
 BA.debugLineNum = 31;BA.debugLine="Private Sub Button2_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Activity.Finish";
Debug.ShouldStop(-2147483648);
test.mostCurrent._activity.runVoidMethod ("Finish");
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