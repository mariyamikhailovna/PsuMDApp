package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class themeactivity_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"themeLayout\")";
Debug.ShouldStop(16777216);
themeactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("themeLayout")),themeactivity.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="showThemePage(0)";
Debug.ShouldStop(33554432);
_showthemepage(BA.numberCast(int.class, 0));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","activity_resume");}
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _applybtn_click() throws Exception{
try {
		Debug.PushSubsStack("applyBtn_Click (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,75);
if (RapidSub.canDelegate("applybtn_click")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","applybtn_click");}
 BA.debugLineNum = 75;BA.debugLine="Sub applyBtn_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="If themePage = 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",themeactivity._themepage,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 77;BA.debugLine="Starter.themeNumber = 0";
Debug.ShouldStop(4096);
themeactivity.mostCurrent._starter._themenumber /*RemoteObject*/  = BA.numberCast(int.class, 0);
 }else 
{ BA.debugLineNum = 78;BA.debugLine="Else If themePage = 1 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",themeactivity._themepage,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 79;BA.debugLine="Starter.themeNumber = 1";
Debug.ShouldStop(16384);
themeactivity.mostCurrent._starter._themenumber /*RemoteObject*/  = BA.numberCast(int.class, 1);
 }else 
{ BA.debugLineNum = 80;BA.debugLine="Else If themePage = 2 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",themeactivity._themepage,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 81;BA.debugLine="Starter.themeNumber = 2";
Debug.ShouldStop(65536);
themeactivity.mostCurrent._starter._themenumber /*RemoteObject*/  = BA.numberCast(int.class, 2);
 }}}
;
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("backBtn_Click (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,65);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","backbtn_click");}
 BA.debugLineNum = 65;BA.debugLine="Sub backBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="If themePage > 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",themeactivity._themepage,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 67;BA.debugLine="showThemePage(themePage - 1)";
Debug.ShouldStop(4);
_showthemepage(RemoteObject.solve(new RemoteObject[] {themeactivity._themepage,RemoteObject.createImmutable(1)}, "-",1, 1));
 };
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
public static RemoteObject  _closehelp_click() throws Exception{
try {
		Debug.PushSubsStack("closeHelp_Click (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,71);
if (RapidSub.canDelegate("closehelp_click")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","closehelp_click");}
 BA.debugLineNum = 71;BA.debugLine="Sub closeHelp_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
themeactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 73;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private titleLbl As Label";
themeactivity.mostCurrent._titlelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private backBtn As Button";
themeactivity.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private nextBtn As Button";
themeactivity.mostCurrent._nextbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private theme1 As ImageView";
themeactivity.mostCurrent._theme1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private theme2 As ImageView";
themeactivity.mostCurrent._theme2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _nextbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nextBtn_Click (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,59);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","nextbtn_click");}
 BA.debugLineNum = 59;BA.debugLine="Sub nextBtn_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="If themePage < 2 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",themeactivity._themepage,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 61;BA.debugLine="showThemePage(themePage + 1)";
Debug.ShouldStop(268435456);
_showthemepage(RemoteObject.solve(new RemoteObject[] {themeactivity._themepage,RemoteObject.createImmutable(1)}, "+",1, 1));
 };
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim themePage As Int = 0";
themeactivity._themepage = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim xui As XUI";
themeactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showthemepage(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("showThemePage (themeactivity) ","themeactivity",9,themeactivity.mostCurrent.activityBA,themeactivity.mostCurrent,37);
if (RapidSub.canDelegate("showthemepage")) { return b4a.example.themeactivity.remoteMe.runUserSub(false, "themeactivity","showthemepage", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 37;BA.debugLine="Sub showThemePage(page As Int)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="themePage = page";
Debug.ShouldStop(64);
themeactivity._themepage = _page;
 BA.debugLineNum = 41;BA.debugLine="Select page";
Debug.ShouldStop(256);
switch (BA.switchObjectToInt(_page,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 43;BA.debugLine="titleLbl.Text = \"Default Theme\"";
Debug.ShouldStop(1024);
themeactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Default Theme"));
 BA.debugLineNum = 44;BA.debugLine="theme1.Bitmap = xui.LoadBitmapResize(File.DirAss";
Debug.ShouldStop(2048);
themeactivity.mostCurrent._theme1.runMethod(false,"setBitmap",(themeactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(themeactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(themeactivity.mostCurrent._theme1.runMethod(true,"getWidth")),(Object)(themeactivity.mostCurrent._theme1.runMethod(true,"getHeight")),(Object)(themeactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 45;BA.debugLine="theme2.Bitmap = xui.LoadBitmapResize(File.DirAss";
Debug.ShouldStop(4096);
themeactivity.mostCurrent._theme2.runMethod(false,"setBitmap",(themeactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(themeactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(themeactivity.mostCurrent._theme2.runMethod(true,"getWidth")),(Object)(themeactivity.mostCurrent._theme2.runMethod(true,"getHeight")),(Object)(themeactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 1: {
 BA.debugLineNum = 47;BA.debugLine="titleLbl.Text = \"Y2K Aero\"";
Debug.ShouldStop(16384);
themeactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Y2K Aero"));
 BA.debugLineNum = 48;BA.debugLine="theme1.Bitmap = xui.LoadBitmapResize(File.DirAss";
Debug.ShouldStop(32768);
themeactivity.mostCurrent._theme1.runMethod(false,"setBitmap",(themeactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(themeactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(themeactivity.mostCurrent._theme1.runMethod(true,"getWidth")),(Object)(themeactivity.mostCurrent._theme1.runMethod(true,"getHeight")),(Object)(themeactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 49;BA.debugLine="theme2.Bitmap = xui.LoadBitmapResize(File.DirAss";
Debug.ShouldStop(65536);
themeactivity.mostCurrent._theme2.runMethod(false,"setBitmap",(themeactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(themeactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(themeactivity.mostCurrent._theme2.runMethod(true,"getWidth")),(Object)(themeactivity.mostCurrent._theme2.runMethod(true,"getHeight")),(Object)(themeactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 2: {
 BA.debugLineNum = 51;BA.debugLine="titleLbl.Text = \"Pixelated Rustic\"";
Debug.ShouldStop(262144);
themeactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Pixelated Rustic"));
 BA.debugLineNum = 52;BA.debugLine="theme1.Bitmap = xui.LoadBitmapResize(File.DirAss";
Debug.ShouldStop(524288);
themeactivity.mostCurrent._theme1.runMethod(false,"setBitmap",(themeactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(themeactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(themeactivity.mostCurrent._theme1.runMethod(true,"getWidth")),(Object)(themeactivity.mostCurrent._theme1.runMethod(true,"getHeight")),(Object)(themeactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 53;BA.debugLine="theme2.Bitmap = xui.LoadBitmapResize(File.DirAss";
Debug.ShouldStop(1048576);
themeactivity.mostCurrent._theme2.runMethod(false,"setBitmap",(themeactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(themeactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(themeactivity.mostCurrent._theme2.runMethod(true,"getWidth")),(Object)(themeactivity.mostCurrent._theme2.runMethod(true,"getHeight")),(Object)(themeactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
}
;
 BA.debugLineNum = 55;BA.debugLine="backBtn.Enabled = (page > 0)";
Debug.ShouldStop(4194304);
themeactivity.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean(">",_page,BA.numberCast(double.class, 0)))));
 BA.debugLineNum = 56;BA.debugLine="nextBtn.Enabled = (page < 2)";
Debug.ShouldStop(8388608);
themeactivity.mostCurrent._nextbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean("<",_page,BA.numberCast(double.class, 2)))));
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