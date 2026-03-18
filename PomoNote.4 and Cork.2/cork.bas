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
	Private LastX, LastY As Float
	Private boardPnl As Panel
	Private addPnl As Panel
	Private canvaBtn As Button
	Private imgBtn As Button
	Private stickyBtn As Button
	Private stringBtn As Button
	Private stickyTxt As  EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("corkboardLayout")
	boardPnl.Width = Activity.Width
	boardPnl.Height = Activity.Height

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'THINGS TO ADD
'1. Sticky Notes
'2. Images
'3. Canvas
'4. String
'5. Being able to hide add buttons

Sub AddStickyNote(Text As String, x As Int, y As Int)
	Dim p As Panel
	p.Initialize("Sticky")
	p.Color = Colors.RGB(255, 192, 203)
    
	Dim dragHandle As Panel
	dragHandle.Initialize("Sticky")
	dragHandle.Color = Colors.RGB(0, 0, 0)
	p.AddView(dragHandle, 0, 0, 100dip, 20dip)
	
	stickyTxt.Initialize("stickyTxt")
	stickyTxt.Text = Text
	stickyTxt.TextSize = 9
	stickyTxt.Background = Null
	stickyTxt.Gravity = Gravity.TOP
	
	p.AddView(stickyTxt, 5dip, 15dip, 90dip, 70dip)
	
	boardPnl.AddView(p, x, y, 100dip, 100dip)
    
	Log("Note Added. Is it enabled? " & p.Enabled)
End Sub

Sub Sticky_Touch (Action As Int, X As Float, Y As Float)
	Dim v As B4XView = Sender
    
	Select Action
		Case 0 ' Action_Down
			LastX = X
			LastY = Y
			v.BringToFront
            
		Case 2 ' Action_Move
			' Now LastX and LastY are recognized and contain
			' the values set during Action_Down
			v.Left = v.Left + X - LastX
			v.Top = v.Top + Y - LastY
	End Select
End Sub



Private Sub stickyBtn_Click
	' Generates a random position so they don't stack perfectly
	Dim randomX As Int = Rnd(20dip, 150dip)
	Dim randomY As Int = Rnd(20dip, 150dip)
	AddStickyNote("", randomX, randomY)
End Sub