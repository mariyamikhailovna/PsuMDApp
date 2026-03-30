package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class corkactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,48);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
Debug.ShouldStop(65536);
corkactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("corkboardLayout")),corkactivity.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="penSpnr.AddAll(Array As String(\"Black\", \"Blue\", \"";
Debug.ShouldStop(131072);
corkactivity.mostCurrent._penspnr.runVoidMethod ("AddAll",(Object)(corkactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("Black"),BA.ObjectToString("Blue"),BA.ObjectToString("Green"),BA.ObjectToString("Red"),BA.ObjectToString("Yellow"),RemoteObject.createImmutable("Eraser")})))));
 BA.debugLineNum = 51;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(262144);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 52;BA.debugLine="imgPicker.Initialize(\"CC\")";
Debug.ShouldStop(524288);
corkactivity._imgpicker.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 };
 BA.debugLineNum = 54;BA.debugLine="penSpnr.Visible = False";
Debug.ShouldStop(2097152);
corkactivity.mostCurrent._penspnr.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 55;BA.debugLine="Width = 80dip";
Debug.ShouldStop(4194304);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));
 BA.debugLineNum = 56;BA.debugLine="Height = 60dip";
Debug.ShouldStop(8388608);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));
 BA.debugLineNum = 57;BA.debugLine="ddn.Initialize(Me, \"NoteDrag\")";
Debug.ShouldStop(16777216);
corkactivity.mostCurrent._ddn.runVoidMethod ("_initialize",corkactivity.processBA,(Object)(corkactivity.getObject()),(Object)(RemoteObject.createImmutable("NoteDrag")));
 BA.debugLineNum = 58;BA.debugLine="ddi.Initialize(Me, \"ImgDrag\")";
Debug.ShouldStop(33554432);
corkactivity.mostCurrent._ddi.runVoidMethod ("_initialize",corkactivity.processBA,(Object)(corkactivity.getObject()),(Object)(RemoteObject.createImmutable("ImgDrag")));
 BA.debugLineNum = 59;BA.debugLine="ddc.Initialize(Me, \"CanvasDrag\")";
Debug.ShouldStop(67108864);
corkactivity.mostCurrent._ddc.runVoidMethod ("_initialize",corkactivity.processBA,(Object)(corkactivity.getObject()),(Object)(RemoteObject.createImmutable("CanvasDrag")));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,66);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,62);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","activity_resume");}
 BA.debugLineNum = 62;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("AddCanvas (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,116);
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

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("AddCanvas (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,116);
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
 BA.debugLineNum = 117;BA.debugLine="Dim f As Panel";
Debug.ShouldStop(1048576);
_f = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("f", _f);
 BA.debugLineNum = 118;BA.debugLine="f.Initialize(\"CanvasFrame\")";
Debug.ShouldStop(2097152);
_f.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("CanvasFrame")));
 BA.debugLineNum = 119;BA.debugLine="f.Color = Colors.Black";
Debug.ShouldStop(4194304);
_f.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 120;BA.debugLine="boardPnl.AddView(f, x, y, Width + 20dip, Height +";
Debug.ShouldStop(8388608);
parent.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_f.getObject())),(Object)(_x),(Object)(_y),(Object)(RemoteObject.solve(new RemoteObject[] {parent._width,parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {parent._height,parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "+",1, 1)));
 BA.debugLineNum = 122;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(33554432);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 123;BA.debugLine="p.Initialize(\"CanvasPanel\")";
Debug.ShouldStop(67108864);
_p.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("CanvasPanel")));
 BA.debugLineNum = 124;BA.debugLine="p.Color = Colors.White";
Debug.ShouldStop(134217728);
_p.runVoidMethod ("setColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 125;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
Debug.ShouldStop(268435456);
_f.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(parent._width),(Object)(parent._height));
 BA.debugLineNum = 127;BA.debugLine="Sleep(0)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("Sleep",corkactivity.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "corkactivity", "addcanvas"),BA.numberCast(int.class, 0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 129;BA.debugLine="Dim cvs As B4XCanvas";
Debug.ShouldStop(1);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 130;BA.debugLine="cvs.Initialize(p)";
Debug.ShouldStop(2);
_cvs.runVoidMethod ("Initialize",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()));
 BA.debugLineNum = 131;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
