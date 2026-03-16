package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class editnote_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (editnote) ","editnote",5,editnote.mostCurrent.activityBA,editnote.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.editnote.remoteMe.runUserSub(false, "editnote","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"editnoteLayout\")";
Debug.ShouldStop(4194304);
editnote.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("editnoteLayout")),editnote.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="contentTxt.Background = Null";
Debug.ShouldStop(33554432);
editnote.mostCurrent._contenttxt.runMethod(false,"setBackground",(editnote.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 27;BA.debugLine="contentTxt.Gravity = Bit.Or(Gravity.TOP, Gravity.";
Debug.ShouldStop(67108864);
editnote.mostCurrent._contenttxt.runMethod(true,"setGravity",editnote.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(editnote.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP")),(Object)(editnote.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT"))));
 BA.debugLineNum = 29;BA.debugLine="If ActiveNote.IsInitialized Then";
Debug.ShouldStop(268435456);
if (editnote._activenote.getField(true,"IsInitialized" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 30;BA.debugLine="titleTxt.Text = ActiveNote.Title";
Debug.ShouldStop(536870912);
editnote.mostCurrent._titletxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(editnote._activenote.getField(true,"Title" /*RemoteObject*/ )));
 BA.debugLineNum = 31;BA.debugLine="tagsTxt.Text = ActiveNote.Tags";
Debug.ShouldStop(1073741824);
editnote.mostCurrent._tagstxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(editnote._activenote.getField(true,"Tags" /*RemoteObject*/ )));
 BA.debugLineNum = 32;BA.debugLine="contentTxt.Text = ActiveNote.Content";
Debug.ShouldStop(-2147483648);
editnote.mostCurrent._contenttxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(editnote._activenote.getField(true,"Content" /*RemoteObject*/ )));
 };
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (editnote) ","editnote",5,editnote.mostCurrent.activityBA,editnote.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.editnote.remoteMe.runUserSub(false, "editnote","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="If UserClosed Then ActiveNote.Initialize";
Debug.ShouldStop(256);
if (_userclosed.<Boolean>get().booleanValue()) { 
editnote._activenote.runVoidMethod ("Initialize");};
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (editnote) ","editnote",5,editnote.mostCurrent.activityBA,editnote.mostCurrent,36);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.editnote.remoteMe.runUserSub(false, "editnote","activity_resume");}
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private contentTxt As EditText";
editnote.mostCurrent._contenttxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private saveBtn As Button";
editnote.mostCurrent._savebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private tagsTxt As EditText";
editnote.mostCurrent._tagstxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private titleTxt As EditText";
editnote.mostCurrent._titletxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public ActiveNote As MyNote";
editnote._activenote = RemoteObject.createNew ("b4a.example.main._mynote");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _savebtn_click() throws Exception{
try {
		Debug.PushSubsStack("saveBtn_Click (editnote) ","editnote",5,editnote.mostCurrent.activityBA,editnote.mostCurrent,44);
if (RapidSub.canDelegate("savebtn_click")) { return b4a.example.editnote.remoteMe.runUserSub(false, "editnote","savebtn_click");}
RemoteObject _n = RemoteObject.declareNull("b4a.example.main._mynote");
 BA.debugLineNum = 44;BA.debugLine="Sub saveBtn_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="If titleTxt.Text.Trim = \"\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",editnote.mostCurrent._titletxt.runMethod(true,"getText").runMethod(true,"trim"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 46;BA.debugLine="MsgboxAsync(\"Please add a title\", \"\")";
Debug.ShouldStop(8192);
editnote.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Please add a title")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))),editnote.processBA);
 BA.debugLineNum = 47;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 50;BA.debugLine="Dim n As MyNote";
Debug.ShouldStop(131072);
_n = RemoteObject.createNew ("b4a.example.main._mynote");Debug.locals.put("n", _n);
 BA.debugLineNum = 51;BA.debugLine="n.Initialize";
Debug.ShouldStop(262144);
_n.runVoidMethod ("Initialize");
 BA.debugLineNum = 54;BA.debugLine="If ActiveNote.IsInitialized Then";
Debug.ShouldStop(2097152);
if (editnote._activenote.getField(true,"IsInitialized" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 55;BA.debugLine="n.noteID = ActiveNote.noteID";
Debug.ShouldStop(4194304);
_n.setField ("noteID" /*RemoteObject*/ ,editnote._activenote.getField(true,"noteID" /*RemoteObject*/ ));
 }else {
 BA.debugLineNum = 59;BA.debugLine="n.noteID = (DateTime.Now * 1000) + Rnd(1, 1000)";
Debug.ShouldStop(67108864);
_n.setField ("noteID" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {editnote.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),RemoteObject.createImmutable(1000)}, "*",0, 2)),editnote.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1000)))}, "+",1, 2));
 };
 BA.debugLineNum = 63;BA.debugLine="n.Title = titleTxt.Text";
Debug.ShouldStop(1073741824);
_n.setField ("Title" /*RemoteObject*/ ,editnote.mostCurrent._titletxt.runMethod(true,"getText"));
 BA.debugLineNum = 64;BA.debugLine="n.Tags = tagsTxt.Text";
Debug.ShouldStop(-2147483648);
_n.setField ("Tags" /*RemoteObject*/ ,editnote.mostCurrent._tagstxt.runMethod(true,"getText"));
 BA.debugLineNum = 65;BA.debugLine="n.Content = contentTxt.Text";
Debug.ShouldStop(1);
_n.setField ("Content" /*RemoteObject*/ ,editnote.mostCurrent._contenttxt.runMethod(true,"getText"));
 BA.debugLineNum = 66;BA.debugLine="n.DateAdded = DateTime.Now";
Debug.ShouldStop(2);
_n.setField ("DateAdded" /*RemoteObject*/ ,editnote.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 70;BA.debugLine="Main.kvs.Put(\"Note_\" & n.noteID, n)";
Debug.ShouldStop(32);
editnote.mostCurrent._main._kvs /*RemoteObject*/ .runClassMethod (b4a.example.keyvaluestore.class, "_put" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("Note_"),_n.getField(true,"noteID" /*RemoteObject*/ ))),(Object)((_n)));
 BA.debugLineNum = 72;BA.debugLine="ToastMessageShow(\"Note Saved\", False)";
Debug.ShouldStop(128);
editnote.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Note Saved")),(Object)(editnote.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 73;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
editnote.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}