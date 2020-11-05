import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i+=5) {
            Place p1 = new Place("[p1]", 1);
            Place p2 = new Place("[p2]", i);
            Place p3 = new Place("[p3]", 0);
            Place p4 = new Place("[p4]", 0);
            Place p5 = new Place("[p5]", 0);

            Transition t1 = new Transition("[t1]");
            Transition t2 = new Transition("[t2]");
            Transition t3 = new Transition("[t3]");
            Transition t4 = new Transition("[t4]");

            Arc a1 = new Arc("[A1]", p1, t1, 1);
            Arc a2 = new Arc("[A2]", p1, 1);
            Arc a3 = new Arc("[A3]", p2, 1);
            Arc a4 = new Arc("[A4]", p2, t2, 1);
            Arc a5 = new Arc("[A5]", p2, t3, 1);
            Arc a6 = new Arc("[A6]", p3, 1);
            Arc a7 = new Arc("[A7]", p4, 1);
            Arc a8 = new Arc("[A8]", p3, t4, 1);
            Arc a9 = new Arc("[A9]", p4, t4, 1);
            Arc a10 = new Arc("[A10]", p5, 1);

            t1.arcsIn.add(a1);
            t1.arcsOut.add(a2);
            t1.arcsOut.add(a3);

            t2.arcsIn.add(a4);
            t2.arcsOut.add(a6);

            t3.arcsIn.add(a5);
            t3.arcsOut.add(a7);

            t4.arcsIn.add(a8);
            t4.arcsIn.add(a9);
            t4.arcsOut.add(a10);

            List<Place> places = Arrays.asList(p1, p2, p3, p4, p5);

            places.forEach(p -> System.out.println("Start number of markers in " + p.name + " : " + p.markersCount));

            List<Transition> transitions = Arrays.asList(t1, t2, t3, t4);
            Model model = new Model(places, transitions);

            model.simulate(100);
        }
    }
}