Debug.ShouldStop(4);
_cvs.runVoidMethod ("DrawRect",(Object)(_cvs.runMethod(false,"getTargetRect")),(Object)(parent.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray")),(Object)(parent.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 132;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(8);
_cvs.runVoidMethod ("Invalidate");
 BA.debugLineNum = 133;BA.debugLine="p.Tag = cvs";
Debug.ShouldStop(16);
_p.runMethod(false,"setTag",(_cvs));
 BA.debugLineNum = 135;BA.debugLine="ddc.AddDragView(f, False)";
Debug.ShouldStop(64);
parent.mostCurrent._ddc.runVoidMethod ("_adddragview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _f.getObject()),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 136;BA.debugLine="ddc.AddPlaceView(place1).AddPlaceView(place2).Add";
Debug.ShouldStop(128);
parent.mostCurrent._ddc.runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place1.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place2.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place3.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place4.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place5.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place6.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place7.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place8.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place9.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place10.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place11.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._place12.getObject())).runVoidMethod ("_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent._deletelbl.getObject()));
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("addcBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,205);
if (RapidSub.canDelegate("addcbtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addcbtn_click");}
 BA.debugLineNum = 205;BA.debugLine="Private Sub addcBtn_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="AddCanvas(150dip, 500dip)";
Debug.ShouldStop(8192);
_addcanvas(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150))),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500))));
 BA.debugLineNum = 207;BA.debugLine="canvasPnl.Visible = False";
Debug.ShouldStop(16384);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("addnBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,196);
if (RapidSub.canDelegate("addnbtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addnbtn_click");}
 BA.debugLineNum = 196;BA.debugLine="Private Sub addnBtn_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 197;BA.debugLine="AddStickyNote(\"\", 150dip, 500dip)";
Debug.ShouldStop(16);
_addstickynote(BA.ObjectToString(""),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150))),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500))));
 BA.debugLineNum = 198;BA.debugLine="notePnl.Visible = False";
Debug.ShouldStop(32);
corkactivity.mostCurrent._notepnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 199;BA.debugLine="R = 255";
Debug.ShouldStop(64);
corkactivity._r = BA.numberCast(int.class, 255);
 BA.debugLineNum = 200;BA.debugLine="G = 105";
Debug.ShouldStop(128);
corkactivity._g = BA.numberCast(int.class, 105);
 BA.debugLineNum = 201;BA.debugLine="B = 97";
Debug.ShouldStop(256);
corkactivity._b = BA.numberCast(int.class, 97);
 BA.debugLineNum = 202;BA.debugLine="stickyBtn.Enabled = True";
Debug.ShouldStop(512);
corkactivity.mostCurrent._stickybtn.runMethod(true,"setEnabled",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("AddStickyNote (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,77);
if (RapidSub.canDelegate("addstickynote")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","addstickynote", _text, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
Debug.locals.put("Text", _text);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
 BA.debugLineNum = 77;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 79;BA.debugLine="p.Initialize(\"NotePanel\")";
Debug.ShouldStop(16384);
_p.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("NotePanel")));
 BA.debugLineNum = 80;BA.debugLine="p.Color = Colors.RGB(R, G, B)";
Debug.ShouldStop(32768);
_p.runVoidMethod ("setColor",corkactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(corkactivity._r),(Object)(corkactivity._g),(Object)(corkactivity._b)));
 BA.debugLineNum = 82;BA.debugLine="Dim txt As EditText";
Debug.ShouldStop(131072);
_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");Debug.locals.put("txt", _txt);
 BA.debugLineNum = 83;BA.debugLine="txt.Initialize(\"\")";
Debug.ShouldStop(262144);
_txt.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 84;BA.debugLine="txt.Text = Text";
Debug.ShouldStop(524288);
_txt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_text));
 BA.debugLineNum = 85;BA.debugLine="txt.TextSize = 12";
