package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class todoactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","activity_create", _firsttime);}
RemoteObject _savedlists = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _title = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 41;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(256);
if (todoactivity.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"todoListLayoutDark.bal\")";
Debug.ShouldStop(512);
todoactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("todoListLayoutDark.bal")),todoactivity.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"todoListLayout.bal\")";
Debug.ShouldStop(2048);
todoactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("todoListLayout.bal")),todoactivity.mostCurrent.activityBA);
 };
 BA.debugLineNum = 47;BA.debugLine="addTitleTextArea.Tag = Null";
Debug.ShouldStop(16384);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setTag",todoactivity.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 48;BA.debugLine="addTitleTextArea.Background = Null";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setBackground",(todoactivity.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 50;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(131072);
_newaddtaskbtn();
 BA.debugLineNum = 51;BA.debugLine="tasksList.GetBase.Visible = False";
Debug.ShouldStop(262144);
todoactivity.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 53;BA.debugLine="kvs = Starter.taskKvs";
Debug.ShouldStop(1048576);
todoactivity._kvs = todoactivity.mostCurrent._starter._taskkvs /*RemoteObject*/ ;
 BA.debugLineNum = 55;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
Debug.ShouldStop(4194304);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("lists"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 56;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
Debug.ShouldStop(8388608);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 57;BA.debugLine="For Each title As String In savedLists";
Debug.ShouldStop(16777216);
{
final RemoteObject group13 = _savedlists;
final int groupLen13 = group13.runMethod(true,"getSize").<Integer>get()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_title = BA.ObjectToString(group13.runMethod(false,"Get",index13));Debug.locals.put("title", _title);
Debug.locals.put("title", _title);
 BA.debugLineNum = 58;BA.debugLine="listsList.AddTextItem(title, title)";
Debug.ShouldStop(33554432);
todoactivity.mostCurrent._listslist.runVoidMethod ("_addtextitem",(Object)((_title)),(Object)((_title)));
 }
}Debug.locals.put("title", _title);
;
 };
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Pause (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,68);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,64);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","activity_resume");}
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtaskbtn_click() throws Exception{
try {
		Debug.PushSubsStack("addTaskBtn_Click (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,333);
if (RapidSub.canDelegate("addtaskbtn_click")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","addtaskbtn_click");}
 BA.debugLineNum = 333;BA.debugLine="Sub addTaskBtn_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 335;BA.debugLine="addTaskBtn.Enabled = False";
Debug.ShouldStop(16384);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 336;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_removeat",(Object)(RemoteObject.solve(new RemoteObject[] {todoactivity.mostCurrent._taskslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 338;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
Debug.ShouldStop(131072);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskPanel")));
 BA.debugLineNum = 339;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 250dip, 100dip)";
Debug.ShouldStop(262144);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("SetLayout",(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 340;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(524288);
if (todoactivity.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 341;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 17, 17, 17";
Debug.ShouldStop(1048576);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("setColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 17)),(Object)(BA.numberCast(int.class, 17)),(Object)(BA.numberCast(int.class, 17))));
 }else {
 BA.debugLineNum = 343;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247,";
Debug.ShouldStop(4194304);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("setColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247))));
 };
 BA.debugLineNum = 347;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
Debug.ShouldStop(67108864);
todoactivity.mostCurrent._addtasktextarea.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTodoText")));
 BA.debugLineNum = 348;BA.debugLine="addTaskTextArea.Hint = \"Add a task...\"";
Debug.ShouldStop(134217728);
todoactivity.mostCurrent._addtasktextarea.runMethod(true,"setHint",BA.ObjectToString("Add a task..."));
 BA.debugLineNum = 349;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(268435456);
if (todoactivity.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 350;BA.debugLine="addTaskTextArea.HintColor = Colors.ARGB(255, 247";
Debug.ShouldStop(536870912);
todoactivity.mostCurrent._addtasktextarea.runMethod(true,"setHintColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247))));
 }else {
 BA.debugLineNum = 352;BA.debugLine="addTaskTextArea.HintColor = Colors.ARGB(255, 17,";
Debug.ShouldStop(-2147483648);
todoactivity.mostCurrent._addtasktextarea.runMethod(true,"setHintColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 17)),(Object)(BA.numberCast(int.class, 17)),(Object)(BA.numberCast(int.class, 17))));
 };
 BA.debugLineNum = 354;BA.debugLine="addTaskTextArea.Tag = Null";
Debug.ShouldStop(2);
todoactivity.mostCurrent._addtasktextarea.runMethod(false,"setTag",todoactivity.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 356;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
Debug.ShouldStop(8);
todoactivity.mostCurrent._entertaskbtn.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("enterTaskBtn")));
 BA.debugLineNum = 357;BA.debugLine="enterTaskBtn.Text = \"Enter task\"";
Debug.ShouldStop(16);
todoactivity.mostCurrent._entertaskbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Enter task"));
 BA.debugLineNum = 359;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, addTa";
Debug.ShouldStop(64);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("AddView",(Object)((todoactivity.mostCurrent._addtasktextarea.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 360;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, addT";
Debug.ShouldStop(128);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("AddView",(Object)((todoactivity.mostCurrent._entertaskbtn.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 362;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
Debug.ShouldStop(512);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), todoactivity.mostCurrent._addtaskpanel.getObject()),(Object)((todoactivity.mostCurrent._addtaskpanel.getObject())));
 BA.debugLineNum = 364;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtitletextarea_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("addTitleTextArea_EnterPressed (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,121);
if (RapidSub.canDelegate("addtitletextarea_enterpressed")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","addtitletextarea_enterpressed");}
RemoteObject _ctx = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _oldindex = RemoteObject.createImmutable(0);
RemoteObject _oldtitle = RemoteObject.createImmutable("");
RemoteObject _newtitle = RemoteObject.createImmutable("");
RemoteObject _savedlists = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _existingtitle = RemoteObject.createImmutable("");
RemoteObject _oldkey = RemoteObject.createImmutable("");
RemoteObject _newkey = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _task = RemoteObject.createImmutable("");
RemoteObject _oldck = RemoteObject.createImmutable("");
RemoteObject _newck = RemoteObject.createImmutable("");
RemoteObject _savedlists2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _t = RemoteObject.createImmutable("");
RemoteObject _title = RemoteObject.createImmutable("");
 BA.debugLineNum = 121;BA.debugLine="Sub addTitleTextArea_EnterPressed";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 124;BA.debugLine="If addTitleTextArea.Tag <> Null And addTitleTextA";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("N",todoactivity.mostCurrent._addtitletextarea.runMethod(false,"getTag")) && RemoteObject.solveBoolean("i",todoactivity.mostCurrent._addtitletextarea.runMethod(false,"getTag"), RemoteObject.createImmutable("java.util.List"))) { 
 BA.debugLineNum = 125;BA.debugLine="Dim ctx As List = addTitleTextArea.Tag";
Debug.ShouldStop(268435456);
_ctx = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_ctx = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity.mostCurrent._addtitletextarea.runMethod(false,"getTag"));Debug.locals.put("ctx", _ctx);Debug.locals.put("ctx", _ctx);
 BA.debugLineNum = 126;BA.debugLine="Dim oldIndex As Int = ctx.Get(0)";
Debug.ShouldStop(536870912);
_oldindex = BA.numberCast(int.class, _ctx.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("oldIndex", _oldindex);Debug.locals.put("oldIndex", _oldindex);
 BA.debugLineNum = 127;BA.debugLine="Dim oldTitle As String = ctx.Get(1)";
Debug.ShouldStop(1073741824);
_oldtitle = BA.ObjectToString(_ctx.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("oldTitle", _oldtitle);Debug.locals.put("oldTitle", _oldtitle);
 BA.debugLineNum = 128;BA.debugLine="Dim newTitle As String = addTitleTextArea.Text.T";
Debug.ShouldStop(-2147483648);
_newtitle = todoactivity.mostCurrent._addtitletextarea.runMethod(true,"getText").runMethod(true,"trim");Debug.locals.put("newTitle", _newtitle);Debug.locals.put("newTitle", _newtitle);
 BA.debugLineNum = 130;BA.debugLine="If newTitle = \"\" Or newTitle = oldTitle Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_newtitle,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",_newtitle,_oldtitle)) { 
 BA.debugLineNum = 131;BA.debugLine="addTitleTextArea.Tag = Null";
Debug.ShouldStop(4);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setTag",todoactivity.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 132;BA.debugLine="addTitleTextArea.Text = currentList";
Debug.ShouldStop(8);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(todoactivity.mostCurrent._currentlist));
 BA.debugLineNum = 133;BA.debugLine="addTitleTextArea.Enabled = False";
Debug.ShouldStop(16);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 134;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 138;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
Debug.ShouldStop(512);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 139;BA.debugLine="For Each existingTitle As String In savedLists";
Debug.ShouldStop(1024);
{
final RemoteObject group13 = _savedlists;
final int groupLen13 = group13.runMethod(true,"getSize").<Integer>get()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_existingtitle = BA.ObjectToString(group13.runMethod(false,"Get",index13));Debug.locals.put("existingTitle", _existingtitle);
Debug.locals.put("existingTitle", _existingtitle);
 BA.debugLineNum = 140;BA.debugLine="If existingTitle = newTitle Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_existingtitle,_newtitle)) { 
 BA.debugLineNum = 141;BA.debugLine="MsgboxAsync(\"A list with that name already exi";
Debug.ShouldStop(4096);
todoactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("A list with that name already exists.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Duplicate title"))),todoactivity.processBA);
 BA.debugLineNum = 142;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("existingTitle", _existingtitle);
;
 BA.debugLineNum = 147;BA.debugLine="savedLists.Set(oldIndex, newTitle)";
Debug.ShouldStop(262144);
_savedlists.runVoidMethod ("Set",(Object)(_oldindex),(Object)((_newtitle)));
 BA.debugLineNum = 148;BA.debugLine="kvs.Put(\"lists\", savedLists)";
Debug.ShouldStop(524288);
todoactivity._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("lists")),(Object)((_savedlists.getObject())));
 BA.debugLineNum = 151;BA.debugLine="Dim oldKey As String = \"list_\" & oldTitle";
Debug.ShouldStop(4194304);
_oldkey = RemoteObject.concat(RemoteObject.createImmutable("list_"),_oldtitle);Debug.locals.put("oldKey", _oldkey);Debug.locals.put("oldKey", _oldkey);
 BA.debugLineNum = 152;BA.debugLine="Dim newKey As String = \"list_\" & newTitle";
Debug.ShouldStop(8388608);
_newkey = RemoteObject.concat(RemoteObject.createImmutable("list_"),_newtitle);Debug.locals.put("newKey", _newkey);Debug.locals.put("newKey", _newkey);
 BA.debugLineNum = 153;BA.debugLine="If kvs.ContainsKey(oldKey) Then";
Debug.ShouldStop(16777216);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_oldkey)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 154;BA.debugLine="Dim savedTasks As List = kvs.Get(oldKey)";
Debug.ShouldStop(33554432);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(_oldkey)));Debug.locals.put("savedTasks", _savedtasks);Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 155;BA.debugLine="For Each task As String In savedTasks";
Debug.ShouldStop(67108864);
{
final RemoteObject group25 = _savedtasks;
final int groupLen25 = group25.runMethod(true,"getSize").<Integer>get()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_task = BA.ObjectToString(group25.runMethod(false,"Get",index25));Debug.locals.put("task", _task);
Debug.locals.put("task", _task);
 BA.debugLineNum = 156;BA.debugLine="Dim oldCK As String = \"checked_\" & oldTitle &";
Debug.ShouldStop(134217728);
_oldck = RemoteObject.concat(RemoteObject.createImmutable("checked_"),_oldtitle,RemoteObject.createImmutable("_"),_task);Debug.locals.put("oldCK", _oldck);Debug.locals.put("oldCK", _oldck);
 BA.debugLineNum = 157;BA.debugLine="Dim newCK As String = \"checked_\" & newTitle &";
Debug.ShouldStop(268435456);
_newck = RemoteObject.concat(RemoteObject.createImmutable("checked_"),_newtitle,RemoteObject.createImmutable("_"),_task);Debug.locals.put("newCK", _newck);Debug.locals.put("newCK", _newck);
 BA.debugLineNum = 158;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
Debug.ShouldStop(536870912);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_oldck)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 159;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
Debug.ShouldStop(1073741824);
todoactivity._kvs.runVoidMethod ("_put",(Object)(_newck),(Object)(todoactivity._kvs.runMethod(false,"_get",(Object)(_oldck))));
 BA.debugLineNum = 160;BA.debugLine="kvs.Remove(oldCK)";
Debug.ShouldStop(-2147483648);
todoactivity._kvs.runVoidMethod ("_remove",(Object)(_oldck));
 };
 }
}Debug.locals.put("task", _task);
;
 BA.debugLineNum = 163;BA.debugLine="kvs.Put(newKey, savedTasks)";
Debug.ShouldStop(4);
todoactivity._kvs.runVoidMethod ("_put",(Object)(_newkey),(Object)((_savedtasks.getObject())));
 BA.debugLineNum = 164;BA.debugLine="kvs.Remove(oldKey)";
Debug.ShouldStop(8);
todoactivity._kvs.runVoidMethod ("_remove",(Object)(_oldkey));
 };
 BA.debugLineNum = 168;BA.debugLine="If currentList = oldTitle Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",todoactivity.mostCurrent._currentlist,_oldtitle)) { 
 BA.debugLineNum = 169;BA.debugLine="currentList = newTitle";
Debug.ShouldStop(256);
todoactivity.mostCurrent._currentlist = _newtitle;
 };
 BA.debugLineNum = 173;BA.debugLine="listsList.Clear";
