import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Transition {
    public List<Arc> arcsIn = new ArrayList<>();
    public List<Arc> arcsOut = new ArrayList<>();
    public String name = "";
    public double transitionProbability = 0;

    public Transition(String name) {
        this.name = name;
    }

    public boolean setTransitionPossibility(List<Place> places) {
        boolean f = true;
        List<String> fromPositionsNames = arcsIn.stream().map(x -> x.placeFrom.name).collect(Collectors.toList());

        List<Place> connectedPlaces = places.stream().filter(x -> fromPositionsNames.contains(x.name)).collect(Collectors.toList());
        for (int i = 0; i < connectedPlaces.size(); i++) {
            if (connectedPlaces.get(i).markersCount < arcsIn.get(i).n) {
                f = false;
                break;
            }
        }
        return f;
    }

    public List<Place> performTransition(List<Place> places) {
            System.out.println("\nTransition " + name + " :");
            System.out.print("Takes markers from: ");

        for (Arc a : arcsIn) {
            places.stream().filter(x -> x.name.equals(a.placeFrom.name)).collect(Collectors.toList()).get(0).markersCount -= a.n;
                System.out.print(a.placeFrom.name + "\n");
        }

            System.out.print("Sends markers to: ");

        for (Arc a : arcsOut) {
            places.stream().filter(x -> x.name.equals(a.placeTo.name)).collect(Collectors.toList()).get(0).markersCount += a.n;
                System.out.print(a.placeTo.name +"\n");
        }

            System.out.println();

        return places;
    }
}
