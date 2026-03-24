B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	Dim xui As XUI
	Private timerClock As Timer
	Public kvs As KeyValueStore
	Public format24h As Boolean = False
End Sub

Sub Globals
	Dim regLayout, darkModeLayout As B4XView 
	Dim size As Int = 100%y
	Private hsv As HorizontalScrollView
	Private computerGif As B4XGifView 
	Private dcomputerGif As B4XGifView
	Private clockBtn As Button
	Private clockLightBtn As Button
	Public kvs As KeyValueStore
	Private infoPnl As B4XView
	Private infoTitleLbl As Label
	Private infoDescLbl As Label
	Private infoPageLbl As Label
	Dim infoPage As Int = 0
End Sub

Sub Activity_Create(FirstTime As Boolean)

	Activity.LoadLayout("Layouthsv")

	If FirstTime Then
		kvs.Initialize(File.DirInternal, "notes_data")
		timerClock.Initialize("timerClock", 1000)
		timerClock.Enabled = True
	End If
	
	hsv.Panel.Width = size
	hsv.Panel.Height = size

	regLayout = xui.CreatePanel("")
	darkModeLayout = xui.CreatePanel("")

	hsv.Panel.AddView(regLayout, 0, 0, hsv.Panel.Width, hsv.Panel.Height)
	hsv.Panel.AddView(darkModeLayout, 0, 0, hsv.Panel.Width, hsv.Panel.Height)
	
	regLayout.BringToFront
	
	Select Starter.themeNumber
		Case 0
			regLayout.LoadLayout("Layout") 'light mode for theme 1
			darkModeLayout.LoadLayout("Layout2") 'dark mode for theme 1
		Case 1
			regLayout.LoadLayout("Layout") 'light mode for theme 2, not yet made
			darkModeLayout.LoadLayout("Layout2") 'dark mode for theme 2, not yet made
	End Select
	
	computerGif.SetGif(File.DirAssets, "BtnComputer.GIF")
	dcomputerGif.SetGif(File.DirAssets, "Dark BtnComputer.GIF")
	darkModeLayout.Visible = False
	
	Sleep(50)
	hsv.ScrollPosition = Max(0, (hsv.Panel.Width - 100%x) / 2)
	
End Sub

Sub Activity_Resume
	If format24h Then
		DateTime.TimeFormat = "HH:mm" ' 24-Hour Format
	Else
		DateTime.TimeFormat = "hh:mm a" ' AM/PM Format
	End If
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

Sub timerClock_Tick
	clockBtn.Text = DateTime.Time(DateTime.Now)
	clockLightBtn.Text = DateTime.Time(DateTime.Now)
End Sub

Private Sub clockBtn_Click
	StartActivity(clockActivity)
End Sub

Private Sub  clockLightBtn_Click
	StartActivity(clockActivity)
End Sub

Private Sub clockBtn_LongClick
	'there should be a pop-up panel saying that this is the pomodoro feature, etc.
	showInfoPopup
	If infoPnl <> Null Then
		infoPnl.Visible = True
		infoPnl.BringToFront
		showInfoPage(0)
		Return
	End If
End Sub
Private Sub clockLightBtn_LongClick
	'there should be a pop-up panel saying that this is the pomodoro feature, etc.
	showInfoPopup
	If infoPnl <> Null Then
		infoPnl.Visible = True
		infoPnl.BringToFront
		showInfoPage(0)
		Return
	End If
End Sub

Private Sub navBtn_Click
	StartActivity(navActivity)
End Sub

Private Sub helpBtn_Click
	StartActivity(helpActivity)
End Sub

Private Sub showInfoPopup
	

	infoPnl = xui.CreatePanel("infoPnl")
	Activity.AddView(infoPnl, 75dip, 225dip, 300dip, 220dip)
	infoPnl.SetColorAndBorder(xui.Color_White, 2dip, xui.Color_Black, 3dip)

	Dim closeBtn As Button
	closeBtn.Initialize("infoPnlClose")
	closeBtn.Text = "X"
	closeBtn.TextSize = 8
	infoPnl.AddView(closeBtn, 265dip, 8dip, 28dip, 28dip)

	infoTitleLbl.Initialize("")
	infoTitleLbl.TextSize = 16
	infoTitleLbl.Gravity = Gravity.CENTER_HORIZONTAL
	infoPnl.AddView(infoTitleLbl, 10dip, 12dip, 248dip, 30dip)

	infoDescLbl.Initialize("")
	infoDescLbl.TextSize = 13
	infoDescLbl.Gravity = Gravity.TOP
	infoDescLbl.SingleLine = False
	infoPnl.AddView(infoDescLbl, 12dip, 52dip, 276dip, 110dip)

	infoPageLbl.Initialize("")
	infoPageLbl.Gravity = Gravity.CENTER_HORIZONTAL
	infoPageLbl.TextSize = 11
	infoPnl.AddView(infoPageLbl, 95dip, 184dip, 110dip, 22dip)


	showInfoPage(0)
End Sub

Private Sub showInfoPage(page As Int)
	infoPage = page
	Select page
		Case 0
			infoTitleLbl.Text = "func 1"
			infoDescLbl.Text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas lacinia nisi eu risus sollicitudin, in mattis velit laoreet. Quisque iaculis elit sit amet ex fermentum, at vehicula odio rutrum."
		Case 1
			infoTitleLbl.Text = "func 2"
			infoDescLbl.Text = "Aenean blandit a lorem ut laoreet. Sed gravida turpis sed dui porttitor porta. Donec vel mi id neque pretium varius vitae sed eros. Nullam gravida rhoncus fringilla."
		Case 2
			infoTitleLbl.Text = "func 3"
			infoDescLbl.Text = "Sed eget facilisis purus, sed porta justo. Aliquam vitae lorem semper, pharetra enim a, tincidunt urna. Sed egestas felis non metus interdum, sit amet ornare dui tempor."
		Case 3
			infoTitleLbl.Text = "func 4"
			infoDescLbl.Text = "Proin volutpat turpis at lorem commodo sollicitudin. Aenean eget ullamcorper ex, non scelerisque arcu. Duis sed vestibulum lacus, vel fringilla sapien. Quisque feugiat dui sit amet magna placerat convallis."
	End Select
End Sub

Private Sub infoPnlClose_Click
	infoPnl.Visible = False
End Sub
