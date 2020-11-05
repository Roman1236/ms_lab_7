import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Place> places;
    public List<Transition> transitions;
    public List<Transition> nextTransitions = new ArrayList<>();

    public Model(List<Place> places, List<Transition> transitions) {
        this.places = places;
        this.transitions = transitions;
    }

    public void simulate(int iterations) {
        int iterator = 0;

        while (iterator < iterations) {

            printIterNumber(iterator);

            places.forEach(Place::doMarkerStatistic);

            transitions.stream().filter(t -> t.setTransitionPossibility(places)).forEach(t -> nextTransitions.add(t));

            nextTransitions.forEach(t -> t.transitionProbability = 1.0 / nextTransitions.size());

            double r = Math.random();

            for (int i = 0; i < nextTransitions.size(); i++) {
                if (r < nextTransitions.get(i).transitionProbability) {
                    places = nextTransitions.get(i).performTransition(places);
                    break;
                } else
                    r -= nextTransitions.get(i).transitionProbability;
            }
            nextTransitions.clear();
            iterator++;
        }

        printName();
        printStatistics(iterations);
        System.out.println("\n");
    }

    public void printName() {
            System.out.println("VERIFICATION\n");
    }
    public void printIterNumber(int iterator) {
            System.out.println();
            System.out.println("ITERATION " + (iterator + 1));
    }

    public void printStatistics(int iterations) {
        System.out.printf("\n%-26s%-4s%-4s%-10s\n", "name", "min", "max", "average");
        for (Place p : places) {
            p.markersAvarage /= iterations;
            System.out.printf("%-26s%-4d%-4d%-10.3f\n", p.name, p.markersMin, p.markersMax, p.markersAvarage);
        }
    }
}
