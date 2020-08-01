package unc.live.d42n81.machinelearningtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;

import java.io.File;
import java.util.ArrayList;

import libsvm.GridSearch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double[] t = new double[]{};

        double [] temp = new double[] {170.0, 137.0};

        Instance instance1 = new DenseInstance(temp, "bear");
        // An instance is a row. A dense instance is a row where every cell has data. A sparse
        // instance would be missing some cells.
        ArrayList<String> aL = new ArrayList<>();
        aL.add("bear");

        Instance instance2 = new DenseInstance(temp, aL.get(0));
        temp = new double[] {127, 2200};
        Instance instance3 = new DenseInstance(temp, "buffalo");
        Instance instance4 = new DenseInstance(temp, "buffalo");
        temp = new double[] {110, 200};
        Instance instance5 = new DenseInstance(temp);

        Instance[] instances = new Instance[3];
        double[] temp2 = new double[3];
        double test = 10/3;
        ArrayList<Instance> instanceArrayList = new ArrayList<>();
        instanceArrayList.add(instance1);
        instances = (Instance[]) instanceArrayList.toArray();
        instanceArrayList.clear();

        Dataset data = new DefaultDataset();
        data.add(instance1);
        // These adds the row of data to the data set.
        data.add(instance2);
        data.add(instance3);
        data.add(instance4);



        Classifier knn = new KNearestNeighbors(3);
        // Usually use an odd number of neighbors, so you can never have a tie for classification.
        knn.buildClassifier(data);
        // This is a magic box that finds an algorithm from the data set fed into the classifier.

        Log.v("MyTag", "" + knn.classify(instance5));

        // Classify whether human is standing, walking, or running depending on accelerometer values.
        // Make x the variance, make y standing, walking, or running.
        // Use KNearest Neighbors. Use square root of number of data points as K number of neighbors.
        ArrayList<String> Name, Company = new ArrayList<>();
    }
}
