package fine.koacaiia.androidysk;

public class RecyclerList {
    String name;
    String contents;

    public RecyclerList(){

    }

    public RecyclerList(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
