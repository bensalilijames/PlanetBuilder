package uk.ac.cam.cl.bravo.PlanetBuilder;

import java.io.*;

public class GlobalOptions implements Serializable {
    private static GlobalOptions go = null;

    private float detailLevel;
    private boolean renderHigh;

    protected GlobalOptions() {
        //Initialise options with defaults
        detailLevel = 50.0f;
        renderHigh = true;
    }

    public static GlobalOptions getInstance() {
        if (go == null) {
            go = new GlobalOptions();
        }
        return go;
    }

    public static GlobalOptions readFromFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        return (GlobalOptions) objIn.readObject();
    }

    //Getters and setters only below

    public float getDetailLevel() {
        return detailLevel;
    }

    public void setDetailLevel(float detailLevel) {
        if (detailLevel >= 0.0f && detailLevel <= 100.0f) {
            this.detailLevel = detailLevel;
        }
    }

    public boolean isRenderHigh() {
        return renderHigh;
    }

    public void setRenderHigh(boolean renderHigh) {
        this.renderHigh = renderHigh;
    }

    public static void writeToFile(GlobalOptions g, String pathname) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(pathname);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(g);
        objectOut.close();
        fileOut.close();
    }

    //Equals and hash code auto generated by IDE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalOptions that = (GlobalOptions) o;

        if (Float.compare(that.detailLevel, detailLevel) != 0) return false;
        if (renderHigh != that.renderHigh) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (detailLevel != +0.0f ? Float.floatToIntBits(detailLevel) : 0);
        result = 31 * result + (renderHigh ? 1 : 0);
        return result;
    }
}
