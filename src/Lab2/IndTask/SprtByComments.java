package Lab2.IndTask;

import Lab2.IndTask.JAXBScheme.TramStation;

import java.util.Comparator;

public class SprtByComments implements Comparator<TramStation.Hour> {
    @Override
    public int compare(TramStation.Hour h1, TramStation.Hour h2){ return h2.getComments().compareTo(h1.getComments());}

}