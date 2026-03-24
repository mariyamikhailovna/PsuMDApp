package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class helpactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"helpAct\")";
Debug.ShouldStop(134217728);
helpactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("helpAct")),helpactivity.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="showHelpPage(0)";
Debug.ShouldStop(268435456);
_showhelppage(BA.numberCast(int.class, 0));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,36);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,32);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_resume");}
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backBtn_Click (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,73);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","backbtn_click");}
 BA.debugLineNum = 73;BA.debugLine="Sub backBtn_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="If helpPage > 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",helpactivity._helppage,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 75;BA.debugLine="showHelpPage(helpPage - 1)";
Debug.ShouldStop(1024);
_showhelppage(RemoteObject.solve(new RemoteObject[] {helpactivity._helppage,RemoteObject.createImmutable(1)}, "-",1, 1));
 };
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("closedaShi_Click (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,79);
if (RapidSub.canDelegate("closedashi_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","closedashi_click");}
 BA.debugLineNum = 79;BA.debugLine="Sub closedaShi_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
helpactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private titleLbl As Label";
helpactivity.mostCurrent._titlelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private descriptionLbl As Label";
helpactivity.mostCurrent._descriptionlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private backBtn As Button";
helpactivity.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private nextBtn As Button";
helpactivity.mostCurrent._nextbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private helpimage As ImageView";
helpactivity.mostCurrent._helpimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _nextbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nextBtn_Click (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,67);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","nextbtn_click");}
 BA.debugLineNum = 67;BA.debugLine="Sub nextBtn_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="If helpPage < 3 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",helpactivity._helppage,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 69;BA.debugLine="showHelpPage(helpPage + 1)";
Debug.ShouldStop(16);
_showhelppage(RemoteObject.solve(new RemoteObject[] {helpactivity._helppage,RemoteObject.createImmutable(1)}, "+",1, 1));
 };
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
helpactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="Dim helpPage As Int = 0";
helpactivity._helppage = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 11;BA.debugLine="Public format24h As Boolean = False";
helpactivity._format24h = helpactivity.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 12;BA.debugLine="Public kvs As KeyValueStore";
helpactivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showhelppage(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("showHelpPage (helpactivity) ","helpactivity",4,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,40);
if (RapidSub.canDelegate("showhelppage")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","showhelppage", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 40;BA.debugLine="Sub showHelpPage(page As Int)";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="helpPage = page";
Debug.ShouldStop(256);
helpactivity._helppage = _page;
 BA.debugLineNum = 43;BA.debugLine="Select page";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(_page,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 45;BA.debugLine="titleLbl.Text = \"Welcome\"";
Debug.ShouldStop(4096);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Welcome"));
 BA.debugLineNum = 46;BA.debugLine="descriptionLbl.Text = \"This app is tailor-made";
Debug.ShouldStop(8192);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("This app is tailor-made for students—or anyone who wants to learn. It has all the features you'll need in order to learn effectively!"));
 BA.debugLineNum = 47;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(16384);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("rei.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 1: {
 BA.debugLineNum = 49;BA.debugLine="titleLbl.Text = \"Clock\"";
Debug.ShouldStop(65536);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Clock"));
 BA.debugLineNum = 50;BA.debugLine="descriptionLbl.Text = \"This is the pomodoro fea";
Debug.ShouldStop(131072);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("This is the pomodoro feature, explanation goes here yada yada"));
 BA.debugLineNum = 51;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(262144);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("psulogo.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 2: {
 BA.debugLineNum = 53;BA.debugLine="titleLbl.Text = \"Notetaking\"";
Debug.ShouldStop(1048576);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Notetaking"));
 BA.debugLineNum = 54;BA.debugLine="descriptionLbl.Text = \"We take notes here, and";
Debug.ShouldStop(2097152);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("We take notes here, and we save em."));
 BA.debugLineNum = 55;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(4194304);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("dumbass.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 3: {
 BA.debugLineNum = 57;BA.debugLine="titleLbl.Text = \"Minions\"";
Debug.ShouldStop(16777216);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Minions"));
 BA.debugLineNum = 58;BA.debugLine="descriptionLbl.Text = \"Can we just praise Bob?";
Debug.ShouldStop(33554432);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("Can we just praise Bob? I love the guy"));
 BA.debugLineNum = 59;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(67108864);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
}
;
 BA.debugLineNum = 63;BA.debugLine="backBtn.Enabled = (page > 0)";
Debug.ShouldStop(1073741824);
helpactivity.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean(">",_page,BA.numberCast(double.class, 0)))));
 BA.debugLineNum = 64;BA.debugLine="nextBtn.Enabled = (page < 3)";
Debug.ShouldStop(-2147483648);
helpactivity.mostCurrent._nextbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean("<",_page,BA.numberCast(double.class, 3)))));
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
}