Debug.ShouldStop(4096);
todoactivity.mostCurrent._listslist.runVoidMethod ("_clear");
 BA.debugLineNum = 174;BA.debugLine="Dim savedLists2 As List = kvs.Get(\"lists\")";
Debug.ShouldStop(8192);
_savedlists2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists2", _savedlists2);Debug.locals.put("savedLists2", _savedlists2);
 BA.debugLineNum = 175;BA.debugLine="For Each t As String In savedLists2";
Debug.ShouldStop(16384);
{
final RemoteObject group41 = _savedlists2;
final int groupLen41 = group41.runMethod(true,"getSize").<Integer>get()
;int index41 = 0;
;
for (; index41 < groupLen41;index41++){
_t = BA.ObjectToString(group41.runMethod(false,"Get",index41));Debug.locals.put("t", _t);
Debug.locals.put("t", _t);
 BA.debugLineNum = 176;BA.debugLine="listsList.AddTextItem(t, t)";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._listslist.runVoidMethod ("_addtextitem",(Object)((_t)),(Object)((_t)));
 }
}Debug.locals.put("t", _t);
;
 BA.debugLineNum = 179;BA.debugLine="addTitleTextArea.Tag = Null";
Debug.ShouldStop(262144);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setTag",todoactivity.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 180;BA.debugLine="addTitleTextArea.Text = currentList";
Debug.ShouldStop(524288);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(todoactivity.mostCurrent._currentlist));
 BA.debugLineNum = 181;BA.debugLine="addTitleTextArea.Enabled = False";
Debug.ShouldStop(1048576);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 182;BA.debugLine="newListBtn.Enabled = True";
Debug.ShouldStop(2097152);
todoactivity.mostCurrent._newlistbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 183;BA.debugLine="isAddingList = False";
Debug.ShouldStop(4194304);
todoactivity._isaddinglist = todoactivity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 184;BA.debugLine="ToastMessageShow(\"List renamed\", False)";
Debug.ShouldStop(8388608);
todoactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("List renamed")),(Object)(todoactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 185;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 189;BA.debugLine="Dim title As String = addTitleTextArea.Text";
Debug.ShouldStop(268435456);
_title = todoactivity.mostCurrent._addtitletextarea.runMethod(true,"getText");Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 191;BA.debugLine="Dim savedLists As List";
Debug.ShouldStop(1073741824);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 192;BA.debugLine="savedLists.Initialize";
Debug.ShouldStop(-2147483648);
_savedlists.runVoidMethod ("Initialize");
 BA.debugLineNum = 194;BA.debugLine="If title = \"\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_title,BA.ObjectToString(""))) { 
 BA.debugLineNum = 195;BA.debugLine="title = \"Untitled\" & untitledNo";
Debug.ShouldStop(4);
_title = RemoteObject.concat(RemoteObject.createImmutable("Untitled"),todoactivity._untitledno);Debug.locals.put("title", _title);
 BA.debugLineNum = 197;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
Debug.ShouldStop(16);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("lists"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 198;BA.debugLine="savedLists = kvs.Get(\"lists\")";
Debug.ShouldStop(32);
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 199;BA.debugLine="For Each existingTitle As String In savedLists";
Debug.ShouldStop(64);
{
final RemoteObject group59 = _savedlists;
final int groupLen59 = group59.runMethod(true,"getSize").<Integer>get()
;int index59 = 0;
;
for (; index59 < groupLen59;index59++){
_existingtitle = BA.ObjectToString(group59.runMethod(false,"Get",index59));Debug.locals.put("existingTitle", _existingtitle);
Debug.locals.put("existingTitle", _existingtitle);
 BA.debugLineNum = 200;BA.debugLine="If title = existingTitle Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_title,_existingtitle)) { 
 BA.debugLineNum = 201;BA.debugLine="untitledNo = untitledNo + 1";
Debug.ShouldStop(256);
todoactivity._untitledno = RemoteObject.solve(new RemoteObject[] {todoactivity._untitledno,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 202;BA.debugLine="title = \"Untitled\" & untitledNo";
Debug.ShouldStop(512);
_title = RemoteObject.concat(RemoteObject.createImmutable("Untitled"),todoactivity._untitledno);Debug.locals.put("title", _title);
 };
 }
}Debug.locals.put("existingTitle", _existingtitle);
;
 };
 BA.debugLineNum = 207;BA.debugLine="newListBtn.Enabled = True";
Debug.ShouldStop(16384);
todoactivity.mostCurrent._newlistbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 210;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
Debug.ShouldStop(131072);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("lists"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 211;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
Debug.ShouldStop(262144);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 212;BA.debugLine="For Each existingTitle As String In savedLists";
Debug.ShouldStop(524288);
{
final RemoteObject group70 = _savedlists;
final int groupLen70 = group70.runMethod(true,"getSize").<Integer>get()
;int index70 = 0;
;
for (; index70 < groupLen70;index70++){
_existingtitle = BA.ObjectToString(group70.runMethod(false,"Get",index70));Debug.locals.put("existingTitle", _existingtitle);
Debug.locals.put("existingTitle", _existingtitle);
 BA.debugLineNum = 213;BA.debugLine="If existingTitle = title Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_existingtitle,_title)) { 
 BA.debugLineNum = 214;BA.debugLine="MsgboxAsync(\"List already exists.\", \"Duplicate";
Debug.ShouldStop(2097152);
todoactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("List already exists.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Duplicate title"))),todoactivity.processBA);
 BA.debugLineNum = 215;BA.debugLine="newListBtn.Enabled = True";
Debug.ShouldStop(4194304);
todoactivity.mostCurrent._newlistbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 216;BA.debugLine="addTitleTextArea.Text = \"\"";
Debug.ShouldStop(8388608);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 217;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("existingTitle", _existingtitle);
;
 };
 BA.debugLineNum = 222;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
Debug.ShouldStop(536870912);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("lists"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 223;BA.debugLine="savedLists = kvs.Get(\"lists\")";
Debug.ShouldStop(1073741824);
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);
 };
 BA.debugLineNum = 226;BA.debugLine="savedLists.Add(title)";
