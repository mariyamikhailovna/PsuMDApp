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
	Dim xui As XUI
End Sub

Sub Globals
	Dim regLayout, darkModeLayout As B4XView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	regLayout = xui.CreatePanel("")
	darkModeLayout = xui.CreatePanel("")
	
	Activity.AddView(darkModeLayout, 0, 0, 100%x, 100%y)
	Activity.AddView(regLayout, 0, 0, 100%x, 100%y)
	
	regLayout.LoadLayout("Layout")
	darkModeLayout.LoadLayout("Layout2")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lamp_Click
	Starter.darkMode = True
	darkModeLayout.Visible = True
	darkModeLayout.Alpha = 0
	darkModeLayout.SetAlphaAnimated(250, 1)
	regLayout.SetAlphaAnimated(250, 0)
	Sleep(250)
	regLayout.Visible = False
End Sub

Private Sub dlamp_Click
	Starter.darkMode = False
	regLayout.Visible = True
	regLayout.Alpha = 0
	regLayout.SetAlphaAnimated(250, 1)
	darkModeLayout.SetAlphaAnimated(250, 0)
	Sleep(250)
	darkModeLayout.Visible = False
End Sub



Private Sub clockBtn_Click
	StartActivity(clockActivity)
End Sub

Private Sub clockBtn_LongClick
	'there should be a pop-up panel saying that this is the pomodoro feature, etc.
End Sub

Private Sub navBtn_Click
	StartActivity(navActivity)
End Sub

Private Sub helpBtn_Click
	StartActivity(helpActivity)
End Sub