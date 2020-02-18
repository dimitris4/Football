public class Player {

    private static int count;
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Player() {}

    public Player(String firstName, String lastName, int age) {
        setId(++count);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() { return id; }


    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) { this.id = id; }


    //override the compareTo method
    public int compareTo(Player otherPlayer) {
        //compare name
        int ageDiff = age - otherPlayer.age;
        if(ageDiff != 0){
            return ageDiff;
        }
        //names are equals compare age
        return lastName.compareToIgnoreCase(otherPlayer.lastName);
    }


    public String toString() {
        return  String.format("%-10d%-15s%-22s%-2d", id, firstName, lastName, age);
    }


    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Player)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Player p = (Player) o;

        // Compare the data members and return accordingly
        return this.id == p.id;
    }
}