Debug.ShouldStop(2);
_savedlists.runVoidMethod ("Add",(Object)((_title)));
 BA.debugLineNum = 227;BA.debugLine="kvs.Put(\"lists\", savedLists)";
Debug.ShouldStop(4);
todoactivity._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("lists")),(Object)((_savedlists.getObject())));
 BA.debugLineNum = 229;BA.debugLine="listsList.AddTextItem(title, title)";
Debug.ShouldStop(16);
todoactivity.mostCurrent._listslist.runVoidMethod ("_addtextitem",(Object)((_title)),(Object)((_title)));
 BA.debugLineNum = 231;BA.debugLine="currentList = title";
Debug.ShouldStop(64);
todoactivity.mostCurrent._currentlist = _title;
 BA.debugLineNum = 232;BA.debugLine="addTitleTextArea.Text = currentList";
Debug.ShouldStop(128);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(todoactivity.mostCurrent._currentlist));
 BA.debugLineNum = 233;BA.debugLine="addTitleTextArea.Visible = True";
Debug.ShouldStop(256);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 234;BA.debugLine="addTitleTextArea.Enabled = False";
Debug.ShouldStop(512);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 236;BA.debugLine="tasksList.Clear";
Debug.ShouldStop(2048);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_clear");
 BA.debugLineNum = 237;BA.debugLine="tasksList.GetBase.Visible = True";
Debug.ShouldStop(4096);
todoactivity.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 238;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(8192);
_newaddtaskbtn();
 BA.debugLineNum = 240;BA.debugLine="newListBtn.Enabled = True";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._newlistbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 241;BA.debugLine="isAddingList = False";
Debug.ShouldStop(65536);
todoactivity._isaddinglist = todoactivity.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 242;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
Debug.ShouldStop(131072);
todoactivity.mostCurrent._progressnumber.runMethod(true,"setText",BA.ObjectToCharSequence("0 / 0 tasks done!"));
 BA.debugLineNum = 243;BA.debugLine="progressPercent.Text = \"0%\"";
Debug.ShouldStop(262144);
todoactivity.mostCurrent._progresspercent.runMethod(true,"setText",BA.ObjectToCharSequence("0%"));
 BA.debugLineNum = 244;BA.debugLine="progressBar.Progress = 0";
Debug.ShouldStop(524288);
todoactivity.mostCurrent._progressbar.runMethod(true,"setProgress",BA.numberCast(int.class, 0));
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
public static RemoteObject  _entertaskbtn_click() throws Exception{
try {
		Debug.PushSubsStack("enterTaskBtn_Click (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,366);
if (RapidSub.canDelegate("entertaskbtn_click")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","entertaskbtn_click");}
RemoteObject _newtask = RemoteObject.createImmutable("");
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _existingtask = RemoteObject.createImmutable("");
RemoteObject _ctx = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _oldtask = RemoteObject.createImmutable("");
RemoteObject _taskindex = RemoteObject.createImmutable(0);
RemoteObject _oldck = RemoteObject.createImmutable("");
RemoteObject _newck = RemoteObject.createImmutable("");
RemoteObject _savedtasks2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _t = RemoteObject.createImmutable("");
 BA.debugLineNum = 366;BA.debugLine="Sub enterTaskBtn_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 368;BA.debugLine="Dim newTask As String = addTaskTextArea.Text.Trim";
Debug.ShouldStop(32768);
_newtask = todoactivity.mostCurrent._addtasktextarea.runMethod(true,"getText").runMethod(true,"trim");Debug.locals.put("newTask", _newtask);Debug.locals.put("newTask", _newtask);
 BA.debugLineNum = 369;BA.debugLine="If newTask = \"\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_newtask,BA.ObjectToString(""))) { 
 BA.debugLineNum = 370;BA.debugLine="MsgboxAsync(\"Please enter a task.\", \"No task ent";
Debug.ShouldStop(131072);
todoactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Please enter a task.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("No task entered"))),todoactivity.processBA);
 BA.debugLineNum = 371;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 374;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(2097152);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),todoactivity.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 375;BA.debugLine="Dim savedTasks As List";
Debug.ShouldStop(4194304);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 376;BA.debugLine="savedTasks.Initialize";
Debug.ShouldStop(8388608);
_savedtasks.runVoidMethod ("Initialize");
 BA.debugLineNum = 378;BA.debugLine="If kvs.ContainsKey(key) Then";
Debug.ShouldStop(33554432);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_key)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 379;BA.debugLine="savedTasks = kvs.Get(key)";
Debug.ShouldStop(67108864);
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);
 };
 BA.debugLineNum = 382;BA.debugLine="For Each existingTask As String In savedTasks";
Debug.ShouldStop(536870912);
{
final RemoteObject group12 = _savedtasks;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_existingtask = BA.ObjectToString(group12.runMethod(false,"Get",index12));Debug.locals.put("existingTask", _existingtask);
Debug.locals.put("existingTask", _existingtask);
 BA.debugLineNum = 383;BA.debugLine="If existingTask = newTask Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_existingtask,_newtask)) { 
 BA.debugLineNum = 384;BA.debugLine="MsgboxAsync(\"A task with that name already exis";
Debug.ShouldStop(-2147483648);
todoactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("A task with that name already exists.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Duplicate task"))),todoactivity.processBA);
 BA.debugLineNum = 385;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("existingTask", _existingtask);
;
 BA.debugLineNum = 390;BA.debugLine="If addTaskTextArea.Tag <> Null Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("N",todoactivity.mostCurrent._addtasktextarea.runMethod(false,"getTag"))) { 
 BA.debugLineNum = 391;BA.debugLine="Dim ctx As List = addTaskTextArea.Tag";
Debug.ShouldStop(64);
_ctx = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_ctx = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity.mostCurrent._addtasktextarea.runMethod(false,"getTag"));Debug.locals.put("ctx", _ctx);Debug.locals.put("ctx", _ctx);
 BA.debugLineNum = 392;BA.debugLine="Dim oldTask As String = ctx.Get(1)";
Debug.ShouldStop(128);
_oldtask = BA.ObjectToString(_ctx.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("oldTask", _oldtask);Debug.locals.put("oldTask", _oldtask);
 BA.debugLineNum = 394;BA.debugLine="Dim taskIndex As Int = savedTasks.IndexOf(oldTas";
Debug.ShouldStop(512);
_taskindex = _savedtasks.runMethod(true,"IndexOf",(Object)((_oldtask)));Debug.locals.put("taskIndex", _taskindex);Debug.locals.put("taskIndex", _taskindex);
 BA.debugLineNum = 395;BA.debugLine="If taskIndex >= 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("g",_taskindex,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 396;BA.debugLine="savedTasks.Set(taskIndex, newTask)";
Debug.ShouldStop(2048);
_savedtasks.runVoidMethod ("Set",(Object)(_taskindex),(Object)((_newtask)));
 BA.debugLineNum = 397;BA.debugLine="kvs.Put(key, savedTasks)";
Debug.ShouldStop(4096);
todoactivity._kvs.runVoidMethod ("_put",(Object)(_key),(Object)((_savedtasks.getObject())));
 };
 BA.debugLineNum = 401;BA.debugLine="Dim oldCK As String = \"checked_\" & currentList &";
