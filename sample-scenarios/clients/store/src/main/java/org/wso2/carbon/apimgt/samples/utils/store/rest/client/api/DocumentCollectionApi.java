/*
 * WSO2 API Manager - Store
 * This specifies a **RESTful API** for WSO2 **API Manager** - Store.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.1.66/components/apimgt/org.wso2.carbon.apimgt.rest.api.store/src/main/resources/store-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: 0.11.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.carbon.apimgt.samples.utils.store.rest.client.api;

import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ApiCallback;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ApiClient;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ApiResponse;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.Configuration;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.Pair;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ProgressRequestBody;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.DocumentList;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.Error;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentCollectionApi {
    private ApiClient apiClient;

    public DocumentCollectionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DocumentCollectionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for apisApiIdDocumentsGet */
    private com.squareup.okhttp.Call apisApiIdDocumentsGetCall(String apiId, Integer limit, Integer offset, String xWSO2Tenant, String accept, String ifNoneMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/apis/{apiId}/documents".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "apiId" + "\\}", apiClient.escapeString(apiId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xWSO2Tenant != null)
        localVarHeaderParams.put("X-WSO2-Tenant", apiClient.parameterToString(xWSO2Tenant));
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apisApiIdDocumentsGetValidateBeforeCall(String apiId, Integer limit, Integer offset, String xWSO2Tenant, String accept, String ifNoneMatch, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiId' is set
        if (apiId == null) {
            throw new ApiException("Missing the required parameter 'apiId' when calling apisApiIdDocumentsGet(Async)");
        }
        
        
        com.squareup.okhttp.Call call = apisApiIdDocumentsGetCall(apiId, limit, offset, xWSO2Tenant, accept, ifNoneMatch, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a list of documents of an API 
     * This operation can be used to retrive a list of documents belonging to an API by providing the id of the API.  &#x60;X-WSO2-Tenant&#x60; header can be used to retrive documents of an API that belongs to a different tenant domain. If not specified super tenant will be used. If Authorization header is present in the request, the user&#39;s tenant associated with the access token will be used.  **NOTE:** * This operation does not require an Authorization header by default. But in order to see a restricted API&#39;s documents, you need to provide Authorization header. 
     * @param apiId **API ID** consisting of the **UUID** of the API. Using the **UUID** in the API call is recommended. The combination of the provider of the API, name of the API and the version is also accepted as a valid API ID. Should be formatted as **provider-name-version**.  (required)
     * @param limit Maximum size of resource array to return.  (optional, default to 25)
     * @param offset Starting point within the complete list of items qualified.  (optional, default to 0)
     * @param xWSO2Tenant For cross-tenant invocations, this is used to specify the tenant domain, where the resource need to be   retirieved from.  (optional)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to application/json)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @return DocumentList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DocumentList apisApiIdDocumentsGet(String apiId, Integer limit, Integer offset, String xWSO2Tenant, String accept, String ifNoneMatch) throws ApiException {
        ApiResponse<DocumentList> resp = apisApiIdDocumentsGetWithHttpInfo(apiId, limit, offset, xWSO2Tenant, accept, ifNoneMatch);
        return resp.getData();
    }

    /**
     * Get a list of documents of an API 
     * This operation can be used to retrive a list of documents belonging to an API by providing the id of the API.  &#x60;X-WSO2-Tenant&#x60; header can be used to retrive documents of an API that belongs to a different tenant domain. If not specified super tenant will be used. If Authorization header is present in the request, the user&#39;s tenant associated with the access token will be used.  **NOTE:** * This operation does not require an Authorization header by default. But in order to see a restricted API&#39;s documents, you need to provide Authorization header. 
     * @param apiId **API ID** consisting of the **UUID** of the API. Using the **UUID** in the API call is recommended. The combination of the provider of the API, name of the API and the version is also accepted as a valid API ID. Should be formatted as **provider-name-version**.  (required)
     * @param limit Maximum size of resource array to return.  (optional, default to 25)
     * @param offset Starting point within the complete list of items qualified.  (optional, default to 0)
     * @param xWSO2Tenant For cross-tenant invocations, this is used to specify the tenant domain, where the resource need to be   retirieved from.  (optional)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to application/json)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @return ApiResponse&lt;DocumentList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DocumentList> apisApiIdDocumentsGetWithHttpInfo(String apiId, Integer limit, Integer offset, String xWSO2Tenant, String accept, String ifNoneMatch) throws ApiException {
        com.squareup.okhttp.Call call = apisApiIdDocumentsGetValidateBeforeCall(apiId, limit, offset, xWSO2Tenant, accept, ifNoneMatch, null, null);
        Type localVarReturnType = new TypeToken<DocumentList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of documents of an API  (asynchronously)
     * This operation can be used to retrive a list of documents belonging to an API by providing the id of the API.  &#x60;X-WSO2-Tenant&#x60; header can be used to retrive documents of an API that belongs to a different tenant domain. If not specified super tenant will be used. If Authorization header is present in the request, the user&#39;s tenant associated with the access token will be used.  **NOTE:** * This operation does not require an Authorization header by default. But in order to see a restricted API&#39;s documents, you need to provide Authorization header. 
     * @param apiId **API ID** consisting of the **UUID** of the API. Using the **UUID** in the API call is recommended. The combination of the provider of the API, name of the API and the version is also accepted as a valid API ID. Should be formatted as **provider-name-version**.  (required)
     * @param limit Maximum size of resource array to return.  (optional, default to 25)
     * @param offset Starting point within the complete list of items qualified.  (optional, default to 0)
     * @param xWSO2Tenant For cross-tenant invocations, this is used to specify the tenant domain, where the resource need to be   retirieved from.  (optional)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to application/json)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apisApiIdDocumentsGetAsync(String apiId, Integer limit, Integer offset, String xWSO2Tenant, String accept, String ifNoneMatch, final ApiCallback<DocumentList> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apisApiIdDocumentsGetValidateBeforeCall(apiId, limit, offset, xWSO2Tenant, accept, ifNoneMatch, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DocumentList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
