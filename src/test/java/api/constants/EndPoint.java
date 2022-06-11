package api.constants;

public enum EndPoint {

    COMMENTS("/api/postservice/posts/72317180/comments");

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
