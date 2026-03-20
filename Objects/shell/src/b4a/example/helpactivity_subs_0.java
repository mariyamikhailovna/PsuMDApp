package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class helpactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"helpAct\")";
Debug.ShouldStop(8388608);
helpactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("helpAct")),helpactivity.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="showHelpPage(0)";
Debug.ShouldStop(16777216);
_showhelppage(BA.numberCast(int.class, 0));
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
		Debug.PushSubsStack("Activity_Pause (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,32);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,28);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_resume");}
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backBtn_Click (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,68);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","backbtn_click");}
 BA.debugLineNum = 68;BA.debugLine="Sub backBtn_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="If helpPage > 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",helpactivity._helppage,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 70;BA.debugLine="showHelpPage(helpPage - 1)";
Debug.ShouldStop(32);
_showhelppage(RemoteObject.solve(new RemoteObject[] {helpactivity._helppage,RemoteObject.createImmutable(1)}, "-",1, 1));
 };
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _closedashi_click() throws Exception{
try {
		Debug.PushSubsStack("closedaShi_Click (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,74);
if (RapidSub.canDelegate("closedashi_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","closedashi_click");}
 BA.debugLineNum = 74;BA.debugLine="Sub closedaShi_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1024);
helpactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 //BA.debugLineNum = 16;BA.debugLine="Private titleLbl As Label";
helpactivity.mostCurrent._titlelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private descriptionLbl As Label";
helpactivity.mostCurrent._descriptionlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private backBtn As Button";
helpactivity.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private nextBtn As Button";
helpactivity.mostCurrent._nextbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _nextbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nextBtn_Click (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,62);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","nextbtn_click");}
 BA.debugLineNum = 62;BA.debugLine="Sub nextBtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="If helpPage < 3 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("<",helpactivity._helppage,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 64;BA.debugLine="showHelpPage(helpPage + 1)";
Debug.ShouldStop(-2147483648);
_showhelppage(RemoteObject.solve(new RemoteObject[] {helpactivity._helppage,RemoteObject.createImmutable(1)}, "+",1, 1));
 };
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim helpPage As Int = 0";
helpactivity._helppage = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showhelppage(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("showHelpPage (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,36);
if (RapidSub.canDelegate("showhelppage")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","showhelppage", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 36;BA.debugLine="Sub showHelpPage(page As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="helpPage = page";
Debug.ShouldStop(16);
helpactivity._helppage = _page;
 BA.debugLineNum = 39;BA.debugLine="Select page";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(_page,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 41;BA.debugLine="titleLbl.Text = \"Welcome\"";
Debug.ShouldStop(256);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Welcome"));
 BA.debugLineNum = 42;BA.debugLine="descriptionLbl.Text = \"This app is tailor-made";
Debug.ShouldStop(512);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("This app is tailor-made for students—or anyone who wants to learn. It has all the features you'll need in order to learn effectively!"));
 break; }
case 1: {
 BA.debugLineNum = 45;BA.debugLine="titleLbl.Text = \"Clock\"";
Debug.ShouldStop(4096);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Clock"));
 BA.debugLineNum = 46;BA.debugLine="descriptionLbl.Text = \"This is the pomodoro fea";
Debug.ShouldStop(8192);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("This is the pomodoro feature, explanation goes here yada yada"));
 break; }
case 2: {
 BA.debugLineNum = 49;BA.debugLine="titleLbl.Text = \"Notetaking\"";
Debug.ShouldStop(65536);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Notetaking"));
 BA.debugLineNum = 50;BA.debugLine="descriptionLbl.Text = \"We take notes here, and";
Debug.ShouldStop(131072);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("We take notes here, and we save em."));
 break; }
case 3: {
 BA.debugLineNum = 53;BA.debugLine="titleLbl.Text = \"Minions\"";
Debug.ShouldStop(1048576);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Minions"));
 BA.debugLineNum = 54;BA.debugLine="descriptionLbl.Text = \"Can we just praise Bob?";
Debug.ShouldStop(2097152);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("Can we just praise Bob? I love the guy"));
 break; }
}
;
 BA.debugLineNum = 58;BA.debugLine="backBtn.Enabled = (page > 0)";
Debug.ShouldStop(33554432);
helpactivity.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean(">",_page,BA.numberCast(double.class, 0)))));
 BA.debugLineNum = 59;BA.debugLine="nextBtn.Enabled = (page < 3)";
Debug.ShouldStop(67108864);
helpactivity.mostCurrent._nextbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean("<",_page,BA.numberCast(double.class, 3)))));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}