package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class cork_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
Debug.ShouldStop(67108864);
cork.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("corkboardLayout")),cork.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(268435456);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 30;BA.debugLine="imgPicker.Initialize(\"CC\")";
Debug.ShouldStop(536870912);
cork._imgpicker.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 };
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,39);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Resume (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,35);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","activity_resume");}
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _addcanvas(RemoteObject _x,RemoteObject _y,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("AddCanvas (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,109);
if (RapidSub.canDelegate("addcanvas")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","addcanvas", _x, _y, _width, _height);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 109;BA.debugLine="Sub AddCanvas(x As Int, y As Int, Width As Int, He";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 111;BA.debugLine="p.Initialize(\"CanvasPanel\")";
Debug.ShouldStop(16384);
_p.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("CanvasPanel")));
 BA.debugLineNum = 112;BA.debugLine="p.Color = Colors.White";
Debug.ShouldStop(32768);
_p.runVoidMethod ("setColor",cork.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 113;BA.debugLine="boardPnl.AddView(p, x, y, Width, Height)";
Debug.ShouldStop(65536);
cork.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_x),(Object)(_y),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 115;BA.debugLine="Dim cvs As B4XCanvas";
Debug.ShouldStop(262144);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 116;BA.debugLine="cvs.Initialize(p)";
Debug.ShouldStop(524288);
_cvs.runVoidMethod ("Initialize",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _p.getObject()));
 BA.debugLineNum = 117;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
Debug.ShouldStop(1048576);
_cvs.runVoidMethod ("DrawRect",(Object)(_cvs.runMethod(false,"getTargetRect")),(Object)(cork.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray")),(Object)(cork.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 118;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(2097152);
_cvs.runVoidMethod ("Invalidate");
 BA.debugLineNum = 120;BA.debugLine="p.Tag = cvs";
Debug.ShouldStop(8388608);
_p.runMethod(false,"setTag",(_cvs));
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("AddStickyNote (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,76);
if (RapidSub.canDelegate("addstickynote")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","addstickynote", _text, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("Text", _text);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
 BA.debugLineNum = 76;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(4096);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 78;BA.debugLine="p.Initialize(\"Generic\")";
Debug.ShouldStop(8192);
_p.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Generic")));
 BA.debugLineNum = 79;BA.debugLine="p.Color = Colors.RGB(255, 192, 203)";
Debug.ShouldStop(16384);
_p.runVoidMethod ("setColor",cork.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 192)),(Object)(BA.numberCast(int.class, 203))));
 BA.debugLineNum = 81;BA.debugLine="stickyTxt.Initialize(\"stickyTxt\")";
Debug.ShouldStop(65536);
cork.mostCurrent._stickytxt.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("stickyTxt")));
 BA.debugLineNum = 82;BA.debugLine="stickyTxt.Text = Text";
Debug.ShouldStop(131072);
cork.mostCurrent._stickytxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_text));
 BA.debugLineNum = 83;BA.debugLine="stickyTxt.TextSize = 9";
Debug.ShouldStop(262144);
cork.mostCurrent._stickytxt.runMethod(true,"setTextSize",BA.numberCast(float.class, 9));
 BA.debugLineNum = 84;BA.debugLine="stickyTxt.Background = Null";
