package org.example._2024_05_03.stock;
/*  С помощью Deque реализуйте ситуацию:
    на путях станции стоит состав из вагонов (без локомотива).
    Станционным локомотивам нужно разобрать состав.
    Один локомотив может брать один вагон с одной стороны состава,
    а другой локомотив – с другой стороны состава.
    У каждого вагона должен быть уникальный номер.*/
public class Main {

    public static void main(String[] args) {
        Vagon vagon1 = new Vagon(1);
        Vagon vagon2 = new Vagon(2);
        Vagon vagon3 = new Vagon(3);
        Vagon vagon4 = new Vagon(4);
        Vagon vagon5 = new Vagon(5);

        RollingStock rollingStock = new RollingStock();
        rollingStock.addLastVagon(vagon1);
        rollingStock.addLastVagon(vagon2);
        rollingStock.addLastVagon(vagon3);
        rollingStock.addLastVagon(vagon4);
        rollingStock.addLastVagon(vagon5);

        Locomotiv locomotiv1 = new Locomotiv(1);
        Locomotiv locomotiv2 = new Locomotiv(2);

        while (!rollingStock.isEmpty()){
            locomotiv1.getFirstVagon(rollingStock);
            if (rollingStock.isEmpty())break;
            locomotiv2.getLarstVagon(rollingStock);
        }



    }

}