Debug.ShouldStop(65536);
_oldck = RemoteObject.concat(RemoteObject.createImmutable("checked_"),todoactivity.mostCurrent._currentlist,RemoteObject.createImmutable("_"),_oldtask);Debug.locals.put("oldCK", _oldck);Debug.locals.put("oldCK", _oldck);
 BA.debugLineNum = 402;BA.debugLine="Dim newCK As String = \"checked_\" & currentList &";
Debug.ShouldStop(131072);
_newck = RemoteObject.concat(RemoteObject.createImmutable("checked_"),todoactivity.mostCurrent._currentlist,RemoteObject.createImmutable("_"),_newtask);Debug.locals.put("newCK", _newck);Debug.locals.put("newCK", _newck);
 BA.debugLineNum = 403;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
Debug.ShouldStop(262144);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_oldck)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 404;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
Debug.ShouldStop(524288);
todoactivity._kvs.runVoidMethod ("_put",(Object)(_newck),(Object)(todoactivity._kvs.runMethod(false,"_get",(Object)(_oldck))));
 BA.debugLineNum = 405;BA.debugLine="kvs.Remove(oldCK)";
Debug.ShouldStop(1048576);
todoactivity._kvs.runVoidMethod ("_remove",(Object)(_oldck));
 };
 BA.debugLineNum = 408;BA.debugLine="addTaskTextArea.Tag = Null";
Debug.ShouldStop(8388608);
todoactivity.mostCurrent._addtasktextarea.runMethod(false,"setTag",todoactivity.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 411;BA.debugLine="tasksList.Clear";
Debug.ShouldStop(67108864);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_clear");
 BA.debugLineNum = 412;BA.debugLine="Dim savedTasks2 As List = kvs.Get(key)";
Debug.ShouldStop(134217728);
_savedtasks2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks2", _savedtasks2);Debug.locals.put("savedTasks2", _savedtasks2);
 BA.debugLineNum = 413;BA.debugLine="For Each t As String In savedTasks2";
Debug.ShouldStop(268435456);
{
final RemoteObject group35 = _savedtasks2;
final int groupLen35 = group35.runMethod(true,"getSize").<Integer>get()
;int index35 = 0;
;
for (; index35 < groupLen35;index35++){
_t = BA.ObjectToString(group35.runMethod(false,"Get",index35));Debug.locals.put("t", _t);
Debug.locals.put("t", _t);
 BA.debugLineNum = 414;BA.debugLine="tasksListUI(t)";
Debug.ShouldStop(536870912);
_taskslistui(_t);
 }
}Debug.locals.put("t", _t);
;
 BA.debugLineNum = 416;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(-2147483648);
_newaddtaskbtn();
 BA.debugLineNum = 417;BA.debugLine="addTaskBtn.Enabled = True";
Debug.ShouldStop(1);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 418;BA.debugLine="updateProgress";
Debug.ShouldStop(2);
_updateprogress();
 BA.debugLineNum = 419;BA.debugLine="ToastMessageShow(\"Task renamed\", False)";
Debug.ShouldStop(4);
todoactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Task renamed")),(Object)(todoactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 420;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 424;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
Debug.ShouldStop(128);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_removeat",(Object)(RemoteObject.solve(new RemoteObject[] {todoactivity.mostCurrent._taskslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 426;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(512);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),todoactivity.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 427;BA.debugLine="Dim savedTasks As List";
Debug.ShouldStop(1024);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 428;BA.debugLine="If kvs.ContainsKey(key) Then";
Debug.ShouldStop(2048);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_key)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 429;BA.debugLine="savedTasks = kvs.Get(key)";
Debug.ShouldStop(4096);
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);
 }else {
 BA.debugLineNum = 431;BA.debugLine="savedTasks.Initialize";
Debug.ShouldStop(16384);
_savedtasks.runVoidMethod ("Initialize");
 };
 BA.debugLineNum = 434;BA.debugLine="savedTasks.Add(newTask)";
Debug.ShouldStop(131072);
_savedtasks.runVoidMethod ("Add",(Object)((_newtask)));
 BA.debugLineNum = 435;BA.debugLine="kvs.Put(key, savedTasks)";
Debug.ShouldStop(262144);
todoactivity._kvs.runVoidMethod ("_put",(Object)(_key),(Object)((_savedtasks.getObject())));
 BA.debugLineNum = 437;BA.debugLine="tasksListUI(newTask)";
Debug.ShouldStop(1048576);
_taskslistui(_newtask);
 BA.debugLineNum = 438;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(2097152);
_newaddtaskbtn();
 BA.debugLineNum = 439;BA.debugLine="addTaskBtn.Enabled = True";
Debug.ShouldStop(4194304);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 440;BA.debugLine="updateProgress";
Debug.ShouldStop(8388608);
_updateprogress();
 BA.debugLineNum = 442;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 16;BA.debugLine="Private addTitleTextArea As EditText";
todoactivity.mostCurrent._addtitletextarea = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private listsList As CustomListView";
todoactivity.mostCurrent._listslist = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 18;BA.debugLine="Private newListBtn As Button";
todoactivity.mostCurrent._newlistbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private tasksList As CustomListView";
todoactivity.mostCurrent._taskslist = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 20;BA.debugLine="Dim isAddingList As Boolean = False";
todoactivity._isaddinglist = todoactivity.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 22;BA.debugLine="Dim addTaskBtnPNL As Panel";
todoactivity.mostCurrent._addtaskbtnpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim addTaskBtn As Button";
todoactivity.mostCurrent._addtaskbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private currentList As String = \"\"";
todoactivity.mostCurrent._currentlist = BA.ObjectToString("");
 //BA.debugLineNum = 27;BA.debugLine="Dim addTaskPanel As Panel";
todoactivity.mostCurrent._addtaskpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim addTaskTextArea As EditText";
todoactivity.mostCurrent._addtasktextarea = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim enterTaskBtn As Button";
todoactivity.mostCurrent._entertaskbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim untitledNo As Int = 1";
todoactivity._untitledno = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 33;BA.debugLine="Private progressNumber As Label";
todoactivity.mostCurrent._progressnumber = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private progressPercent As Label";
todoactivity.mostCurrent._progresspercent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private progressBar As ProgressBar";
todoactivity.mostCurrent._progressbar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _listslist_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("listsList_ItemClick (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,248);
if (RapidSub.canDelegate("listslist_itemclick")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","listslist_itemclick", _index, _value);}
RemoteObject _listpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _listlbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _task = RemoteObject.createImmutable("");
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 248;BA.debugLine="Sub listsList_ItemClick(Index As Int, Value As Obj";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 250;BA.debugLine="If isAddingList Then Return";
Debug.ShouldStop(33554432);
if (todoactivity._isaddinglist.<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 252;BA.debugLine="Dim listPNL As B4XView = listsList.GetPanel(Index";
Debug.ShouldStop(134217728);
_listpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_listpnl = todoactivity.mostCurrent._listslist.runMethod(false,"_getpanel",(Object)(_index));Debug.locals.put("listPNL", _listpnl);Debug.locals.put("listPNL", _listpnl);
 BA.debugLineNum = 253;BA.debugLine="Dim listLBL As Label = listPNL.GetView(0)";
Debug.ShouldStop(268435456);
_listlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_listlbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _listpnl.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("listLBL", _listlbl);Debug.locals.put("listLBL", _listlbl);
 BA.debugLineNum = 255;BA.debugLine="currentList = listLBL.Text";
Debug.ShouldStop(1073741824);
todoactivity.mostCurrent._currentlist = _listlbl.runMethod(true,"getText");
 BA.debugLineNum = 256;BA.debugLine="addTitleTextArea.Text = currentList";
Debug.ShouldStop(-2147483648);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(todoactivity.mostCurrent._currentlist));
 BA.debugLineNum = 257;BA.debugLine="addTitleTextArea.Visible = True";
Debug.ShouldStop(1);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 259;BA.debugLine="tasksList.Clear";
Debug.ShouldStop(4);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_clear");
 BA.debugLineNum = 261;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(16);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),todoactivity.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 263;BA.debugLine="If kvs.ContainsKey(key) Then";
Debug.ShouldStop(64);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_key)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 264;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
Debug.ShouldStop(128);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 265;BA.debugLine="For Each task As String In savedTasks";
Debug.ShouldStop(256);
{
final RemoteObject group11 = _savedtasks;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_task = BA.ObjectToString(group11.runMethod(false,"Get",index11));Debug.locals.put("task", _task);
Debug.locals.put("task", _task);
 BA.debugLineNum = 266;BA.debugLine="tasksListUI(task)";
Debug.ShouldStop(512);
_taskslistui(_task);
 }
}Debug.locals.put("task", _task);
;
 };
 BA.debugLineNum = 270;BA.debugLine="tasksList.GetBase.Visible = True";
