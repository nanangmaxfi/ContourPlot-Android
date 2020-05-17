package id.web.nanangmaxfi.contourplot;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

public class Contour2DMap {
    private double sizeX;
    private double sizeY;

    private double[][] data;
    private double isoFactor;
    private int interpolationFactor;
    private ColorScale mapColorScale;
    private Bitmap bitmap;

    public Contour2DMap(Bitmap bitmap, double sizeX, double sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.bitmap = bitmap;
    }

    public void draw(ImageView imageView){
        ArrayList<ArrayList<Double>> temporalData = new ArrayList<>();
        BicubicInterpolator bicubicInterpolator = new BicubicInterpolator();

        double minDataValue = findMin(data);
        double maxDataValue = findMax(data);

        for (int i = 0; i < data.length * interpolationFactor; i++) {
            double idx = i * (1.0 / interpolationFactor);
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < data[0].length * interpolationFactor; j++) {
                double jdy = j * (1.0 / interpolationFactor);
                double value = bicubicInterpolator.getValue(data, idx, jdy);

                if (value < minDataValue) {
                    value = minDataValue;
                } else if (value > maxDataValue) {
                    value = maxDataValue;
                }

                row.add(value);
            }
            temporalData.add(row);
        }

        int correction = interpolationFactor - 1;
        double[][] interpolatedData = new double[temporalData.size() - correction][temporalData.get(0).size() - correction];

        for (int i = 0; i < interpolatedData.length; i++) {
            for (int j = 0; j < interpolatedData[i].length; j++) {
                interpolatedData[i][j] = temporalData.get(i).get(j);
            }
        }

        minDataValue = findMin(interpolatedData);
        maxDataValue = findMax(interpolatedData);

        double[] isoValues = arange(minDataValue, maxDataValue, isoFactor);
        ArrayList<Double> arrayListOfIsoValues = new ArrayList<>();

        for (double isoValue : isoValues) {
            arrayListOfIsoValues.add(isoValue);
        }
        arrayListOfIsoValues.add(maxDataValue);

        int numberOfColorIntervals = arrayListOfIsoValues.size() - 1;
        ArrayList<Paint> colorScale = new ArrayList<>();

        switch (mapColorScale) {
            case MONOCHROMATIC:
                ArrayList<Double> brightnessValues = linspace(0, 100, numberOfColorIntervals, true);
                for (int i = 0; i < brightnessValues.size(); i++) {
                    Paint paint = new Paint();
                    paint.setColor((Color.HSVToColor(new float[]{0, 0, (float)(brightnessValues.get(i) / 100)})));
                    paint.setStrokeWidth(5);
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    colorScale.add(paint);
                }
                break;
            case  COLOR:
                ArrayList<Double> hueValues = linspace(0, 250, numberOfColorIntervals, true);
                Collections.reverse(hueValues);
                for (int i = 0; i < hueValues.size(); i++) {
                    Paint paint = new Paint();
                    paint.setColor(Color.HSVToColor(new float[]{hueValues.get(i).floatValue(), 1.0f, 1.0f}));
                    paint.setStrokeWidth(2);
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    colorScale.add(paint);
                }
                break;
        }

        int isoCellsNumberX = interpolatedData[0].length - 1;
        int isoCellsNumberY = interpolatedData.length - 1;

        double isoCellSizeX = sizeX / isoCellsNumberX;
        double isoCellSizeY = sizeY / isoCellsNumberY;

        double isoCellPositionX = 0;
        double isoCellPositionY = 0;

        ArrayList<ArrayList<IsoCell>> matrixOfIsoCells = new ArrayList<>();

        for (int i = 0; i < isoCellsNumberY; i++) {

            ArrayList<IsoCell> oneRowOfIsoCells = new ArrayList<>();

            for (int j = 0; j < isoCellsNumberX; j++) {

                IsoCell isoCell = new IsoCell(bitmap, isoCellSizeX, isoCellSizeY);
                isoCell.setPosition((float)isoCellPositionX, (float)isoCellPositionY);
//                isoCell.setLayoutX(isoCellPositionX);
//                isoCell.setLayoutY(isoCellPositionY);

                //this.getChildren().add(isoCell);

                oneRowOfIsoCells.add(isoCell);

                isoCellPositionX += isoCellSizeX;
            }
            matrixOfIsoCells.add(oneRowOfIsoCells);

            isoCellPositionX = 0;
            isoCellPositionY += isoCellSizeY;
        }

