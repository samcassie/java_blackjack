public enum RankType {

    ACE("ace",1),
    TWO("two", 2),
    THREE("three",3),
    FOUR("four",4),
    FIVE("five",5),
    SIX("six",6),
    SEVEN("seven",7),
    EIGHT("eight",8),
    NINE("nine",9),
    TEN("ten",10),
    JACK("jack",10),
    QUEEN("queen",10),
    KING("king",10);

    private final int value;
    private final String name;

    RankType(String name, int value){

        this.name = name;
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public String getName() {
        return name;
    }
}