Debug.ShouldStop(524288);
cork.mostCurrent._stickytxt.runMethod(false,"setBackground",(cork.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 85;BA.debugLine="stickyTxt.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
cork.mostCurrent._stickytxt.runMethod(true,"setTextColor",cork.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 86;BA.debugLine="stickyTxt.Gravity = Gravity.TOP";
Debug.ShouldStop(2097152);
cork.mostCurrent._stickytxt.runMethod(true,"setGravity",cork.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 88;BA.debugLine="p.AddView(stickyTxt, 5dip, 15dip, 90dip, 70dip)";
Debug.ShouldStop(8388608);
_p.runVoidMethod ("AddView",(Object)((cork.mostCurrent._stickytxt.getObject())),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 90;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
Debug.ShouldStop(33554432);
cork.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_x),(Object)(_y),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
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
public static RemoteObject  _canvabtn_click() throws Exception{
try {
		Debug.PushSubsStack("canvaBtn_Click (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,151);
if (RapidSub.canDelegate("canvabtn_click")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","canvabtn_click");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
 BA.debugLineNum = 151;BA.debugLine="Private Sub canvaBtn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="Dim randomX As Int = Rnd(10dip, 150dip)";
Debug.ShouldStop(8388608);
_randomx = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 153;BA.debugLine="Dim randomY As Int = Rnd(100dip, 300dip)";
Debug.ShouldStop(16777216);
_randomy = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 154;BA.debugLine="AddCanvas(randomX, randomY, 200dip, 200dip)";
Debug.ShouldStop(33554432);
_addcanvas(_randomx,_randomy,cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))),cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))));
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
public static RemoteObject  _canvaspanel_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("CanvasPanel_Touch (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,123);
if (RapidSub.canDelegate("canvaspanel_touch")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","canvaspanel_touch", _action, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 123;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 124;BA.debugLine="Dim p As Panel = Sender";
Debug.ShouldStop(134217728);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), cork.mostCurrent.__c.runMethod(false,"Sender",cork.mostCurrent.activityBA));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 126;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
Debug.ShouldStop(536870912);
_cvs = (_p.runMethod(false,"getTag"));Debug.locals.put("cvs", _cvs);Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 127;BA.debugLine="Select Action";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(_action,cork.mostCurrent._activity.getField(true,"ACTION_DOWN"),cork.mostCurrent._activity.getField(true,"ACTION_MOVE"))) {
case 0: {
 BA.debugLineNum = 129;BA.debugLine="LastX = X";
Debug.ShouldStop(1);
cork._lastx = _x;
 BA.debugLineNum = 130;BA.debugLine="LastY = Y";
Debug.ShouldStop(2);
cork._lasty = _y;
 break; }
case 1: {
 BA.debugLineNum = 133;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.Black,";
Debug.ShouldStop(16);
_cvs.runVoidMethod ("DrawLine",(Object)(cork._lastx),(Object)(cork._lasty),(Object)(_x),(Object)(_y),(Object)(cork.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(float.class, cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3))))));
 BA.debugLineNum = 134;BA.debugLine="cvs.Invalidate ' This refresh is required to sh";
Debug.ShouldStop(32);
_cvs.runVoidMethod ("Invalidate");
 BA.debugLineNum = 135;BA.debugLine="LastX = X";
Debug.ShouldStop(64);
cork._lastx = _x;
 BA.debugLineNum = 136;BA.debugLine="LastY = Y";
Debug.ShouldStop(128);
cork._lasty = _y;
 break; }
}
;
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("CC_Result (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,94);
if (RapidSub.canDelegate("cc_result")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","cc_result", _success, _dir, _filename);}
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 94;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="If Success Then";
Debug.ShouldStop(1073741824);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 96;BA.debugLine="imgView.Bitmap = LoadBitmapResize(Dir, FileName,";
Debug.ShouldStop(-2147483648);
cork.mostCurrent._imgview.runMethod(false,"setBitmap",(cork.mostCurrent.__c.runMethod(false,"LoadBitmapResize",(Object)(_dir),(Object)(_filename),(Object)(cork.mostCurrent._imgview.runMethod(true,"getWidth")),(Object)(cork.mostCurrent._imgview.runMethod(true,"getHeight")),(Object)(cork.mostCurrent.__c.getField(true,"True"))).getObject()));
 }else {
 BA.debugLineNum = 98;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
Debug.ShouldStop(2);
cork.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No image selected")),(Object)(cork.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generic_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("Generic_Touch (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,50);
if (RapidSub.canDelegate("generic_touch")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","generic_touch", _action, _x, _y);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
RemoteObject _deltax = RemoteObject.createImmutable(0f);
RemoteObject _deltay = RemoteObject.createImmutable(0f);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 50;BA.debugLine="Sub Generic_Touch (Action As Int, X As Float, Y As";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Dim v As View = Sender";
Debug.ShouldStop(262144);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
_v = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), cork.mostCurrent.__c.runMethod(false,"Sender",cork.mostCurrent.activityBA));Debug.locals.put("v", _v);Debug.locals.put("v", _v);
 BA.debugLineNum = 53;BA.debugLine="Select Action";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(_action,cork.mostCurrent._activity.getField(true,"ACTION_DOWN"),cork.mostCurrent._activity.getField(true,"ACTION_MOVE"))) {
case 0: {
 BA.debugLineNum = 55;BA.debugLine="LastX = X";
Debug.ShouldStop(4194304);
cork._lastx = _x;
 BA.debugLineNum = 56;BA.debugLine="LastY = Y";
Debug.ShouldStop(8388608);
cork._lasty = _y;
 break; }
case 1: {
 BA.debugLineNum = 61;BA.debugLine="Dim deltaX As Float = X - LastX";
Debug.ShouldStop(268435456);
_deltax = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_x,cork._lastx}, "-",1, 0));Debug.locals.put("deltaX", _deltax);Debug.locals.put("deltaX", _deltax);
 BA.debugLineNum = 62;BA.debugLine="Dim deltaY As Float = Y - LastY";
