B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private menupanel As Panel
	Private Week_btn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("Layout2")
	Week_btn.Color = Colors.blue

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub menu_btn_Click
	menupanel.Visible =True
End Sub


Private Sub sched_btn_Click
	Activity.Finish
	StartActivity(Schedule_MODULE)
End Sub

Private Sub Day_btn_Click
	Dim currentyear As Int = DateTime.GetYear(DateTime.Now)
	Dim currentmonth As Int = DateTime.GetMonth(DateTime.Now)
	Dim currentday As Int = DateTime.GetDayOfMonth(DateTime.Now)
	Day_MODULE.currentDate = currentyear & "-" & currentmonth & "-" & currentday
	Activity.Finish
	StartActivity(Day_MODULE)
End Sub

Private Sub Week_btn_Click
	menupanel.visible = False
End Sub

Private Sub Month_btn_Click
	Activity.Finish
	StartActivity(Main)
End Sub