
# ToolTipTextView

ToolTipTextView is an customzed textview where you can achieve tool tip and other functionalities without any hessle.


## Installation

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```gradle    
implementation 'libs.fahad.tooltiptextview:package:1.0.0'
```

## How to use

    <libs.fahad.tooltiptextview.ToolTipTextView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:fontFamily="@font/outfit_bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:title="First Name"
        app:titleColor="@color/teal_700"
        app:titleFontSize="12sp"
        app:toolTipBackgroundColor="#888585"
        app:toolTipImage="@drawable/ic_baseline_info_24"
        app:toolTipImageViewSize="18dp"
        app:toolTipText="First name be mateched with you CNIC name !"
        app:toolTipTextColor="#FFFFFF" />


## Screenshots

![App Screenshot ](https://github.com/profahad/toolTipTextView/blob/main/demo/Screenshot_1665934533.png?raw=true=600x200)


## Badges

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