Debug.ShouldStop(536870912);
_deltay = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_y,cork._lasty}, "-",1, 0));Debug.locals.put("deltaY", _deltay);Debug.locals.put("deltaY", _deltay);
 BA.debugLineNum = 65;BA.debugLine="v.Left = v.Left + deltaX";
Debug.ShouldStop(1);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getLeft"),_deltax}, "+",1, 0)));
 BA.debugLineNum = 66;BA.debugLine="v.Top = v.Top + deltaY";
Debug.ShouldStop(2);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getTop"),_deltay}, "+",1, 0)));
 BA.debugLineNum = 70;BA.debugLine="LastX = X";
Debug.ShouldStop(32);
cork._lastx = _x;
 BA.debugLineNum = 71;BA.debugLine="LastY = Y";
Debug.ShouldStop(64);
cork._lasty = _y;
 BA.debugLineNum = 72;BA.debugLine="v.BringToFront";
Debug.ShouldStop(128);
_v.runVoidMethod ("BringToFront");
 break; }
}
;
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private boardPnl As Panel";
cork.mostCurrent._boardpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private addPnl As Panel";
cork.mostCurrent._addpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private canvaBtn As Button";
cork.mostCurrent._canvabtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private imgBtn As Button";
cork.mostCurrent._imgbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private imgView As ImageView";
cork.mostCurrent._imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private stickyBtn As Button";
cork.mostCurrent._stickybtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private stringBtn As Button";
cork.mostCurrent._stringbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private stickyTxt As  EditText";
cork.mostCurrent._stickytxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private LastX, LastY As Float";
cork._lastx = RemoteObject.createImmutable(0f);
cork._lasty = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imgbtn_click() throws Exception{
try {
		Debug.PushSubsStack("imgBtn_Click (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,146);
if (RapidSub.canDelegate("imgbtn_click")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","imgbtn_click");}
 BA.debugLineNum = 146;BA.debugLine="Private Sub imgBtn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
Debug.ShouldStop(262144);
cork._imgpicker.runVoidMethod ("Show",cork.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Select a Photo")));
 BA.debugLineNum = 148;BA.debugLine="imgPick";
Debug.ShouldStop(524288);
_imgpick();
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("imgPick (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,102);
if (RapidSub.canDelegate("imgpick")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","imgpick");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
 BA.debugLineNum = 102;BA.debugLine="Sub imgPick";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="imgView.Initialize(\"Generic\")";
Debug.ShouldStop(64);
cork.mostCurrent._imgview.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Generic")));
 BA.debugLineNum = 104;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
Debug.ShouldStop(128);
_randomx = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 105;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
Debug.ShouldStop(256);
_randomy = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 106;BA.debugLine="Activity.AddView(imgView, randomX, randomY, 100di";
Debug.ShouldStop(512);
cork.mostCurrent._activity.runVoidMethod ("AddView",(Object)((cork.mostCurrent._imgview.getObject())),(Object)(_randomx),(Object)(_randomy),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
cork._imgpicker = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _stickybtn_click() throws Exception{
try {
		Debug.PushSubsStack("stickyBtn_Click (cork) ","cork",5,cork.mostCurrent.activityBA,cork.mostCurrent,140);
if (RapidSub.canDelegate("stickybtn_click")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","stickybtn_click");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
 BA.debugLineNum = 140;BA.debugLine="Private Sub stickyBtn_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
Debug.ShouldStop(4096);
_randomx = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 142;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
Debug.ShouldStop(8192);
_randomy = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 143;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
Debug.ShouldStop(16384);
_addstickynote(BA.ObjectToString(""),_randomx,_randomy);
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}