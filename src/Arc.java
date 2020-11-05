public class Arc {
    public Transition nextTransition ;
    public Place placeFrom;
    public Place placeTo ;
    public int n ;
    public String name ;

    public Arc(String name, Place next, int n)
    {
        this.name = name;
        placeTo = next;
        this.n = n;
    }

    public Arc(String name, Place previousPlace, Transition nextTransition, int n)
    {
        this.name = name;
        this.nextTransition = nextTransition;
        placeFrom = previousPlace;
        this.n = n;
    }


}
