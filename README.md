# ContourPlot
Library Android for generate contour plot 2D

This source code is a modification from [here](https://github.com/piotrdzwiniel/Contour2DPlot).

## Installation

Add the JitPack repository to your build file
```bash
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```bash
dependencies {
    implementation 'com.github.nanangmaxfi:ContourPlot:1.0.0'
}
```

Use gradle, maven or many others. Full instalation you can access [install](https://jitpack.io/#nanangmaxfi/ContourPlot/1.0.0)

## Usage

```java
ImageView imageView = findViewById(R.id.imageView);
double[][] data = {
                    {...,...},
                    {...,...}
                  };
double width = 600;
double height = 600;
Bitmap bitmap = Bitmap.createBitmap((int)width,(int)height, Bitmap.Config.ARGB_8888);

Contour2DMap contour2DMap = new Contour2DMap(bitmap,width,height);
contour2DMap.setData(data);
contour2DMap.setIsoFactor(0.1);
contour2DMap.setInterpolationFactor(3);
contour2DMap.setMapColorScale(ColorScale.COLOR);
contour2DMap.draw(imageView);
```
