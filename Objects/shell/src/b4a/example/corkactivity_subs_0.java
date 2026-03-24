package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class corkactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,44);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
Debug.ShouldStop(4096);
corkactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("corkboardLayout")),corkactivity.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="penSpnr.AddAll(Array As String(\"Red\", \"Blue\", \"Gr";
Debug.ShouldStop(8192);
corkactivity.mostCurrent._penspnr.runVoidMethod ("AddAll",(Object)(corkactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("Red"),BA.ObjectToString("Blue"),BA.ObjectToString("Green"),BA.ObjectToString("Black"),BA.ObjectToString("Yellow"),RemoteObject.createImmutable("Eraser")})))));
 BA.debugLineNum = 47;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(16384);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 48;BA.debugLine="imgPicker.Initialize(\"CC\")";
Debug.ShouldStop(32768);
corkactivity._imgpicker.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 };
 BA.debugLineNum = 50;BA.debugLine="penSpnr.Visible = False";
Debug.ShouldStop(131072);
corkactivity.mostCurrent._penspnr.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="Width = 80dip";
Debug.ShouldStop(262144);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));
 BA.debugLineNum = 52;BA.debugLine="Height = 60dip";
Debug.ShouldStop(524288);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Resume (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","activity_resume");}
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
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
public static void  _addcanvas(RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("AddCanvas (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,112);
if (RapidSub.canDelegate("addcanvas")) { b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addcanvas", _x, _y); return;}
ResumableSub_AddCanvas rsub = new ResumableSub_AddCanvas(null,_x,_y);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_AddCanvas extends BA.ResumableSub {
public ResumableSub_AddCanvas(b4a.example.corkactivity parent,RemoteObject _x,RemoteObject _y) {
this.parent = parent;
this._x = _x;
this._y = _y;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.corkactivity parent;
RemoteObject _x;
RemoteObject _y;
RemoteObject _f = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
RemoteObject _dd = RemoteObject.declareNull("b4a.example.dragdropview");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("AddCanvas (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,112);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
 BA.debugLineNum = 113;BA.debugLine="Dim f As Panel";
Debug.ShouldStop(65536);
_f = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("f", _f);
 BA.debugLineNum = 114;BA.debugLine="f.Initialize(\"CanvasFrame\")";
Debug.ShouldStop(131072);
_f.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("CanvasFrame")));
 BA.debugLineNum = 115;BA.debugLine="f.Color = Colors.Gray";
Debug.ShouldStop(262144);
_f.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 116;BA.debugLine="boardPnl.AddView(f, x, y, Width + 20dip, Height +";
Debug.ShouldStop(524288);
parent.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_f.getObject())),(Object)(_x),(Object)(_y),(Object)(RemoteObject.solve(new RemoteObject[] {parent._width,parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {parent._height,parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "+",1, 1)));
 BA.debugLineNum = 118;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(2097152);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 119;BA.debugLine="p.Initialize(\"CanvasPanel\")";
Debug.ShouldStop(4194304);
_p.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("CanvasPanel")));
 BA.debugLineNum = 120;BA.debugLine="p.Color = Colors.White";
Debug.ShouldStop(8388608);
_p.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 121;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
Debug.ShouldStop(16777216);
_f.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(parent._width),(Object)(parent._height));
 BA.debugLineNum = 123;BA.debugLine="Sleep(0)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("Sleep",corkactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "corkactivity", "addcanvas"),BA.numberCast(int.class, 0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 125;BA.debugLine="Dim cvs As B4XCanvas";
Debug.ShouldStop(268435456);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 126;BA.debugLine="cvs.Initialize(p)";
Debug.ShouldStop(536870912);
_cvs.runVoidMethod ("Initialize",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()));
 BA.debugLineNum = 127;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
