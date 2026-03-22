package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class week_module_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"Layout2\")";
Debug.ShouldStop(4194304);
week_module.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout2")),week_module.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="Week_btn.Color = Colors.blue";
Debug.ShouldStop(8388608);
week_module.mostCurrent._week_btn.runVoidMethod ("setColor",week_module.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,32);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,28);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","activity_resume");}
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _day_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Day_btn_Click (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,46);
if (RapidSub.canDelegate("day_btn_click")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","day_btn_click");}
RemoteObject _currentyear = RemoteObject.createImmutable(0);
RemoteObject _currentmonth = RemoteObject.createImmutable(0);
RemoteObject _currentday = RemoteObject.createImmutable(0);
 BA.debugLineNum = 46;BA.debugLine="Private Sub Day_btn_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTim";
Debug.ShouldStop(16384);
_currentyear = week_module.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(week_module.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentyear", _currentyear);Debug.locals.put("currentyear", _currentyear);
 BA.debugLineNum = 48;BA.debugLine="Dim currentmonth As Int = DateTime.GetMonth(DateT";
Debug.ShouldStop(32768);
_currentmonth = week_module.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(week_module.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentmonth", _currentmonth);Debug.locals.put("currentmonth", _currentmonth);
 BA.debugLineNum = 49;BA.debugLine="Dim currentday As Int = DateTime.GetDayOfMonth(Da";
Debug.ShouldStop(65536);
_currentday = week_module.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(week_module.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentday", _currentday);Debug.locals.put("currentday", _currentday);
 BA.debugLineNum = 50;BA.debugLine="Day_MODULE.currentDate = currentyear & \"-\" & curr";
Debug.ShouldStop(131072);
week_module.mostCurrent._day_module._currentdate /*RemoteObject*/  = RemoteObject.concat(_currentyear,RemoteObject.createImmutable("-"),_currentmonth,RemoteObject.createImmutable("-"),_currentday);
 BA.debugLineNum = 51;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
week_module.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 52;BA.debugLine="StartActivity(Day_MODULE)";
Debug.ShouldStop(524288);
week_module.mostCurrent.__c.runVoidMethod ("StartActivity",week_module.processBA,(Object)((week_module.mostCurrent._day_module.getObject())));
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 16;BA.debugLine="Private menupanel As Panel";
week_module.mostCurrent._menupanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Week_btn As Button";
week_module.mostCurrent._week_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _menu_btn_click() throws Exception{
try {
		Debug.PushSubsStack("menu_btn_Click (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,36);
if (RapidSub.canDelegate("menu_btn_click")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","menu_btn_click");}
 BA.debugLineNum = 36;BA.debugLine="Private Sub menu_btn_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="menupanel.Visible =True";
Debug.ShouldStop(16);
week_module.mostCurrent._menupanel.runMethod(true,"setVisible",week_module.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _month_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Month_btn_Click (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,59);
if (RapidSub.canDelegate("month_btn_click")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","month_btn_click");}
 BA.debugLineNum = 59;BA.debugLine="Private Sub Month_btn_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="Activity.Finish";
Debug.ShouldStop(134217728);
week_module.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 61;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(268435456);
week_module.mostCurrent.__c.runVoidMethod ("StartActivity",week_module.processBA,(Object)((week_module.mostCurrent._main.getObject())));
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
public static RemoteObject  _sched_btn_click() throws Exception{
try {
		Debug.PushSubsStack("sched_btn_Click (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,41);
if (RapidSub.canDelegate("sched_btn_click")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","sched_btn_click");}
 BA.debugLineNum = 41;BA.debugLine="Private Sub sched_btn_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
week_module.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 43;BA.debugLine="StartActivity(Schedule_MODULE)";
Debug.ShouldStop(1024);
week_module.mostCurrent.__c.runVoidMethod ("StartActivity",week_module.processBA,(Object)((week_module.mostCurrent._schedule_module.getObject())));
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _week_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Week_btn_Click (week_module) ","week_module",2,week_module.mostCurrent.activityBA,week_module.mostCurrent,55);
if (RapidSub.canDelegate("week_btn_click")) { return b4a.example.week_module.remoteMe.runUserSub(false, "week_module","week_btn_click");}
 BA.debugLineNum = 55;BA.debugLine="Private Sub Week_btn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="menupanel.visible = False";
Debug.ShouldStop(8388608);
week_module.mostCurrent._menupanel.runMethod(true,"setVisible",week_module.mostCurrent.__c.getField(true,"False"));
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
}