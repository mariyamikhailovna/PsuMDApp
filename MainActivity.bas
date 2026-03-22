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
	Dim size As Int = 100%y
	Private hsv As HorizontalScrollView
	Private computerGif As B4XGifView 
	Private dcomputerGif As B4XGifView
End Sub

Sub Activity_Create(FirstTime As Boolean)

	Activity.LoadLayout("Layouthsv")

	hsv.Panel.Width = size
	hsv.Panel.Height = size

	regLayout = xui.CreatePanel("")
	darkModeLayout = xui.CreatePanel("")

	hsv.Panel.AddView(regLayout, 0, 0, hsv.Panel.Width, hsv.Panel.Height)
	hsv.Panel.AddView(darkModeLayout, 0, 0, hsv.Panel.Width, hsv.Panel.Height)
	
	regLayout.BringToFront

	regLayout.LoadLayout("Layout")      'light mode
	darkModeLayout.LoadLayout("Layout2") 'dark mode

	computerGif.SetGif(File.DirAssets, "BtnComputer.GIF")
	dcomputerGif.SetGif(File.DirAssets, "Dark BtnComputer.GIF")
	darkModeLayout.Visible = False
	
	Sleep(50)
	hsv.ScrollPosition = Max(0, (hsv.Panel.Width - 100%x) / 2)
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lamp_Click
	Starter.darkMode = True
	darkModeLayout.Visible = True
	darkModeLayout.BringToFront
	darkModeLayout.Alpha = 0
	darkModeLayout.SetAlphaAnimated(250, 1)
	regLayout.SetAlphaAnimated(250, 0)
	Sleep(250)
	regLayout.Visible = False
End Sub

Private Sub dlamp_Click
	Starter.darkMode = False
	regLayout.Visible = True
	regLayout.BringToFront
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