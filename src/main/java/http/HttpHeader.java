package http;

import http.request.exception.NotFoundHttpRequestHeader;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class HttpHeader {
    private static final String HEADER_SPLITTER = ": ";

    private final Map<String, String> headers;

    private HttpHeader(Map<String, String> headers) {
        this.headers = headers;
    }

    public static HttpHeader of(List<String> headerLines) {
        Map<String, String> headers = headerLines.stream()
                .collect(Collectors.toMap(
                        headerLine -> headerLine.split(HEADER_SPLITTER)[0],
                        headerLine -> headerLine.split(HEADER_SPLITTER)[1]
                ));

        return new HttpHeader(headers);
    }

    public String getHeader(String key) {
        return Optional.ofNullable(headers.get(key))
                .orElseThrow(() -> new NotFoundHttpRequestHeader(key));
    }

    public boolean contains(String key) {
        return headers.containsKey(key);
    }

    public Set<String> getKeySet() {
        return headers.keySet();
    }
}