Debug.ShouldStop(8192);
todoactivity.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 271;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(16384);
_newaddtaskbtn();
 BA.debugLineNum = 272;BA.debugLine="updateProgress";
Debug.ShouldStop(32768);
_updateprogress();
 BA.debugLineNum = 274;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _listslist_itemlongclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("listsList_ItemLongClick (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,276);
if (RapidSub.canDelegate("listslist_itemlongclick")) { b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","listslist_itemlongclick", _index, _value); return;}
ResumableSub_listsList_ItemLongClick rsub = new ResumableSub_listsList_ItemLongClick(null,_index,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_listsList_ItemLongClick extends BA.ResumableSub {
public ResumableSub_listsList_ItemLongClick(b4a.example.todoactivity parent,RemoteObject _index,RemoteObject _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.todoactivity parent;
RemoteObject _index;
RemoteObject _value;
RemoteObject _res = RemoteObject.createImmutable(0);
RemoteObject _savedlists = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _task = RemoteObject.createImmutable("");
RemoteObject group18;
int index18;
int groupLen18;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("listsList_ItemLongClick (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,276);
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
 BA.debugLineNum = 278;BA.debugLine="Msgbox2Async(\"Delete or rename this list?\", Value";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Delete or rename this list?")),(Object)(BA.ObjectToCharSequence(_value)),(Object)(BA.ObjectToString("Rename")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Delete")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),todoactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 279;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", todoactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "todoactivity", "listslist_itemlongclick"), null);
this.state = 22;
return;
case 22:
//C
this.state = 1;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 281;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
Debug.ShouldStop(16777216);
if (true) break;

case 1:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}else 
{ BA.debugLineNum = 284;BA.debugLine="Else If res = DialogResponse.NEGATIVE Then ' Dele";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 5;
}}
if (true) break;

case 3:
//C
this.state = 21;
 BA.debugLineNum = 282;BA.debugLine="showRenameListPanel(Index, Value)";
Debug.ShouldStop(33554432);
_showrenamelistpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 286;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete th";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Are you sure you want to delete the list \""),_value,RemoteObject.createImmutable("\"?")))),(Object)(BA.ObjectToCharSequence("Confirmation")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),todoactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 287;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", todoactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "todoactivity", "listslist_itemlongclick"), null);
this.state = 23;
return;
case 23:
//C
this.state = 6;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 288;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 6:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 8;
}if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 289;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
Debug.ShouldStop(1);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 290;BA.debugLine="savedLists.RemoveAt(Index)";
Debug.ShouldStop(2);
_savedlists.runVoidMethod ("RemoveAt",(Object)(_index));
 BA.debugLineNum = 291;BA.debugLine="kvs.Put(\"lists\", savedLists)";
Debug.ShouldStop(4);
parent._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("lists")),(Object)((_savedlists.getObject())));
 BA.debugLineNum = 292;BA.debugLine="listsList.RemoveAt(Index)";
Debug.ShouldStop(8);
parent.mostCurrent._listslist.runVoidMethod ("_removeat",(Object)(_index));
 BA.debugLineNum = 293;BA.debugLine="ToastMessageShow(\"List deleted\", False)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("List deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 9:
//C
this.state = 10;
;
 BA.debugLineNum = 297;BA.debugLine="Dim key As String = \"list_\" & Value";
Debug.ShouldStop(256);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),_value);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 298;BA.debugLine="If kvs.ContainsKey(key) Then";
Debug.ShouldStop(512);
if (true) break;

case 10:
//if
this.state = 17;
if (parent._kvs.runMethod(true,"_containskey",(Object)(_key)).<Boolean>get().booleanValue()) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 299;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
Debug.ShouldStop(1024);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 300;BA.debugLine="For Each task As String In savedTasks";
Debug.ShouldStop(2048);
if (true) break;

case 13:
//for
this.state = 16;
group18 = _savedtasks;
index18 = 0;
groupLen18 = group18.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("task", _task);
this.state = 24;
if (true) break;

case 24:
//C
this.state = 16;
if (index18 < groupLen18) {
this.state = 15;
_task = BA.ObjectToString(group18.runMethod(false,"Get",index18));Debug.locals.put("task", _task);}
if (true) break;

case 25:
//C
this.state = 24;
index18++;
Debug.locals.put("task", _task);
if (true) break;

case 15:
//C
this.state = 25;
 BA.debugLineNum = 301;BA.debugLine="kvs.Remove(\"checked_\" & Value & \"_\" & task)";
Debug.ShouldStop(4096);
parent._kvs.runVoidMethod ("_remove",(Object)(RemoteObject.concat(RemoteObject.createImmutable("checked_"),_value,RemoteObject.createImmutable("_"),_task)));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
Debug.locals.put("task", _task);
;
 BA.debugLineNum = 303;BA.debugLine="kvs.Remove(key)";
Debug.ShouldStop(16384);
parent._kvs.runVoidMethod ("_remove",(Object)(_key));
 if (true) break;
;
 BA.debugLineNum = 307;BA.debugLine="If currentList = Value Then";
Debug.ShouldStop(262144);

case 17:
//if
this.state = 20;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._currentlist,BA.ObjectToString(_value))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 308;BA.debugLine="currentList = \"\"";
Debug.ShouldStop(524288);
parent.mostCurrent._currentlist = BA.ObjectToString("");
 BA.debugLineNum = 309;BA.debugLine="tasksList.Clear";
Debug.ShouldStop(1048576);
parent.mostCurrent._taskslist.runVoidMethod ("_clear");
 BA.debugLineNum = 310;BA.debugLine="tasksList.GetBase.Visible = False";
Debug.ShouldStop(2097152);
parent.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 311;BA.debugLine="addTitleTextArea.Text = \"\"";
Debug.ShouldStop(4194304);
parent.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 312;BA.debugLine="addTitleTextArea.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._addtitletextarea.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 20:
//C
this.state = 21;
;
 if (true) break;

case 21:
//C
this.state = -1;
;
 BA.debugLineNum = 316;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
public static RemoteObject  _newaddtaskbtn() throws Exception{
try {
		Debug.PushSubsStack("newAddTaskBtn (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,72);
if (RapidSub.canDelegate("newaddtaskbtn")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","newaddtaskbtn");}
 BA.debugLineNum = 72;BA.debugLine="Sub newAddTaskBtn";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(256);
if (todoactivity.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 74;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
Debug.ShouldStop(512);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskBtnPNL")));
 BA.debugLineNum = 75;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 235dip, 50dip)";
Debug.ShouldStop(1024);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 235)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 76;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 17, 17, 1";
Debug.ShouldStop(2048);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("setColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 17)),(Object)(BA.numberCast(int.class, 17)),(Object)(BA.numberCast(int.class, 17))));
 BA.debugLineNum = 78;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
Debug.ShouldStop(8192);
todoactivity.mostCurrent._addtaskbtn.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskBtn")));
 BA.debugLineNum = 79;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
Debug.ShouldStop(16384);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setText",BA.ObjectToCharSequence("+ add a task "));
 BA.debugLineNum = 80;BA.debugLine="addTaskBtn.TextColor = Colors.DarkGray";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray"));
 BA.debugLineNum = 81;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0dip,";
Debug.ShouldStop(65536);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("AddView",(Object)((todoactivity.mostCurrent._addtaskbtn.getObject())),(Object)(BA.numberCast(int.class, -(double) (0 + todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))).<Integer>get().intValue()))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getHeight")));
 BA.debugLineNum = 83;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
Debug.ShouldStop(262144);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), todoactivity.mostCurrent._addtaskbtnpnl.getObject()),(Object)((RemoteObject.createImmutable(""))));
 }else {
 BA.debugLineNum = 85;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
Debug.ShouldStop(1048576);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskBtnPNL")));
 BA.debugLineNum = 86;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 235dip, 50dip)";
Debug.ShouldStop(2097152);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 235)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 87;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 250, 250,";
Debug.ShouldStop(4194304);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("setColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 89;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
Debug.ShouldStop(16777216);
todoactivity.mostCurrent._addtaskbtn.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskBtn")));
 BA.debugLineNum = 90;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
Debug.ShouldStop(33554432);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setText",BA.ObjectToCharSequence("+ add a task "));
 BA.debugLineNum = 91;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0dip, a";
Debug.ShouldStop(67108864);
todoactivity.mostCurrent._addtaskbtnpnl.runVoidMethod ("AddView",(Object)((todoactivity.mostCurrent._addtaskbtn.getObject())),(Object)(BA.numberCast(int.class, -(double) (0 + todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))).<Integer>get().intValue()))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getHeight")));
 BA.debugLineNum = 93;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
