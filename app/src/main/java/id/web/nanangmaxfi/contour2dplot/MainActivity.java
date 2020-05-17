package id.web.nanangmaxfi.contour2dplot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import id.web.nanangmaxfi.contour2dplot.plot.ColorScale;
import id.web.nanangmaxfi.contour2dplot.plot.Contour2DMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView drawImageView;
    private TextView txtHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawImageView = findViewById(R.id.drawImageView);
        txtHello = findViewById(R.id.txt_hello);
        Bitmap bitmap = Bitmap.createBitmap(600,600, Bitmap.Config.ARGB_8888);


        Contour2DMap contour2DMap = new Contour2DMap(bitmap,600,600);
        double[][] data = {
                                {-1,-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1},
                                {-1,-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1},
                                {-1,-1,	-1,	-1,	1.08,0.0,2.32,-1,3.63,-1,0.0,-1},
                {-1,0.0,0.48,-1,7.52,2.32,2.95,	5.35,10.48,	6.46,5.35,3.63},
                {4.52,2.95,7.52,2.32,10.48,10.48,10.48,10.48,10.48,	10.48,6.46,	4.52},
                {6.46,	9.0,	9.0,	9.0	,10.48,	10.48,	10.48	,9.0,	9.0,	7.52,	4.52	,3.63},
                {6.46,	7.52,	5.35,	9.0	,9.0,10.48	,10.48,	9.0,	10.48,	4.52,	4.52,	0.0},
                {5.35	,7.52,	5.35	,7.52	,7.52,7.52,	5.35,	2.95,	4.52	,3.63,	5.35,3.63}
                            };
        contour2DMap.setData(data);
        contour2DMap.setIsoFactor(0.1);
        contour2DMap.setInterpolationFactor(3);
        contour2DMap.setMapColorScale(ColorScale.COLOR);
        contour2DMap.draw(drawImageView);
       //txtHello.setText(String.valueOf(data.length));

//        IsoCell isoCell = new IsoCell(bitmap,80,80);
//        Paint paint = new Paint();
//        paint.setColor(Color.HSVToColor(new float[]{100, 1.0f, 1.0f}));
//        paint.setStrokeWidth(2);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        isoCell.drawIsoBand(42,paint);
//
//
//        IsoCell isoCell2 = new IsoCell(bitmap,80,80);
//        Paint paint2 = new Paint();
//        paint2.setColor(Color.HSVToColor(new float[]{40, 1.0f, 1.0f}));
//        paint2.setStrokeWidth(2);
//        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
//        isoCell.drawIsoBand(26,paint2);
//        drawImageView.setImageBitmap(bitmap);

//        Canvas canvas = new Canvas(bitmap);
//
//        Path path = new Path();
//        path.moveTo(10,10);
//        path.lineTo(20,200);
//        path.lineTo(100,200);
//
//        Paint paint = new Paint();
//        paint.setColor(Color.HSVToColor(new float[]{100, 1.0f, 1.0f}));
//        paint.setStrokeWidth(2);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//
//        canvas.drawPath(path,paint);
//
//        Canvas canvas2 = new Canvas(bitmap);
//
//        Paint paint2 = new Paint();
//        paint2.setColor(Color.BLUE);
//        paint2.setStrokeWidth(5);
//        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
//
//        Path path2 = new Path();
//        path2.moveTo(80,60);
//        path2.lineTo(100,300);
//        path2.lineTo(50,150);
//        canvas2.drawPath(path2,paint2);
//
//        drawImageView.setImageBitmap(bitmap);
    }

}
