package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class note_subs_2 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.note.remoteMe.runUserSub(false, "note","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"notepadLayout\")";
Debug.ShouldStop(524288);
note.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("notepadLayout")),note.mostCurrent.activityBA);
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
		Debug.PushSubsStack("Activity_Pause (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.note.remoteMe.runUserSub(false, "note","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,24);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.note.remoteMe.runUserSub(false, "note","activity_resume");}
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="RefreshList";
Debug.ShouldStop(16777216);
_refreshlist();
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
public static RemoteObject  _addbtn_click() throws Exception{
try {
		Debug.PushSubsStack("addBtn_Click (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,72);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.example.note.remoteMe.runUserSub(false, "note","addbtn_click");}
 BA.debugLineNum = 72;BA.debugLine="Sub addBtn_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="StartActivity(editnote)";
Debug.ShouldStop(512);
note.mostCurrent.__c.runVoidMethod ("StartActivity",note.processBA,(Object)((note.mostCurrent._editnote.getObject())));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
 //BA.debugLineNum = 15;BA.debugLine="Private addBtn As Button";
note.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private noteClv As CustomListView";
note.mostCurrent._noteclv = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _noteclv_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("noteClv_ItemClick (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,32);
if (RapidSub.canDelegate("noteclv_itemclick")) { return b4a.example.note.remoteMe.runUserSub(false, "note","noteclv_itemclick", _index, _value);}
RemoteObject _selectednote = RemoteObject.declareNull("b4a.example.main._mynote");
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 32;BA.debugLine="Sub noteClv_ItemClick (Index As Int, Value As Obje";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="Dim selectedNote As MyNote = Value";
Debug.ShouldStop(2);
_selectednote = (_value);Debug.locals.put("selectedNote", _selectednote);Debug.locals.put("selectedNote", _selectednote);
 BA.debugLineNum = 37;BA.debugLine="editnote.ActiveNote = selectedNote";
Debug.ShouldStop(16);
note.mostCurrent._editnote._activenote /*RemoteObject*/  = _selectednote;
 BA.debugLineNum = 39;BA.debugLine="StartActivity(editnote)";
Debug.ShouldStop(64);
note.mostCurrent.__c.runVoidMethod ("StartActivity",note.processBA,(Object)((note.mostCurrent._editnote.getObject())));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _noteclv_itemlongclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("noteClv_ItemLongClick (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,42);
if (RapidSub.canDelegate("noteclv_itemlongclick")) { b4a.example.note.remoteMe.runUserSub(false, "note","noteclv_itemlongclick", _index, _value); return;}
ResumableSub_noteClv_ItemLongClick rsub = new ResumableSub_noteClv_ItemLongClick(null,_index,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_noteClv_ItemLongClick extends BA.ResumableSub {
public ResumableSub_noteClv_ItemLongClick(b4a.example.note parent,RemoteObject _index,RemoteObject _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.note parent;
RemoteObject _index;
RemoteObject _value;
RemoteObject _n = RemoteObject.declareNull("b4a.example.main._mynote");
RemoteObject _res = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("noteClv_ItemLongClick (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,42);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 43;BA.debugLine="Dim n As MyNote = Value";
Debug.ShouldStop(1024);
_n = (_value);Debug.locals.put("n", _n);Debug.locals.put("n", _n);
 BA.debugLineNum = 46;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete '\"";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Are you sure you want to delete '"),_n.getField(true,"Title" /*RemoteObject*/ ),RemoteObject.createImmutable("'?")))),(Object)(BA.ObjectToCharSequence("Delete Note")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),note.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 47;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", note.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "note", "noteclv_itemlongclick"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 48;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 50;BA.debugLine="Main.kvs.Remove(\"Note_\" & n.noteID)";
Debug.ShouldStop(131072);
parent.mostCurrent._main._kvs /*RemoteObject*/ .runClassMethod (b4a.example.keyvaluestore.class, "_remove" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable("Note_"),_n.getField(true,"noteID" /*RemoteObject*/ ))));
 BA.debugLineNum = 53;BA.debugLine="RefreshList";
Debug.ShouldStop(1048576);
_refreshlist();
 BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\"Note deleted\", False)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Note deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
public static void  _msgbox_result(RemoteObject _res) throws Exception{
}
public static RemoteObject  _notecvl_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("noteCvl_ItemClick (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,77);
if (RapidSub.canDelegate("notecvl_itemclick")) { return b4a.example.note.remoteMe.runUserSub(false, "note","notecvl_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 77;BA.debugLine="Sub noteCvl_ItemClick (Index As Int, Value As Obje";
Debug.ShouldStop(4096);
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
note._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _refreshlist() throws Exception{
try {
		Debug.PushSubsStack("RefreshList (note) ","note",3,note.mostCurrent.activityBA,note.mostCurrent,59);
if (RapidSub.canDelegate("refreshlist")) { return b4a.example.note.remoteMe.runUserSub(false, "note","refreshlist");}
RemoteObject _keys = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _k = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.declareNull("b4a.example.main._mynote");
 BA.debugLineNum = 59;BA.debugLine="Sub RefreshList";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="noteClv.Clear";
Debug.ShouldStop(134217728);
note.mostCurrent._noteclv.runVoidMethod ("_clear");
 BA.debugLineNum = 62;BA.debugLine="Dim keys As List = Main.kvs.ListKeys";
Debug.ShouldStop(536870912);
_keys = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_keys = note.mostCurrent._main._kvs /*RemoteObject*/ .runClassMethod (b4a.example.keyvaluestore.class, "_listkeys" /*RemoteObject*/ );Debug.locals.put("keys", _keys);Debug.locals.put("keys", _keys);
 BA.debugLineNum = 63;BA.debugLine="For Each k As String In keys";
Debug.ShouldStop(1073741824);
{
final RemoteObject group3 = _keys;
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_k = BA.ObjectToString(group3.runMethod(false,"Get",index3));Debug.locals.put("k", _k);
Debug.locals.put("k", _k);
 BA.debugLineNum = 64;BA.debugLine="If k.StartsWith(\"Note_\") Then";
Debug.ShouldStop(-2147483648);
if (_k.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("Note_"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 65;BA.debugLine="Dim n As MyNote = Main.kvs.Get(k)";
Debug.ShouldStop(1);
_n = (note.mostCurrent._main._kvs /*RemoteObject*/ .runClassMethod (b4a.example.keyvaluestore.class, "_get" /*RemoteObject*/ ,(Object)(_k)));Debug.locals.put("n", _n);Debug.locals.put("n", _n);
 BA.debugLineNum = 67;BA.debugLine="noteClv.AddTextItem(n.Title & CRLF & n.Tags, n)";
Debug.ShouldStop(4);
note.mostCurrent._noteclv.runVoidMethod ("_addtextitem",(Object)((RemoteObject.concat(_n.getField(true,"Title" /*RemoteObject*/ ),note.mostCurrent.__c.getField(true,"CRLF"),_n.getField(true,"Tags" /*RemoteObject*/ )))),(Object)((_n)));
 };
 }
}Debug.locals.put("k", _k);
;
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}