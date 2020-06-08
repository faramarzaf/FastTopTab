# FastTopTab

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```gradle
dependencies {
	        implementation 'com.github.faramarzaf:FastTopTab:1.0.1'
	}
```

**In your xml**

```xml

 <com.faramarz.material.en.FastTopTab.PresetRadioGroup
        android:id="@+id/preset_radio_group"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:orientation="horizontal"
        android:weightSum="3"
        app:ftt_RadioCheckedId="@+id/tab1">

        <com.faramarz.material.en.FastTopTab.FTTTab
            android:id="@+id/tab1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:background="@drawable/background_selector_preset_button"
            android:clickable="true"
            android:gravity="center"
            android:padding="10dp"
            app:ftt_ButtonPressedTextColor="#675"
            app:ftt_ButtonValueText="text"
            app:ftt_ButtonValueTextColor="#AD6813"
            app:ftt_SelectedTabColor="@color/colorAccent"
            app:ftt_StrokeColor="#241"
            app:ftt_StrokeWidth="2" />

        <com.faramarz.material.en.FastTopTab.FTTTab
            android:id="@+id/tab2"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:background="@drawable/background_selector_preset_button"
            android:clickable="true"
            android:gravity="center"
            android:padding="10dp"
            app:ftt_ButtonPressedTextColor="#675"
            app:ftt_ButtonValueText="text"
            app:ftt_ButtonValueTextColor="#AD6813"
            app:ftt_SelectedTabColor="@color/colorAccent"
            app:ftt_StrokeColor="#241"
            app:ftt_StrokeWidth="2" />

        <com.faramarz.material.en.FastTopTab.FTTTab
            android:id="@+id/tab3"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:background="@drawable/background_selector_preset_button"
            android:clickable="true"
            android:gravity="center"
            android:padding="10dp"
            app:ftt_ButtonPressedTextColor="#675"
            app:ftt_ButtonValueText="text"
            app:ftt_ButtonValueTextColor="#AD6813"
            app:ftt_SelectedTabColor="@color/colorAccent"
            app:ftt_StrokeColor="#241"
            app:ftt_StrokeWidth="2" />

    </com.faramarz.material.en.FastTopTab.PresetRadioGroup>

```

**Java usage**

```java
    PresetRadioGroup presetRadioGroup;
 	presetRadioGroup = findViewById(R.id.preset_radio_group);
		
		presetRadioGroup.setOnCheckedChangeListener(new PresetRadioGroup.OnCheckedChangeListener() {
            		 @Override
            		 public void onCheckedChanged(View radioGroup, View radioButton, boolean isChecked, int checkedId) {
               		 String checked = ((FTTTab) radioButton).getValue();
                	 Toast.makeText(MainActivity.this, checked, Toast.LENGTH_SHORT).show();
            }
        });
	
```
