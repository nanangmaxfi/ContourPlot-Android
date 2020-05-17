package id.web.nanangmaxfi.contourplot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class IsoCell {
        private float cellSizeX;
        private float cellSizeY;
        private int ternaryIndexOfAverageOfCorners;
        private Bitmap bitmap;
        private static final float INIT_2 = 0.2f;
        private static final float INIT_4 = 0.4f;
        private static final float INIT_6 = 0.6f;
        private static final float INIT_8 = 0.8f;
        private float positionX;
        private float positionY;

        public IsoCell(Bitmap bitmap, double cellSizeX, double cellSizeY) {
            super();

            this.cellSizeX = (float)cellSizeX;
            this.cellSizeY =  (float)cellSizeY;
            this.bitmap = bitmap;
        }

        public void setPosition(float positionX, float positionY){
            this.positionX = positionX;
            this.positionY = positionY;
        }

        public void drawIsoBand(int ternaryIndex, Paint isoColor) {
            Canvas canvas = new Canvas(bitmap);
            Path path = new Path();

            Canvas additionalCanvas = new Canvas(bitmap);
            Path additionalPath = new Path();

            float ax, ay, bx, by, cx, cy, dx, dy, ex, ey, fx, fy, gx, gy, hx, hy;

            switch (ternaryIndex) {
                case 1:
                    // Single triangle 0001.
                    ax = 0;
                    ay = cellSizeY;

                    bx = (cellSizeX * INIT_6);
                    by = cellSizeY;

                    cx = 0;
                    cy = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 2:
                    // Single trapezoid 0002.
                    ax = 0;
                    ay = (cellSizeY * INIT_6);

                    bx = (cellSizeX * INIT_4);
                    by = cellSizeY;

                    cx = (cellSizeX * INIT_6);
                    cy = cellSizeY;

                    dx = 0;
                    dy = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 3:
                    // Single triangle 0010.
                    ax = (cellSizeX * INIT_4);
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 4:
                    // Single rectangle 0011.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = (cellSizeY * INIT_4);

                    dx = 0;
                    dy = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 5:
                    // Single pentagon 0012.
                    ax = 0;
                    ay = (cellSizeY * INIT_6);

                    bx = (cellSizeX * INIT_4);
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY;

                    dx = cellSizeX;
                    dy = (cellSizeY * INIT_4);

                    ex = 0;
                    ey = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 6:
                    // Single trapezoid 0020.
                    ax = (cellSizeX * INIT_4);
                    ay = cellSizeY;

                    bx = (cellSizeX * INIT_6);
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = (cellSizeY * INIT_6);

                    dx = cellSizeX;
                    dy = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 7:
                    // Single pentagon 0021.
                    ax = 0;
                    ay = cellSizeY;

                    bx = (cellSizeX * INIT_6);
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = (cellSizeY * INIT_6);

                    dx = cellSizeX;
                    dy = (cellSizeY * INIT_4);

                    ex = 0;
                    ey = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 8:
                    // Single rectangle 0022.
                    ax = 0;
                    ay = (cellSizeY * INIT_6);

                    bx = cellSizeX;
                    by = (cellSizeY * INIT_6);

                    cx = cellSizeX;
                    cy = (cellSizeY * INIT_4);

                    dx = 0;
                    dy = (cellSizeY * INIT_4);

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 9:
                    // Single triangle 0100.
                    ax = (cellSizeX * INIT_4);
                    ay = 0;

                    bx = cellSizeX;
                    by = (cellSizeY * INIT_6);

                    cx = cellSizeX;
                    cy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 10:
                    // Saddle 0101.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:
                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY;

                            bx = (cellSizeX * INIT_6);
                            by = cellSizeY;

                            cx = 0;
                            cy = (cellSizeY * INIT_4);

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);

                            // Polygon no. 2.
                            ax = (cellSizeX * INIT_4);
                            ay = 0;

                            bx = cellSizeX;
                            by = (cellSizeY * INIT_6);

                            cx = cellSizeX;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);
                            break;
                        case 1:
                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            canvas.drawPath(path,isoColor);
                            break;
                    }

                    break;
                case 11:
                    // Saddle 0102.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:
                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);

                            // Polygon no. 2.
                            ax = cellSizeX * INIT_4;
                            ay = 0;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);
                            break;
                        case 1:
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);
                            break;
                        default:
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);
                            break;
                    }
                    break;
                case 12:
                    // Single rectangle 0110.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 13:
                    // Single pentagon 0111.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 14:
                    // Single hexagon 0112.
                    ax = 0;
                    ay = cellSizeY * INIT_8;

                    bx = cellSizeX * INIT_4;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY;

                    dx = cellSizeX;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_2;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 15:
                    // Single pentagon 0120.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 16:
                    // Single hexagon 0121.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 17:
                    // Single pentagon 0122.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 18:
                    // Single trapezoid 0200.
                    ax = cellSizeX;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_4;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);
                    break;
                case 19:
                    // Saddle 0201.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:
                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = 0;
                            cy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);

                            // Polygon no. 2.
                            ax = cellSizeX;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_4;

                            cx = cellSizeX * INIT_6;
                            cy = 0;

                            dx = cellSizeX * INIT_4;
                            dy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        case 1:
                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = cellSizeX * INIT_4;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);
                            break;
                        default:

                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = cellSizeX * INIT_4;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 20:

                    // Saddle 0202.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);

                            // Polygon no. 2.
                            ax = cellSizeX;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_4;

                            cx = cellSizeX * INIT_6;
                            cy = 0;

                            dx = cellSizeX * INIT_4;
                            dy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        case 1:
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = cellSizeX * INIT_4;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_4;

                            hx = 0;
                            hy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            path.lineTo(hx+positionX, hy+positionY);
                            canvas.drawPath(path,isoColor);

                            break;
                        case 2:
                            // Polygon no. 1.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = cellSizeX * INIT_4;
                            cy = 0;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 21:

                    // Single pentagon 0210.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 22:

                    // Single hexagon 0211.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_8;
                    dy = 0;

                    ex = cellSizeX * INIT_2;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 23:

                    // Saddle 0212.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = cellSizeX * INIT_6;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = cellSizeX * INIT_4;
                            cy = 0;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        default:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = cellSizeX * INIT_6;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 24:

                    // Single rectangle 0220.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 25:

                    // Single pentagon 0221.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 26:

                    // Single trapezoid 0222.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX * INIT_6;
                    by = 0;

                    cx = cellSizeX * INIT_4;
                    cy = 0;

                    dx = 0;
                    dy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 27:

                    // Single triangle 1000.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX * INIT_6;
                    by = 0;

                    cx = 0;
                    cy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 28:

                    // Single rectangle 1001.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 29:

                    // Single pentagon 1002.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 30:

                    // Saddle 1010.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:

                            // Polygon no. 1.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = 0;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = cellSizeX * INIT_6;
                            dy = 0;

                            ex = 0;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 31:

                    // Single pentagon 1011.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 32:

                    // Single hexagon 1012.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 33:

                    // Saddle 1020.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = 0;
                            cy = 0;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = 0;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        default:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = 0;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 34:

                    // Single hexagon 1021.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_8;

                    dx = cellSizeX;
                    dy = cellSizeY * INIT_2;

                    ex = cellSizeX * INIT_6;
                    ey = 0;

                    fx = 0;
                    fy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 35:

                    // Single pentagon 1022.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 36:

                    // Single rectangle 1100.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 37:

                    // Single pentagon 1101.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_4;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 38:

                    // Single hexagon 1102.
                    ax = cellSizeX * INIT_2;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_8;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 39:

                    // Single pentagon 1110.
                    ax = cellSizeX * INIT_6;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 40:

                    // Single square 1111.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 41:

                    // Single pentagon 1112.
                    ax = cellSizeX * INIT_6;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 42:

                    // Single hexagon 1120.
                    ax = cellSizeX * INIT_2;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_8;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 43:

                    // Single pentagon 1121.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_4;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 44:

                    // Single rectangle 1122.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 45:

                    // Single pentagon 1200.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 46:

                    // Single hexagon 1201.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_8;

                    dx = cellSizeX;
                    dy = cellSizeY * INIT_2;

                    ex = cellSizeX * INIT_6;
                    ey = 0;

                    fx = 0;
                    fy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 47:

                    // Saddle 1202.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = 0;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = 0;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        default:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = 0;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 48:

                    // Single hexagon 1210.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 49:

                    // Single pentagon 1211.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    ex = 0;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 50:

                    // Saddle 1212.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = cellSizeX * INIT_6;
                            dy = 0;

                            ex = 0;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = 0;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 51:

                    // Single pentagon 1220.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 52:

                    // Single rectangle 1221.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = 0;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 53:

                    // Single triangle 1222.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX * INIT_6;
                    by = 0;

                    cx = 0;
                    cy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 54:

                    // Single trapezoid 2000.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX * INIT_6;
                    by = 0;

                    cx = cellSizeX * INIT_4;
                    cy = 0;

                    dx = 0;
                    dy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 55:

                    // Single pentagon 2001.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 56:

                    // Single rectangle 2002.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 57:

                    // Saddle 2010.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = cellSizeX * INIT_4;
                            cy = 0;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = cellSizeX * INIT_6;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        default:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = cellSizeX * INIT_6;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 58:

                    // Single hexagon 2011.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_8;
                    dy = 0;

                    ex = cellSizeX * INIT_2;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 59:

                    // Single pentagon 2012.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 60:

                    // Saddle 2020.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 0:

                            // Polygon no. 1.
                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX * INIT_6;
                            by = 0;

                            cx = cellSizeX * INIT_4;
                            cy = 0;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = cellSizeX * INIT_4;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_4;

                            hx = 0;
                            hy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            path.lineTo(hx+positionX, hy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_4;

                            cx = cellSizeX * INIT_6;
                            cy = 0;

                            dx = cellSizeX * INIT_4;
                            dy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 61:

                    // Saddle 2021.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 1:

                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = cellSizeX * INIT_4;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = 0;
                            cy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_4;

                            cx = cellSizeX * INIT_6;
                            cy = 0;

                            dx = cellSizeX * INIT_4;
                            dy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalPath.lineTo(dx+positionX, dy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        default:

                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = cellSizeY * INIT_4;

                            ex = cellSizeX * INIT_6;
                            ey = 0;

                            fx = cellSizeX * INIT_4;
                            fy = 0;

                            gx = 0;
                            gy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 62:

                    // Single trapezoid 2022.
                    ax = cellSizeX;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_4;

                    cx = cellSizeX * INIT_6;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 63:

                    // Single pentagon 2100.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 64:

                    // Single hexagon 2101.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 65:

                    // Single pentagon 2102.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 66:

                    // Single hexagon 2110.
                    ax = 0;
                    ay = cellSizeY * INIT_8;

                    bx = cellSizeX * INIT_4;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY;

                    dx = cellSizeX;
                    dy = 0;

                    ex = cellSizeX * INIT_4;
                    ey = 0;

                    fx = 0;
                    fy = cellSizeY * INIT_2;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    path.lineTo(fx+positionX, fy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 67:

                    // Single pentagon 2111.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = cellSizeX * INIT_6;
                    dy = 0;

                    ex = 0;
                    ey = cellSizeY * INIT_6;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 68:

                    // Single rectangle 2112.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = 0;

                    dx = cellSizeX * INIT_4;
                    dy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 69:

                    // Saddle 2120.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 1:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY * INIT_6;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_4;

                            dx = 0;
                            dy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX * INIT_4;
                            ay = 0;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                        default:

                            ax = cellSizeX * INIT_4;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            gx = 0;
                            gy = cellSizeY * INIT_6;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            path.lineTo(gx+positionX, gy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 70:

                    // Saddle 2121.
                    switch (ternaryIndexOfAverageOfCorners) {
                        case 1:

                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = cellSizeX;
                            cy = cellSizeY * INIT_6;

                            dx = cellSizeX;
                            dy = 0;

                            ex = cellSizeX * INIT_4;
                            ey = 0;

                            fx = 0;
                            fy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            path.lineTo(dx+positionX, dy+positionY);
                            path.lineTo(ex+positionX, ey+positionY);
                            path.lineTo(fx+positionX, fy+positionY);
                            canvas.drawPath(path,isoColor);


                            break;
                        case 2:

                            // Polygon no. 1.
                            ax = 0;
                            ay = cellSizeY;

                            bx = cellSizeX * INIT_6;
                            by = cellSizeY;

                            cx = 0;
                            cy = cellSizeY * INIT_4;

                            path.moveTo(ax+positionX, ay+positionY);
                            path.lineTo(bx+positionX, by+positionY);
                            path.lineTo(cx+positionX, cy+positionY);
                            canvas.drawPath(path,isoColor);


                            // Polygon no. 2.
                            ax = cellSizeX * INIT_4;
                            ay = 0;

                            bx = cellSizeX;
                            by = cellSizeY * INIT_6;

                            cx = cellSizeX;
                            cy = 0;

                            additionalPath.moveTo(ax+positionX, ay+positionY);
                            additionalPath.lineTo(bx+positionX, by+positionY);
                            additionalPath.lineTo(cx+positionX, cy+positionY);
                            additionalCanvas.drawPath(path,isoColor);


                            break;
                    }

                    break;
                case 71:

                    // Single triangle 2122.
                    ax = cellSizeX * INIT_4;
                    ay = 0;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = 0;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 72:

                    // Single rectangle 2200.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX;
                    by = cellSizeY * INIT_6;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = 0;
                    dy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 73:

                    // Single pentagon 2201.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = cellSizeY * INIT_4;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 74:

                    // Single trapezoid 2202.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_6;

                    dx = cellSizeX;
                    dy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 75:

                    // Single pentagon 2210.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX * INIT_4;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY;

                    dx = cellSizeX;
                    dy = cellSizeY * INIT_4;

                    ex = 0;
                    ey = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    path.lineTo(ex+positionX, ey+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 76:

                    // Single rectangle 2211.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    dx = 0;
                    dy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 77:

                    // Single triangle 2212.
                    ax = cellSizeX * INIT_4;
                    ay = cellSizeY;

                    bx = cellSizeX;
                    by = cellSizeY;

                    cx = cellSizeX;
                    cy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 78:

                    // Single trapezoid 2220.
                    ax = 0;
                    ay = cellSizeY * INIT_6;

                    bx = cellSizeX * INIT_4;
                    by = cellSizeY;

                    cx = cellSizeX * INIT_6;
                    cy = cellSizeY;

                    dx = 0;
                    dy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    path.lineTo(dx+positionX, dy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
                case 79:

                    // Single triangle 2221.
                    ax = 0;
                    ay = cellSizeY;

                    bx = cellSizeX * INIT_6;
                    by = cellSizeY;

                    cx = 0;
                    cy = cellSizeY * INIT_4;

                    path.moveTo(ax+positionX, ay+positionY);
                    path.lineTo(bx+positionX, by+positionY);
                    path.lineTo(cx+positionX, cy+positionY);
                    canvas.drawPath(path,isoColor);


                    break;
            }
        }

        public void setTernaryIndexOfAverageOfCorners(int ternaryIndexOfAverageOfCorners) {
            this.ternaryIndexOfAverageOfCorners = ternaryIndexOfAverageOfCorners;
        }

}