Debug.ShouldStop(268435456);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), todoactivity.mostCurrent._addtaskbtnpnl.getObject()),(Object)((RemoteObject.createImmutable(""))));
 };
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _newlistbtn_click() throws Exception{
try {
		Debug.PushSubsStack("newListBtn_Click (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,97);
if (RapidSub.canDelegate("newlistbtn_click")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","newlistbtn_click");}
 BA.debugLineNum = 97;BA.debugLine="Sub newListBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="tasksList.Clear";
Debug.ShouldStop(4);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_clear");
 BA.debugLineNum = 100;BA.debugLine="isAddingList = True";
Debug.ShouldStop(8);
todoactivity._isaddinglist = todoactivity.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 102;BA.debugLine="progressNumber.Text = \"\"";
Debug.ShouldStop(32);
todoactivity.mostCurrent._progressnumber.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 103;BA.debugLine="progressPercent.Text = \"\"";
Debug.ShouldStop(64);
todoactivity.mostCurrent._progresspercent.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 104;BA.debugLine="progressBar.Progress = 0";
Debug.ShouldStop(128);
todoactivity.mostCurrent._progressbar.runMethod(true,"setProgress",BA.numberCast(int.class, 0));
 BA.debugLineNum = 106;BA.debugLine="addTitleTextArea.Visible = True";
Debug.ShouldStop(512);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 107;BA.debugLine="addTitleTextArea.Enabled = True";
Debug.ShouldStop(1024);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 108;BA.debugLine="addTitleTextArea.Background = Null";
Debug.ShouldStop(2048);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setBackground",(todoactivity.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 109;BA.debugLine="addTitleTextArea.Text = \"\"";
Debug.ShouldStop(4096);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 110;BA.debugLine="addTitleTextArea.Hint = \"+ add a title...\"";
Debug.ShouldStop(8192);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setHint",BA.ObjectToString("+ add a title..."));
 BA.debugLineNum = 111;BA.debugLine="addTitleTextArea.RequestFocus";
Debug.ShouldStop(16384);
todoactivity.mostCurrent._addtitletextarea.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 112;BA.debugLine="addTitleTextArea.Tag = Null";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setTag",todoactivity.mostCurrent.__c.getField(false,"Null"));
 BA.debugLineNum = 114;BA.debugLine="newListBtn.Enabled = False";
Debug.ShouldStop(131072);
todoactivity.mostCurrent._newlistbtn.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 116;BA.debugLine="tasksList.GetBase.Visible = True";
Debug.ShouldStop(524288);
todoactivity.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 117;BA.debugLine="addTaskBtn.Visible = True";
Debug.ShouldStop(1048576);
todoactivity.mostCurrent._addtaskbtn.runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
todoactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="Public kvs As KeyValueStore";
todoactivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showrenamelistpanel(RemoteObject _index,RemoteObject _oldtitle) throws Exception{
try {
		Debug.PushSubsStack("showRenameListPanel (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,318);
if (RapidSub.canDelegate("showrenamelistpanel")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","showrenamelistpanel", _index, _oldtitle);}
RemoteObject _ctx = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Index", _index);
Debug.locals.put("oldTitle", _oldtitle);
 BA.debugLineNum = 318;BA.debugLine="Sub showRenameListPanel(Index As Int, oldTitle As";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 320;BA.debugLine="addTitleTextArea.Text = oldTitle";
Debug.ShouldStop(-2147483648);
todoactivity.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_oldtitle));
 BA.debugLineNum = 321;BA.debugLine="addTitleTextArea.Visible = True";
Debug.ShouldStop(1);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setVisible",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 322;BA.debugLine="addTitleTextArea.Enabled = True";
Debug.ShouldStop(2);
todoactivity.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",todoactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 323;BA.debugLine="addTitleTextArea.RequestFocus";
Debug.ShouldStop(4);
todoactivity.mostCurrent._addtitletextarea.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 325;BA.debugLine="Dim ctx As List";
Debug.ShouldStop(16);
_ctx = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ctx", _ctx);
 BA.debugLineNum = 326;BA.debugLine="ctx.Initialize";
Debug.ShouldStop(32);
_ctx.runVoidMethod ("Initialize");
 BA.debugLineNum = 327;BA.debugLine="ctx.Add(Index)";
Debug.ShouldStop(64);
_ctx.runVoidMethod ("Add",(Object)((_index)));
 BA.debugLineNum = 328;BA.debugLine="ctx.Add(oldTitle)";
Debug.ShouldStop(128);
_ctx.runVoidMethod ("Add",(Object)((_oldtitle)));
 BA.debugLineNum = 329;BA.debugLine="addTitleTextArea.Tag = ctx";
Debug.ShouldStop(256);
todoactivity.mostCurrent._addtitletextarea.runMethod(false,"setTag",(_ctx.getObject()));
 BA.debugLineNum = 331;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showrenametaskpanel(RemoteObject _index,RemoteObject _oldtask) throws Exception{
try {
		Debug.PushSubsStack("showRenameTaskPanel (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,467);
if (RapidSub.canDelegate("showrenametaskpanel")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","showrenametaskpanel", _index, _oldtask);}
RemoteObject _ctx = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Index", _index);
Debug.locals.put("oldTask", _oldtask);
 BA.debugLineNum = 467;BA.debugLine="Sub showRenameTaskPanel(Index As Int, oldTask As S";
Debug.ShouldStop(262144);
 BA.debugLineNum = 469;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1) ' remove \"";
Debug.ShouldStop(1048576);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_removeat",(Object)(RemoteObject.solve(new RemoteObject[] {todoactivity.mostCurrent._taskslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 471;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
Debug.ShouldStop(4194304);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskPanel")));
 BA.debugLineNum = 472;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 250dip, 100dip)";
Debug.ShouldStop(8388608);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("SetLayout",(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 473;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
Debug.ShouldStop(16777216);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("setColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247))));
 BA.debugLineNum = 475;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
Debug.ShouldStop(67108864);
todoactivity.mostCurrent._addtasktextarea.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTodoText")));
 BA.debugLineNum = 476;BA.debugLine="addTaskTextArea.Text = oldTask";
Debug.ShouldStop(134217728);
todoactivity.mostCurrent._addtasktextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_oldtask));
 BA.debugLineNum = 477;BA.debugLine="Dim ctx As List";
Debug.ShouldStop(268435456);
_ctx = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ctx", _ctx);
 BA.debugLineNum = 478;BA.debugLine="ctx.Initialize";
Debug.ShouldStop(536870912);
_ctx.runVoidMethod ("Initialize");
 BA.debugLineNum = 479;BA.debugLine="ctx.Add(Index)";
Debug.ShouldStop(1073741824);
_ctx.runVoidMethod ("Add",(Object)((_index)));
 BA.debugLineNum = 480;BA.debugLine="ctx.Add(oldTask)";
Debug.ShouldStop(-2147483648);
_ctx.runVoidMethod ("Add",(Object)((_oldtask)));
 BA.debugLineNum = 481;BA.debugLine="addTaskTextArea.Tag = ctx";
Debug.ShouldStop(1);
todoactivity.mostCurrent._addtasktextarea.runMethod(false,"setTag",(_ctx.getObject()));
 BA.debugLineNum = 483;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
Debug.ShouldStop(4);
todoactivity.mostCurrent._entertaskbtn.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("enterTaskBtn")));
 BA.debugLineNum = 484;BA.debugLine="enterTaskBtn.Text = \"Rename task\"";
Debug.ShouldStop(8);
todoactivity.mostCurrent._entertaskbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Rename task"));
 BA.debugLineNum = 486;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, addTa";
Debug.ShouldStop(32);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("AddView",(Object)((todoactivity.mostCurrent._addtasktextarea.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 487;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, addT";
Debug.ShouldStop(64);
todoactivity.mostCurrent._addtaskpanel.runVoidMethod ("AddView",(Object)((todoactivity.mostCurrent._entertaskbtn.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(todoactivity.mostCurrent._addtaskbtnpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 489;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
Debug.ShouldStop(256);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), todoactivity.mostCurrent._addtaskpanel.getObject()),(Object)((todoactivity.mostCurrent._addtaskpanel.getObject())));
 BA.debugLineNum = 491;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _taskcheckbox_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("taskCheckbox_CheckedChange (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,493);
if (RapidSub.canDelegate("taskcheckbox_checkedchange")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","taskcheckbox_checkedchange", _checked);}
RemoteObject _taskcheckbox = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _tasklbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _key = RemoteObject.createImmutable("");
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 493;BA.debugLine="Sub taskCheckbox_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 495;BA.debugLine="Dim taskCheckbox As CheckBox = Sender";
Debug.ShouldStop(16384);
_taskcheckbox = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_taskcheckbox = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), todoactivity.mostCurrent.__c.runMethod(false,"Sender",todoactivity.mostCurrent.activityBA));Debug.locals.put("taskCheckbox", _taskcheckbox);Debug.locals.put("taskCheckbox", _taskcheckbox);
 BA.debugLineNum = 496;BA.debugLine="Dim taskLBL As Label = taskCheckbox.Tag";
Debug.ShouldStop(32768);
_tasklbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_tasklbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _taskcheckbox.runMethod(false,"getTag"));Debug.locals.put("taskLBL", _tasklbl);Debug.locals.put("taskLBL", _tasklbl);
 BA.debugLineNum = 497;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(65536);
if (todoactivity.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 498;BA.debugLine="If Checked Then";
Debug.ShouldStop(131072);
if (_checked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 499;BA.debugLine="taskLBL.TextColor = Colors.ARGB(255, 128, 128,";
Debug.ShouldStop(262144);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128))));
 }else {
 BA.debugLineNum = 501;BA.debugLine="taskLBL.TextColor = Colors.White";
Debug.ShouldStop(1048576);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 };
 }else {
 BA.debugLineNum = 504;BA.debugLine="If Checked Then";
Debug.ShouldStop(8388608);
if (_checked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 505;BA.debugLine="taskLBL.TextColor = Colors.ARGB(255, 128, 128,";
Debug.ShouldStop(16777216);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128))));
 }else {
 BA.debugLineNum = 507;BA.debugLine="taskLBL.TextColor = Colors.Black";
Debug.ShouldStop(67108864);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 };
 };
 BA.debugLineNum = 512;BA.debugLine="Dim key As String = \"checked_\" & currentList & \"_";
Debug.ShouldStop(-2147483648);
_key = RemoteObject.concat(RemoteObject.createImmutable("checked_"),todoactivity.mostCurrent._currentlist,RemoteObject.createImmutable("_"),_tasklbl.runMethod(true,"getText"));Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 513;BA.debugLine="kvs.Put(key, Checked)";
Debug.ShouldStop(1);
todoactivity._kvs.runVoidMethod ("_put",(Object)(_key),(Object)((_checked)));
 BA.debugLineNum = 515;BA.debugLine="updateProgress";
Debug.ShouldStop(4);
_updateprogress();
 BA.debugLineNum = 517;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _taskslist_itemlongclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("tasksList_ItemLongClick (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,444);
if (RapidSub.canDelegate("taskslist_itemlongclick")) { b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","taskslist_itemlongclick", _index, _value); return;}
ResumableSub_tasksList_ItemLongClick rsub = new ResumableSub_tasksList_ItemLongClick(null,_index,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_tasksList_ItemLongClick extends BA.ResumableSub {
public ResumableSub_tasksList_ItemLongClick(b4a.example.todoactivity parent,RemoteObject _index,RemoteObject _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.todoactivity parent;
RemoteObject _index;
RemoteObject _value;
RemoteObject _res = RemoteObject.createImmutable(0);
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("tasksList_ItemLongClick (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,444);
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
 BA.debugLineNum = 446;BA.debugLine="If Value = \"\" Then Return";
Debug.ShouldStop(536870912);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable(("")))) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 BA.debugLineNum = 448;BA.debugLine="Msgbox2Async(\"Delete or rename this task?\", Value";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Delete or rename this task?")),(Object)(BA.ObjectToCharSequence(_value)),(Object)(BA.ObjectToString("Rename")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Delete")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),todoactivity.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 449;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", todoactivity.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "todoactivity", "taskslist_itemlongclick"), null);
this.state = 13;
return;
case 13:
//C
this.state = 7;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 451;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
Debug.ShouldStop(4);
if (true) break;

case 7:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 9;
}else 
{ BA.debugLineNum = 454;BA.debugLine="Else If res = DialogResponse.NEGATIVE Then ' Dele";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 11;
}}
if (true) break;

case 9:
//C
this.state = 12;
 BA.debugLineNum = 452;BA.debugLine="showRenameTaskPanel(Index, Value)";
Debug.ShouldStop(8);
_showrenametaskpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 455;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(64);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),parent.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 456;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
Debug.ShouldStop(128);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 457;BA.debugLine="savedTasks.RemoveAt(Index)";
Debug.ShouldStop(256);
_savedtasks.runVoidMethod ("RemoveAt",(Object)(_index));
 BA.debugLineNum = 458;BA.debugLine="kvs.Put(key, savedTasks)";
Debug.ShouldStop(512);
parent._kvs.runVoidMethod ("_put",(Object)(_key),(Object)((_savedtasks.getObject())));
 BA.debugLineNum = 459;BA.debugLine="kvs.Remove(\"checked_\" & currentList & \"_\" & Valu";
Debug.ShouldStop(1024);
parent._kvs.runVoidMethod ("_remove",(Object)(RemoteObject.concat(RemoteObject.createImmutable("checked_"),parent.mostCurrent._currentlist,RemoteObject.createImmutable("_"),_value)));
 BA.debugLineNum = 460;BA.debugLine="tasksList.RemoveAt(Index)";
Debug.ShouldStop(2048);
parent.mostCurrent._taskslist.runVoidMethod ("_removeat",(Object)(_index));
 BA.debugLineNum = 461;BA.debugLine="updateProgress";
Debug.ShouldStop(4096);
_updateprogress();
 BA.debugLineNum = 462;BA.debugLine="ToastMessageShow(\"Task deleted\", False)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Task deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 465;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
public static RemoteObject  _taskslistui(RemoteObject _newtask) throws Exception{
try {
		Debug.PushSubsStack("tasksListUI (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,519);
if (RapidSub.canDelegate("taskslistui")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","taskslistui", _newtask);}
RemoteObject _taskpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _taskcheckbox = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _tasklbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _divider = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _checkedkey = RemoteObject.createImmutable("");
RemoteObject _ischecked = RemoteObject.createImmutable(false);
Debug.locals.put("newTask", _newtask);
 BA.debugLineNum = 519;BA.debugLine="Sub tasksListUI(newTask As String)";
Debug.ShouldStop(64);
 BA.debugLineNum = 521;BA.debugLine="Dim taskPNL As Panel";
Debug.ShouldStop(256);
_taskpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("taskPNL", _taskpnl);
 BA.debugLineNum = 522;BA.debugLine="taskPNL.Initialize(\"taskPNL\")";
Debug.ShouldStop(512);
_taskpnl.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskPNL")));
 BA.debugLineNum = 523;BA.debugLine="taskPNL.SetLayout(0, 0, 250dip, 60dip)";
Debug.ShouldStop(1024);
_taskpnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 525;BA.debugLine="Dim taskCheckbox As CheckBox";
Debug.ShouldStop(4096);
_taskcheckbox = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("taskCheckbox", _taskcheckbox);
 BA.debugLineNum = 526;BA.debugLine="taskCheckbox.Initialize(\"taskCheckbox\")";
Debug.ShouldStop(8192);
_taskcheckbox.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskCheckbox")));
 BA.debugLineNum = 527;BA.debugLine="taskPNL.AddView(taskCheckbox, 0dip, 10dip, 40dip,";
Debug.ShouldStop(16384);
_taskpnl.runVoidMethod ("AddView",(Object)((_taskcheckbox.getObject())),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 529;BA.debugLine="Dim taskLBL As Label";
Debug.ShouldStop(65536);
_tasklbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("taskLBL", _tasklbl);
 BA.debugLineNum = 530;BA.debugLine="If Starter.darkMode Then";
Debug.ShouldStop(131072);
if (todoactivity.mostCurrent._starter._darkmode /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 531;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
Debug.ShouldStop(262144);
_tasklbl.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskLBL")));
 BA.debugLineNum = 532;BA.debugLine="taskLBL.Text = newTask";
Debug.ShouldStop(524288);
_tasklbl.runMethod(true,"setText",BA.ObjectToCharSequence(_newtask));
 BA.debugLineNum = 533;BA.debugLine="taskLBL.TextColor = Colors.White";
Debug.ShouldStop(1048576);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 534;BA.debugLine="taskPNL.AddView(taskLBL, 40dip, 20dip, taskPNL.W";
Debug.ShouldStop(2097152);
_taskpnl.runVoidMethod ("AddView",(Object)((_tasklbl.getObject())),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(RemoteObject.solve(new RemoteObject[] {_taskpnl.runMethod(true,"getWidth"),todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))}, "-",1, 1)),(Object)(_taskpnl.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 536;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
Debug.ShouldStop(8388608);
_tasklbl.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskLBL")));
 BA.debugLineNum = 537;BA.debugLine="taskLBL.Text = newTask";
Debug.ShouldStop(16777216);
_tasklbl.runMethod(true,"setText",BA.ObjectToCharSequence(_newtask));
 BA.debugLineNum = 538;BA.debugLine="taskLBL.TextColor = Colors.Black";
Debug.ShouldStop(33554432);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 539;BA.debugLine="taskPNL.AddView(taskLBL, 40dip, 20dip, taskPNL.W";
Debug.ShouldStop(67108864);
_taskpnl.runVoidMethod ("AddView",(Object)((_tasklbl.getObject())),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(RemoteObject.solve(new RemoteObject[] {_taskpnl.runMethod(true,"getWidth"),todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))}, "-",1, 1)),(Object)(_taskpnl.runMethod(true,"getHeight")));
 };
 BA.debugLineNum = 543;BA.debugLine="Dim divider As Panel";
Debug.ShouldStop(1073741824);
_divider = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("divider", _divider);
 BA.debugLineNum = 544;BA.debugLine="divider.Initialize(\"line\")";
Debug.ShouldStop(-2147483648);
_divider.runVoidMethod ("Initialize",todoactivity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("line")));
 BA.debugLineNum = 545;BA.debugLine="divider.Color = Colors.ARGB(255, 60, 60, 60)";
Debug.ShouldStop(1);
_divider.runVoidMethod ("setColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 60)),(Object)(BA.numberCast(int.class, 60)),(Object)(BA.numberCast(int.class, 60))));
 BA.debugLineNum = 546;BA.debugLine="taskPNL.AddView(divider, 0, 59dip, taskPNL.Width,";
Debug.ShouldStop(2);
_taskpnl.runVoidMethod ("AddView",(Object)((_divider.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 59)))),(Object)(_taskpnl.runMethod(true,"getWidth")),(Object)(todoactivity.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 548;BA.debugLine="taskCheckbox.Tag = taskLBL";
Debug.ShouldStop(8);
_taskcheckbox.runMethod(false,"setTag",(_tasklbl.getObject()));
 BA.debugLineNum = 551;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentLi";
Debug.ShouldStop(64);
_checkedkey = RemoteObject.concat(RemoteObject.createImmutable("checked_"),todoactivity.mostCurrent._currentlist,RemoteObject.createImmutable("_"),_newtask);Debug.locals.put("checkedKey", _checkedkey);Debug.locals.put("checkedKey", _checkedkey);
 BA.debugLineNum = 552;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
Debug.ShouldStop(128);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_checkedkey)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 553;BA.debugLine="Dim isChecked As Boolean = kvs.Get(checkedKey)";
Debug.ShouldStop(256);
_ischecked = BA.ObjectToBoolean(todoactivity._kvs.runMethod(false,"_get",(Object)(_checkedkey)));Debug.locals.put("isChecked", _ischecked);Debug.locals.put("isChecked", _ischecked);
 BA.debugLineNum = 554;BA.debugLine="taskCheckbox.Checked = isChecked";
Debug.ShouldStop(512);
_taskcheckbox.runMethodAndSync(true,"setChecked",_ischecked);
 BA.debugLineNum = 555;BA.debugLine="If isChecked Then";
Debug.ShouldStop(1024);
if (_ischecked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 556;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
Debug.ShouldStop(2048);
_tasklbl.runMethod(true,"setTextColor",todoactivity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 };
 };
 BA.debugLineNum = 560;BA.debugLine="tasksList.Add(taskPNL, newTask)";
Debug.ShouldStop(32768);
todoactivity.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _taskpnl.getObject()),(Object)((_newtask)));
 BA.debugLineNum = 562;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updateprogress() throws Exception{
try {
		Debug.PushSubsStack("updateProgress (todoactivity) ","todoactivity",6,todoactivity.mostCurrent.activityBA,todoactivity.mostCurrent,564);
if (RapidSub.canDelegate("updateprogress")) { return b4a.example.todoactivity.remoteMe.runUserSub(false, "todoactivity","updateprogress");}
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _totaltasks = RemoteObject.createImmutable(0);
RemoteObject _donetasks = RemoteObject.createImmutable(0);
RemoteObject _percentagetasks = RemoteObject.createImmutable(0);
RemoteObject _task = RemoteObject.createImmutable("");
RemoteObject _checkedkey = RemoteObject.createImmutable("");
 BA.debugLineNum = 564;BA.debugLine="Sub updateProgress";
Debug.ShouldStop(524288);
 BA.debugLineNum = 566;BA.debugLine="If currentList = \"\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",todoactivity.mostCurrent._currentlist,BA.ObjectToString(""))) { 
 BA.debugLineNum = 567;BA.debugLine="progressNumber.Text = \"\"";
Debug.ShouldStop(4194304);
todoactivity.mostCurrent._progressnumber.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 568;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 571;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(67108864);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),todoactivity.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 572;BA.debugLine="If kvs.ContainsKey(key) = False Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",todoactivity._kvs.runMethod(true,"_containskey",(Object)(_key)),todoactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 573;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
Debug.ShouldStop(268435456);
todoactivity.mostCurrent._progressnumber.runMethod(true,"setText",BA.ObjectToCharSequence("0 / 0 tasks done!"));
 BA.debugLineNum = 574;BA.debugLine="progressPercent.Text = \"0%\"";
Debug.ShouldStop(536870912);
todoactivity.mostCurrent._progresspercent.runMethod(true,"setText",BA.ObjectToCharSequence("0%"));
 BA.debugLineNum = 575;BA.debugLine="progressBar.Progress = 0";
Debug.ShouldStop(1073741824);
todoactivity.mostCurrent._progressbar.runMethod(true,"setProgress",BA.numberCast(int.class, 0));
 BA.debugLineNum = 576;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 580;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
Debug.ShouldStop(8);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), todoactivity._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 581;BA.debugLine="Dim totalTasks As Int = savedTasks.Size";
Debug.ShouldStop(16);
_totaltasks = _savedtasks.runMethod(true,"getSize");Debug.locals.put("totalTasks", _totaltasks);Debug.locals.put("totalTasks", _totaltasks);
 BA.debugLineNum = 582;BA.debugLine="Dim doneTasks As Int = 0";
