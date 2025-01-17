package com.binance.connector.client.impl.spot;

import com.binance.connector.client.enums.HttpMethod;
import com.binance.connector.client.utils.RequestHandler;

import java.util.LinkedHashMap;

/**
 * <h2>Pay Endpoints</h2>
 * All endpoints under the
 * <a href="https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Pay Endpoint</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned in <i>String format</i>.
 */
public class Pay {
    private final String baseUrl;
    private final RequestHandler requestHandler;
    private final boolean showLimitUsage;

    public Pay(String baseUrl, String apiKey, String secretKey, boolean showLimitUsage) {
        this.baseUrl = baseUrl;
        this.requestHandler = new RequestHandler(apiKey, secretKey);
        this.showLimitUsage = showLimitUsage;
    }

    private final String TRANSACTIONS = "/sapi/v1/pay/transactions";
    /**
     * GET /sapi/v1/pay/transactions
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * startTimestamp -- optional/long <br>
     * endTimestamp -- optional/long <br>
     * limit -- optional/int -- default 100, max 100 <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#get-pay-trade-history-user_data">
     *     https://binance-docs.github.io/apidocs/spot/en/#get-pay-trade-history-user_data</a>
     */
    public String transactions(LinkedHashMap<String,Object> parameters) {
        return requestHandler.sendSignedRequest(baseUrl, TRANSACTIONS, parameters, HttpMethod.GET, showLimitUsage);
    }
}
