package http;

import java.util.Objects;

public class HttpBody {
    private final String body;

    private HttpBody(String body) {
        this.body = body;
    }

    public static HttpBody of(String body) {
        return new HttpBody(body);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpBody httpBody = (HttpBody) o;
        return Objects.equals(body, httpBody.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public String toString() {
        return "HttpBody{" +
                "body='" + body + '\'' +
                '}';
    }
}
