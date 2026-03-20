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
	Private xui As XUI
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
	Private notePnl As B4XView
	Private canvasPnl As B4XView
	Private LastX, LastY As Float
	Private DragManager As DragDropView
	Private place1 As Label
	Private place2 As Label
	Private place3 As Label
	Private place4 As Label
	Private place5 As Label
	Private place6 As Label
	Private place7 As Label
	Private place8 As Label
	Private place9 As Label
	Private place10 As Label
	Private place11 As Label
	Private place12 As Label
	Private R, G, B As Int
	Private R2, G2, B2 As Int
	Private penSpnr As Spinner
	Private Width As Int
	Private Height As Int
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("corkboardLayout")
	penSpnr.AddAll(Array As String("Red", "Blue", "Green", "Black", "Yellow", "Eraser"))
	If FirstTime Then
		imgPicker.Initialize("CC")
	End If
	penSpnr.Visible = False
	Width = 100dip  ' Default starting width
	Height = 100dip ' Default starting height
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'THINGS TO ADD
'1. Sticky Notes
'2. Images
'3. Canvas

Sub AddStickyNote(Text As String, x As Int, y As Int)
	Dim p As Panel
	p.Initialize("NotePanel")
	p.Color = Colors.RGB(R, G, B)

	Dim txt As EditText
	txt.Initialize("")
	txt.Text = Text
	txt.TextSize = 12
	txt.Background = Null
	txt.TextColor = Colors.Black
	txt.Gravity = Gravity.TOP
	
	p.AddView(txt, 5dip, 15dip, 90dip, 70dip)
	
	boardPnl.AddView(p, x, y, 100dip, 100dip)
	
	Dim dd As DragDropView
	dd.Initialize(Me, "NoteDrag")
	dd.AddDragView(p, False)
	dd.AddPlaceView(place1).AddPlaceView(place2).AddPlaceView(place3).AddPlaceView(place4).AddPlaceView(place5).AddPlaceView(place6).AddPlaceView(place7).AddPlaceView(place8).AddPlaceView(place9).AddPlaceView(place10).AddPlaceView(place11).AddPlaceView(place12)
End Sub

Sub CC_Result (Success As Boolean, Dir As String, FileName As String)
	If Success Then
		imgView.Bitmap = LoadBitmapResize(Dir, FileName, imgView.Width, imgView.Height, True)
	Else
		ToastMessageShow("No image selected", False)
	End If
End Sub

Sub imgPick
	imgView.Initialize("ImgView")
	Dim randomX As Int = Rnd(20dip, 300dip)
	Dim randomY As Int = Rnd(20dip, 500dip)
	boardPnl.AddView(imgView, randomX, randomY, 100dip, 100dip)
	
	Dim dd As DragDropView
	dd.Initialize(Me, "ImgDrag")
	dd.AddDragView(imgView, False)
	dd.AddPlaceView(place1).AddPlaceView(place2).AddPlaceView(place3).AddPlaceView(place4).AddPlaceView(place5).AddPlaceView(place6).AddPlaceView(place7).AddPlaceView(place8).AddPlaceView(place9)
	
End Sub

Sub AddCanvas(x As Int, y As Int)
	Dim f As Panel
	f.Initialize("CanvasFrame")
	f.Color = Colors.Gray
	boardPnl.AddView(f, x, y, Width + 20dip, Height + 40dip)
	
	Dim p As Panel
	p.Initialize("CanvasPanel")
	p.Color = Colors.White
	f.AddView(p, 10dip, 20dip, Width, Height)
	
	Sleep(0)
	
	Dim cvs As B4XCanvas
	cvs.Initialize(p)
	cvs.DrawRect(cvs.TargetRect, Colors.LightGray, False, 1dip)
	cvs.Invalidate
	p.Tag = cvs
	
	Dim dd As DragDropView
	dd.Initialize(Me, "CanvasDrag")
	dd.AddDragView(f, False)
	dd.AddPlaceView(place1).AddPlaceView(place2).AddPlaceView(place3).AddPlaceView(place4).AddPlaceView(place5).AddPlaceView(place6).AddPlaceView(place7).AddPlaceView(place8).AddPlaceView(place9).AddPlaceView(place10).AddPlaceView(place11).AddPlaceView(place12)
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
			cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,G2,B2), 3dip)
			cvs.Invalidate ' This refresh is required to show the drawing
			LastX = X
			LastY = Y
	End Select
