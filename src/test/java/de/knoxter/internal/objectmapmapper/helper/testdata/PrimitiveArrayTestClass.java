package de.knoxter.internal.objectmapmapper.helper.testdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PrimitiveArrayTestClass {
    private byte[] primByteArray;
    private short[] primShortArray;
    private int[] primIntArray;
    private long[] primLongArray;
    private float[] primFloatArray;
    private double[] primDoubleArray;

    public static PrimitiveArrayTestClass empty() {
        return new PrimitiveArrayTestClass();
    }

    public static PrimitiveArrayTestClass filled() {
        PrimitiveArrayTestClass obj = new PrimitiveArrayTestClass();
        obj.primByteArray = new byte[]{ 10, 11, 12 };
        obj.primShortArray = new short[]{ 20, 21, 22 };
        obj.primIntArray = new int[]{ 30, 31, 32 };
        obj.primLongArray = new long[]{ 40, 41, 42 };
        obj.primFloatArray = new float[]{ 50.5f, 51.51f, 52.52f };
        obj.primDoubleArray = new double[]{ 60.6, 61.61, 62.62 };
        return obj;
    }
}
