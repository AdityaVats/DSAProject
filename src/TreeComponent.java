public class TreeComponent {

    String id;
    String pid;
    String title;

    public TreeComponent() {
    }

    public TreeComponent(String id, String pid, String title) {
        this.id = id;
        this.pid = pid;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