End Sub

Private Sub stickyBtn_Click
	noteWindow(250dip, 180dip)
	notePnl.Visible = True
End Sub

Private Sub noteWindow(pW As Int, pH As Int)
	notePnl = xui.CreatePanel("notePnl")
	Activity.AddView(notePnl, 100dip, 225dip, pW, pH)
	notePnl.Color = xui.Color_RGB(50, 50, 50)
	notePnl.SetColorAndBorder(xui.Color_White, 2dip, xui.Color_Black, 3dip)

	Dim colorsSpnr As Spinner
	colorsSpnr.Initialize("colorsSpnr")
	colorsSpnr.AddAll(Array As String("Red", "Blue", "Green"))
	notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20dip, 40dip)
	
	Dim addnBtn As Button
	addnBtn.Initialize("addnBtn")
	addnBtn.Text = "Add Note"
	notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) - 15dip, 50dip)
	
	notePnl.Enabled = False
	notePnl.Visible = False
End Sub

Private Sub canvasWindow(pW As Int, pH As Int)
	canvasPnl = xui.CreatePanel("canvasPanel")
	Activity.AddView(canvasPnl, 100dip, 225dip, pW, pH)
	canvasPnl.Color = xui.Color_RGB(50, 50, 50)
	canvasPnl.SetColorAndBorder(xui.Color_White, 2dip, xui.Color_Black, 3dip)

	Dim sizeSpnr As Spinner
	sizeSpnr.Initialize("sizeSpnr")
	sizeSpnr.AddAll(Array As String("1x1", "2x1", "1x2", "2x2", "3x2", "2x3"))
	canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20dip, 40dip)
	
	Dim addcBtn As Button
	addcBtn.Initialize("addcBtn")
	addcBtn.Text = "Add Canvas"
	canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2) - 15dip, 50dip)
	
	canvasPnl.Enabled = False
	canvasPnl.Visible = False
End Sub

Private Sub addnBtn_Click
	Dim randomX As Int = Rnd(20dip, 300dip)
	Dim randomY As Int = Rnd(20dip, 500dip)
	AddStickyNote("", randomX, randomY)
	notePnl.Visible = False
	R = 255
	G = 0
	B = 0
End Sub

Private Sub addcBtn_Click
	Dim randomX As Int = Rnd(20dip, 300dip)
	Dim randomY As Int = Rnd(20dip, 500dip)
	AddCanvas(randomX, randomY)
	canvasPnl.Visible = False
End Sub

Private Sub imgBtn_Click
	imgPicker.Show("image/*", "Select a Photo")
	imgPick
End Sub

Private Sub canvaBtn_Click
	canvasWindow(250dip, 180dip)
	canvasPnl.Visible = True
	penSpnr.Visible = True
End Sub

Private Sub sizeSpnr_ItemClick (Position As Int, Value As Object)
	Select Position
		Case 0
			Width = 100dip
			Height = 100dip
		Case 1
			Width = 200dip
			Height = 200dip
		Case 2
			Width = 100dip
			Height = 100dip
		Case 3
			Width = 100dip
			Height = 100dip
		Case 4
			Width = 100dip
			Height = 100dip
		Case 5
			Width = 100dip
			Height = 100dip
	End Select
End Sub

Private Sub colorsSpnr_ItemClick (Position As Int, Value As Object)
	Select Position
		Case 0 
			R = 255
			G = 0
			B = 0
		Case 1
			R = 0
			G = 0
			B = 255
		Case 2
			R = 0
			G = 255
			B = 0
	End Select
End Sub

Private Sub penSpnr_ItemClick (Position As Int, Value As Object)
	Select Position
		Case 0 
			R2 = 255
			G2 = 0
			B2 = 0
		Case 1
			R2 = 0
			G2 = 0
			B2 = 255
		Case 2
			R2 = 0
			G2 = 255
			B2 = 0
		Case 3
			R2 = 0
			G2 = 0
			B2 = 0
		Case 4
			R2 = 255
			G2 = 255
			B2 = 0
		Case 5
			R2 = 255
			G2 = 255
			B2 = 0
	End Select
End Sub