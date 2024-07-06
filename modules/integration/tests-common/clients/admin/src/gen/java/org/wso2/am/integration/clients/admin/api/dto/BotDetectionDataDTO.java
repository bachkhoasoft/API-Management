/*
 * WSO2 API Manager - Admin
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Admin Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.admin.v1/src/main/resources/admin-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the the API you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_admin\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown bellow to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_admin\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_admin\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for Admin REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorizations** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_passowrd>&scope=<scopes seperated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:admin apim:tier_view\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:admin apim:tier_view\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/f5ac2ca9fb22afef6ed6) 
 *
 * The version of the OpenAPI document: v4
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.admin.api.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* BotDetectionDataDTO
*/

public class BotDetectionDataDTO {
        public static final String SERIALIZED_NAME_RECORDED_TIME = "recordedTime";
        @SerializedName(SERIALIZED_NAME_RECORDED_TIME)
            private Long recordedTime;

        public static final String SERIALIZED_NAME_MESSAGE_I_D = "messageID";
        @SerializedName(SERIALIZED_NAME_MESSAGE_I_D)
            private String messageID;

        public static final String SERIALIZED_NAME_API_METHOD = "apiMethod";
        @SerializedName(SERIALIZED_NAME_API_METHOD)
            private String apiMethod;

        public static final String SERIALIZED_NAME_HEADER_SET = "headerSet";
        @SerializedName(SERIALIZED_NAME_HEADER_SET)
            private String headerSet;

        public static final String SERIALIZED_NAME_MESSAGE_BODY = "messageBody";
        @SerializedName(SERIALIZED_NAME_MESSAGE_BODY)
            private String messageBody;

        public static final String SERIALIZED_NAME_CLIENT_IP = "clientIp";
        @SerializedName(SERIALIZED_NAME_CLIENT_IP)
            private String clientIp;


        public BotDetectionDataDTO recordedTime(Long recordedTime) {
        
        this.recordedTime = recordedTime;
        return this;
        }

    /**
        * The time of detection
    * @return recordedTime
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "1591734138413", value = "The time of detection")
    
    public Long getRecordedTime() {
        return recordedTime;
    }


    public void setRecordedTime(Long recordedTime) {
        this.recordedTime = recordedTime;
    }


        public BotDetectionDataDTO messageID(String messageID) {
        
        this.messageID = messageID;
        return this;
        }

    /**
        * The message ID
    * @return messageID
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "urn:uuid:1ed6d2de-29df-4fed-a96a-46d2329dce65", value = "The message ID")
    
    public String getMessageID() {
        return messageID;
    }


    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }


        public BotDetectionDataDTO apiMethod(String apiMethod) {
        
        this.apiMethod = apiMethod;
        return this;
        }

    /**
        * The api method
    * @return apiMethod
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "GET", value = "The api method")
    
    public String getApiMethod() {
        return apiMethod;
    }


    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }


        public BotDetectionDataDTO headerSet(String headerSet) {
        
        this.headerSet = headerSet;
        return this;
        }

    /**
        * The header set
    * @return headerSet
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[Accept=*_/_*, Host=localhost:8243, User-Agent=curl/7.58.0]", value = "The header set")
    
    public String getHeaderSet() {
        return headerSet;
    }


    public void setHeaderSet(String headerSet) {
        this.headerSet = headerSet;
    }


        public BotDetectionDataDTO messageBody(String messageBody) {
        
        this.messageBody = messageBody;
        return this;
        }

    /**
        * The content of the message body
    * @return messageBody
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "<soapenv:Body xmlns:soapenv=\\\"http://www.w3.org/2003/05/soap-envelope\\\"/>", value = "The content of the message body")
    
    public String getMessageBody() {
        return messageBody;
    }


    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }


        public BotDetectionDataDTO clientIp(String clientIp) {
        
        this.clientIp = clientIp;
        return this;
        }

    /**
        * The IP of the client
    * @return clientIp
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "127.0.0.1", value = "The IP of the client")
    
    public String getClientIp() {
        return clientIp;
    }


    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            BotDetectionDataDTO botDetectionData = (BotDetectionDataDTO) o;
            return Objects.equals(this.recordedTime, botDetectionData.recordedTime) &&
            Objects.equals(this.messageID, botDetectionData.messageID) &&
            Objects.equals(this.apiMethod, botDetectionData.apiMethod) &&
            Objects.equals(this.headerSet, botDetectionData.headerSet) &&
            Objects.equals(this.messageBody, botDetectionData.messageBody) &&
            Objects.equals(this.clientIp, botDetectionData.clientIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordedTime, messageID, apiMethod, headerSet, messageBody, clientIp);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class BotDetectionDataDTO {\n");
    sb.append("    recordedTime: ").append(toIndentedString(recordedTime)).append("\n");
    sb.append("    messageID: ").append(toIndentedString(messageID)).append("\n");
    sb.append("    apiMethod: ").append(toIndentedString(apiMethod)).append("\n");
    sb.append("    headerSet: ").append(toIndentedString(headerSet)).append("\n");
    sb.append("    messageBody: ").append(toIndentedString(messageBody)).append("\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

