# textinputedittext
**Preview**

![home_screen](https://user-images.githubusercontent.com/42700838/93781703-493f8a80-fc47-11ea-86da-4cbf4753e772.png)

****Gradle Dependency****

```
dependencies { implementation 'com.github.thekundankamal:textinputedittext:1.0' }
```
****Usage****

XML

```
 <com.thekundankamal.textinputlibrary.TextInputEditText
        android:layout_margin="10dp"
        android:id="@+id/input_data"
        custome:titleText="Title"
        custome:hintText="Enter your value"
        custome:titleTextSize="4sp"
        custome:textSize="6sp"
        custome:borderColor="@color/strokeColor"
        custome:titleColor="@color/colorPrimaryDark"
        custome:hintColor="@color/colorAccent"
        custome:textColor="@color/colorPrimary"
        custome:borderWidth="10"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```
Java

**SET TEXT** 

`        edInputText.setText("Welcome ");
`

**TITLE TXT**

`    edInputText.setTitleText("Header");
`

**HINT TEXT**

`        edInputText.setHintText("Enter your value");
`

`
