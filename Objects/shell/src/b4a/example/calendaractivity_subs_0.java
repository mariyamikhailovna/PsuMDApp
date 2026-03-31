package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class calendaractivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,45);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","activity_create", _firsttime);}
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
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",calendaractivity.mostCurrent._starter._darkmode /*RemoteObject*/ ,calendaractivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"CalendarActivityLayout\")";
Debug.ShouldStop(32768);
calendaractivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("CalendarActivityLayout")),calendaractivity.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 50;BA.debugLine="Activity.LoadLayout(\"CalendarActivityLayoutDark\"";
Debug.ShouldStop(131072);
calendaractivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("CalendarActivityLayoutDark")),calendaractivity.mostCurrent.activityBA);
 };
 BA.debugLineNum = 53;BA.debugLine="Month_btn.Color = Colors.blue";
Debug.ShouldStop(1048576);
calendaractivity.mostCurrent._month_btn.runVoidMethod ("setColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 55;BA.debugLine="kvs = Starter.calKvs";
Debug.ShouldStop(4194304);
calendaractivity._kvs = calendaractivity.mostCurrent._starter._calkvs /*RemoteObject*/ ;
 BA.debugLineNum = 56;BA.debugLine="CalendarMap = Starter.calendarMap";
Debug.ShouldStop(8388608);
calendaractivity._calendarmap = calendaractivity.mostCurrent._starter._calendarmap /*RemoteObject*/ ;
 BA.debugLineNum = 59;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTim";
Debug.ShouldStop(67108864);
_currentyear = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentyear", _currentyear);Debug.locals.put("currentyear", _currentyear);
 BA.debugLineNum = 60;BA.debugLine="Dim years As List";
Debug.ShouldStop(134217728);
_years = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("years", _years);
 BA.debugLineNum = 61;BA.debugLine="years.Initialize";
Debug.ShouldStop(268435456);
_years.runVoidMethod ("Initialize");
 BA.debugLineNum = 62;BA.debugLine="For i = currentyear -10 To currentyear+10";
Debug.ShouldStop(536870912);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_currentyear,RemoteObject.createImmutable(10)}, "+",1, 1).<Integer>get().intValue();
_i = RemoteObject.solve(new RemoteObject[] {_currentyear,RemoteObject.createImmutable(10)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 63;BA.debugLine="years.Add(i)";
Debug.ShouldStop(1073741824);
_years.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable((_i))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 65;BA.debugLine="YearSP.AddAll(years)";
Debug.ShouldStop(1);
calendaractivity.mostCurrent._yearsp.runVoidMethod ("AddAll",(Object)(_years));
 BA.debugLineNum = 66;BA.debugLine="YearSP.SelectedIndex = 10";
Debug.ShouldStop(2);
calendaractivity.mostCurrent._yearsp.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 10));
 BA.debugLineNum = 69;BA.debugLine="MonthSp.AddAll(Months)";
Debug.ShouldStop(16);
calendaractivity.mostCurrent._monthsp.runVoidMethod ("AddAll",(Object)(calendaractivity.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(calendaractivity.mostCurrent._months))));
 BA.debugLineNum = 70;BA.debugLine="MonthSp.SelectedIndex = DateTime.GetMonth(DateTim";
Debug.ShouldStop(32);
calendaractivity.mostCurrent._monthsp.runMethod(true,"setSelectedIndex",RemoteObject.solve(new RemoteObject[] {calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(1)}, "-",1, 1));
 BA.debugLineNum = 73;BA.debugLine="DrawCalendar(DateTime.GetMonth(DateTime.Now), Dat";
Debug.ShouldStop(256);
_drawcalendar(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 76;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(2048);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 77;BA.debugLine="cd.Initialize2(Colors.White, 0, 2dip, Colors.Blac";
Debug.ShouldStop(4096);
_cd.runVoidMethod ("Initialize2",(Object)(calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(BA.numberCast(int.class, 0)),(Object)(calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 79;BA.debugLine="Dim column As Int = 7";
Debug.ShouldStop(16384);
_column = BA.numberCast(int.class, 7);Debug.locals.put("column", _column);Debug.locals.put("column", _column);
 BA.debugLineNum = 80;BA.debugLine="Dim cellW As Int = calendarpanel.Width/column";
Debug.ShouldStop(32768);
_cellw = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {calendaractivity.mostCurrent._calendarpanel.runMethod(true,"getWidth"),_column}, "/",0, 0));Debug.locals.put("cellW", _cellw);Debug.locals.put("cellW", _cellw);
 BA.debugLineNum = 81;BA.debugLine="Dim cellH As Int = 60dip";
Debug.ShouldStop(65536);
_cellh = calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));Debug.locals.put("cellH", _cellh);Debug.locals.put("cellH", _cellh);
 BA.debugLineNum = 82;BA.debugLine="For c = 0 To column -1";
