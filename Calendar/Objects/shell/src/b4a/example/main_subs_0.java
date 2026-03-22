package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _currentyear = RemoteObject.createImmutable(0);
RemoteObject _years = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _column = RemoteObject.createImmutable(0);
RemoteObject _cellw = RemoteObject.createImmutable(0);
RemoteObject _cellh = RemoteObject.createImmutable(0);
int _c = 0;
RemoteObject _celllabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(2097152);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 57;BA.debugLine="Month_btn.Color = Colors.blue";
Debug.ShouldStop(16777216);
main.mostCurrent._month_btn.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 59;BA.debugLine="kvs.Initialize(File.DirInternal, \"mydata\")";
Debug.ShouldStop(67108864);
main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("mydata")));
 BA.debugLineNum = 61;BA.debugLine="If kvs.ContainsKey(\"CalendarKVS\") Then";
Debug.ShouldStop(268435456);
if (main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_containskey" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("CalendarKVS"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 62;BA.debugLine="CalendarMap = kvs.Get(\"CalendarKVS\")";
Debug.ShouldStop(536870912);
main._calendarmap = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_get" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("CalendarKVS"))));
 }else {
 BA.debugLineNum = 64;BA.debugLine="CalendarMap.initialize";
Debug.ShouldStop(-2147483648);
main._calendarmap.runVoidMethod ("Initialize");
 };
 BA.debugLineNum = 69;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTim";
Debug.ShouldStop(16);
_currentyear = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentyear", _currentyear);Debug.locals.put("currentyear", _currentyear);
 BA.debugLineNum = 70;BA.debugLine="Dim years As List";
Debug.ShouldStop(32);
_years = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("years", _years);
 BA.debugLineNum = 71;BA.debugLine="years.Initialize";
Debug.ShouldStop(64);
_years.runVoidMethod ("Initialize");
 BA.debugLineNum = 72;BA.debugLine="For i = currentyear -10 To currentyear+10";
Debug.ShouldStop(128);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_currentyear,RemoteObject.createImmutable(10)}, "+",1, 1).<Integer>get().intValue();
_i = RemoteObject.solve(new RemoteObject[] {_currentyear,RemoteObject.createImmutable(10)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 73;BA.debugLine="years.Add(i)";
Debug.ShouldStop(256);
_years.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable((_i))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 75;BA.debugLine="YearSP.AddAll(years)";
Debug.ShouldStop(1024);
main.mostCurrent._yearsp.runVoidMethod ("AddAll",(Object)(_years));
 BA.debugLineNum = 76;BA.debugLine="YearSP.SelectedIndex = 10";
Debug.ShouldStop(2048);
main.mostCurrent._yearsp.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 10));
 BA.debugLineNum = 79;BA.debugLine="MonthSp.AddAll(Months)";
Debug.ShouldStop(16384);
main.mostCurrent._monthsp.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(main.mostCurrent._months))));
 BA.debugLineNum = 80;BA.debugLine="MonthSp.SelectedIndex = DateTime.GetMonth(DateTim";
Debug.ShouldStop(32768);
main.mostCurrent._monthsp.runMethod(true,"setSelectedIndex",RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 83;BA.debugLine="DrawCalendar(DateTime.GetMonth(DateTime.Now), Dat";
Debug.ShouldStop(262144);
_drawcalendar(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 86;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(2097152);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 87;BA.debugLine="cd.Initialize2(Colors.White, 0, 2dip, Colors.Blac";
Debug.ShouldStop(4194304);
_cd.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 89;BA.debugLine="Dim column As Int = 7";
Debug.ShouldStop(16777216);
_column = BA.numberCast(int.class, 7);Debug.locals.put("column", _column);Debug.locals.put("column", _column);
 BA.debugLineNum = 90;BA.debugLine="Dim cellW As Int = calendarpanel.Width/column";
Debug.ShouldStop(33554432);
_cellw = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._calendarpanel.runMethod(true,"getWidth"),_column}, "/",0, 0));Debug.locals.put("cellW", _cellw);Debug.locals.put("cellW", _cellw);
 BA.debugLineNum = 91;BA.debugLine="Dim cellH As Int = 60dip";
Debug.ShouldStop(67108864);
_cellh = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));Debug.locals.put("cellH", _cellh);Debug.locals.put("cellH", _cellh);
 BA.debugLineNum = 92;BA.debugLine="For c = 0 To column -1";
Debug.ShouldStop(134217728);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_column,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_c = 0 ;
for (;(step25 > 0 && _c <= limit25) || (step25 < 0 && _c >= limit25) ;_c = ((int)(0 + _c + step25))  ) {
Debug.locals.put("c", _c);
 BA.debugLineNum = 93;BA.debugLine="Dim celllabel As Label";
Debug.ShouldStop(268435456);
_celllabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("celllabel", _celllabel);
 BA.debugLineNum = 94;BA.debugLine="celllabel.Initialize(\"cell_label\")";
Debug.ShouldStop(536870912);
_celllabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell_label")));
 BA.debugLineNum = 95;BA.debugLine="Weekday(c)";
Debug.ShouldStop(1073741824);
_weekday(BA.numberCast(int.class, _c));
 BA.debugLineNum = 96;BA.debugLine="celllabel.Text = day_of_week";
Debug.ShouldStop(-2147483648);
_celllabel.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._day_of_week));
 BA.debugLineNum = 97;BA.debugLine="celllabel.TextSize = 14";
