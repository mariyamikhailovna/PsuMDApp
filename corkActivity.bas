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
	Private R = 255, G = 105, B = 97 As Int
	Private R2, G2, B2 As Int
	Private penSpnr As Spinner
	Private Width As Int
	Private Height As Int
	Private deleteLbl As Label
	Dim ddn As DragDropView
	Dim ddi As DragDropView
	Dim ddc As DragDropView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("corkboardLayout")
	penSpnr.AddAll(Array As String("Black", "Blue", "Green", "Red", "Yellow", "Eraser"))
	If FirstTime Then
		imgPicker.Initialize("CC")
	End If
	penSpnr.Visible = False
	Width = 80dip
	Height = 60dip
	ddn.Initialize(Me, "NoteDrag")
	ddi.Initialize(Me, "ImgDrag")
	ddc.Initialize(Me, "CanvasDrag")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'THINGS TO ADD
'1. Sticky Notes
'2. Images
'3. Canvas

'----------------------MAIN SPAWNING/ADDINNG EVENTS---------------------------

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

	ddn.AddDragView(p, False)
	ddn.AddPlaceView(place1).AddPlaceView(place2).AddPlaceView(place3).AddPlaceView(place4).AddPlaceView(place5).AddPlaceView(place6).AddPlaceView(place7).AddPlaceView(place8).AddPlaceView(place9).AddPlaceView(place10).AddPlaceView(place11).AddPlaceView(place12).AddPlaceView(deleteLbl)
	
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
	boardPnl.AddView(imgView, 150dip, 500dip, 100dip, 100dip)

	ddi.AddDragView(imgView, False)
	ddi.AddPlaceView(place1).AddPlaceView(place2).AddPlaceView(place3).AddPlaceView(place4).AddPlaceView(place5).AddPlaceView(place6).AddPlaceView(place7).AddPlaceView(place8).AddPlaceView(place9).AddPlaceView(place10).AddPlaceView(place11).AddPlaceView(place12).AddPlaceView(deleteLbl)
	
End Sub

Sub AddCanvas(x As Int, y As Int)
	Dim f As Panel
	f.Initialize("CanvasFrame")
	f.Color = Colors.Black
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

	ddc.AddDragView(f, False)
	ddc.AddPlaceView(place1).AddPlaceView(place2).AddPlaceView(place3).AddPlaceView(place4).AddPlaceView(place5).AddPlaceView(place6).AddPlaceView(place7).AddPlaceView(place8).AddPlaceView(place9).AddPlaceView(place10).AddPlaceView(place11).AddPlaceView(place12).AddPlaceView(deleteLbl)
End Sub

Sub CanvasPanel_Touch (Action As Int, X As Float, Y As Float)
	Dim p As Panel = Sender
	Dim cvs As B4XCanvas = p.Tag
	Select Action
		Case Activity.ACTION_DOWN
			LastX = X
			LastY = Y
		Case Activity.ACTION_MOVE
			cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,G2,B2), 3dip)
			cvs.Invalidate
			LastX = X
			LastY = Y
	End Select
End Sub

'---------------PANELS/WINDOWS SPAWNED AND BUTTONS INSIDE IT------------------

Private Sub noteWindow(pW As Int, pH As Int)
	notePnl = xui.CreatePanel("notePnl")
	Activity.AddView(notePnl, 100dip, 225dip, pW, pH)
	notePnl.Color = xui.Color_RGB(50, 50, 50)
	notePnl.SetColorAndBorder(xui.Color_White, 2dip, xui.Color_Black, 3dip)

	Dim colorsSpnr As Spinner
	colorsSpnr.Initialize("colorsSpnr")
	colorsSpnr.AddAll(Array As String("Red", "Blue", "Yellow"))
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
	AddStickyNote("", 150dip, 500dip)
	notePnl.Visible = False
	R = 255
	G = 105
	B = 97
	stickyBtn.Enabled = True
End Sub

Private Sub addcBtn_Click
	AddCanvas(150dip, 500dip)
	canvasPnl.Visible = False
End Sub

'--------------------------MAIN ADDING BUTTONS--------------------------------

Private Sub stickyBtn_Click
	noteWindow(250dip, 180dip)
	notePnl.Visible = True
	stickyBtn.Enabled = False
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

'------------------------------SPINNERS---------------------------------------

Private Sub sizeSpnr_ItemClick (Position As Int, Value As Object)
	Select Position
		Case 0
			Width = 80dip
			Height = 60dip
		Case 1
			Width = 205dip
			Height = 60dip
		Case 2
			Width = 80dip
			Height = 185dip
		Case 3
			Width = 205dip
			Height = 185dip
		Case 4
			Width = 330dip
			Height = 185dip
		Case 5
			Width = 205dip
			Height = 310dip
	End Select
End Sub

Private Sub colorsSpnr_ItemClick (Position As Int, Value As Object)
	Select Position
		Case 0
			R = 255
			G = 105
			B = 97
		Case 1
			R = 155
			G = 190
			B = 237
		Case 2
			R = 248
			G = 241
			B = 174
	End Select
End Sub

Private Sub penSpnr_ItemClick (Position As Int, Value As Object)
	Select Position
		Case 0
			R2 = 0
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
			R2 = 255
			G2 = 0
			B2 = 0
		Case 4
			R2 = 255
			G2 = 255
			B2 = 0
		Case 5
			R2 = 255
			G2 = 255
			B2 = 255
	End Select
End Sub

'---------------------------DELETE FUNCTION-----------------------------------

Sub NoteDrag_PlacedView(DragView As B4XView, PlaceView As B4XView)
	If PlaceView = deleteLbl Then
		Msgbox2Async("Are you sure you want to delete note?", "Delete Note", "No", "", "Yes", Null, False)
		Wait For Msgbox_Result (res As Int)
		If res = DialogResponse.NEGATIVE Then
			DragView.Visible = False
			DragView = Null
			ToastMessageShow("Note Deleted", False)
		End If
	End If
End Sub

Sub ImgDrag_PlacedView(DragView As B4XView, PlaceView As B4XView)
	If PlaceView = deleteLbl Then
		Msgbox2Async("Are you sure you want to delete image?", "Delete Image", "No", "", "Yes", Null, False)
		Wait For Msgbox_Result (res As Int)
		If res = DialogResponse.NEGATIVE Then
			DragView.Visible = False
			DragView = Null
			ToastMessageShow("Image Deleted", False)
		End If
	End If
End Sub

Sub CanvasDrag_PlacedView(DragView As B4XView, PlaceView As B4XView)
	If PlaceView = deleteLbl Then
		Msgbox2Async("Are you sure you want to delete canvas?", "Delete Canvas", "No", "", "Yes", Null, False)
		Wait For Msgbox_Result (res As Int)
		If res = DialogResponse.NEGATIVE Then
			DragView.Visible = False
			DragView = Null
			ToastMessageShow("Canvas Deleted", False)
		End If
	End If
End Sub