Debug.ShouldStop(131072);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_column,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_c = 0 ;
for (;(step25 > 0 && _c <= limit25) || (step25 < 0 && _c >= limit25) ;_c = ((int)(0 + _c + step25))  ) {
Debug.locals.put("c", _c);
 BA.debugLineNum = 83;BA.debugLine="Dim celllabel As Label";
Debug.ShouldStop(262144);
_celllabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("celllabel", _celllabel);
 BA.debugLineNum = 84;BA.debugLine="celllabel.Initialize(\"cell_label\")";
Debug.ShouldStop(524288);
_celllabel.runVoidMethod ("Initialize",calendaractivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell_label")));
 BA.debugLineNum = 85;BA.debugLine="Weekday(c)";
Debug.ShouldStop(1048576);
_weekday(BA.numberCast(int.class, _c));
 BA.debugLineNum = 86;BA.debugLine="celllabel.Text = day_of_week";
Debug.ShouldStop(2097152);
_celllabel.runMethod(true,"setText",BA.ObjectToCharSequence(calendaractivity.mostCurrent._day_of_week));
 BA.debugLineNum = 87;BA.debugLine="celllabel.TextSize = 14";
Debug.ShouldStop(4194304);
_celllabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 88;BA.debugLine="celllabel.Color = Colors.black";
Debug.ShouldStop(8388608);
_celllabel.runVoidMethod ("setColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 89;BA.debugLine="weekpanel.AddView(celllabel, c*cellW, 0, cellW,";
Debug.ShouldStop(16777216);
calendaractivity.mostCurrent._weekpanel.runVoidMethod ("AddView",(Object)((_celllabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_c),_cellw}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cellw),(Object)(_cellh));
 BA.debugLineNum = 92;BA.debugLine="celllabel.Background = cd";
Debug.ShouldStop(134217728);
_celllabel.runMethod(false,"setBackground",(_cd.getObject()));
 }
}Debug.locals.put("c", _c);
;
 BA.debugLineNum = 98;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,303);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 303;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 305;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,299);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","activity_resume");}
 BA.debugLineNum = 299;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 301;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("cell_click_click (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,248);
if (RapidSub.canDelegate("cell_click_click")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","cell_click_click");}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _datestr = RemoteObject.createImmutable("");
 BA.debugLineNum = 248;BA.debugLine="Sub cell_click_click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 250;BA.debugLine="Dim p As Panel = Sender";
Debug.ShouldStop(33554432);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_p = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), calendaractivity.mostCurrent.__c.runMethod(false,"Sender",calendaractivity.mostCurrent.activityBA));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 251;BA.debugLine="Dim datestr As String = p.Tag";
Debug.ShouldStop(67108864);
_datestr = BA.ObjectToString(_p.runMethod(false,"getTag"));Debug.locals.put("datestr", _datestr);Debug.locals.put("datestr", _datestr);
 BA.debugLineNum = 252;BA.debugLine="Activity.finish";
Debug.ShouldStop(134217728);
calendaractivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 253;BA.debugLine="StartActivity(day_module)";
Debug.ShouldStop(268435456);
calendaractivity.mostCurrent.__c.runVoidMethod ("StartActivity",calendaractivity.processBA,(Object)((calendaractivity.mostCurrent._day_module.getObject())));
 BA.debugLineNum = 254;BA.debugLine="day_module.currentDate = datestr";
Debug.ShouldStop(536870912);
calendaractivity.mostCurrent._day_module._currentdate /*RemoteObject*/  = _datestr;
 BA.debugLineNum = 255;BA.debugLine="Log(datestr)";
Debug.ShouldStop(1073741824);
calendaractivity.mostCurrent.__c.runVoidMethod ("LogImpl","613893639",_datestr,0);
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("CleanDebugger (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,100);
if (RapidSub.canDelegate("cleandebugger")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","cleandebugger");}
 BA.debugLineNum = 100;BA.debugLine="Sub CleanDebugger";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="CalendarMap.Clear";
Debug.ShouldStop(16);
calendaractivity._calendarmap.runVoidMethod ("Clear");
 BA.debugLineNum = 102;BA.debugLine="kvs.Put(\"CalendarKVS\", CalendarMap)";
Debug.ShouldStop(32);
calendaractivity._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("CalendarKVS")),(Object)((calendaractivity._calendarmap.getObject())));
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Day_btn_Click (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,329);
if (RapidSub.canDelegate("day_btn_click")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","day_btn_click");}
RemoteObject _currentyear = RemoteObject.createImmutable(0);
RemoteObject _currentmonth = RemoteObject.createImmutable(0);
RemoteObject _currentday = RemoteObject.createImmutable(0);
RemoteObject _datestr = RemoteObject.createImmutable("");
 BA.debugLineNum = 329;BA.debugLine="Private Sub Day_btn_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 330;BA.debugLine="If day_module.currentDate = \"\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",calendaractivity.mostCurrent._day_module._currentdate /*RemoteObject*/ ,BA.ObjectToString(""))) { 
 BA.debugLineNum = 331;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTi";
Debug.ShouldStop(1024);
_currentyear = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentyear", _currentyear);Debug.locals.put("currentyear", _currentyear);
 BA.debugLineNum = 332;BA.debugLine="Dim currentmonth As Int = DateTime.GetMonth(Date";
Debug.ShouldStop(2048);
_currentmonth = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentmonth", _currentmonth);Debug.locals.put("currentmonth", _currentmonth);
 BA.debugLineNum = 333;BA.debugLine="Dim currentday As Int = DateTime.GetDayOfMonth(D";
Debug.ShouldStop(4096);
_currentday = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("currentday", _currentday);Debug.locals.put("currentday", _currentday);
 BA.debugLineNum = 334;BA.debugLine="Dim datestr As String= currentyear & \"-\" & Numbe";
Debug.ShouldStop(8192);
_datestr = RemoteObject.concat(_currentyear,RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _currentmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _currentday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);Debug.locals.put("datestr", _datestr);
 BA.debugLineNum = 335;BA.debugLine="day_module.currentDate = datestr";
Debug.ShouldStop(16384);
calendaractivity.mostCurrent._day_module._currentdate /*RemoteObject*/  = _datestr;
 BA.debugLineNum = 336;BA.debugLine="Log(day_module.currentDate)";
Debug.ShouldStop(32768);
calendaractivity.mostCurrent.__c.runVoidMethod ("LogImpl","614483463",calendaractivity.mostCurrent._day_module._currentdate /*RemoteObject*/ ,0);
 };
 BA.debugLineNum = 339;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
calendaractivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 340;BA.debugLine="StartActivity(day_module)";
Debug.ShouldStop(524288);
calendaractivity.mostCurrent.__c.runVoidMethod ("StartActivity",calendaractivity.processBA,(Object)((calendaractivity.mostCurrent._day_module.getObject())));
 BA.debugLineNum = 341;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Daysinamonth (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,260);
if (RapidSub.canDelegate("daysinamonth")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","daysinamonth", _month, _year);}
RemoteObject _nextmonth = RemoteObject.createImmutable(0);
RemoteObject _nextyear = RemoteObject.createImmutable(0);
RemoteObject _firstnextmonth = RemoteObject.createImmutable(0L);
RemoteObject _lastdaydate = RemoteObject.createImmutable(0L);
Debug.locals.put("Month", _month);
Debug.locals.put("year", _year);
 BA.debugLineNum = 260;BA.debugLine="Sub Daysinamonth(Month As Int, year As Int) As Int";
Debug.ShouldStop(8);
 BA.debugLineNum = 261;BA.debugLine="Dim nextMonth As Int";
Debug.ShouldStop(16);
_nextmonth = RemoteObject.createImmutable(0);Debug.locals.put("nextMonth", _nextmonth);
 BA.debugLineNum = 262;BA.debugLine="Dim nextyear As Int";
Debug.ShouldStop(32);
_nextyear = RemoteObject.createImmutable(0);Debug.locals.put("nextyear", _nextyear);
 BA.debugLineNum = 264;BA.debugLine="If Month = 12 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, 12))) { 
 BA.debugLineNum = 265;BA.debugLine="nextMonth = 1";
Debug.ShouldStop(256);
_nextmonth = BA.numberCast(int.class, 1);Debug.locals.put("nextMonth", _nextmonth);
 BA.debugLineNum = 266;BA.debugLine="nextyear = year+1";
Debug.ShouldStop(512);
_nextyear = RemoteObject.solve(new RemoteObject[] {_year,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextyear", _nextyear);
 }else {
 BA.debugLineNum = 268;BA.debugLine="nextMonth = Month +1";
Debug.ShouldStop(2048);
_nextmonth = RemoteObject.solve(new RemoteObject[] {_month,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextMonth", _nextmonth);
 BA.debugLineNum = 269;BA.debugLine="nextyear = year";
Debug.ShouldStop(4096);
_nextyear = _year;Debug.locals.put("nextyear", _nextyear);
 };
 BA.debugLineNum = 272;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
Debug.ShouldStop(32768);
calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 273;BA.debugLine="Dim firstNextMonth As Long = DateTime.DateParse(n";
Debug.ShouldStop(65536);
_firstnextmonth = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(RemoteObject.concat(_nextyear,RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _nextmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-01"))));Debug.locals.put("firstNextMonth", _firstnextmonth);Debug.locals.put("firstNextMonth", _firstnextmonth);
 BA.debugLineNum = 274;BA.debugLine="Dim lastDayDate As Long = firstNextMonth - DateTi";
Debug.ShouldStop(131072);
_lastdaydate = RemoteObject.solve(new RemoteObject[] {_firstnextmonth,calendaractivity.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "-",1, 2);Debug.locals.put("lastDayDate", _lastdaydate);Debug.locals.put("lastDayDate", _lastdaydate);
 BA.debugLineNum = 277;BA.debugLine="Return DateTime.GetDayOfMonth(lastDayDate)";
Debug.ShouldStop(1048576);
if (true) return calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(_lastdaydate));
 BA.debugLineNum = 279;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("DrawCalendar (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,105);
if (RapidSub.canDelegate("drawcalendar")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","drawcalendar", _month, _year);}
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
 BA.debugLineNum = 105;BA.debugLine="Sub DrawCalendar (month As Int, year As Int)";
Debug.ShouldStop(256);
 BA.debugLineNum = 107;BA.debugLine="calendarpanel.RemoveAllViews";
Debug.ShouldStop(1024);
calendaractivity.mostCurrent._calendarpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 110;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
Debug.ShouldStop(8192);
calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 111;BA.debugLine="Dim firstDay As Long = DateTime.DateParse(year &";
Debug.ShouldStop(16384);
_firstday = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(RemoteObject.concat(_year,RemoteObject.createImmutable("-"),_month,RemoteObject.createImmutable("-01"))));Debug.locals.put("firstDay", _firstday);Debug.locals.put("firstDay", _firstday);
 BA.debugLineNum = 112;BA.debugLine="Dim startDay As Int = DateTime.GetDayOfweek(first";
Debug.ShouldStop(32768);
_startday = calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(_firstday));Debug.locals.put("startDay", _startday);Debug.locals.put("startDay", _startday);
 BA.debugLineNum = 113;BA.debugLine="Dim daysInmonth As Int = Daysinamonth(month, year";
Debug.ShouldStop(65536);
_daysinmonth = _daysinamonth(_month,_year);Debug.locals.put("daysInmonth", _daysinmonth);Debug.locals.put("daysInmonth", _daysinmonth);
 BA.debugLineNum = 117;BA.debugLine="Dim prevmonth As Int";
Debug.ShouldStop(1048576);
_prevmonth = RemoteObject.createImmutable(0);Debug.locals.put("prevmonth", _prevmonth);
 BA.debugLineNum = 118;BA.debugLine="Dim prevyear As Int";
Debug.ShouldStop(2097152);
_prevyear = RemoteObject.createImmutable(0);Debug.locals.put("prevyear", _prevyear);
 BA.debugLineNum = 120;BA.debugLine="If month = 1 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 121;BA.debugLine="prevmonth = 12";
Debug.ShouldStop(16777216);
_prevmonth = BA.numberCast(int.class, 12);Debug.locals.put("prevmonth", _prevmonth);
 BA.debugLineNum = 122;BA.debugLine="prevyear = year - 1";
Debug.ShouldStop(33554432);
_prevyear = RemoteObject.solve(new RemoteObject[] {_year,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("prevyear", _prevyear);
 }else {
 BA.debugLineNum = 124;BA.debugLine="prevmonth = month-1";
Debug.ShouldStop(134217728);
_prevmonth = RemoteObject.solve(new RemoteObject[] {_month,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("prevmonth", _prevmonth);
 BA.debugLineNum = 125;BA.debugLine="prevyear = year";
Debug.ShouldStop(268435456);
_prevyear = _year;Debug.locals.put("prevyear", _prevyear);
 };
 BA.debugLineNum = 127;BA.debugLine="Dim daysInprevMonth As Int = Daysinamonth(prevmon";
Debug.ShouldStop(1073741824);
_daysinprevmonth = _daysinamonth(_prevmonth,_prevyear);Debug.locals.put("daysInprevMonth", _daysinprevmonth);Debug.locals.put("daysInprevMonth", _daysinprevmonth);
 BA.debugLineNum = 131;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(4);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 132;BA.debugLine="cd.Initialize2(Colors.White, 0, 2dip, Colors.Blac";
Debug.ShouldStop(8);
_cd.runVoidMethod ("Initialize2",(Object)(calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(BA.numberCast(int.class, 0)),(Object)(calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 134;BA.debugLine="Dim rows As Int = 6  'number of rows (days)";
Debug.ShouldStop(32);
_rows = BA.numberCast(int.class, 6);Debug.locals.put("rows", _rows);Debug.locals.put("rows", _rows);
 BA.debugLineNum = 135;BA.debugLine="Dim column As Int = 7 'number of columns (the wee";
Debug.ShouldStop(64);
_column = BA.numberCast(int.class, 7);Debug.locals.put("column", _column);Debug.locals.put("column", _column);
 BA.debugLineNum = 137;BA.debugLine="Dim day As Int = 1";
Debug.ShouldStop(256);
_day = BA.numberCast(int.class, 1);Debug.locals.put("day", _day);Debug.locals.put("day", _day);
 BA.debugLineNum = 138;BA.debugLine="Dim started As Boolean = False";
Debug.ShouldStop(512);
_started = calendaractivity.mostCurrent.__c.getField(true,"False");Debug.locals.put("started", _started);Debug.locals.put("started", _started);
 BA.debugLineNum = 140;BA.debugLine="Dim index As Int = 0";
Debug.ShouldStop(2048);
_index = BA.numberCast(int.class, 0);Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 142;BA.debugLine="Dim cellW As Int = calendarpanel.width / column";
Debug.ShouldStop(8192);
_cellw = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {calendaractivity.mostCurrent._calendarpanel.runMethod(true,"getWidth"),_column}, "/",0, 0));Debug.locals.put("cellW", _cellw);Debug.locals.put("cellW", _cellw);
 BA.debugLineNum = 143;BA.debugLine="Dim cellH As Int = 60dip";
Debug.ShouldStop(16384);
_cellh = calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));Debug.locals.put("cellH", _cellh);Debug.locals.put("cellH", _cellh);
 BA.debugLineNum = 144;BA.debugLine="For r = 0 To rows -1";
Debug.ShouldStop(32768);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_rows,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_r = 0 ;
for (;(step25 > 0 && _r <= limit25) || (step25 < 0 && _r >= limit25) ;_r = ((int)(0 + _r + step25))  ) {
Debug.locals.put("r", _r);
 BA.debugLineNum = 145;BA.debugLine="For c = 0 To column -1";
Debug.ShouldStop(65536);
{
final int step26 = 1;
final int limit26 = RemoteObject.solve(new RemoteObject[] {_column,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_c = 0 ;
for (;(step26 > 0 && _c <= limit26) || (step26 < 0 && _c >= limit26) ;_c = ((int)(0 + _c + step26))  ) {
Debug.locals.put("c", _c);
 BA.debugLineNum = 147;BA.debugLine="Dim cell As Panel";
Debug.ShouldStop(262144);
_cell = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("cell", _cell);
 BA.debugLineNum = 148;BA.debugLine="cell.Initialize(\"cell_click\")";
Debug.ShouldStop(524288);
_cell.runVoidMethod ("Initialize",calendaractivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell_click")));
 BA.debugLineNum = 149;BA.debugLine="cell.Enabled  =True";
Debug.ShouldStop(1048576);
_cell.runMethod(true,"setEnabled",calendaractivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 151;BA.debugLine="calendarpanel.AddView(cell, c * cellW, r * cell";
Debug.ShouldStop(4194304);
calendaractivity.mostCurrent._calendarpanel.runVoidMethod ("AddView",(Object)((_cell.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_c),_cellw}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_r),_cellh}, "*",0, 1)),(Object)(_cellw),(Object)(_cellh));
 BA.debugLineNum = 152;BA.debugLine="cell.Background = cd";
Debug.ShouldStop(8388608);
_cell.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 154;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(33554432);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 155;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(67108864);
_lbl.runVoidMethod ("Initialize",calendaractivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 156;BA.debugLine="lbl.Gravity = Gravity.CENTER_Horizontal";
Debug.ShouldStop(134217728);
_lbl.runMethod(true,"setGravity",calendaractivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 157;BA.debugLine="lbl.Enabled = False";
Debug.ShouldStop(268435456);
_lbl.runMethod(true,"setEnabled",calendaractivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 159;BA.debugLine="index = index +1";
Debug.ShouldStop(1073741824);
_index = RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("index", _index);
 BA.debugLineNum = 161;BA.debugLine="Dim displayday As Int";
Debug.ShouldStop(1);
_displayday = RemoteObject.createImmutable(0);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 162;BA.debugLine="Dim datestr As String";
Debug.ShouldStop(2);
_datestr = RemoteObject.createImmutable("");Debug.locals.put("datestr", _datestr);
 BA.debugLineNum = 165;BA.debugLine="If index < startDay Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("<",_index,BA.numberCast(double.class, _startday))) { 
 BA.debugLineNum = 166;BA.debugLine="displayday = daysInprevMonth - (startDay - ind";
Debug.ShouldStop(32);
_displayday = RemoteObject.solve(new RemoteObject[] {_daysinprevmonth,(RemoteObject.solve(new RemoteObject[] {_startday,_index}, "-",1, 1)),RemoteObject.createImmutable(1)}, "-+",2, 1);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 167;BA.debugLine="lbl.TextColor = Colors.gray";
Debug.ShouldStop(64);
_lbl.runMethod(true,"setTextColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 168;BA.debugLine="datestr = prevyear & \"-\" & NumberFormat(prevmo";
Debug.ShouldStop(128);
_datestr = RemoteObject.concat(_prevyear,RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _prevmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _displayday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);
 }else 
{ BA.debugLineNum = 169;BA.debugLine="Else if index >= startDay And index < startDay";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_index,BA.numberCast(double.class, _startday)) && RemoteObject.solveBoolean("<",_index,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_startday,_daysinmonth}, "+",1, 1)))) { 
 BA.debugLineNum = 170;BA.debugLine="displayday = index - startDay + 1";
Debug.ShouldStop(512);
_displayday = RemoteObject.solve(new RemoteObject[] {_index,_startday,RemoteObject.createImmutable(1)}, "-+",2, 1);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 171;BA.debugLine="lbl.TextColor = Colors.Black";
Debug.ShouldStop(1024);
_lbl.runMethod(true,"setTextColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 172;BA.debugLine="datestr = year&\"-\"&NumberFormat(month,2,0)&\"-\"";
Debug.ShouldStop(2048);
_datestr = RemoteObject.concat(_year,RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _month)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _displayday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);
 }else {
 BA.debugLineNum = 174;BA.debugLine="displayday = index - (startDay + daysInmonth)";
Debug.ShouldStop(8192);
_displayday = RemoteObject.solve(new RemoteObject[] {_index,(RemoteObject.solve(new RemoteObject[] {_startday,_daysinmonth}, "+",1, 1)),RemoteObject.createImmutable(1)}, "-+",2, 1);Debug.locals.put("displayday", _displayday);
 BA.debugLineNum = 175;BA.debugLine="lbl.TextColor = Colors.Gray";
Debug.ShouldStop(16384);
_lbl.runMethod(true,"setTextColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 176;BA.debugLine="Dim nextmonth As Int";
Debug.ShouldStop(32768);
_nextmonth = RemoteObject.createImmutable(0);Debug.locals.put("nextmonth", _nextmonth);
 BA.debugLineNum = 177;BA.debugLine="Dim nextyear As Int";
Debug.ShouldStop(65536);
_nextyear = RemoteObject.createImmutable(0);Debug.locals.put("nextyear", _nextyear);
 BA.debugLineNum = 179;BA.debugLine="If month = 12 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_month,BA.numberCast(double.class, 12))) { 
 BA.debugLineNum = 180;BA.debugLine="nextmonth = 1";
Debug.ShouldStop(524288);
_nextmonth = BA.numberCast(int.class, 1);Debug.locals.put("nextmonth", _nextmonth);
 BA.debugLineNum = 181;BA.debugLine="nextyear = year+1";
Debug.ShouldStop(1048576);
_nextyear = RemoteObject.solve(new RemoteObject[] {_year,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextyear", _nextyear);
 }else {
 BA.debugLineNum = 183;BA.debugLine="nextmonth = month+1";
Debug.ShouldStop(4194304);
_nextmonth = RemoteObject.solve(new RemoteObject[] {_month,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("nextmonth", _nextmonth);
 BA.debugLineNum = 184;BA.debugLine="nextyear = year";
Debug.ShouldStop(8388608);
_nextyear = _year;Debug.locals.put("nextyear", _nextyear);
 BA.debugLineNum = 185;BA.debugLine="datestr = nextyear&\"-\"&NumberFormat(nextmonth";
Debug.ShouldStop(16777216);
_datestr = RemoteObject.concat(_nextyear,RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _nextmonth)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("-"),calendaractivity.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _displayday)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("datestr", _datestr);
 };
 }}
;
 BA.debugLineNum = 190;BA.debugLine="lbl.Text = displayday";
Debug.ShouldStop(536870912);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_displayday));
 BA.debugLineNum = 191;BA.debugLine="cell.Tag = datestr";
Debug.ShouldStop(1073741824);
_cell.runMethod(false,"setTag",(_datestr));
 BA.debugLineNum = 192;BA.debugLine="lbl.Enabled = False";
Debug.ShouldStop(-2147483648);
_lbl.runMethod(true,"setEnabled",calendaractivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 193;BA.debugLine="cell.AddView(lbl, 0, 0, cellW, cellH)";
Debug.ShouldStop(1);
_cell.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cellw),(Object)(_cellh));
 BA.debugLineNum = 195;BA.debugLine="If CalendarMap.ContainsKey(datestr) Then";
Debug.ShouldStop(4);
if (calendaractivity._calendarmap.runMethod(true,"ContainsKey",(Object)((_datestr))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 196;BA.debugLine="Dim eventmap As Map = CalendarMap.Get(datestr)";
Debug.ShouldStop(8);
_eventmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_eventmap = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), calendaractivity._calendarmap.runMethod(false,"Get",(Object)((_datestr))));Debug.locals.put("eventmap", _eventmap);Debug.locals.put("eventmap", _eventmap);
 BA.debugLineNum = 197;BA.debugLine="Dim allevents As List = eventmap.Get(\"AllEvent";
Debug.ShouldStop(16);
_allevents = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_allevents = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _eventmap.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("AllEvents")))));Debug.locals.put("allevents", _allevents);Debug.locals.put("allevents", _allevents);
 BA.debugLineNum = 199;BA.debugLine="Dim maxShow As Int = Min(allevents.Size, 2)";
Debug.ShouldStop(64);
_maxshow = BA.numberCast(int.class, calendaractivity.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _allevents.runMethod(true,"getSize"))),(Object)(BA.numberCast(double.class, 2))));Debug.locals.put("maxShow", _maxshow);Debug.locals.put("maxShow", _maxshow);
 BA.debugLineNum = 200;BA.debugLine="Dim yoffset As Int = 20dip";
Debug.ShouldStop(128);
_yoffset = calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("yoffset", _yoffset);Debug.locals.put("yoffset", _yoffset);
 BA.debugLineNum = 202;BA.debugLine="For i = 0 To maxShow -1";
Debug.ShouldStop(512);
{
final int step70 = 1;
final int limit70 = RemoteObject.solve(new RemoteObject[] {_maxshow,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70) ;_i = ((int)(0 + _i + step70))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 203;BA.debugLine="Dim ev As Map = allevents.Get(i)";
Debug.ShouldStop(1024);
_ev = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_ev = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _allevents.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("ev", _ev);Debug.locals.put("ev", _ev);
 BA.debugLineNum = 205;BA.debugLine="Dim dot As Label";
Debug.ShouldStop(4096);
_dot = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("dot", _dot);
 BA.debugLineNum = 206;BA.debugLine="dot.Initialize(\"\")";
Debug.ShouldStop(8192);
_dot.runVoidMethod ("Initialize",calendaractivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 207;BA.debugLine="dot.Text = ev.Get(\"Title\")";
Debug.ShouldStop(16384);
_dot.runMethod(true,"setText",BA.ObjectToCharSequence(_ev.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Title"))))));
 BA.debugLineNum = 208;BA.debugLine="dot.TextSize = 8";
Debug.ShouldStop(32768);
_dot.runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 209;BA.debugLine="dot.TextColor = Colors.white";
Debug.ShouldStop(65536);
_dot.runMethod(true,"setTextColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 210;BA.debugLine="dot.Color = IdentifyColor(ev.Get(\"Tags\"))";
Debug.ShouldStop(131072);
_dot.runVoidMethod ("setColor",_identifycolor(BA.ObjectToString(_ev.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Tags")))))));
 BA.debugLineNum = 211;BA.debugLine="dot.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(262144);
_dot.runMethod(true,"setGravity",calendaractivity.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 212;BA.debugLine="dot.SingleLine = True";
Debug.ShouldStop(524288);
_dot.runVoidMethod ("setSingleLine",calendaractivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 213;BA.debugLine="dot.Ellipsize = \"END\"";
Debug.ShouldStop(1048576);
_dot.runMethod(true,"setEllipsize",BA.ObjectToString("END"));
 BA.debugLineNum = 214;BA.debugLine="cell.AddView(dot, 2dip, yoffset +i*12dip, cel";
Debug.ShouldStop(2097152);
_cell.runVoidMethod ("AddView",(Object)((_dot.getObject())),(Object)(calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_yoffset,RemoteObject.createImmutable(_i),calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_cellw,calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "-",1, 1)),(Object)(calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 217;BA.debugLine="If allevents.Size > 2 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean(">",_allevents.runMethod(true,"getSize"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 218;BA.debugLine="Dim morelbl As Label";
Debug.ShouldStop(33554432);
_morelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("morelbl", _morelbl);
 BA.debugLineNum = 219;BA.debugLine="morelbl.Initialize(\"\")";
Debug.ShouldStop(67108864);
_morelbl.runVoidMethod ("Initialize",calendaractivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 220;BA.debugLine="morelbl.Text = \"+\" & (allevents.Size -2)";
Debug.ShouldStop(134217728);
_morelbl.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("+"),(RemoteObject.solve(new RemoteObject[] {_allevents.runMethod(true,"getSize"),RemoteObject.createImmutable(2)}, "-",1, 1)))));
 BA.debugLineNum = 221;BA.debugLine="morelbl.TextSize = 8";
Debug.ShouldStop(268435456);
_morelbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 8));
 BA.debugLineNum = 222;BA.debugLine="morelbl.TextColor = Colors.black";
Debug.ShouldStop(536870912);
_morelbl.runMethod(true,"setTextColor",calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 223;BA.debugLine="cell.AddView(morelbl, 2dip , yoffset + 2 * 12";
Debug.ShouldStop(1073741824);
_cell.runVoidMethod ("AddView",(Object)((_morelbl.getObject())),(Object)(calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_yoffset,RemoteObject.createImmutable(2),calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+*",1, 1)),(Object)(_cellw),(Object)(calendaractivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 };
 };
 }
}Debug.locals.put("c", _c);
;
 }
}Debug.locals.put("r", _r);
;
 BA.debugLineNum = 230;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim Months(12) As String";
calendaractivity.mostCurrent._months = RemoteObject.createNewArray ("String", new int[] {12}, new Object[]{});
 //BA.debugLineNum = 21;BA.debugLine="Months(0) = \"January\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("January"),BA.numberCast(int.class, 0));
 //BA.debugLineNum = 22;BA.debugLine="Months(1) = \"February\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("February"),BA.numberCast(int.class, 1));
 //BA.debugLineNum = 23;BA.debugLine="Months(2) = \"March\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("March"),BA.numberCast(int.class, 2));
 //BA.debugLineNum = 24;BA.debugLine="Months(3) = \"April\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("April"),BA.numberCast(int.class, 3));
 //BA.debugLineNum = 25;BA.debugLine="Months(4) = \"May\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("May"),BA.numberCast(int.class, 4));
 //BA.debugLineNum = 26;BA.debugLine="Months(5) = \"June\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("June"),BA.numberCast(int.class, 5));
 //BA.debugLineNum = 27;BA.debugLine="Months(6) = \"July\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("July"),BA.numberCast(int.class, 6));
 //BA.debugLineNum = 28;BA.debugLine="Months(7) = \"August\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("August"),BA.numberCast(int.class, 7));
 //BA.debugLineNum = 29;BA.debugLine="Months(8) = \"September\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("September"),BA.numberCast(int.class, 8));
 //BA.debugLineNum = 30;BA.debugLine="Months(9) = \"October\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("October"),BA.numberCast(int.class, 9));
 //BA.debugLineNum = 31;BA.debugLine="Months(10) = \"November\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("November"),BA.numberCast(int.class, 10));
 //BA.debugLineNum = 32;BA.debugLine="Months(11) = \"December\"";
calendaractivity.mostCurrent._months.setArrayElement (BA.ObjectToString("December"),BA.numberCast(int.class, 11));
 //BA.debugLineNum = 36;BA.debugLine="Private calendarpanel As Panel";
calendaractivity.mostCurrent._calendarpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private weekpanel As Panel";
calendaractivity.mostCurrent._weekpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Dim day_of_week As String";
calendaractivity.mostCurrent._day_of_week = RemoteObject.createImmutable("");
 //BA.debugLineNum = 39;BA.debugLine="Private MonthSp As Spinner";
calendaractivity.mostCurrent._monthsp = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private YearSP As Spinner";
calendaractivity.mostCurrent._yearsp = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private menupanel As Panel";
calendaractivity.mostCurrent._menupanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private Month_btn As Button";
calendaractivity.mostCurrent._month_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _identifycolor(RemoteObject _typeofevent) throws Exception{
try {
		Debug.PushSubsStack("IdentifyColor (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,232);
if (RapidSub.canDelegate("identifycolor")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","identifycolor", _typeofevent);}
RemoteObject _mycolor = RemoteObject.createImmutable(0);
Debug.locals.put("typeofevent", _typeofevent);
 BA.debugLineNum = 232;BA.debugLine="Sub IdentifyColor (typeofevent As String) As Int";
Debug.ShouldStop(128);
 BA.debugLineNum = 233;BA.debugLine="Dim mycolor As Int";
Debug.ShouldStop(256);
_mycolor = RemoteObject.createImmutable(0);Debug.locals.put("mycolor", _mycolor);
 BA.debugLineNum = 234;BA.debugLine="If typeofevent = \"Task\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("Task"))) { 
 BA.debugLineNum = 235;BA.debugLine="mycolor = Colors.Blue";
Debug.ShouldStop(1024);
_mycolor = calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue");Debug.locals.put("mycolor", _mycolor);
 }else 
{ BA.debugLineNum = 236;BA.debugLine="Else if typeofevent = \"Event\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("Event"))) { 
 BA.debugLineNum = 237;BA.debugLine="mycolor = Colors.Green";
Debug.ShouldStop(4096);
_mycolor = calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Green");Debug.locals.put("mycolor", _mycolor);
 }else 
{ BA.debugLineNum = 238;BA.debugLine="Else if typeofevent = \"Birthday\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("Birthday"))) { 
 BA.debugLineNum = 239;BA.debugLine="mycolor = Colors.Magenta";
Debug.ShouldStop(16384);
_mycolor = calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Magenta");Debug.locals.put("mycolor", _mycolor);
 }else 
{ BA.debugLineNum = 240;BA.debugLine="Else if typeofevent = \"OOO\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_typeofevent,BA.ObjectToString("OOO"))) { 
 BA.debugLineNum = 241;BA.debugLine="mycolor = Colors.Yellow";
Debug.ShouldStop(65536);
_mycolor = calendaractivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow");Debug.locals.put("mycolor", _mycolor);
 }}}}
;
 BA.debugLineNum = 244;BA.debugLine="Return mycolor";
Debug.ShouldStop(524288);
if (true) return _mycolor;
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("menu_btn_Click (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,320);
if (RapidSub.canDelegate("menu_btn_click")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","menu_btn_click");}
 BA.debugLineNum = 320;BA.debugLine="Private Sub menu_btn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 321;BA.debugLine="menupanel.Visible =True";
Debug.ShouldStop(1);
calendaractivity.mostCurrent._menupanel.runMethod(true,"setVisible",calendaractivity.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _month_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Month_btn_Click (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,343);
if (RapidSub.canDelegate("month_btn_click")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","month_btn_click");}
 BA.debugLineNum = 343;BA.debugLine="Private Sub Month_btn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 344;BA.debugLine="menupanel.Visible = False";
Debug.ShouldStop(8388608);
calendaractivity.mostCurrent._menupanel.runMethod(true,"setVisible",calendaractivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 345;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("MonthSp_ItemClick (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,308);
if (RapidSub.canDelegate("monthsp_itemclick")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","monthsp_itemclick", _position, _value);}
RemoteObject _selectedmonth = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 308;BA.debugLine="Private Sub MonthSp_ItemClick (Position As Int, Va";
Debug.ShouldStop(524288);
 BA.debugLineNum = 309;BA.debugLine="Dim selectedmonth As Int = Position +1";
Debug.ShouldStop(1048576);
_selectedmonth = RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("selectedmonth", _selectedmonth);Debug.locals.put("selectedmonth", _selectedmonth);
 BA.debugLineNum = 311;BA.debugLine="DrawCalendar(selectedmonth, DateTime.GetYear(Date";
Debug.ShouldStop(4194304);
_drawcalendar(_selectedmonth,calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(calendaractivity.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
calendaractivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="Dim CalendarMap As Map";
calendaractivity._calendarmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 12;BA.debugLine="Dim kvs As KeyValueStore";
calendaractivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sched_btn_click() throws Exception{
try {
		Debug.PushSubsStack("sched_btn_Click (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,324);
if (RapidSub.canDelegate("sched_btn_click")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","sched_btn_click");}
 BA.debugLineNum = 324;BA.debugLine="Private Sub sched_btn_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 325;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
calendaractivity.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 326;BA.debugLine="StartActivity(Schedule_module)";
Debug.ShouldStop(32);
calendaractivity.mostCurrent.__c.runVoidMethod ("StartActivity",calendaractivity.processBA,(Object)((calendaractivity.mostCurrent._schedule_module.getObject())));
 BA.debugLineNum = 327;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Weekday (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,281);
if (RapidSub.canDelegate("weekday")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","weekday", _day);}
Debug.locals.put("Day", _day);
 BA.debugLineNum = 281;BA.debugLine="Sub Weekday (Day As Int)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 282;BA.debugLine="If Day = 0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 283;BA.debugLine="day_of_week = \"Sun\"";
Debug.ShouldStop(67108864);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Sun");
 }else 
{ BA.debugLineNum = 284;BA.debugLine="Else if Day = 1 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 285;BA.debugLine="day_of_week = \"Mon\"";
Debug.ShouldStop(268435456);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Mon");
 }else 
{ BA.debugLineNum = 286;BA.debugLine="Else if Day = 2 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 287;BA.debugLine="day_of_week = \"Tue\"";
Debug.ShouldStop(1073741824);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Tue");
 }else 
{ BA.debugLineNum = 288;BA.debugLine="Else if Day = 3 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 289;BA.debugLine="day_of_week = \"Wed\"";
Debug.ShouldStop(1);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Wed");
 }else 
{ BA.debugLineNum = 290;BA.debugLine="Else if Day = 4 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 291;BA.debugLine="day_of_week = \"Thu\"";
Debug.ShouldStop(4);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Thu");
 }else 
{ BA.debugLineNum = 292;BA.debugLine="Else if Day = 5 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_day,BA.numberCast(double.class, 5))) { 
 BA.debugLineNum = 293;BA.debugLine="day_of_week = \"Fri\"";
Debug.ShouldStop(16);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Fri");
 }else {
 BA.debugLineNum = 295;BA.debugLine="day_of_week = \"Sat\"";
Debug.ShouldStop(64);
calendaractivity.mostCurrent._day_of_week = BA.ObjectToString("Sat");
 }}}}}}
;
 BA.debugLineNum = 297;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("YearSP_ItemClick (calendaractivity) ","calendaractivity",14,calendaractivity.mostCurrent.activityBA,calendaractivity.mostCurrent,314);
if (RapidSub.canDelegate("yearsp_itemclick")) { return b4a.example.calendaractivity.remoteMe.runUserSub(false, "calendaractivity","yearsp_itemclick", _position, _value);}
RemoteObject _selectedyear = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 314;BA.debugLine="Private Sub YearSP_ItemClick (Position As Int, Val";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 315;BA.debugLine="Dim selectedyear As Int = Value";
Debug.ShouldStop(67108864);
_selectedyear = BA.numberCast(int.class, _value);Debug.locals.put("selectedyear", _selectedyear);Debug.locals.put("selectedyear", _selectedyear);
 BA.debugLineNum = 317;BA.debugLine="DrawCalendar(MonthSp.SelectedIndex +1, selectedye";
Debug.ShouldStop(268435456);
_drawcalendar(RemoteObject.solve(new RemoteObject[] {calendaractivity.mostCurrent._monthsp.runMethod(true,"getSelectedIndex"),RemoteObject.createImmutable(1)}, "+",1, 1),_selectedyear);
 BA.debugLineNum = 318;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}