Debug.ShouldStop(32);
_donetasks = BA.numberCast(int.class, 0);Debug.locals.put("doneTasks", _donetasks);Debug.locals.put("doneTasks", _donetasks);
 BA.debugLineNum = 583;BA.debugLine="Dim percentageTasks As Int = 0";
Debug.ShouldStop(64);
_percentagetasks = BA.numberCast(int.class, 0);Debug.locals.put("percentageTasks", _percentagetasks);Debug.locals.put("percentageTasks", _percentagetasks);
 BA.debugLineNum = 585;BA.debugLine="For Each task As String In savedTasks";
Debug.ShouldStop(256);
{
final RemoteObject group16 = _savedtasks;
final int groupLen16 = group16.runMethod(true,"getSize").<Integer>get()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_task = BA.ObjectToString(group16.runMethod(false,"Get",index16));Debug.locals.put("task", _task);
Debug.locals.put("task", _task);
 BA.debugLineNum = 586;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentL";
Debug.ShouldStop(512);
_checkedkey = RemoteObject.concat(RemoteObject.createImmutable("checked_"),todoactivity.mostCurrent._currentlist,RemoteObject.createImmutable("_"),_task);Debug.locals.put("checkedKey", _checkedkey);Debug.locals.put("checkedKey", _checkedkey);
 BA.debugLineNum = 587;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
Debug.ShouldStop(1024);
if (todoactivity._kvs.runMethod(true,"_containskey",(Object)(_checkedkey)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 588;BA.debugLine="If kvs.Get(checkedKey) = True Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",todoactivity._kvs.runMethod(false,"_get",(Object)(_checkedkey)),(todoactivity.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 589;BA.debugLine="doneTasks = doneTasks + 1";
Debug.ShouldStop(4096);
_donetasks = RemoteObject.solve(new RemoteObject[] {_donetasks,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("doneTasks", _donetasks);
 };
 };
 }
}Debug.locals.put("task", _task);
;
 BA.debugLineNum = 594;BA.debugLine="percentageTasks = (doneTasks / totalTasks) * 100";
Debug.ShouldStop(131072);
_percentagetasks = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_donetasks,_totaltasks}, "/",0, 0)),RemoteObject.createImmutable(100)}, "*",0, 0));Debug.locals.put("percentageTasks", _percentagetasks);
 BA.debugLineNum = 596;BA.debugLine="progressNumber.Text = doneTasks & \" / \" & totalTa";
Debug.ShouldStop(524288);
todoactivity.mostCurrent._progressnumber.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_donetasks,RemoteObject.createImmutable(" / "),_totaltasks,RemoteObject.createImmutable(" tasks done!"))));
 BA.debugLineNum = 597;BA.debugLine="progressPercent.Text = percentageTasks & \"%\"";
Debug.ShouldStop(1048576);
todoactivity.mostCurrent._progresspercent.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_percentagetasks,RemoteObject.createImmutable("%"))));
 BA.debugLineNum = 598;BA.debugLine="progressBar.Progress = percentageTasks";
Debug.ShouldStop(2097152);
todoactivity.mostCurrent._progressbar.runMethod(true,"setProgress",_percentagetasks);
 BA.debugLineNum = 600;BA.debugLine="End Sub";
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