Debug.ShouldStop(1073741824);
_cvs.runVoidMethod ("DrawRect",(Object)(_cvs.runMethod(false,"getTargetRect")),(Object)(parent.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray")),(Object)(parent.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 128;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(-2147483648);
_cvs.runVoidMethod ("Invalidate");
 BA.debugLineNum = 129;BA.debugLine="p.Tag = cvs";
Debug.ShouldStop(1);
_p.runMethod(false,"setTag",(_cvs));
 BA.debugLineNum = 131;BA.debugLine="Dim dd As DragDropView";
Debug.ShouldStop(4);
_dd = RemoteObject.createNew ("b4a.example.dragdropview");Debug.locals.put("dd", _dd);
 BA.debugLineNum = 132;BA.debugLine="dd.Initialize(Me, \"CanvasDrag\")";
Debug.ShouldStop(8);
_dd.runVoidMethod ("_initialize",corkactivity.processBA,(Object)(corkactivity.getObject()),(Object)(RemoteObject.createImmutable("CanvasDrag")));
 BA.debugLineNum = 133;BA.debugLine="dd.AddDragView(f, False)";
Debug.ShouldStop(16);
_dd.runVoidMethod ("_adddragview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _f.getObject()),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 134;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
Debug.ShouldStop(32);
_dd.runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place1.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place2.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place3.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place4.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place5.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place6.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place7.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place8.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place9.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place10.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place11.getObject())).runVoidMethod ("_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place12.getObject()));
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
public static RemoteObject  _addcbtn_click() throws Exception{
try {
		Debug.PushSubsStack("addcBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,207);
if (RapidSub.canDelegate("addcbtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addcbtn_click");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
 BA.debugLineNum = 207;BA.debugLine="Private Sub addcBtn_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
Debug.ShouldStop(32768);
_randomx = corkactivity.mostCurrent.__c.runMethod(true,"Rnd",(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 209;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
Debug.ShouldStop(65536);
_randomy = corkactivity.mostCurrent.__c.runMethod(true,"Rnd",(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 210;BA.debugLine="AddCanvas(randomX, randomY)";
Debug.ShouldStop(131072);
_addcanvas(_randomx,_randomy);
 BA.debugLineNum = 211;BA.debugLine="canvasPnl.Visible = False";
Debug.ShouldStop(262144);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addnbtn_click() throws Exception{
try {
		Debug.PushSubsStack("addnBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,197);
if (RapidSub.canDelegate("addnbtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addnbtn_click");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
 BA.debugLineNum = 197;BA.debugLine="Private Sub addnBtn_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 198;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
Debug.ShouldStop(32);
_randomx = corkactivity.mostCurrent.__c.runMethod(true,"Rnd",(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 199;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
Debug.ShouldStop(64);
_randomy = corkactivity.mostCurrent.__c.runMethod(true,"Rnd",(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 200;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
Debug.ShouldStop(128);
_addstickynote(BA.ObjectToString(""),_randomx,_randomy);
 BA.debugLineNum = 201;BA.debugLine="notePnl.Visible = False";
Debug.ShouldStop(256);
corkactivity.mostCurrent._notepnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 202;BA.debugLine="R = 255";
Debug.ShouldStop(512);
corkactivity._r = BA.numberCast(int.class, 255);
 BA.debugLineNum = 203;BA.debugLine="G = 0";
Debug.ShouldStop(1024);
corkactivity._g = BA.numberCast(int.class, 0);
 BA.debugLineNum = 204;BA.debugLine="B = 0";
Debug.ShouldStop(2048);
corkactivity._b = BA.numberCast(int.class, 0);
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addstickynote(RemoteObject _text,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("AddStickyNote (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,68);
if (RapidSub.canDelegate("addstickynote")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addstickynote", _text, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
RemoteObject _dd = RemoteObject.declareNull("b4a.example.dragdropview");
Debug.locals.put("Text", _text);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
 BA.debugLineNum = 68;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(16);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 70;BA.debugLine="p.Initialize(\"NotePanel\")";
Debug.ShouldStop(32);
_p.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("NotePanel")));
 BA.debugLineNum = 71;BA.debugLine="p.Color = Colors.RGB(R, G, B)";
Debug.ShouldStop(64);
_p.runVoidMethod ("setColor",corkactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(corkactivity._r),(Object)(corkactivity._g),(Object)(corkactivity._b)));
 BA.debugLineNum = 73;BA.debugLine="Dim txt As EditText";
Debug.ShouldStop(256);
_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");Debug.locals.put("txt", _txt);
 BA.debugLineNum = 74;BA.debugLine="txt.Initialize(\"\")";
Debug.ShouldStop(512);
_txt.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 75;BA.debugLine="txt.Text = Text";
Debug.ShouldStop(1024);
_txt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_text));
 BA.debugLineNum = 76;BA.debugLine="txt.TextSize = 12";
Debug.ShouldStop(2048);
_txt.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 77;BA.debugLine="txt.Background = Null";
Debug.ShouldStop(4096);
_txt.runMethod(false,"setBackground",(corkactivity.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 78;BA.debugLine="txt.TextColor = Colors.Black";
Debug.ShouldStop(8192);
_txt.runMethod(true,"setTextColor",corkactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 79;BA.debugLine="txt.Gravity = Gravity.TOP";
Debug.ShouldStop(16384);
_txt.runMethod(true,"setGravity",corkactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 81;BA.debugLine="p.AddView(txt, 5dip, 15dip, 90dip, 70dip)";
Debug.ShouldStop(65536);
_p.runVoidMethod ("AddView",(Object)((_txt.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 83;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
Debug.ShouldStop(262144);
corkactivity.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_x),(Object)(_y),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 85;BA.debugLine="Dim dd As DragDropView";
Debug.ShouldStop(1048576);
_dd = RemoteObject.createNew ("b4a.example.dragdropview");Debug.locals.put("dd", _dd);
 BA.debugLineNum = 86;BA.debugLine="dd.Initialize(Me, \"NoteDrag\")";
Debug.ShouldStop(2097152);
_dd.runVoidMethod ("_initialize",corkactivity.processBA,(Object)(corkactivity.getObject()),(Object)(RemoteObject.createImmutable("NoteDrag")));
 BA.debugLineNum = 87;BA.debugLine="dd.AddDragView(p, False)";
Debug.ShouldStop(4194304);
_dd.runVoidMethod ("_adddragview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()),(Object)(corkactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 88;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
Debug.ShouldStop(8388608);
_dd.runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place1.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place2.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place3.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place4.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place5.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place6.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place7.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place8.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place9.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place10.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place11.getObject())).runVoidMethod ("_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place12.getObject()));
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _canvabtn_click() throws Exception{
try {
		Debug.PushSubsStack("canvaBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,219);
if (RapidSub.canDelegate("canvabtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvabtn_click");}
 BA.debugLineNum = 219;BA.debugLine="Private Sub canvaBtn_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="canvasWindow(250dip, 180dip)";
Debug.ShouldStop(134217728);
_canvaswindow(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 180))));
 BA.debugLineNum = 221;BA.debugLine="canvasPnl.Visible = True";
Debug.ShouldStop(268435456);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 222;BA.debugLine="penSpnr.Visible = True";
Debug.ShouldStop(536870912);
corkactivity.mostCurrent._penspnr.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 223;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _canvaspanel_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("CanvasPanel_Touch (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,137);
if (RapidSub.canDelegate("canvaspanel_touch")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvaspanel_touch", _action, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 137;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="Dim p As Panel = Sender";
Debug.ShouldStop(512);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), corkactivity.mostCurrent.__c.runMethod(false,"Sender",corkactivity.mostCurrent.activityBA));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 139;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
Debug.ShouldStop(1024);
_cvs = (_p.runMethod(false,"getTag"));Debug.locals.put("cvs", _cvs);Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 140;BA.debugLine="Select Action";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_action,corkactivity.mostCurrent._activity.getField(true,"ACTION_DOWN"),corkactivity.mostCurrent._activity.getField(true,"ACTION_MOVE"))) {
case 0: {
 BA.debugLineNum = 142;BA.debugLine="LastX = X";
Debug.ShouldStop(8192);
corkactivity._lastx = _x;
 BA.debugLineNum = 143;BA.debugLine="LastY = Y";
Debug.ShouldStop(16384);
corkactivity._lasty = _y;
 break; }
case 1: {
 BA.debugLineNum = 145;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,";
Debug.ShouldStop(65536);
_cvs.runVoidMethod ("DrawLine",(Object)(corkactivity._lastx),(Object)(corkactivity._lasty),(Object)(_x),(Object)(_y),(Object)(corkactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(corkactivity._r2),(Object)(corkactivity._g2),(Object)(corkactivity._b2))),(Object)(BA.numberCast(float.class, corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3))))));
 BA.debugLineNum = 146;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(131072);
_cvs.runVoidMethod ("Invalidate");
 BA.debugLineNum = 147;BA.debugLine="LastX = X";
Debug.ShouldStop(262144);
corkactivity._lastx = _x;
 BA.debugLineNum = 148;BA.debugLine="LastY = Y";
Debug.ShouldStop(524288);
corkactivity._lasty = _y;
 break; }
}
;
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _canvaswindow(RemoteObject _pw,RemoteObject _ph) throws Exception{
try {
		Debug.PushSubsStack("canvasWindow (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,177);
if (RapidSub.canDelegate("canvaswindow")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvaswindow", _pw, _ph);}
RemoteObject _sizespnr = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
RemoteObject _addcbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("pW", _pw);
Debug.locals.put("pH", _ph);
 BA.debugLineNum = 177;BA.debugLine="Private Sub canvasWindow(pW As Int, pH As Int)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="canvasPnl = xui.CreatePanel(\"canvasPanel\")";
Debug.ShouldStop(131072);
corkactivity.mostCurrent._canvaspnl = corkactivity._xui.runMethod(false,"CreatePanel",corkactivity.processBA,(Object)(RemoteObject.createImmutable("canvasPanel")));
 BA.debugLineNum = 179;BA.debugLine="Activity.AddView(canvasPnl, 100dip, 225dip, pW, p";
Debug.ShouldStop(262144);
corkactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((corkactivity.mostCurrent._canvaspnl.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))),(Object)(_pw),(Object)(_ph));
 BA.debugLineNum = 180;BA.debugLine="canvasPnl.Color = xui.Color_RGB(50, 50, 50)";
Debug.ShouldStop(524288);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setColor",corkactivity._xui.runMethod(true,"Color_RGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 181;BA.debugLine="canvasPnl.SetColorAndBorder(xui.Color_White, 2dip";
Debug.ShouldStop(1048576);
corkactivity.mostCurrent._canvaspnl.runVoidMethod ("SetColorAndBorder",(Object)(corkactivity._xui.getField(true,"Color_White")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(corkactivity._xui.getField(true,"Color_Black")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 183;BA.debugLine="Dim sizeSpnr As Spinner";
Debug.ShouldStop(4194304);
_sizespnr = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("sizeSpnr", _sizespnr);
 BA.debugLineNum = 184;BA.debugLine="sizeSpnr.Initialize(\"sizeSpnr\")";
Debug.ShouldStop(8388608);
_sizespnr.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sizeSpnr")));
 BA.debugLineNum = 185;BA.debugLine="sizeSpnr.AddAll(Array As String(\"1x1\", \"2x1\", \"1x";
Debug.ShouldStop(16777216);
_sizespnr.runVoidMethod ("AddAll",(Object)(corkactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("1x1"),BA.ObjectToString("2x1"),BA.ObjectToString("1x2"),BA.ObjectToString("2x2"),BA.ObjectToString("3x2"),RemoteObject.createImmutable("2x3")})))));
 BA.debugLineNum = 186;BA.debugLine="canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20";
Debug.ShouldStop(33554432);
corkactivity.mostCurrent._canvaspnl.runVoidMethod ("AddView",(Object)((_sizespnr.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_pw,corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 188;BA.debugLine="Dim addcBtn As Button";
Debug.ShouldStop(134217728);
_addcbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("addcBtn", _addcbtn);
 BA.debugLineNum = 189;BA.debugLine="addcBtn.Initialize(\"addcBtn\")";
Debug.ShouldStop(268435456);
_addcbtn.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addcBtn")));
 BA.debugLineNum = 190;BA.debugLine="addcBtn.Text = \"Add Canvas\"";
Debug.ShouldStop(536870912);
_addcbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Add Canvas"));
 BA.debugLineNum = 191;BA.debugLine="canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2)";
Debug.ShouldStop(1073741824);
corkactivity.mostCurrent._canvaspnl.runVoidMethod ("AddView",(Object)((_addcbtn.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pw,RemoteObject.createImmutable(2)}, "/",0, 0)),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "-",1, 0))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 193;BA.debugLine="canvasPnl.Enabled = False";
Debug.ShouldStop(1);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setEnabled",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 194;BA.debugLine="canvasPnl.Visible = False";
Debug.ShouldStop(2);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cc_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("CC_Result (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,91);
if (RapidSub.canDelegate("cc_result")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","cc_result", _success, _dir, _filename);}
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 91;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="If Success Then";
Debug.ShouldStop(134217728);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 93;BA.debugLine="imgView.Bitmap = LoadBitmapResize(Dir, FileName,";
Debug.ShouldStop(268435456);
corkactivity.mostCurrent._imgview.runMethod(false,"setBitmap",(corkactivity.mostCurrent.__c.runMethod(false,"LoadBitmapResize",(Object)(_dir),(Object)(_filename),(Object)(corkactivity.mostCurrent._imgview.runMethod(true,"getWidth")),(Object)(corkactivity.mostCurrent._imgview.runMethod(true,"getHeight")),(Object)(corkactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 }else {
 BA.debugLineNum = 95;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
Debug.ShouldStop(1073741824);
corkactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No image selected")),(Object)(corkactivity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _colorsspnr_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("colorsSpnr_ItemClick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,248);
if (RapidSub.canDelegate("colorsspnr_itemclick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","colorsspnr_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 248;BA.debugLine="Private Sub colorsSpnr_ItemClick (Position As Int,";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="Select Position";
Debug.ShouldStop(16777216);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 251;BA.debugLine="R = 255";
Debug.ShouldStop(67108864);
corkactivity._r = BA.numberCast(int.class, 255);
 BA.debugLineNum = 252;BA.debugLine="G = 0";
Debug.ShouldStop(134217728);
corkactivity._g = BA.numberCast(int.class, 0);
 BA.debugLineNum = 253;BA.debugLine="B = 0";
Debug.ShouldStop(268435456);
corkactivity._b = BA.numberCast(int.class, 0);
 break; }
case 1: {
 BA.debugLineNum = 255;BA.debugLine="R = 0";
Debug.ShouldStop(1073741824);
corkactivity._r = BA.numberCast(int.class, 0);
 BA.debugLineNum = 256;BA.debugLine="G = 0";
Debug.ShouldStop(-2147483648);
corkactivity._g = BA.numberCast(int.class, 0);
 BA.debugLineNum = 257;BA.debugLine="B = 255";
Debug.ShouldStop(1);
corkactivity._b = BA.numberCast(int.class, 255);
 break; }
case 2: {
 BA.debugLineNum = 259;BA.debugLine="R = 0";
Debug.ShouldStop(4);
corkactivity._r = BA.numberCast(int.class, 0);
 BA.debugLineNum = 260;BA.debugLine="G = 255";
Debug.ShouldStop(8);
corkactivity._g = BA.numberCast(int.class, 255);
 BA.debugLineNum = 261;BA.debugLine="B = 0";
Debug.ShouldStop(16);
corkactivity._b = BA.numberCast(int.class, 0);
 break; }
}
;
 BA.debugLineNum = 263;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 16;BA.debugLine="Private boardPnl As Panel";
corkactivity.mostCurrent._boardpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private addPnl As Panel";
corkactivity.mostCurrent._addpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private canvaBtn As Button";
corkactivity.mostCurrent._canvabtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private imgBtn As Button";
corkactivity.mostCurrent._imgbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private imgView As ImageView";
corkactivity.mostCurrent._imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private stickyBtn As Button";
corkactivity.mostCurrent._stickybtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private notePnl As B4XView";
corkactivity.mostCurrent._notepnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private canvasPnl As B4XView";
corkactivity.mostCurrent._canvaspnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private LastX, LastY As Float";
corkactivity._lastx = RemoteObject.createImmutable(0f);
corkactivity._lasty = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 25;BA.debugLine="Private place1 As Label";
corkactivity.mostCurrent._place1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private place2 As Label";
corkactivity.mostCurrent._place2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private place3 As Label";
corkactivity.mostCurrent._place3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private place4 As Label";
corkactivity.mostCurrent._place4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private place5 As Label";
corkactivity.mostCurrent._place5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private place6 As Label";
corkactivity.mostCurrent._place6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private place7 As Label";
corkactivity.mostCurrent._place7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private place8 As Label";
corkactivity.mostCurrent._place8 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private place9 As Label";
corkactivity.mostCurrent._place9 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private place10 As Label";
corkactivity.mostCurrent._place10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private place11 As Label";
corkactivity.mostCurrent._place11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private place12 As Label";
corkactivity.mostCurrent._place12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private R, G, B As Int";
corkactivity._r = RemoteObject.createImmutable(0);
corkactivity._g = RemoteObject.createImmutable(0);
corkactivity._b = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 38;BA.debugLine="Private R2, G2, B2 As Int";
corkactivity._r2 = RemoteObject.createImmutable(0);
corkactivity._g2 = RemoteObject.createImmutable(0);
corkactivity._b2 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 39;BA.debugLine="Private penSpnr As Spinner";
corkactivity.mostCurrent._penspnr = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private Width As Int";
corkactivity._width = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 41;BA.debugLine="Private Height As Int";
corkactivity._height = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imgbtn_click() throws Exception{
try {
		Debug.PushSubsStack("imgBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,214);
if (RapidSub.canDelegate("imgbtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","imgbtn_click");}
 BA.debugLineNum = 214;BA.debugLine="Private Sub imgBtn_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 215;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
Debug.ShouldStop(4194304);
corkactivity._imgpicker.runVoidMethod ("Show",corkactivity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select a Photo")));
 BA.debugLineNum = 216;BA.debugLine="imgPick";
Debug.ShouldStop(8388608);
_imgpick();
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _imgpick() throws Exception{
try {
		Debug.PushSubsStack("imgPick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,99);
if (RapidSub.canDelegate("imgpick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","imgpick");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
RemoteObject _dd = RemoteObject.declareNull("b4a.example.dragdropview");
 BA.debugLineNum = 99;BA.debugLine="Sub imgPick";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="imgView.Initialize(\"ImgView\")";
Debug.ShouldStop(8);
corkactivity.mostCurrent._imgview.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ImgView")));
 BA.debugLineNum = 101;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
Debug.ShouldStop(16);
_randomx = corkactivity.mostCurrent.__c.runMethod(true,"Rnd",(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 102;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
Debug.ShouldStop(32);
_randomy = corkactivity.mostCurrent.__c.runMethod(true,"Rnd",(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 103;BA.debugLine="boardPnl.AddView(imgView, randomX, randomY, 100di";
Debug.ShouldStop(64);
corkactivity.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((corkactivity.mostCurrent._imgview.getObject())),(Object)(_randomx),(Object)(_randomy),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 105;BA.debugLine="Dim dd As DragDropView";
Debug.ShouldStop(256);
_dd = RemoteObject.createNew ("b4a.example.dragdropview");Debug.locals.put("dd", _dd);
 BA.debugLineNum = 106;BA.debugLine="dd.Initialize(Me, \"ImgDrag\")";
Debug.ShouldStop(512);
_dd.runVoidMethod ("_initialize",corkactivity.processBA,(Object)(corkactivity.getObject()),(Object)(RemoteObject.createImmutable("ImgDrag")));
 BA.debugLineNum = 107;BA.debugLine="dd.AddDragView(imgView, False)";
Debug.ShouldStop(1024);
_dd.runVoidMethod ("_adddragview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._imgview.getObject()),(Object)(corkactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 108;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
Debug.ShouldStop(2048);
_dd.runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place1.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place2.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place3.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place4.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place5.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place6.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place7.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place8.getObject())).runVoidMethod ("_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place9.getObject()));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _notewindow(RemoteObject _pw,RemoteObject _ph) throws Exception{
try {
		Debug.PushSubsStack("noteWindow (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,157);
if (RapidSub.canDelegate("notewindow")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","notewindow", _pw, _ph);}
RemoteObject _colorsspnr = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
RemoteObject _addnbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("pW", _pw);
Debug.locals.put("pH", _ph);
 BA.debugLineNum = 157;BA.debugLine="Private Sub noteWindow(pW As Int, pH As Int)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="notePnl = xui.CreatePanel(\"notePnl\")";
Debug.ShouldStop(536870912);
corkactivity.mostCurrent._notepnl = corkactivity._xui.runMethod(false,"CreatePanel",corkactivity.processBA,(Object)(RemoteObject.createImmutable("notePnl")));
 BA.debugLineNum = 159;BA.debugLine="Activity.AddView(notePnl, 100dip, 225dip, pW, pH)";
Debug.ShouldStop(1073741824);
corkactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((corkactivity.mostCurrent._notepnl.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))),(Object)(_pw),(Object)(_ph));
 BA.debugLineNum = 160;BA.debugLine="notePnl.Color = xui.Color_RGB(50, 50, 50)";
Debug.ShouldStop(-2147483648);
corkactivity.mostCurrent._notepnl.runMethod(true,"setColor",corkactivity._xui.runMethod(true,"Color_RGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 161;BA.debugLine="notePnl.SetColorAndBorder(xui.Color_White, 2dip,";
Debug.ShouldStop(1);
corkactivity.mostCurrent._notepnl.runVoidMethod ("SetColorAndBorder",(Object)(corkactivity._xui.getField(true,"Color_White")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(corkactivity._xui.getField(true,"Color_Black")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 163;BA.debugLine="Dim colorsSpnr As Spinner";
Debug.ShouldStop(4);
_colorsspnr = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("colorsSpnr", _colorsspnr);
 BA.debugLineNum = 164;BA.debugLine="colorsSpnr.Initialize(\"colorsSpnr\")";
Debug.ShouldStop(8);
_colorsspnr.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("colorsSpnr")));
 BA.debugLineNum = 165;BA.debugLine="colorsSpnr.AddAll(Array As String(\"Red\", \"Blue\",";
Debug.ShouldStop(16);
_colorsspnr.runVoidMethod ("AddAll",(Object)(corkactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Red"),BA.ObjectToString("Blue"),RemoteObject.createImmutable("Green")})))));
 BA.debugLineNum = 166;BA.debugLine="notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20";
Debug.ShouldStop(32);
corkactivity.mostCurrent._notepnl.runVoidMethod ("AddView",(Object)((_colorsspnr.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_pw,corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 168;BA.debugLine="Dim addnBtn As Button";
Debug.ShouldStop(128);
_addnbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("addnBtn", _addnbtn);
 BA.debugLineNum = 169;BA.debugLine="addnBtn.Initialize(\"addnBtn\")";
Debug.ShouldStop(256);
_addnbtn.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addnBtn")));
 BA.debugLineNum = 170;BA.debugLine="addnBtn.Text = \"Add Note\"";
Debug.ShouldStop(512);
_addnbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Add Note"));
 BA.debugLineNum = 171;BA.debugLine="notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) -";
Debug.ShouldStop(1024);
corkactivity.mostCurrent._notepnl.runVoidMethod ("AddView",(Object)((_addnbtn.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pw,RemoteObject.createImmutable(2)}, "/",0, 0)),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "-",1, 0))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 173;BA.debugLine="notePnl.Enabled = False";
Debug.ShouldStop(4096);
corkactivity.mostCurrent._notepnl.runMethod(true,"setEnabled",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 174;BA.debugLine="notePnl.Visible = False";
Debug.ShouldStop(8192);
corkactivity.mostCurrent._notepnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _penspnr_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("penSpnr_ItemClick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,265);
if (RapidSub.canDelegate("penspnr_itemclick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","penspnr_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 265;BA.debugLine="Private Sub penSpnr_ItemClick (Position As Int, Va";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="Select Position";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 268;BA.debugLine="R2 = 255";
Debug.ShouldStop(2048);
corkactivity._r2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 269;BA.debugLine="G2 = 0";
Debug.ShouldStop(4096);
corkactivity._g2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 270;BA.debugLine="B2 = 0";
Debug.ShouldStop(8192);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 1: {
 BA.debugLineNum = 272;BA.debugLine="R2 = 0";
Debug.ShouldStop(32768);
corkactivity._r2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 273;BA.debugLine="G2 = 0";
Debug.ShouldStop(65536);
corkactivity._g2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 274;BA.debugLine="B2 = 255";
Debug.ShouldStop(131072);
corkactivity._b2 = BA.numberCast(int.class, 255);
 break; }
case 2: {
 BA.debugLineNum = 276;BA.debugLine="R2 = 0";
Debug.ShouldStop(524288);
corkactivity._r2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 277;BA.debugLine="G2 = 255";
Debug.ShouldStop(1048576);
corkactivity._g2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 278;BA.debugLine="B2 = 0";
Debug.ShouldStop(2097152);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 3: {
 BA.debugLineNum = 280;BA.debugLine="R2 = 0";
Debug.ShouldStop(8388608);
corkactivity._r2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 281;BA.debugLine="G2 = 0";
Debug.ShouldStop(16777216);
corkactivity._g2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 282;BA.debugLine="B2 = 0";
Debug.ShouldStop(33554432);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 4: {
 BA.debugLineNum = 284;BA.debugLine="R2 = 255";
Debug.ShouldStop(134217728);
corkactivity._r2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 285;BA.debugLine="G2 = 255";
Debug.ShouldStop(268435456);
corkactivity._g2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 286;BA.debugLine="B2 = 0";
Debug.ShouldStop(536870912);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 5: {
 BA.debugLineNum = 288;BA.debugLine="R2 = 255";
Debug.ShouldStop(-2147483648);
corkactivity._r2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 289;BA.debugLine="G2 = 255";
Debug.ShouldStop(1);
corkactivity._g2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 290;BA.debugLine="B2 = 255";
Debug.ShouldStop(2);
corkactivity._b2 = BA.numberCast(int.class, 255);
 break; }
}
;
 BA.debugLineNum = 292;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 9;BA.debugLine="Private imgPicker As ContentChooser";
corkactivity._imgpicker = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
corkactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sizespnr_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("sizeSpnr_ItemClick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,225);
if (RapidSub.canDelegate("sizespnr_itemclick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","sizespnr_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 225;BA.debugLine="Private Sub sizeSpnr_ItemClick (Position As Int, V";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="Select Position";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 228;BA.debugLine="Width = 80dip";
Debug.ShouldStop(8);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));
 BA.debugLineNum = 229;BA.debugLine="Height = 60dip";
Debug.ShouldStop(16);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));
 break; }
case 1: {
 BA.debugLineNum = 231;BA.debugLine="Width = 205dip";
Debug.ShouldStop(64);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 205)));
 BA.debugLineNum = 232;BA.debugLine="Height = 60dip";
Debug.ShouldStop(128);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));
 break; }
case 2: {
 BA.debugLineNum = 234;BA.debugLine="Width = 80dip";
Debug.ShouldStop(512);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));
 BA.debugLineNum = 235;BA.debugLine="Height = 185dip";
Debug.ShouldStop(1024);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 185)));
 break; }
case 3: {
 BA.debugLineNum = 237;BA.debugLine="Width = 205dip";
Debug.ShouldStop(4096);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 205)));
 BA.debugLineNum = 238;BA.debugLine="Height = 185dip";
Debug.ShouldStop(8192);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 185)));
 break; }
case 4: {
 BA.debugLineNum = 240;BA.debugLine="Width = 330dip";
Debug.ShouldStop(32768);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 330)));
 BA.debugLineNum = 241;BA.debugLine="Height = 185dip";
Debug.ShouldStop(65536);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 185)));
 break; }
case 5: {
 BA.debugLineNum = 243;BA.debugLine="Width = 205dip";
Debug.ShouldStop(262144);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 205)));
 BA.debugLineNum = 244;BA.debugLine="Height = 310dip";
Debug.ShouldStop(524288);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 310)));
 break; }
}
;
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _stickybtn_click() throws Exception{
try {
		Debug.PushSubsStack("stickyBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,152);
if (RapidSub.canDelegate("stickybtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","stickybtn_click");}
 BA.debugLineNum = 152;BA.debugLine="Private Sub stickyBtn_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="noteWindow(250dip, 180dip)";
Debug.ShouldStop(16777216);
_notewindow(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 180))));
 BA.debugLineNum = 154;BA.debugLine="notePnl.Visible = True";
Debug.ShouldStop(33554432);
corkactivity.mostCurrent._notepnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}