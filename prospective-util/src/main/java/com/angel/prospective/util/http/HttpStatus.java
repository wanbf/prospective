package com.angel.prospective.util.http;

/**
 * Created by wanbf on 2017/11/22.
 */
public interface HttpStatus {

    /**
     * HTTP HttpStatus-Code 200: OK.
     */
    public static final int HTTP_OK = 200;

    /**
     * HTTP HttpStatus-Code 201: Created.
     */
    public static final int HTTP_CREATED = 201;

    /**
     * HTTP HttpStatus-Code 202: Accepted.
     */
    public static final int HTTP_ACCEPTED = 202;

    /**
     * HTTP HttpStatus-Code 203: Non-Authoritative Information.
     */
    public static final int HTTP_NOT_AUTHORITATIVE = 203;

    /**
     * HTTP HttpStatus-Code 204: No Content.
     */
    public static final int HTTP_NO_CONTENT = 204;

    /**
     * HTTP HttpStatus-Code 205: Reset Content.
     */
    public static final int HTTP_RESET = 205;

    /**
     * HTTP HttpStatus-Code 206: Partial Content.
     */
    public static final int HTTP_PARTIAL = 206;

	/* 3XX: relocation/redirect */

    /**
     * HTTP HttpStatus-Code 300: Multiple Choices.
     */
    public static final int HTTP_MULT_CHOICE = 300;

    /**
     * HTTP HttpStatus-Code 301: Moved Permanently.
     */
    public static final int HTTP_MOVED_PERM = 301;

    /**
     * HTTP HttpStatus-Code 302: Temporary Redirect.
     */
    public static final int HTTP_MOVED_TEMP = 302;

    /**
     * HTTP HttpStatus-Code 303: See Other.
     */
    public static final int HTTP_SEE_OTHER = 303;

    /**
     * HTTP HttpStatus-Code 304: Not Modified.
     */
    public static final int HTTP_NOT_MODIFIED = 304;

    /**
     * HTTP HttpStatus-Code 305: Use Proxy.
     */
    public static final int HTTP_USE_PROXY = 305;

	/* 4XX: client error */

    /**
     * HTTP HttpStatus-Code 400: Bad Request.
     */
    public static final int HTTP_BAD_REQUEST = 400;

    /**
     * HTTP HttpStatus-Code 401: Unauthorized.
     */
    public static final int HTTP_UNAUTHORIZED = 401;

    /**
     * HTTP HttpStatus-Code 402: Payment Required.
     */
    public static final int HTTP_PAYMENT_REQUIRED = 402;

    /**
     * HTTP HttpStatus-Code 403: Forbidden.
     */
    public static final int HTTP_FORBIDDEN = 403;

    /**
     * HTTP HttpStatus-Code 404: Not Found.
     */
    public static final int HTTP_NOT_FOUND = 404;

    /**
     * HTTP HttpStatus-Code 405: Method Not Allowed.
     */
    public static final int HTTP_BAD_METHOD = 405;

    /**
     * HTTP HttpStatus-Code 406: Not Acceptable.
     */
    public static final int HTTP_NOT_ACCEPTABLE = 406;

    /**
     * HTTP HttpStatus-Code 407: Proxy Authentication Required.
     */
    public static final int HTTP_PROXY_AUTH = 407;

    /**
     * HTTP HttpStatus-Code 408: Request Time-Out.
     */
    public static final int HTTP_CLIENT_TIMEOUT = 408;

    /**
     * HTTP HttpStatus-Code 409: Conflict.
     */
    public static final int HTTP_CONFLICT = 409;

    /**
     * HTTP HttpStatus-Code 410: Gone.
     */
    public static final int HTTP_GONE = 410;

    /**
     * HTTP HttpStatus-Code 411: Length Required.
     */
    public static final int HTTP_LENGTH_REQUIRED = 411;

    /**
     * HTTP HttpStatus-Code 412: Precondition Failed.
     */
    public static final int HTTP_PRECON_FAILED = 412;

    /**
     * HTTP HttpStatus-Code 413: Request Entity Too Large.
     */
    public static final int HTTP_ENTITY_TOO_LARGE = 413;

    /**
     * HTTP HttpStatus-Code 414: Request-URI Too Large.
     */
    public static final int HTTP_REQ_TOO_LONG = 414;

    /**
     * HTTP HttpStatus-Code 415: Unsupported Media Type.
     */
    public static final int HTTP_UNSUPPORTED_TYPE = 415;

	/* 5XX: server error */

    /**
     * HTTP HttpStatus-Code 500: Internal Server Error.
     *
     * @deprecated it is misplaced and shouldn't have existed.
     */
    @Deprecated
    public static final int HTTP_SERVER_ERROR = 500;

    /**
     * HTTP HttpStatus-Code 500: Internal Server Error.
     */
    public static final int HTTP_INTERNAL_ERROR = 500;

    /**
     * HTTP HttpStatus-Code 501: Not Implemented.
     */
    public static final int HTTP_NOT_IMPLEMENTED = 501;

    /**
     * HTTP HttpStatus-Code 502: Bad Gateway.
     */
    public static final int HTTP_BAD_GATEWAY = 502;

    /**
     * HTTP HttpStatus-Code 503: Service Unavailable.
     */
    public static final int HTTP_UNAVAILABLE = 503;

    /**
     * HTTP HttpStatus-Code 504: Gateway Timeout.
     */
    public static final int HTTP_GATEWAY_TIMEOUT = 504;

    /**
     * HTTP HttpStatus-Code 505: HTTP Version Not Supported.
     */
    public static final int HTTP_VERSION = 505;
}
