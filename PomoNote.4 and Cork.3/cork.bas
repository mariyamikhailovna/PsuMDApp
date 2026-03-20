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
	Private imgPicker As ContentChooser
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private boardPnl As Panel
	Private addPnl As Panel
	Private canvaBtn As Button
	Private imgBtn As Button
	Private imgView As ImageView
	Private stickyBtn As Button
	Private stringBtn As Button
	Private stickyTxt As  EditText
	Private LastX, LastY As Float
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("corkboardLayout")
	
	If FirstTime Then
		imgPicker.Initialize("CC")
	End If

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'THINGS TO ADD
'1. Sticky Notes
'2. Images
'3. Canvas
'4. String (gian)
'5. Being able to hide add buttons (gian)

Sub Generic_Touch (Action As Int, X As Float, Y As Float)
    Dim v As View = Sender
    
    Select Action
        Case Activity.ACTION_DOWN
            LastX = X
            LastY = Y
            
            
        Case Activity.ACTION_MOVE
            ' 1. Calculate the shift
            Dim deltaX As Float = X - LastX
            Dim deltaY As Float = Y - LastY
            
            ' 2. Apply the shift to the view
            v.Left = v.Left + deltaX
            v.Top = v.Top + deltaY
            
            ' 3. CRITICAL: Update the last position to the CURRENT position
            ' If you don't do this, the math breaks on the next millisecond of movement
            LastX = X 
            LastY = Y
			v.BringToFront
    End Select
End Sub

Sub AddStickyNote(Text As String, x As Int, y As Int)
	Dim p As Panel
	p.Initialize("Generic")
	p.Color = Colors.RGB(255, 192, 203)

	stickyTxt.Initialize("stickyTxt") 
	stickyTxt.Text = Text
	stickyTxt.TextSize = 9
	stickyTxt.Background = Null
	stickyTxt.TextColor = Colors.Black
	stickyTxt.Gravity = Gravity.TOP
	
	p.AddView(stickyTxt, 5dip, 15dip, 90dip, 70dip)
	
	boardPnl.AddView(p, x, y, 100dip, 100dip)
    
End Sub

Sub CC_Result (Success As Boolean, Dir As String, FileName As String)
	If Success Then
		imgView.Bitmap = LoadBitmapResize(Dir, FileName, imgView.Width, imgView.Height, True)
	Else
		ToastMessageShow("No image selected", False)
	End If
End Sub

Sub imgPick
	imgView.Initialize("Generic")
	Dim randomX As Int = Rnd(20dip, 300dip)
	Dim randomY As Int = Rnd(20dip, 500dip)
	Activity.AddView(imgView, randomX, randomY, 100dip, 100dip)
End Sub

Sub AddCanvas(x As Int, y As Int, Width As Int, Height As Int)
	Dim p As Panel
	p.Initialize("CanvasPanel")
	p.Color = Colors.White
	boardPnl.AddView(p, x, y, Width, Height)
	
	Dim cvs As B4XCanvas
	cvs.Initialize(p)
	cvs.DrawRect(cvs.TargetRect, Colors.LightGray, False, 1dip)
	cvs.Invalidate

	p.Tag = cvs
End Sub

Sub CanvasPanel_Touch (Action As Int, X As Float, Y As Float)
	Dim p As Panel = Sender
	' Retrieve the Canvas associated with THIS specific panel
	Dim cvs As B4XCanvas = p.Tag
	Select Action
		Case Activity.ACTION_DOWN
			LastX = X
			LastY = Y
		Case Activity.ACTION_MOVE
			' Draw a line from where the finger was to where it is now
			cvs.DrawLine(LastX, LastY, X, Y, Colors.Black, 3dip)
			cvs.Invalidate ' This refresh is required to show the drawing
			LastX = X
			LastY = Y
	End Select
End Sub

Private Sub stickyBtn_Click
	Dim randomX As Int = Rnd(20dip, 300dip)
	Dim randomY As Int = Rnd(20dip, 500dip)
	AddStickyNote("", randomX, randomY)
End Sub

Private Sub imgBtn_Click
	imgPicker.Show("image/*", "Select a Photo")
	imgPick
End Sub

Private Sub canvaBtn_Click
	Dim randomX As Int = Rnd(10dip, 150dip)
	Dim randomY As Int = Rnd(100dip, 300dip)
	AddCanvas(randomX, randomY, 200dip, 200dip)
End Sub