Debug.ShouldStop(1);
_celllabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 98;BA.debugLine="celllabel.Color = Colors.black";
Debug.ShouldStop(2);
_celllabel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 99;BA.debugLine="weekpanel.AddView(celllabel, c*cellW, 0, cellW,";
Debug.ShouldStop(4);
main.mostCurrent._weekpanel.runVoidMethod ("AddView",(Object)((_celllabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_c),_cellw}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cellw),(Object)(_cellh));
 BA.debugLineNum = 102;BA.debugLine="celllabel.Background = cd";
Debug.ShouldStop(32);
_celllabel.runMethod(false,"setBackground",(_cd.getObject()));
 }
}Debug.locals.put("c", _c);
;
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,313);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 313;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 315;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,309);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 309;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 311;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cell_click_click() throws Exception{
try {
		Debug.PushSubsStack("cell_click_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,258);
if (RapidSub.canDelegate("cell_click_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cell_click_click");}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _datestr = RemoteObject.createImmutable("");
 BA.debugLineNum = 258;BA.debugLine="Sub cell_click_click";
Debug.ShouldStop(2);
 BA.debugLineNum = 260;BA.debugLine="Dim p As Panel = Sender";
Debug.ShouldStop(8);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 261;BA.debugLine="Dim datestr As String = p.Tag";
Debug.ShouldStop(16);
_datestr = BA.ObjectToString(_p.runMethod(false,"getTag"));Debug.locals.put("datestr", _datestr);Debug.locals.put("datestr", _datestr);
 BA.debugLineNum = 262;BA.debugLine="Activity.finish";
Debug.ShouldStop(32);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 263;BA.debugLine="StartActivity(Day_MODULE)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._day_module.getObject())));
 BA.debugLineNum = 264;BA.debugLine="Day_MODULE.currentDate = datestr";
Debug.ShouldStop(128);
main.mostCurrent._day_module._currentdate /*RemoteObject*/  = _datestr;
 BA.debugLineNum = 265;BA.debugLine="Log(datestr)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6393223",_datestr,0);
 BA.debugLineNum = 267;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cleandebugger() throws Exception{
try {
		Debug.PushSubsStack("CleanDebugger (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,110);
if (RapidSub.canDelegate("cleandebugger")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cleandebugger");}
 BA.debugLineNum = 110;BA.debugLine="Sub CleanDebugger";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="CalendarMap.Clear";
Debug.ShouldStop(16384);
main._calendarmap.runVoidMethod ("Clear");
 BA.debugLineNum = 112;BA.debugLine="kvs.Put(\"CalendarKVS\", CalendarMap)";
Debug.ShouldStop(32768);
main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_put" /*RemoteObject*/ ,(Object)(BA.ObjectToString("CalendarKVS")),(Object)((main._calendarmap.getObject())));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _day_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Day_btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,339);
if (RapidSub.canDelegate("day_btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","day_btn_click");}
RemoteObject _currentyear = RemoteObject.createImmutable(0);
RemoteObject _currentmonth = RemoteObject.createImmutable(0);
RemoteObject _currentday = RemoteObject.createImmutable(0);
RemoteObject _datestr = RemoteObject.createImmutable("");
 BA.debugLineNum = 339;BA.debugLine="Private Sub Day_btn_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 340;BA.debugLine="If Day_MODULE.currentDate = \"\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent._day_module._currentdate /*RemoteObject*/ ,BA.ObjectToString(""))) { 
 BA.debugLineNum = 341;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTi";
Debug.ShouldStop(1048576);
_currentyear = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentyear", _currentyear);Debug.locals.put("currentyear", _currentyear);
 BA.debugLineNum = 342;BA.debugLine="Dim currentmonth As Int = DateTime.GetMonth(Date";
Debug.ShouldStop(2097152);
_currentmonth = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentmonth", _currentmonth);Debug.locals.put("currentmonth", _currentmonth);
 BA.debugLineNum = 343;BA.debugLine="Dim currentday As Int = DateTime.GetDayOfMonth(D";
Debug.ShouldStop(4194304);
_currentday = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentday", _currentday);Debug.locals.put("currentday", _currentday);
 BA.debugLineNum = 344;BA.debugLine="Dim datestr As String= currentyear & \"-\" & Numbe";
Debug.ShouldStop(8388608);
_datestr = RemoteObject.concat(_currentyear,RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _currentmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _currentday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);Debug.locals.put("datestr", _datestr);
 BA.debugLineNum = 345;BA.debugLine="Day_MODULE.currentDate = datestr";
Debug.ShouldStop(16777216);
main.mostCurrent._day_module._currentdate /*RemoteObject*/  = _datestr;
 BA.debugLineNum = 346;BA.debugLine="Log(Day_MODULE.currentDate)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6983047",main.mostCurrent._day_module._currentdate /*RemoteObject*/ ,0);
 };
 BA.debugLineNum = 349;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 350;BA.debugLine="StartActivity(Day_MODULE)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._day_module.getObject())));
 BA.debugLineNum = 351;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _daysinamonth(RemoteObject _month,RemoteObject _year) throws Exception{
try {
		Debug.PushSubsStack("Daysinamonth (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,270);
if (RapidSub.canDelegate("daysinamonth")) { return b4a.example.main.remoteMe.runUserSub(false, "main","daysinamonth", _month, _year);}
RemoteObject _nextmonth = RemoteObject.createImmutable(0);
RemoteObject _nextyear = RemoteObject.createImmutable(0);
RemoteObject _firstnextmonth = RemoteObject.createImmutable(0L);
RemoteObject _lastdaydate = RemoteObject.createImmutable(0L);
Debug.locals.put("Month", _month);
Debug.locals.put("year", _year);
 BA.debugLineNum = 270;BA.debugLine="Sub Daysinamonth(Month As Int, year As Int) As Int";
Debug.ShouldStop(8192);
 BA.debugLineNum = 271;BA.debugLine="Dim nextMonth As Int";
Debug.ShouldStop(16384);
_nextmonth = RemoteObject.createImmutable(0);Debug.locals.put("nextMonth", _nextmonth);
 BA.debugLineNum = 272;BA.debugLine="Dim nextyear As Int";
Debug.ShouldStop(32768);
_nextyear = RemoteObject.createImmutable(0);Debug.locals.put("nextyear", _nextyear);
 BA.debugLineNum = 274;BA.debugLine="If Month = 12 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, 12))) { 
 BA.debugLineNum = 275;BA.debugLine="nextMonth = 1";
Debug.ShouldStop(262144);
_nextmonth = BA.numberCast(int.class, 1);Debug.locals.put("nextMonth", _nextmonth);
 BA.debugLineNum = 276;BA.debugLine="nextyear = year+1";
Debug.ShouldStop(524288);
_nextyear = RemoteObject.solve(new RemoteObject[] {_year,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextyear", _nextyear);
 }else {
 BA.debugLineNum = 278;BA.debugLine="nextMonth = Month +1";
Debug.ShouldStop(2097152);
_nextmonth = RemoteObject.solve(new RemoteObject[] {_month,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextMonth", _nextmonth);
 BA.debugLineNum = 279;BA.debugLine="nextyear = year";
Debug.ShouldStop(4194304);
_nextyear = _year;Debug.locals.put("nextyear", _nextyear);
 };
 BA.debugLineNum = 282;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 283;BA.debugLine="Dim firstNextMonth As Long = DateTime.DateParse(n";
Debug.ShouldStop(67108864);
_firstnextmonth = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(RemoteObject.concat(_nextyear,RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _nextmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-01"))));Debug.locals.put("firstNextMonth", _firstnextmonth);Debug.locals.put("firstNextMonth", _firstnextmonth);
 BA.debugLineNum = 284;BA.debugLine="Dim lastDayDate As Long = firstNextMonth - DateTi";
Debug.ShouldStop(134217728);
_lastdaydate = RemoteObject.solve(new RemoteObject[] {_firstnextmonth,main.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "-",1, 2);Debug.locals.put("lastDayDate", _lastdaydate);Debug.locals.put("lastDayDate", _lastdaydate);
 BA.debugLineNum = 287;BA.debugLine="Return DateTime.GetDayOfMonth(lastDayDate)";
Debug.ShouldStop(1073741824);
if (true) return main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(_lastdaydate));
 BA.debugLineNum = 289;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawcalendar(RemoteObject _month,RemoteObject _year) throws Exception{
try {
		Debug.PushSubsStack("DrawCalendar (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("drawcalendar")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawcalendar", _month, _year);}
RemoteObject _firstday = RemoteObject.createImmutable(0L);
RemoteObject _startday = RemoteObject.createImmutable(0);
RemoteObject _daysinmonth = RemoteObject.createImmutable(0);
RemoteObject _prevmonth = RemoteObject.createImmutable(0);
RemoteObject _prevyear = RemoteObject.createImmutable(0);
RemoteObject _daysinprevmonth = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _rows = RemoteObject.createImmutable(0);
RemoteObject _column = RemoteObject.createImmutable(0);
RemoteObject _day = RemoteObject.createImmutable(0);
RemoteObject _started = RemoteObject.createImmutable(false);
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _cellw = RemoteObject.createImmutable(0);
RemoteObject _cellh = RemoteObject.createImmutable(0);
int _r = 0;
int _c = 0;
RemoteObject _cell = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _displayday = RemoteObject.createImmutable(0);
RemoteObject _datestr = RemoteObject.createImmutable("");
RemoteObject _nextmonth = RemoteObject.createImmutable(0);
RemoteObject _nextyear = RemoteObject.createImmutable(0);
RemoteObject _eventmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _allevents = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _maxshow = RemoteObject.createImmutable(0);
RemoteObject _yoffset = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _ev = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _dot = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _morelbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("month", _month);
Debug.locals.put("year", _year);
 BA.debugLineNum = 115;BA.debugLine="Sub DrawCalendar (month As Int, year As Int)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="calendarpanel.RemoveAllViews";
Debug.ShouldStop(1048576);
main.mostCurrent._calendarpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 120;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 121;BA.debugLine="Dim firstDay As Long = DateTime.DateParse(year &";
Debug.ShouldStop(16777216);
_firstday = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(RemoteObject.concat(_year,RemoteObject.createImmutable("-"),_month,RemoteObject.createImmutable("-01"))));Debug.locals.put("firstDay", _firstday);Debug.locals.put("firstDay", _firstday);
 BA.debugLineNum = 122;BA.debugLine="Dim startDay As Int = DateTime.GetDayOfweek(first";
Debug.ShouldStop(33554432);
_startday = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(_firstday));Debug.locals.put("startDay", _startday);Debug.locals.put("startDay", _startday);
 BA.debugLineNum = 123;BA.debugLine="Dim daysInmonth As Int = Daysinamonth(month, year";
Debug.ShouldStop(67108864);
_daysinmonth = _daysinamonth(_month,_year);Debug.locals.put("daysInmonth", _daysinmonth);Debug.locals.put("daysInmonth", _daysinmonth);
 BA.debugLineNum = 127;BA.debugLine="Dim prevmonth As Int";
Debug.ShouldStop(1073741824);
_prevmonth = RemoteObject.createImmutable(0);Debug.locals.put("prevmonth", _prevmonth);
 BA.debugLineNum = 128;BA.debugLine="Dim prevyear As Int";
Debug.ShouldStop(-2147483648);
_prevyear = RemoteObject.createImmutable(0);Debug.locals.put("prevyear", _prevyear);
 BA.debugLineNum = 130;BA.debugLine="If month = 1 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 131;BA.debugLine="prevmonth = 12";
Debug.ShouldStop(4);
_prevmonth = BA.numberCast(int.class, 12);Debug.locals.put("prevmonth", _prevmonth);
 BA.debugLineNum = 132;BA.debugLine="prevyear = year - 1";
Debug.ShouldStop(8);
_prevyear = RemoteObject.solve(new RemoteObject[] {_year,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("prevyear", _prevyear);
 }else {
 BA.debugLineNum = 134;BA.debugLine="prevmonth = month-1";
Debug.ShouldStop(32);
_prevmonth = RemoteObject.solve(new RemoteObject[] {_month,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("prevmonth", _prevmonth);
 BA.debugLineNum = 135;BA.debugLine="prevyear = year";
Debug.ShouldStop(64);
_prevyear = _year;Debug.locals.put("prevyear", _prevyear);
 };
 BA.debugLineNum = 137;BA.debugLine="Dim daysInprevMonth As Int = Daysinamonth(prevmon";
Debug.ShouldStop(256);
_daysinprevmonth = _daysinamonth(_prevmonth,_prevyear);Debug.locals.put("daysInprevMonth", _daysinprevmonth);Debug.locals.put("daysInprevMonth", _daysinprevmonth);
 BA.debugLineNum = 141;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(4096);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 142;BA.debugLine="cd.Initialize2(Colors.White, 0, 2dip, Colors.Blac";
Debug.ShouldStop(8192);
_cd.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 144;BA.debugLine="Dim rows As Int = 6  'number of rows (days)";
Debug.ShouldStop(32768);
_rows = BA.numberCast(int.class, 6);Debug.locals.put("rows", _rows);Debug.locals.put("rows", _rows);
 BA.debugLineNum = 145;BA.debugLine="Dim column As Int = 7 'number of columns (the wee";
Debug.ShouldStop(65536);
_column = BA.numberCast(int.class, 7);Debug.locals.put("column", _column);Debug.locals.put("column", _column);
 BA.debugLineNum = 147;BA.debugLine="Dim day As Int = 1";
Debug.ShouldStop(262144);
_day = BA.numberCast(int.class, 1);Debug.locals.put("day", _day);Debug.locals.put("day", _day);
 BA.debugLineNum = 148;BA.debugLine="Dim started As Boolean = False";
Debug.ShouldStop(524288);
_started = main.mostCurrent.__c.getField(true,"False");Debug.locals.put("started", _started);Debug.locals.put("started", _started);
 BA.debugLineNum = 150;BA.debugLine="Dim index As Int = 0";
Debug.ShouldStop(2097152);
_index = BA.numberCast(int.class, 0);Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 152;BA.debugLine="Dim cellW As Int = calendarpanel.width / column";
Debug.ShouldStop(8388608);
_cellw = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._calendarpanel.runMethod(true,"getWidth"),_column}, "/",0, 0));Debug.locals.put("cellW", _cellw);Debug.locals.put("cellW", _cellw);
 BA.debugLineNum = 153;BA.debugLine="Dim cellH As Int = 60dip";
Debug.ShouldStop(16777216);
_cellh = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));Debug.locals.put("cellH", _cellh);Debug.locals.put("cellH", _cellh);
 BA.debugLineNum = 154;BA.debugLine="For r = 0 To rows -1";
Debug.ShouldStop(33554432);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_rows,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_r = 0 ;
for (;(step25 > 0 && _r <= limit25) || (step25 < 0 && _r >= limit25) ;_r = ((int)(0 + _r + step25))  ) {
Debug.locals.put("r", _r);
 BA.debugLineNum = 155;BA.debugLine="For c = 0 To column -1";
Debug.ShouldStop(67108864);
{
final int step26 = 1;
final int limit26 = RemoteObject.solve(new RemoteObject[] {_column,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_c = 0 ;
for (;(step26 > 0 && _c <= limit26) || (step26 < 0 && _c >= limit26) ;_c = ((int)(0 + _c + step26))  ) {
Debug.locals.put("c", _c);
 BA.debugLineNum = 157;BA.debugLine="Dim cell As Panel";
Debug.ShouldStop(268435456);
_cell = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("cell", _cell);
 BA.debugLineNum = 158;BA.debugLine="cell.Initialize(\"cell_click\")";
Debug.ShouldStop(536870912);
_cell.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell_click")));
 BA.debugLineNum = 159;BA.debugLine="cell.Enabled  =True";
Debug.ShouldStop(1073741824);
_cell.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 161;BA.debugLine="calendarpanel.AddView(cell, c * cellW, r * cell";
Debug.ShouldStop(1);
main.mostCurrent._calendarpanel.runVoidMethod ("AddView",(Object)((_cell.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_c),_cellw}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_r),_cellh}, "*",0, 1)),(Object)(_cellw),(Object)(_cellh));
 BA.debugLineNum = 162;BA.debugLine="cell.Background = cd";
Debug.ShouldStop(2);
_cell.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 164;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(8);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 165;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(16);
_lbl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 166;BA.debugLine="lbl.Gravity = Gravity.CENTER_Horizontal";
Debug.ShouldStop(32);
_lbl.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 167;BA.debugLine="lbl.Enabled = False";
Debug.ShouldStop(64);
_lbl.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 169;BA.debugLine="index = index +1";
Debug.ShouldStop(256);
_index = RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("index", _index);
 BA.debugLineNum = 171;BA.debugLine="Dim displayday As Int";
Debug.ShouldStop(1024);
_displayday = RemoteObject.createImmutable(0);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 172;BA.debugLine="Dim datestr As String";
Debug.ShouldStop(2048);
_datestr = RemoteObject.createImmutable("");Debug.locals.put("datestr", _datestr);
 BA.debugLineNum = 175;BA.debugLine="If index < startDay Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("<",_index,BA.numberCast(double.class, _startday))) { 
 BA.debugLineNum = 176;BA.debugLine="displayday = daysInprevMonth - (startDay - inde";
Debug.ShouldStop(32768);
_displayday = RemoteObject.solve(new RemoteObject[] {_daysinprevmonth,(RemoteObject.solve(new RemoteObject[] {_startday,_index}, "-",1, 1)),RemoteObject.createImmutable(1)}, "-+",2, 1);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 177;BA.debugLine="lbl.TextColor = Colors.gray";
Debug.ShouldStop(65536);
_lbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 178;BA.debugLine="datestr = prevyear & \"-\" & NumberFormat(prevmon";
Debug.ShouldStop(131072);
_datestr = RemoteObject.concat(_prevyear,RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _prevmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _displayday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);
 }else 
{ BA.debugLineNum = 179;BA.debugLine="Else if index >= startDay And index < startDay +";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("g",_index,BA.numberCast(double.class, _startday)) && RemoteObject.solveBoolean("<",_index,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_startday,_daysinmonth}, "+",1, 1)))) { 
 BA.debugLineNum = 180;BA.debugLine="displayday = index - startDay + 1";
Debug.ShouldStop(524288);
_displayday = RemoteObject.solve(new RemoteObject[] {_index,_startday,RemoteObject.createImmutable(1)}, "-+",2, 1);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 181;BA.debugLine="lbl.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
_lbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 182;BA.debugLine="datestr = year&\"-\"&NumberFormat(month,2,0)&\"-\"&";
Debug.ShouldStop(2097152);
_datestr = RemoteObject.concat(_year,RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _month)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _displayday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);
 }else {
 BA.debugLineNum = 184;BA.debugLine="displayday = index - (startDay + daysInmonth) +";
Debug.ShouldStop(8388608);
_displayday = RemoteObject.solve(new RemoteObject[] {_index,(RemoteObject.solve(new RemoteObject[] {_startday,_daysinmonth}, "+",1, 1)),RemoteObject.createImmutable(1)}, "-+",2, 1);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 185;BA.debugLine="lbl.TextColor = Colors.Gray";
Debug.ShouldStop(16777216);
_lbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 186;BA.debugLine="Dim nextmonth As Int";
Debug.ShouldStop(33554432);
_nextmonth = RemoteObject.createImmutable(0);Debug.locals.put("nextmonth", _nextmonth);
 BA.debugLineNum = 187;BA.debugLine="Dim nextyear As Int";
Debug.ShouldStop(67108864);
_nextyear = RemoteObject.createImmutable(0);Debug.locals.put("nextyear", _nextyear);
 BA.debugLineNum = 189;BA.debugLine="If month = 12 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, 12))) { 
 BA.debugLineNum = 190;BA.debugLine="nextmonth = 1";
Debug.ShouldStop(536870912);
_nextmonth = BA.numberCast(int.class, 1);Debug.locals.put("nextmonth", _nextmonth);
 BA.debugLineNum = 191;BA.debugLine="nextyear = year+1";
Debug.ShouldStop(1073741824);
_nextyear = RemoteObject.solve(new RemoteObject[] {_year,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextyear", _nextyear);
 }else {
 BA.debugLineNum = 193;BA.debugLine="nextmonth = month+1";
Debug.ShouldStop(1);
_nextmonth = RemoteObject.solve(new RemoteObject[] {_month,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextmonth", _nextmonth);
 BA.debugLineNum = 194;BA.debugLine="nextyear = year";
Debug.ShouldStop(2);
_nextyear = _year;Debug.locals.put("nextyear", _nextyear);
 BA.debugLineNum = 195;BA.debugLine="datestr = nextyear&\"-\"&NumberFormat(nextmonth,";
Debug.ShouldStop(4);
_datestr = RemoteObject.concat(_nextyear,RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _nextmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _displayday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);
 };
 }}
;
 BA.debugLineNum = 200;BA.debugLine="lbl.Text = displayday";
Debug.ShouldStop(128);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_displayday));
 BA.debugLineNum = 201;BA.debugLine="cell.Tag = datestr";
Debug.ShouldStop(256);
_cell.runMethod(false,"setTag",(_datestr));
 BA.debugLineNum = 202;BA.debugLine="lbl.Enabled = False";
Debug.ShouldStop(512);
_lbl.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 203;BA.debugLine="cell.AddView(lbl, 0, 0, cellW, cellH)";
Debug.ShouldStop(1024);
_cell.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cellw),(Object)(_cellh));
 BA.debugLineNum = 205;BA.debugLine="If CalendarMap.ContainsKey(datestr) Then";
Debug.ShouldStop(4096);
if (main._calendarmap.runMethod(true,"ContainsKey",(Object)((_datestr))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 206;BA.debugLine="Dim eventmap As Map = CalendarMap.Get(datestr)";
Debug.ShouldStop(8192);
_eventmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_eventmap = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), main._calendarmap.runMethod(false,"Get",(Object)((_datestr))));Debug.locals.put("eventmap", _eventmap);Debug.locals.put("eventmap", _eventmap);
 BA.debugLineNum = 207;BA.debugLine="Dim allevents As List = eventmap.Get(\"AllEvent";
Debug.ShouldStop(16384);
_allevents = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_allevents = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _eventmap.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("AllEvents")))));Debug.locals.put("allevents", _allevents);Debug.locals.put("allevents", _allevents);
 BA.debugLineNum = 209;BA.debugLine="Dim maxShow As Int = Min(allevents.Size, 2)";
