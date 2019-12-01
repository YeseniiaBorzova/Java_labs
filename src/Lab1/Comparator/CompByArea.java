package Lab1.Comparator;

import java.util.Comparator;

class CompByArea implements Comparator<Triangle> {
    @Override
    public int compare(Triangle tr1, Triangle tr2){
        return  Double.compare(tr1.getArea(),tr2.getArea());
    }
}
