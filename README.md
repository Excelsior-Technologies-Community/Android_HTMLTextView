## Android HTMLTextView
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![API](https://img.shields.io/badge/API-24%2B-orange)](#)
---

A lightweight and customizable HTML rendering TextView for Android, written in Kotlin.
It extends TextView to safely render HTML content with support for links, images, styling, and custom attributes.

### Features

- Render HTML text using Html.fromHtml
- Clickable links with custom click handling
- <img> tag support using Glide
- Custom text color and link color
- Custom text size from XML
- Works with both XML and Kotlin

---

## Installation (JitPack)

### 1️⃣ Add JitPack to your **root `settings.gradle` or `build.gradle`**

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### Add Dependency
```
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_BalloonPopup:1.0.0'
	}
```

---


### Usage

**XML Usage (Static HTML)**
```xml
<com.ext.htmltextview.HtmlTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:htmlText="@string/sample_html"
    app:htmlTextColor="@color/black"
    app:linkColor="@color/purple_500"
    app:htmlTextSize="16sp" />
```

**Kotlin Usage (Dynamic HTML)**
```kotlin
val htmlView = findViewById<HtmlTextView>(R.id.htmlView)

htmlView.setHtml(
    """
    <h2>Hello</h2>
    <p>This is <b>HTML</b> text</p>
    <img src="https://via.placeholder.com/300" />
    <a href="https://google.com">Google</a>
    """.trimIndent()
)
```

**Link Click Handling**

You can intercept link clicks instead of opening the browser automatically.
```kotlin
htmlView.setOnLinkClickListener(object : OnLinkClickListener {
    override fun onLinkClick(url: String): Boolean {
        Toast.makeText(this@MainActivity, url, Toast.LENGTH_SHORT).show()
        return true // consume click
    }
})
```


### Custom XML Attributes

| Attribute Name  | Type        | Description                       | Example Value         |
| --------------- | ----------- | --------------------------------- | --------------------- |
| `htmlText`      | `string`    | HTML content to render            | `@string/sample_html` |
| `htmlTextColor` | `color`     | Color for normal text             | `@color/black`        |
| `linkColor`     | `color`     | Color for clickable links (`<a>`) | `@color/purple_500`   |
| `htmlTextSize`  | `dimension` | Text size for rendered HTML       | `16sp`                |

---

### Supported HTML Tags

| Category           | HTML Tag(s)            | Description                          |
|--------------------|------------------------|--------------------------------------|
| Text formatting    | `<b>`, `<strong>`      | Bold text                            |
| Text formatting    | `<i>`, `<em>`          | Italic text                          |
| Text formatting    | `<u>`                  | Underlined text                     |
| Paragraph & break  | `<p>`, `<br>`          | Paragraphs and line breaks          |
| Lists              | `<ul>`, `<li>`         | Unordered lists                     |
| Links              | `<a href="">`          | Clickable hyperlinks                |
| Images             | `<img src="">`         | Inline images (loaded via Glide)    |

---

### License

```
MIT License

Copyright (c) 2025 Excelsior Technologies 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

