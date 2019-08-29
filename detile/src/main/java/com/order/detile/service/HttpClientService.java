package com.order.detile.service;

import java.util.List;
import java.util.Map;

public interface HttpClientService {
    List<Map<String , Object>> getHttpClient(String uri);
}
