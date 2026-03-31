package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class noteactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",noteactivity.mostCurrent._starter._darkmode /*RemoteObject*/ ,noteactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"notepadLayout\")";
Debug.ShouldStop(8388608);
noteactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("notepadLayout")),noteactivity.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"notepadLayoutDark\")";
Debug.ShouldStop(33554432);
noteactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("notepadLayoutDark")),noteactivity.mostCurrent.activityBA);
 };
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="RefreshList(\"\")";
Debug.ShouldStop(-2147483648);
_refreshlist(RemoteObject.createImmutable(""));
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
public static RemoteObject  _addbtn_click() throws Exception{
try {
		Debug.PushSubsStack("addBtn_Click (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,94);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","addbtn_click");}
 BA.debugLineNum = 94;BA.debugLine="Sub addBtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="StartActivity(editnote)";
Debug.ShouldStop(1073741824);
noteactivity.mostCurrent.__c.runVoidMethod ("StartActivity",noteactivity.processBA,(Object)((noteactivity.mostCurrent._editnote.getObject())));
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 16;BA.debugLine="Private addBtn As Button";
noteactivity.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private noteClv As CustomListView";
noteactivity.mostCurrent._noteclv = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _noteclv_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("noteClv_ItemClick (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,39);
if (RapidSub.canDelegate("noteclv_itemclick")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","noteclv_itemclick", _index, _value);}
RemoteObject _selectednote = RemoteObject.declareNull("b4a.example.main._mynote");
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 39;BA.debugLine="Sub noteClv_ItemClick (Index As Int, Value As Obje";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="Dim selectedNote As MyNote = Value";
Debug.ShouldStop(256);
_selectednote = (_value);Debug.locals.put("selectedNote", _selectednote);Debug.locals.put("selectedNote", _selectednote);
 BA.debugLineNum = 44;BA.debugLine="editnote.ActiveNote = selectedNote";
Debug.ShouldStop(2048);
noteactivity.mostCurrent._editnote._activenote /*RemoteObject*/  = _selectednote;
 BA.debugLineNum = 46;BA.debugLine="StartActivity(editnote)";
Debug.ShouldStop(8192);
noteactivity.mostCurrent.__c.runVoidMethod ("StartActivity",noteactivity.processBA,(Object)((noteactivity.mostCurrent._editnote.getObject())));
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
public static void  _noteclv_itemlongclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("noteClv_ItemLongClick (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,49);
if (RapidSub.canDelegate("noteclv_itemlongclick")) { b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","noteclv_itemlongclick", _index, _value); return;}
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
public ResumableSub_noteClv_ItemLongClick(b4a.example.noteactivity parent,RemoteObject _index,RemoteObject _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.noteactivity parent;
RemoteObject _index;
RemoteObject _value;
RemoteObject _n = RemoteObject.declareNull("b4a.example.main._mynote");
RemoteObject _res = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("noteClv_ItemLongClick (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,49);
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
 BA.debugLineNum = 50;BA.debugLine="Dim n As MyNote = Value";
Debug.ShouldStop(131072);
_n = (_value);Debug.locals.put("n", _n);Debug.locals.put("n", _n);
 BA.debugLineNum = 52;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete '\"";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Are you sure you want to delete '"),_n.getField(true,"Title" /*RemoteObject*/ ),RemoteObject.createImmutable("'?")))),(Object)(BA.ObjectToCharSequence("Delete Note")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),noteactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 53;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", noteactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "noteactivity", "noteclv_itemlongclick"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 54;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(2097152);
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
 BA.debugLineNum = 55;BA.debugLine="MainActivity.kvs.Remove(\"N_\" & n.noteID)";
Debug.ShouldStop(4194304);
parent.mostCurrent._mainactivity._kvs /*RemoteObject*/ .runVoidMethod ("_remove",(Object)(RemoteObject.concat(RemoteObject.createImmutable("N_"),_n.getField(true,"noteID" /*RemoteObject*/ ))));
 BA.debugLineNum = 56;BA.debugLine="RefreshList(\"\")";
Debug.ShouldStop(8388608);
_refreshlist(RemoteObject.createImmutable(""));
 BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"Note deleted\", False)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Note deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("noteCvl_ItemClick (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,98);
if (RapidSub.canDelegate("notecvl_itemclick")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","notecvl_itemclick", _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 98;BA.debugLine="Sub noteCvl_ItemClick (Index As Int, Value As Obje";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
noteactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="Public kvs As KeyValueStore";
noteactivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _refreshlist(RemoteObject _searchquery) throws Exception{
try {
		Debug.PushSubsStack("RefreshList (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,61);
if (RapidSub.canDelegate("refreshlist")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","refreshlist", _searchquery);}
RemoteObject _allnotes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _keys = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _k = RemoteObject.createImmutable("");
RemoteObject _n = RemoteObject.declareNull("b4a.example.main._mynote");
RemoteObject _query = RemoteObject.createImmutable("");
Debug.locals.put("SearchQuery", _searchquery);
 BA.debugLineNum = 61;BA.debugLine="Sub RefreshList(SearchQuery As String)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="noteClv.Clear";
Debug.ShouldStop(536870912);
noteactivity.mostCurrent._noteclv.runVoidMethod ("_clear");
 BA.debugLineNum = 63;BA.debugLine="Dim AllNotes As List";
Debug.ShouldStop(1073741824);
_allnotes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("AllNotes", _allnotes);
 BA.debugLineNum = 64;BA.debugLine="AllNotes.Initialize";
Debug.ShouldStop(-2147483648);
_allnotes.runVoidMethod ("Initialize");
 BA.debugLineNum = 66;BA.debugLine="Dim keys As List = MainActivity.kvs.ListKeys";
Debug.ShouldStop(2);
_keys = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_keys = noteactivity.mostCurrent._mainactivity._kvs /*RemoteObject*/ .runMethod(false,"_listkeys");Debug.locals.put("keys", _keys);Debug.locals.put("keys", _keys);
 BA.debugLineNum = 68;BA.debugLine="For Each k As String In keys";
Debug.ShouldStop(8);
{
final RemoteObject group5 = _keys;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_k = BA.ObjectToString(group5.runMethod(false,"Get",index5));Debug.locals.put("k", _k);
Debug.locals.put("k", _k);
 BA.debugLineNum = 69;BA.debugLine="If k.StartsWith(\"N_\") Then";
Debug.ShouldStop(16);
if (_k.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("N_"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 70;BA.debugLine="Dim N As MyNote = MainActivity.kvs.Get(k)";
Debug.ShouldStop(32);
_n = (noteactivity.mostCurrent._mainactivity._kvs /*RemoteObject*/ .runMethod(false,"_get",(Object)(_k)));Debug.locals.put("N", _n);Debug.locals.put("N", _n);
 BA.debugLineNum = 71;BA.debugLine="Dim query As String = SearchQuery.ToLowerCase";
Debug.ShouldStop(64);
_query = _searchquery.runMethod(true,"toLowerCase");Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 72;BA.debugLine="If query = \"\" Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_query,BA.ObjectToString(""))) { 
 BA.debugLineNum = 73;BA.debugLine="AllNotes.Add(N)";
Debug.ShouldStop(256);
_allnotes.runVoidMethod ("Add",(Object)((_n)));
 }else {
 BA.debugLineNum = 75;BA.debugLine="If N.Tags.ToLowerCase.Contains(query) Or N.Tit";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(".",_n.getField(true,"Tags" /*RemoteObject*/ ).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(_query))) || RemoteObject.solveBoolean(".",_n.getField(true,"Title" /*RemoteObject*/ ).runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(_query)))) { 
 BA.debugLineNum = 76;BA.debugLine="AllNotes.Add(N)";
Debug.ShouldStop(2048);
_allnotes.runVoidMethod ("Add",(Object)((_n)));
 };
 };
 };
 }
}Debug.locals.put("k", _k);
;
 BA.debugLineNum = 82;BA.debugLine="AllNotes.SortType(\"Title\", True)";
Debug.ShouldStop(131072);
_allnotes.runVoidMethod ("SortType",(Object)(BA.ObjectToString("Title")),(Object)(noteactivity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 84;BA.debugLine="For Each n As MyNote In AllNotes";
Debug.ShouldStop(524288);
{
final RemoteObject group19 = _allnotes;
final int groupLen19 = group19.runMethod(true,"getSize").<Integer>get()
;int index19 = 0;
;
for (; index19 < groupLen19;index19++){
_n = (group19.runMethod(false,"Get",index19));Debug.locals.put("N", _n);
Debug.locals.put("N", _n);
 BA.debugLineNum = 85;BA.debugLine="noteClv.AddTextItem(n.Title & CRLF & n.Tags, n)";
Debug.ShouldStop(1048576);
noteactivity.mostCurrent._noteclv.runVoidMethod ("_addtextitem",(Object)((RemoteObject.concat(_n.getField(true,"Title" /*RemoteObject*/ ),noteactivity.mostCurrent.__c.getField(true,"CRLF"),_n.getField(true,"Tags" /*RemoteObject*/ )))),(Object)((_n)));
 }
}Debug.locals.put("N", _n);
;
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _searchtxt_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("searchTxt_TextChanged (noteactivity) ","noteactivity",5,noteactivity.mostCurrent.activityBA,noteactivity.mostCurrent,90);
if (RapidSub.canDelegate("searchtxt_textchanged")) { return b4a.example.noteactivity.remoteMe.runUserSub(false, "noteactivity","searchtxt_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 90;BA.debugLine="Sub searchTxt_TextChanged (Old As String, New As S";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="RefreshList(New)";
Debug.ShouldStop(67108864);
_refreshlist(_new);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
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