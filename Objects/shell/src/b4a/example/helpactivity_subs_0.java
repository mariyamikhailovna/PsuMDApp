package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class helpactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",helpactivity.mostCurrent._starter._darkmode /*RemoteObject*/ ,helpactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"helpAct\")";
Debug.ShouldStop(268435456);
helpactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("helpAct")),helpactivity.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"helpActDark\")";
Debug.ShouldStop(1073741824);
helpactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("helpActDark")),helpactivity.mostCurrent.activityBA);
 };
 BA.debugLineNum = 34;BA.debugLine="showHelpPage(0)";
Debug.ShouldStop(2);
_showhelppage(BA.numberCast(int.class, 0));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,41);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,37);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","activity_resume");}
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backBtn_Click (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,139);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","backbtn_click");}
 BA.debugLineNum = 139;BA.debugLine="Sub backBtn_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="If helpPage > 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",helpactivity._helppage,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 141;BA.debugLine="showHelpPage(helpPage - 1)";
Debug.ShouldStop(4096);
_showhelppage(RemoteObject.solve(new RemoteObject[] {helpactivity._helppage,RemoteObject.createImmutable(1)}, "-",1, 1));
 };
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("closeHelp_Click (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,145);
if (RapidSub.canDelegate("closehelp_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","closehelp_click");}
 BA.debugLineNum = 145;BA.debugLine="Sub closeHelp_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 146;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
helpactivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
 //BA.debugLineNum = 17;BA.debugLine="Private titleLbl As Label";
helpactivity.mostCurrent._titlelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private descriptionLbl As Label";
helpactivity.mostCurrent._descriptionlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private backBtn As Button";
helpactivity.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private nextBtn As Button";
helpactivity.mostCurrent._nextbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private helpimage As ImageView";
helpactivity.mostCurrent._helpimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private iconButton1 As ImageView";
helpactivity.mostCurrent._iconbutton1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private iconButton2 As ImageView";
helpactivity.mostCurrent._iconbutton2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private iconButton3 As ImageView";
helpactivity.mostCurrent._iconbutton3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _nextbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nextBtn_Click (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,133);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","nextbtn_click");}
 BA.debugLineNum = 133;BA.debugLine="Sub nextBtn_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="If helpPage < 10 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("<",helpactivity._helppage,BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 135;BA.debugLine="showHelpPage(helpPage + 1)";
Debug.ShouldStop(64);
_showhelppage(RemoteObject.solve(new RemoteObject[] {helpactivity._helppage,RemoteObject.createImmutable(1)}, "+",1, 1));
 };
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showhelppage(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("showHelpPage (helpactivity) ","helpactivity",3,helpactivity.mostCurrent.activityBA,helpactivity.mostCurrent,45);
if (RapidSub.canDelegate("showhelppage")) { return b4a.example.helpactivity.remoteMe.runUserSub(false, "helpactivity","showhelppage", _page);}
Debug.locals.put("page", _page);
 BA.debugLineNum = 45;BA.debugLine="Sub showHelpPage(page As Int)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="helpPage = page";
Debug.ShouldStop(8192);
helpactivity._helppage = _page;
 BA.debugLineNum = 48;BA.debugLine="Select page";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(_page,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10))) {
case 0: {
 BA.debugLineNum = 50;BA.debugLine="titleLbl.Text = \"Welcome\"";
Debug.ShouldStop(131072);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Welcome"));
 BA.debugLineNum = 51;BA.debugLine="descriptionLbl.Text = \"This app is tailor-made";
Debug.ShouldStop(262144);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("This app is tailor-made for students—or anyone who wants to learn. It has all the features you'll need in order to learn effectively!"));
 BA.debugLineNum = 52;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(524288);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("icon.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 53;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(1048576);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 54;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(2097152);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 55;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(4194304);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 1: {
 BA.debugLineNum = 57;BA.debugLine="titleLbl.Text = \"Calendar\"";
Debug.ShouldStop(16777216);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Calendar"));
 BA.debugLineNum = 58;BA.debugLine="descriptionLbl.Text = \"The calendar comes in th";
Debug.ShouldStop(33554432);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The calendar comes in three views to match however you like to plan. The Schedule view lets you see all your upcoming days at a glance, with major events and to-do items laid out on a timeline. The Day view shows you the full timeline for a single day, where you can add events, tasks, or birthdays, and color-coded backgrounds make each type of entry easy to tell apart. The Month view presents the classic calendar layout, complete with a month and year spinner to jump around quickly, a sneak peek of events on each day's cell, and neighboring dates filling in the empty cells so the grid always looks complete."));
 BA.debugLineNum = 59;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(67108864);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 60;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(134217728);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("icon.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 61;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(268435456);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 62;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(536870912);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("icon.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 2: {
 BA.debugLineNum = 64;BA.debugLine="titleLbl.Text = \"Clock\"";
Debug.ShouldStop(-2147483648);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Clock"));
 BA.debugLineNum = 65;BA.debugLine="descriptionLbl.Text = \"The clock keeps you on t";
Debug.ShouldStop(1);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The clock keeps you on time and on task all in one place. A format button lets you switch between clock displays to whatever you prefer. It also comes with a built-in Pomodoro timer to help you stay focused and productive, and if the default durations don't work for you, you can freely adjust them to fit your own rhythm."));
 BA.debugLineNum = 66;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(2);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 67;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(4);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("icon.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 68;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(8);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("icon.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 69;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(16);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("icon.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 3: {
 BA.debugLineNum = 71;BA.debugLine="titleLbl.Text = \"Corkboard\"";
Debug.ShouldStop(64);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Corkboard"));
 BA.debugLineNum = 72;BA.debugLine="descriptionLbl.Text = \"The corkboard gives you";
Debug.ShouldStop(128);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The corkboard gives you a creative space to pin your thoughts and ideas. You can place sticky notes in a variety of colors to keep things visually organized and easy to tell apart. Images from your gallery can be attached right onto the board for extra context or inspiration. And when words and notes aren't enough, you can open up a drawable canvas with a selection of colored pens and sketch, doodle, or diagram anything you have in mind."));
 BA.debugLineNum = 73;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(256);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 74;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(512);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 75;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(1024);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 76;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(2048);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 4: {
 BA.debugLineNum = 78;BA.debugLine="titleLbl.Text = \"Flashcards\"";
Debug.ShouldStop(8192);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Flashcards"));
 BA.debugLineNum = 79;BA.debugLine="descriptionLbl.Text = \"The flashcard feature or";
Debug.ShouldStop(16384);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The flashcard feature organizes your cards into decks and subdecks, and you have the freedom to add, rename, or delete any of them — with a confirmation before anything gets deleted for good. Cards are automatically shuffled so every session feels fresh. A progress bar and percentage track how far you've made it through a deck, and when you're ready to dive back in, two buttons have you covered — restart the entire deck from scratch, or continue right where you left off."));
 BA.debugLineNum = 80;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(32768);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 81;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(65536);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 82;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(131072);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 83;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(262144);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 5: {
 BA.debugLineNum = 85;BA.debugLine="titleLbl.Text = \"Music Player\"";
Debug.ShouldStop(1048576);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Music Player"));
 BA.debugLineNum = 86;BA.debugLine="descriptionLbl.Text = \"The music player plays t";
Debug.ShouldStop(2097152);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The music player plays the music on startup, meaning the app greets you with songs! Filled with chill, lo-fi tracks, you have the freedom to choose what track you want to play--either through the previous/next song buttons, or through the list of songs below where you can click on whatever chooses your fancy. There's a segment of the song that you want to listen to again or you want to zoom through a certain bit of a song? The seek bar presents itself to you where you can navigate within the music."));
 BA.debugLineNum = 87;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(4194304);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 88;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(8388608);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 89;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(16777216);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 90;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(33554432);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 6: {
 BA.debugLineNum = 92;BA.debugLine="titleLbl.Text = \"Notepad\"";
Debug.ShouldStop(134217728);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Notepad"));
 BA.debugLineNum = 93;BA.debugLine="descriptionLbl.Text = \"The notepad keeps all yo";
Debug.ShouldStop(268435456);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The notepad keeps all your notes in one tidy list that's easy to browse through. A search bar lets you quickly find any note by its title or tags, so nothing ever gets lost in the pile. Adding a new note is simple — just give it a title, attach some tags to keep things organized, and write away to your heart's content."));
 BA.debugLineNum = 94;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(536870912);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 95;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(1073741824);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 96;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(-2147483648);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 97;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(1);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 7: {
 BA.debugLineNum = 99;BA.debugLine="titleLbl.Text = \"To-do List\"";
Debug.ShouldStop(4);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("To-do List"));
 BA.debugLineNum = 100;BA.debugLine="descriptionLbl.Text = \"The to-do list enables y";
Debug.ShouldStop(8);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The to-do list enables you to create lists with titles and, especially, tasks you want or are obligated to do. You are able to keep a lot of lists that you can easily navigate through the left side of your screen. The task section is a checklist of your tasks that you input, and once achieved, you can tick it off the list. The to-do list will also show you your progress in the list."));
 BA.debugLineNum = 101;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(16);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 102;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(32);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 103;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(64);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 104;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(128);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 8: {
 BA.debugLineNum = 106;BA.debugLine="titleLbl.Text = \"Themes\"";
Debug.ShouldStop(512);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Themes"));
 BA.debugLineNum = 107;BA.debugLine="descriptionLbl.Text = \"Themes let you put your";
Debug.ShouldStop(1024);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("Themes let you put your own fun twist on the app. Choose from a range of styles and color schemes to dress up your experience, making the space you study and plan in feel a little more like yours."));
 BA.debugLineNum = 108;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(2048);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 109;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(4096);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 110;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(8192);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 111;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(16384);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 9: {
 BA.debugLineNum = 113;BA.debugLine="titleLbl.Text = \"Lamp\"";
Debug.ShouldStop(65536);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Lamp"));
 BA.debugLineNum = 114;BA.debugLine="descriptionLbl.Text = \"The lamp gives you contr";
Debug.ShouldStop(131072);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("The lamp gives you control over how the app looks in any lighting. Switch effortlessly between light mode for bright environments and dark mode for low-light settings, so your eyes stay comfortable no matter when or where you're working."));
 BA.debugLineNum = 115;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(262144);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 116;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(524288);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 117;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(1048576);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 118;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(2097152);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
case 10: {
 BA.debugLineNum = 120;BA.debugLine="titleLbl.Text = \"Navigation\"";
Debug.ShouldStop(8388608);
helpactivity.mostCurrent._titlelbl.runMethod(true,"setText",BA.ObjectToCharSequence("Navigation"));
 BA.debugLineNum = 121;BA.debugLine="descriptionLbl.Text = \"Navigation is your home";
Debug.ShouldStop(16777216);
helpactivity.mostCurrent._descriptionlbl.runMethod(true,"setText",BA.ObjectToCharSequence("Navigation is your home base for getting around the app. All of the app's features are laid out in one accessible spot, with clearly labeled and easy-to-read buttons so you can jump to wherever you need to be without any hassle."));
 BA.debugLineNum = 122;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
Debug.ShouldStop(33554432);
helpactivity.mostCurrent._helpimage.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 123;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(67108864);
helpactivity.mostCurrent._iconbutton1.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 124;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(134217728);
helpactivity.mostCurrent._iconbutton2.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 125;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File.";
Debug.ShouldStop(268435456);
helpactivity.mostCurrent._iconbutton3.runMethod(false,"setBitmap",(helpactivity._xui.runMethod(false,"LoadBitmapResize",(Object)(helpactivity.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("bob.png")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getWidth")),(Object)(helpactivity.mostCurrent._helpimage.runMethod(true,"getHeight")),(Object)(helpactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 break; }
}
;
 BA.debugLineNum = 129;BA.debugLine="backBtn.Enabled = (page > 0)";
Debug.ShouldStop(1);
helpactivity.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean(">",_page,BA.numberCast(double.class, 0)))));
 BA.debugLineNum = 130;BA.debugLine="nextBtn.Enabled = (page < 10)";
Debug.ShouldStop(2);
helpactivity.mostCurrent._nextbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean("<",_page,BA.numberCast(double.class, 10)))));
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}