Debug.ShouldStop(65536);
_maxshow = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _allevents.runMethod(true,"getSize"))),(Object)(BA.numberCast(double.class, 2))));Debug.locals.put("maxShow", _maxshow);Debug.locals.put("maxShow", _maxshow);
 BA.debugLineNum = 210;BA.debugLine="Dim yoffset As Int = 20dip";
Debug.ShouldStop(131072);
_yoffset = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("yoffset", _yoffset);Debug.locals.put("yoffset", _yoffset);
 BA.debugLineNum = 212;BA.debugLine="For i = 0 To maxShow -1";
Debug.ShouldStop(524288);
{
final int step70 = 1;
final int limit70 = RemoteObject.solve(new RemoteObject[] {_maxshow,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70) ;_i = ((int)(0 + _i + step70))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 213;BA.debugLine="Dim ev As Map = allevents.Get(i)";
Debug.ShouldStop(1048576);
_ev = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_ev = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _allevents.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("ev", _ev);Debug.locals.put("ev", _ev);
 BA.debugLineNum = 215;BA.debugLine="Dim dot As Label";
Debug.ShouldStop(4194304);
_dot = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("dot", _dot);
 BA.debugLineNum = 216;BA.debugLine="dot.Initialize(\"\")";
Debug.ShouldStop(8388608);
_dot.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 217;BA.debugLine="dot.Text = ev.Get(\"Title\")";
Debug.ShouldStop(16777216);
_dot.runMethod(true,"setText",BA.ObjectToCharSequence(_ev.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Title"))))));
 BA.debugLineNum = 218;BA.debugLine="dot.TextSize = 8";
Debug.ShouldStop(33554432);
_dot.runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 219;BA.debugLine="dot.TextColor = Colors.white";
Debug.ShouldStop(67108864);
_dot.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 220;BA.debugLine="dot.Color = IdentifyColor(ev.Get(\"Tags\"))";
Debug.ShouldStop(134217728);
_dot.runVoidMethod ("setColor",_identifycolor(BA.ObjectToString(_ev.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Tags")))))));
 BA.debugLineNum = 221;BA.debugLine="dot.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(268435456);
_dot.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 222;BA.debugLine="dot.SingleLine = True";
Debug.ShouldStop(536870912);
_dot.runVoidMethod ("setSingleLine",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 223;BA.debugLine="dot.Ellipsize = \"END\"";
Debug.ShouldStop(1073741824);
_dot.runMethod(true,"setEllipsize",BA.ObjectToString("END"));
 BA.debugLineNum = 224;BA.debugLine="cell.AddView(dot, 2dip, yoffset +i*12dip, cel";
Debug.ShouldStop(-2147483648);
_cell.runVoidMethod ("AddView",(Object)((_dot.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_yoffset,RemoteObject.createImmutable(_i),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_cellw,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 227;BA.debugLine="If allevents.Size > 2 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_allevents.runMethod(true,"getSize"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 228;BA.debugLine="Dim morelbl As Label";
Debug.ShouldStop(8);
_morelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("morelbl", _morelbl);
 BA.debugLineNum = 229;BA.debugLine="morelbl.Initialize(\"\")";
Debug.ShouldStop(16);
_morelbl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 230;BA.debugLine="morelbl.Text = \"+\" & (allevents.Size -2)";
Debug.ShouldStop(32);
_morelbl.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("+"),(RemoteObject.solve(new RemoteObject[] {_allevents.runMethod(true,"getSize"),RemoteObject.createImmutable(2)}, "-",1, 1)))));
 BA.debugLineNum = 231;BA.debugLine="morelbl.TextSize = 8";
Debug.ShouldStop(64);
_morelbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 232;BA.debugLine="morelbl.TextColor = Colors.black";
Debug.ShouldStop(128);
_morelbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 233;BA.debugLine="cell.AddView(morelbl, 2dip , yoffset + 2 * 12";
Debug.ShouldStop(256);
_cell.runVoidMethod ("AddView",(Object)((_morelbl.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_yoffset,RemoteObject.createImmutable(2),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+*",1, 1)),(Object)(_cellw),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 };
 };
 }
}Debug.locals.put("c", _c);
;
 }
}Debug.locals.put("r", _r);
;
 BA.debugLineNum = 240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Dim Months(12) As String";
main.mostCurrent._months = RemoteObject.createNewArray ("String", new int[] {12}, new Object[]{});
 //BA.debugLineNum = 29;BA.debugLine="Months(0) = \"January\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("January"),BA.numberCast(int.class, 0));
 //BA.debugLineNum = 30;BA.debugLine="Months(1) = \"February\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("February"),BA.numberCast(int.class, 1));
 //BA.debugLineNum = 31;BA.debugLine="Months(2) = \"March\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("March"),BA.numberCast(int.class, 2));
 //BA.debugLineNum = 32;BA.debugLine="Months(3) = \"April\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("April"),BA.numberCast(int.class, 3));
 //BA.debugLineNum = 33;BA.debugLine="Months(4) = \"May\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("May"),BA.numberCast(int.class, 4));
 //BA.debugLineNum = 34;BA.debugLine="Months(5) = \"June\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("June"),BA.numberCast(int.class, 5));
 //BA.debugLineNum = 35;BA.debugLine="Months(6) = \"July\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("July"),BA.numberCast(int.class, 6));
 //BA.debugLineNum = 36;BA.debugLine="Months(7) = \"August\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("August"),BA.numberCast(int.class, 7));
 //BA.debugLineNum = 37;BA.debugLine="Months(8) = \"September\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("September"),BA.numberCast(int.class, 8));
 //BA.debugLineNum = 38;BA.debugLine="Months(9) = \"October\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("October"),BA.numberCast(int.class, 9));
 //BA.debugLineNum = 39;BA.debugLine="Months(10) = \"November\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("November"),BA.numberCast(int.class, 10));
 //BA.debugLineNum = 40;BA.debugLine="Months(11) = \"December\"";
main.mostCurrent._months.setArrayElement (BA.ObjectToString("December"),BA.numberCast(int.class, 11));
 //BA.debugLineNum = 44;BA.debugLine="Private calendarpanel As Panel";
main.mostCurrent._calendarpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private weekpanel As Panel";
main.mostCurrent._weekpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Dim day_of_week As String";
main.mostCurrent._day_of_week = RemoteObject.createImmutable("");
 //BA.debugLineNum = 47;BA.debugLine="Private MonthSp As Spinner";
main.mostCurrent._monthsp = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private YearSP As Spinner";
main.mostCurrent._yearsp = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private menupanel As Panel";
main.mostCurrent._menupanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private Month_btn As Button";
main.mostCurrent._month_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _identifycolor(RemoteObject _typeofevent) throws Exception{
try {
		Debug.PushSubsStack("IdentifyColor (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,242);
if (RapidSub.canDelegate("identifycolor")) { return b4a.example.main.remoteMe.runUserSub(false, "main","identifycolor", _typeofevent);}
RemoteObject _mycolor = RemoteObject.createImmutable(0);
Debug.locals.put("typeofevent", _typeofevent);
 BA.debugLineNum = 242;BA.debugLine="Sub IdentifyColor (typeofevent As String) As Int";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="Dim mycolor As Int";
Debug.ShouldStop(262144);
_mycolor = RemoteObject.createImmutable(0);Debug.locals.put("mycolor", _mycolor);
 BA.debugLineNum = 244;BA.debugLine="If typeofevent = \"Task\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("Task"))) { 
 BA.debugLineNum = 245;BA.debugLine="mycolor = Colors.Blue";
Debug.ShouldStop(1048576);
_mycolor = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue");Debug.locals.put("mycolor", _mycolor);
 }else 
{ BA.debugLineNum = 246;BA.debugLine="Else if typeofevent = \"Event\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("Event"))) { 
 BA.debugLineNum = 247;BA.debugLine="mycolor = Colors.Green";
Debug.ShouldStop(4194304);
_mycolor = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green");Debug.locals.put("mycolor", _mycolor);
 }else 
{ BA.debugLineNum = 248;BA.debugLine="Else if typeofevent = \"Birthday\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("Birthday"))) { 
 BA.debugLineNum = 249;BA.debugLine="mycolor = Colors.Magenta";
Debug.ShouldStop(16777216);
_mycolor = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Magenta");Debug.locals.put("mycolor", _mycolor);
 }else 
{ BA.debugLineNum = 250;BA.debugLine="Else if typeofevent = \"OOO\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("OOO"))) { 
 BA.debugLineNum = 251;BA.debugLine="mycolor = Colors.Yellow";
Debug.ShouldStop(67108864);
_mycolor = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow");Debug.locals.put("mycolor", _mycolor);
 }}}}
;
 BA.debugLineNum = 254;BA.debugLine="Return mycolor";
Debug.ShouldStop(536870912);
if (true) return _mycolor;
 BA.debugLineNum = 255;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _menu_btn_click() throws Exception{
try {
		Debug.PushSubsStack("menu_btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,330);
if (RapidSub.canDelegate("menu_btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","menu_btn_click");}
 BA.debugLineNum = 330;BA.debugLine="Private Sub menu_btn_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 331;BA.debugLine="menupanel.Visible =True";
Debug.ShouldStop(1024);
main.mostCurrent._menupanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 332;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _month_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Month_btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,358);
if (RapidSub.canDelegate("month_btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","month_btn_click");}
 BA.debugLineNum = 358;BA.debugLine="Private Sub Month_btn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 359;BA.debugLine="menupanel.Visible = False";
Debug.ShouldStop(64);
main.mostCurrent._menupanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 360;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _monthsp_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("MonthSp_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,318);
if (RapidSub.canDelegate("monthsp_itemclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","monthsp_itemclick", _position, _value);}
RemoteObject _selectedmonth = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 318;BA.debugLine="Private Sub MonthSp_ItemClick (Position As Int, Va";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 319;BA.debugLine="Dim selectedmonth As Int = Position +1";
Debug.ShouldStop(1073741824);
_selectedmonth = RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("selectedmonth", _selectedmonth);Debug.locals.put("selectedmonth", _selectedmonth);
 BA.debugLineNum = 321;BA.debugLine="DrawCalendar(selectedmonth, DateTime.GetYear(Date";
Debug.ShouldStop(1);
_drawcalendar(_selectedmonth,main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 322;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
week_module_subs_0._process_globals();
day_module_subs_0._process_globals();
schedule_module_subs_0._process_globals();
add_events_module_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
week_module.myClass = BA.getDeviceClass ("b4a.example.week_module");
day_module.myClass = BA.getDeviceClass ("b4a.example.day_module");
schedule_module.myClass = BA.getDeviceClass ("b4a.example.schedule_module");
add_events_module.myClass = BA.getDeviceClass ("b4a.example.add_events_module");
keyvaluestore.myClass = BA.getDeviceClass ("b4a.example.keyvaluestore");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Dim CalendarMap As Map";
main._calendarmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 20;BA.debugLine="Dim kvs As KeyValueStore";
main._kvs = RemoteObject.createNew ("b4a.example.keyvaluestore");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sched_btn_click() throws Exception{
try {
		Debug.PushSubsStack("sched_btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,334);
if (RapidSub.canDelegate("sched_btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sched_btn_click");}
 BA.debugLineNum = 334;BA.debugLine="Private Sub sched_btn_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 335;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 336;BA.debugLine="StartActivity(Schedule_MODULE)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._schedule_module.getObject())));
 BA.debugLineNum = 337;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _week_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Week_btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,353);
if (RapidSub.canDelegate("week_btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","week_btn_click");}
 BA.debugLineNum = 353;BA.debugLine="Private Sub Week_btn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 354;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 355;BA.debugLine="StartActivity(Week_MODULE)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._week_module.getObject())));
 BA.debugLineNum = 356;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _weekday(RemoteObject _day) throws Exception{
try {
		Debug.PushSubsStack("Weekday (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,291);
if (RapidSub.canDelegate("weekday")) { return b4a.example.main.remoteMe.runUserSub(false, "main","weekday", _day);}
Debug.locals.put("Day", _day);
 BA.debugLineNum = 291;BA.debugLine="Sub Weekday (Day As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 292;BA.debugLine="If Day = 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 293;BA.debugLine="day_of_week = \"Sun\"";
Debug.ShouldStop(16);
main.mostCurrent._day_of_week = BA.ObjectToString("Sun");
 }else 
{ BA.debugLineNum = 294;BA.debugLine="Else if Day = 1 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 295;BA.debugLine="day_of_week = \"Mon\"";
Debug.ShouldStop(64);
main.mostCurrent._day_of_week = BA.ObjectToString("Mon");
 }else 
{ BA.debugLineNum = 296;BA.debugLine="Else if Day = 2 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 297;BA.debugLine="day_of_week = \"Tue\"";
Debug.ShouldStop(256);
main.mostCurrent._day_of_week = BA.ObjectToString("Tue");
 }else 
{ BA.debugLineNum = 298;BA.debugLine="Else if Day = 3 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 299;BA.debugLine="day_of_week = \"Wed\"";
Debug.ShouldStop(1024);
main.mostCurrent._day_of_week = BA.ObjectToString("Wed");
 }else 
{ BA.debugLineNum = 300;BA.debugLine="Else if Day = 4 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 301;BA.debugLine="day_of_week = \"Thu\"";
Debug.ShouldStop(4096);
main.mostCurrent._day_of_week = BA.ObjectToString("Thu");
 }else 
{ BA.debugLineNum = 302;BA.debugLine="Else if Day = 5 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 5))) { 
 BA.debugLineNum = 303;BA.debugLine="day_of_week = \"Fri\"";
Debug.ShouldStop(16384);
main.mostCurrent._day_of_week = BA.ObjectToString("Fri");
 }else {
 BA.debugLineNum = 305;BA.debugLine="day_of_week = \"Sat\"";
Debug.ShouldStop(65536);
main.mostCurrent._day_of_week = BA.ObjectToString("Sat");
 }}}}}}
;
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _yearsp_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("YearSP_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,324);
if (RapidSub.canDelegate("yearsp_itemclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","yearsp_itemclick", _position, _value);}
RemoteObject _selectedyear = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 324;BA.debugLine="Private Sub YearSP_ItemClick (Position As Int, Val";
Debug.ShouldStop(8);
 BA.debugLineNum = 325;BA.debugLine="Dim selectedyear As Int = Value";
Debug.ShouldStop(16);
_selectedyear = BA.numberCast(int.class, _value);Debug.locals.put("selectedyear", _selectedyear);Debug.locals.put("selectedyear", _selectedyear);
 BA.debugLineNum = 327;BA.debugLine="DrawCalendar(MonthSp.SelectedIndex +1, selectedye";
Debug.ShouldStop(64);
_drawcalendar(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._monthsp.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1),_selectedyear);
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}