        /*
          Based on: https://en.wikipedia.org/wiki/Marching_squares#Isoband.
          For each isoColor draw polygon in the specific isoCell if ternary index is different than 0 and 80.
         */
        for (int i = 0; i < colorScale.size(); i++) {

            double startOfRange = arrayListOfIsoValues.get(i);
            double endOfRange = arrayListOfIsoValues.get(i + 1);

            for (int j = 0; j < matrixOfIsoCells.size(); j++) {

                ArrayList<IsoCell> isoCellsRow = matrixOfIsoCells.get(j);

                for (int k = 0; k < isoCellsRow.size(); k++) {

                    ArrayList<Integer> ternaryNumber = new ArrayList<>();

                    // Bottom left corner of the iso cell.
                    double average = 0;

                    double decibelThreshold = interpolatedData[j + 1][k];
                    int ternarySingleValue = checkIfValueIsInRange(startOfRange, endOfRange, decibelThreshold);
                    ternaryNumber.add(ternarySingleValue);
                    average += decibelThreshold;

                    // Bottom right corner of the iso cell.
                    decibelThreshold = interpolatedData[j + 1][k + 1];
                    ternarySingleValue = checkIfValueIsInRange(startOfRange, endOfRange, decibelThreshold);
                    ternaryNumber.add(ternarySingleValue);
                    average += decibelThreshold;

                    // Top right corner of the iso cell.
                    decibelThreshold = interpolatedData[j][k + 1];
                    ternarySingleValue = checkIfValueIsInRange(startOfRange, endOfRange, decibelThreshold);
                    ternaryNumber.add(ternarySingleValue);
                    average += decibelThreshold;

                    // Top left corner of the iso cell.
                    decibelThreshold = interpolatedData[j][k];
                    ternarySingleValue = checkIfValueIsInRange(startOfRange, endOfRange, decibelThreshold);
                    ternaryNumber.add(ternarySingleValue);
                    average += decibelThreshold;

                    int ternaryIndex = ternaryToDecimalConverter(ternaryNumber);
                    if (ternaryIndex != 0 && ternaryIndex != 80) {

                        int[] saddleIndices = {10, 11, 19, 20, 23, 30, 33, 47, 50, 57, 60, 61, 69, 70};
                        boolean contains = false;

                        for (int x: saddleIndices) {
                            if (x == ternaryIndex){
                                contains = true;
                                break;
                            }
                        }

                        if (contains) {
                            average /= 4;
                            int ternaryIndexOfAverageOfCorners = checkIfValueIsInRange(startOfRange, endOfRange, average);
                            isoCellsRow.get(k).setTernaryIndexOfAverageOfCorners(ternaryIndexOfAverageOfCorners);
                            isoCellsRow.get(k).drawIsoBand(ternaryIndex, colorScale.get(i));
                        } else {
                            isoCellsRow.get(k).drawIsoBand(ternaryIndex, colorScale.get(i));
                        }
                    }
                }
            }
        }

        imageView.setImageBitmap(bitmap);
    }

    private double findMin(double[][] matrix) {
        double min = matrix[0][0];
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                if (min > aDouble) {
                    min = aDouble;
                }
            }
        }
        return min;
    }

    private double findMax(double[][] matrix) {
        double max = matrix[0][0];
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                if (max < aDouble) {
                    max = aDouble;
                }
            }
        }
        return max;
    }

    private double[] arange(double start, double end, double step) {
        int endLength = (int) ((end - start) / step);
        double[] range = new double[endLength];
        for (int i = 0; i < endLength ; i++){
            range[i] = i * step + start;
        }
        return range;
    }

    private ArrayList<Double> linspace(double start, double stop, int n, boolean roundToInt) {
        ArrayList<Double> result = new ArrayList<>();
        double step = (stop-start)/(n-1);
        for(int i = 0; i <= n-2; i++) {
            if (roundToInt) {
                BigDecimal bd = new BigDecimal(start + (i * step));
                bd = bd.setScale(0, RoundingMode.HALF_UP);
                result.add(bd.doubleValue());
            } else {
                result.add(start + (i * step));
            }
        }
        result.add(stop);
        return result;
    }

    private int checkIfValueIsInRange(double startOfRange, double endOfRange, double value) {
        if (value < startOfRange) {
            return 0;
        } else if (value >= startOfRange && value <= endOfRange) {
            return 1;
        } else {
            return 2;
        }
    }

    private int ternaryToDecimalConverter(ArrayList<Integer> ternaryNumber) {

        int decimalValue = 0;

        for (int i = 0; i < ternaryNumber.size(); i++) {
            if (ternaryNumber.get(i) >= 0 && ternaryNumber.get(i) <= 2) {
                decimalValue += ternaryNumber.get(i) * Math.pow(3, i);
            } else {
                throw new IllegalArgumentException();
            }
        }

        return decimalValue;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public void setIsoFactor(double isoFactor) {
        this.isoFactor = isoFactor;
    }

    public void setInterpolationFactor(int interpolationFactor) {
        this.interpolationFactor = interpolationFactor;
    }

    public void setMapColorScale(ColorScale mapColorScale) {
        this.mapColorScale = mapColorScale;
    }
}