Debug.ShouldStop(1048576);
_txt.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 86;BA.debugLine="txt.Background = Null";
Debug.ShouldStop(2097152);
_txt.runMethod(false,"setBackground",(corkactivity.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 87;BA.debugLine="txt.TextColor = Colors.Black";
Debug.ShouldStop(4194304);
_txt.runMethod(true,"setTextColor",corkactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 88;BA.debugLine="txt.Gravity = Gravity.TOP";
Debug.ShouldStop(8388608);
_txt.runMethod(true,"setGravity",corkactivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 90;BA.debugLine="p.AddView(txt, 5dip, 15dip, 90dip, 70dip)";
Debug.ShouldStop(33554432);
_p.runVoidMethod ("AddView",(Object)((_txt.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 92;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
Debug.ShouldStop(134217728);
corkactivity.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_x),(Object)(_y),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 94;BA.debugLine="ddn.AddDragView(p, False)";
Debug.ShouldStop(536870912);
corkactivity.mostCurrent._ddn.runVoidMethod ("_adddragview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()),(Object)(corkactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 95;BA.debugLine="ddn.AddPlaceView(place1).AddPlaceView(place2).Add";
Debug.ShouldStop(1073741824);
corkactivity.mostCurrent._ddn.runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place1.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place2.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place3.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place4.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place5.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place6.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place7.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place8.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place9.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place10.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place11.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place12.getObject())).runVoidMethod ("_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._deletelbl.getObject()));
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
public static RemoteObject  _canvabtn_click() throws Exception{
try {
		Debug.PushSubsStack("canvaBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,223);
if (RapidSub.canDelegate("canvabtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvabtn_click");}
 BA.debugLineNum = 223;BA.debugLine="Private Sub canvaBtn_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 224;BA.debugLine="canvasWindow(250dip, 180dip)";
Debug.ShouldStop(-2147483648);
_canvaswindow(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 180))));
 BA.debugLineNum = 225;BA.debugLine="canvasPnl.Visible = True";
Debug.ShouldStop(1);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 226;BA.debugLine="penSpnr.Visible = True";
Debug.ShouldStop(2);
corkactivity.mostCurrent._penspnr.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _canvasdrag_placedview(RemoteObject _dragview,RemoteObject _placeview) throws Exception{
try {
		Debug.PushSubsStack("CanvasDrag_PlacedView (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,326);
if (RapidSub.canDelegate("canvasdrag_placedview")) { b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvasdrag_placedview", _dragview, _placeview); return;}
ResumableSub_CanvasDrag_PlacedView rsub = new ResumableSub_CanvasDrag_PlacedView(null,_dragview,_placeview);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_CanvasDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_CanvasDrag_PlacedView(b4a.example.corkactivity parent,RemoteObject _dragview,RemoteObject _placeview) {
this.parent = parent;
this._dragview = _dragview;
this._placeview = _placeview;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.corkactivity parent;
RemoteObject _dragview;
RemoteObject _placeview;
RemoteObject _res = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("CanvasDrag_PlacedView (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,326);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("DragView", _dragview);
Debug.locals.put("PlaceView", _placeview);
 BA.debugLineNum = 327;BA.debugLine="If PlaceView = deleteLbl Then";
Debug.ShouldStop(64);
if (true) break;

case 1:
//if
this.state = 8;
if (RemoteObject.solveBoolean("=",_placeview,parent.mostCurrent._deletelbl.getObject())) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 328;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete ca";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to delete canvas?")),(Object)(BA.ObjectToCharSequence("Delete Canvas")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),corkactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 329;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", corkactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "corkactivity", "canvasdrag_placedview"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 330;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(512);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 331;BA.debugLine="DragView.Visible = False";
Debug.ShouldStop(1024);
_dragview.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 332;BA.debugLine="DragView = Null";
Debug.ShouldStop(2048);
_dragview = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent.__c.getField(false,"Null"));Debug.locals.put("DragView", _dragview);
 BA.debugLineNum = 333;BA.debugLine="ToastMessageShow(\"Canvas Deleted\", False)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Canvas Deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 BA.debugLineNum = 336;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static RemoteObject  _canvaspanel_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("CanvasPanel_Touch (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,139);
if (RapidSub.canDelegate("canvaspanel_touch")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvaspanel_touch", _action, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 139;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="Dim p As Panel = Sender";
Debug.ShouldStop(2048);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), corkactivity.mostCurrent.__c.runMethod(false,"Sender",corkactivity.mostCurrent.activityBA));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 141;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
Debug.ShouldStop(4096);
_cvs = (_p.runMethod(false,"getTag"));Debug.locals.put("cvs", _cvs);Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 142;BA.debugLine="Select Action";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(_action,corkactivity.mostCurrent._activity.getField(true,"ACTION_DOWN"),corkactivity.mostCurrent._activity.getField(true,"ACTION_MOVE"))) {
case 0: {
 BA.debugLineNum = 144;BA.debugLine="LastX = X";
Debug.ShouldStop(32768);
corkactivity._lastx = _x;
 BA.debugLineNum = 145;BA.debugLine="LastY = Y";
Debug.ShouldStop(65536);
corkactivity._lasty = _y;
 break; }
case 1: {
 BA.debugLineNum = 147;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,";
Debug.ShouldStop(262144);
_cvs.runVoidMethod ("DrawLine",(Object)(corkactivity._lastx),(Object)(corkactivity._lasty),(Object)(_x),(Object)(_y),(Object)(corkactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(corkactivity._r2),(Object)(corkactivity._g2),(Object)(corkactivity._b2))),(Object)(BA.numberCast(float.class, corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3))))));
 BA.debugLineNum = 148;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(524288);
_cvs.runVoidMethod ("Invalidate");
 BA.debugLineNum = 149;BA.debugLine="LastX = X";
Debug.ShouldStop(1048576);
corkactivity._lastx = _x;
 BA.debugLineNum = 150;BA.debugLine="LastY = Y";
Debug.ShouldStop(2097152);
corkactivity._lasty = _y;
 break; }
}
;
 BA.debugLineNum = 152;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("canvasWindow (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,176);
if (RapidSub.canDelegate("canvaswindow")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","canvaswindow", _pw, _ph);}
RemoteObject _sizespnr = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
RemoteObject _addcbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("pW", _pw);
Debug.locals.put("pH", _ph);
 BA.debugLineNum = 176;BA.debugLine="Private Sub canvasWindow(pW As Int, pH As Int)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 177;BA.debugLine="canvasPnl = xui.CreatePanel(\"canvasPanel\")";
Debug.ShouldStop(65536);
corkactivity.mostCurrent._canvaspnl = corkactivity._xui.runMethod(false,"CreatePanel",corkactivity.processBA,(Object)(RemoteObject.createImmutable("canvasPanel")));
 BA.debugLineNum = 178;BA.debugLine="Activity.AddView(canvasPnl, 100dip, 225dip, pW, p";
Debug.ShouldStop(131072);
corkactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((corkactivity.mostCurrent._canvaspnl.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))),(Object)(_pw),(Object)(_ph));
 BA.debugLineNum = 179;BA.debugLine="canvasPnl.Color = xui.Color_RGB(50, 50, 50)";
Debug.ShouldStop(262144);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setColor",corkactivity._xui.runMethod(true,"Color_RGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 180;BA.debugLine="canvasPnl.SetColorAndBorder(xui.Color_White, 2dip";
Debug.ShouldStop(524288);
corkactivity.mostCurrent._canvaspnl.runVoidMethod ("SetColorAndBorder",(Object)(corkactivity._xui.getField(true,"Color_White")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(corkactivity._xui.getField(true,"Color_Black")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 182;BA.debugLine="Dim sizeSpnr As Spinner";
Debug.ShouldStop(2097152);
_sizespnr = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("sizeSpnr", _sizespnr);
 BA.debugLineNum = 183;BA.debugLine="sizeSpnr.Initialize(\"sizeSpnr\")";
Debug.ShouldStop(4194304);
_sizespnr.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sizeSpnr")));
 BA.debugLineNum = 184;BA.debugLine="sizeSpnr.AddAll(Array As String(\"1x1\", \"2x1\", \"1x";
Debug.ShouldStop(8388608);
_sizespnr.runVoidMethod ("AddAll",(Object)(corkactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("1x1"),BA.ObjectToString("2x1"),BA.ObjectToString("1x2"),BA.ObjectToString("2x2"),BA.ObjectToString("3x2"),RemoteObject.createImmutable("2x3")})))));
 BA.debugLineNum = 185;BA.debugLine="canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20";
Debug.ShouldStop(16777216);
corkactivity.mostCurrent._canvaspnl.runVoidMethod ("AddView",(Object)((_sizespnr.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_pw,corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 187;BA.debugLine="Dim addcBtn As Button";
Debug.ShouldStop(67108864);
_addcbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("addcBtn", _addcbtn);
 BA.debugLineNum = 188;BA.debugLine="addcBtn.Initialize(\"addcBtn\")";
Debug.ShouldStop(134217728);
_addcbtn.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addcBtn")));
 BA.debugLineNum = 189;BA.debugLine="addcBtn.Text = \"Add Canvas\"";
Debug.ShouldStop(268435456);
_addcbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Add Canvas"));
 BA.debugLineNum = 190;BA.debugLine="canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2)";
Debug.ShouldStop(536870912);
corkactivity.mostCurrent._canvaspnl.runVoidMethod ("AddView",(Object)((_addcbtn.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pw,RemoteObject.createImmutable(2)}, "/",0, 0)),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "-",1, 0))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 192;BA.debugLine="canvasPnl.Enabled = False";
Debug.ShouldStop(-2147483648);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setEnabled",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 193;BA.debugLine="canvasPnl.Visible = False";
Debug.ShouldStop(1);
corkactivity.mostCurrent._canvaspnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 194;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("CC_Result (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,99);
if (RapidSub.canDelegate("cc_result")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","cc_result", _success, _dir, _filename);}
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 99;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="If Success Then";
Debug.ShouldStop(8);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 101;BA.debugLine="imgView.Bitmap = LoadBitmapResize(Dir, FileName,";
Debug.ShouldStop(16);
corkactivity.mostCurrent._imgview.runMethod(false,"setBitmap",(corkactivity.mostCurrent.__c.runMethod(false,"LoadBitmapResize",(Object)(_dir),(Object)(_filename),(Object)(corkactivity.mostCurrent._imgview.runMethod(true,"getWidth")),(Object)(corkactivity.mostCurrent._imgview.runMethod(true,"getHeight")),(Object)(corkactivity.mostCurrent.__c.getField(true,"True"))).getObject()));
 }else {
 BA.debugLineNum = 103;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
Debug.ShouldStop(64);
corkactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No image selected")),(Object)(corkactivity.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("colorsSpnr_ItemClick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,254);
if (RapidSub.canDelegate("colorsspnr_itemclick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","colorsspnr_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 254;BA.debugLine="Private Sub colorsSpnr_ItemClick (Position As Int,";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 255;BA.debugLine="Select Position";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 257;BA.debugLine="R = 255";
Debug.ShouldStop(1);
corkactivity._r = BA.numberCast(int.class, 255);
 BA.debugLineNum = 258;BA.debugLine="G = 105";
Debug.ShouldStop(2);
corkactivity._g = BA.numberCast(int.class, 105);
 BA.debugLineNum = 259;BA.debugLine="B = 97";
Debug.ShouldStop(4);
corkactivity._b = BA.numberCast(int.class, 97);
 break; }
case 1: {
 BA.debugLineNum = 261;BA.debugLine="R = 155";
Debug.ShouldStop(16);
corkactivity._r = BA.numberCast(int.class, 155);
 BA.debugLineNum = 262;BA.debugLine="G = 190";
Debug.ShouldStop(32);
corkactivity._g = BA.numberCast(int.class, 190);
 BA.debugLineNum = 263;BA.debugLine="B = 237";
Debug.ShouldStop(64);
corkactivity._b = BA.numberCast(int.class, 237);
 break; }
case 2: {
 BA.debugLineNum = 265;BA.debugLine="R = 248";
Debug.ShouldStop(256);
corkactivity._r = BA.numberCast(int.class, 248);
 BA.debugLineNum = 266;BA.debugLine="G = 241";
Debug.ShouldStop(512);
corkactivity._g = BA.numberCast(int.class, 241);
 BA.debugLineNum = 267;BA.debugLine="B = 174";
Debug.ShouldStop(1024);
corkactivity._b = BA.numberCast(int.class, 174);
 break; }
}
;
 BA.debugLineNum = 269;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
 //BA.debugLineNum = 37;BA.debugLine="Private R = 255, G = 105, B = 97 As Int";
corkactivity._r = BA.numberCast(int.class, 255);
corkactivity._g = BA.numberCast(int.class, 105);
corkactivity._b = BA.numberCast(int.class, 97);
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
 //BA.debugLineNum = 42;BA.debugLine="Private deleteLbl As Label";
corkactivity.mostCurrent._deletelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Dim ddn As DragDropView";
corkactivity.mostCurrent._ddn = RemoteObject.createNew ("b4a.example.dragdropview");
 //BA.debugLineNum = 44;BA.debugLine="Dim ddi As DragDropView";
corkactivity.mostCurrent._ddi = RemoteObject.createNew ("b4a.example.dragdropview");
 //BA.debugLineNum = 45;BA.debugLine="Dim ddc As DragDropView";
corkactivity.mostCurrent._ddc = RemoteObject.createNew ("b4a.example.dragdropview");
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imgbtn_click() throws Exception{
try {
		Debug.PushSubsStack("imgBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,218);
if (RapidSub.canDelegate("imgbtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","imgbtn_click");}
 BA.debugLineNum = 218;BA.debugLine="Private Sub imgBtn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
Debug.ShouldStop(67108864);
corkactivity._imgpicker.runVoidMethod ("Show",corkactivity.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select a Photo")));
 BA.debugLineNum = 220;BA.debugLine="imgPick";
Debug.ShouldStop(134217728);
_imgpick();
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _imgdrag_placedview(RemoteObject _dragview,RemoteObject _placeview) throws Exception{
try {
		Debug.PushSubsStack("ImgDrag_PlacedView (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,314);
if (RapidSub.canDelegate("imgdrag_placedview")) { b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","imgdrag_placedview", _dragview, _placeview); return;}
ResumableSub_ImgDrag_PlacedView rsub = new ResumableSub_ImgDrag_PlacedView(null,_dragview,_placeview);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ImgDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_ImgDrag_PlacedView(b4a.example.corkactivity parent,RemoteObject _dragview,RemoteObject _placeview) {
this.parent = parent;
this._dragview = _dragview;
this._placeview = _placeview;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.corkactivity parent;
RemoteObject _dragview;
RemoteObject _placeview;
RemoteObject _res = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ImgDrag_PlacedView (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,314);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("DragView", _dragview);
Debug.locals.put("PlaceView", _placeview);
 BA.debugLineNum = 315;BA.debugLine="If PlaceView = deleteLbl Then";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//if
this.state = 8;
if (RemoteObject.solveBoolean("=",_placeview,parent.mostCurrent._deletelbl.getObject())) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 316;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete im";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to delete image?")),(Object)(BA.ObjectToCharSequence("Delete Image")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),corkactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 317;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", corkactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "corkactivity", "imgdrag_placedview"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 318;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(536870912);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 319;BA.debugLine="DragView.Visible = False";
Debug.ShouldStop(1073741824);
_dragview.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 320;BA.debugLine="DragView = Null";
Debug.ShouldStop(-2147483648);
_dragview = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent.__c.getField(false,"Null"));Debug.locals.put("DragView", _dragview);
 BA.debugLineNum = 321;BA.debugLine="ToastMessageShow(\"Image Deleted\", False)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Image Deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
public static RemoteObject  _imgpick() throws Exception{
try {
		Debug.PushSubsStack("imgPick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,107);
if (RapidSub.canDelegate("imgpick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","imgpick");}
 BA.debugLineNum = 107;BA.debugLine="Sub imgPick";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="imgView.Initialize(\"ImgView\")";
Debug.ShouldStop(2048);
corkactivity.mostCurrent._imgview.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ImgView")));
 BA.debugLineNum = 109;BA.debugLine="boardPnl.AddView(imgView, 150dip, 500dip, 100dip,";
Debug.ShouldStop(4096);
corkactivity.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((corkactivity.mostCurrent._imgview.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 111;BA.debugLine="ddi.AddDragView(imgView, False)";
Debug.ShouldStop(16384);
corkactivity.mostCurrent._ddi.runVoidMethod ("_adddragview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._imgview.getObject()),(Object)(corkactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 112;BA.debugLine="ddi.AddPlaceView(place1).AddPlaceView(place2).Add";
Debug.ShouldStop(32768);
corkactivity.mostCurrent._ddi.runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place1.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place2.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place3.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place4.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place5.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place6.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place7.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place8.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place9.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place10.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place11.getObject())).runMethod(false,"_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._place12.getObject())).runVoidMethod ("_addplaceview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), corkactivity.mostCurrent._deletelbl.getObject()));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _notedrag_placedview(RemoteObject _dragview,RemoteObject _placeview) throws Exception{
try {
		Debug.PushSubsStack("NoteDrag_PlacedView (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,302);
if (RapidSub.canDelegate("notedrag_placedview")) { b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","notedrag_placedview", _dragview, _placeview); return;}
ResumableSub_NoteDrag_PlacedView rsub = new ResumableSub_NoteDrag_PlacedView(null,_dragview,_placeview);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_NoteDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_NoteDrag_PlacedView(b4a.example.corkactivity parent,RemoteObject _dragview,RemoteObject _placeview) {
this.parent = parent;
this._dragview = _dragview;
this._placeview = _placeview;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.corkactivity parent;
RemoteObject _dragview;
RemoteObject _placeview;
RemoteObject _res = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("NoteDrag_PlacedView (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,302);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("DragView", _dragview);
Debug.locals.put("PlaceView", _placeview);
 BA.debugLineNum = 303;BA.debugLine="If PlaceView = deleteLbl Then";
Debug.ShouldStop(16384);
if (true) break;

case 1:
//if
this.state = 8;
if (RemoteObject.solveBoolean("=",_placeview,parent.mostCurrent._deletelbl.getObject())) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 304;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete no";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Are you sure you want to delete note?")),(Object)(BA.ObjectToCharSequence("Delete Note")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),corkactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 305;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", corkactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "corkactivity", "notedrag_placedview"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 306;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(131072);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 307;BA.debugLine="DragView.Visible = False";
Debug.ShouldStop(262144);
_dragview.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 308;BA.debugLine="DragView = Null";
Debug.ShouldStop(524288);
_dragview = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), parent.mostCurrent.__c.getField(false,"Null"));Debug.locals.put("DragView", _dragview);
 BA.debugLineNum = 309;BA.debugLine="ToastMessageShow(\"Note Deleted\", False)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Note Deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
public static RemoteObject  _notewindow(RemoteObject _pw,RemoteObject _ph) throws Exception{
try {
		Debug.PushSubsStack("noteWindow (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,156);
if (RapidSub.canDelegate("notewindow")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","notewindow", _pw, _ph);}
RemoteObject _colorsspnr = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
RemoteObject _addnbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("pW", _pw);
Debug.locals.put("pH", _ph);
 BA.debugLineNum = 156;BA.debugLine="Private Sub noteWindow(pW As Int, pH As Int)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="notePnl = xui.CreatePanel(\"notePnl\")";
Debug.ShouldStop(268435456);
corkactivity.mostCurrent._notepnl = corkactivity._xui.runMethod(false,"CreatePanel",corkactivity.processBA,(Object)(RemoteObject.createImmutable("notePnl")));
 BA.debugLineNum = 158;BA.debugLine="Activity.AddView(notePnl, 100dip, 225dip, pW, pH)";
Debug.ShouldStop(536870912);
corkactivity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((corkactivity.mostCurrent._notepnl.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))),(Object)(_pw),(Object)(_ph));
 BA.debugLineNum = 159;BA.debugLine="notePnl.Color = xui.Color_RGB(50, 50, 50)";
Debug.ShouldStop(1073741824);
corkactivity.mostCurrent._notepnl.runMethod(true,"setColor",corkactivity._xui.runMethod(true,"Color_RGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 160;BA.debugLine="notePnl.SetColorAndBorder(xui.Color_White, 2dip,";
Debug.ShouldStop(-2147483648);
corkactivity.mostCurrent._notepnl.runVoidMethod ("SetColorAndBorder",(Object)(corkactivity._xui.getField(true,"Color_White")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(corkactivity._xui.getField(true,"Color_Black")),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 162;BA.debugLine="Dim colorsSpnr As Spinner";
Debug.ShouldStop(2);
_colorsspnr = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("colorsSpnr", _colorsspnr);
 BA.debugLineNum = 163;BA.debugLine="colorsSpnr.Initialize(\"colorsSpnr\")";
Debug.ShouldStop(4);
_colorsspnr.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("colorsSpnr")));
 BA.debugLineNum = 164;BA.debugLine="colorsSpnr.AddAll(Array As String(\"Red\", \"Blue\",";
Debug.ShouldStop(8);
_colorsspnr.runVoidMethod ("AddAll",(Object)(corkactivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Red"),BA.ObjectToString("Blue"),RemoteObject.createImmutable("Yellow")})))));
 BA.debugLineNum = 165;BA.debugLine="notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20";
Debug.ShouldStop(16);
corkactivity.mostCurrent._notepnl.runVoidMethod ("AddView",(Object)((_colorsspnr.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_pw,corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 167;BA.debugLine="Dim addnBtn As Button";
Debug.ShouldStop(64);
_addnbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("addnBtn", _addnbtn);
 BA.debugLineNum = 168;BA.debugLine="addnBtn.Initialize(\"addnBtn\")";
Debug.ShouldStop(128);
_addnbtn.runVoidMethod ("Initialize",corkactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addnBtn")));
 BA.debugLineNum = 169;BA.debugLine="addnBtn.Text = \"Add Note\"";
Debug.ShouldStop(256);
_addnbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Add Note"));
 BA.debugLineNum = 170;BA.debugLine="notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) -";
Debug.ShouldStop(512);
corkactivity.mostCurrent._notepnl.runVoidMethod ("AddView",(Object)((_addnbtn.getObject())),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_pw,RemoteObject.createImmutable(2)}, "/",0, 0)),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "-",1, 0))),(Object)(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 172;BA.debugLine="notePnl.Enabled = False";
Debug.ShouldStop(2048);
corkactivity.mostCurrent._notepnl.runMethod(true,"setEnabled",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 173;BA.debugLine="notePnl.Visible = False";
Debug.ShouldStop(4096);
corkactivity.mostCurrent._notepnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("penSpnr_ItemClick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,271);
if (RapidSub.canDelegate("penspnr_itemclick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","penspnr_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 271;BA.debugLine="Private Sub penSpnr_ItemClick (Position As Int, Va";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="Select Position";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 274;BA.debugLine="R2 = 0";
Debug.ShouldStop(131072);
corkactivity._r2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 275;BA.debugLine="G2 = 0";
Debug.ShouldStop(262144);
corkactivity._g2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 276;BA.debugLine="B2 = 0";
Debug.ShouldStop(524288);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 1: {
 BA.debugLineNum = 278;BA.debugLine="R2 = 0";
Debug.ShouldStop(2097152);
corkactivity._r2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 279;BA.debugLine="G2 = 0";
Debug.ShouldStop(4194304);
corkactivity._g2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 280;BA.debugLine="B2 = 255";
Debug.ShouldStop(8388608);
corkactivity._b2 = BA.numberCast(int.class, 255);
 break; }
case 2: {
 BA.debugLineNum = 282;BA.debugLine="R2 = 0";
Debug.ShouldStop(33554432);
corkactivity._r2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 283;BA.debugLine="G2 = 255";
Debug.ShouldStop(67108864);
corkactivity._g2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 284;BA.debugLine="B2 = 0";
Debug.ShouldStop(134217728);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 3: {
 BA.debugLineNum = 286;BA.debugLine="R2 = 255";
Debug.ShouldStop(536870912);
corkactivity._r2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 287;BA.debugLine="G2 = 0";
Debug.ShouldStop(1073741824);
corkactivity._g2 = BA.numberCast(int.class, 0);
 BA.debugLineNum = 288;BA.debugLine="B2 = 0";
Debug.ShouldStop(-2147483648);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 4: {
 BA.debugLineNum = 290;BA.debugLine="R2 = 255";
Debug.ShouldStop(2);
corkactivity._r2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 291;BA.debugLine="G2 = 255";
Debug.ShouldStop(4);
corkactivity._g2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 292;BA.debugLine="B2 = 0";
Debug.ShouldStop(8);
corkactivity._b2 = BA.numberCast(int.class, 0);
 break; }
case 5: {
 BA.debugLineNum = 294;BA.debugLine="R2 = 255";
Debug.ShouldStop(32);
corkactivity._r2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 295;BA.debugLine="G2 = 255";
Debug.ShouldStop(64);
corkactivity._g2 = BA.numberCast(int.class, 255);
 BA.debugLineNum = 296;BA.debugLine="B2 = 255";
Debug.ShouldStop(128);
corkactivity._b2 = BA.numberCast(int.class, 255);
 break; }
}
;
 BA.debugLineNum = 298;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("sizeSpnr_ItemClick (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,231);
if (RapidSub.canDelegate("sizespnr_itemclick")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","sizespnr_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 231;BA.debugLine="Private Sub sizeSpnr_ItemClick (Position As Int, V";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="Select Position";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5))) {
case 0: {
 BA.debugLineNum = 234;BA.debugLine="Width = 80dip";
Debug.ShouldStop(512);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));
 BA.debugLineNum = 235;BA.debugLine="Height = 60dip";
Debug.ShouldStop(1024);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));
 break; }
case 1: {
 BA.debugLineNum = 237;BA.debugLine="Width = 205dip";
Debug.ShouldStop(4096);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 205)));
 BA.debugLineNum = 238;BA.debugLine="Height = 60dip";
Debug.ShouldStop(8192);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));
 break; }
case 2: {
 BA.debugLineNum = 240;BA.debugLine="Width = 80dip";
Debug.ShouldStop(32768);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));
 BA.debugLineNum = 241;BA.debugLine="Height = 185dip";
Debug.ShouldStop(65536);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 185)));
 break; }
case 3: {
 BA.debugLineNum = 243;BA.debugLine="Width = 205dip";
Debug.ShouldStop(262144);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 205)));
 BA.debugLineNum = 244;BA.debugLine="Height = 185dip";
Debug.ShouldStop(524288);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 185)));
 break; }
case 4: {
 BA.debugLineNum = 246;BA.debugLine="Width = 330dip";
Debug.ShouldStop(2097152);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 330)));
 BA.debugLineNum = 247;BA.debugLine="Height = 185dip";
Debug.ShouldStop(4194304);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 185)));
 break; }
case 5: {
 BA.debugLineNum = 249;BA.debugLine="Width = 205dip";
Debug.ShouldStop(16777216);
corkactivity._width = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 205)));
 BA.debugLineNum = 250;BA.debugLine="Height = 310dip";
Debug.ShouldStop(33554432);
corkactivity._height = corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 310)));
 break; }
}
;
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("stickyBtn_Click (corkactivity) ","corkactivity",8,corkactivity.mostCurrent.activityBA,corkactivity.mostCurrent,212);
if (RapidSub.canDelegate("stickybtn_click")) { return b4a.example.corkactivity.remoteMe.runUserSub(false, "corkactivity","stickybtn_click");}
 BA.debugLineNum = 212;BA.debugLine="Private Sub stickyBtn_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="noteWindow(250dip, 180dip)";
Debug.ShouldStop(1048576);
_notewindow(corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))),corkactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 180))));
 BA.debugLineNum = 214;BA.debugLine="notePnl.Visible = True";
Debug.ShouldStop(2097152);
corkactivity.mostCurrent._notepnl.runMethod(true,"setVisible",corkactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 215;BA.debugLine="stickyBtn.Enabled = False";
Debug.ShouldStop(4194304);
corkactivity.mostCurrent._stickybtn.runMethod(true,"setEnabled",corkactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}